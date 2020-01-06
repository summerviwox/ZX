package com.siweisoft.heavycenter.module.acct.repwd;

//by summer on 2017-12-14.

import android.content.Context;

import com.android.lib.network.bean.res.BaseResBean;
import com.android.lib.network.netadapter.OnNetWorkReqAdapter;
import com.android.lib.network.netadapter.UINetAdapter;
import com.android.lib.network.news.NetAdapter;
import com.android.lib.network.news.NetI;
import com.android.lib.util.GsonUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.android.lib.util.thread.ThreadUtil;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.acct.code.CodeReqBean;
import com.siweisoft.heavycenter.data.netd.acct.code.CodeResBean;
import com.siweisoft.heavycenter.data.netd.acct.forget.ForGetReqBean;
import com.siweisoft.heavycenter.data.netd.acct.forget.ForGetResBean;
import com.siweisoft.heavycenter.data.netd.acct.regist.RegistReqBean;
import com.siweisoft.heavycenter.data.netd.acct.regist.RegistResBean;

public class RepwdDAOpe extends AppDAOpe {

    private ThreadUtil threadUtil = new ThreadUtil();


    public String getImageUrl(){
        return "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513325040026&di=9e408824bb71605801a3e73997457851&imgtype=0&src=http%3A%2F%2Fbbs.static.coloros.com%2Fdata%2Fattachment%2Fforum%2F201503%2F06%2F183706dti1utuig1rqa13y.jpg";
    }

    public void updatePwd(ForGetReqBean reqBean, NetI<ForGetResBean> adapter){
        NetDataOpe.updatePwd(getActivity(), NetValue.获取地址("/user/forgetPwd"),reqBean,adapter);
    }

    public void getCode(CodeReqBean reqBean){
        NetDataOpe.getCode(getActivity(), NetValue.获取地址("/user/getSecurityCode"), reqBean, new NetAdapter<CodeResBean>(getActivity()) {
            @Override
            public void onNetFinish(boolean haveData, String url, BaseResBean o) {
                ToastUtil.getInstance().showShort(getActivity(), StringUtil.getStr(o.getResult())+" "+o.getMessage());

            }
        });
    }

    public ThreadUtil getThreadUtil() {
        return threadUtil;
    }
}
