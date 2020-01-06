package com.siweisoft.heavycenter.module.mana.car.news;

//by summer on 2017-12-19.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.android.lib.util.NullUtil;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.mana.car.bind.BindCarReq;
import com.siweisoft.heavycenter.data.netd.mana.car.bind.BindCarRes;
import com.siweisoft.heavycenter.data.netd.mana.car.info.CarInfoReq;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.news.CarNewReqBean;
import com.siweisoft.heavycenter.data.netd.mana.car.news.CarNewResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.update.UpdateCarReq;
import com.siweisoft.heavycenter.data.netd.mana.car.update.UpdateCarRes;
import com.siweisoft.heavycenter.data.netd.unit.dirvers.DriverRes;
import com.siweisoft.heavycenter.data.netd.unit.dirvers.DriversReq;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadReqBean;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadResBean;
import com.siweisoft.heavycenter.module.mana.car.detail.CarDetailValue;

import org.xutils.common.util.KeyValue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NewCarDAOpe extends AppDAOpe {

    CarNewReqBean carNewReqBean = new CarNewReqBean();

    private UpdateCarReq updateCarReq = new UpdateCarReq();

    private CarsResBean.CarInfoRes carInfoRes;

    private ArrayList<DriverRes> driverRes = new ArrayList<>();

    BindCarReq bindCarReq = new BindCarReq();


    public void newCar(CarNewReqBean carNewReqBean, NetI<CarsResBean.CarInfoRes> adapter){
        NetDataOpe.Mana.Car.newCar(getActivity(),carNewReqBean,adapter);
    }


    public static void infoCar(Context context,String carno,NetI<CarsResBean.CarInfoRes> adapter){
        CarInfoReq carInfoReq = new CarInfoReq();
        carInfoReq.setCarLicenseNo(carno);
        carInfoReq.setIsApp(1);
        NetDataOpe.Mana.Car.infoCar(context,carInfoReq,adapter);
    }

    public void updateCar(UpdateCarReq updateCarReq,NetI<UpdateCarRes> adapter){
        NetDataOpe.Mana.Car.updateCar(getActivity(),updateCarReq,adapter);
    }

    public UpdateCarReq getUpdateCarReq(CarsResBean.CarInfoRes carinfo) {
        updateCarReq.setId(carinfo.getVehicleId());
        updateCarReq.setEditer(LocalValue.get登录返回信息().getUserId());
        updateCarReq.setCarLicenseNo(carinfo.getCarLicenseNo());
        updateCarReq.setVehiclePhoto(carinfo.getVehiclePhoto());
        updateCarReq.setVehicleLicensePhoto(carinfo.getVehicleLicensePhoto());
        return updateCarReq;
    }


    public CarNewReqBean getCarNewReqBean(CarsResBean.CarInfoRes carinfo) {
        carNewReqBean.setVehicleLicensePhoto(carinfo.getVehicleLicensePhoto());
        carNewReqBean.setVehiclePhoto(carinfo.getVehiclePhoto());
        carNewReqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        carNewReqBean.setCreater(LocalValue.get登录返回信息().getUserId());
        return carNewReqBean;
    }

    public void updateHead(String path,String type, NetI<UpdateHeadResBean> adapter){
        List<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(new KeyValue(UpdateHeadReqBean.用户id, LocalValue.get登录返回信息().getUserId()));
        keyValues.add(new KeyValue(UpdateHeadReqBean.文件类型,type));
        keyValues.add(new KeyValue(UpdateHeadReqBean.文件路径,new File(path)));
        NetDataOpe.User.uploadPhoto(getActivity(),keyValues,adapter);
    }


    public void drvers(CarsResBean.CarInfoRes info,NetI<ArrayList<DriverRes>> adapter){
        DriversReq driversReq = new DriversReq();
        driversReq.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        driversReq.setVehicleId(info.getVehicleId());
        NetDataOpe.Unit.drvers(getActivity(),driversReq,adapter);
    }



    public void bindCar(  BindCarReq bindCarReq,NetI<BindCarRes> adapter){
        NetDataOpe.Mana.Car.bindCar(getActivity(),bindCarReq,adapter);
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////


    public BindCarReq getBindCarReq() {
        return bindCarReq;
    }

    public ArrayList<DriverRes> getDriverRes() {
        return driverRes;
    }


    public CarsResBean.CarInfoRes getCarInfoRes() {
        return carInfoRes;
    }

    public void setCarInfoRes(CarsResBean.CarInfoRes carInfoRes) {
        this.carInfoRes = carInfoRes;
    }

    public boolean IsNewCar(){
        if(getCarInfoRes()==null|| NullUtil.isStrEmpty(getCarInfoRes().getCarLicenseNo())){
            return true;
        }
        return false;
    }
}
