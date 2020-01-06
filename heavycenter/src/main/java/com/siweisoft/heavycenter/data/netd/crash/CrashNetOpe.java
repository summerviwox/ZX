package com.siweisoft.heavycenter.data.netd.crash;

//by summer on 2017-12-12.

import android.content.Context;

import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.network.NetWork;
import com.android.lib.network.bean.req.BaseReqBean;
import com.android.lib.network.bean.res.BaseResBean;
import com.android.lib.network.netadapter.OnNetWorkReqAdapter;
import com.android.lib.util.GsonUtil;
import com.android.lib.util.data.DateFormatUtil;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;

public class CrashNetOpe extends BaseDAOpe{

    public CrashNetOpe(Context context) {
        super(context);
    }

    public static void setCrash(Context context,String txt){
        BaseReqBean baseReqBean = new BaseReqBean();
        CrashBean crash = new CrashBean();
        crash.setCreatedtime(DateFormatUtil.getNowStr(DateFormatUtil.YYYY_MM_DD_HH_MM_SS));
        crash.setError(txt);
        CrashBean.UserBeanBean userBeanBean = new CrashBean.UserBeanBean();
        LoginResBean loginResBean = LocalValue.get登录返回信息();
        if(loginResBean!=null){
            userBeanBean.setId(loginResBean.getUserId());
            userBeanBean.setName(loginResBean.getTrueName());
            userBeanBean.setPhone(loginResBean.getTel());
            userBeanBean.setUsertype(loginResBean.getUserType());
        }
        crash.setUserBean(userBeanBean);
        crash.setPlatform(context.getPackageName());
        baseReqBean.setData(GsonUtil.getInstance().toJson(crash));
        NetWork.postData(context, NetValue.奔溃日志, baseReqBean, new OnNetWorkReqAdapter(context) {
            @Override
            public void onNetWorkResult(boolean success, BaseResBean o) {

            }
        });
    }
}
