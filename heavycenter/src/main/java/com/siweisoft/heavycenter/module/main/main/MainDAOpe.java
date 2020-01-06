package com.siweisoft.heavycenter.module.main.main;

//by summer on 17-08-23.

import android.Manifest;
import android.widget.RelativeLayout;

import com.android.lib.network.news.NetI;
import com.android.lib.util.OjectUtil;
import com.android.lib.util.system.PermissionUtil;
import com.android.lib.view.bottommenu.BottomMenuBean;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.user.info.UserInfoReqBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;
import com.siweisoft.heavycenter.module.main.map.MapFrag;
import com.siweisoft.heavycenter.module.main.msg.MsgsFrag;
import com.siweisoft.heavycenter.module.main.orders.OrdersFrag;
import com.siweisoft.heavycenter.module.main.store.StoreFrag;
import com.siweisoft.heavycenter.module.main.trans.trans.TransFrag;
import com.siweisoft.heavycenter.module.main.weights.weights.WeightsFrag;
import com.siweisoft.heavycenter.module.main.weights.detail.DetailFrag;
import com.siweisoft.heavycenter.module.myce.myce.MyceFrag;
import com.siweisoft.heavycenter.module.myce.unit.nobind.NoBindFrag;
import com.siweisoft.heavycenter.module.scan.ScanDAOpe;

import java.util.ArrayList;

public class MainDAOpe extends AppDAOpe {

    private ArrayList<BottomMenuBean> bottomdata = new ArrayList<>();

    private ArrayList<BottomMenuBean> menudata = new ArrayList<>();

    private ArrayList<BottomMenuBean> nodata = new ArrayList<>();

    private PermissionUtil permissionUtil;

    private int index=0;

    MyceFrag myceFrag ;

    ScanDAOpe scanDAOpe;


    @Override
    public void initDA() {
        super.initDA();
        initBottomMenuViewData();
        initBottomMenuViewNoData();
        permissionUtil= new PermissionUtil();
    }

    protected ArrayList<BottomMenuBean> initBottomMenuViewData(){
        menudata.clear();
        if(OjectUtil.equals(LocalValue.get登录返回信息().getUserType(),UserTypeReqBean.驾驶员)){
            RelativeLayout v0 = new RelativeLayout(context);v0.setId(MainValue.地磅ID);
            menudata.add(new BottomMenuBean(MainValue.称重, R.drawable.drawable_main_bottom_weight,new DetailFrag(),v0, context.getResources().getColorStateList(R.color.color_hv_bottom_select)));
        }else{
            RelativeLayout v0 = new RelativeLayout(context);v0.setId(MainValue.地磅ID);
            menudata.add(new BottomMenuBean(MainValue.地磅, R.drawable.drawable_main_bottom_weight,new WeightsFrag(),v0, context.getResources().getColorStateList(R.color.color_hv_bottom_select)));
        }

        RelativeLayout v1 = new RelativeLayout(context);v1.setId(MainValue.运输单ID);
        menudata.add(new BottomMenuBean(MainValue.运输单, R.drawable.drawable_main_bottom_trans,new TransFrag(),v1,context.getResources().getColorStateList(R.color.color_hv_bottom_select)));

        if(OjectUtil.equals(LocalValue.get登录返回信息().getUserType(),UserTypeReqBean.驾驶员)){
            RelativeLayout v2 = new RelativeLayout(context);v2.setId(MainValue.地图ID);
            menudata.add(new BottomMenuBean(MainValue.地图, R.drawable.drawable_main_bottom_order,new MapFrag(),v2,context.getResources().getColorStateList(R.color.color_hv_bottom_select)));
        }else{
            RelativeLayout v2 = new RelativeLayout(context);v2.setId(MainValue.订单ID);
            menudata.add(new BottomMenuBean(MainValue.订单, R.drawable.drawable_main_bottom_order,new OrdersFrag(),v2,context.getResources().getColorStateList(R.color.color_hv_bottom_select)));

            RelativeLayout v3 = new RelativeLayout(context);v3.setId(MainValue.仓库ID);
            menudata.add(new BottomMenuBean(MainValue.仓库, R.drawable.drawable_main_bottom_store,new StoreFrag(),v3,context.getResources().getColorStateList(R.color.color_hv_bottom_select)));
        }
        RelativeLayout v4 = new RelativeLayout(context);v4.setId(MainValue.消息ID);
        menudata.add(new BottomMenuBean(MainValue.消息, R.drawable.drawable_main_bottom_msg,new MsgsFrag(),v4,context.getResources().getColorStateList(R.color.color_hv_bottom_select)));
        return menudata;
    }


