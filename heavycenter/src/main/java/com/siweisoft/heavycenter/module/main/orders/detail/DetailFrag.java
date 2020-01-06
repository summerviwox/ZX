package com.siweisoft.heavycenter.module.main.orders.detail;

//by summer on 2017-12-19.

import android.os.Bundle;
import android.view.View;

import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.NetAdapter;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.Test;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsReqBean;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.order.addcar.AddCarReq;
import com.siweisoft.heavycenter.data.netd.order.addcar.AddCarRes;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersRes;
import com.siweisoft.heavycenter.module.main.trans.strans.StransFrag;
import com.siweisoft.heavycenter.module.mana.car.car.CarFrag;
import com.siweisoft.heavycenter.module.mana.car.car.CarValue;

import butterknife.OnClick;

public class DetailFrag extends AppFrag<DetailUIOpe,DetailDAOpe> implements ViewListener{


    public static DetailFrag getInstance(String type){
        DetailFrag detailFrag = new DetailFrag();
        detailFrag.setArguments(new Bundle());
        detailFrag.getArguments().putString(ValueConstant.TYPE,type);
        return detailFrag;
    }

    @Override
    public void initdelay() {
        super.initdelay();
        getP().getD().detail(getArguments().getInt(ValueConstant.DATA_DATA), new UINetAdapter<OrdersRes.ResultsBean>(this,UINetAdapter.Loading) {
            @Override
            public void onSuccess(OrdersRes.ResultsBean o) {
                //o= new Test().getOrdersRes().getResults().get(0);
                getP().getD().setData(o);
                getP().getU().initUI(getArguments().getString(ValueConstant.TYPE),getP().getD().getData());
                getP().getU().initdata(getP().getD().getData().getVehicleList(),DetailFrag.this);
            }
        });
    }

    @OnClick({R.id.iv_local})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.iv_local:
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),CarFrag.getInstance("指定车辆",CarsReqBean.WHAT_MY, CarValue.选择车辆));
                break;
            case R.id.tv_totalcarnum://done
                if(getP().getD().getData()==null){
                    return;
                }
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),StransFrag.getInstance(getP().getD().getData().getOrderId(),1,getP().getD().getData().getOrderNo()));

                break;
            case R.id.tv_carno://doing
                if(getP().getD().getData()==null){
                    return;
                }
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),StransFrag.getInstance(getP().getD().getData().getOrderId(),1,getP().getD().getData().getOrderNo()));
                break;
        }
    }

    @Override
    public void onResult(int res, Bundle bundle) {
        super.onResult(res, bundle);
        switch (res){
            case CarValue.选择车辆:
                if(bundle==null|| bundle.getSerializable(ValueConstant.DATA_DATA)==null){
                    return;
                }
                final CarsResBean.CarInfoRes bean = (CarsResBean.CarInfoRes) bundle.getSerializable(ValueConstant.DATA_DATA);
                if(!getP().getD().haveAddCar(bean)){
                    getP().getD().addCar(bean.getVehicleId(), AddCarReq.添加,new NetAdapter<AddCarRes>(getContext()){
                        @Override
                        public void onResult(boolean success, String msg, AddCarRes o) {
                            super.onResult(success, msg, o);
                            if(success){
                                getP().getD().getData().getVehicleList().add(bean);
                                getP().getU().initdata(getP().getD().getData().getVehicleList(),DetailFrag.this);
                            }
                        }
                    });
                }
                break;
        }
    }

    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:
                switch (v.getId()){
                    case R.id.smMenuViewRight:
                        final CarsResBean.CarInfoRes bean = (CarsResBean.CarInfoRes) v.getTag(R.id.data);
                        getP().getD().addCar(bean.getVehicleId(), AddCarReq.移除,new NetAdapter<AddCarRes>(getContext()){
                            @Override
                            public void onResult(boolean success, String msg, AddCarRes o) {
                                super.onResult(success, msg, o);
                                if(success){
                                    getP().getD().getData().getVehicleList().remove(bean);
                                    getP().getU().initdata(getP().getD().getData().getVehicleList(),DetailFrag.this);
                                }
                            }
                        });
                        break;
                }
                break;
        }
    }
}
