package com.siweisoft.heavycenter.module.main.store;

//by summer on 2017-12-11.

import android.content.Context;

import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoresReqBean;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoresResBean;

import java.util.ArrayList;

public class StoreDAOpe extends BaseDAOpe {

    private int pageIndex = NetValue.PAGE_INDEX_START;

    private StoresResBean storesResBean = new StoresResBean();

    private int comid =LocalValue.get登录返回信息().getCompanyId() ;



    public void storesInfo(NetI<StoresResBean> adapter){
        StoresReqBean reqBean = new StoresReqBean();
        reqBean.setCompanyId(comid);
        reqBean.setIsApp(1);
        reqBean.setPageIndex(getPageIndex());
        reqBean.setPageSize(20);
        NetDataOpe.Mana.Store.sotresInfo(getActivity(),reqBean,adapter);
    }

    public StoresResBean getStoresResBean() {
        return storesResBean;
    }

    public void addData(StoresResBean data){
        if(data!=null&&data.getResults()!=null){
            storesResBean.getResults().addAll(data.getResults());
        }
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }
}
