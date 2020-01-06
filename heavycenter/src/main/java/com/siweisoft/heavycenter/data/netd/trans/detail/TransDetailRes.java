package com.siweisoft.heavycenter.data.netd.trans.detail;


import androidx.databinding.Bindable;

import com.android.lib.bean.BaseBean;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.data.DateFormatUtil;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.module.main.orders.news.rule.RuleDAOpe;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public  class TransDetailRes extends BaseBean {


    /**
     * orderType : S
     * develiverCompanyLat : 31.314282
     * receiveCompanyName : 王尼玛有限公司
     * develiverCompanyLng : 121.515221
     * develiverAbbreviationName : 老干爹
     * signStatus : 0
     * deliverRecordList : [{"adjustGross":0,"fhDeduct":0,"adjustTare":0,"gross":20,"grossPhoto":"","deductTime":null,"tareTime":null,"grossTime":null,"remark":"","editTime":null,"warehouseId":0,"createTime":1517537731000,"tare":10,"creater":80,"id":106,"editer":0,"transportRecordId":105,"tarePhoto":"","status":1}]
     * specifications : 100f
     * productName : 水泥
     * carLicenseNo : 沪A44444
     * trueName : 18721503333
     * receiveRecordList : [{"adjustGross":0,"adjustTare":0,"gross":20,"grossPhoto":null,"deductTime":null,"tareTime":null,"grossTime":null,"remark":"","editTime":null,"shDeduct":0,"warehouseId":0,"createTime":1517537731000,"tare":10,"creater":80,"id":101,"editer":0,"transportRecordId":105,"tarePhoto":"","status":1}]
     * receiveAbbreviationName : 王尼玛
     * receiveCompanyLat : 31.314243
     * signRule : zjSign
     * develiverNum : 10
     * tel : 18721503333
     * receiveCompanyLng : 121.515273
     * transportrecordId : 105
     * receiveNum : 0
     * orderNo : 201802022
     * userId : 87
     * develiverCompanyName : 老干爹有限公司
     * carNumber : null
     * ordersId : 59
     */

    private String orderType;
    private double develiverCompanyLat;
    private String receiveCompanyName;
    private double develiverCompanyLng;
    private String develiverAbbreviationName;
    private int signStatus;
    private String specifications;
    private String productName;
    private String carLicenseNo;
    private String trueName;
    private String receiveAbbreviationName;
    private double receiveCompanyLat;
    private String signRule;
    private double develiverNum;
    private String tel;
    private double receiveCompanyLng;
    private int transportrecordId;
    private double receiveNum;
    private String orderNo;
    private int userId;
    private String develiverCompanyName;
    private int carNumber;
    private int ordersId;
    private double totalSuttle;
    private double planNumber;
    private Long FhTime;
    private Long ShTime;
    private ArrayList<DeliverRecordListBean> deliverRecordList;
    private ArrayList<DeliverRecordListBean> receiveRecordList;


    public static final int SING_STATUS_未确认 = 0;

    public static final int SING_STATUS_已确认 = 1;

    public static final String 订单类型_发货 = "S";

    public static final String 订单类型_收货 = "R";


    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public double getDeveliverCompanyLat() {
        return develiverCompanyLat;
    }

    public void setDeveliverCompanyLat(double develiverCompanyLat) {
        this.develiverCompanyLat = develiverCompanyLat;
    }

    public String getReceiveCompanyName() {
        return receiveCompanyName;
    }

    public String getReceiveCompanyNameCN() {
        return StringUtil.getStr(receiveCompanyName);
    }

    public void setReceiveCompanyName(String receiveCompanyName) {
        this.receiveCompanyName = receiveCompanyName;
    }

    public double getDeveliverCompanyLng() {
        return develiverCompanyLng;
    }

    public void setDeveliverCompanyLng(double develiverCompanyLng) {
        this.develiverCompanyLng = develiverCompanyLng;
    }

    public String getDeveliverAbbreviationName() {
        return develiverAbbreviationName;
    }

    public void setDeveliverAbbreviationName(String develiverAbbreviationName) {
        this.develiverAbbreviationName = develiverAbbreviationName;
    }

    public int getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(int signStatus) {
        this.signStatus = signStatus;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Bindable
    public String getProductNameAndSpecification() {
        return StringUtil.getStr(productName)+"\t\t"+StringUtil.getStr(specifications);
    }


    public String getCarLicenseNo() {
        return carLicenseNo;
    }


    public String getCarLicenseNoCN() {
        return StringUtil.getStr(carLicenseNo);
    }

    public void setCarLicenseNo(String carLicenseNo) {
        this.carLicenseNo = carLicenseNo;
    }

    public String getTrueName() {
        return trueName;
    }

    public String getTrueNameCN() {
        return StringUtil.getStr(trueName);
    }


    public String getTrueNameCN2() {
        return "驾驶员:"+StringUtil.getStr(trueName);
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getReceiveAbbreviationName() {
        return receiveAbbreviationName;
    }

    public void setReceiveAbbreviationName(String receiveAbbreviationName) {
        this.receiveAbbreviationName = receiveAbbreviationName;
    }

    public double getReceiveCompanyLat() {
        return receiveCompanyLat;
    }

    public void setReceiveCompanyLat(double receiveCompanyLat) {
        this.receiveCompanyLat = receiveCompanyLat;
    }

    public String getSignRule() {
        return signRule;
    }

    public void setSignRule(String signRule) {
        this.signRule = signRule;
    }



    public String getTel() {
        return tel;
    }

    public String getTelCN2() {
        return "联系电话:"+StringUtil.getStr(tel);
    }


    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getReceiveCompanyLng() {
        return receiveCompanyLng;
    }

    public void setReceiveCompanyLng(double receiveCompanyLng) {
        this.receiveCompanyLng = receiveCompanyLng;
    }

    public int getTransportrecordId() {
        return transportrecordId;
    }

    public void setTransportrecordId(int transportrecordId) {
        this.transportrecordId = transportrecordId;
    }

    public double getDeveliverNum() {
        return develiverNum;
    }


    public String getDeveliverNumCN() {
        return develiverNum+"t";
    }

    public void setDeveliverNum(double develiverNum) {
        this.develiverNum = develiverNum;
    }

    public double getReceiveNum() {
        return receiveNum;
    }

    public String getReceiveNumCN() {
        return StringUtil.getStr(receiveNum)+"t";
    }

    public void setReceiveNum(double receiveNum) {
        this.receiveNum = receiveNum;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDeveliverCompanyName() {
        return develiverCompanyName;
    }

    public String getDeveliverCompanyNameCN() {
        return StringUtil.getStr(develiverCompanyName);
    }

    public void setDeveliverCompanyName(String develiverCompanyName) {
        this.develiverCompanyName = develiverCompanyName;
    }

    public String getCarNumberCN() {
        if(getSignStatus()==TransDetailRes.SING_STATUS_已确认){
            return "第"+StringUtil.getStr(getCarNumber())+"车";
        }
        return StringUtil.getStr(getCarNumber()-1)+"车";
    }


    public String getCarNumberCN2() {
        return "第"+StringUtil.getStr(getCarNumber())+"车";
    }


    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public ArrayList<DeliverRecordListBean> getDeliverRecordList() {
        return deliverRecordList;
    }

    public void setDeliverRecordList(ArrayList<DeliverRecordListBean> deliverRecordList) {
        this.deliverRecordList = deliverRecordList;
    }

    public ArrayList<DeliverRecordListBean> getReceiveRecordList() {
        return receiveRecordList;
    }

    public void setReceiveRecordList(ArrayList<DeliverRecordListBean> receiveRecordList) {
        this.receiveRecordList = receiveRecordList;
    }

    public double getYK(){
        return  getReceiveNum()- getDeveliverNum();
    }


    public String getYKCN(){
        BigDecimal bd = new BigDecimal(getReceiveNum()- getDeveliverNum());
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        return  bd.toString()+"t";
    }

    public Long getFhTime() {
        return FhTime;
    }

    LoginResBean loginResBean = LocalValue.get登录返回信息();

    public boolean isIDiliverCom(){
        if("S".equals(getOrderType())){
            return true;
        }
        return false;
    }

    public boolean isDriver(){
        return  loginResBean.is驾驶员();
    }

    public boolean isShowCarLicense(){
        if(NullUtil.isStrEmpty(getCarLicenseNo())){
            return false;
        }
        return true;
    }

    public String getType(){
        if(isIDiliverCom()){
            return "发往";
        }
        return "来自";
    }


    public String getAccessComName() {
        if(isIDiliverCom()){
            return getReceiveCompanyNameCN();
        }
        return getDeveliverCompanyNameCN();
    }

    public boolean isUpSecondTypeShow(){
        if(loginResBean.is驾驶员()||!isIDiliverCom()){
            return false;
        }
        return true;
    }


    public boolean isDownSecondTypeShow(){
        if(loginResBean.is驾驶员()||isIDiliverCom()){
            return false;
        }
        return true;
    }

    public String getFhTimeCN() {
        if(getFhTime()==null){
            return "";
        }
        return DateFormatUtil.getdDateStr(DateFormatUtil.MM_DD_HH_MM,new Date(getFhTime()));
    }

    public String getFhTimeCN2() {
        if(getFhTime()==null){
            return "";
        }
        return DateFormatUtil.getdDateStr(DateFormatUtil.YYYY_MM_DD_HH_MM_SS,new Date(getFhTime()));
    }

    public int getPercent(){
        if((getSignStatus()==TransDetailRes.SING_STATUS_已确认)){
            return 0;
        }
        if(getPlanNumber()==0){
            return 0;
        }
        return (int) (100*getTotalSuttle()/(getPlanNumber()));
    }


    public void setFhTime(Long fhTime) {
        FhTime = fhTime;
    }

    public Long getShTime() {
        return ShTime;
    }

    public String getShTimeCN() {
        if(getShTime()==null){
            return "";
        }
        return DateFormatUtil.getdDateStr(DateFormatUtil.MM_DD_HH_MM,new Date(getShTime()));
    }

    public String getShTimeCN2() {
        if(getShTime()==null){
            return "";
        }
        return DateFormatUtil.getdDateStr(DateFormatUtil.YYYY_MM_DD_HH_MM_SS,new Date(getShTime()));
    }

    public boolean isshowOpeBtn(TransDetailRes data){
        if(getReceiveNum()==0){
            return false;
        }
        if((data.getSignStatus()==TransDetailRes.SING_STATUS_未确认)){
            if(loginResBean.is驾驶员()){
                if(StringUtil.equals(getSignRule(), RuleDAOpe.需驾驶员确认)){
                    return true;
                }
                return false;
            }else{
                if(isIDiliverCom()){
                    if(StringUtil.equals(getSignRule(), RuleDAOpe.需发货单位确认)){
                        return true;
                    }
                    return false;
                }else{
                    return false;
                }
            }

        }
        if(data.getSignStatus()==TransDetailRes.SING_STATUS_已确认){
            return false;
        }
        return true;
    }

    public boolean isFinished(TransDetailRes data){
        if((data.getSignStatus()==TransDetailRes.SING_STATUS_未确认)){
            return false;
        }
        return true;
    }

    public String getUpLineTxt(){
        if(loginResBean.is驾驶员()){
            return StringUtil.getStr(getDeveliverCompanyName());
        }else{
            if(isIDiliverCom()){
                return StringUtil.getStr(getTrueName());
            }else{
                return StringUtil.getStr(getDeveliverCompanyName());
            }
        }
    }


    public String getDownLineTxt(){
        if(loginResBean.is驾驶员()){
            return StringUtil.getStr(getReceiveCompanyName());
        }else{
            if(isIDiliverCom()){
                return StringUtil.getStr(getReceiveCompanyName());
            }else{
                return StringUtil.getStr(getTrueName());
            }
        }
    }



    public void setShTime(Long shTime) {
        ShTime = shTime;
    }

    public static class DeliverRecordListBean extends BaseBean{

        /**
         * deduct : 0
         * adjustGross : 0
         * adjustTare : 0
         * gross : 0
         * grossPhoto :
         * deductTime : 1234566666
         * tareTime : 1234566666
         * grossTime : null
         * remark :
         * editTime : 1234566666
         * netWeight : 0
         * warehouseId : 0
         * createTime : 1517975889000
         * tare : 0
         * creater : 78
         * netWeightTime : 1519696732000
         * id : 124
         * editer : 0
         * transportRecordId : 118
         * tarePhoto :
         * status : 1
         */

        private double deduct;
        private double adjustGross;
        private double adjustTare;
        private double gross;
        private String grossPhoto;
        private Long deductTime;
        private Long tareTime;
        private Long grossTime;
        private String remark;
        private long editTime;
        private double netWeight;
        private int warehouseId;
        private Long createTime;
        private double tare;
        private int creater;
        private Long netWeightTime;
        private int id;
        private int editer;
        private int transportRecordId;
        private String tarePhoto;
        private int status;

        public double getDeduct() {
            return deduct;
        }

        public void setDeduct(double deduct) {
            this.deduct = deduct;
        }

        public double getAdjustGross() {
            return adjustGross;
        }

        public void setAdjustGross(double adjustGross) {
            this.adjustGross = adjustGross;
        }

        public double getAdjustTare() {
            return adjustTare;
        }

        public void setAdjustTare(double adjustTare) {
            this.adjustTare = adjustTare;
        }

        public double getGross() {
            return gross;
        }

        public void setGross(double gross) {
            this.gross = gross;
        }

        public String getGrossPhoto() {
            return grossPhoto;
        }

        public void setGrossPhoto(String grossPhoto) {
            this.grossPhoto = grossPhoto;
        }




        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }


        public double getNetWeight() {
            return netWeight;
        }

        public String getNetWeightCN() {
            return netWeight+"t";
        }

        public void setNetWeight(double netWeight) {
            this.netWeight = netWeight;
        }

        public int getWarehouseId() {
            return warehouseId;
        }

        public void setWarehouseId(int warehouseId) {
            this.warehouseId = warehouseId;
        }


        public double getTare() {
            return tare;
        }

        public void setTare(double tare) {
            this.tare = tare;
        }

        public int getCreater() {
            return creater;
        }

        public void setCreater(int creater) {
            this.creater = creater;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEditer() {
            return editer;
        }

        public void setEditer(int editer) {
            this.editer = editer;
        }

        public int getTransportRecordId() {
            return transportRecordId;
        }

        public void setTransportRecordId(int transportRecordId) {
            this.transportRecordId = transportRecordId;
        }

        public String getTarePhoto() {
            return tarePhoto;
        }

        public void setTarePhoto(String tarePhoto) {
            this.tarePhoto = tarePhoto;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Long getDeductTime() {
            return deductTime;
        }


        public String getDeductTimeCN() {
            if(getDeductTime()==null){
                return "";
            }
            return DateFormatUtil.getdDateStr(DateFormatUtil.HH_MM,new Date(getDeductTime()))+"";
        }

        public void setDeductTime(Long deductTime) {
            this.deductTime = deductTime;
        }

        public Long getTareTime() {
            return tareTime;
        }


        public String getTareTimeCN() {
            if(getTareTime()==null){
                return "";
            }
            return DateFormatUtil.getdDateStr(DateFormatUtil.HH_MM,new Date(getTareTime()))+"";
        }

        public void setTareTime(Long tareTime) {
            this.tareTime = tareTime;
        }

        public Long getGrossTime() {
            return grossTime;
        }

        public String getGrossTimeCN() {
            if(getGrossTime()==null){
                return "";
            }
            return DateFormatUtil.getdDateStr(DateFormatUtil.HH_MM,new Date(getGrossTime()))+"";
        }

        public void setGrossTime(Long grossTime) {
            this.grossTime = grossTime;
        }

        public long getEditTime() {
            return editTime;
        }

        public void setEditTime(long editTime) {
            this.editTime = editTime;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getNetWeightTime() {
            return netWeightTime;
        }

        public void setNetWeightTime(Long netWeightTime) {
            this.netWeightTime = netWeightTime;
        }
    }





    public double getTotalSuttle() {
        return totalSuttle;
    }

    public String getTotalSuttleCN() {
        return totalSuttle+"t";
    }


    public void setTotalSuttle(double totalSuttle) {
        this.totalSuttle = totalSuttle;
    }

    public double getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(double planNumber) {
        this.planNumber = planNumber;
    }
}