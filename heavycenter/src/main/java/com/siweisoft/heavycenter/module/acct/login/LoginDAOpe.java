package com.siweisoft.heavycenter.module.acct.login;

//by summer on 2017-12-14.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginReqBean;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.other.city.CityReqBean;
import com.siweisoft.heavycenter.data.netd.other.city.CityResBean;

import java.util.ArrayList;

public class LoginDAOpe extends AppDAOpe {



    public void go登录(LoginReqBean reqBean, NetI<LoginResBean> adapter){
        NetDataOpe.onLogin(getActivity(),reqBean,adapter);
    }

    public void get省市列表接口数据(CityReqBean reqBean, NetI<ArrayList<CityResBean>> adapter){
        NetDataOpe.get省市列表接口数据(getActivity(),reqBean,adapter);
    }


}
