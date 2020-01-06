package com.siweisoft.heavycenter.module.main.store.check;

//by summer on 2017-12-19.

import android.os.Bundle;
import android.view.View;

import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.mana.store.check.CheckStoreResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoreDetail;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoresResBean;

import butterknife.OnClick;

public class CheckFrag extends AppFrag<CheckUIOpe,CheckDAOpe> {


    public static CheckFrag getInstance(String type,int id){
        CheckFrag checkFrag = new CheckFrag();
        checkFrag.setArguments(new Bundle());
        checkFrag.getArguments().putString(ValueConstant.DATA_TYPE,type);
        checkFrag.getArguments().putInt(ValueConstant.DATA_DATA,id);
        return checkFrag;
    }

    @Override
    public void initdelay() {
        super.initdelay();
        getP().getU().initRecycle();
        switch (getArguments().getString(ValueConstant.DATA_TYPE)){
            case CheckValue.盘点一个仓库:
                CheckDAOpe.storesDetail(getActivity(), getArguments().getInt(ValueConstant.DATA_DATA), new UINetAdapter<StoreDetail>(getActivity()) {
                    @Override
                    public void onSuccess(StoreDetail o) {
                        super.onSuccess(o);
                        StoresResBean storesResBean = new StoresResBean();
                        storesResBean.getResults().add(o);

                        getP().getD().setStoresResBean(storesResBean);
                        getP().getU().LoadListData(getP().getD().getStoresResBean());
                        getP().getD().setInitdata(true);
                    }
                });
                break;
            case CheckValue.盘点所有仓库:
                getP().getD().storesInfo(new UINetAdapter<StoresResBean>(getBaseUIAct()) {
                    @Override
                    public void onSuccess(StoresResBean o) {
                        getP().getD().setStoresResBean(o);
                        getP().getU().LoadListData(getP().getD().getStoresResBean());
                        getP().getD().setInitdata(true);
                    }
                });
                break;
        }
    }

    @OnClick({R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ftv_right2:
                if(getP().getD().canGo()){
                    if(!getP().getD().changedData()){
                        ToastUtil.getInstance().showShort(getActivity(),"库存没有变化，取消盘点");
                        getBaseUIAct().onBackPressed();
                        return;
                    }
                    getP().getD().checkStore(getP().getD().getCheckStoreReqBean(getP().getD().getStoresResBean()), new UINetAdapter<CheckStoreResBean>(this,true) {
                        @Override
                        public void onResult(boolean success, String msg, CheckStoreResBean o) {
                            super.onResult(success, msg, o);
                            if(success){
                                getArguments().putBoolean(ValueConstant.FRAG_KEY,true);
                                getBaseUIAct().onBackPressed();
                            }
                        }
                    });
                }
                break;
        }
    }
}
