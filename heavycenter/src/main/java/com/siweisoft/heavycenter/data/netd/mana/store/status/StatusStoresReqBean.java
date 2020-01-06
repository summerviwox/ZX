package com.siweisoft.heavycenter.data.netd.mana.store.status;

//by summer on 2018-01-16.

import com.android.lib.network.bean.req.BaseReqBean;

public class StatusStoresReqBean extends BaseReqBean {

    private int id;

    private int status;

    public StatusStoresReqBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
