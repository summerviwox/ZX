package com.siweisoft.heavycenter.module.myce.car.bind;

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
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsReqBean;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;

import java.util.ArrayList;

public class BindDAOpe extends AppDAOpe {

    BindCarReq bindCarReq  = new BindCarReq();

    CarsResBean netCars = new CarsResBean();


    CarsResBean selCars = new CarsResBean();


    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        for(int i=0;i<100;i++){
            data.add(""+i);
        }
        return data;
    }

    public void Cars(NetI<CarsResBean> adapter){
        CarsReqBean carsReqBean = new CarsReqBean();
        carsReqBean.setIsApp(1);
        carsReqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        carsReqBean.setPageIndex(0);
        carsReqBean.setPageSize(1000);
        carsReqBean.setWhat(CarsReqBean.WHAT_MY);
        NetDataOpe.Mana.Car.Cars(getActivity(),carsReqBean,adapter);
    }

    public BindCarReq getBindCarReq() {
        return bindCarReq;
    }

    public void bindCar(int carid,NetI<BindCarRes> adapter){
        getBindCarReq().setCurrentDriver(LocalValue.get登录返回信息().getUserId());
        getBindCarReq().setId(carid);
        getBindCarReq().setEditer(LocalValue.get登录返回信息().getUserId());
        NetDataOpe.Mana.Car.bindCar(getActivity(),getBindCarReq(),adapter);
    }


    public void infoCar(String calicenseno,NetI<CarsResBean.CarInfoRes> adapter){
        CarInfoReq carInfoReq = new CarInfoReq();
        carInfoReq.setCarLicenseNo(calicenseno);
        carInfoReq.setIsApp(1);
        NetDataOpe.Mana.Car.infoCar(getActivity(),carInfoReq,adapter);
    }


    public CarsResBean getNetCars() {
        return netCars;
    }

    public void setNetCars(CarsResBean netCars) {
        this.netCars = netCars;
    }

    public CarsResBean getSelCars(String key) {
        if(NullUtil.isStrEmpty(key)){
            return netCars;
        }
        selCars.getResults().clear();
        for(int i=0;netCars!=null &&netCars.getResults()!=null && i<netCars.getResults().size();i++){
            if((netCars.getResults().get(i).getCarBrand()+""+netCars.getResults().get(i).getCarLicenseNo()+netCars.getResults().get(i).getCompanyName()+netCars.getResults().get(i).getIcCard()
                    +netCars.getResults().get(i).getSpecifications()+netCars.getResults().get(i).getTel()+""+netCars.getResults().get(i).getTrueName()).contains(key)){
                selCars.getResults().add(netCars.getResults().get(i));
            }
        }
        return selCars;
    }

    public void setSelCars(CarsResBean selCars) {
        this.selCars = selCars;
    }
}
