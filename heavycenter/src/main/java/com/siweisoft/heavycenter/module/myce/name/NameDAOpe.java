package com.siweisoft.heavycenter.module.myce.name;

//by summer on 2017-12-19.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.rename.ReNameReqBean;
import com.siweisoft.heavycenter.data.netd.acct.rename.ReNameResBean;

public class NameDAOpe extends AppDAOpe {

    public void reName(ReNameReqBean reNameReqBean, NetI<ReNameResBean> adapter){
        NetDataOpe.reName(getActivity(),reNameReqBean,adapter);
    }
}
