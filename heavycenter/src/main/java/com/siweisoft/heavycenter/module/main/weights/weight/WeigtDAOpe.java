package com.siweisoft.heavycenter.module.main.weights.weight;

//by summer on 2017-12-11.

import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.jpush.WeightMsg;

public class WeigtDAOpe extends AppDAOpe {


    WeightMsg weightMsg = new WeightMsg();

    LoginResBean loginResBean = new LoginResBean();


    public WeightMsg getWeightMsg() {
        return weightMsg;
    }

    public void setWeightMsg(WeightMsg weightMsg) {
        this.weightMsg = weightMsg;
    }

    public LoginResBean getLoginResBean() {
        return loginResBean;
    }

    public void setLoginResBean(LoginResBean loginResBean) {
        this.loginResBean = loginResBean;
    }
}
