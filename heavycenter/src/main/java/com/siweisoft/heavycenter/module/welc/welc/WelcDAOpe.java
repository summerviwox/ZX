package com.siweisoft.heavycenter.module.welc.welc;

//by summer on 2017-12-14.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginReqBean;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.user.info.UserInfoReqBean;

public class WelcDAOpe extends AppDAOpe {



    public void get用户信息(NetI<LoginResBean> adapter){
        UserInfoReqBean userInfoReqBean = new UserInfoReqBean();
        userInfoReqBean.setId(LocalValue.get登录返回信息().getUserId());
        NetDataOpe.User.get用户信息(getActivity(),userInfoReqBean,adapter);
    }

    public void go登录(NetI<LoginResBean> adapter){
        NetDataOpe.onLogin(getActivity(),LocalValue.get登录参数(),adapter);
    }

    public void initWeightDA(){

    }

}
