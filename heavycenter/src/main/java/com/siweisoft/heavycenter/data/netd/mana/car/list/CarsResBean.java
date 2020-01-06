package com.siweisoft.heavycenter.data.netd.mana.car.list;

//by summer on 2018-01-11.

import com.android.lib.bean.BaseBean;
import com.android.lib.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class CarsResBean extends BaseBean {


    /**
     * totalCount : 7
     * pageIndex : -1000
     * pageCount : 1
     * pageSize : 1000
     * results : [{"vehicleId":18,"carLicenseNo":"沪A22224","specifications":"","currentDriver":0,"carBrand":"900","maxCapacity":1000,"emptyWeight":1000,"icCard":"3000","status":1,"trueName":null,"tel":"","companyId":32,"companyName":"huluwaCompany3"}]
     */

    private int totalCount;
    private int pageIndex;
    private int pageCount;
    private int pageSize;
    private int fhCount;
    private int myCount;
    private int shCount;
    private List<CarInfoRes> results = new ArrayList<>();

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<CarInfoRes> getResults() {
        return results;
    }

    public void setResults(List<CarInfoRes> results) {
        this.results = results;
    }

    public int getFhCount() {
        return fhCount;
    }

    public void setFhCount(int fhCount) {
        this.fhCount = fhCount;
    }

    public int getMyCount() {
        return myCount;
    }

    public void setMyCount(int myCount) {
        this.myCount = myCount;
    }

    public int getShCount() {
        return shCount;
    }

    public void setShCount(int shCount) {
        this.shCount = shCount;
    }

    public static class CarInfoRes extends BaseBean{
        /**
         * vehicleId : 18
         * carLicenseNo : 沪A22224
         * specifications :
         * currentDriver : 0
         * carBrand : 900
         * maxCapacity : 1000
         * emptyWeight : 1000
         * icCard : 3000
         * status : 1
         * trueName : null
         * tel :
         * companyId : 32
         * companyName : huluwaCompany3
         */

        public static final int STATUS_ON = 1;

        public static final int STATUS_OFF = 0;

        public static final String STATUS_ON_CN = "启用";

        public static final String STATUS_OFF_CN = "停用";

        private int vehicleId = -1;
        private String vehicleLicense;
        private String carLicenseNo;
        private String specifications;
        private String carBrand;
        private String vehiclePhoto;
        private String vehicleLicensePhoto;
        private int maxCapacity;
        private int emptyWeight;
        private int creater;
        private double carLng;
        private double carLat;
        private int currentDriver;
        private String icCard;
        private int status;
        private String trueName;
        private String tel;
        private int companyId;
        private String companyName;


        public int getVehicleId() {
            return vehicleId;
        }

        public void setVehicleId(int vehicleId) {
            this.vehicleId = vehicleId;
        }

        public String getCarLicenseNo() {
            return carLicenseNo;
        }

        public void setCarLicenseNo(String carLicenseNo) {
            this.carLicenseNo = carLicenseNo;
        }

        public String getSpecifications() {
            return specifications;
        }

        public void setSpecifications(String specifications) {
            this.specifications = specifications;
        }

        public int getCurrentDriver() {
            return currentDriver;
        }

        public void setCurrentDriver(int currentDriver) {
            this.currentDriver = currentDriver;
        }

        public String getCarBrand() {
            return carBrand;
        }

        public void setCarBrand(String carBrand) {
            this.carBrand = carBrand;
        }

        public int getMaxCapacity() {
            return maxCapacity;
        }

        public void setMaxCapacity(int maxCapacity) {
            this.maxCapacity = maxCapacity;
        }

        public int getEmptyWeight() {
            return emptyWeight;
        }

        public void setEmptyWeight(int emptyWeight) {
            this.emptyWeight = emptyWeight;
        }

        public String getIcCard() {
            return icCard;
        }

        public void setIcCard(String icCard) {
            this.icCard = icCard;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTrueName() {
            return trueName;
        }

        public String getTrueNameCN() {
            return "驾驶员:"+StringUtil.getStr(trueName);
        }

        public void setTrueName(String trueName) {
            this.trueName = trueName;
        }

        public String getTel() {
            return tel;
        }

        public String getTelCN() {
            return "联系电话:"+StringUtil.getStr(tel);
        }
        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getVehicleLicense() {
            return vehicleLicense;
        }

        public void setVehicleLicense(String vehicleLicense) {
            this.vehicleLicense = vehicleLicense;
        }

        public String getVehiclePhoto() {
            return vehiclePhoto;
        }

        public void setVehiclePhoto(String vehiclePhoto) {
            this.vehiclePhoto = vehiclePhoto;
        }

        public String getVehicleLicensePhoto() {
            return vehicleLicensePhoto;
        }

        public void setVehicleLicensePhoto(String vehicleLicensePhoto) {
            this.vehicleLicensePhoto = vehicleLicensePhoto;
        }

        public int getCreater() {
            return creater;
        }

        public void setCreater(int creater) {
            this.creater = creater;
        }

        public double getCarLng() {
            return carLng;
        }

        public void setCarLng(double carLng) {
            this.carLng = carLng;
        }

        public double getCarLat() {
            return carLat;
        }

        public void setCarLat(double carLat) {
            this.carLat = carLat;
        }
    }
}
