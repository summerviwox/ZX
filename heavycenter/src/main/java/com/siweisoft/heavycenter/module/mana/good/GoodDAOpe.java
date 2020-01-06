package com.siweisoft.heavycenter.module.mana.good;

//by summer on 2017-12-14.

import android.content.Context;
import android.text.GetChars;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.mana.good.list.GoodListReq;
import com.siweisoft.heavycenter.data.netd.mana.good.list.GoodListRes;
import com.siweisoft.heavycenter.data.netd.mana.good.status.GoodStatusReq;
import com.siweisoft.heavycenter.data.netd.mana.good.status.GoodStatusRes;

import java.util.ArrayList;

public class GoodDAOpe extends AppDAOpe {

    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        for(int i=0;i<100;i++){
            data.add(""+i);
        }
        return data;
    }

    public void listGood(NetI<GoodListRes> adapter){
        GoodListReq goodListReq = new GoodListReq();
        goodListReq.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        goodListReq.setIsApp(1);
        NetDataOpe.Mana.Good.listGood(getActivity(),goodListReq,adapter);
    }

    public static void goodStatus(Context context, int id, int status, NetI<GoodStatusRes> adapter){
        GoodStatusReq goodStatusReq = new GoodStatusReq();
        goodStatusReq.setId(id);
        goodStatusReq.setStatus(status);
        NetDataOpe.Mana.Good.updateStatus(context,goodStatusReq,adapter);
    }

}
