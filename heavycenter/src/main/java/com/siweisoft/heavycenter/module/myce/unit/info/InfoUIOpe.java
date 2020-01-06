package com.siweisoft.heavycenter.module.myce.unit.info;

//by summer on 2017-12-19.

import android.view.LayoutInflater;
import android.view.View;

import com.android.lib.util.StringUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;
import com.siweisoft.heavycenter.databinding.FragMyceUnitInfoBinding;
import com.siweisoft.heavycenter.module.view.center.DiaLogCenterFrag;

public class InfoUIOpe extends AppUIOpe<FragMyceUnitInfoBinding>{


    FragManager2 fragManager2;


    public void initinfo(UnitInfo unitInfo){
        if(unitInfo==null){
            return;
        }
        bind.itemName.setMidTVTxt(unitInfo.getCompanyName());
        bind.itemShort.setMidTVTxt(unitInfo.getAbbreviationName());
        bind.itemUnunit.setMidTVTxt(unitInfo.getParentCompanyName());
        bind.itemAddr.setMidTVTxt(unitInfo.getCompanyAddress());
        bind.itemArea.setMidTVTxt(unitInfo.getBelongArea());
        bind.itemContact.setMidTVTxt(unitInfo.getContactName());
        bind.itemPhone.setMidTVTxt(unitInfo.getContactPhone());

        if(StringUtil.equals(LocalValue.get登录返回信息().getUserRole(), LoginResBean.USER_ROLE_SUPER_ADMIN)){
            bind.itemName.setEdit(true);
            bind.itemShort.setEdit(true);
            bind.itemUnunit.getRightIV().setBackgroundResource(R.drawable.icon_hv_into);
            bind.itemAddr.getRightIV().setBackgroundResource(R.drawable.icon_hv_into);
           bind.itemArea.getRightIV().setBackgroundResource(R.drawable.icon_hv_into);
            bind.itemContact.setEdit(true);
            bind.itemPhone.setEdit(true);
        }

    }

    public void showTip(View.OnClickListener onClickListener){
        DiaLogCenterFrag diaLogCenterFrag = new DiaLogCenterFrag();
        diaLogCenterFrag.setCustomView(LayoutInflater.from(context).inflate(R.layout.frag_myce_unit_bind_tip_leave,null));
        diaLogCenterFrag.setOnClickListener(onClickListener,R.id.close,R.id.sure);
        fragManager2 = FragManager2.getInstance().setStartAnim(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in,R.anim.fade_out).setFinishAnim(R.anim.fade_in,R.anim.fade_out).setHideLast(false);
        fragManager2.start(getActivity(), getFrag().get容器(),diaLogCenterFrag);
    }

    public FragManager2 getFragManager2() {
        return fragManager2;
    }
}
