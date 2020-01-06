package com.siweisoft.heavycenter.module.test;

import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by summer on 2018/1/29 20:29.
 */

public class Test {


    public void testData(){
        LoginResBean loginResBean = new LoginResBean();
        loginResBean.setAbbreviationName("公司简称");
        loginResBean.setBindCompanyState(LoginResBean.BIND_UNIT_STATE_BINDED);
        loginResBean.setBindCompanyTime(System.currentTimeMillis());

        ArrayList<LoginResBean.BranchCompanyListBean> branchCompanyList = new ArrayList<>();
        LoginResBean.BranchCompanyListBean branchCompanyListBean = new LoginResBean.BranchCompanyListBean();
        branchCompanyListBean.setAbbreviationName("公司简称");
        branchCompanyListBean.setBranchId(40);
        branchCompanyListBean.setCompanyName("id为40的公司");
        branchCompanyList.add(branchCompanyListBean);
        loginResBean.setBranchCompanyList(branchCompanyList);
        loginResBean.setCompanyId(40);
        loginResBean.setCompanyName("公司名称");
        loginResBean.setDeviceId("fdjfoewhgiehgoir");
        loginResBean.setDeviceType(1);
        loginResBean.setLoginStatus(1);
        loginResBean.setPassWord("123456");
        loginResBean.setProductCount(10);
        loginResBean.setTel("18721607438");
        loginResBean.setTrueName("唐杰");
        loginResBean.setUserCount(10);
        loginResBean.setUserId(150);
        loginResBean.setUserPhoto("1747494443");
        loginResBean.setUserRole(LoginResBean.USER_ROLE_ADMIN);
        loginResBean.setUserType(UserTypeReqBean.非驾驶员);
        loginResBean.setVehicleCount(10);
        loginResBean.setWareHouseCount(10);
        LocalValue.save登录返回信息(loginResBean);
    }
}
