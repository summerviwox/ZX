package com.siweisoft.heavycenter.module.mana.good.specs;

//by summer on 2018-01-17.

import android.content.Context;

import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.mana.good.names.NamesReq;
import com.siweisoft.heavycenter.data.netd.mana.good.names.NamesRes;
import com.siweisoft.heavycenter.data.netd.mana.good.specs.SpecsReq;
import com.siweisoft.heavycenter.data.netd.mana.good.specs.SpecsRes;

public class SpecsDAOpe extends BaseDAOpe {



    public void SpecsGood(int productid,NetI<SpecsRes> adapter){
        SpecsReq specsReq = new SpecsReq();
        specsReq.setIsApp(1);
        specsReq.setProductId(productid);
        NetDataOpe.Mana.Good.SpecsGood(getActivity(),specsReq,adapter);
    }
}
