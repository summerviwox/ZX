package com.siweisoft.heavycenter.module.myce.unit.nobind;

//by summer on 2017-12-19.

import android.content.Context;

import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.databinding.FragMyceUnitNobindBinding;

public class NoBindUIOpe extends AppUIOpe<FragMyceUnitNobindBinding>{

    @Override
    public void initUI() {
        super.initUI();
        String bindinfo  = "";
        switch (LocalValue.get登录返回信息().getBindCompanyState()){
            case LoginResBean.BIND_UNIT_STATE_BINDED:
                bindinfo = "已绑定单位";
                break;
            case LoginResBean.BIND_UNIT_STATE_CHECK:
                bindinfo = "绑定单位正在审核中";
                break;
            case LoginResBean.BIND_UNIT_STATE_REJECT:
                bindinfo = "绑定单位已被拒绝";
                break;
            case LoginResBean.BIND_UNIT_STATE_UNBIND:
                bindinfo = "必须先绑定单位";
                break;
        }
        if(LocalValue.get登录返回信息().is驾驶员()){
            bind.tvBindtip.setText("您是驾驶员,"+bindinfo);
        }else{
            bind.tvBindtip.setText("您是非驾驶员,"+bindinfo);
        }

    }
}
