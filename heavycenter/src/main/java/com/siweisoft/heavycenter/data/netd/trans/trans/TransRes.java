package com.siweisoft.heavycenter.data.netd.trans.trans;

//by summer on 2018-01-18.

import com.android.lib.bean.BaseBean;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailRes;

import java.util.ArrayList;
import java.util.List;

public class TransRes extends BaseBean {


    /**
     * totalCount : 26
     * pageIndex : -10
     * pageCount : 0
     * pageSize : 10
     * results : [{"orderType":"S","ShTime":123456799,"receiveCompanyName":"","signStatus":0,"totalSuttle":0,"specifications":"一级灰细度(8-12)","userId":81,"develiverCompanyName":"","productName":"粉煤灰","carLicenseNo":"沪A00000","planNumber":500,"carNumber":"","trueName":"驾驶员B","ordersId":20,"develiverNum":"","tel":"18721504444","transportrecordId":18,"receiveNum":"","FhTime":""}]
     */

    private int totalCount;
    private int pageIndex;
    private int pageCount;
    private int pageSize;
    private List<TransDetailRes> results = new ArrayList<>();

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<TransDetailRes> getResults() {
        return results;
    }

    public void setResults(List<TransDetailRes> results) {
        this.results = results;
    }
}
