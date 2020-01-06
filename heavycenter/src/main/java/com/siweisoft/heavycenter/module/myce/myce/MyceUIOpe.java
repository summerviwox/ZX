package com.siweisoft.heavycenter.module.myce.myce;

//by summer on 2017-12-14.

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.siweisoft.heavycenter.GlideApp;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;
import com.siweisoft.heavycenter.databinding.FragMyceBinding;
import com.siweisoft.heavycenter.databinding.FragMyceDriverBinding;
import com.siweisoft.heavycenter.databinding.FragMyceGeneralBinding;

public class MyceUIOpe extends AppUIOpe<FragMyceBinding> {


    FragMyceDriverBinding fragMyceDriverBinding;

    FragMyceGeneralBinding fragMyceGeneralBinding;

    public void initUI() {
        super.initUI();
        GlideApp.with(context).asBitmap().load(NetValue.获取地址(LocalValue.get登录返回信息().getUserPhoto())).placeholder(R.drawable.icon_hv_myce_head).centerCrop().into(bind.llHead.ivHead);
        bind.llHead.tvName.setText(StringUtil.getStr(LocalValue.get登录返回信息().getTrueName()));
        bind.llHead.tvPhone.setText(StringUtil.getStr(LocalValue.get登录返回信息().getTel()));

        switch (LocalValue.get登录返回信息().getUserType()){
            case UserTypeReqBean.驾驶员:
                if(fragMyceDriverBinding==null){
                    fragMyceDriverBinding = DataBindingUtil.bind(LayoutInflater.from(getActivity()).inflate(R.layout.frag_myce_driver,null));
                    bind.contentAcct.addView(fragMyceDriverBinding.getRoot(),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                }
                fragMyceDriverBinding.itemUnit.getLeftTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getCompanyName()));
                //bind.llHead.tvRole.setText(UserTypeReqBean.USER_TYPE_DRIVER_CN);
                fragMyceDriverBinding.itemDriver.getLeftTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getCarLicenseNo()));
                fragMyceDriverBinding.itemDriver.getMidTV().setVisibility(View.VISIBLE);
                fragMyceDriverBinding.itemDriver.getMidTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getCarBrand()));
                fragMyceDriverBinding.tvEmptyweight.setText("自重: "+StringUtil.getStr(LocalValue.get登录返回信息().getEmptyWeight())+"t");
                fragMyceDriverBinding.tvMaxweight.setText("载重: "+StringUtil.getStr(LocalValue.get登录返回信息().getMaxCapacity())+"t");


                //bind.llHead.tvRole.setText(LoginResBean.USER_ROLE_DRIVER_CN);


                switch (LocalValue.get登录返回信息().getBindCompanyState()){
                    case LoginResBean.BIND_UNIT_STATE_BINDED:
                        fragMyceDriverBinding.itemDriver.setVisibility(View.VISIBLE);
                        break;
                    default:
                        fragMyceDriverBinding.itemUnit.getLeftTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getCompanyName()));
                        fragMyceDriverBinding.itemDriver.setVisibility(View.GONE);
                        break;
                }

                if(NullUtil.isStrEmpty(LocalValue.get登录返回信息().getCarLicenseNo())){
                    fragMyceDriverBinding.llCar.setVisibility(View.GONE);
                    fragMyceDriverBinding.itemDriver.getLeftTV().setText("绑定车辆");
                }else{
                    fragMyceDriverBinding.llCar.setVisibility(View.VISIBLE);
                }

                GlideApp.with(context).asBitmap().load(NetValue.获取地址(LocalValue.get登录返回信息().getVehicleLicensePhoto())).centerCrop().into(fragMyceDriverBinding.ivDirver);
                GlideApp.with(context).asBitmap().load(NetValue.获取地址(LocalValue.get登录返回信息().getVehiclePhoto())).centerCrop().into(fragMyceDriverBinding.ivCar);

                break;
            case UserTypeReqBean.非驾驶员:
                if(fragMyceGeneralBinding==null){
                    fragMyceGeneralBinding = DataBindingUtil.bind(LayoutInflater.from(getActivity()).inflate(R.layout.frag_myce_general,null));
                    bind.contentAcct.addView(fragMyceGeneralBinding.getRoot(),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                }
                fragMyceGeneralBinding.itemUnit.getLeftTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getCompanyName()));

                bind.llHead.tvRole.setText(UserTypeReqBean.USER_TYPE_GENERAL_CN);
                switch (LocalValue.get登录返回信息().getUserRole()){
                    case LoginResBean.USER_ROLE_ADMIN:
                        bind.llHead.tvRole.setText(LoginResBean.USER_ROLE_ADMIN_CN);
                        break;
                    case LoginResBean.USER_ROLE_GENERAL:
                        bind.llHead.tvRole.setText(LoginResBean.USER_ROLE_GENERAL_CN);
                        fragMyceGeneralBinding.itemStore.setVisibility(View.GONE);
                        fragMyceGeneralBinding.itemGood.setVisibility(View.GONE);
                        fragMyceGeneralBinding.itemUser.setVisibility(View.GONE);
                        fragMyceGeneralBinding.itemCar.setVisibility(View.GONE);
                        break;
                    case LoginResBean.USER_ROLE_SUPER_ADMIN:
                        bind.llHead.tvRole.setText(LoginResBean.USER_ROLE_SUPER_ADMIN_CN);
                        break;
                    case LoginResBean.USER_ROLE_SYS_ADMIN:
                        bind.llHead.tvRole.setText(LoginResBean.USER_ROLE_SYS_ADMIN_CN);
                        break;
                }


                fragMyceGeneralBinding.itemStore.getRightTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getWareHouseCount()));
                fragMyceGeneralBinding.itemGood.getRightTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getProductCount()));
                fragMyceGeneralBinding.itemUser.getRightTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getUserCount()));
                fragMyceGeneralBinding.itemCar.getRightTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getVehicleCount()));


                fragMyceGeneralBinding.itemStore.setRightTxt(LocalValue.get登录返回信息().getWareHouseCount());
                fragMyceGeneralBinding.itemGood.setRightTxt(LocalValue.get登录返回信息().getProductCount());
                fragMyceGeneralBinding.itemUser.setRightTxt(LocalValue.get登录返回信息().getUserCount());
                fragMyceGeneralBinding.itemCar.setRightTxt(LocalValue.get登录返回信息().getVehicleCount());

                break;
        }


        switch (LocalValue.get登录返回信息().getUserType()) {
            case UserTypeReqBean.驾驶员:
                switch (LocalValue.get登录返回信息().getBindCompanyState()){
                    case LoginResBean.BIND_UNIT_STATE_UNBIND:
                        fragMyceDriverBinding.itemUnit.getLeftTV().setText("绑定单位");
                        fragMyceDriverBinding.itemUnit.getRightTV().setText(LoginResBean.BIND_UNIT_STATE_UNBIND_CN);
                        fragMyceDriverBinding.itemUnit.setRightTxt("");
                        break;
                    case LoginResBean.BIND_UNIT_STATE_CHECK:
                        fragMyceDriverBinding.itemUnit.getLeftTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getCompanyName()));
                        fragMyceDriverBinding.itemUnit.setRightTxt(LoginResBean.BIND_UNIT_STATE_CHECK_CN);
                        break;
                    case LoginResBean.BIND_UNIT_STATE_BINDED:
                        fragMyceDriverBinding.itemUnit.getLeftTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getCompanyName()));
                        fragMyceDriverBinding.itemUnit.setRightTxt("");
                        break;
                    case LoginResBean.BIND_UNIT_STATE_REJECT:
                        fragMyceDriverBinding.itemUnit.getLeftTV().setText("绑定单位");
                        fragMyceDriverBinding.itemUnit.setRightTxt(LoginResBean.BIND_UNIT_STATE_REJECT_CN);
                        break;
                }
                break;
            case UserTypeReqBean.非驾驶员:
                switch (LocalValue.get登录返回信息().getBindCompanyState()){
                    case LoginResBean.BIND_UNIT_STATE_UNBIND:
                        fragMyceGeneralBinding.itemUnit.getLeftTV().setText("绑定单位");
                        fragMyceGeneralBinding.itemUnit.getRightTV().setText(LoginResBean.BIND_UNIT_STATE_UNBIND_CN);
                        fragMyceGeneralBinding.itemUnit.setRightTxt("");
                        break;
                    case LoginResBean.BIND_UNIT_STATE_CHECK:
                        fragMyceGeneralBinding.itemUnit.getLeftTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getCompanyName()));
                        fragMyceGeneralBinding.itemUnit.setRightTxt(LoginResBean.BIND_UNIT_STATE_CHECK_CN);
                        break;
                    case LoginResBean.BIND_UNIT_STATE_BINDED:
                        fragMyceGeneralBinding.itemUnit.getLeftTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getCompanyName()));
                        fragMyceGeneralBinding.itemUnit.setRightTxt("");
                        break;
                    case LoginResBean.BIND_UNIT_STATE_REJECT:
                        fragMyceGeneralBinding.itemUnit.getLeftTV().setText("绑定单位");
                        fragMyceGeneralBinding.itemUnit.setRightTxt(LoginResBean.BIND_UNIT_STATE_REJECT_CN);
                        break;
                }
                break;
        }
    }

    public void hideOrShowManageFunction(boolean show){
        int vis = View.VISIBLE;
        if(show&& LocalValue.get登录返回信息().getUserType()==UserTypeReqBean.非驾驶员 &&!LoginResBean.USER_ROLE_GENERAL.equals(LocalValue.get登录返回信息().getUserRole())){
            vis = View.VISIBLE;
        }else{
            vis = View.GONE;
        }
        if(fragMyceGeneralBinding!=null){
            fragMyceGeneralBinding.itemCar.setVisibility(vis);
            fragMyceGeneralBinding.itemGood.setVisibility(vis);
            fragMyceGeneralBinding.itemStore.setVisibility(vis);
            fragMyceGeneralBinding.itemUser.setVisibility(vis);
        }
    }


}
