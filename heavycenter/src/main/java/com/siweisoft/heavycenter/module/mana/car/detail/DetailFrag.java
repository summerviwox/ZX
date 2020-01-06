package com.siweisoft.heavycenter.module.mana.car.detail;

//by summer on 2017-12-19.

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.bean.res.BaseResBean;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.IntentUtil;
import com.android.lib.util.StringUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.mana.car.bind.BindCarRes;
import com.siweisoft.heavycenter.data.netd.mana.car.info.CarInfoReq;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.update.UpdateCarRes;
import com.siweisoft.heavycenter.data.netd.unit.dirvers.DriverRes;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadReqBean;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadResBean;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.mana.car.news.NewCarDAOpe;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import butterknife.Optional;

public class DetailFrag extends AppFrag<DetailUIOpe,DetailDAOpe> implements ViewListener{



    public static DetailFrag getInstance(String type,String title,CarsResBean.CarInfoRes data){
        DetailFrag detailFrag = new DetailFrag();
        detailFrag.setArguments(new Bundle());
        detailFrag.getArguments().putString(CarDetailValue.类型,type);
        detailFrag.getArguments().putString(CarDetailValue.标题,title);
        detailFrag.getArguments().putSerializable(CarDetailValue.数据,data);
        return detailFrag;
    }

    @Override
    public void initNow() {
        super.initNow();
        getDE().setType(getArguments().getString(CarDetailValue.类型));
        getUI().init(getDE().getType());
    }

    @Override
    public void initdelay() {
        super.initdelay();
        switch (getDE().getType()){
            case CarDetailValue.新建车辆:

                break;
            case CarDetailValue.新建车辆并绑定:
                getUI().bind.title.getMidTV().setText("绑定车辆");
                getUI().bind.etName.setText(getArguments().getString(CarDetailValue.标题,""));
                //getUI().bind.itemCarlicenseno.setMidEtTxt(StringUtil.getStr(getArguments().getString(ValueConstant.DATA_DATA,"")));
                break;
            case CarDetailValue.查看车辆:
                getDE().setCarinfo((CarsResBean.CarInfoRes) getArguments().getSerializable(CarDetailValue.数据));
                getDE().infoCar(getDE().getCarInfoReq(getDE().getCarinfo()), new UINetAdapter<CarsResBean.CarInfoRes>(this) {
                    @Override
                    public void onSuccess(CarsResBean.CarInfoRes o) {
                        getDE().setCarinfo(o);
                        getUI().initData(getDE().getType(),getDE().getCarinfo());
                        getDE().drvers(getDE().getType(), getDE().getCarinfo(), new UINetAdapter<ArrayList<DriverRes>>(getActivity()) {
                            @Override
                            public void onSuccess(ArrayList<DriverRes> o) {
                                super.onSuccess(o);
                                getDE().ReaddDriverData(o);
                                getUI().LoadListData(getDE().getDriverRes(),DetailFrag.this);
                            }
                        });
                    }
                });
                break;
            case CarDetailValue.绑定车辆:
                getDE().setCarinfo((CarsResBean.CarInfoRes) getArguments().getSerializable(CarDetailValue.数据));
                getDE().infoCar(getDE().getCarInfoReq(getDE().getCarinfo()), new UINetAdapter<CarsResBean.CarInfoRes>(this) {
                    @Override
                    public void onSuccess(CarsResBean.CarInfoRes o) {
                        getDE().setCarinfo(o);
                        getUI().initData(getDE().getType(),getDE().getCarinfo());
                    }
                });
                break;
        }


    }

