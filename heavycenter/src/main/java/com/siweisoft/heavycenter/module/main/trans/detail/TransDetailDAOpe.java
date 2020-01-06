package com.siweisoft.heavycenter.module.main.trans.detail;

//by summer on 2017-12-18.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailReq;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailRes;

public class TransDetailDAOpe extends AppDAOpe {

    private int transid = -1;



    public void detailTrans(int id, NetI<TransDetailRes> adapter){
        TransDetailReq transDetailReq = new TransDetailReq();
        transDetailReq.setTransportRecordId(id);
        NetDataOpe.Trans.detailTrans(getActivity(),transDetailReq,adapter);
    }

    public int getTransid() {
        return transid;
    }

    public void setTransid(int transid) {
        this.transid = transid;
    }
}