    protected ArrayList<BottomMenuBean> initBottomMenuViewNoData(){
        nodata.clear();
        if(OjectUtil.equals(LocalValue.get登录返回信息().getUserType(),UserTypeReqBean.驾驶员)){
            RelativeLayout v0 = new RelativeLayout(context);v0.setId(MainValue.地磅ID);
            nodata.add(new BottomMenuBean(MainValue.称重, R.drawable.drawable_main_bottom_weight,new NoBindFrag(),v0, context.getResources().getColorStateList(R.color.color_hv_bottom_select)));
        }else{
            RelativeLayout v0 = new RelativeLayout(context);v0.setId(MainValue.地磅ID);
            nodata.add(new BottomMenuBean(MainValue.地磅, R.drawable.drawable_main_bottom_weight,new NoBindFrag(),v0, context.getResources().getColorStateList(R.color.color_hv_bottom_select)));
        }

        RelativeLayout v1 = new RelativeLayout(context);v1.setId(MainValue.运输单ID);
        nodata.add(new BottomMenuBean(MainValue.运输单, R.drawable.drawable_main_bottom_trans,new NoBindFrag(),v1,context.getResources().getColorStateList(R.color.color_hv_bottom_select)));

        if(OjectUtil.equals(LocalValue.get登录返回信息().getUserType(),UserTypeReqBean.驾驶员)){
            RelativeLayout v2 = new RelativeLayout(context);v2.setId(MainValue.地图ID);
            nodata.add(new BottomMenuBean(MainValue.地图, R.drawable.drawable_main_bottom_order,new NoBindFrag(),v2,context.getResources().getColorStateList(R.color.color_hv_bottom_select)));
        }else{
            RelativeLayout v2 = new RelativeLayout(context);v2.setId(MainValue.订单ID);
            nodata.add(new BottomMenuBean(MainValue.订单, R.drawable.drawable_main_bottom_order,new NoBindFrag(),v2,context.getResources().getColorStateList(R.color.color_hv_bottom_select)));

            RelativeLayout v3 = new RelativeLayout(context);v3.setId(MainValue.仓库ID);
            nodata.add(new BottomMenuBean(MainValue.仓库, R.drawable.drawable_main_bottom_store,new NoBindFrag(),v3,context.getResources().getColorStateList(R.color.color_hv_bottom_select)));
        }
        RelativeLayout v4 = new RelativeLayout(context);v4.setId(MainValue.消息ID);
        nodata.add(new BottomMenuBean(MainValue.消息, R.drawable.drawable_main_bottom_msg,new MsgsFrag(),v4,context.getResources().getColorStateList(R.color.color_hv_bottom_select)));
        return nodata;
    }

    public int getPos(String name){
        for(int i=0;i<getBottomdata().size();i++){
            if(getBottomdata().get(i).getName().equals(name)){
                return i;
            }
        }
        return 0;
    }


    public MyceFrag getMyceFrag() {
        if(myceFrag==null){
            myceFrag= new MyceFrag();
        }
        return myceFrag;
    }

    private String[] permissions = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.VIBRATE,
            Manifest.permission.INTERNET,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.WAKE_LOCK,
            Manifest.permission.MODIFY_AUDIO_SETTINGS,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.RECEIVE_BOOT_COMPLETED,
            Manifest.permission.DISABLE_KEYGUARD
    };

    public String[] getPermissions() {
        return permissions;
    }


    public ArrayList<BottomMenuBean> getBottomdata() {
        if(is绑定了单位()){
            return menudata;
        }
        return nodata;
    }


    public ArrayList<BottomMenuBean> initBottomdata() {
        if(is绑定了单位()){
            return initBottomMenuViewData();
        }
        return initBottomMenuViewNoData();
    }


    public PermissionUtil getPermissionUtil() {
        return permissionUtil;
    }

    public void get用户信息(NetI<LoginResBean> adapter){
        UserInfoReqBean userInfoReqBean = new UserInfoReqBean();
        userInfoReqBean.setId(LocalValue.get登录返回信息().getUserId());
        NetDataOpe.User.get用户信息(getActivity(),userInfoReqBean,adapter);
    }

    public boolean is绑定了单位() {
        //绑定了单位== true
        if(LocalValue.get登录返回信息().getBindCompanyState()== LoginResBean.BIND_UNIT_STATE_BINDED){
            return true;
        }
        return false;
    }




    public ScanDAOpe getScanDAOpe() {
        if(scanDAOpe==null){
            scanDAOpe = new ScanDAOpe(getActivity());
        }
        return scanDAOpe;
    }


}
