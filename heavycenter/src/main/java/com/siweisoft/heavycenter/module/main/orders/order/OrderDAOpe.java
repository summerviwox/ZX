package com.siweisoft.heavycenter.module.main.orders.order;

//by summer on 2017-12-19.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersReq;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersRes;
import com.siweisoft.heavycenter.data.netd.order.receipt.ReceiptOrderReq;
import com.siweisoft.heavycenter.data.netd.order.receipt.ReceiptOrderRes;
import com.siweisoft.heavycenter.module.main.orders.OrdersDAOpe;
import com.siweisoft.heavycenter.module.main.orders.OrdersFrag;

public class OrderDAOpe extends AppDAOpe {

    OrdersFrag ordersFrag;

    private int pageIndex = NetValue.PAGE_INDEX_START;

    private OrdersRes ordersRes = new OrdersRes();


    public static final String 新订单 = OrdersReq.新订单;

    public static final String 进行中订单 = OrdersReq.进行中订单;

    public static final String 已完成订单 = OrdersReq.已完成订单;

    private String STATUS = "";

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }



    public static void orders(int comid,Context context,String type, int pageIndex, NetI<OrdersRes> adapter){
        OrdersReq ordersReq = new OrdersReq();
        ordersReq.setCompanyId(comid);
        ordersReq.setIsApp(1);
        ordersReq.setPageIndex(pageIndex);
        ordersReq.setPageSize(10);
        ordersReq.setOrderStatus(type);
        NetDataOpe.Order.orders(context,ordersReq,adapter);
    }

    public static void receipt(Context context,int id, int state, NetI<ReceiptOrderRes> adapter){
        ReceiptOrderReq receiptOrderReq = new ReceiptOrderReq();
        receiptOrderReq.setAuditor(LocalValue.get登录返回信息().getUserId());
        receiptOrderReq.setAuditState(state);
        receiptOrderReq.setId(id);
        NetDataOpe.Order.receipt(context,receiptOrderReq,adapter);
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public OrdersRes getOrdersRes() {
        return ordersRes;
    }

    public void setOrdersRes(OrdersRes ordersRes) {
        this.ordersRes = ordersRes;
    }

    public OrdersFrag getOrdersFrag() {
        return ordersFrag;
    }

    public void setOrdersFrag(OrdersFrag ordersFrag) {
        this.ordersFrag = ordersFrag;
    }
}
