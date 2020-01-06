package com.siweisoft.heavycenter.module.main.trans.trans;

//by summer on 2017-12-11.

import android.content.Context;

import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.network.news.NetI;
import com.android.lib.util.ObjectUtil;
import com.android.lib.util.OjectUtil;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.trans.sign.TransSignReq;
import com.siweisoft.heavycenter.data.netd.trans.sign.TransSignRes;
import com.siweisoft.heavycenter.data.netd.trans.trans.TransReq;
import com.siweisoft.heavycenter.data.netd.trans.trans.TransRes;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;

import java.util.ArrayList;

public class TransDAOpe extends BaseDAOpe {

    private TransReq transReq = new TransReq();

    private TransRes transRes = new TransRes();

    private int pageIndex = NetValue.PAGE_INDEX_START;


    private int comid = LocalValue.get登录返回信息().getCompanyId();

    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        for(int i=0;i<1;i++){
            data.add("");
        }
        return data;
    }


    public TransReq getTransReq(int pageIndex) {
        transReq.setIsApp(1);
//        if(OjectUtil.equals(LocalValue.get登录返回信息().getUserType(), UserTypeReqBean.驾驶员)){
//            transReq.setUserId(LocalValue.get登录返回信息().getUserId());
//        }else{
//            transReq.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
//        }
        transReq.setCompanyId(comid);
        transReq.setPageIndex(pageIndex);
        transReq.setPageSize(10);
        return transReq;
    }



    public void transs(TransReq transReq, NetI<TransRes> adapter){
        NetDataOpe.Trans.transs(getActivity(),transReq,adapter);
    }

    public void signTrans(int id, NetI<TransSignRes> adapter){
        TransSignReq transSignReq = new TransSignReq();
        transSignReq.setTransportrecordId(id);
        transSignReq.setUserId(LocalValue.get登录返回信息().getUserId());
        transSignReq.setSignStatus(TransSignReq.已确认);
        NetDataOpe.Trans.signTrans(getActivity(),transSignReq,adapter);
    }

    public TransRes getTransRes() {
        return transRes;
    }

    public int getPageIndex() {
        return pageIndex;
    }


    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }

}
