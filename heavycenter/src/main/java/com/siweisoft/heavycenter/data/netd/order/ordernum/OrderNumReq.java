package com.siweisoft.heavycenter.data.netd.order.ordernum;

//by summer on 2018-02-05.

import com.android.lib.network.bean.req.BaseReqBean;

public class OrderNumReq extends BaseReqBean {

    private int companyId;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
