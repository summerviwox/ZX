package com.siweisoft.heavycenter.module.upunit;

//by summer on 2017-12-18.

import com.android.lib.base.ope.BaseDAOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;

import java.util.ArrayList;

public class TitleTipDAOpe extends BaseDAOpe {


    private ArrayList< LoginResBean.BranchCompanyListBean> coms;

    public ArrayList<LoginResBean.BranchCompanyListBean> getComs() {
        return coms;
    }

    public void setComs(ArrayList<LoginResBean.BranchCompanyListBean> coms) {
        this.coms = coms;
    }
}
