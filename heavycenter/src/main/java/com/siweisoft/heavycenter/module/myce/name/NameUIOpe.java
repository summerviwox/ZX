package com.siweisoft.heavycenter.module.myce.name;

//by summer on 2017-12-19.

import android.content.Context;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.rename.ReNameReqBean;
import com.siweisoft.heavycenter.databinding.FragMyceNameBinding;

public class NameUIOpe extends AppUIOpe<FragMyceNameBinding>{

    ReNameReqBean reNameReqBean  = new ReNameReqBean();



    public void initTxt() {
        bind.itemName.setMidEtTxt(StringUtil.getStr(LocalValue.get登录返回信息().getTrueName()));
    }

    public boolean canGo(){
        if(NullUtil.isStrEmpty(bind.itemName.getMidEtTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"姓名不能为空");
            return false;
        }
        return true;
    }

    public ReNameReqBean getReNameReqBean() {
        reNameReqBean.setId(LocalValue.get登录返回信息().getUserId());
        reNameReqBean.setTrueName(bind.itemName.getMidET().getText().toString());
        return reNameReqBean;
    }
}
