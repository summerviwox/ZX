package com.siweisoft.heavycenter.data.netd.mana.car.list;

//by summer on 2018-01-11.

import com.android.lib.network.bean.req.BaseReqBean;

public class CarsReqBean extends BaseReqBean {




    public static final String WHAT_MY = "MY";

    public static final String WHAT_FH = "FH";

    public static final String WHAT_SH = "SH";





    private int isApp;

    private int companyId;

    private int pageIndex;

    private int pageSize;

    private String what;

    private Integer status;


    public CarsReqBean() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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


    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }
}
