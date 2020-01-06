package com.siweisoft.heavycenter.module.myce.unit.addr;

//by summer on 2017-12-19.

import android.os.Bundle;
import android.view.View;

import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.util.LogUtil;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.module.myce.unit.area.prov.ProvFrag;
import com.siweisoft.heavycenter.module.myce.unit.area.prov.ProvValue;

import butterknife.OnClick;

public class AddrFrag extends AppFrag<AddrUIOpe,AddrDAOpe> implements ViewListener{



    @Override
    public void initdelay() {
        super.initdelay();

        getP().getD().getMapUtil().init(getBaseUIAct(),true);
        getP().getD().getMapUtil().registerLocationListener(getBaseUIAct(), new BDAbstractLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                getP().getU().bind.tvAddr.setText(StringUtil.getStr(bdLocation.getAddrStr()));
                getP().getU().bind.tvCity.setText(StringUtil.getStr(bdLocation.getCity()));
                getP().getD().getUnitInfo().setCompanyAddress(bdLocation.getAddrStr());
                getP().getD().getUnitInfo().setCompanyLat(bdLocation.getLatitude());
                getP().getD().getUnitInfo().setCompanyLng(bdLocation.getLongitude());
            }
        });
        getP().getD().startMap();
        getP().getU().LoadListData(getP().getD().getAddrs(),AddrFrag.this);
        getP().getU().initInput(new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                if(getP().getU().canLocal()){
                    getP().getD().getMapUtil().searchNeayBy(getP().getU().bind.tvCity.getText().toString(),o.toString() ,new OnGetPoiSearchResultListener() {
                        @Override
                        public void onGetPoiResult(PoiResult poiResult) {
                            if(poiResult!=null&&poiResult.getAllPoi()!=null){
                                getP().getD().setAddrs(poiResult.getAllPoi());
                                getP().getU().notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
                            LogUtil.E("");
                        }

                        @Override
                        public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
                            LogUtil.E("");
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:
                PoiInfo poiInfo = (PoiInfo) v.getTag(R.id.data);
                getP().getD().getUnitInfo().setCompanyAddress(poiInfo.address);
                getP().getD().getUnitInfo().setCompanyLat(poiInfo.location.latitude);
                getP().getD().getUnitInfo().setCompanyLng(poiInfo.location.longitude);
                getArguments().putSerializable(ValueConstant.DATA_DATA,getP().getD().getUnitInfo());
                getBaseUIAct().onBackPressed();
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getP().getD().stopMap();
    }

    @OnClick({R.id.tv_addr,R.id.iv_local,R.id.tv_local,R.id.tv_city})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_addr:
                if(NullUtil.isStrEmpty(getP().getU().bind.tvAddr.getText().toString())){
                    ToastUtil.getInstance().showShort(getActivity(),"当前地址为空 请重新定位");
                    return;
                }
                getArguments().putSerializable(ValueConstant.DATA_DATA,getP().getD().getUnitInfo());
                getBaseUIAct().onBackPressed();
                break;
            case R.id.iv_local:
            case R.id.tv_local:
                getP().getD().getMapUtil().init(getBaseUIAct(),true);
                getP().getD().getMapUtil().registerLocationListener(getBaseUIAct(), new BDAbstractLocationListener() {
                    @Override
                    public void onReceiveLocation(BDLocation bdLocation) {
                        getP().getU().bind.tvAddr.setText(StringUtil.getStr(bdLocation.getAddrStr()));
                    }
                });
                getP().getD().startMap();
                break;
            case R.id.tv_city:
                Bundle bundle = new Bundle();
                bundle.putInt(ValueConstant.FARG_REQ,1);
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),ProvFrag.getInstance(ProvValue.选择一个城市,"选择省份"),bundle);
                break;
        }
    }

    @Override
    public void onResult(int res, Bundle bundle) {
        super.onResult(res, bundle);
        switch (res){
            case 1:
                if(bundle==null|| bundle.getString(ValueConstant.DATA_RES)==null){
                    return;
                }
               getP().getU().bind.tvCity.setText(StringUtil.getStr( bundle.getString(ValueConstant.DATA_RES)));
                break;
        }
    }
}
