package com.siweisoft.heavycenter.data.netd.order.detail;

//by summer on 2018-01-19.

import com.android.lib.network.bean.req.BaseReqBean;

public class OrderDetailReq extends BaseReqBean {

    private int isApp;

    private int id;

    public OrderDetailReq() {
    }

    public int getIsApp() {
        return isApp;
    }

    public void setIsApp(int isApp) {
        this.isApp = isApp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
