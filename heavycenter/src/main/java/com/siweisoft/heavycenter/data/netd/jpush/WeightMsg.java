package com.siweisoft.heavycenter.data.netd.jpush;

//by summer on 2018-01-30.

import com.android.lib.bean.BaseBean;
import com.android.lib.util.StringUtil;
import com.android.lib.util.data.DateFormatUtil;

import java.util.Date;

public class WeightMsg extends BaseBean {


    /**
     * message : {"messageType":"bridge","content":"去送货","state":"s1","time":"2018-02-02 16:17:23","weigh":222,"order":{"orderId":66,"ysdId":107,"fhdwName":"老干爹","driverId":87,"specification":"C50","shdwName":"王尼玛","receiveCompanyId":37,"ysdNo":"15301","develiverCompanyId":39,"orderNo":"201802029","productName":"混凝土"},"fhTare":10}
     */

    private MessageBean message = new MessageBean();

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public static class MessageBean extends BaseBean{
        /**
         * messageType : bridge
         * content : 去送货
         * state : s1
         * time : 2018-02-02 16:17:23
         * weigh : 222
         * order : {"orderId":66,"ysdId":107,"fhdwName":"老干爹","driverId":87,"specification":"C50","shdwName":"王尼玛","receiveCompanyId":37,"ysdNo":"15301","develiverCompanyId":39,"orderNo":"201802029","productName":"混凝土"}
         * fhTare : 10
         */

        private  double mz;
        private  double kc;
        private  double jz;
        private  double pz;
        private String isFlush;


        private String weighResult;
        private String messageType;
        private String content;
        private String state;
        private Long time;
        private double weigh;
        private OrderBean order = new OrderBean();
        private double fhTare;
        private String suttle;
        private String warnMessage;

        public String getIsFlush() {
            return isFlush;
        }

        public void setIsFlush(String isFlush) {
            this.isFlush = isFlush;
        }

        public String getWarnMessage() {
            return warnMessage;
        }

        public void setWarnMessage(String warnMessage) {
            this.warnMessage = warnMessage;
        }

        public String getMessageType() {
            return messageType;
        }

        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }

        public String getContent() {
            return content;
        }

