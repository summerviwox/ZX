package com.siweisoft.heavycenter.module.welc.welc;

//by summer on 2017-12-14.

import android.os.Bundle;
import android.view.View;

import com.android.lib.network.news.NetAdapter;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.IntentUtil;
import com.siweisoft.heavycenter.HCApp;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppAct;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.other.city.CityReqBean;
import com.siweisoft.heavycenter.data.netd.other.city.CityResBean;
import com.siweisoft.heavycenter.module.acct.acct.AcctAct;
import com.siweisoft.heavycenter.module.main.main.MainAct;

import java.util.ArrayList;

import butterknife.OnClick;
import butterknife.Optional;

public class WelcAct extends AppAct<WelcUIOpe,WelcDAOpe> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        if(HCApp.test){
            IntentUtil.startActivityWithFinish(getActivity(), MainAct.class,null);
            return;
        }
        if(LocalValue.get省市排序列表()!=null&&LocalValue.get省市排序列表().size()>0){
            AutoLogin();
        }else{
            NetDataOpe.get省市列表接口数据(getActivity(),new CityReqBean(),new NetAdapter<ArrayList<CityResBean>>(getActivity()){
                @Override
                public void onSuccess(ArrayList<CityResBean> o) {
                    LocalValue.save省市列表接口数据(o);
                    AutoLogin();
                }
            });
        }
    }



    private void AutoLogin(){
        if(LocalValue.is自动登录()&& LocalValue.get登录参数()!=null){
            getP().getD().go登录(new UINetAdapter<LoginResBean>(WelcAct.this) {
                @Override
                public void onResult(boolean success, String msg, LoginResBean o) {
                    super.onResult(success, msg, o);
                    if(success){
                        LocalValue.save登录返回信息(o);
                        IntentUtil.startActivityWithFinish(getActivity(), MainAct.class,null);
                    }else{
                        IntentUtil.startActivityWithFinish(WelcAct.this, AcctAct.class,null);
                    }
                }
            });
        }else{
            IntentUtil.startActivityWithFinish(WelcAct.this, AcctAct.class,null);
        }
    }
    @Optional
    @OnClick({R.id.image})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.image:

                break;
        }
    }
}
