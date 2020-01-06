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
        getDE().getMapUtil().init(getActivity());
        getDE().getMapUtil().setScantime(10000);
        getDE().getMapUtil().registerLocationListener(getActivity(), new BDAbstractLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                getDE().getMapUtil().animateMapStatus(getUI().bind.map.getMap(),bdLocation);
                getDE().getMapUtil().setMyLocationData(getUI().bind.map.getMap(),bdLocation);
            }
        });
        getDE().startMap();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ftv_back:
                ((MainAct)getActivity()).getUI().switchDrawer();
                break;
            case R.id.ftv_right:
                if(getActivity() instanceof MainAct){
                    new IntentIntegrator(getBaseAct()).setCaptureActivity(ScanAct.class).initiateScan();
                }
                break;
        }
    }

    public void local(BDLocation bdLocation){
        getDE().getMapUtil().animateMapStatus2(getUI().bind.map.getMap(),bdLocation);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getDE().stopMap();
    }
}
