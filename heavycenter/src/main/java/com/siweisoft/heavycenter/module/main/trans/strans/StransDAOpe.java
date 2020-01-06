package com.siweisoft.heavycenter.module.main.trans.strans;

//by summer on 2018-03-14.

import android.content.Context;

import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailRes;
import com.siweisoft.heavycenter.data.netd.trans.strans.StransReq;
import com.siweisoft.heavycenter.data.netd.trans.trans.TransReq;
import com.siweisoft.heavycenter.data.netd.trans.trans.TransRes;

import java.util.ArrayList;
import java.util.List;

public class StransDAOpe extends BaseDAOpe {

    private StransReq stransReq = new StransReq();

    private ArrayList<TransDetailRes> data = new ArrayList<>();

    public static void stranss(Context context, StransReq stransReq,NetI<TransRes> adapter){
        NetDataOpe.Order.getStrans(context,stransReq,adapter);
    }


    public StransReq getStransReq() {
        return stransReq;
    }

    public void setStransReq(StransReq stransReq) {
        this.stransReq = stransReq;
    }

    public ArrayList<TransDetailRes> getData() {
        return data;
    }

    public void addData(TransRes o) {
       if(o!=null&&o.getResults()!=null&&o.getResults().size()!=0){
           getData().addAll(o.getResults());
       }
    }
}
