package com.siweisoft.heavycenter.module.main.map;

//by summer on 2017-12-11.

import android.view.View;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.google.zxing.integration.android.IntentIntegrator;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.view.scan.ScanAct;

public class MapFrag extends AppFrag<MapUIOpe,MapDAOpe> {


    @Override
    public void onFristVisibleInit() {
        getP().getD().getMapUtil().init(getActivity());
        getP().getD().getMapUtil().setScantime(10000);
        getP().getD().getMapUtil().registerLocationListener(getActivity(), new BDAbstractLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                getP().getD().getMapUtil().animateMapStatus(getP().getU().bind.map.getMap(),bdLocation);
                getP().getD().getMapUtil().setMyLocationData(getP().getU().bind.map.getMap(),bdLocation);
            }
        });
        getP().getD().startMap();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ftv_back:
                ((MainAct)getActivity()).getP().getU().switchDrawer();
                break;
            case R.id.ftv_right:
                if(getActivity() instanceof MainAct){
                    new IntentIntegrator(getBaseAct()).setCaptureActivity(ScanAct.class).initiateScan();
                }
                break;
        }
    }

    public void local(BDLocation bdLocation){
        getP().getD().getMapUtil().animateMapStatus2(getP().getU().bind.map.getMap(),bdLocation);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getP().getD().stopMap();
    }
}
