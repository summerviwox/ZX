package com.siweisoft.heavycenter.data.netd.acct.code;

//by summer on 2018-01-09.

import com.android.lib.network.bean.req.BaseReqBean;

public class CodeReqBean extends BaseReqBean {

    private String tel;

    private String type;

    public CodeReqBean() {
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
