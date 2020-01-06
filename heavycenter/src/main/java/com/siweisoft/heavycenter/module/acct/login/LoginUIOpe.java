package com.siweisoft.heavycenter.module.acct.login;

//by summer on 2017-12-14.

import android.content.Context;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.util.MD5Util;
import com.android.lib.util.NullUtil;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginReqBean;
import com.siweisoft.heavycenter.databinding.FragAcctLoginBinding;

import cn.jpush.android.api.JPushInterface;

public class LoginUIOpe extends AppUIOpe<FragAcctLoginBinding> {

    LoginReqBean loginReqBean = new LoginReqBean();


    public void initUI() {
        bind.phone.getEditText().setText(LocalValue.get登录参数()==null?"":LocalValue.get登录参数().getTel());
        bind.pwd.getEditText().setText(LocalValue.get登录参数()==null?"":LocalValue.get登录参数().getInputPwd());
    }

    public boolean is输入完全(){
        if(NullUtil.isStrEmpty(bind.phone.getText().toLowerCase())){
            ToastUtil.getInstance().showShort(getActivity(),"手机号不能为空");
            return false;
        }

        if(NullUtil.isStrEmpty(bind.pwd.getText().toLowerCase())){
            ToastUtil.getInstance().showShort(getActivity(),"密码不能为空");
            return false;
        }
        return true;
    }

    public LoginReqBean getLoginReqBean() {
        loginReqBean.setIdentityType(1);
        loginReqBean.setTel(bind.phone.getText().toString());
        loginReqBean.setPassWord(MD5Util.md5(bind.pwd.getText().toString()));
        loginReqBean.setInputPwd(bind.pwd.getText().toString());
        loginReqBean.setDeviceId(JPushInterface.getRegistrationID(getActivity()));
        loginReqBean.setDeviceType(1);
        return loginReqBean;
    }
}
