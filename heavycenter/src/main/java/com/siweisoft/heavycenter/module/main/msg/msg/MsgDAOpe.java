package com.siweisoft.heavycenter.module.main.msg.msg;

//by summer on 2017-12-11.

import android.content.Context;

import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.msg.deal.MsgDealReqBean;
import com.siweisoft.heavycenter.data.netd.msg.deal.MsgDealResBean;
import com.siweisoft.heavycenter.data.netd.msg.list.MsgsReqBean;
import com.siweisoft.heavycenter.data.netd.msg.list.MsgsResBean;

public class MsgDAOpe extends BaseDAOpe {


    private int pageindex = NetValue.PAGE_INDEX_START;

    private MsgsResBean msgsResBean = new MsgsResBean();


    public void getMsgSys(String type,NetI<MsgsResBean> adapter){
        MsgsReqBean msgsReqBean = new MsgsReqBean();
        msgsReqBean.setUserId(LocalValue.get登录返回信息().getUserId());
        msgsReqBean.setPageIndex(getPageindex());
        msgsReqBean.setPageSize(20);
        msgsReqBean.setMessageCate(type);
        NetDataOpe.Msg.list(getActivity(),msgsReqBean,adapter);
    }

    public void dealMss(int messageId, String auditStatus, NetI<MsgDealResBean> adapter){
        MsgDealReqBean msgDealReqBean = new MsgDealReqBean();
        msgDealReqBean.setUserId(LocalValue.get登录返回信息().getUserId());
        msgDealReqBean.setMessageId(messageId);
        msgDealReqBean.setAuditStatus(auditStatus);
        NetDataOpe.Msg.deal(getActivity(),msgDealReqBean,adapter);

    }


    public void addData(MsgsResBean data){
        if(data!=null && data.getResults()!=null){
            msgsResBean.getResults().addAll(data.getResults());
        }
    }


    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public MsgsResBean getMsgsResBean() {
        return msgsResBean;
    }

    public void setMsgsResBean(MsgsResBean msgsResBean) {
        this.msgsResBean = msgsResBean;
    }
}
