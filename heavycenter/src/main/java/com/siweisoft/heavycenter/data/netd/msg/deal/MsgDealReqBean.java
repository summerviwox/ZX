package com.siweisoft.heavycenter.data.netd.msg.deal;

//by summer on 2018-01-15.

import com.android.lib.network.bean.req.BaseReqBean;

public class MsgDealReqBean extends BaseReqBean {

    private int userId;

    private int messageId;

    private String auditStatus;


    public static final String AUDII_STATUS_YES = "YES";

    public static final String AUDII_STATUS_NO = "NO";

    public static final String AUDII_STATUS_SetMngr = "SetMngr";



    public MsgDealReqBean() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }
}
