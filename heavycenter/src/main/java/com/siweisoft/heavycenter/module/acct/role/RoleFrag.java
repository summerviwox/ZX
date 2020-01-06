package com.siweisoft.heavycenter.module.acct.role;

//by summer on 2017-12-18.

import android.os.Bundle;
import android.view.View;

import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.IntentUtil;
import com.android.lib.util.ToastUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeResBean;
import com.siweisoft.heavycenter.module.acct.acct.AcctAct;
import com.siweisoft.heavycenter.module.main.main.MainAct;

import butterknife.OnClick;

public class RoleFrag extends AppFrag<RoleUIOpe,RoleDAOpe>{

    public static String 直接登录 = "直接登录";


    public static RoleFrag getInstance(boolean login){
        RoleFrag roleFrag = new RoleFrag();
        roleFrag.setArguments(new Bundle());
        roleFrag.getArguments().putBoolean(直接登录,login);
        return roleFrag;
    }

    @OnClick({R.id.tv_notdriver,R.id.tv_driver})
    public void onClick(final View vv){
        super.onClick(vv);
        getP().getU().showTip(R.id.tv_driver==vv.getId(),new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (v.getId()){
                    case R.id.tv_sure:
                        getP().getD().login(LocalValue.get登录参数(), new UINetAdapter<LoginResBean>(RoleFrag.this,UINetAdapter.Loading) {
                            @Override
                            public void onSuccess(LoginResBean o) {
                                getP().getU().getUserTypeReqBean().setId(o.getUserId());
                                getP().getU().getUserTypeReqBean().setUserType((R.id.tv_driver==vv.getId())?UserTypeReqBean.驾驶员 :UserTypeReqBean.非驾驶员);
                                LocalValue.save登录返回信息(o);
                                getP().getD().setUserType(getP().getU().getUserTypeReqBean(), new UINetAdapter<UserTypeResBean>(RoleFrag.this,UINetAdapter.Loading) {
                                    @Override
                                    public void onSuccess(UserTypeResBean o) {
                                        ToastUtil.getInstance().showShort(getContext(),"设置用户角色成功");
                                        if(getArguments().getBoolean(直接登录,false)){
                                            LoginResBean resBean = LocalValue.get登录返回信息();
                                            resBean.setUserType((R.id.tv_driver==vv.getId())?UserTypeReqBean.驾驶员 :UserTypeReqBean.非驾驶员);
                                            LocalValue.save登录返回信息(resBean);
                                            IntentUtil.startActivityWithFinish(getBaseUIAct(), MainAct.class,null);
                                        }else{
                                            getBaseUIAct().onBackPressed();
                                        }
                                    }
                                });
                            }
                        });
                        break;
                }
                FragManager2.getInstance().setFinishAnim(R.anim.fade_in,R.anim.fade_out).finish(getBaseUIAct(), AcctAct.账号,true);
            }
        });
    }

}
