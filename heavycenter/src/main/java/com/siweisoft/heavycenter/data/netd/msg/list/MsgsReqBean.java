package com.siweisoft.heavycenter.data.netd.msg.list;

//by summer on 2018-01-11.

import com.android.lib.network.bean.req.BaseReqBean;
import com.android.lib.util.OjectUtil;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;

import java.util.ArrayList;

public class MsgsReqBean extends BaseReqBean {


    //全部、运输、车辆、公告、系统


    public static final String MESSAGE_CATE_ALL = "";

    public static final String MESSAGE_CATE_TRANS = "2";

    public static final String MESSAGE_CATE_CAR = "3";

    public static final String MESSAGE_CATE_PUB = "4";

    public static final String MESSAGE_CATE_SYS = "1";

    private int userId;

    private String messageCate;

    private int pageIndex;

    private int pageSize;

    public static final ArrayList<MsgBean> 非驾驶员消息类型 = new ArrayList<>();

    public static final ArrayList<MsgBean> 驾驶员消息类型 = new ArrayList<>();

    static{
        非驾驶员消息类型.add(new MsgBean(MESSAGE_CATE_ALL,"全部"));
        非驾驶员消息类型.add(new MsgBean(MESSAGE_CATE_TRANS,"运输"));
        非驾驶员消息类型.add(new MsgBean(MESSAGE_CATE_CAR,"车辆"));
        非驾驶员消息类型.add(new MsgBean(MESSAGE_CATE_PUB,"公告"));
        非驾驶员消息类型.add(new MsgBean(MESSAGE_CATE_SYS,"系统"));


        驾驶员消息类型.add(new MsgBean(MESSAGE_CATE_ALL,"全部"));
        驾驶员消息类型.add(new MsgBean(MESSAGE_CATE_TRANS,"运输"));
        驾驶员消息类型.add(new MsgBean(MESSAGE_CATE_PUB,"公告"));
        驾驶员消息类型.add(new MsgBean(MESSAGE_CATE_SYS,"系统"));

    }

    public static ArrayList<MsgBean> get消息类型(){
        if(OjectUtil.equals(LocalValue.get登录返回信息().getUserType(), UserTypeReqBean.驾驶员)){
            return 驾驶员消息类型;
        }
        return 非驾驶员消息类型;
    }


    public MsgsReqBean() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessageCate() {
        return messageCate;
    }

    public void setMessageCate(String messageCate) {
        this.messageCate = messageCate;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
