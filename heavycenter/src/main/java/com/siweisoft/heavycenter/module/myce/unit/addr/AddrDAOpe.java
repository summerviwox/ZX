package com.siweisoft.heavycenter.module.myce.unit.addr;

//by summer on 2017-12-19.

import android.content.Context;

import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.PoiAddrInfo;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;
import com.siweisoft.heavycenter.module.view.map.MapUtil;

import java.util.ArrayList;
import java.util.List;

public class AddrDAOpe extends AppDAOpe {

    private UnitInfo unitInfo = new UnitInfo();

    private List<PoiInfo> addrs = new ArrayList<>();

    private int index = 1;



    public MapUtil getMapUtil() {
        return MapUtil.getInstance();
    }


    public void  stopMap(){
        if(getMapUtil().getLocationClient()==null){
            return;
        }
        getMapUtil().getLocationClient().stop();
    }

    public void startMap(){
        if(getMapUtil().getLocationClient()==null){
            return;
        }
        getMapUtil().getLocationClient().start();
    }

    public List<PoiInfo> getAddrs() {
        return addrs;
    }

    public void setAddrs(List<PoiInfo> addrs) {
        if(addrs==null){
            return;
        }
        this.addrs.clear();
        this.addrs.addAll(addrs);
    }

    public void addAddrs(List<PoiInfo> addrs) {
        if(addrs==null){
            return;
        }
        this.addrs.addAll(addrs);
    }

    public UnitInfo getUnitInfo() {
        return unitInfo;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
