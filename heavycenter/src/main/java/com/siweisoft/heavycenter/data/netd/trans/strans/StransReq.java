package com.siweisoft.heavycenter.data.netd.trans.strans;

//by summer on 2018-03-14.

import com.android.lib.network.bean.req.BaseReqBean;

public class StransReq extends BaseReqBean {
    private int isApp = 1;

    private int ordersId;

    private int pageIndex;

    private int pageSize;

    private int signStatus;

    public int getIsApp() {
        return isApp;
    }

    public void setIsApp(int isApp) {
        this.isApp = isApp;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(int signStatus) {
        this.signStatus = signStatus;
    }

}
