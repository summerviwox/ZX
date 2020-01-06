package com.siweisoft.heavycenter.module.acct.login;

//by summer on 2017-12-14.

import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.IntentUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.module.acct.acct.AcctAct;
import com.siweisoft.heavycenter.module.acct.regist.RegistFrag;
import com.siweisoft.heavycenter.module.acct.repwd.RepwdFrag;
import com.siweisoft.heavycenter.module.acct.role.RoleFrag;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.myce.test.HeadTestFrag;

import butterknife.OnClick;

public class LoginFrag extends AppFrag<LoginUIOpe,LoginDAOpe> {

    @Override
    public void initNow() {
        super.initNow();

    }

    @OnClick({R.id.login,R.id.regist,R.id.repwd})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login:
                if(getP().getU().is输入完全()){
                    getP().getD().go登录(getP().getU().getLoginReqBean(), new UINetAdapter<LoginResBean>(this,UINetAdapter.Loading,true) {
                        @Override
                        public void onSuccess(LoginResBean loginResBean) {
                            LocalValue.save登录参数(getP().getU().getLoginReqBean());
                            LocalValue.save登录返回信息(loginResBean);
                            if(loginResBean.is选择了角色()){
                                LocalValue.set自动登录(true);
                                IntentUtil.startActivityWithFinish(getBaseUIAct(), MainAct.class,null);
                            }else{
                                FragManager2.getInstance().start(getBaseUIAct(), AcctAct.账号,AcctAct.账号界面根布局,RoleFrag.getInstance(true));
                            }
                        }
                    });
                }
                break;
            case R.id.regist:
                FragManager2.getInstance().start(getBaseUIAct(), AcctAct.账号,AcctAct.账号界面根布局,new RegistFrag());
                break;
            case R.id.repwd:
                FragManager2.getInstance().start(getBaseUIAct(), AcctAct.账号,AcctAct.账号界面根布局,new RepwdFrag());
                break;
            case R.id.iv_head:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    HeadTestFrag headTestFrag = new HeadTestFrag();
                    Slide slideTransition = new Slide(Gravity.RIGHT);
                    slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));

                    ChangeBounds changeBoundsTransition = new ChangeBounds();
                    changeBoundsTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));

                    headTestFrag.setEnterTransition(slideTransition);
                    headTestFrag.setAllowEnterTransitionOverlap(true);
                    headTestFrag.setAllowReturnTransitionOverlap(true);
                    headTestFrag.setSharedElementEnterTransition(changeBoundsTransition);
                    getBaseUIAct().getSupportFragmentManager().beginTransaction()
                            .add(AcctAct.账号界面根布局, headTestFrag)
                            .addToBackStack(null)
                            .hide(this)
                            .addSharedElement(v, "headimage")
                            .commit();
                }
                break;
        }
    }

}
