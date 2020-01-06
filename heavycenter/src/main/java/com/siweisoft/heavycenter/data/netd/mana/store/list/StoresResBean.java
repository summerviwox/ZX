package com.siweisoft.heavycenter.data.netd.mana.store.list;

//by summer on 2018-01-11.

import com.android.lib.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

public class StoresResBean extends BaseBean {


    /**
     * totalCount : 1
     * pageIndex : -1000
     * pageCount : 1
     * pageSize : 1000
     * results : [{"locate":"","warehouseId":93,"companyName":"qwe","maxStock":250,"productMaxStock":0.1,"productMinStock":0.1,"currentStock":0.1,"warehouseName":"仓库1","specifications":"","productName":"","minStock":100.6,"status":1}]
     */

    private int totalCount;
    private int pageIndex;
    private int pageCount;
    private int pageSize;
    private List<StoreDetail> results = new ArrayList<>();

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

    public List<StoreDetail> getResults() {
        return results;
    }

    public void setResults(List<StoreDetail> results) {
        this.results = results;
    }


}
