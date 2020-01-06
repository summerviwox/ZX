package com.siweisoft.heavycenter.module.mana.user.news;

//by summer on 2017-12-19.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.locd.scan.user.UserInfo;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.mana.user.add.AddUserReqBean;
import com.siweisoft.heavycenter.data.netd.mana.user.add.AddUserResBean;
import com.siweisoft.heavycenter.data.netd.user.info.UserInfoReqBean;
import com.siweisoft.heavycenter.data.netd.user.userrole.UserRoleReq;
import com.siweisoft.heavycenter.data.netd.user.userrole.UserRoleRes;

public class NewDAOpe extends AppDAOpe {

    AddUserReqBean reqBean = new AddUserReqBean();

    private LoginResBean userInfo;

    public void addUser(AddUserReqBean reqBean, NetI<AddUserResBean> adapter){
        NetDataOpe.Mana.User.addUser(getActivity(),reqBean,adapter);
    }

    public static void setUserRole(Context context, int id,String role,NetI<UserRoleRes> adapter){
        UserRoleReq userRoleReq = new UserRoleReq();
        userRoleReq.setId(id);
        userRoleReq.setUserId(LocalValue.get登录返回信息().getUserId());
        userRoleReq.setUserRole(role);
        NetDataOpe.User.setUserRole(context,userRoleReq,adapter);
    }

    public AddUserReqBean getReqBean() {
        reqBean.setUserId(LocalValue.get登录返回信息().getUserId());
        reqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        return reqBean;
    }
    public static void getUserInfo(int id,Context context, NetI<LoginResBean> adapter){
        UserInfoReqBean userInfoReqBean = new UserInfoReqBean();
        userInfoReqBean.setId(id);
        NetDataOpe.User.get用户信息(context,userInfoReqBean,adapter);
    }

    public LoginResBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(LoginResBean userInfo) {
        this.userInfo = userInfo;
    }
}
