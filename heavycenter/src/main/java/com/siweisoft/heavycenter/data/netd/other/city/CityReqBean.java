package com.siweisoft.heavycenter.data.netd.other.city;

//by summer on 2018-01-10.

        import com.android.lib.network.bean.req.BaseReqBean;

public class CityReqBean extends BaseReqBean {

    private int isApp=1;

    public int getIsApp() {
        return isApp;
    }

    public void setIsApp(int isApp) {
        this.isApp = isApp;
    }
}
