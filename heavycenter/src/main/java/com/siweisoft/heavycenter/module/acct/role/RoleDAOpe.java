package com.siweisoft.heavycenter.module.acct.role;

//by summer on 2017-12-18.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.acct.forget.ForGetReqBean;
import com.siweisoft.heavycenter.data.netd.acct.forget.ForGetResBean;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginReqBean;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeResBean;

public class RoleDAOpe extends AppDAOpe {



    public void setUserType(UserTypeReqBean reqBean, NetI<UserTypeResBean> adapter){
        NetDataOpe.setUserType(getActivity(), NetValue.获取地址("/user/setUserType"),reqBean,adapter);
    }

    public void login(LoginReqBean reqBean, NetI<LoginResBean> adapter){
        NetDataOpe.onLogin(getActivity(),reqBean,adapter);
    }
}
