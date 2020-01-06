package com.siweisoft.heavycenter.data.netd.acct.regist;

//by summer on 2018-01-09.

import com.android.lib.network.bean.req.BaseReqBean;

public class RegistReqBean extends BaseReqBean {

    public static final int IDENTITY_TYPE_PHONE = 1;

    public static final int IDENTITY_TYPE_QQ = 2;

    public static final int IDENTITY_TYPE_WEIXIN = 3;

    public static final int IDENTITY_TYPE_WEIBO = 4;



    private int identityType;

    private String tel;

    private String passWord;

    private String userName;

    private int identifier;

    private String securityCode;

    public RegistReqBean() {
    }

    public int getIdentityType() {
        return identityType;
    }

    public void setIdentityType(int identityType) {
        this.identityType = identityType;
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


    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
