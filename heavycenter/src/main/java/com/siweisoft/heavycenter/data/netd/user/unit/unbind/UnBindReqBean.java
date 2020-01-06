package com.siweisoft.heavycenter.data.netd.user.unit.unbind;

//by summer on 2018-01-12.

import com.android.lib.network.bean.req.BaseReqBean;

public class UnBindReqBean extends BaseReqBean {

    private int id;

    private int companyId;

    public UnBindReqBean() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
