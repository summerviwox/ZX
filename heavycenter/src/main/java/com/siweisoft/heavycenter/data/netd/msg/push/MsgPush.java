package com.siweisoft.heavycenter.data.netd.msg.push;

//by summer on 2018-03-02.

import com.android.lib.bean.BaseBean;

public class MsgPush extends BaseBean {


    /**
     * resultData : {}
     * isFlush : 0
     * messageType : inviteM
     * messageCate : 1
     */

    private ResultDataBean resultData;
    private String isFlush;
    private String messageType;
    private int messageCate;



    public ResultDataBean getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataBean resultData) {
        this.resultData = resultData;
    }

    public String getIsFlush() {
        return isFlush;
    }

    public void setIsFlush(String isFlush) {
        this.isFlush = isFlush;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public int getMessageCate() {
        return messageCate;
    }

    public void setMessageCate(int messageCate) {
        this.messageCate = messageCate;
    }

    public static class ResultDataBean {
    }
}
