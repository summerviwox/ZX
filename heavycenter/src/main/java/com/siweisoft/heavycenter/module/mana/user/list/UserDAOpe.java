package com.siweisoft.heavycenter.module.mana.user.list;

//by summer on 2017-12-14.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.mana.user.add.AddUserReqBean;
import com.siweisoft.heavycenter.data.netd.mana.user.add.AddUserResBean;
import com.siweisoft.heavycenter.data.netd.unit.user.UnitUserResBean;
import com.siweisoft.heavycenter.data.netd.unit.user.UnitUsersReqBean;
import com.siweisoft.heavycenter.data.netd.user.unit.unbind.UnBindReqBean;
import com.siweisoft.heavycenter.data.netd.user.unit.unbind.UnBindResBean;
import com.siweisoft.heavycenter.data.netd.user.userrole.UserRoleReq;
import com.siweisoft.heavycenter.data.netd.user.userrole.UserRoleRes;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;

import java.util.ArrayList;

public class UserDAOpe extends AppDAOpe {

    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        for(int i=0;i<100;i++){
            data.add(""+i);
        }
        return data;
    }

    public void unitUsers(NetI<UnitUserResBean> adapter){
        UnitUsersReqBean reqBean = new UnitUsersReqBean();
        reqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        reqBean.setIsApp(1);
        reqBean.setPageIndex(0);
        reqBean.setPageSize(1000);
        NetDataOpe.Unit.unitUsers(getActivity(),reqBean,adapter);
    }

    public void addUser(UnitUserResBean.ResultsBean user, NetI<AddUserResBean> adapter){
        AddUserReqBean reqBean = new AddUserReqBean();
        reqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        reqBean.setUserId(user.getUserId());
        reqBean.setTel(user.getTel());
        reqBean.setUserRole(user.getUserRole());
        NetDataOpe.Mana.User.addUser(getActivity(),reqBean,adapter);
    }

    public void unBindUser(int userid, NetI<UnBindResBean> adapter){
        UnBindReqBean reqBean = new UnBindReqBean();
        reqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        reqBean.setId(userid);
        NetDataOpe.User.unBinUnit(getActivity(),reqBean,adapter);
    }

    public void setUserRole(int id, NetI<UserRoleRes> adapter){
        UserRoleReq userRoleReq = new UserRoleReq();
        userRoleReq.setId(id);
        userRoleReq.setUserRole(LoginResBean.USER_ROLE_SUPER_ADMIN);
        userRoleReq.setUserId(LocalValue.get登录返回信息().getUserId());
        NetDataOpe.User.setUserRole(getActivity(),userRoleReq,adapter);
    }

    public boolean canUnBind(UnitUserResBean.ResultsBean resultsBean){
        if(LocalValue.get登录返回信息().getUserId()==resultsBean.getUserId()){
            ToastUtil.getInstance().showShort(getActivity(),"不能解绑自己");
            return false;
        }
        return true;
    }

}
