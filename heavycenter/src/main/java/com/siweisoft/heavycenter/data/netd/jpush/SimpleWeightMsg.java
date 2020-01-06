package com.siweisoft.heavycenter.data.netd.jpush;

//by summer on 2018-01-30.

import com.android.lib.bean.BaseBean;

public class SimpleWeightMsg extends BaseBean {

    /**
     * message : {"messageType":"bridge","content":"来拉货","state":"s0","time":"2018-01-30 16:49:02","weigh":20,"order":{"orderId":20,"ysdId":18,"fhdwName":"老干爹","specification":"300f","shdwName":"王尼玛","receiveCompanyId":37,"ysdNo":"","develiverCompanyId":39,"orderNo":"201801308","productName":"水泥"}}
     */

    private WeightMsg.MessageBean message;

    public WeightMsg.MessageBean getMessage() {
        return message;
    }

    public void setMessage(WeightMsg.MessageBean message) {
        this.message = message;
    }

    public static class MessageBean extends BaseBean{

        private String messageType;
        private String content;
        private String state;
        private String time;
        private int weigh;

        public String getMessageType() {
            return messageType;
        }

        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getWeigh() {
            return weigh;
        }

        public void setWeigh(int weigh) {
            this.weigh = weigh;
        }
    }
}
