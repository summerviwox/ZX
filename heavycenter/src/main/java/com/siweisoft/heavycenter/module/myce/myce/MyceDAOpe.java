package com.siweisoft.heavycenter.module.myce.myce;

//by summer on 2017-12-14.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.update.UpdateCarReq;
import com.siweisoft.heavycenter.data.netd.mana.car.update.UpdateCarRes;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadReqBean;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadResBean;
import com.siweisoft.heavycenter.data.netd.user.info.UserInfoReqBean;
import com.siweisoft.heavycenter.data.netd.weight.list.WeightListReq;
import com.siweisoft.heavycenter.data.netd.weight.list.WeightListRes;

import org.xutils.common.util.KeyValue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyceDAOpe extends AppDAOpe {



    public void uploadPhoto(File f, String type, NetI<UpdateHeadResBean> adapter){
        List<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(new KeyValue(UpdateHeadReqBean.用户id,LocalValue.get登录返回信息().getUserId()));
        keyValues.add(new KeyValue(UpdateHeadReqBean.文件类型,type));
        keyValues.add(new KeyValue(UpdateHeadReqBean.文件路径,f));
        NetDataOpe.User.uploadPhoto(getActivity(),keyValues,adapter);
    }

    public void updateHead(String headfile,NetI<UpdateHeadResBean> adapter){
        UpdateHeadReqBean updateHeadReqBean = new UpdateHeadReqBean();
        updateHeadReqBean.setId(LocalValue.get登录返回信息().getUserId());
        updateHeadReqBean.setMyFile(headfile);
        NetDataOpe.User.updatePhoto(getActivity(),updateHeadReqBean,adapter);
    }

    public void updateCar(NetI<UpdateCarRes> adapter){
        UpdateCarReq updateCarReq = new UpdateCarReq();
        updateCarReq.setId(LocalValue.get登录返回信息().getVehicleId());
        updateCarReq.setCarLicenseNo(LocalValue.get登录返回信息().getCarLicenseNo());
        updateCarReq.setCarBrand(LocalValue.get登录返回信息().getCarBrand());
        updateCarReq.setVehiclePhoto(LocalValue.get登录返回信息().getVehiclePhoto());
        updateCarReq.setVehicleLicensePhoto(LocalValue.get登录返回信息().getVehicleLicensePhoto());
        updateCarReq.setMaxCapacity(LocalValue.get登录返回信息().getMaxCapacity());
        updateCarReq.setEmptyWeight(LocalValue.get登录返回信息().getEmptyWeight());
        updateCarReq.setIcCard(LocalValue.get登录返回信息().getIcCard());
        updateCarReq.setEditer(LocalValue.get登录返回信息().getUserId());
        NetDataOpe.Mana.Car.updateCar(getActivity(),updateCarReq,adapter);
    }


    public void getInfo(NetI<LoginResBean> adapter){

        UserInfoReqBean userInfoReqBean = new UserInfoReqBean();
        userInfoReqBean.setId(LocalValue.get登录返回信息().getUserId());
        userInfoReqBean.setIsApp(1);
        NetDataOpe.User.get用户信息(getActivity(),userInfoReqBean,adapter);
    }

}
