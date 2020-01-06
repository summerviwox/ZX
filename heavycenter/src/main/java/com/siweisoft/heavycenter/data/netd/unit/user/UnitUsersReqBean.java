package com.siweisoft.heavycenter.data.netd.unit.user;

//by summer on 2018-01-11.

import com.android.lib.network.bean.req.BaseReqBean;

public class UnitUsersReqBean extends BaseReqBean {

    private int isApp;

    private int companyId;

    private int pageIndex;

    private int pageSize;

    public UnitUsersReqBean() {
    }

    public int getIsApp() {
        return isApp;
    }

    public void setIsApp(int isApp) {
        this.isApp = isApp;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
