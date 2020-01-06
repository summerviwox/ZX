package com.siweisoft.heavycenter.data.netd.acct.login;

//by summer on 2018-01-09.

import com.android.lib.bean.BaseBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;

import java.util.ArrayList;
import java.util.List;

public class LoginResBean extends BaseBean {


    /**
     * userId : 140
     * passWord : e10adc3949ba59abbe56e057f20f883e
     * tel : 18721607419
     * trueName : 唐杰
     * userPhoto :
     * companyId : 32
     * bindCompanyState : 2
     * bindCompanyTime : 1515663494000
     * companyName : huluwaCompany3
     * abbreviationName : hulu3
     * userType : 2
     * deviceType : 1
     * deviceId : 1104a89792ac1fc2d38
     * userRole : admin
     * loginStatus : 1
     * wareHouseCount : 2
     * productCount : 4
     * userCount : 8
     * vehicleCount : 7
     * branchCompanyList : [{"branchId":35,"companyName":"huluwaCompany6","abbreviationName":"hulu6"},{"branchId":32,"companyName":"huluwaCompany3","abbreviationName":"hulu3"},{"branchId":34,"companyName":"huluwaCompany5","abbreviationName":"hulu5"},{"branchId":36,"companyName":"huluwaCompany7","abbreviationName":"huluwa7"}]
     */


    public static final String USER_ROLE_DRIVER = "driver";

    public static final String USER_ROLE_SUPER_ADMIN = "superAdmin";

    public static final String USER_ROLE_ADMIN = "admin";

    public static final String USER_ROLE_GENERAL = "general";

    public static final String USER_ROLE_SYS_ADMIN = "sysAdmin";

    public static final String USER_ROLE_DRIVER_CN = "驾驶员";

    public static final String USER_ROLE_SUPER_ADMIN_CN = "超级管理员";

    public static final String USER_ROLE_ADMIN_CN = "管理员";

    public static final String USER_ROLE_GENERAL_CN = "普通用户";

    public static final String USER_ROLE_SYS_ADMIN_CN = "系统管理员";

    public static final int BIND_UNIT_STATE_UNBIND = 0;

    public static final int BIND_UNIT_STATE_CHECK = 1;

    public static final int BIND_UNIT_STATE_BINDED = 2;

    public static final int BIND_UNIT_STATE_REJECT = 3;

    public static final int 已解绑 = 4;

    public static final String BIND_UNIT_STATE_UNBIND_CN = "未绑定";

    public static final String BIND_UNIT_STATE_CHECK_CN = "审核中";

    public static final String BIND_UNIT_STATE_BINDED_CN = "已绑定";

    public static final String BIND_UNIT_STATE_REJECT_CN = "绑定失败";


    public static final String BIND_UNIT_STATE_已解绑_CN = "已解绑";

    private int userId;
    private String passWord;
    private String tel;
    private String trueName;
    private String userPhoto;
    private int companyId;
    private int bindCompanyState;
    private Long bindCompanyTime;
    private String companyName;
    private String abbreviationName;
    private int userType;
    private int deviceType;
    private String deviceId;
    private String userRole = USER_ROLE_GENERAL;
    private int loginStatus;
    private int wareHouseCount;
    private int productCount;
    private int userCount;
    private int vehicleCount;
    private ArrayList<BranchCompanyListBean> branchCompanyList = new ArrayList<>();
    private String carLat;
    private String carLng;
    private String carBrand;
    private float emptyWeight;
    private float maxCapacity;
    private String vehicleLicensePhoto;
    private String vehiclePhoto;
    private String vehicleLicense;
    private String carLicenseNo;
    private String icCard;
    private String userIcCard;
    private int vehicleId;
    private String driverNoPhoto;
    private String driverNo;


    public Long getBindCompanyTime() {
        return bindCompanyTime;
    }

    public void setBindCompanyTime(Long bindCompanyTime) {
        this.bindCompanyTime = bindCompanyTime;
    }

    public boolean is驾驶员(){
        if(getUserType()==UserTypeReqBean.驾驶员){
            return true;
        }
        return false;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getBindCompanyState() {
        return bindCompanyState;
    }

    public void setBindCompanyState(int bindCompanyState) {
        this.bindCompanyState = bindCompanyState;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAbbreviationName() {
        return abbreviationName;
    }

    public void setAbbreviationName(String abbreviationName) {
        this.abbreviationName = abbreviationName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getWareHouseCount() {
        return wareHouseCount;
    }

    public void setWareHouseCount(int wareHouseCount) {
        this.wareHouseCount = wareHouseCount;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public void setVehicleCount(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    public ArrayList<BranchCompanyListBean> getBranchCompanyList() {
        return branchCompanyList;
    }

    public void setBranchCompanyList(ArrayList<BranchCompanyListBean> branchCompanyList) {
        this.branchCompanyList = branchCompanyList;
    }

    public String getCarLat() {
        return carLat;
    }

    public void setCarLat(String carLat) {
        this.carLat = carLat;
    }

    public String getCarLng() {
        return carLng;
    }

    public void setCarLng(String carLng) {
        this.carLng = carLng;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public float getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(float emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public float getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(float maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getCarLicenseNo() {
        return carLicenseNo;
    }

    public void setCarLicenseNo(String carLicenseNo) {
        this.carLicenseNo = carLicenseNo;
    }

    public String getIcCard() {
        return icCard;
    }

    public void setIcCard(String icCard) {
        this.icCard = icCard;
    }

    public String getDriverNoPhoto() {
        return driverNoPhoto;
    }

    public void setDriverNoPhoto(String driverNoPhoto) {
        this.driverNoPhoto = driverNoPhoto;
    }

    public String getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
    }


    public String getVehicleLicensePhoto() {
        return vehicleLicensePhoto;
    }

    public void setVehicleLicensePhoto(String vehicleLicensePhoto) {
        this.vehicleLicensePhoto = vehicleLicensePhoto;
    }

    public String getVehiclePhoto() {
        return vehiclePhoto;
    }

    public void setVehiclePhoto(String vehiclePhoto) {
        this.vehiclePhoto = vehiclePhoto;
    }

    public String getVehicleLicense() {
        return vehicleLicense;
    }

    public void setVehicleLicense(String vehicleLicense) {
        this.vehicleLicense = vehicleLicense;
    }

    public String getUserIcCard() {
        return userIcCard;
    }

    public void setUserIcCard(String userIcCard) {
        this.userIcCard = userIcCard;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public boolean is选择了角色(){
        if(getUserType()== UserTypeReqBean.驾驶员 || getUserType()== UserTypeReqBean.非驾驶员){
            return true;
        }
        return false;
    }

    public static class BranchCompanyListBean extends BaseBean{
        /**
         * branchId : 35
         * companyName : huluwaCompany6
         * abbreviationName : hulu6
         */

        private int branchId;
        private String companyName;
        private String abbreviationName;

        public int getBranchId() {
            return branchId;
        }

        public void setBranchId(int branchId) {
            this.branchId = branchId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getAbbreviationName() {
            return abbreviationName;
        }

        public void setAbbreviationName(String abbreviationName) {
            this.abbreviationName = abbreviationName;
        }
    }
}
