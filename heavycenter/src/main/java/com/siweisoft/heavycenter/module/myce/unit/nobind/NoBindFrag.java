package com.siweisoft.heavycenter.module.myce.unit.nobind;

//by summer on 2017-12-19.

import android.view.View;

import com.android.lib.util.fragment.two.FragManager2;
import com.google.zxing.integration.android.IntentIntegrator;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.main.main.MainValue;
import com.siweisoft.heavycenter.module.myce.unit.list.UnitListDAOpe;
import com.siweisoft.heavycenter.module.myce.unit.list.UnitListFrag;
import com.siweisoft.heavycenter.module.view.scan.ScanAct;

import butterknife.OnClick;

public class NoBindFrag extends AppFrag<NoBindUIOpe,NoBindDAOpe> {

    @OnClick({R.id.ftv_right,R.id.tv_bindtip,R.id.ftv_back,R.id.ftv_title})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ftv_back:
                ((MainAct)getBaseUIAct()).getP().getU().switchDrawer();
                break;
            case R.id.ftv_right:
                if(getActivity() instanceof MainAct){
                    new IntentIntegrator(getBaseUIAct()).setCaptureActivity(ScanAct.class).initiateScan();
                }
                break;
            case R.id.ftv_title:
            case R.id.tv_bindtip:
                FragManager2.getInstance().start(getBaseUIAct(), MainValue.主界面,MainValue.主界面ID,UnitListFrag.getInstance(UnitListDAOpe.绑定单位));
                break;
        }
    }
}