    @Optional
    @OnClick({R.id.iv_vehicleLicensePhoto,R.id.iv_vehiclePhoto,R.id.ftv_right2,R.id.tv_y})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.iv_vehicleLicensePhoto:
                IntentUtil.getInstance().pickImage(this,01);
                // IntentUtil.getInstance().photoShowFromphone(this,01);
                break;
            case R.id.iv_vehiclePhoto:
                IntentUtil.getInstance().pickImage(this,02);
                //IntentUtil.getInstance().photoShowFromphone(this,02);
                break;
            case R.id.ftv_right2:
                switch (getDE().getType()){
                    case CarDetailValue.新建车辆:
                        if(getDE().IsNewCar(getDE().getCarinfo())){
                            if(getUI().canNewGo()){
                                getDE().newCar(getUI().getCarNewReqBean(getDE().getCarNewReqBean(getDE().getCarinfo())), new UINetAdapter<CarsResBean.CarInfoRes>(this,UINetAdapter.Loading,true) {
                                    @Override
                                    public void onSuccess(CarsResBean.CarInfoRes o) {
                                        if(getDE().getBindCarReq().isEnable()){
                                            NewCarDAOpe.infoCar(getContext(), o.getCarLicenseNo(), new UINetAdapter<CarsResBean.CarInfoRes>(DetailFrag.this,UINetAdapter.Loading) {
                                                @Override
                                                public void onSuccess(CarsResBean.CarInfoRes o) {
                                                    super.onSuccess(o);
                                                    getDE().getBindCarReq().setId(o.getVehicleId());
                                                    getDE().bindCar(getDE().getBindCarReq(),new UINetAdapter<BindCarRes>(DetailFrag.this,UINetAdapter.Loading,true) {
                                                        @Override
                                                        public void onSuccess(BindCarRes o) {
                                                            super.onSuccess(o);
                                                            getArguments().putBoolean(ValueConstant.FARG_TYPE,true);
                                                            getBaseUIAct().onBackPressed();
                                                        }
                                                    });
                                                }
                                            });
                                        }else{
                                            getArguments().putBoolean(ValueConstant.FARG_TYPE,true);
                                            getBaseUIAct().onBackPressed();
                                        }
                                    }
                                });
                            }
                        }else{
                            if(getUI().canNewGo()){
                                getDE().updateCar(getUI().getUpdateCarReq(getDE().getUpdateCarReq(getDE().getCarinfo())), new UINetAdapter<UpdateCarRes>(this,UINetAdapter.Loading,true) {
                                    @Override
                                    public void onSuccess(UpdateCarRes o) {
                                        super.onSuccess(o);
                                        if(getDE().getBindCarReq().isEnable()){
                                            getDE().bindCar(getDE().getBindCarReq(),new UINetAdapter<BindCarRes>(DetailFrag.this,UINetAdapter.Loading,true) {
                                                @Override
                                                public void onSuccess(BindCarRes o) {
                                                    super.onSuccess(o);
                                                    getArguments().putBoolean(ValueConstant.FARG_TYPE,true);
                                                    getBaseUIAct().onBackPressed();
                                                }
                                            });
                                        }else{
                                            getArguments().putBoolean(ValueConstant.FARG_TYPE,true);
                                            getBaseUIAct().onBackPressed();
                                        }
                                    }
                                });
                            }
                        }
                        break;
                    case CarDetailValue.查看车辆:
                        if(getUI().canGo()){
                            getDE().updateCar(getUI().getUpdateCarReq(getDE().getUpdateCarReq(getDE().getCarinfo())), new UINetAdapter<UpdateCarRes>(this,UINetAdapter.Loading,true) {
                                @Override
                                public void onSuccess(UpdateCarRes o) {
                                    super.onSuccess(o);
                                    if(getDE().getBindCarReq().isEnable()){
                                        getDE().bindCar(getDE().getBindCarReq(),new UINetAdapter<BindCarRes>(DetailFrag.this,UINetAdapter.Loading,true) {
                                            @Override
                                            public void onSuccess(BindCarRes o) {
                                                super.onSuccess(o);
                                                getArguments().putBoolean(ValueConstant.FARG_TYPE,true);
                                                getBaseUIAct().onBackPressed();
                                            }
                                        });
                                    }else{
                                        getArguments().putBoolean(ValueConstant.FARG_TYPE,true);
                                        getBaseUIAct().onBackPressed();
                                    }
                                }
                            });
                        }
                        break;
                    case CarDetailValue.绑定车辆:
                        if(getUI().canGo()){
                            getDE().updateCar(getUI().getUpdateCarReq(getDE().getUpdateCarReq(getDE().getCarinfo())), new UINetAdapter<UpdateCarRes>(this) {
                                @Override
                                public void onResult(boolean success, String msg, UpdateCarRes o) {
                                    super.onResult(success, msg, o);
                                    if(success){
                                        getDE().bindCar(getDE().getDriverBindCarReq(getDE().getCarinfo()), new UINetAdapter<BindCarRes>(DetailFrag.this,true) {
                                            @Override
                                            public void onSuccess(BindCarRes o) {
                                                ((MainAct) getBaseUIAct()).getDE().getMyceFrag().initUINET();
                                                getBaseUIAct().onBackPressed();
                                            }
                                        });
                                    }
                                }
                            });
                        }
                        break;
                    case CarDetailValue.新建车辆并绑定:
                        if(getUI().canNewGo()){
                            getDE().newCar(getUI().getCarNewReqBean(getDE().getCarNewReqBean(getDE().getCarinfo())), new UINetAdapter<CarsResBean.CarInfoRes>(this,UINetAdapter.Loading) {
                                @Override
                                public void onSuccess(CarsResBean.CarInfoRes o) {
                                    getDE().setCarinfo(o);
                                    CarInfoReq req = new CarInfoReq();
                                    req.setIsApp(1);
                                    req.setCarLicenseNo(StringUtil.getStr(getArguments().getString(CarDetailValue.标题)));
                                    getDE().infoCar(req, new UINetAdapter<CarsResBean.CarInfoRes>(DetailFrag.this,UINetAdapter.Loading) {
                                        @Override
                                        public void onSuccess(CarsResBean.CarInfoRes o) {
                                            getDE().setCarinfo(o);
                                            getDE().bindCar(getDE().getDriverBindCarReq(getDE().getCarinfo()), new UINetAdapter<BindCarRes>(DetailFrag.this,UINetAdapter.Loading,true) {
                                                @Override
                                                public void onSuccess(BindCarRes o) {
                                                    ((MainAct) getBaseUIAct()).getDE().getMyceFrag().initUINET();
                                                    getBaseUIAct().onBackPressed();
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }
                        break;
                }
                break;
            case R.id.tv_y:
                switch (getDE().getType()){
                    case CarDetailValue.新建车辆:
                        if(getUI().nowReInput()){
                            getUI().whenClickReInput();
                            getDE().getBindCarReq().setEnable(false);
                        }else{
                            if(getUI().canSearchCar()){
                                getUI().whenClickMakeSure();
                                DetailDAOpe.infoCar(getContext(), getUI().getCarNO(), new UINetAdapter<CarsResBean.CarInfoRes>(this, UINetAdapter.Loading) {
                                    @Override
                                    public void onSuccess(CarsResBean.CarInfoRes o) {
                                        super.onSuccess(o);
                                        getDE().setCarinfo(o);
                                        getUI().initData(getDE().getType(),getDE().getCarinfo());

                                        getDE().drvers(getDE().getType(),getDE().getCarinfo(), new UINetAdapter<ArrayList<DriverRes>>(getActivity()) {
                                            @Override
                                            public void onSuccess(ArrayList<DriverRes> o) {
                                                super.onSuccess(o);
                                                getDE().ReaddDriverData(o);
                                                getUI().LoadListData(getDE().getDriverRes(),DetailFrag.this);
                                            }
                                        });
                                    }
                                });
                            }
                        }
                        break;
                }
                break;
        }

    }


    @Override
    public void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data==null){
            return;
        }
        String s= "";
        switch (requestCode){
            case 01:
                s = UpdateHeadReqBean.驾驶证照片;
                break;
            case 02:
                s = UpdateHeadReqBean.车辆照片;
                break;
        }

        List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
        if(selectList==null||selectList.size()!=1){
            return;
        }

        getDE().updateHead(selectList.get(0).getCompressPath(),s, new UINetAdapter<UpdateHeadResBean>(this,true) {
            @Override
            public void onNetFinish(boolean haveData, String url, BaseResBean baseResBean) {
                stopLoading();
                if(haveData){
                    String s = baseResBean.getResult().toString();
                    if(s!=null){
                        if(s.trim().startsWith("[")){
                            s= s.substring(1,s.length()-1).trim();
                        }
                        switch (requestCode){
                            case 01:
                                getDE().getCarinfo().setVehicleLicensePhoto(s);
                                break;
                            case 02:
                                getDE().getCarinfo().setVehiclePhoto(s);
                                break;
                        }
                        getUI().initPhoto(getDE().getCarinfo().getVehiclePhoto(),getDE().getCarinfo().getVehicleLicensePhoto());
                    }
                }
            }
        });


    }

    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:
                int pos = (int) v.getTag(R.id.position);
                DriverRes driverRes = (DriverRes) v.getTag(R.id.data);
                for(int i=0;getDE().getDriverRes()!=null&&i<getDE().getDriverRes().size();i++){
                    if(pos==i){
                        getDE().getDriverRes().get(i).setIsCurrentDriver(DriverRes.是当前驾驶员);
                        getDE().getBindCarReq().setEnable(true);
                        getDE().getBindCarReq().setCurrentDriver(driverRes.getUserId());
                        getDE().getBindCarReq().setId(getDE().getCarinfo().getVehicleId());
                    }else{
                        getDE().getDriverRes().get(i).setIsCurrentDriver(DriverRes.不当前驾驶员);
                    }
                }
                getUI().notifyDataSetChanged();
                break;
        }
    }


    public void bindCar(int userid){
        DriverRes select = null;
        for(int i=0;getDE().getDriverRes()!=null&&i<getDE().getDriverRes().size();i++){
            if(userid == getDE().getDriverRes().get(i).getUserId()){
                select = getDE().getDriverRes().get(i);
                getDE().getDriverRes().get(i).setIsCurrentDriver(DriverRes.是当前驾驶员);
                getDE().getBindCarReq().setEnable(true);
                getDE().getBindCarReq().setCurrentDriver(userid);
                getDE().getBindCarReq().setId(getDE().getCarinfo().getVehicleId());
            }else{
                getDE().getDriverRes().get(i).setIsCurrentDriver(DriverRes.不当前驾驶员);
            }
        }
        if(select!=null){
            getDE().getDriverRes().remove(select);
            getDE().getDriverRes().add(0,select);
        }
        getUI().notifyDataSetChanged();
    }
}
