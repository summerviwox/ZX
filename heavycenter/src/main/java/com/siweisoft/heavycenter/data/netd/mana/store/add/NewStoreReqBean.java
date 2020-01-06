package com.siweisoft.heavycenter.data.netd.mana.store.add;

//by summer on 2018-01-16.

import com.android.lib.network.bean.req.BaseReqBean;

public class NewStoreReqBean extends BaseReqBean {


    private int companyId;

    private String warehouseName;

    private float maxStock;

    private float minStock;

    private String locate;

    public NewStoreReqBean() {
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
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

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }
}
