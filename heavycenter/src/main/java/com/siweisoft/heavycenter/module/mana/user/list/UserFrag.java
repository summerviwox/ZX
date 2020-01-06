package com.siweisoft.heavycenter.module.mana.user.list;

//by summer on 2017-12-14.

import android.os.Bundle;
import android.view.View;

import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.fragment.two.FragManager2;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.Test;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.mana.user.add.AddUserResBean;
import com.siweisoft.heavycenter.data.netd.unit.user.UnitUserResBean;
import com.siweisoft.heavycenter.data.netd.user.unit.unbind.UnBindResBean;
import com.siweisoft.heavycenter.data.netd.user.userrole.UserRoleRes;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.mana.user.news.NewFrag;
import com.siweisoft.heavycenter.module.mana.user.news.NewUserValue;

import butterknife.OnClick;

public class UserFrag extends AppFrag<UserUIOpe,UserDAOpe> implements OnRefreshListener,OnLoadmoreListener,ViewListener{

    public static UserFrag getInstance(String type){
        UserFrag userFrag = new UserFrag();
        userFrag.setArguments(new Bundle());
        userFrag.getArguments().putString(ValueConstant.DATA_TYPE,type);
        return userFrag;
    }


    @Override
    public void initNow() {
        super.initNow();
        switch (getArguments().getString(ValueConstant.DATA_TYPE)){
            case UserValue.查看用户:

                break;
            case UserValue.选择用户:
                getP().getU().setSwipe(false);
                break;

        }
    }

    @Override
    public void initdelay() {
        super.initdelay();
        getP().getU().initRecycle();
        getP().getU().initRefresh(this,this);
        onRefresh(null);


    }

    @OnClick({R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ftv_right2:
                Bundle bundle = new Bundle();
                bundle.putInt(ValueConstant.FARG_REQ,1);
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),NewFrag.getInstance(NewUserValue.新建用户,-1),bundle);
                break;
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        getP().getU().finishLoadmore();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        getP().getD().unitUsers(new UINetAdapter<UnitUserResBean>(this) {
            @Override
            public void onSuccess(UnitUserResBean o) {
                //o= new Test().getUnitUserResBean();
                getP().getU().LoadListData(o,UserFrag.this);
                getP().getU().finishRefresh();
            }
        });
    }

    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:
                switch (v.getId()){
                    case R.id.smMenuViewRight:
                        UnitUserResBean.ResultsBean resultsBean  = (UnitUserResBean.ResultsBean) v.getTag(R.id.data);
                        int t = (int) v.getTag(R.id.type);
                        switch (t){
                            case 1:
                                Bundle bundle = new Bundle();
                                bundle.putInt(ValueConstant.FARG_REQ,2);
                                FragManager2.getInstance().start(getBaseUIAct(), get容器(),UserFrag.getInstance(UserValue.选择用户),bundle);
                                break;
                            case 0:
                                switch (resultsBean.getBindCompanyState()){
                                    case LoginResBean.BIND_UNIT_STATE_BINDED:
                                        if(getP().getD().canUnBind(resultsBean)){
                                            getP().getD().unBindUser(resultsBean.getUserId(), new UINetAdapter<UnBindResBean>(this,true) {
                                                @Override
                                                public void onResult(boolean success, String msg, UnBindResBean o) {
                                                    super.onResult(success, msg, o);
                                                    onRefresh(null);
                                                }
                                            });
                                        }
                                        break;
                                    default:
                                        getP().getD().addUser(resultsBean, new UINetAdapter<AddUserResBean>(this,true) {
                                            @Override
                                            public void onSuccess(AddUserResBean o) {
                                                onRefresh(null);
                                            }
                                        });
                                        break;
                                }
                                break;
                        }
                        break;
                    case R.id.smContentView:
                        UnitUserResBean.ResultsBean data  = (UnitUserResBean.ResultsBean) v.getTag(R.id.data);
                        switch (getArguments().getString(ValueConstant.DATA_TYPE)){
                            case UserValue.查看用户:
                                FragManager2.getInstance().start(getBaseUIAct(), get容器(),NewFrag.getInstance(NewUserValue.用户信息,data.getUserId()));
                                break;
                            case UserValue.选择用户:
                                getArguments().putSerializable(ValueConstant.DATA_DATA,data);
                                getBaseUIAct().onBackPressed();
                                break;

                        }
                        break;
                }
                break;
        }
    }

    @Override
    public void onResult(int res, Bundle bundle) {
        super.onResult(res, bundle);
        switch (res){
            case 1:
                if(bundle==null || !bundle.getBoolean(ValueConstant.FARG_TYPE,false)){
                    return;
                }
                UnitUserResBean.ResultsBean data = (UnitUserResBean.ResultsBean) bundle.getSerializable(ValueConstant.DATA_DATA);
                if(bundle.getBoolean(ValueConstant.FARG_TYPE,false)){
                    onRefresh(null);
                }
                break;
            case 2:
                if(bundle==null || bundle.getSerializable(ValueConstant.DATA_DATA)==null){
                    return;
                }
                UnitUserResBean.ResultsBean data1 = (UnitUserResBean.ResultsBean) bundle.getSerializable(ValueConstant.DATA_DATA);
                getP().getU().showBindTip(data1.getTrueName(),get容器(), new View.OnClickListener() {
                    @Override
                    public void onClick(View vv) {
                        switch (vv.getId()){
                            case R.id.tv_n:
                                break;
                            case R.id.tv_y:

                                getP().getD().setUserRole(data1.getUserId(), new UINetAdapter<UserRoleRes>(UserFrag.this) {
                                    @Override
                                    public void onSuccess(UserRoleRes o) {
                                        super.onSuccess(o);
                                        getBaseAct().onBackPressed();
                                        ((MainAct)getBaseAct()).go网络获取用户信息重新加载();
                                    }
                                });
                                break;
                        }
                        getP().getU().getShowBindTipM().setAnim(false).finish(getBaseUIAct(),get容器(),true);
                    }
                });
                break;
        }
    }
}
