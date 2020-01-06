package com.siweisoft.heavycenter.data.netd.user.unit.bind;

//by summer on 2018-01-11.

import com.android.lib.network.bean.req.BaseReqBean;

public class BindReqBean extends BaseReqBean{


    public static final int BIND_OPERATE_TYPE_SEARCH = 0;

    public static final int BIND_OPERATE_TYPE_MYSCAN = 1;

    public static final int BIND_OPERATE_TYPE_MANAGSCAN = 2;

    public static final int IS_MANAGER_YES = 1;

    public static final int IS_MANAGER_NO = 0;




    private int id;

    private int companyId;

    private int bindOperateType;

    private int isManager;

    private int mangerId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getBindOperateType() {
        return bindOperateType;
    }

    public void setBindOperateType(int bindOperateType) {
        this.bindOperateType = bindOperateType;
    }

    public int getIsManager() {
        return isManager;
    }

    public void setIsManager(int isManager) {
        this.isManager = isManager;
    }

    public int getMangerId() {
        return mangerId;
    }

    public void setMangerId(int mangerId) {
        this.mangerId = mangerId;
    }
}
