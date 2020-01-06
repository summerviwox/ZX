package com.siweisoft.heavycenter.module.scan;

import android.content.Context;
import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.GsonUtil;
import com.android.lib.util.NullUtil;
import com.android.lib.util.ToastUtil;
import com.google.gson.JsonSyntaxException;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.scan.user.UserInfo;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.unit.info.UnitInfoReqBean;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;
import com.siweisoft.heavycenter.data.netd.user.info.UserInfoReqBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;

/**
 * Created by summer on 2018/1/25 0:33.
 */

public class ScanDAOpe extends BaseDAOpe {


    public ScanDAOpe() {
    }

    public ScanDAOpe(Context context ){
        super(context);
    }

    public void logic(final AppFrag appFrag,String data){

         UserInfo userInfo = null;
        try {
            userInfo = GsonUtil.getInstance().fromJson(data,UserInfo.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } finally {

        }
        if(userInfo==null|| NullUtil.isStrEmpty(userInfo.getType())){
            ToastUtil.getInstance().showShort(context,"扫码信息有误");
            return;
        }



        switch (userInfo.getType()) {
            case UserInfo.TYPE_STORE:
                StoreScanDAOpe storeScanDAOpe = new StoreScanDAOpe(context);
                storeScanDAOpe.logic(appFrag,userInfo);
                break;
            case UserInfo.TYPE_UNIT:
                UnitInfoReqBean unitInfoReqBean = new UnitInfoReqBean();
                unitInfoReqBean.setId(userInfo.getID());
                final UserInfo finalUserInfo = userInfo;
                NetDataOpe.Unit.getInfo(getActivity(), unitInfoReqBean, new UINetAdapter<UnitInfo>(getActivity()) {
                    @Override
                    public void onResult(boolean success, String msg, UnitInfo o) {
                        super.onResult(success, msg, o);
                        if(success){
                            UnitScanDAOpe unitScanDAOpe = new UnitScanDAOpe(context);
                            o.setId(finalUserInfo.getID());
                            unitScanDAOpe.logic(appFrag, o);
                        }

                    }
                });

                break;
            case UserInfo.TYPE_USER:
                UserInfoReqBean infoReqBean = new UserInfoReqBean();
                infoReqBean.setIsApp(1);
                infoReqBean.setId(userInfo.getID());
                NetDataOpe.User.get用户信息(getActivity(), infoReqBean, new UINetAdapter<LoginResBean>(getActivity()) {
                    @Override
                    public void onResult(boolean success, String msg, LoginResBean o) {
                        super.onResult(success, msg, o);
                        if (!success) {
                            return;
                        }
                        UserScanDAOpe userScanDAOpe = new UserScanDAOpe(context);
                        userScanDAOpe.logic(appFrag, o);
                    }
                });
                break;
            case UserInfo.TYPE_WEIGHT:
                WeightScanDAOpe weightScanDAOpe = new WeightScanDAOpe(context);
                weightScanDAOpe.logic(appFrag,userInfo);
                break;
        }
    }

























    public static int getCode(LoginResBean res){
        int a = 0;
        int b= 0;
        int c = 0;

        switch (res.getUserRole()){
            case LoginResBean.USER_ROLE_GENERAL:
                c = 1;
                break;
            case LoginResBean.USER_ROLE_ADMIN:
                c = 2;
                break;
            case LoginResBean.USER_ROLE_SUPER_ADMIN:
                c = 3;
                break;
            case LoginResBean.USER_ROLE_SYS_ADMIN:
                c = 4;
                break;
        }


        switch (res.getUserType()){
            case   UserTypeReqBean.驾驶员:
                a= 1;
                c= 0;
                break;
            case   UserTypeReqBean.非驾驶员:
                a = 2;
                break;
                default:
                    a=0;
                    break;
        }
        switch (res.getBindCompanyState()){
            case LoginResBean.BIND_UNIT_STATE_BINDED:
                b=1;
                break;
                default:
                    b = 0 ;
                    break;
        }
        return a*100+b*10+c;

    }

    public static ScanBean getScanBean(LoginResBean res,AppFrag appFrag){
        return new ScanBean(getCode(res),appFrag.getClass().getName());
    }
}
