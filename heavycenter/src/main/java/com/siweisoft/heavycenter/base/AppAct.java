package com.siweisoft.heavycenter.base;

//by summer on 2017-12-08.

import android.os.Bundle;

import com.summer.x.base.ui.DE;
import com.summer.x.base.ui.UI;
import com.summer.x.base.ui.VA;
import com.summer.x.base.ui.XActivity;


public class AppAct<A extends UI, B extends DE> extends XActivity<A,B,VA> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
