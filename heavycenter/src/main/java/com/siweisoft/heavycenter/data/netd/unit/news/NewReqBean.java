package com.siweisoft.heavycenter.data.netd.unit.news;

//by summer on 2018-01-10.

import com.android.lib.network.bean.req.BaseReqBean;

public class NewReqBean extends BaseReqBean {

    private String abbreviationName;

    private String companyName;

    private String companyAddress;

    private String companyLng;

    private String companyLat;

    private String contactName;

    private String contactPhone;

    private int highCompany = -1;

    private Integer creater;

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


    public String getBelongArea() {
        return belongArea;
    }

    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }
}
