package com.siweisoft.heavycenter.data.netd.acct.login;

//by summer on 2018-01-09.

import com.android.lib.network.bean.req.BaseReqBean;

public class LoginReqBean extends BaseReqBean {

    private int identityType;

    private int identifier;

    private String tel;

    private String passWord;

    private String deviceId;

    private int deviceType;

    private String inputPwd;

    public LoginReqBean() {
    }

    public int getIdentityType() {
        return identityType;
    }

    public void setIdentityType(int identityType) {
        this.identityType = identityType;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getInputPwd() {
        return inputPwd;
    }

    public void setInputPwd(String inputPwd) {
        this.inputPwd = inputPwd;
    }
}
