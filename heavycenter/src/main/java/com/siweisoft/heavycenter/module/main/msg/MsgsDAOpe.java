package com.siweisoft.heavycenter.module.main.msg;

//by summer on 2017-12-11.

import android.support.v4.app.Fragment;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.constant.ValueConstant;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.msg.list.MsgsReqBean;
import com.siweisoft.heavycenter.module.main.main.MainValue;
import com.siweisoft.heavycenter.module.main.msg.msg.MsgFrag;

import java.util.ArrayList;

public class MsgsDAOpe extends BaseDAOpe {


    private int comid=LocalValue.get登录返回信息().getCompanyId();

    public ArrayList<Fragment> getPages(){
        ArrayList<Fragment> pages = new ArrayList<>();
        for(int i = 0; i<MsgsReqBean.get消息类型().size(); i++){
            BaseUIFrag frag =MsgFrag.getInstance(MsgsReqBean.get消息类型().get(i));
            frag.getArguments().putString(ValueConstant.DATA_MOUDLE, MainValue.消息);
            pages.add(frag);
        }
        return pages;
    }

    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }
}
