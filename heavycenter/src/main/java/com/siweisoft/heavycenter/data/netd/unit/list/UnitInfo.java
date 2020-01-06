package com.siweisoft.heavycenter.data.netd.unit.list;

import com.android.lib.bean.BaseBean;

public class UnitInfo extends BaseBean {
        /**
         * businessLicense :
         * belongArea : 210000
         * companyName : huluwaCompany7
         * remark :
         * editTime :
         * companyUrl :
         * companyLng : 0
         * highCompany : 32
         * creditLevel :
         * companyPropery :
         * companyFax :
         * id : 36
         * companyLat : 0
         * abbreviationName : huluwa7
         * companyType : 0
         * contactId : 0
         * contactName : huluwa
         * companyStatus : 0
         * postcode :
         * taxRegistration :
         * yhNum : 1
         * organizationCode :
         * createTime : 1515492446000
         * companyAddress : 国和路与清源环路交叉口东南50米
         * creater : 111
         * companyPostbox :
         * editer : 0
         * contactPhone : 13000000000
         * cpNum : 0
         * isMarket : 0
         * status : 1
         */

        protected String businessLicense;
        protected String belongArea;
        protected String belongAreaDes;
        protected String belongAreaNo;
        protected String companyName;
        protected String remark;
        protected String editTime;
        protected String companyUrl;
        protected double companyLng;
        protected int highCompany;
        protected String creditLevel;
        protected String companyPropery;
        protected String companyFax;
        protected int id;
        protected double companyLat;
        protected String abbreviationName;
        protected int companyType;
        protected int contactId;
        protected String contactName;
        protected String companyStatus;
        protected String postcode;
        protected String taxRegistration;
        protected int yhNum;
        protected String organizationCode;
        protected long createTime;
        protected String companyAddress;
        protected int creater;
        protected String companyPostbox;
        protected int editer;
        protected String contactPhone;
        protected int cpNum;
        protected int isMarket;
        protected int status;
        protected int parentCompanyId =-1;
        protected String parentCompanyName;
        protected int companyIsNull;
        private int companyId;

        public static final int COMPANY_NULL = 0;

        public static final int COMPANY_EXSIT = 1;

        public int getTrueComId(){
            if(id==0){
                return companyId;
            }
            return id;
        }

    public String getBelongAreaNo() {
        return belongAreaNo;
    }

    public void setBelongAreaNo(String belongAreaNo) {
        this.belongAreaNo = belongAreaNo;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getBusinessLicense() {
            return businessLicense;
        }

        public void setBusinessLicense(String businessLicense) {
            this.businessLicense = businessLicense;
        }

        public String getBelongArea() {
            return belongArea;
        }

        public void setBelongArea(String belongArea) {
            this.belongArea = belongArea;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getEditTime() {
            return editTime;
        }

        public void setEditTime(String editTime) {
            this.editTime = editTime;
        }

        public String getCompanyUrl() {
            return companyUrl;
        }

        public void setCompanyUrl(String companyUrl) {
            this.companyUrl = companyUrl;
        }


        public int getHighCompany() {
            return highCompany;
        }

        public void setHighCompany(int highCompany) {
            this.highCompany = highCompany;
        }

        public String getCreditLevel() {
            return creditLevel;
        }

        public void setCreditLevel(String creditLevel) {
            this.creditLevel = creditLevel;
        }

        public String getCompanyPropery() {
            return companyPropery;
        }

        public void setCompanyPropery(String companyPropery) {
            this.companyPropery = companyPropery;
        }

        public String getCompanyFax() {
            return companyFax;
        }

        public void setCompanyFax(String companyFax) {
            this.companyFax = companyFax;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAbbreviationName() {
            return abbreviationName;
        }

        public void setAbbreviationName(String abbreviationName) {
            this.abbreviationName = abbreviationName;
        }

        public int getCompanyType() {
            return companyType;
        }

        public void setCompanyType(int companyType) {
            this.companyType = companyType;
        }

        public int getContactId() {
            return contactId;
        }

        public void setContactId(int contactId) {
            this.contactId = contactId;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getCompanyStatus() {
            return companyStatus;
        }

        public void setCompanyStatus(String companyStatus) {
            this.companyStatus = companyStatus;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getTaxRegistration() {
            return taxRegistration;
        }

        public void setTaxRegistration(String taxRegistration) {
            this.taxRegistration = taxRegistration;
        }

        public int getYhNum() {
            return yhNum;
        }

        public void setYhNum(int yhNum) {
            this.yhNum = yhNum;
        }

        public String getOrganizationCode() {
            return organizationCode;
        }

        public void setOrganizationCode(String organizationCode) {
            this.organizationCode = organizationCode;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getCompanyAddress() {
            return companyAddress;
        }

        public void setCompanyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
        }

        public int getCreater() {
            return creater;
        }

        public void setCreater(int creater) {
            this.creater = creater;
        }

        public String getCompanyPostbox() {
            return companyPostbox;
        }

        public void setCompanyPostbox(String companyPostbox) {
            this.companyPostbox = companyPostbox;
        }

        public int getEditer() {
            return editer;
        }

        public void setEditer(int editer) {
            this.editer = editer;
        }

        public String getContactPhone() {
            return contactPhone;
        }

        public void setContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
        }

        public int getCpNum() {
            return cpNum;
        }

        public void setCpNum(int cpNum) {
            this.cpNum = cpNum;
        }

        public int getIsMarket() {
            return isMarket;
        }

        public void setIsMarket(int isMarket) {
            this.isMarket = isMarket;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getParentCompanyId() {
            return parentCompanyId;
        }

        public void setParentCompanyId(int parentCompanyId) {
            this.parentCompanyId = parentCompanyId;
        }

        public String getParentCompanyName() {
            return parentCompanyName;
        }

        public void setParentCompanyName(String parentCompanyName) {
            this.parentCompanyName = parentCompanyName;
        }

    public int getCompanyIsNull() {
        return companyIsNull;
    }

    public void setCompanyIsNull(int companyIsNull) {
        this.companyIsNull = companyIsNull;
    }

    public String getBelongAreaDes() {
        return belongAreaDes;
    }

    public void setBelongAreaDes(String belongAreaDes) {
        this.belongAreaDes = belongAreaDes;
    }

    public double getCompanyLng() {
        return companyLng;
    }

    public void setCompanyLng(double companyLng) {
        this.companyLng = companyLng;
    }

    public double getCompanyLat() {
        return companyLat;
    }

    public void setCompanyLat(double companyLat) {
        this.companyLat = companyLat;
    }
}