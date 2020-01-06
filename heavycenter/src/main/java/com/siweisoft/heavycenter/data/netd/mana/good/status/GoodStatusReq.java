package com.siweisoft.heavycenter.data.netd.mana.good.status;

//by summer on 2018-03-02.

import com.android.lib.network.bean.req.BaseReqBean;

public class GoodStatusReq extends BaseReqBean {

    private int id;

    private int status;

    public static final int 启用 =1;

    public static final int 停用 = 0;


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
