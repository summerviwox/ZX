package com.siweisoft.heavycenter.data.netd.mana.car.bind;

//by summer on 2018-01-18.

import com.android.lib.network.bean.req.BaseReqBean;

public class BindCarReq extends BaseReqBean {

    private int id;

    private int currentDriver;

    private int editer;

    private boolean enable = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentDriver() {
        return currentDriver;
    }

    public void setCurrentDriver(int currentDriver) {
        this.currentDriver = currentDriver;
    }

    public int getEditer() {
        return editer;
    }

    public void setEditer(int editer) {
        this.editer = editer;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
