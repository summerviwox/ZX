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
        getP().getD().getStransReq().setOrdersId(getArguments().getInt(ValueConstant.DATA_DATA,0));
        getP().getD().getStransReq().setSignStatus(getArguments().getInt(ValueConstant.DATA_TYPE,0));
        getP().getD().getStransReq().setPageSize(1000);
        getP().getD().getStransReq().setPageIndex(1);
    }

    @Override
    public void initdelay() {
        super.initdelay();
        getP().getU().autoRefresh();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        StransDAOpe.stranss(getContext(), getP().getD().getStransReq(), new UINetAdapter<TransRes>(this, UINetAdapter.Loading) {
            @Override
            public void onSuccess(TransRes o) {
                super.onSuccess(o);
                getP().getD().addData(o);
                getP().getU().LoadListData(getP().getD().getData());
            }
        });
    }
}
