package com.siweisoft.heavycenter.module.main.trans.strans;

//by summer on 2018-03-14.

import android.content.Context;
import android.os.Bundle;

import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.LoadUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.trans.trans.TransRes;

public class StransFrag extends AppFrag<StransUIOpe,StransDAOpe> implements OnRefreshListener{

    public static StransFrag getInstance(int orderid,int signstatus,String orderno){
        StransFrag stransFrag = new StransFrag();
        stransFrag.setArguments(new Bundle());
        stransFrag.getArguments().putInt(ValueConstant.DATA_DATA,orderid);
        stransFrag.getArguments().putInt(ValueConstant.DATA_TYPE,signstatus);
        stransFrag.getArguments().putString(ValueConstant.DATA_DATA2,orderno);
        return stransFrag;
    }

    @Override
    public void initNow() {
        super.initNow();
        getDE().getStransReq().setOrdersId(getArguments().getInt(ValueConstant.DATA_DATA,0));
        getDE().getStransReq().setSignStatus(getArguments().getInt(ValueConstant.DATA_TYPE,0));
        getDE().getStransReq().setPageSize(1000);
        getDE().getStransReq().setPageIndex(1);
    }

    @Override
    public void initdelay() {
        super.initdelay();
        getUI().autoRefresh();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        StransDAOpe.stranss(getContext(), getDE().getStransReq(), new UINetAdapter<TransRes>(this, UINetAdapter.Loading) {
            @Override
            public void onSuccess(TransRes o) {
                super.onSuccess(o);
                getDE().addData(o);
                getUI().LoadListData(getDE().getData());
            }
        });
    }
}
