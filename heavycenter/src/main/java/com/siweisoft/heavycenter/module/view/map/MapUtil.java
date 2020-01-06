package com.siweisoft.heavycenter.module.view.map;

//by summer on 2017-12-13.

import android.content.Context;

import com.android.lib.util.LogUtil;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.poi.PoiSortType;
import com.siweisoft.heavycenter.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MapUtil {

    private static LocationClientOption mOption=null;

    private MapView mapView;

    private static LocationClient locationClient;

    private static MapUtil instance;

    private boolean isFirst = true;

    private boolean isAdd  = false;

    private int scantime = 3000;

    private MapUtil(){

    }

    public static MapUtil getInstance(){
        if(instance==null){
            instance = new MapUtil();
        }
        return instance;
    }


    public  void init(Context context){
        if(mOption!=null){
            return;
        }
        mOption = new LocationClientOption();
        mOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        mOption.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系，如果配合百度地图使用，建议设置为bd09ll;
        mOption.setScanSpan(3000);//可选，默认0，即仅定位一次，设置发起连续定位请求的间隔需要大于等于1000ms才是有效的
        mOption.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        mOption.setIsNeedLocationDescribe(true);//可选，设置是否需要地址描述
        mOption.setNeedDeviceDirect(false);//可选，设置是否需要设备方向结果
        mOption.setLocationNotify(false);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        mOption.setIgnoreKillProcess(true);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        mOption.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        mOption.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        mOption.SetIgnoreCacheException(true);//可选，默认false，设置是否收集CRASH信息，默认收集
        mOption.setOpenGps(true);//可选，默认false，设置是否开启Gps定位
        mOption.setIsNeedAltitude(false);//可选，默认false，设置定位时是否需要海拔信息，默认不需要，除基础定位版本都可用

        locationClient = new LocationClient(context.getApplicationContext());
        locationClient.setLocOption(mOption);
    }

    public void init(Context context,boolean once){
        if(mOption!=null){
            return;
        }
        mOption = new LocationClientOption();
        mOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        mOption.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系，如果配合百度地图使用，建议设置为bd09ll;
        if(once){
            mOption.setScanSpan(0);//可选，默认0，即仅定位一次，设置发起连续定位请求的间隔需要大于等于1000ms才是有效的
        }else{
            mOption.setScanSpan(3000);//可选，默认0，即仅定位一次，设置发起连续定位请求的间隔需要大于等于1000ms才是有效的
        }
        mOption.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        mOption.setIsNeedLocationDescribe(true);//可选，设置是否需要地址描述
        mOption.setNeedDeviceDirect(false);//可选，设置是否需要设备方向结果
        mOption.setLocationNotify(false);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        mOption.setIgnoreKillProcess(true);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        mOption.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        mOption.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        mOption.SetIgnoreCacheException(true);//可选，默认false，设置是否收集CRASH信息，默认收集
        mOption.setOpenGps(true);//可选，默认false，设置是否开启Gps定位
        mOption.setIsNeedAltitude(false);//可选，默认false，设置定位时是否需要海拔信息，默认不需要，除基础定位版本都可用

        locationClient = new LocationClient(context.getApplicationContext());
        locationClient.setLocOption(mOption);
    }

    public void registerLocationListener(Context context,BDAbstractLocationListener listener){
        if(mOption==null){
            init(context);
        }
        locationClient.registerLocationListener(listener);
    }

    public void setMyLocationData(BaiduMap map,BDLocation bdLocation){
        map.setMyLocationEnabled(true);
        MyLocationData.Builder locationBuilder = new MyLocationData.Builder();
        locationBuilder.accuracy(bdLocation.getRadius()).direction(100);
        locationBuilder.latitude(bdLocation.getLatitude());
        locationBuilder.longitude(bdLocation.getLongitude());
        MyLocationData locationData = locationBuilder.build();
        map.setMyLocationData(locationData);
    }

    public void animateMapStatus(BaiduMap map,BDLocation bdLocation){
        if(isFirst()){
            map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL,true, BitmapDescriptorFactory.fromResource(R.drawable.drawable_setting)));
            map.setMyLocationEnabled(true);
            LatLng latLng = new LatLng(bdLocation.getLatitude(),bdLocation.getLongitude());
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target(latLng).zoom(16f);
            map.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));

            if(BigDecimal.valueOf(map.getMapStatus().target.latitude).setScale(5, RoundingMode.HALF_UP).doubleValue()==BigDecimal.valueOf(bdLocation.getLatitude()).setScale(5, RoundingMode.HALF_UP).doubleValue()
                    &&BigDecimal.valueOf(map.getMapStatus().target.longitude).setScale(5, RoundingMode.HALF_UP).doubleValue()==BigDecimal.valueOf(bdLocation.getLongitude()).setScale(5, RoundingMode.HALF_UP).doubleValue()){
                setFirst(false);
            }else{
                setFirst(true);
            }

        }
    }


    public void animateMapStatus2(BaiduMap map,BDLocation bdLocation){
        map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL,true, BitmapDescriptorFactory.fromResource(R.drawable.drawable_setting)));
        map.setMyLocationEnabled(true);
        LatLng latLng = new LatLng(bdLocation.getLatitude(),bdLocation.getLongitude());
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.target(latLng).zoom(16f);
        map.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
    }


    public void addOverlays(BaiduMap map,LatLng... latLngs){
        if(isAdd){
            return;
        }
        List<OverlayOptions> options = new ArrayList<>();
        for(int i=0;i<latLngs.length;i++){
            options.add(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_gou)).position(latLngs[i]));

        }
        map.addOverlays(options);
        isAdd= true;
    }

      PoiSearch poiSearch;
    public void searchNeayBy(String city,String key,OnGetPoiSearchResultListener var1) {
        if(poiSearch==null){
            poiSearch = PoiSearch.newInstance();
        }
        PoiCitySearchOption poiCitySearchOption = new PoiCitySearchOption();
        poiCitySearchOption.city(city).keyword(key).pageNum(20);
        poiSearch.setOnGetPoiSearchResultListener(var1);
        poiSearch.searchInCity(poiCitySearchOption);
    }


    public PoiSearch getPoiSearch() {
        return poiSearch;
    }

    public LocationClientOption getmOption() {
        return mOption;
    }

    public MapView getMapView() {
        return mapView;
    }

    public LocationClient getLocationClient() {
        return locationClient;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public int getScantime() {
        return scantime;
    }

    public void setScantime(int scantime) {
        this.scantime = scantime;
    }
}
