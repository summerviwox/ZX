package com.siweisoft.heavycenter.data.locd;

//by summer on 2018-01-10.

import com.android.lib.constant.ValueConstant;
import com.android.lib.util.GsonUtil;
import com.android.lib.util.SPUtil;
import com.google.gson.reflect.TypeToken;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginReqBean;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.other.city.CityResBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocalValue {

    public static final String 登录返回信息 ="登录返回信息";

    public static final String 登录参数 = "登录参数";

    public static final String 省市列表接口数据 = "省市列表接口数据";

    public static final String 省Map = "省Map";

    public static final String 市名找代码 = "市名找代码";

    public static final String 代码找市名 = "代码找市名";

    public static final String 市Map = "市Map";

    public static final String 省市排序列表 = "省市排序列表";

    public static final String[] pros = new String[]{
            "安徽","澳门","北京",
            "重庆","福建","",
            "广东","广西","贵州",
            "甘肃","河北","河南",
            "黑龙江","湖北","湖南",
            "海南","吉林","江西",
            "江苏","辽宁","内蒙古",
            "宁夏","青海","上海",
            "山东","山西","四川",
            "陕西","天津","台湾",
            "西藏","新疆","香港",
            "云南","浙江","",
    };




    public static boolean is自动登录(){
        return  SPUtil.getInstance().getBoolean(ValueConstant.AUTO_LOGIN);
    }

    public static void set自动登录(boolean autoLogin){
        SPUtil.getInstance().saveBoolean(ValueConstant.AUTO_LOGIN,autoLogin);
    }

    public static LoginResBean get登录返回信息(){
        return GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(登录返回信息),LoginResBean.class);
    }

    public static void save登录返回信息(LoginResBean loginResBean){
        SPUtil.getInstance().saveStr(登录返回信息,GsonUtil.getInstance().toJson(loginResBean));
    }

    public static LoginReqBean get登录参数(){
        return GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(登录参数),LoginReqBean.class);
    }

    public static void save登录参数(LoginReqBean loginReqBean){
        SPUtil.getInstance().saveStr(登录参数,GsonUtil.getInstance().toJson(loginReqBean));
    }

    public static ArrayList<CityResBean> get省市列表接口数据(){
        return GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(省市列表接口数据),new TypeToken<ArrayList<CityResBean>>(){}.getType());
    }

    public static void save省市列表接口数据(ArrayList<CityResBean> list){
        SPUtil.getInstance().saveStr(省市列表接口数据,GsonUtil.getInstance().toJson(list));

        HashMap<String,CityResBean.ProvinceListBean> map = new HashMap<>();
        HashMap<String,String> map1 = new HashMap<>();
        HashMap<String,String> map2 = new HashMap<>();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).getProvinceList().size();j++){
                map.put(list.get(i).getProvinceList().get(j).getValue(),list.get(i).getProvinceList().get(j));
                for(int k=0;k<list.get(i).getProvinceList().get(j).getCityList().size();k++){
                    map1.put(list.get(i).getProvinceList().get(j).getCityList().get(k).getName(),list.get(i).getProvinceList().get(j).getCityList().get(k).getValue());
                    map2.put(list.get(i).getProvinceList().get(j).getCityList().get(k).getValue(),list.get(i).getProvinceList().get(j).getCityList().get(k).getName());
                }
            }
        }
        SPUtil.getInstance().saveStr(省Map,GsonUtil.getInstance().toJson(map));
        SPUtil.getInstance().saveStr(市名找代码,GsonUtil.getInstance().toJson(map2));
        SPUtil.getInstance().saveStr(代码找市名,GsonUtil.getInstance().toJson(map1));

        List<CityResBean.ProvinceListBean> pro = new ArrayList<>();
        for(int i=0;i<LocalValue.pros.length;i++){
            CityResBean.ProvinceListBean provinceListBean = map.get(LocalValue.pros[i]);
            if(provinceListBean==null){
                provinceListBean = new CityResBean.ProvinceListBean();
                provinceListBean.setValue("");
            }
            pro.add(provinceListBean);
        }
        SPUtil.getInstance().saveStr(省市排序列表,GsonUtil.getInstance().toJson(pro));
    }


    public static HashMap<String,CityResBean.ProvinceListBean> get省Map(){
        return GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(省Map),new TypeToken<HashMap<String,CityResBean.ProvinceListBean>>(){}.getType());
    }

    public static List<CityResBean.ProvinceListBean> get省市排序列表(){
        return GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(省市排序列表),new TypeToken<List<CityResBean.ProvinceListBean>>(){}.getType());
    }

    public static HashMap<String,String> get代码从市名(){
        return GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(市名找代码),new TypeToken<HashMap<String,String>>(){}.getType());
    }

    public static HashMap<String,String> get市名从代码(){
        return GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(代码找市名),new TypeToken<HashMap<String,String>>(){}.getType());
    }


    public static ArrayList<LoginResBean.BranchCompanyListBean> get下级单位列表(){
        return  LocalValue.get登录返回信息().getBranchCompanyList();
    }


}
