package com.siweisoft.heavycenter.data.netd.user.dirver;

//by summer on 2018-01-24.

import com.android.lib.network.bean.req.BaseReqBean;

public class UpdDriverReq extends BaseReqBean {

    private int id;

    private String driverNo;

    private String driverNoPhoto;

    private String icCard;


    public UpdDriverReq() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
    }

    public String getDriverNoPhoto() {
        return driverNoPhoto;
    }

    public void setDriverNoPhoto(String driverNoPhoto) {
        this.driverNoPhoto = driverNoPhoto;
    }

    public String getIcCard() {
        return icCard;
    }

    public void setIcCard(String icCard) {
        this.icCard = icCard;
    }
}
