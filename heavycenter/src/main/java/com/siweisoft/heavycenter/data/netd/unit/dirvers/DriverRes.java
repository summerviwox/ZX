package com.siweisoft.heavycenter.data.netd.unit.dirvers;

//by summer on 2018-02-01.

import com.android.lib.bean.BaseBean;

public class DriverRes extends BaseBean {


    /**
     * userId : 90
     * trueName : 18721609999
     * tel : 18721609999
     * isCurrentDriver : 0
     */

    private int userId;
    private String trueName;
    private String tel;
    private int isCurrentDriver;

    public static int 是当前驾驶员 = 1;

    public static int 不当前驾驶员 = 0;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getIsCurrentDriver() {
        return isCurrentDriver;
    }

    public void setIsCurrentDriver(int isCurrentDriver) {
        this.isCurrentDriver = isCurrentDriver;
    }
}
