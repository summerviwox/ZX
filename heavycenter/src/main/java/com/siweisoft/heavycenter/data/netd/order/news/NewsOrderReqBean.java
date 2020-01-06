package com.siweisoft.heavycenter.data.netd.order.news;

//by summer on 2018-01-17.

import com.android.lib.network.bean.req.BaseReqBean;

public class NewsOrderReqBean extends BaseReqBean {

    private int creater;

    private String orderType;

    private int develiverCompanyId;

    private int receiveCompanyId;

    private int tempCompany = -1;

    private String tempCompanyName ;

    private String address;

    private String productName;

    private String specification;

    private float planNumber;

    private String planTime;

    private String signRule;

    private String signRuleValue;

    private int productId;

    public static final String 直接签收 = "zjSign";

    public static final String 驾驶员确认签收 = "jsyQr";

    public static final String 发货单位确认签收 = "fhdwQr";


    public static final String 发货 = "S";

    public static final String 收货 = "R";

    public int getCreater() {
        return creater;
    }

    public void setCreater(int creater) {
        this.creater = creater;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getDeveliverCompanyId() {
        return develiverCompanyId;
    }

    public void setDeveliverCompanyId(int develiverCompanyId) {
        this.develiverCompanyId = develiverCompanyId;
    }

    public int getReceiveCompanyId() {
        return receiveCompanyId;
    }

    public void setReceiveCompanyId(int receiveCompanyId) {
        this.receiveCompanyId = receiveCompanyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public float getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(float planNumber) {
        this.planNumber = planNumber;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = planTime;
    }

    public String getSignRule() {
        return signRule;
    }

    public void setSignRule(String signRule) {
        this.signRule = signRule;
    }

    public int getTempCompany() {
        return tempCompany;
    }


    public void setTempCompany(int tempCompany) {


        this.tempCompany = tempCompany;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTempCompanyName() {
        return tempCompanyName;
    }

    public void setTempCompanyName(String tempCompanyName) {
        this.tempCompanyName = tempCompanyName;
    }

    public String getSignRuleValue() {
        return signRuleValue;
    }

    public void setSignRuleValue(String signRuleValue) {
        this.signRuleValue = signRuleValue;
    }
}
