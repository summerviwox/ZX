package com.siweisoft.heavycenter.data.netd.mana.store.list;

import com.android.lib.bean.BaseBean;

public class StoreDetail extends BaseBean {
    /**
     * locate :
     * warehouseId : 93
     * companyName : qwe
     * maxStock : 250
     * productMaxStock : 0.1
     * productMinStock : 0.1
     * currentStock : 0.1
     * warehouseName : 仓库1
     * specifications :
     * productName :
     * minStock : 100.6
     * status : 1
     */
    private String todayStorage;
    private String todayOutStorage;
    private String locate;
    private int warehouseId;
    private String companyName;
    private float maxStock;
    private float productMaxStock;
    private float productMinStock;
    private float currentStock;
    private float afterAdjust;
    private String warehouseName;
    private String specifications;
    private String productName;
    private int productId=-1;
    private float minStock;
    private int status;
    private String allProfitNum;
    private String todayProfitNum;

    public static final int STATUS_OFF = 0;

    public static final int STATUS_ON = 1;

    public static final String STATUS_OFF_CN = "禁用";

    public static final String STATUS_ON_CN = "启用";

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(float maxStock) {
        this.maxStock = maxStock;
    }

    public float getProductMaxStock() {
        return productMaxStock;
    }

    public void setProductMaxStock(float productMaxStock) {
        this.productMaxStock = productMaxStock;
    }

    public float getProductMinStock() {
        return productMinStock;
    }

    public void setProductMinStock(float productMinStock) {
        this.productMinStock = productMinStock;
    }

    public float getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(float currentStock) {
        this.currentStock = currentStock;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getMinStock() {
        return minStock;
    }

    public void setMinStock(float minStock) {
        this.minStock = minStock;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public float getAfterAdjust() {
        return afterAdjust;
    }

    public void setAfterAdjust(float afterAdjust) {
        this.afterAdjust = afterAdjust;
    }

    public String getTodayStorage() {
        return todayStorage;
    }

    public void setTodayStorage(String todayStorage) {
        this.todayStorage = todayStorage;
    }

    public String getTodayOutStorage() {
        return todayOutStorage;
    }

    public void setTodayOutStorage(String todayOutStorage) {
        this.todayOutStorage = todayOutStorage;
    }

    public String getAllProfitNum() {
        return allProfitNum;
    }

    public void setAllProfitNum(String allProfitNum) {
        this.allProfitNum = allProfitNum;
    }

    public String getTodayProfitNum() {
        return todayProfitNum;
    }

    public void setTodayProfitNum(String todayProfitNum) {
        this.todayProfitNum = todayProfitNum;
    }

    public static StoreDetail copyStoreDetail(StoreDetail storeDetail){
        StoreDetail data = new StoreDetail();
        data.setAfterAdjust(storeDetail.getAfterAdjust());
        data.setAllProfitNum(storeDetail.getAllProfitNum());
        data.setCompanyName(storeDetail.getCompanyName());
        data.setCurrentStock(storeDetail.getCurrentStock());
        data.setMaxStock(storeDetail.getMaxStock());
        data.setMinStock(storeDetail.getMinStock());
        data.setProductId(storeDetail.getProductId());
        data.setProductMaxStock(storeDetail.getProductMaxStock());
        data.setProductMinStock(storeDetail.getProductMinStock());
        data.setProductName(storeDetail.getProductName());
        data.setSpecifications(storeDetail.getSpecifications());
        data.setStatus(storeDetail.getStatus());
        data.setTodayOutStorage(storeDetail.getTodayOutStorage());
        data.setTodayProfitNum(storeDetail.getTodayProfitNum());
        data.setTodayStorage(storeDetail.getTodayStorage());
        data.setWarehouseId(storeDetail.getWarehouseId());
        data.setWarehouseName(storeDetail.getWarehouseName());
        return data;
    }
}