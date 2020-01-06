package com.siweisoft.heavycenter.data.netd.mana.car.news;

//by summer on 2018-01-15.

import com.android.lib.network.bean.req.BaseReqBean;

public class CarNewReqBean extends BaseReqBean {

    private String carLicenseNo;

    private String carBrand;

    private String vehiclePhoto;

    private String vehicleLicensePhoto;

    private float maxCapacity;

    private float emptyWeight;

    private String icCard;

    private int companyId;

    private int creater;

    public CarNewReqBean() {
    }

    public String getCarLicenseNo() {
        return carLicenseNo;
    }

    public void setCarLicenseNo(String carLicenseNo) {
        this.carLicenseNo = carLicenseNo;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getVehiclePhoto() {
        return vehiclePhoto;
    }

    public void setVehiclePhoto(String vehiclePhoto) {
        this.vehiclePhoto = vehiclePhoto;
    }

    public String getVehicleLicensePhoto() {
        return vehicleLicensePhoto;
    }

    public void setVehicleLicensePhoto(String vehicleLicensePhoto) {
        this.vehicleLicensePhoto = vehicleLicensePhoto;
    }

    public float getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(float maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public float getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(float emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public String getIcCard() {
        return icCard;
    }

    public void setIcCard(String icCard) {
        this.icCard = icCard;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCreater() {
        return creater;
    }

    public void setCreater(int creater) {
        this.creater = creater;
    }
}
