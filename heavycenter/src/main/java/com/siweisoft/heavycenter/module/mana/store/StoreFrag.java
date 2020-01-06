package com.siweisoft.heavycenter.module.mana.store;

//by summer on 2017-12-14.

import android.os.Bundle;
import android.view.View;

import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.fragment.two.FragManager2;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.Test;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoreDetail;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoresResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.status.StatusStoresResBean;
import com.siweisoft.heavycenter.module.mana.store.info.StoreInfoFrag;
import com.siweisoft.heavycenter.module.mana.store.info.StoreInfoValue;

import butterknife.OnClick;

public class StoreFrag extends AppFrag<StoreUIOpe,StoreDAOpe> implements ViewListener,OnRefreshListener,OnLoadmoreListener{

    public static final int 选择一个仓库=1;

    @Override
    public void initdelay() {
        super.initdelay();
        getP().getU().setSwipe(getArguments().getInt(ValueConstant.DATA_POSITION2,-1)==选择一个仓库?false:true);
        getP().getU().initRefresh(this,this);
        getP().getU().initRecycle();
        onRefresh(null);

    }


    @OnClick({R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ftv_right2:
                Bundle bundle = new Bundle();
                bundle.putInt(ValueConstant.FARG_REQ,1);
                bundle.putString(StoreInfoValue.仓库类型,StoreInfoValue.新建仓库);
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),new StoreInfoFrag(),bundle);
                break;
        }
    }


    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:
               switch (v.getId()){
                   case R.id.smMenuViewRight:
                       final StoreDetail data  = (StoreDetail) v.getTag(R.id.data);
                       getP().getD().statusStore(getP().getU().getStatusStoresReqBean(getP().getD().getStatusStoresReqBean(),data.getWarehouseId(),data.getStatus()), new UINetAdapter<StatusStoresResBean>(this) {
                           @Override
                           public void onSuccess(StatusStoresResBean o) {
                               data.setStatus(1-data.getStatus());
                               getP().getU().notifyDataSetChanged();
                           }
                       });
                       break;
                       default:
                           if(getArguments().getInt(ValueConstant.DATA_POSITION2,-1)==选择一个仓库){
                               StoreDetail d = (StoreDetail) v.getTag(R.id.data);
                               getArguments().putSerializable(ValueConstant.DATA_DATA2,d);
                               getBaseUIAct().onBackPressed();
                               return;
                           }
                           StoreDetail storeDetail = (StoreDetail) v.getTag(R.id.data);
                           Bundle bundle = new Bundle();
                           bundle.putSerializable(ValueConstant.DATA_DATA,storeDetail);
                           bundle.putInt(ValueConstant.FARG_REQ,2);
                           bundle.putString(StoreInfoValue.仓库类型,StoreInfoValue.修改仓库);
                           FragManager2.getInstance().start(getBaseUIAct(), get容器(),new StoreInfoFrag(),bundle);
                           break;
               }
                break;
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        getP().getU().finishLoadmore();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        getP().getD().storesInfo(getArguments().getInt(ValueConstant.DATA_POSITION2,-1)==选择一个仓库,new UINetAdapter<StoresResBean>(this) {
            @Override
            public void onSuccess(StoresResBean o) {
                //o = new Test().getStoresResBean();
                getP().getU().finishRefresh();
                getP().getU().LoadListData(o,StoreFrag.this);
            }
        });
    }

    @Override
    public void onResult(int res, Bundle bundle) {
        super.onResult(res, bundle);
        switch (res){
            case 1:
                if(bundle==null|| !bundle.getBoolean(ValueConstant.FARG_TYPE,false)){
                    return;
                }
                if(bundle.getBoolean(ValueConstant.FARG_TYPE,false)){
                    getP().getU().autoRefresh(600);
                }
                break;
            case 2:
                if(bundle==null|| !bundle.getBoolean(ValueConstant.FARG_TYPE,false)){
                    return;
                }
                getP().getU().autoRefresh(600);
                break;
        }
    }
}
