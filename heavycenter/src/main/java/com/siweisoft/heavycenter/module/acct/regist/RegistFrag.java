package com.siweisoft.heavycenter.module.acct.regist;

//by summer on 2017-12-14.

import android.view.View;

import com.android.lib.base.activity.BaseUIActivity;
import com.android.lib.base.interf.OnLoadingInterf;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.regist.RegistResBean;
import com.siweisoft.heavycenter.module.acct.acct.AcctAct;
import com.siweisoft.heavycenter.module.acct.agree.AgreeFrag;
import com.siweisoft.heavycenter.module.acct.role.RoleFrag;

import butterknife.OnClick;
import butterknife.Optional;

public class RegistFrag extends AppFrag<RegistUIOpe,RegistDAOpe> {

    @Override
    public void initNow() {
        super.initNow();
    }

    @Optional
    @OnClick({R.id.regist,R.id.tv_agree1})
    public void onClick(final View v){
        super.onClick(v);
        switch (v.getId()){
            case R.id.regist:
                if(getP().getU().is都输入好了()){
                    getP().getD().regist(getP().getU().getRegistReqBean(), new UINetAdapter<RegistResBean>(this,true) {

                        @Override
                        public void onSuccess(RegistResBean o) {
                            LocalValue.save登录参数(getP().getU().getLoginReqBean());
                            getBaseUIAct().onBackPressed();
                            FragManager2.getInstance().setAnim(true).setStartAnim(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in,R.anim.fade_out).setFinishAnim(R.anim.fade_in,R.anim.fade_out).start(getBaseUIAct(), AcctAct.账号,AcctAct.账号界面根布局,RoleFrag.getInstance(true));
                        }
                    });
                }
                break;
            case R.id.tv_code:
                if(getP().getU().is可以点击验证码()){
                    getP().getD().getCode(getP().getU().getCodeReqBean());
                    getP().getD().getThreadUtil().run(this,v,60,1000, new OnLoadingInterf() {
                        @Override
                        public Void onStarLoading(Object o) {
                            getP().getU().bind.code.getCodeText().setText((60 - (int) o) + "s");
                            if ((60 - (int) o) <= 0) {
                                getP().getU().bind.code.setEnabled(true);
                                getP().getD().getThreadUtil().stop();
                                getP().getU().bind.code.getCodeText().setText("重新获取验证码");
                            }
                            return null;
                        }

                        @Override
                        public Void onStopLoading(Object o) {
                            return null;
                        }
                    });
                }
                break;
            case R.id.tv_agree1:
                FragManager2.getInstance().start(getBaseUIAct(), AcctAct.账号,AcctAct.账号界面根布局,new AgreeFrag());
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getP().getD().getThreadUtil().stop();
    }
}
