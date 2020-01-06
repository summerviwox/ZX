package com.siweisoft.heavycenter.module.myce.base.info;

//by summer on 2017-12-19.

import android.content.Context;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.util.GsonUtil;
import com.android.lib.util.ScreenUtil;
import com.android.lib.util.StringUtil;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.locd.scan.user.UserInfo;
import com.siweisoft.heavycenter.databinding.FragScanInfoBinding;
import com.siweisoft.heavycenter.tools.CodeUtils;

public class InfoUIOpe extends AppUIOpe<FragScanInfoBinding>{



    public void initUI() {
        super.initUI();
        bind.setVariable(BR.frag_scan_info, LocalValue.get登录返回信息());
    }

    public void initScan(){
        UserInfo userInfo = new UserInfo();
        userInfo.setID(LocalValue.get登录返回信息().getUserId());
        userInfo.setType("HCUser");
        userInfo.setName(StringUtil.getStr(LocalValue.get登录返回信息().getTrueName()));
        userInfo.setMobile(StringUtil.getStr(LocalValue.get登录返回信息().getTel()));
        bind.ivScan.setImageBitmap(CodeUtils.createImage(GsonUtil.getInstance().toJson(userInfo), (int) (ScreenUtil.最小DIMEN *180), (int) (ScreenUtil.最小DIMEN *180), null));
    }
}
