package com.siweisoft.heavycenter.data.netd.trans.sign;

//by summer on 2018-01-31.

import com.android.lib.network.bean.req.BaseReqBean;

public class TransSignReq extends BaseReqBean {

    private int transportrecordId;

    private int userId;

    private int signStatus;

    public static int 已确认 = 1;

    public static int 等待确认 = 0;


    public int getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(int signStatus) {
        this.signStatus = signStatus;
    }

    public int getTransportrecordId() {
        return transportrecordId;
    }

    public void setTransportrecordId(int transportrecordId) {
        this.transportrecordId = transportrecordId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
