package com.siweisoft.heavycenter.module.scan;

//by summer on 2018-01-25.

import android.content.Context;
import android.os.Bundle;

import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.constant.ValueConstant;
import com.android.lib.util.ToastUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.locd.scan.user.UserInfo;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;
import com.siweisoft.heavycenter.module.main.store.detail.DetailFrag;

public class StoreScanDAOpe extends BaseDAOpe {
    public StoreScanDAOpe() {
    }

    public StoreScanDAOpe(Context context) {
        super(context);
    }

    public void logic(final AppFrag appFrag, UserInfo userInfo){

        if((LocalValue.get登录返回信息().getUserType()== UserTypeReqBean.驾驶员)){
            ToastUtil.getInstance().showShort(getActivity(),"称重，显示对应消息，缓存或发送请求");
            return;
        }

        if((LocalValue.get登录返回信息().getUserType()== UserTypeReqBean.非驾驶员)&&(LocalValue.get登录返回信息().getBindCompanyState()==LoginResBean.BIND_UNIT_STATE_BINDED)){
            ToastUtil.getInstance().showShort(getActivity(),"仓库详情");
            Bundle bundle = new Bundle();
            int id = 0;
            try {
                id = Integer.parseInt(userInfo.getNo());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            bundle.putInt(ValueConstant.DATA_DATA,id);
            FragManager2.getInstance().start(getActivity(),getActivity().getMoudle(),new DetailFrag(),bundle);
            return;
        }

    }
}
