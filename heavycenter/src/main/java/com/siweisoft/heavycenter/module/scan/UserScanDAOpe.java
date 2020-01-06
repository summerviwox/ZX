package com.siweisoft.heavycenter.module.scan;

//by summer on 2018-01-25.

import android.content.Context;

import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.baidu.location.BDLocation;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.unit.info.UnitInfoReqBean;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;
import com.siweisoft.heavycenter.data.netd.user.unit.bind.BindReqBean;
import com.siweisoft.heavycenter.data.netd.user.unit.bind.BindResBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.main.map.MapFrag;
import com.siweisoft.heavycenter.module.main.orders.news.NewOrderFrag;
import com.siweisoft.heavycenter.module.main.trans.trans.TransFrag;
import com.siweisoft.heavycenter.module.mana.car.detail.DetailFrag;
import com.siweisoft.heavycenter.module.mana.car.news.NewCarFrag;
import com.siweisoft.heavycenter.module.myce.unit.list.UnitListFrag;

public class UserScanDAOpe extends BaseDAOpe {


    public UserScanDAOpe() {
    }

    public UserScanDAOpe(Context context) {
        super(context);
    }

    public void logic(final AppFrag appFrag,LoginResBean scaned){

        if(appFrag.getClass().getName().equals(TransFrag.class.getName())){
            ToastUtil.getInstance().showShort(getActivity(),"按单位搜索运输单");
            TransFrag transFrag = (TransFrag) appFrag;
            transFrag.getP().getU().setUnit(StringUtil.getStr(scaned.getCompanyName()));
            transFrag.getP().getU().autoRefresh();
            return;
        }


        if(appFrag.getClass().getName().equals(NewOrderFrag.class.getName()) &&( LocalValue.get登录返回信息().getUserType()==UserTypeReqBean.非驾驶员)){
            ToastUtil.getInstance().showShort(getActivity(),"新建订单选定单位");
            NewOrderFrag newOrderFrag = (NewOrderFrag) appFrag;
            newOrderFrag.setUnit(scaned.getCompanyId());
            return;
        }

        if(appFrag.getClass().getName().equals(MapFrag.class.getName())&&( LocalValue.get登录返回信息().getUserType()==UserTypeReqBean.驾驶员)&&(LoginResBean.BIND_UNIT_STATE_BINDED==scaned.getBindCompanyState())){
            ToastUtil.getInstance().showShort(getActivity(),"驾驶员扫码地图 地图中心改为单位所在位置");
            UnitInfoReqBean unitInfoReqBean = new UnitInfoReqBean();
            unitInfoReqBean.setId(scaned.getCompanyId());
            NetDataOpe.Unit.getInfo(getActivity(), unitInfoReqBean, new UINetAdapter<UnitInfo>(getActivity(),true) {
                @Override
                public void onSuccess(UnitInfo o) {
                    super.onSuccess(o);
                    BDLocation bdLocation = new BDLocation();
                    bdLocation.setLatitude(o.getCompanyLat());
                    bdLocation.setLongitude(o.getCompanyLng());
                    MapFrag mapFrag = (MapFrag) appFrag;
                    mapFrag.local(bdLocation);
                }
            });
            return;
        }

        if(appFrag.getClass().getName().equals(UnitListFrag.class.getName())){
            ToastUtil.getInstance().showShort(getActivity(),"从单位列表中 选择一个单位");
            UnitInfoReqBean unitInfoReqBean = new UnitInfoReqBean();
            unitInfoReqBean.setId(scaned.getCompanyId());
            NetDataOpe.Unit.getInfo(getActivity(), unitInfoReqBean, new UINetAdapter<UnitInfo>(getActivity()) {
                @Override
                public void onSuccess(UnitInfo o) {
                    super.onSuccess(o);
                    UnitListFrag unitListFrag = (UnitListFrag) appFrag;
                    unitListFrag.selUnit(o);
                }
            });
            return;
        }



        if(appFrag.getClass().getName().equals(DetailFrag.class.getName())&&( LocalValue.get登录返回信息().getUserType()==UserTypeReqBean.非驾驶员)
                &&( scaned.getUserType()==UserTypeReqBean.驾驶员)){
            ToastUtil.getInstance().showShort(getActivity(),"作为选定的当前驾驶员");
            DetailFrag detailFrag = (DetailFrag) appFrag;
            detailFrag.bindCar(scaned.getUserId());
            return;
        }


        if(appFrag.getClass().getName().equals(NewCarFrag.class.getName())&&( LocalValue.get登录返回信息().getUserType()==UserTypeReqBean.非驾驶员)
                &&( scaned.getUserType()==UserTypeReqBean.驾驶员)){
            ToastUtil.getInstance().showShort(getActivity(),"作为选定的当前驾驶员");
            NewCarFrag newCarFrag = (NewCarFrag) appFrag;
            newCarFrag.bindCar(scaned.getUserId());
            return;
        }


        if((scaned.getBindCompanyState()!=LoginResBean.BIND_UNIT_STATE_BINDED)&&(
                (LoginResBean.USER_ROLE_ADMIN.equals(LocalValue.get登录返回信息().getUserRole()))
                        ||(LoginResBean.USER_ROLE_SUPER_ADMIN.equals(LocalValue.get登录返回信息().getUserRole())))){
            ToastUtil.getInstance().showShort(getActivity(),"管理员发送邀请");
            BindReqBean bindReqBean = new BindReqBean();
            bindReqBean.setId(scaned.getUserId());
            bindReqBean.setBindOperateType(2);
            bindReqBean.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
            bindReqBean.setIsManager(1);
            bindReqBean.setMangerId(LocalValue.get登录返回信息().getUserId());
            NetDataOpe.User.binUnit(getActivity(), bindReqBean, new UINetAdapter<BindResBean>(getActivity(),true) {
                @Override
                public void onSuccess(BindResBean o) {
                    super.onSuccess(o);

                }
            });
            return;
        }

        if(LocalValue.get登录返回信息().getBindCompanyState()!=LoginResBean.BIND_UNIT_STATE_BINDED){
            ToastUtil.getInstance().showShort(getActivity(),"绑定单位，通知所有管理人员");

        }

        if((LocalValue.get登录返回信息().getBindCompanyState()!=LoginResBean.BIND_UNIT_STATE_BINDED)&&(
                (LoginResBean.USER_ROLE_ADMIN.equals(scaned.getUserRole()))
                        ||(LoginResBean.USER_ROLE_SUPER_ADMIN.equals(scaned.getUserRole())))){
            ToastUtil.getInstance().showShort(getActivity(),"绑定单位，通知被扫用户");
            BindReqBean bindReqBean = new BindReqBean();
            bindReqBean.setId(LocalValue.get登录返回信息().getUserId());
            bindReqBean.setCompanyId(scaned.getCompanyId());
            bindReqBean.setIsManager(BindReqBean.IS_MANAGER_NO);
            bindReqBean.setMangerId(0);
            NetDataOpe.User.binUnit(getActivity(), bindReqBean, new UINetAdapter<BindResBean>(getActivity(),true) {
                @Override
                public void onResult(boolean success, String msg, BindResBean o) {
                    super.onResult(success, msg, o);
                    if(success){
                        ((MainAct)getActivity()).go判断是否绑定单位处理();
                    }
                }
            });
            return;
        }

        if((LocalValue.get登录返回信息().getBindCompanyState()!=LoginResBean.BIND_UNIT_STATE_BINDED)&&(LoginResBean.USER_ROLE_GENERAL.equals(scaned.getUserRole()))){
            ToastUtil.getInstance().showShort(getActivity(),"绑定单位，通知所有管理人员");
            BindReqBean bindReqBean = new BindReqBean();
            bindReqBean.setId(LocalValue.get登录返回信息().getUserId());
            bindReqBean.setCompanyId(scaned.getCompanyId());
            bindReqBean.setIsManager(BindReqBean.IS_MANAGER_NO);
            bindReqBean.setMangerId(0);
            NetDataOpe.User.binUnit(getActivity(), bindReqBean, new UINetAdapter<BindResBean>(getActivity(),true) {
                @Override
                public void onResult(boolean success, String msg, BindResBean o) {
                    super.onResult(success, msg, o);
                    if(success){
                        ((MainAct)getActivity()).go判断是否绑定单位处理();
                    }
                }
            });
            return;
        }


        ToastUtil.getInstance().showShort(getActivity(),"查看用户详情");
    }
}
