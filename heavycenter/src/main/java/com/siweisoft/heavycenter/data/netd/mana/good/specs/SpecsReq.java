package com.siweisoft.heavycenter.data.netd.mana.good.specs;

//by summer on 2018-01-17.

import com.android.lib.network.bean.req.BaseReqBean;

public class SpecsReq extends BaseReqBean {

    private int productId;

    private int isApp;

    public SpecsReq() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getIsApp() {
        return isApp;
    }

    public void setIsApp(int isApp) {
        this.isApp = isApp;
    }
}
