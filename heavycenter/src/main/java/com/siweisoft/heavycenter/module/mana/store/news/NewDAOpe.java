package com.siweisoft.heavycenter.module.mana.store.news;

//by summer on 2017-12-14.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.mana.store.add.NewStoreReqBean;
import com.siweisoft.heavycenter.data.netd.mana.store.add.NewStoreResBean;

public class NewDAOpe extends AppDAOpe {

    private NewStoreReqBean newStoreReqBean = new NewStoreReqBean();



    public void newStore(NewStoreReqBean newStoreReqBean, NetI<NewStoreResBean> adapter){
        NetDataOpe.Mana.Store.newStore(getActivity(),newStoreReqBean,adapter);
    }

    public NewStoreReqBean getNewStoreReqBean() {
        newStoreReqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        return newStoreReqBean;
    }
}
