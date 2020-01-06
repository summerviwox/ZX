package com.siweisoft.heavycenter.module.myce.unit.area.city;

//by summer on 2017-12-19.

import android.os.Bundle;
import android.view.View;

import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.other.city.CityResBean;

import java.io.Serializable;

import butterknife.OnClick;

public class CityFrag extends AppFrag<CityUIOpe,CityDAOpe> implements ViewListener{


    public static final String 选择一个城市 = "选择一个城市";

    public static final String 选择多个城市 = "选择多个城市";

    public static CityFrag getInstance(String title,String state,CityResBean.ProvinceListBean provinceListBean,int proindex){

        CityFrag cityFrag = new CityFrag();
        cityFrag.setArguments(new Bundle());
        cityFrag.getArguments().putString(ValueConstant.DATA_TYPE,title);
        cityFrag.getArguments().putString(ValueConstant.DATA_DATA2,state);
        cityFrag.getArguments().putSerializable(ValueConstant.DATA_DATA,provinceListBean);
        cityFrag.getArguments().putInt(ValueConstant.DATA_POSITION2,proindex);
        cityFrag.getP().getD().setState(state);
        cityFrag.getP().getD().setCitys(provinceListBean);
        cityFrag.getP().getD().setProindex(proindex);
        return  cityFrag;
    }


    @Override
    public void initdelay() {
        super.initdelay();
        getP().getU().initRecycle();
        getP().getU().LoadListData(getP().getD().getCitys().getCityList(),this);
    }

    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:
                int pos  = (int) v.getTag(R.id.position);
                switch (getP().getD().getState()){
                    case 选择一个城市:
                        for(int i=0;i<getP().getD().getCitys().getCityList().size();i++){
                            getP().getD().getCitys().getCityList().get(i).setCheckStatus(CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_NULL);
                            if(pos==i){
                                getP().getD().getCitys().getCityList().get(i).setCheckStatus(CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_FULL);
                            }
                        }
                        break;
                    case 选择多个城市:
                        if(getP().getD().getCitys().getCityList().get(pos).getCheckStatus()!=CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_FULL){
                            getP().getD().getCitys().getCityList().get(pos).setCheckStatus(CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_FULL);
                        }else{
                            getP().getD().getCitys().getCityList().get(pos).setCheckStatus(CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_NULL);
                        }
                        break;
                }
                getP().getU().notifyDataSetChanged();
                break;
        }
    }

    @OnClick({R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ftv_right2:
                getArguments().putSerializable(ValueConstant.DATA_DATA, getP().getD().getCitys());
                getArguments().putInt(ValueConstant.DATA_POSITION2,getP().getD().getProindex());
                getBaseUIAct().onBackPressed();
                break;
        }
    }
}
