package com.siweisoft.heavycenter.module.mana.car;

//by summer on 2017-12-14.

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.constant.ValueConstant;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsReqBean;
import com.siweisoft.heavycenter.module.mana.car.car.CarFrag;
import com.siweisoft.heavycenter.module.mana.car.car.CarValue;

import java.util.ArrayList;

public class CarsDAOpe extends AppDAOpe {


    private  ArrayList<Fragment> pages = new ArrayList<>();



    public void initPages(){
        pages.clear();
        String[] str = new String[]{CarsReqBean.WHAT_FH,CarsReqBean.WHAT_MY,CarsReqBean.WHAT_SH};
        for(int i=0;i<str.length;i++){
            CarFrag sendFrag = CarFrag.getInstance("车辆列表",str[i],CarValue.管理车辆);
            sendFrag.getArguments().putString(ValueConstant.容器,getFrag().get容器());
            sendFrag.getP().getD().setCarsFrag((CarsFrag) getFrag());
            pages.add(sendFrag);
        }
    }

    public ArrayList<Fragment> getPages() {
        return pages;
    }
}
