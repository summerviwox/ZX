package com.siweisoft.heavycenter.data.netd.unit.update;

//by summer on 2018-02-06.

import com.android.lib.network.bean.req.BaseReqBean;

public class UpdateUnitReq extends BaseReqBean {

    private String abbreviationName;

    private String companyName;

    private int id;

    private String companyAddress;

    private String companyLng;

    private String companyLat;

    private String contactName;

    private String contactPhone;

    private int highCompany= -1;

    private int editer;

    private String belongArea;

    public String getAbbreviationName() {
        return abbreviationName;
    }

    public void setAbbreviationName(String abbreviationName) {
        this.abbreviationName = abbreviationName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyLng() {
        return companyLng;
    }

    public void setCompanyLng(String companyLng) {
        this.companyLng = companyLng;
    }

    public String getCompanyLat() {
        return companyLat;
    }

    public void setCompanyLat(String companyLat) {
        this.companyLat = companyLat;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public int getHighCompany() {
        return highCompany;
    }

    public void setHighCompany(int highCompany) {
        this.highCompany = highCompany;
    }

    public int getEditer() {
        return editer;
    }

    public void setEditer(int editer) {
        this.editer = editer;
    }

    public String getBelongArea() {
        return belongArea;
    }

    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea;
    }
}
