package com.siweisoft.heavycenter.module.mana.store;

//by summer on 2017-12-14.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoresReqBean;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoresResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.status.StatusStoresReqBean;
import com.siweisoft.heavycenter.data.netd.mana.store.status.StatusStoresResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.update.UpdateStoreReq;
import com.siweisoft.heavycenter.data.netd.mana.store.update.UpdateStoreRes;

import java.util.ArrayList;

public class StoreDAOpe extends AppDAOpe {

    private StatusStoresReqBean statusStoresReqBean = new StatusStoresReqBean();


    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        for(int i=0;i<100;i++){
            data.add(""+i);
        }
        return data;
    }

    public void storesInfo(boolean sel,NetI<StoresResBean> adapter){
        StoresReqBean reqBean = new StoresReqBean();
        reqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        reqBean.setIsApp(1);
        if(sel){
            reqBean.setStatus(StoresReqBean.STATUS_ON);
            reqBean.setIsEmpty(1);
        }else{

        }
        reqBean.setPageIndex(0);
        reqBean.setPageSize(1000);
       // reqBean.setStatus(StoresReqBean.STATUS_ALL);
        NetDataOpe.Mana.Store.sotresInfo(getActivity(),reqBean,adapter);
    }

    public void statusStore(StatusStoresReqBean statusStoresReqBean, NetI<StatusStoresResBean> adapter){
        NetDataOpe.Mana.Store.statusStore(getActivity(),statusStoresReqBean,adapter);
    }




    public StatusStoresReqBean getStatusStoresReqBean() {
        return statusStoresReqBean;
    }

}
