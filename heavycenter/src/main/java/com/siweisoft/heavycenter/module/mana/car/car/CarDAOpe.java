package com.siweisoft.heavycenter.module.mana.car.car;

//by summer on 2017-12-19.

import com.android.lib.network.news.NetI;
import com.android.lib.util.LogUtil;
import com.android.lib.util.NullUtil;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsReqBean;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.status.StopCarReqBean;
import com.siweisoft.heavycenter.data.netd.mana.car.status.StopCarResBean;
import com.siweisoft.heavycenter.module.mana.car.CarsFrag;

import java.util.ArrayList;

public class CarDAOpe extends AppDAOpe {

    CarsReqBean carsReqBean = new CarsReqBean();

    CarsResBean netcarsRes = new CarsResBean();


    CarsFrag carsFrag;

    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        for(int i=0;i<100;i++){
            data.add(""+i);
        }
        return data;
    }


    public void initCarReq(String moudle,Integer status){
        carsReqBean.setIsApp(1);
        carsReqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        carsReqBean.setPageIndex(0);
        carsReqBean.setPageSize(1000);
        carsReqBean.setStatus(status);
        carsReqBean.setWhat(moudle);
    }

    public void Cars(CarsReqBean carsReqBean,NetI<CarsResBean> adapter){
        NetDataOpe.Mana.Car.Cars(getActivity(),carsReqBean,adapter);
    }

    public Integer getReqStatus(int status){
        switch (status){
            case CarValue.选择车辆:
                return CarValue.启用;
            default:
                return CarValue.全部;
        }
    }


    public void statusCar(int carid, int status, NetI<StopCarResBean> adapter){
        StopCarReqBean reqBean = new StopCarReqBean();
        reqBean.setEditer(LocalValue.get登录返回信息().getUserId());
        reqBean.setId(carid);
        reqBean.setStatus(status== CarsResBean.CarInfoRes.STATUS_OFF? CarsResBean.CarInfoRes.STATUS_ON: CarsResBean.CarInfoRes.STATUS_OFF);
        NetDataOpe.Mana.Car.statusCar(getActivity(),reqBean,adapter);
    }


    public CarsResBean getNetcarsRes() {
        return netcarsRes;
    }

    public void setNetcarsRes(CarsResBean netcarsRes) {
        this.netcarsRes = netcarsRes;
    }

    public CarsResBean searchCar(String name){
        CarsResBean searchCarRes = new CarsResBean();
        if(NullUtil.isStrEmpty(name)){
            return netcarsRes;
        }
        for(int i = 0; getNetcarsRes()!=null&& i< getNetcarsRes().getResults().size(); i++){
            if(getNetcarsRes().getResults().get(i).getCarLicenseNo().contains(name)){
                searchCarRes.getResults().add(getNetcarsRes().getResults().get(i));
            }
        }
        return searchCarRes;
    }

    public CarsReqBean getCarsReqBean() {
        return carsReqBean;
    }

    public CarsFrag getCarsFrag() {
        return carsFrag;
    }

    public void setCarsFrag(CarsFrag carsFrag) {
        this.carsFrag = carsFrag;
    }
}
