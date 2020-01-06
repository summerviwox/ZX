package com.siweisoft.heavycenter.module.main.weights.weights;

//by summer on 2017-12-11.

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.NetI;
import com.android.lib.util.NullUtil;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.jpush.WeightMsg;
import com.siweisoft.heavycenter.data.netd.weight.list.WeightListReq;
import com.siweisoft.heavycenter.data.netd.weight.list.WeightListRes;
import com.siweisoft.heavycenter.data.netd.weight.save.SaveWeightReq;
import com.siweisoft.heavycenter.data.netd.weight.save.SaveWeightRes;
import com.siweisoft.heavycenter.module.main.weights.weight.WeigtFrag;

import java.util.ArrayList;

public class WeightsDAOpe extends AppDAOpe {


    private  WeightMsg weightMsg;

    private ArrayList<Fragment> pages = new ArrayList<>();

    private ArrayList<Fragment> bottomFrag = new ArrayList<>();


    public ArrayList<Fragment> initPages(){
        pages.clear();
        for(int i=0;i<5;i++){
            pages.add(WeigtFrag.getInstance(getFrag().get容器()));
        }
        return pages;
    }

    public ArrayList<Fragment> getPages() {
        if(pages==null){
            initPages();
        }
        return pages;
    }


    public void listWeight(NetI<WeightListRes> adapter){
        WeightListReq weightListReq = new WeightListReq();
        weightListReq.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        weightListReq.setPageIndex(0);
        weightListReq.setPageSize(1000);
        NetDataOpe.Weight.listWeight(getActivity(),weightListReq,adapter);
    }

    public void saveWeight(WeightMsg weightMsg , NetI<SaveWeightRes> adapter){
        if(weightMsg==null||weightMsg.getMessage()==null){
            return;
        }
        SaveWeightReq weightReq = new SaveWeightReq();
        weightReq.setOrderId(weightMsg.getMessage().getOrder().getOrderId());
        weightReq.setTransportRecordId(weightMsg.getMessage().getOrder().getYsdId());
        weightReq.setState(weightMsg.getMessage().getState());
        if(NullUtil.isStrEmpty(weightMsg.getMessage().getState())){
            ToastUtil.getInstance().showShort(getActivity(),"没有返回状态码");
            return;
        }
        switch (weightMsg.getMessage().getState()){
            case "s0":
            case "sF":
            case "s3":
            case "s7":
            case "sD":
            case "s5":
            case "rF":
            case "r5":
            case "r7":
            case "rD":
                weightReq.setWeighLocation(SaveWeightReq.皮重);
                break;
            case "s1":
            case "r1":
            case "r3":
                weightReq.setWeighLocation(SaveWeightReq.毛重);
                break;
        }
        weightReq.setWeighing(weightMsg.getMessage().getWeigh());
        weightReq.setOrderId(weightMsg.getMessage().getOrder().getOrderId());
        weightReq.setDeductWeight(0);
        weightReq.setDriverId(weightMsg.getMessage().getOrder().getDriverId());
        NetDataOpe.Weight.saveWeight(getActivity(),weightReq,adapter);
    }

    public WeightMsg getWeightMsg() {
        return weightMsg;
    }

    public void setWeightMsg(WeightMsg weightMsg) {
        this.weightMsg = weightMsg;
    }
}
