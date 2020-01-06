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
        cityFrag.getDE().setState(state);
        cityFrag.getDE().setCitys(provinceListBean);
        cityFrag.getDE().setProindex(proindex);
        return  cityFrag;
    }


    @Override
    public void initdelay() {
        super.initdelay();
        getUI().initRecycle();
        getUI().LoadListData(getDE().getCitys().getCityList(),this);
    }

    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:
                int pos  = (int) v.getTag(R.id.position);
                switch (getDE().getState()){
                    case 选择一个城市:
                        for(int i=0;i<getDE().getCitys().getCityList().size();i++){
                            getDE().getCitys().getCityList().get(i).setCheckStatus(CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_NULL);
                            if(pos==i){
                                getDE().getCitys().getCityList().get(i).setCheckStatus(CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_FULL);
                            }
                        }
                        break;
                    case 选择多个城市:
                        if(getDE().getCitys().getCityList().get(pos).getCheckStatus()!=CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_FULL){
                            getDE().getCitys().getCityList().get(pos).setCheckStatus(CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_FULL);
                        }else{
                            getDE().getCitys().getCityList().get(pos).setCheckStatus(CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_NULL);
                        }
                        break;
                }
                getUI().notifyDataSetChanged();
                break;
        }
    }

    @OnClick({R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ftv_right2:
                getArguments().putSerializable(ValueConstant.DATA_DATA, getDE().getCitys());
                getArguments().putInt(ValueConstant.DATA_POSITION2,getDE().getProindex());
                getBaseUIAct().onBackPressed();
                break;
        }
    }
}
