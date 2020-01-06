package com.siweisoft.heavycenter.data.netd.order.addcar;

//by summer on 2018-01-19.

import com.android.lib.network.bean.req.BaseReqBean;

public class AddCarReq extends BaseReqBean {

    private int id;

    private int vehicleList;

    private int editer;

    private String oper;

    public static final String  添加= "add";

    public static final String  移除= "del";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(int vehicleList) {
        this.vehicleList = vehicleList;
    }

    public int getEditer() {
        return editer;
    }

    public void setEditer(int editer) {
        this.editer = editer;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }
}
