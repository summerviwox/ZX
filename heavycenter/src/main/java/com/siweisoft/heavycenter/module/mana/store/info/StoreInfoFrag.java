package com.siweisoft.heavycenter.module.mana.store.info;

import android.view.View;

import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.mana.store.add.NewStoreResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoreDetail;
import com.siweisoft.heavycenter.data.netd.mana.store.update.UpdateStoreRes;

import butterknife.OnClick;

/**
 * Created by summer on 2018/1/31 0:12.
 */

public class StoreInfoFrag extends AppFrag<StoreInfoUIOpe,StoreInfoDAOpe>{

    @Override
    public void initNow() {
        super.initNow();
        switch (getArguments().getString(StoreInfoValue.仓库类型)){
            case StoreInfoValue.修改仓库:
                getP().getD().setStoreDetail((StoreDetail) getArguments().getSerializable(ValueConstant.DATA_DATA));
                getP().getU().initUI(getP().getD().getStoreDetail());
                break;
            case StoreInfoValue.新建仓库:

                break;
        }
    }


    @OnClick({R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ftv_right2:
                switch (getArguments().getString(StoreInfoValue.仓库类型)){
                    case StoreInfoValue.修改仓库:
                        if(getP().getU().canGo()){
                            getP().getD().update(getP().getU().getUpdateStoreReq(getP().getD().getUpdateStoreReq(getP().getD().getStoreDetail())), new UINetAdapter<UpdateStoreRes>(this) {
                                @Override
                                public void onSuccess(UpdateStoreRes o) {
                                    getArguments().putBoolean(ValueConstant.FARG_TYPE,true);
                                    getBaseAct().onBackPressed();
                                }
                            });
                        }
                        break;
                    case StoreInfoValue.新建仓库:
                        if(getP().getU().canGo()){
                            getP().getD().newStore(getP().getU().getNewStoreReqBean(getP().getD().getNewStoreReqBean()), new UINetAdapter<NewStoreResBean>(this) {
                                @Override
                                public void onSuccess(NewStoreResBean o) {
                                    getArguments().putBoolean(ValueConstant.FARG_TYPE,true);
                                    getBaseUIAct().onBackPressed();
                                }
                            });
                        }
                        break;
                }
                break;
        }
    }
}
