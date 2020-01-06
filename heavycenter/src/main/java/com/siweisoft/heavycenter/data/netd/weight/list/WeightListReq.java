package com.siweisoft.heavycenter.data.netd.weight.list;

//by summer on 2018-01-30.

import com.android.lib.network.bean.req.BaseReqBean;

public class WeightListReq extends BaseReqBean {

    private int companyId;

    private int pageSize;

    private int pageIndex;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
