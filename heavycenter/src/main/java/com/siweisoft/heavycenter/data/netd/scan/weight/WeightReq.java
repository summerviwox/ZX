package com.siweisoft.heavycenter.data.netd.scan.weight;

//by summer on 2018-01-25.

import com.android.lib.network.bean.req.BaseReqBean;

public class WeightReq extends BaseReqBean {

    private String dbNo;

    private String companyId;

    private String userId;

    public WeightReq() {
    }

    public String getDbNo() {
        return dbNo;
    }

    public void setDbNo(String dbNo) {
        this.dbNo = dbNo;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
