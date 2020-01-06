package com.siweisoft.heavycenter.module.myce.unit.area.prov;

//by summer on 2017-12-19.

import android.os.Bundle;
import android.view.View;

import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.other.city.CityResBean;
import com.siweisoft.heavycenter.module.myce.unit.area.city.CityFrag;

import java.io.Serializable;

import butterknife.OnClick;

public class ProvFrag extends AppFrag<ProvUIOpe,ProvDAOpe> implements ViewListener{

    public static final String 选择一个城市 = "选择一个城市";

    public static final String 选择多个城市 = "选择多个城市";

    public static final String 选择省 = "选择省";


    public static ProvFrag getInstance(String state,String title){
        ProvFrag provFrag = new ProvFrag();
        provFrag.setArguments(new Bundle());
        provFrag.getArguments().putString(ValueConstant.DATA_DATA,state);
        provFrag.getArguments().putString(ValueConstant.DATA_TYPE,title);
        provFrag.getDE().setState(state);
        return provFrag;
    }

    @Override
    public void initNow() {
        super.initNow();
        getUI().initRecycle();
        getUI().LoadListData(getDE().getPro(),this);
    }

    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:
                switch (v.getId()){
                    case R.id.iv_state:
                        CityResBean.ProvinceListBean list = (CityResBean.ProvinceListBean)v.getTag(R.id.data);
                        for(int i=0;i<list.getCityList().size();i++){
                            if(list.getCheckStatus()==CityResBean.ProvinceListBean.CHECK_STATE_FULL){
                                list.getCityList().get(i).setCheckStatus(CityResBean.ProvinceListBean.CHECK_STATE_NULL);
                            }else{
                                list.getCityList().get(i).setCheckStatus(CityResBean.ProvinceListBean.CHECK_STATE_FULL);
                            }

                        }
                        getArguments().putInt(ValueConstant.DATA_POSITION2,(int) v.getTag(R.id.position));
                        getArguments().putSerializable(ValueConstant.DATA_DATA,list);
                        onResult(1,getArguments());
                        break;
                    default:
                        FragManager2.getInstance().start(getBaseUIAct(), get容器(),
                                CityFrag.getInstance("选择城市",getDE().getState(), (CityResBean.ProvinceListBean) v.getTag(R.id.data),(int) v.getTag(R.id.position)));
                        break;
                }
                break;
        }
    }


    @Override
    public void onResult(int res, Bundle bundle) {
        int proindex = bundle.getInt(ValueConstant.DATA_POSITION2,-1);
        if(proindex==-1){
            return;
        }
        CityResBean.ProvinceListBean citys  = (CityResBean.ProvinceListBean) bundle.getSerializable(ValueConstant.DATA_DATA);
        int num=0;
        for(int i=0;i<citys.getCityList().size();i++) {
            if (citys.getCityList().get(i).getCheckStatus() == CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_FULL) {
                ++num;
            }
        }
        if(num==citys.getCityList().size()){
            getDE().getPro().get(proindex).setCheckStatus(CityResBean.ProvinceListBean.CHECK_STATE_FULL);
        }else if(num==0){
            getDE().getPro().get(proindex).setCheckStatus(CityResBean.ProvinceListBean.CHECK_STATE_NULL);
        }else{
            getDE().getPro().get(proindex).setCheckStatus(CityResBean.ProvinceListBean.CHECK_STATE_HALF);
        }
        getUI().notifyDataSetChanged();

        getDE().setS("");
        getDE().setS2("");

        for(int i=0;i<getDE().getPro().size();i++){
            if(getDE().getPro().get(i).getCheckStatus()== CityResBean.ProvinceListBean.CHECK_STATE_NULL){
                continue;
            }
            if(getDE().getPro().get(i).getCheckStatus()== CityResBean.ProvinceListBean.CHECK_STATE_FULL){
                getDE().setS(getDE().getS()+getDE().getPro().get(i).getValue()+",");
                getDE().setS2(getDE().getS2()+getDE().getPro().get(i).getName()+",");
                continue;
            }
            if(getDE().getPro().get(i).getCityList()==null){
                continue;
            }
            for(int j=0;j<getDE().getPro().get(i).getCityList().size();j++){
                if(getDE().getPro().get(i).getCityList().get(j).getCheckStatus()== CityResBean.ProvinceListBean.CityListBean.CHECK_STATE_FULL){
                    getDE().setS(getDE().getS()+getDE().getPro().get(i).getCityList().get(j).getValue()+",");
                    getDE().setS2(getDE().getS2()+getDE().getPro().get(i).getCityList().get(j).getName()+",");
                }
            }
        }
        if(getDE().getS().endsWith(",")){
            getDE().setS(getDE().getS().substring(0,getDE().getS().length()-1));
            getDE().setS2(getDE().getS2().substring(0,getDE().getS2().length()-1));
        }
    }


    @OnClick({R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.ftv_right2:
                getArguments().putBoolean(ValueConstant.DATA_INTENT2,true);
                getArguments().putString(ValueConstant.DATA_RES, getDE().getS());
                getArguments().putString(ValueConstant.DATA_RES2, getDE().getS2());
                getBaseUIAct().onBackPressed();
                break;
        }
    }
}
