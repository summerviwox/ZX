package com.siweisoft.heavycenter.data.netd.mana.good.detial;

//by summer on 2018-01-30.

import com.android.lib.network.bean.req.BaseReqBean;

public class GoodDetailReq extends BaseReqBean {

    private int productInfoId;

    public int getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(int productInfoId) {
        this.productInfoId = productInfoId;
    }
}
