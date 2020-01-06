package com.siweisoft.heavycenter.data.netd.mana.good.upd;

//by summer on 2018-01-30.

import com.android.lib.network.bean.req.BaseReqBean;

public class UpdGoodReq extends BaseReqBean {

    private float maxStock;

    private float minStock;

    private String belongArea;

    private int warehouseId;

    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
