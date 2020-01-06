package com.siweisoft.heavycenter.data.netd.mana.store.check;

//by summer on 2018-01-16.

import com.android.lib.bean.BaseBean;
import com.android.lib.network.bean.req.BaseReqBean;

import java.util.ArrayList;

public class CheckStoreReqBean extends BaseReqBean {

    private int userId;

    private String wareHouseListString ;


    public CheckStoreReqBean() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getWareHouseListString() {
        return wareHouseListString;
    }

    public void setWareHouseListString(String wareHouseListString) {
        this.wareHouseListString = wareHouseListString;
    }
}
