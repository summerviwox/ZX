package com.siweisoft.heavycenter.module.acct.regist;

//by summer on 2017-12-14.

import android.content.Context;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.util.MD5Util;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.acct.code.CodeReqBean;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginReqBean;
import com.siweisoft.heavycenter.data.netd.acct.regist.RegistReqBean;
import com.siweisoft.heavycenter.databinding.FragAcctRegistBinding;

import cn.jpush.android.api.JPushInterface;

public class RegistUIOpe extends AppUIOpe<FragAcctRegistBinding> {

    RegistReqBean registReqBean = new RegistReqBean();

    CodeReqBean codeReqBean = new CodeReqBean();

    LoginReqBean loginReqBean = new LoginReqBean();



    public void initUI() {
        bind.code.getCodeText().setOnClickListener(getFrag());
        bind.tvRead.getCheckIV().setSelected(true);
    }

    public boolean is都输入好了(){
        if(NullUtil.isStrEmpty(bind.phone.getText())){
            ToastUtil.getInstance().showShort(getActivity(),"请输入手机号");
            return false;
        }
        if(bind.phone.getText().length()!=11){
            ToastUtil.getInstance().showShort(getActivity(),"手机号格式不正确");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.code.getText().toString())){
            ToastUtil.getInstance().showShort(getActivity(),"请输入验证码");
            return false;
        }

        if(!bind.pwd.getText().toString().equals(bind.repwd.getText().toString())){
            ToastUtil.getInstance().showShort(getActivity(),"密码不一致");
            return false;
        }
        if(bind.pwd.getText().toString().length()<6 || bind.pwd.getText().toString().length()>18){
            ToastUtil.getInstance().showShort(getActivity(),"密码为6-18位数字和字母");
            return false;
        }
        if(!bind.tvRead.getCheckIV().isSelected()){
            ToastUtil.getInstance().showShort(getActivity(),"请同意协议");
            return false;
        }
        return true;
    }

    public boolean is可以点击验证码(){
        if(NullUtil.isStrEmpty(bind.phone.getText())){
            ToastUtil.getInstance().showShort(getActivity(),"请输入手机号");
            return false;
        }
        if(bind.phone.getText().length()!=11){
            ToastUtil.getInstance().showShort(getActivity(),"手机号格式不正确");
            return false;
        }
        return true;
    }

    public RegistReqBean getRegistReqBean() {
        registReqBean.setUserName(bind.phone.getText().toString());
        registReqBean.setTel(bind.phone.getText().toString());
        registReqBean.setPassWord(MD5Util.md5(bind.pwd.getText().toString()));
        registReqBean.setSecurityCode(bind.code.getText().toString());
        return registReqBean;
    }

    public CodeReqBean getCodeReqBean() {
        codeReqBean.setTel(bind.phone.getText().toString());
        codeReqBean.setType("1");
        return codeReqBean;
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
