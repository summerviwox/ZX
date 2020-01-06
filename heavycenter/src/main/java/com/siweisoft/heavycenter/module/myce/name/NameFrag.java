package com.siweisoft.heavycenter.module.myce.name;

//by summer on 2017-12-19.

import android.view.View;

import com.android.lib.network.news.UINetAdapter;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.acct.rename.ReNameResBean;
import com.siweisoft.heavycenter.module.main.main.MainAct;

import butterknife.OnClick;

public class NameFrag extends AppFrag<NameUIOpe,NameDAOpe> {


    @Override
    public void initdelay() {
        super.initdelay();
        getUI().initTxt();
    }

    @OnClick({R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ftv_right2:
                if(getUI().canGo()){
                    getDE().reName(getUI().getReNameReqBean(), new UINetAdapter<ReNameResBean>(this,true) {
                        @Override
                        public void onSuccess(ReNameResBean o) {
                            LoginResBean loginResBean = LocalValue.get登录返回信息();
                            loginResBean.setTrueName(getUI().getReNameReqBean().getTrueName());
                            LocalValue.save登录返回信息(loginResBean);
                            ((MainAct)getBaseUIAct()).getDE().getMyceFrag().getUI().initUI();
                            getBaseUIAct().onBackPressed();
                        }
                    });
                }
                break;
        }
    }

}
