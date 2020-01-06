package com.siweisoft.heavycenter.module.scan;

//by summer on 2018-01-25.

import com.android.lib.bean.BaseBean;

public class ScanBean extends BaseBean {

    private int code;

    private String pageName;

    public ScanBean() {
    }

    public ScanBean(int code, String pageName) {
        this.code = code;
        this.pageName = pageName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
}
