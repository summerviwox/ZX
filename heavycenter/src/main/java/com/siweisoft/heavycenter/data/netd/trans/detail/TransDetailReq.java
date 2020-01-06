package com.siweisoft.heavycenter.data.netd.trans.detail;

//by summer on 2018-02-02.

import com.android.lib.network.bean.req.BaseReqBean;

public class TransDetailReq extends BaseReqBean {

    private int transportRecordId;

    public int getTransportRecordId() {
        return transportRecordId;
    }

    public void setTransportRecordId(int transportRecordId) {
        this.transportRecordId = transportRecordId;
    }
}
