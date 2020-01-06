package com.siweisoft.heavycenter.module.mana.good.lists;

//by summer on 2018-01-17.

import android.content.Context;

import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.mana.good.names.NamesReq;
import com.siweisoft.heavycenter.data.netd.mana.good.names.NamesRes;

public class NamesDAOpe extends BaseDAOpe {



    public void ProductList(NetI<NamesRes> adapter){
        NamesReq namesReq = new NamesReq();
        namesReq.setPageIndex(1);
        namesReq.setPageSize(100);
        NetDataOpe.Mana.Good.ProductList(getActivity(),namesReq,adapter);
    }
}
