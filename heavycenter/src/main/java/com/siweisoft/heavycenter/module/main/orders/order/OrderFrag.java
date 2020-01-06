package com.siweisoft.heavycenter.module.main.orders.order;

//by summer on 2017-12-19.

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.StringUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.Test;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersReq;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersRes;
import com.siweisoft.heavycenter.data.netd.order.ordernum.OrderNumRes;
import com.siweisoft.heavycenter.data.netd.order.receipt.ReceiptOrderReq;
import com.siweisoft.heavycenter.data.netd.order.receipt.ReceiptOrderRes;
import com.siweisoft.heavycenter.module.main.orders.detail.DetailFrag;

public class OrderFrag extends AppFrag<OrderUIOpe,OrderDAOpe> implements ViewListener,OnRefreshListener,OnLoadmoreListener{


    public static OrderFrag getInstance(String status,String 容器){
        OrderFrag orderFrag = new OrderFrag();
        orderFrag.setArguments(new Bundle());
        orderFrag.getArguments().putString(ValueConstant.容器,容器);
        orderFrag.getP().getD().setSTATUS(status);
        return orderFrag;
    }

    @Override
    protected void onFristVisibleDelayInit() {
        getP().getU().initRefresh(this,this);
        if(StringUtil.equals(OrderDAOpe.新订单,getP().getD().getSTATUS())){
            getP().getU().autoRefresh();
        }else{
            onRefresh(getP().getU().bind.refresh);
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:
                switch (v.getId()){
                    case R.id.ll_ingorder:
                    case R.id.ll_neworder:
                    case R.id.ll_doneorder:
                        Bundle bundle1 = new Bundle();
                        bundle1.putString(ValueConstant.TYPE,(String)v.getTag(R.id.type));
                        OrdersRes.ResultsBean resultsBean1 = (OrdersRes.ResultsBean) v.getTag(R.id.data);
                        bundle1.putInt(ValueConstant.DATA_DATA, resultsBean1.getOrderId());
                        FragManager2.getInstance().start(getBaseUIAct(), get容器(),new DetailFrag(),bundle1);
                        break;
                    case R.id.bt_sure:
                        final OrdersRes.ResultsBean data = (OrdersRes.ResultsBean) v.getTag(R.id.data);
                        OrderDAOpe.receipt(getBaseUIAct(),data.getOrderId(), ReceiptOrderReq.AUDIO_STATE_接收, new UINetAdapter<ReceiptOrderRes>(this) {
                            @Override
                            public void onSuccess(ReceiptOrderRes o) {
                                data.setAuditState(OrdersRes.ResultsBean.AUDITSTATE_接收);
                                getP().getU().notifyDataSetChanged(getP().getD().getSTATUS(),getP().getD().getOrdersRes(),OrderFrag.this);
                            }
                        });
                        break;
                    case R.id.bt_reject:
                        final OrdersRes.ResultsBean data1 = (OrdersRes.ResultsBean) v.getTag(R.id.data);
                        OrderDAOpe.receipt(getBaseUIAct(),data1.getOrderId(), ReceiptOrderReq.AUDIO_STATE_拒绝, new UINetAdapter<ReceiptOrderRes>(this) {
                            @Override
                            public void onSuccess(ReceiptOrderRes o) {
                                data1.setAuditState(OrdersRes.ResultsBean.AUDITSTATE_拒绝);
                                getP().getU().notifyDataSetChanged(getP().getD().getSTATUS(),getP().getD().getOrdersRes(),OrderFrag.this);
                            }
                        });
                        break;
                }
                break;
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        getP().getD().setPageIndex(getP().getD().getPageIndex()+1);
        OrderDAOpe.orders(getP().getD().getOrdersFrag().getP().getD().getCompanyid(),getBaseUIAct(),getP().getD().getSTATUS(),getP().getD().getPageIndex(),new UINetAdapter<OrdersRes>(this) {
            @Override
            public void onSuccess(OrdersRes o) {
                //o = new Test().getOrdersRes();
                getP().getD().getOrdersRes().getResults().addAll(o.getResults());
                getP().getU().notifyDataSetChanged(getP().getD().getSTATUS(),getP().getD().getOrdersRes(),OrderFrag.this);
            }
        });
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        getP().getD().setPageIndex(NetValue.PAGE_INDEX_START);
        OrderDAOpe.orders(getP().getD().getOrdersFrag().getP().getD().getCompanyid(),getBaseUIAct(),getP().getD().getSTATUS(),getP().getD().getPageIndex(),new UINetAdapter<OrdersRes>(this) {
            @Override
            public void onSuccess(OrdersRes o) {
                //o= new Test().getOrdersRes();
                getP().getD().setOrdersRes(o);
                getP().getD().getOrdersFrag().getP().getD().set较多的订单类型(o.getOrderType());
                getP().getD().getOrdersFrag().getP().getU().refreshTopMenu(o);
                getP().getU().notifyDataSetChanged(getP().getD().getSTATUS(),getP().getD().getOrdersRes(),OrderFrag.this);
            }
        });

    }
}
