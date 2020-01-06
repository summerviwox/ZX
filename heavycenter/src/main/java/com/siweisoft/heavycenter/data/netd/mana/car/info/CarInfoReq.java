package com.siweisoft.heavycenter.data.netd.mana.car.info;

//by summer on 2018-01-24.

import com.android.lib.network.bean.req.BaseReqBean;

public class CarInfoReq extends BaseReqBean {

    private int isApp;

    private Integer id;

    private String carLicenseNo;

    public CarInfoReq() {
    }

    public int getIsApp() {
        return isApp;
    }

    public void setIsApp(int isApp) {
        this.isApp = isApp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarLicenseNo() {
        return carLicenseNo;
    }

    public void setCarLicenseNo(String carLicenseNo) {
        this.carLicenseNo = carLicenseNo;
    }
}
