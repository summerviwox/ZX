package com.siweisoft.heavycenter.module.main.orders.trans;

//by summer on 2017-12-19.

import com.siweisoft.heavycenter.base.AppFrag;

public class TransFrag extends AppFrag<TransUIOpe,TransDAOpe> {

    @Override
    public void initNow() {
        super.initNow();
        getUI().initRefresh();
        getUI().LoadListData(getDE().getData());
    }
}
