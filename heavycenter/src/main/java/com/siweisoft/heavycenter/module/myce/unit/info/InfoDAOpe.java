package com.siweisoft.heavycenter.module.myce.unit.info;

//by summer on 2017-12-19.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.unit.info.UnitInfoReqBean;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;
import com.siweisoft.heavycenter.data.netd.unit.update.UpdateUnitReq;
import com.siweisoft.heavycenter.data.netd.unit.update.UpdateUnitRes;
import com.siweisoft.heavycenter.data.netd.user.info.UserInfoReqBean;
import com.siweisoft.heavycenter.data.netd.user.unit.unbind.UnBindReqBean;
import com.siweisoft.heavycenter.data.netd.user.unit.unbind.UnBindResBean;

public class InfoDAOpe extends AppDAOpe {




    public void getInfo(int id,NetI<UnitInfo> adapter){
        UnitInfoReqBean unitInfoReqBean = new UnitInfoReqBean();
        unitInfoReqBean.setId(id==-1?LocalValue.get登录返回信息().getCompanyId():id);
        NetDataOpe.Unit.getInfo(getActivity(), unitInfoReqBean,adapter);
    }

    public void unBinUnit(NetI<UnBindResBean> adapter){
        UnBindReqBean unBindReqBean = new UnBindReqBean();
        unBindReqBean.setId(LocalValue.get登录返回信息().getUserId());
        unBindReqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        NetDataOpe.User.unBinUnit(getActivity(),unBindReqBean,adapter);
    }

    public void getUserInfo(NetI<LoginResBean> adapter){
        UserInfoReqBean userInfoReqBean = new UserInfoReqBean();
        userInfoReqBean.setIsApp(1);
        userInfoReqBean.setId(LocalValue.get登录返回信息().getUserId());
        NetDataOpe.User.get用户信息(getActivity(), userInfoReqBean,adapter);
    }



}
