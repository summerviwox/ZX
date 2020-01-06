package com.siweisoft.heavycenter.data.netd.mana.good.names;

//by summer on 2018-01-17.

import com.android.lib.network.bean.req.BaseReqBean;

public class NamesReq extends BaseReqBean {

    private int pageIndex;

    private int pageSize;

    public NamesReq() {
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
