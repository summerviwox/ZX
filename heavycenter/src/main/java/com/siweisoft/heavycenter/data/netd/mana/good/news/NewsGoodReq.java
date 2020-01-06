package com.siweisoft.heavycenter.data.netd.mana.good.news;

//by summer on 2018-01-17.

import com.android.lib.network.bean.req.BaseReqBean;

public class NewsGoodReq extends BaseReqBean {

    private int companyId;

    private int materielId =-1;

    private int materielSpecId =-1;

    private String materielSpecName;

    private String materielName ;

    private float maxStock;

    private float minStock;

    private String belongArea;

    private String belongAreaName;

    private int warehouseId;

    private String warehouseName;

    public NewsGoodReq() {
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getMaterielId() {
        return materielId;
    }

    public void setMaterielId(int materielId) {
        this.materielId = materielId;
    }

    public int getMaterielSpecId() {
        return materielSpecId;
    }

    public void setMaterielSpecId(int materielSpecId) {
        this.materielSpecId = materielSpecId;
    }

    public float getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(float maxStock) {
        this.maxStock = maxStock;
    }

    public float getMinStock() {
        return minStock;
    }

    public void setMinStock(float minStock) {
        this.minStock = minStock;
    }

    public String getBelongArea() {
        return belongArea;
    }

    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getMaterielSpecName() {
        return materielSpecName;
    }

    public void setMaterielSpecName(String materielSpecName) {
        this.materielSpecName = materielSpecName;
    }

    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    public String getBelongAreaName() {
        return belongAreaName;
    }

    public void setBelongAreaName(String belongAreaName) {
        this.belongAreaName = belongAreaName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
