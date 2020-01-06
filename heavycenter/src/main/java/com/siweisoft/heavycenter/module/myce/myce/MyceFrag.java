package com.siweisoft.heavycenter.module.myce.myce;

//by summer on 2017-12-14.

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.android.lib.constant.ValueConstant;
import com.android.lib.network.bean.res.BaseResBean;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.IntentUtil;
import com.android.lib.util.ScreenUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.github.florent37.viewanimator.ViewAnimator;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.update.UpdateCarRes;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadReqBean;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadResBean;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.main.main.MainValue;
import com.siweisoft.heavycenter.module.mana.car.CarsFrag;
import com.siweisoft.heavycenter.module.mana.good.GoodFrag;
import com.siweisoft.heavycenter.module.mana.store.StoreFrag;
import com.siweisoft.heavycenter.module.mana.user.list.UserFrag;
import com.siweisoft.heavycenter.module.mana.user.list.UserValue;
import com.siweisoft.heavycenter.module.myce.car.bind.BindFrag;
import com.siweisoft.heavycenter.module.myce.name.NameFrag;
import com.siweisoft.heavycenter.module.myce.sett.SetFrag;
import com.siweisoft.heavycenter.module.myce.unit.list.UnitListDAOpe;
import com.siweisoft.heavycenter.module.myce.unit.list.UnitListFrag;
import com.siweisoft.heavycenter.module.myce.base.info.InfoFrag;
import com.siweisoft.heavycenter.module.myce.unit.news.NewUnitFrag;

import java.io.File;
import java.io.IOException;
import java.util.List;

import butterknife.OnClick;
import butterknife.Optional;
import id.zelory.compressor.Compressor;

public class MyceFrag extends AppFrag<MyceUIOpe,MyceDAOpe> {



    @Override
    public void initNow() {
        super.initNow();
        getP().getU().hideOrShowManageFunction(((MainAct)(getActivity())).getP().getD().is绑定了单位());
    }

    @Override
    public void initdelay() {
        super.initdelay();
        getP().getU().initUI();
    }

    public void init(){
        getP().getU().initUI();
        getP().getU().hideOrShowManageFunction(((MainAct)(getActivity())).getP().getD().is绑定了单位());
    }

    public void initUINET(){
        getP().getD().getInfo(new UINetAdapter<LoginResBean>(this) {
            @Override
            public void onSuccess(LoginResBean o) {
                LocalValue.save登录返回信息(o);
                init();
            }
        });
    }

    @Optional
    @OnClick({R.id.item_car,R.id.tv_name,R.id.item_good,R.id.item_store,R.id.item_user,R.id.item_unit,R.id.iv_nameedit,R.id.ftv_right,R.id.iv_head,R.id.item_setting,R.id.iv_car,R.id.iv_dirver,R.id.item_driver})
    public void onClick(View v){

        //((MainAct)activity).getP().getU().unSelectBottomMenu();
        FragManager2.getInstance().clear(getBaseUIAct(), MainValue.主界面);
        switch (v.getId()){
            case R.id.login:
                break;
            case R.id.ftv_back:

                break;
            case R.id.item_car:
                FragManager2.getInstance().start(getBaseUIAct(),MainValue.主界面,MainValue.主界面ID,new CarsFrag());

                break;
            case R.id.item_good:
                FragManager2.getInstance().start(getBaseUIAct(),MainValue.主界面,MainValue.主界面ID,new GoodFrag());
                break;
            case R.id.item_store:
                FragManager2.getInstance().start(getBaseUIAct(),MainValue.主界面,MainValue.主界面ID,new StoreFrag());
                break;
            case R.id.item_user:
                FragManager2.getInstance().start(getBaseUIAct(),MainValue.主界面,MainValue.主界面ID,UserFrag.getInstance(UserValue.查看用户));
                break;
            case R.id.item_unit:
                switch (LocalValue.get登录返回信息().getBindCompanyState()){
                    case LoginResBean.BIND_UNIT_STATE_BINDED:
                        Bundle bundle = new Bundle();
                        if(StringUtil.equals(LocalValue.get登录返回信息().getUserRole(),LoginResBean.USER_ROLE_SUPER_ADMIN)){
                            bundle.putString(ValueConstant.DATA_TYPE, NewUnitFrag.修改单位信息);
                        }else{
                            bundle.putString(ValueConstant.DATA_TYPE, NewUnitFrag.展示单位信息);
                        }
                        FragManager2.getInstance().start(getBaseUIAct(),MainValue.主界面,MainValue.主界面ID, new NewUnitFrag(),bundle);
                        break;
                    case LoginResBean.BIND_UNIT_STATE_CHECK:
                    case LoginResBean.BIND_UNIT_STATE_REJECT:
                    case LoginResBean.BIND_UNIT_STATE_UNBIND:
                        FragManager2.getInstance().start(getBaseUIAct(),MainValue.主界面,MainValue.主界面ID,UnitListFrag.getInstance(UnitListDAOpe.绑定单位));
                        break;
                }
                break;
            case R.id.tv_name:
                FragManager2.getInstance().start(getBaseUIAct(),MainValue.主界面,MainValue.主界面ID,new NameFrag());
                break;
            case R.id.ftv_right:
                final InfoFrag infoFrag = new InfoFrag();
                infoFrag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        infoFrag.getView().findViewById(R.id.rl_scan_info).setBackgroundColor(Color.TRANSPARENT);
                        FragManager2.getInstance().setFinishAnim(R.anim.anim_in3,R.anim.anim_out3).finish(getBaseUIAct(),MainValue.主界面,false);
                    }
                });
                FragManager2.getInstance().setAnim(false).start(getBaseUIAct(),MainValue.主界面,MainValue.主界面ID,infoFrag);
                ViewAnimator.animate(infoFrag.getView().findViewById(R.id.ll_a)).pivotX(ScreenUtil.w/2).pivotY(ScreenUtil.h/2).zoomIn().duration(300).start();
                break;
            case R.id.iv_head:


