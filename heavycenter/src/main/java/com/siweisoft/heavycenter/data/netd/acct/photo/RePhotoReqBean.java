package com.siweisoft.heavycenter.data.netd.acct.photo;

//by summer on 2018-01-15.

import com.android.lib.network.bean.req.BaseReqBean;

public class RePhotoReqBean extends BaseReqBean {

    private int id;

    private String myFile;

    public RePhotoReqBean() {
    }

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
