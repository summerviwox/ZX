package com.siweisoft.heavycenter.base;

//by summer on 2017-12-08.

import android.view.View;

import butterknife.OnClick;
import butterknife.Optional;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.constant.ValueConstant;
import com.google.zxing.integration.android.IntentIntegrator;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.view.scan.ScanAct;
import com.summer.x.base.ui.DE;
import com.summer.x.base.ui.UI;
import com.summer.x.base.ui.VA;
import com.summer.x.base.ui.XFragment;

public abstract class AppFrag<A extends UI, B extends DE,C extends VA> extends XFragment<A,B,C> {


    @Optional
    @OnClick({R.id.ftv_back,R.id.ftv_right})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ftv_back:
               String str = getArguments().getString(ValueConstant.容器);
               if(str!=null){
                   getBaseUIAct().onBackPressed();
               }
                break;
            case R.id.ftv_right:
                if(getActivity() instanceof MainAct){
                    new IntentIntegrator(getBaseUIAct()).setCaptureActivity(ScanAct.class).initiateScan();
                }
                break;

        }
    }

}
