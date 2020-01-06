package com.siweisoft.heavycenter.data.netd.acct.logout;

//by summer on 2018-01-10.

import com.android.lib.network.bean.req.BaseReqBean;

public class LogOutReqBean extends BaseReqBean {

    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
