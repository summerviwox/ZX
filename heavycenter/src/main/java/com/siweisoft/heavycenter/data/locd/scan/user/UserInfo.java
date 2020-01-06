package com.siweisoft.heavycenter.data.locd.scan.user;

//by summer on 2018-01-25.

import com.android.lib.bean.BaseBean;

public class UserInfo extends BaseBean{


    public static final String  TYPE_USER = "HCUser";

    public static final String  TYPE_UNIT = "HCCompany";

    public static final String  TYPE_WEIGHT = "HCBridge";

    public static final String  TYPE_STORE = "HCStore";

    private String Type;

    private int ID;

    private String Name;

    private String Mobile;

    private String CompanyID;

    private String No;

    private String Locate;


    public UserInfo() {
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(String companyID) {
        CompanyID = companyID;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getLocate() {
        return Locate;
    }

    public void setLocate(String locate) {
        Locate = locate;
    }
}
