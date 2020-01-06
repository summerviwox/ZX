package com.siweisoft.heavycenter.module.myce.unit.area.city;

//by summer on 2017-12-19.

import android.content.Context;

import com.android.lib.util.NullUtil;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.netd.other.city.CityResBean;
import com.siweisoft.heavycenter.module.myce.unit.area.prov.ProvFrag;

import java.util.ArrayList;

public class CityDAOpe extends AppDAOpe {

    CityResBean.ProvinceListBean citys;

    int proindex=0;

    private String state = CityFrag.选择多个城市;



    public CityResBean.ProvinceListBean getCitys() {
        return citys;
    }

    public void setCitys(CityResBean.ProvinceListBean citys) {
        this.citys = citys;
    }

    public int getProindex() {
        return proindex;
    }

    public void setProindex(int proindex) {
        this.proindex = proindex;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        if(NullUtil.isStrEmpty(state)){
            return;
        }
        this.state = state;
    }
}