        public String getContentCN() {
            return "系统自动识别当前驾驶员"+ StringUtil.getStr(content)+StringUtil.getStr(getWarnMessage());
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

        public Long getTime() {
            return time;
        }


        public String getTimeCN() {
            if(time==null){
                return "";
            }
            return DateFormatUtil.getdDateStr(DateFormatUtil.MM_DD_HH_MM_SS,new Date(time));
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public double getWeigh() {
            return weigh;
        }

        public void setWeigh(double weigh) {
            this.weigh = weigh;
        }

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public double getFhTare() {
            return fhTare;
        }

        public void setFhTare(double fhTare) {
            this.fhTare = fhTare;
        }

        public String getWeighResult() {
            return weighResult;
        }

        public void setWeighResult(String weighResult) {
            this.weighResult = weighResult;
        }

        public String getSuttle() {
            return suttle;
        }

        public void setSuttle(String suttle) {
            this.suttle = suttle;
        }

        public double getKc() {
            return kc;
        }

        public String getKcCN() {
            return StringUtil.getStr(kc);
        }

        public void setKc(double kc) {
            this.kc = kc;
        }

        public double getJz() {
            return jz;
        }


        public String getJzCN() {
            return StringUtil.getStr(jz);
        }

        public void setJz(double jz) {
            this.jz = jz;
        }

        public double getPz() {
            return pz;
        }


        public String getPzCN() {
            return StringUtil.getStr(pz);
        }

        public void setPz(double pz) {
            this.pz = pz;
        }

        public double getMz() {
            return mz;
        }

        public String getMzCN() {
            return StringUtil.getStr(mz);
        }

        public void setMz(double mz) {
            this.mz = mz;
        }

        public static class OrderBean extends BaseBean{

            /**
             * orderId : 326
             * tel : 13255550000
             * ysdId : 0
             * fhdwName : 贝塔
             * orderType : S
             * specification : 细碎石(10-20mm)
             * totalRecord : 0
             * productName : 石子
             * trueName : p9090308
             * receiveCompanyId : 99
             * ysdNo :
             * develiverCompanyId : 98
             * driverId : 244
             * orderNo : 201803096
             * shdwName : 舒克
             * planNumber : 100
             * carLicenseNo : 沪E00000
             * actualSh : 0
             */

            private int orderId;
            private String tel;
            private int ysdId;
            private String fhdwName;
            private String orderType;
            private String specification;
            private int totalRecord;
            private String productName;
            private String trueName;
            private int receiveCompanyId;
            private String ysdNo;
            private int develiverCompanyId;
            private int driverId;
            private String orderNo;
            private String shdwName;
            private int planNumber;
            private String carLicenseNo;
            private int actualSh;
            private String develiverCompanyName;
            private String receiveCompanyName;



            public String getShortAccessComName() {
                if(isIDiliverCom()){
                    return getShdwName();
                }else{
                    return  getFhdwName();
                }
            }


            public String getAccessComName() {
                if(isIDiliverCom()){
                    return getReceiveCompanyName();
                }else{
                    return  getDeveliverCompanyName();
                }
            }


            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getYsdId() {
                return ysdId;
            }

            public void setYsdId(int ysdId) {
                this.ysdId = ysdId;
            }

            public String getFhdwName() {
                return fhdwName;
            }

            public void setFhdwName(String fhdwName) {
                this.fhdwName = fhdwName;
            }

            public String getOrderType() {
                return orderType;
            }

            public void setOrderType(String orderType) {
                this.orderType = orderType;
            }

            public String getSpecification() {
                return specification;
            }

            public void setSpecification(String specification) {
                this.specification = specification;
            }

            public int getTotalRecord() {
                return totalRecord;
            }

            public void setTotalRecord(int totalRecord) {
                this.totalRecord = totalRecord;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getTrueName() {
                return trueName;
            }

            public void setTrueName(String trueName) {
                this.trueName = trueName;
            }

            public int getReceiveCompanyId() {
                return receiveCompanyId;
            }

            public void setReceiveCompanyId(int receiveCompanyId) {
                this.receiveCompanyId = receiveCompanyId;
            }

            public String getYsdNo() {
                return ysdNo;
            }

            public void setYsdNo(String ysdNo) {
                this.ysdNo = ysdNo;
            }

            public int getDeveliverCompanyId() {
                return develiverCompanyId;
            }

            public void setDeveliverCompanyId(int develiverCompanyId) {
                this.develiverCompanyId = develiverCompanyId;
            }

            public int getDriverId() {
                return driverId;
            }

            public void setDriverId(int driverId) {
                this.driverId = driverId;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public String getShdwName() {
                return shdwName;
            }

            public void setShdwName(String shdwName) {
                this.shdwName = shdwName;
            }

            public int getPlanNumber() {
                return planNumber;
            }

            public void setPlanNumber(int planNumber) {
                this.planNumber = planNumber;
            }

            public String getCarLicenseNo() {
                return carLicenseNo;
            }

            public void setCarLicenseNo(String carLicenseNo) {
                this.carLicenseNo = carLicenseNo;
            }

            public int getActualSh() {
                return actualSh;
            }

            public void setActualSh(int actualSh) {
                this.actualSh = actualSh;
            }

            public boolean isIDiliverCom(){
                if("S".equals(getOrderType())){
                    return true;
                }
                return false;
            }


            public String getType() {
                if(isIDiliverCom()){
                    return "发往";
                }else{
                    return "来自";
                }
            }

            public String getDeveliverCompanyName() {
                return develiverCompanyName;
            }

            public void setDeveliverCompanyName(String develiverCompanyName) {
                this.develiverCompanyName = develiverCompanyName;
            }

            public String getReceiveCompanyName() {
                return receiveCompanyName;
            }

            public void setReceiveCompanyName(String receiveCompanyName) {
                this.receiveCompanyName = receiveCompanyName;
            }
        }
    }
}
