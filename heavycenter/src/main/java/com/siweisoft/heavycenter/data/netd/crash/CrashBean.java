package com.siweisoft.heavycenter.data.netd.crash;

//by summer on 2017-12-12.

import com.android.lib.bean.BaseBean;

public class CrashBean extends BaseBean {


    /**
     * error : 139
     * createdtime : 2017-09-25 15:36:35
     * userBean : {"id":23,"phone":"18721607438","usertype":0,"name":"18721607438","platform":""}
     */

    private String error;
    private String createdtime;
    private UserBeanBean userBean;
    private String platform;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }

    public UserBeanBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBeanBean userBean) {
        this.userBean = userBean;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public static class UserBeanBean {
        /**
         * id : 23
         * phone : 18721607438
         * usertype : 0
         * name : 18721607438
         * platform :
         */

        private int id;
        private String phone;
        private int usertype;
        private String name;
        private String platform;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getUsertype() {
            return usertype;
        }

        public void setUsertype(int usertype) {
            this.usertype = usertype;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }
    }
}
