package com.siweisoft.heavycenter.data.netd.mana.store.list;

//by summer on 2018-01-11.

import com.android.lib.network.bean.req.BaseReqBean;

public class StoresReqBean extends BaseReqBean {

    public static final int STATUS_ON = 1;

    public static final int STATUS_OFF = 0;

    public static final int STATUS_ALL = -1;


    private int companyId;

    private int isApp;

    private int pageSize;

    private int pageIndex;

    private Integer status;

    private Integer isEmpty;

    public StoresReqBean() {
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getIsApp() {
        return isApp;
    }

    public void setIsApp(int isApp) {
        this.isApp = isApp;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(Integer isEmpty) {
        this.isEmpty = isEmpty;
    }
}
