package com.siweisoft.heavycenter.data.netd.weight.save;

//by summer on 2018-01-30.

import com.android.lib.network.bean.req.BaseReqBean;

public class SaveWeightReq extends BaseReqBean {

    private int orderId;

    private int transportRecordId;

    private int weighLocation;

    private String state;

    private double weighing;

    private int driverId;

    private float deductWeight;

    public static final int 毛重 = 1;

    public static final int 皮重 = 2;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTransportRecordId() {
        return transportRecordId;
    }

    public void setTransportRecordId(int transportRecordId) {
        this.transportRecordId = transportRecordId;
    }

    public int getWeighLocation() {
        return weighLocation;
    }

    public void setWeighLocation(int weighLocation) {
        this.weighLocation = weighLocation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getWeighing() {
        return weighing;
    }

    public void setWeighing(double weighing) {
        this.weighing = weighing;
    }

    public float getDeductWeight() {
        return deductWeight;
    }

    public void setDeductWeight(float deductWeight) {
        this.deductWeight = deductWeight;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
