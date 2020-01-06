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
        getP().getD().setType(getArguments().getString(CarDetailValue.类型));
        getP().getU().init(getP().getD().getType());
    }

    @Override
    public void initdelay() {
        super.initdelay();
        switch (getP().getD().getType()){
            case CarDetailValue.新建车辆:

                break;
            case CarDetailValue.新建车辆并绑定:
                getP().getU().bind.title.getMidTV().setText("绑定车辆");
                getP().getU().bind.etName.setText(getArguments().getString(CarDetailValue.标题,""));
                //getP().getU().bind.itemCarlicenseno.setMidEtTxt(StringUtil.getStr(getArguments().getString(ValueConstant.DATA_DATA,"")));
                break;
            case CarDetailValue.查看车辆:
                getP().getD().setCarinfo((CarsResBean.CarInfoRes) getArguments().getSerializable(CarDetailValue.数据));
                getP().getD().infoCar(getP().getD().getCarInfoReq(getP().getD().getCarinfo()), new UINetAdapter<CarsResBean.CarInfoRes>(this) {
                    @Override
                    public void onSuccess(CarsResBean.CarInfoRes o) {
                        getP().getD().setCarinfo(o);
                        getP().getU().initData(getP().getD().getType(),getP().getD().getCarinfo());
                        getP().getD().drvers(getP().getD().getType(), getP().getD().getCarinfo(), new UINetAdapter<ArrayList<DriverRes>>(getActivity()) {
                            @Override
                            public void onSuccess(ArrayList<DriverRes> o) {
                                super.onSuccess(o);
                                getP().getD().ReaddDriverData(o);
                                getP().getU().LoadListData(getP().getD().getDriverRes(),DetailFrag.this);
                            }
                        });
                    }
                });
                break;
            case CarDetailValue.绑定车辆:
                getP().getD().setCarinfo((CarsResBean.CarInfoRes) getArguments().getSerializable(CarDetailValue.数据));
                getP().getD().infoCar(getP().getD().getCarInfoReq(getP().getD().getCarinfo()), new UINetAdapter<CarsResBean.CarInfoRes>(this) {
                    @Override
                    public void onSuccess(CarsResBean.CarInfoRes o) {
                        getP().getD().setCarinfo(o);
                        getP().getU().initData(getP().getD().getType(),getP().getD().getCarinfo());
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
                switch (getP().getD().getType()){
                    case CarDetailValue.新建车辆:
                        if(getP().getD().IsNewCar(getP().getD().getCarinfo())){
                            if(getP().getU().canNewGo()){
                                getP().getD().newCar(getP().getU().getCarNewReqBean(getP().getD().getCarNewReqBean(getP().getD().getCarinfo())), new UINetAdapter<CarsResBean.CarInfoRes>(this,UINetAdapter.Loading,true) {
                                    @Override
                                    public void onSuccess(CarsResBean.CarInfoRes o) {
                                        if(getP().getD().getBindCarReq().isEnable()){
                                            NewCarDAOpe.infoCar(getContext(), o.getCarLicenseNo(), new UINetAdapter<CarsResBean.CarInfoRes>(DetailFrag.this,UINetAdapter.Loading) {
                                                @Override
                                                public void onSuccess(CarsResBean.CarInfoRes o) {
                                                    super.onSuccess(o);
                                                    getP().getD().getBindCarReq().setId(o.getVehicleId());
                                                    getP().getD().bindCar(getP().getD().getBindCarReq(),new UINetAdapter<BindCarRes>(DetailFrag.this,UINetAdapter.Loading,true) {
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
                            if(getP().getU().canNewGo()){
                                getP().getD().updateCar(getP().getU().getUpdateCarReq(getP().getD().getUpdateCarReq(getP().getD().getCarinfo())), new UINetAdapter<UpdateCarRes>(this,UINetAdapter.Loading,true) {
                                    @Override
                                    public void onSuccess(UpdateCarRes o) {
                                        super.onSuccess(o);
                                        if(getP().getD().getBindCarReq().isEnable()){
                                            getP().getD().bindCar(getP().getD().getBindCarReq(),new UINetAdapter<BindCarRes>(DetailFrag.this,UINetAdapter.Loading,true) {
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
                        if(getP().getU().canGo()){
                            getP().getD().updateCar(getP().getU().getUpdateCarReq(getP().getD().getUpdateCarReq(getP().getD().getCarinfo())), new UINetAdapter<UpdateCarRes>(this,UINetAdapter.Loading,true) {
                                @Override
                                public void onSuccess(UpdateCarRes o) {
                                    super.onSuccess(o);
                                    if(getP().getD().getBindCarReq().isEnable()){
                                        getP().getD().bindCar(getP().getD().getBindCarReq(),new UINetAdapter<BindCarRes>(DetailFrag.this,UINetAdapter.Loading,true) {
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
                        if(getP().getU().canGo()){
                            getP().getD().updateCar(getP().getU().getUpdateCarReq(getP().getD().getUpdateCarReq(getP().getD().getCarinfo())), new UINetAdapter<UpdateCarRes>(this) {
                                @Override
                                public void onResult(boolean success, String msg, UpdateCarRes o) {
                                    super.onResult(success, msg, o);
                                    if(success){
                                        getP().getD().bindCar(getP().getD().getDriverBindCarReq(getP().getD().getCarinfo()), new UINetAdapter<BindCarRes>(DetailFrag.this,true) {
                                            @Override
                                            public void onSuccess(BindCarRes o) {
                                                ((MainAct) getBaseUIAct()).getP().getD().getMyceFrag().initUINET();
                                                getBaseUIAct().onBackPressed();
                                            }
                                        });
                                    }
                                }
                            });
                        }
                        break;
                    case CarDetailValue.新建车辆并绑定:
                        if(getP().getU().canNewGo()){
                            getP().getD().newCar(getP().getU().getCarNewReqBean(getP().getD().getCarNewReqBean(getP().getD().getCarinfo())), new UINetAdapter<CarsResBean.CarInfoRes>(this,UINetAdapter.Loading) {
                                @Override
                                public void onSuccess(CarsResBean.CarInfoRes o) {
                                    getP().getD().setCarinfo(o);
                                    CarInfoReq req = new CarInfoReq();
                                    req.setIsApp(1);
                                    req.setCarLicenseNo(StringUtil.getStr(getArguments().getString(CarDetailValue.标题)));
                                    getP().getD().infoCar(req, new UINetAdapter<CarsResBean.CarInfoRes>(DetailFrag.this,UINetAdapter.Loading) {
                                        @Override
                                        public void onSuccess(CarsResBean.CarInfoRes o) {
                                            getP().getD().setCarinfo(o);
                                            getP().getD().bindCar(getP().getD().getDriverBindCarReq(getP().getD().getCarinfo()), new UINetAdapter<BindCarRes>(DetailFrag.this,UINetAdapter.Loading,true) {
                                                @Override
                                                public void onSuccess(BindCarRes o) {
                                                    ((MainAct) getBaseUIAct()).getP().getD().getMyceFrag().initUINET();
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
                switch (getP().getD().getType()){
                    case CarDetailValue.新建车辆:
                        if(getP().getU().nowReInput()){
                            getP().getU().whenClickReInput();
                            getP().getD().getBindCarReq().setEnable(false);
                        }else{
                            if(getP().getU().canSearchCar()){
                                getP().getU().whenClickMakeSure();
                                DetailDAOpe.infoCar(getContext(), getP().getU().getCarNO(), new UINetAdapter<CarsResBean.CarInfoRes>(this, UINetAdapter.Loading) {
                                    @Override
                                    public void onSuccess(CarsResBean.CarInfoRes o) {
                                        super.onSuccess(o);
                                        getP().getD().setCarinfo(o);
                                        getP().getU().initData(getP().getD().getType(),getP().getD().getCarinfo());

                                        getP().getD().drvers(getP().getD().getType(),getP().getD().getCarinfo(), new UINetAdapter<ArrayList<DriverRes>>(getActivity()) {
                                            @Override
                                            public void onSuccess(ArrayList<DriverRes> o) {
                                                super.onSuccess(o);
                                                getP().getD().ReaddDriverData(o);
                                                getP().getU().LoadListData(getP().getD().getDriverRes(),DetailFrag.this);
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

        getP().getD().updateHead(selectList.get(0).getCompressPath(),s, new UINetAdapter<UpdateHeadResBean>(this,true) {
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
                                getP().getD().getCarinfo().setVehicleLicensePhoto(s);
                                break;
                            case 02:
                                getP().getD().getCarinfo().setVehiclePhoto(s);
                                break;
                        }
                        getP().getU().initPhoto(getP().getD().getCarinfo().getVehiclePhoto(),getP().getD().getCarinfo().getVehicleLicensePhoto());
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
                for(int i=0;getP().getD().getDriverRes()!=null&&i<getP().getD().getDriverRes().size();i++){
                    if(pos==i){
                        getP().getD().getDriverRes().get(i).setIsCurrentDriver(DriverRes.是当前驾驶员);
                        getP().getD().getBindCarReq().setEnable(true);
                        getP().getD().getBindCarReq().setCurrentDriver(driverRes.getUserId());
                        getP().getD().getBindCarReq().setId(getP().getD().getCarinfo().getVehicleId());
                    }else{
                        getP().getD().getDriverRes().get(i).setIsCurrentDriver(DriverRes.不当前驾驶员);
                    }
                }
                getP().getU().notifyDataSetChanged();
                break;
        }
    }


    public void bindCar(int userid){
        DriverRes select = null;
        for(int i=0;getP().getD().getDriverRes()!=null&&i<getP().getD().getDriverRes().size();i++){
            if(userid == getP().getD().getDriverRes().get(i).getUserId()){
                select = getP().getD().getDriverRes().get(i);
                getP().getD().getDriverRes().get(i).setIsCurrentDriver(DriverRes.是当前驾驶员);
                getP().getD().getBindCarReq().setEnable(true);
                getP().getD().getBindCarReq().setCurrentDriver(userid);
                getP().getD().getBindCarReq().setId(getP().getD().getCarinfo().getVehicleId());
            }else{
                getP().getD().getDriverRes().get(i).setIsCurrentDriver(DriverRes.不当前驾驶员);
            }
        }
        if(select!=null){
            getP().getD().getDriverRes().remove(select);
            getP().getD().getDriverRes().add(0,select);
        }
        getP().getU().notifyDataSetChanged();
    }
}
