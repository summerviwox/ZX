package com.siweisoft.heavycenter.data.netd.order.receipt;

//by summer on 2018-02-05.

import com.android.lib.network.bean.req.BaseReqBean;

public class ReceiptOrderReq extends BaseReqBean {


    private int id;

    private int auditState;

    private int auditor;

    public final static int  AUDIO_STATE_接收 = 1;

    public final static int  AUDIO_STATE_拒绝 = 2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuditState() {
        return auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
    }

    public int getAuditor() {
        return auditor;
    }

    public void setAuditor(int auditor) {
        this.auditor = auditor;
    }
}
