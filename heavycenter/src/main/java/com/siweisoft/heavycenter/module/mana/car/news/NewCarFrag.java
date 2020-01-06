package com.siweisoft.heavycenter.module.mana.car.news;

//by summer on 2017-12-19.

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.bean.res.BaseResBean;
import com.android.lib.network.news.NetAdapter;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.IntentUtil;
import com.android.lib.util.LoadUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.scwang.smartrefresh.layout.footer.FalsifyFooter;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.mana.car.bind.BindCarRes;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.news.CarNewResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.update.UpdateCarRes;
import com.siweisoft.heavycenter.data.netd.unit.dirvers.DriverRes;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadReqBean;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadResBean;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.mana.car.detail.CarDetailValue;
import com.siweisoft.heavycenter.module.mana.car.detail.DetailFrag;
import com.siweisoft.heavycenter.module.mana.user.list.UserDAOpe;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

public class NewCarFrag extends AppFrag<NewCarUIOpe,NewCarDAOpe> implements ViewListener {


    public static NewCarFrag getInstance(){
        NewCarFrag newCarFrag = new NewCarFrag();
        newCarFrag.setArguments(new Bundle());
        return newCarFrag;
    }

    @Override
    public void initdelay() {
        super.initdelay();

    }

    @OnClick({R.id.ftv_right2,R.id.tv_y,R.id.iv_vehicleLicensePhoto,R.id.iv_vehiclePhoto})
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
                if(getDE().IsNewCar()){
                    if(getUI().canNewGo()){
                        getDE().newCar(getUI().getCarNewReqBean(getDE().getCarNewReqBean(getDE().getCarInfoRes())), new UINetAdapter<CarsResBean.CarInfoRes>(this,UINetAdapter.Loading,true) {
                            @Override
                            public void onSuccess(CarsResBean.CarInfoRes o) {
                                if(getDE().getBindCarReq().isEnable()){
                                    NewCarDAOpe.infoCar(getContext(), o.getCarLicenseNo(), new UINetAdapter<CarsResBean.CarInfoRes>(NewCarFrag.this,UINetAdapter.Loading) {
                                        @Override
                                        public void onSuccess(CarsResBean.CarInfoRes o) {
                                            super.onSuccess(o);
                                            getDE().getBindCarReq().setId(o.getVehicleId());
                                            getDE().bindCar(getDE().getBindCarReq(),new UINetAdapter<BindCarRes>(NewCarFrag.this,UINetAdapter.Loading,true) {
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
                        getDE().updateCar(getUI().getUpdateCarReq(getDE().getUpdateCarReq(getDE().getCarInfoRes())), new UINetAdapter<UpdateCarRes>(this,UINetAdapter.Loading,true) {
                            @Override
                            public void onSuccess(UpdateCarRes o) {
                                super.onSuccess(o);
                                if(getDE().getBindCarReq().isEnable()){
                                    getDE().bindCar(getDE().getBindCarReq(),new UINetAdapter<BindCarRes>(NewCarFrag.this,UINetAdapter.Loading,true) {
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
            case R.id.tv_y:
                if(getUI().nowReInput()){
                    getUI().showCotent(false);
                    getUI().bind.etName.setText("");
                    getUI().bind.tvY.setText("确定");
                    getUI().bind.etName.setEnabled(true);
                    getDE().getBindCarReq().setId(0);
                    getDE().getBindCarReq().setEnable(false);
                }else{
                    if(getUI().canSearch()){
                        getUI().showCotent(true);
                        NewCarDAOpe.infoCar(getContext(), getUI().getCarNO(), new UINetAdapter<CarsResBean.CarInfoRes>(this, UINetAdapter.Loading) {
                            @Override
                            public void onSuccess(CarsResBean.CarInfoRes o) {
                                super.onSuccess(o);
                                getDE().setCarInfoRes(o);
                                getUI().initData(getDE().getCarInfoRes());
                                getUI().bind.tvY.setText("重新输入");
                                getUI().bind.etName.setEnabled(false);

                                getDE().drvers(getDE().getCarInfoRes(), new UINetAdapter<ArrayList<DriverRes>>(getActivity()) {
                                    @Override
                                    public void onSuccess(ArrayList<DriverRes> o) {
                                        super.onSuccess(o);
                                        getDE().getDriverRes().clear();
                                        if(o!=null){
                                            getDE().getDriverRes().addAll(o);
                                            getUI().LoadListData(getDE().getDriverRes(),NewCarFrag.this);
                                        }
                                    }
                                });
                            }
                        });
                    }
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
                                getDE().getCarInfoRes().setVehicleLicensePhoto(s);
                                break;
                            case 02:
                                getDE().getCarInfoRes().setVehiclePhoto(s);
                                break;
                        }
                        getUI().initPhoto(getDE().getCarInfoRes().getVehiclePhoto(),getDE().getCarInfoRes().getVehicleLicensePhoto());
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
                        getDE().getBindCarReq().setId(getDE().getCarInfoRes().getVehicleId());
                    }else{
                        getDE().getDriverRes().get(i).setIsCurrentDriver(DriverRes.不当前驾驶员);
                    }
                }
                getUI().notifyDataSetChanged();
                break;
        }
    }

    public void bindCar(int userid){
        for(int i=0;getDE().getDriverRes()!=null&&i<getDE().getDriverRes().size();i++){
            if(userid == getDE().getDriverRes().get(i).getUserId()){
                getDE().getDriverRes().get(i).setIsCurrentDriver(DriverRes.是当前驾驶员);
                getDE().getBindCarReq().setEnable(true);
                getDE().getBindCarReq().setCurrentDriver(userid);
                getDE().getBindCarReq().setId(getDE().getCarInfoRes().getVehicleId());
            }else{
                getDE().getDriverRes().get(i).setIsCurrentDriver(DriverRes.不当前驾驶员);
            }
        }
        getUI().notifyDataSetChanged();
    }
}
