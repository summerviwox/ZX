package com.siweisoft.heavycenter.module.mana.car.car;

//by summer on 2017-12-19.

import android.os.Bundle;
import android.view.View;

import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.LogUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.Test;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.status.StopCarResBean;
import com.siweisoft.heavycenter.module.mana.car.detail.CarDetailValue;
import com.siweisoft.heavycenter.module.mana.car.detail.DetailFrag;

public class CarFrag extends AppFrag<CarUIOpe,CarDAOpe> implements ViewListener,OnRefreshListener,OnLoadmoreListener,OnFinishListener{


    public static CarFrag getInstance(String title,String what,int status){
        CarFrag carFrag = new CarFrag();
        carFrag.setArguments(new Bundle());
        carFrag.getArguments().putString(ValueConstant.DATA_TYPE,title);
        carFrag.getArguments().putString(ValueConstant.DATA_POSITION,what);
        carFrag.getArguments().putInt(ValueConstant.FARG_REQ,status);
        carFrag.getDE().initCarReq(what,carFrag.getDE().getReqStatus(status));
        return carFrag;
    }

    @Override
    public void initNow() {
        super.initNow();
        getUI().initUI(getArguments().getInt(ValueConstant.FARG_REQ,CarValue.选择车辆));
        getUI().initRefresh(this,this);
    }

    @Override
    public void initdelay() {
        super.initdelay();
        onRefresh(null);
        getUI().initSearch(this);
    }



    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:
                switch (v.getId()){
                    case R.id.smMenuViewRight:
                        final CarsResBean.CarInfoRes bean = (CarsResBean.CarInfoRes) v.getTag(R.id.data);
                        getDE().statusCar(bean.getVehicleId(), bean.getStatus(), new UINetAdapter<StopCarResBean>(this,true) {
                            @Override
                            public void onSuccess(StopCarResBean o) {
                                bean.setStatus(bean.getStatus()== CarsResBean.CarInfoRes.STATUS_ON? CarsResBean.CarInfoRes.STATUS_OFF: CarsResBean.CarInfoRes.STATUS_ON);
                                getUI().notifyDataSetChanged();
                            }
                        });
                        break;
                        default:
                            final CarsResBean.CarInfoRes bean1 = (CarsResBean.CarInfoRes) v.getTag(R.id.data);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable(ValueConstant.DATA_DATA,bean1);
                            bundle.putInt(ValueConstant.FARG_REQ,1);
                            if(getArguments().getInt(ValueConstant.FARG_REQ,CarValue.选择车辆)== CarValue.选择车辆){
                                getArguments().putAll(bundle);
                                getBaseUIAct().onBackPressed();
                            }else{
                                FragManager2.getInstance().start(getBaseUIAct(), get容器(),DetailFrag.getInstance(CarDetailValue.查看车辆,"车辆详情",bean1),bundle);
                            }
                            break;
                }
                break;
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        getUI().finishLoadmore();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        getDE().Cars(getDE().getCarsReqBean(),new UINetAdapter<CarsResBean>(this) {
            @Override
            public void onSuccess(CarsResBean o) {
               // o = new Test().getCarsResBean();
                getDE().setNetcarsRes(o);
                getUI().LoadListData( getDE().searchCar(""),getArguments().getString(ValueConstant.DATA_POSITION),CarFrag.this);
                getUI().finishRefresh();
                if(getDE().getCarsFrag()!=null){
                    getDE().getCarsFrag().getUI().refreshTopMenu(getDE().getNetcarsRes());
                }
            }
        });
    }

    @Override
    public void onResult(int res, Bundle bundle) {
        super.onResult(res, bundle);
        switch (res){
            case 1:
                if(bundle==null|| !bundle.getBoolean(ValueConstant.FARG_TYPE,false)){
                    return;
                }
                onRefresh(null);
                break;
        }
    }

    @Override
    public void onFinish(Object o) {
        getUI().LoadListData( getDE().searchCar(o.toString()),getArguments().getString(ValueConstant.DATA_POSITION),CarFrag.this);
    }
}
