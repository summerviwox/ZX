package com.siweisoft.heavycenter.data.netd.unit.historysh;

//by summer on 2018-03-02.

import com.android.lib.network.bean.req.BaseReqBean;

public class HistoryShUnitReq extends BaseReqBean {

    private int companyId;


    private String keyword;

    private int pageIndex;

    private int pageSize;

    private String address;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
