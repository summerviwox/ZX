package com.siweisoft.heavycenter.module.myce.sett;

//by summer on 2017-12-19.

import android.view.View;

import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.IntentUtil;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginReqBean;
import com.siweisoft.heavycenter.data.netd.acct.logout.LogOutResBean;
import com.siweisoft.heavycenter.module.welc.welc.WelcAct;

import butterknife.OnClick;

public class SetFrag extends AppFrag<SetUIOpe,SetDAOpe> {


    @OnClick({R.id.item_exit})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.item_exit:
                getP().getD().logOut(new UINetAdapter<LogOutResBean>(this,true) {
                    @Override
                    public void onResult(boolean success, String msg, LogOutResBean o) {
                        super.onResult(success, msg, o);
                        LocalValue.set自动登录(false);
                        LoginReqBean loginReqBean = LocalValue.get登录参数();
                        loginReqBean.setInputPwd("");
                        LocalValue.save登录参数(loginReqBean);
                        IntentUtil.startActivityWithFinish(getActivity(),WelcAct.class,null);
                    }
                });
                break;
        }
    }
}
