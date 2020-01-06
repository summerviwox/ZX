package com.siweisoft.heavycenter.module.main.main;

//by summer on 17-08-23.

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.siweisoft.heavycenter.base.AppAct;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.jpush.main.MainPush;
import com.siweisoft.heavycenter.data.netd.msg.push.MsgPush;
import com.siweisoft.heavycenter.module.welc.welc.WelcAct;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainAct extends AppAct<MainUIOpe, MainDAOpe> implements OnAppItemSelectListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtil.被后台清理了就重启(getActivity(),savedInstanceState,WelcAct.class);
        if(!getDE().getPermissionUtil().is所有的权限都允许(getActivity(),getDE().getPermissions())){
            return;
        }
        初始化界面();



    }




    public void 初始化界面(){
        getUI().setBottomMenuViewData(getDE().initBottomdata());
        getUI().initDrawerMenu(getDE().getMyceFrag());
        getUI().initPages(getDE().getBottomdata(),this);
        if(getDE().getMyceFrag().getUI()!=null){
            getDE().getMyceFrag().init();
        }
    }

    public void go判断是否绑定单位处理(){
        getUI().initPages(getDE().initBottomdata(),this);
        if(getDE().getMyceFrag().getUI()!=null){
            getDE().getMyceFrag().init();
        }
    }

    public void go网络获取用户信息重新加载(){
        getDE().get用户信息(new UINetAdapter<LoginResBean>(this) {
            @Override
            public void onSuccess(LoginResBean o) {
                super.onSuccess(o);
                LocalValue.save登录返回信息(o);
                go判断是否绑定单位处理();
            }
        });
    }


    @Override
    public void onAppItemSelect(ViewGroup viewGroup, View view, int position) {
        FragManager2.getInstance().clear((BaseUIActivity) getActivity(),MainValue.主界面);
        getUI().setCurrentItem(position);
        setMoudle(getDE().getBottomdata().get(position).getName());
        getDE().getBottomdata().get(position).getFragment().onFristVisible();
//        if(position==getDE().getMenudata().size()-1){
//            if(!getDE().is绑定了单位()){
//                getUI().hideshowunbind(false);
//            }
//        }else{
//            if(!getDE().is绑定了单位()){
//                getUI().hideshowunbind(true);
//            }
//        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(!getDE().getPermissionUtil().onRequestPermissionsResult(getActivity(),requestCode,grantResults)){
            return;
        }
        初始化界面();
    }



    @Override
    public void onBackPressed() {

        BaseUIFrag baseUIFrag = FragManager2.getInstance().getCurrentFrag(getMoudle());
        if(baseUIFrag!=null&&baseUIFrag.getFragM()!=null){
            FragManager2 fragManager2 = baseUIFrag.getFragM();
            if(!fragManager2.finish(getActivity(),getMoudle(),!getMoudle().equals(MainValue.主界面))){//清除当前页面
                super.onBackPressed();//当前模块没有可清除界面
            }else{
                //当前模块有可清除界面
                if(FragManager2.getInstance().getMoudleFragSize(MainValue.主界面)==0){
                    onAppItemSelect(null,null,getUI().bind.bottommenu.getIndex());
                }

            }
        }else{
            super.onBackPressed();
        }
//        if(!FragManager2.getInstance().finish(getActivity(),getMoudle(),!getMoudle().equals(MainValue.主界面))){
//            super.onBackPressed();
//        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (null != data && data.getExtras()!=null &&IntentIntegrator.REQUEST_CODE==requestCode) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if(result != null&&result.getContents() != null) {
                ToastUtil.getInstance().showShort(getActivity(),FragManager2.getInstance().getCurrentFrag(getMoudle()).getClass().getSimpleName());
                getDE().getScanDAOpe().logic((AppFrag) FragManager2.getInstance().getCurrentFrag(getMoudle()),result.getContents());
            } else {
                ToastUtil.getInstance().showShort(this,"解析二维码失败");
            }
        }

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void XXX(MessageEvent m) {
        if("net".equals(m.sender)){
            LocalValue.set自动登录(false);
            startActivity(new Intent(this,WelcAct.class));
            this.finish();
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MainPush(MainPush m) {
        if(m==null||m.getMsg()==null){
            return;
        }
        MsgPush msgPush = GsonUtil.getInstance().fromJson(m.getMsg(),MsgPush.class);
        if(msgPush.getMessageType()==null){
            return;
        }
        switch (msgPush.getMessageType()){
            default:
                if (SystemUtil.isBackground(getActivity())) {
                    IntentUtil.getInstance().IntentTo(getActivity(), getActivity().getPackageName());
                }

                PowerManager pm = (PowerManager) getActivity().getSystemService(Context.POWER_SERVICE);
                PowerManager.WakeLock mWakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE, "SimpleTimer");
                mWakeLock.acquire();//这里唤醒锁，用这种方式要记得在适当的地方关闭锁，
                mWakeLock.release();
                onAppItemSelect(null,null,getDE().getPos(MainValue.消息));
                break;
        }
    }



    @Override
    protected boolean registerEventBus() {
        return true;
    }
}
