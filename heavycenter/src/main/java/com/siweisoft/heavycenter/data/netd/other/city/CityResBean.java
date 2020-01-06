package com.siweisoft.heavycenter.data.netd.other.city;

//by summer on 2018-01-10.

import com.android.lib.bean.BaseBean;

import java.util.List;

public class CityResBean extends BaseBean {


    /**
     * firstA : A
     * provinceList : [{"name":"340000","value":"安徽","cityList":[{"name":"340100","value":"合肥市","checkStatus":0},{"name":"340200","value":"芜湖市","checkStatus":0},{"name":"340300","value":"蚌埠市","checkStatus":0},{"name":"340400","value":"淮南市","checkStatus":0},{"name":"340500","value":"马鞍山市","checkStatus":0},{"name":"340600","value":"淮北市","checkStatus":0},{"name":"340700","value":"铜陵市","checkStatus":0},{"name":"340800","value":"安庆市","checkStatus":0},{"name":"341000","value":"黄山市","checkStatus":0},{"name":"341100","value":"滁州市","checkStatus":0},{"name":"341200","value":"阜阳市","checkStatus":0},{"name":"341300","value":"宿州市","checkStatus":0},{"name":"341500","value":"六安市","checkStatus":0},{"name":"341600","value":"亳州市","checkStatus":0},{"name":"341700","value":"池州市","checkStatus":0},{"name":"341800","value":"宣城市","checkStatus":0}]},{"name":"820000","value":"澳门","cityList":[]}]
     */

    private String firstA;
    private List<ProvinceListBean> provinceList;

    public String getFirstA() {
        return firstA;
    }

    public void setFirstA(String firstA) {
        this.firstA = firstA;
    }

    public List<ProvinceListBean> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<ProvinceListBean> provinceList) {
        this.provinceList = provinceList;
    }

    public static class ProvinceListBean extends BaseBean{
        /**
         * name : 340000
         * value : 安徽
         * cityList : [{"name":"340100","value":"合肥市","checkStatus":0},{"name":"340200","value":"芜湖市","checkStatus":0},{"name":"340300","value":"蚌埠市","checkStatus":0},{"name":"340400","value":"淮南市","checkStatus":0},{"name":"340500","value":"马鞍山市","checkStatus":0},{"name":"340600","value":"淮北市","checkStatus":0},{"name":"340700","value":"铜陵市","checkStatus":0},{"name":"340800","value":"安庆市","checkStatus":0},{"name":"341000","value":"黄山市","checkStatus":0},{"name":"341100","value":"滁州市","checkStatus":0},{"name":"341200","value":"阜阳市","checkStatus":0},{"name":"341300","value":"宿州市","checkStatus":0},{"name":"341500","value":"六安市","checkStatus":0},{"name":"341600","value":"亳州市","checkStatus":0},{"name":"341700","value":"池州市","checkStatus":0},{"name":"341800","value":"宣城市","checkStatus":0}]
         */

        private String name;
        private String value;
        private List<CityListBean> cityList;

        private int checkStatus;

        public static final int CHECK_STATE_FULL = 2;

        public static final int CHECK_STATE_HALF = 1;

        public static final int CHECK_STATE_NULL = 0;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<CityListBean> getCityList() {
            return cityList;
        }

        public void setCityList(List<CityListBean> cityList) {
            this.cityList = cityList;
        }

        public int getCheckStatus() {
            return checkStatus;
        }

        public void setCheckStatus(int checkStatus) {
            this.checkStatus = checkStatus;
        }

        public static class CityListBean extends BaseBean{
            /**
             * name : 340100
             * value : 合肥市
             * checkStatus : 0
             */

            private String name;
            private String value;
            private int checkStatus;

            public static final int CHECK_STATE_FULL = 2;

            public static final int CHECK_STATE_HALF = 1;

            public static final int CHECK_STATE_NULL = 0;


            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public int getCheckStatus() {
                return checkStatus;
            }

            public void setCheckStatus(int checkStatus) {
                this.checkStatus = checkStatus;
            }
        }
    }
}
