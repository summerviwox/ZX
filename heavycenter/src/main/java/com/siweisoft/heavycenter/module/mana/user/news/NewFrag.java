package com.siweisoft.heavycenter.module.mana.user.news;

//by summer on 2017-12-19.

import android.os.Bundle;
import android.view.View;

import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.scan.user.UserInfo;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.mana.user.add.AddUserResBean;
import com.siweisoft.heavycenter.data.netd.user.userrole.UserRoleRes;

import butterknife.OnClick;
import butterknife.Optional;

public class NewFrag extends AppFrag<NewUIOpe,NewDAOpe> {


    public static NewFrag getInstance(String type,int id){
        NewFrag newFrag = new NewFrag();
        newFrag.setArguments(new Bundle());
        newFrag.getArguments().putString(ValueConstant.DATA_TYPE,type);
        newFrag.getArguments().putInt(ValueConstant.DATA_DATA,id);
        return newFrag;
    }


    @Override
    public void initdelay() {
        super.initdelay();
        switch (getArguments().getString(ValueConstant.DATA_TYPE)){
            case NewUserValue.新建用户:

                break;
            case NewUserValue.用户信息:
                NewDAOpe.getUserInfo(getArguments().getInt(ValueConstant.DATA_DATA), getActivity(), new UINetAdapter<LoginResBean>(getActivity()) {
                    @Override
                    public void onSuccess(LoginResBean o) {
                        super.onSuccess(o);
                        getDE().setUserInfo(o);
                        getUI().initUserInfo(getDE().getUserInfo());
                    }
                });
                break;

        }
    }

    @Optional
    @OnClick({R.id.enter,R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.enter:
                if(getUI().canGo()){
                    getDE().addUser(getUI().getUser(getDE().getReqBean()), new UINetAdapter<AddUserResBean>(this,true) {
                        @Override
                        public void onSuccess(AddUserResBean o) {
                            getArguments().putBoolean(ValueConstant.FARG_TYPE,true);
                            getBaseUIAct().onBackPressed();
                        }
                    });
                }
                break;
            case R.id.ftv_right2:
                if(v.getVisibility()==View.VISIBLE&&getDE().getUserInfo()!=null&&getUI().getSelectRole()!=null){
                    NewDAOpe.setUserRole(getBaseAct(), getDE().getUserInfo().getUserId(), getUI().getSelectRole(), new UINetAdapter<UserRoleRes>(this,true) {
                        @Override
                        public void onSuccess(UserRoleRes o) {
                            super.onSuccess(o);
                            getBaseAct().onBackPressed();
                        }
                    });
                }

                break;
        }
    }
}
