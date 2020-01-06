package com.siweisoft.heavycenter.module.mana.store.info;

import android.content.Context;
import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.mana.store.add.NewStoreReqBean;
import com.siweisoft.heavycenter.data.netd.mana.store.add.NewStoreResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoreDetail;
import com.siweisoft.heavycenter.data.netd.mana.store.update.UpdateStoreReq;
import com.siweisoft.heavycenter.data.netd.mana.store.update.UpdateStoreRes;

/**
 * Created by summer on 2018/1/31 0:12.
 */

public class StoreInfoDAOpe extends BaseDAOpe {

    private StoreDetail storeDetail ;

    UpdateStoreReq updateStoreReq = new UpdateStoreReq();


    private NewStoreReqBean newStoreReqBean = new NewStoreReqBean();

    public StoreDetail getStoreDetail() {
        return storeDetail;
    }

    public void setStoreDetail(StoreDetail storeDetail) {
        this.storeDetail = storeDetail;
    }


    public void update(UpdateStoreReq updateStoreReq, NetI<UpdateStoreRes> adapter){
        NetDataOpe.Mana.Store.update(getActivity(),updateStoreReq,adapter);
    }


    public UpdateStoreReq getUpdateStoreReq(StoreDetail storeDetail) {
        updateStoreReq.setId(storeDetail.getWarehouseId());
        updateStoreReq.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        return updateStoreReq;
    }


    public void newStore(NewStoreReqBean newStoreReqBean, NetI<NewStoreResBean> adapter){
        NetDataOpe.Mana.Store.newStore(getActivity(),newStoreReqBean,adapter);
    }

    public NewStoreReqBean getNewStoreReqBean() {
        newStoreReqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        return newStoreReqBean;
    }
}