//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                    HeadTestFrag sharedElementFragment2 = new HeadTestFrag();
//
//                    Slide slideTransition = new Slide(Gravity.RIGHT);
//                    slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));
//
//                    ChangeBounds changeBoundsTransition = new ChangeBounds();
//                    changeBoundsTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));
//
//                    sharedElementFragment2.setEnterTransition(slideTransition);
//                    sharedElementFragment2.setAllowEnterTransitionOverlap(false);
//                    sharedElementFragment2.setAllowReturnTransitionOverlap(false);
//                    sharedElementFragment2.setSharedElementEnterTransition(changeBoundsTransition);
//
//                    MainAct mainAct = (MainAct) getBaseUIAct();
//                    getFragmentManager().beginTransaction()
//                            .add(mainAct.getP().getU().bind.incloud.hvLeftDrawer.getId(), sharedElementFragment2)
//                            .hide(this)
//                            .setReorderingAllowed(true)
//                            .addToBackStack(null)
//                            .addSharedElement(v, "cirlceimageview")
//                            .commit();
//                    return;
//                }


                // IntentUtil.getInstance().takeGetPhoto(activity);
                IntentUtil.getInstance().pickImage(this,01);
                //IntentUtil.getInstance().photosShowFromphone(this,01);
                break;
            case R.id.item_setting:
                FragManager2.getInstance().start(getBaseUIAct(),MainValue.主界面,MainValue.主界面ID,new SetFrag());
                break;
            case R.id.iv_car:
                //IntentUtil.getInstance().photoShowFromphone(this,02);
                return;
            case R.id.iv_dirver:
                //IntentUtil.getInstance().photoShowFromphone(this,03);
                return;
            case R.id.item_driver:
                FragManager2.getInstance().start(getBaseUIAct(),MainValue.主界面,MainValue.主界面ID,new BindFrag());
                break;
        }
        getBaseUIAct().setMoudle(MainValue.主界面);
        ((MainAct)getActivity()).getP().getU().switchDrawer();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data==null||requestCode != 01){
            return;
        }
        List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
        if(selectList==null||selectList.size()!=1){
            return;
        }
        File file;
        try {
            file = new Compressor(getActivity()).compressToFile(new File(selectList.get(0).getCompressPath()));
        } catch (IOException e) {
            e.printStackTrace();
            file = new File(selectList.get(0).getCompressPath());
        }
        String type = "";
        switch (requestCode){
            case 1:
                type = UpdateHeadReqBean.头像;
                break;
            case 2:
                type = UpdateHeadReqBean.车辆照片;
                break;
            case 3:
                type = UpdateHeadReqBean.行驶证照片;
                break;
        }
        final String finalType = type;
        getP().getD().uploadPhoto(file,type, new UINetAdapter<UpdateHeadResBean>(this,true) {
            @Override
            public void onNetFinish(boolean haveData, String url, BaseResBean baseResBean) {
                stopLoading();
                if(haveData){
                    final LoginResBean loginResBean = LocalValue.get登录返回信息();
                    String s = baseResBean.getResult().toString();
                    if(s!=null){
                        if(s.trim().startsWith("[")){
                            s= s.substring(1,s.length()-1).trim();
                        }
                        switch (finalType){
                            case UpdateHeadReqBean.头像:
                                loginResBean.setUserPhoto(s);
                                LocalValue.save登录返回信息(loginResBean);
                                getP().getU().initUI();
                                ToastUtil.getInstance().showShort(getActivity(),"更换头像成功");
                                break;
                            case UpdateHeadReqBean.车辆照片:
                                loginResBean.setVehicleLicense(s);
                                LocalValue.save登录返回信息(loginResBean);
                                getP().getD().updateCar(new UINetAdapter<UpdateCarRes>(MyceFrag.this,true) {
                                    @Override
                                    public void onSuccess(UpdateCarRes o) {
                                        getP().getU().initUI();
                                    }
                                });
                                break;
                            case UpdateHeadReqBean.行驶证照片:
                                loginResBean.setVehicleLicensePhoto(s);
                                LocalValue.save登录返回信息(loginResBean);
                                getP().getD().updateCar(new UINetAdapter<UpdateCarRes>(MyceFrag.this,true) {
                                    @Override
                                    public void onSuccess(UpdateCarRes o) {
                                        getP().getU().initUI();
                                    }
                                });
                                break;
                        }

                    }
                }
            }
        });


    }
}
