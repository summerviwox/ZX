package com.siweisoft.heavycenter.data.netd.user.head;

//by summer on 2018-01-17.

import com.android.lib.network.bean.req.BaseReqBean;

public class UpdateHeadReqBean extends BaseReqBean {

    public static final String 用户id = "userId";

    public static final String 文件类型 = "fileType";

    public static final String 文件路径 = "myFile";

    public static final String 头像= "TX";

    public static final String 驾驶证照片= "JSZ";

    public static final String 车辆照片= "CLZP";

    public static final String 行驶证照片= "XSZ";

    public static final String 故障照片= "GZ";

    public static final String 营业执照= "YYZZ";

    public static final String 税务登记证= "SWDJ";

    public static final String 组织机构代码证= "ZZJG";

    public static final String 建议反馈= "JYFK";

    private int id;


    private String myFile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyFile() {
        return myFile;
    }

    public void setMyFile(String myFile) {
        this.myFile = myFile;
    }
}
