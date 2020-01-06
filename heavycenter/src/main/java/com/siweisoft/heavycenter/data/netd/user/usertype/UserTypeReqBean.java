package com.siweisoft.heavycenter.data.netd.user.usertype;

//by summer on 2018-01-10.

import com.android.lib.network.bean.req.BaseReqBean;
//设置用户类型
public class UserTypeReqBean extends BaseReqBean {

    private int id;

    public static final int USER_TYPE_NULL = 0;

    public static final int 驾驶员 = 1;

    public static final int 非驾驶员 = 2;

    public static final String USER_TYPE_DRIVER_CN = "驾驶员";

    public static final String USER_TYPE_GENERAL_CN = "普通用户";


    private int userType;

    public UserTypeReqBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
