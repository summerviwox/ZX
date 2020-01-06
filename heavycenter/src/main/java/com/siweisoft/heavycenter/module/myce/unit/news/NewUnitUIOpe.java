package com.siweisoft.heavycenter.module.myce.unit.news;

//by summer on 2017-12-19.

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.base.listener.BaseTextWather;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;
import com.siweisoft.heavycenter.data.netd.unit.news.NewReqBean;
import com.siweisoft.heavycenter.data.netd.unit.update.UpdateUnitReq;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;
import com.siweisoft.heavycenter.databinding.FragMyceUnitNewBinding;
import com.siweisoft.heavycenter.module.view.center.DiaLogCenterFrag;

public class NewUnitUIOpe extends AppUIOpe<FragMyceUnitNewBinding>{

    NewReqBean newReqBean = new NewReqBean();


    public NewReqBean getNewReqBean(UnitInfo unitInfo) {
        newReqBean.setCompanyName(bind.itemUnitname.getMidET().getText().toString());
        newReqBean.setAbbreviationName(bind.itemNunitshortname.getMidET().getText().toString());
        newReqBean.setCompanyAddress(unitInfo.getCompanyAddress());
        newReqBean.setCompanyLat(StringUtil.getStr(unitInfo.getCompanyLat()));
        newReqBean.setCompanyLng(StringUtil.getStr(unitInfo.getCompanyLng()));
        newReqBean.setContactPhone(bind.unitphone.getMidET().getText().toString());
        newReqBean.setBelongArea(unitInfo.getBelongArea());
        newReqBean.setContactName(bind.unitcontact.getMidET().getText().toString());
       /// if(LocalValue.get登录返回信息().getBindCompanyState()!= LoginResBean.BIND_UNIT_STATE_BINDED){
        if(LocalValue.get登录返回信息().getUserType()== UserTypeReqBean.非驾驶员){
            newReqBean.setCreater(LocalValue.get登录返回信息().getUserId());
        }
       ///}
        newReqBean.setHighCompany(unitInfo.getParentCompanyId()==0?-1:unitInfo.getParentCompanyId());
        return newReqBean;
    }


    public UpdateUnitReq getUpdateUnitReq(UnitInfo unitInfo) {
        UpdateUnitReq updateUnitReq = new UpdateUnitReq();
        updateUnitReq.setId(LocalValue.get登录返回信息().getCompanyId());
        updateUnitReq.setEditer(LocalValue.get登录返回信息().getUserId());
        updateUnitReq.setCompanyName(bind.itemUnitname.getMidET().getText().toString());
        updateUnitReq.setAbbreviationName(bind.itemNunitshortname.getMidET().getText().toString());
        updateUnitReq.setCompanyAddress(unitInfo.getCompanyAddress());
        updateUnitReq.setCompanyLat(StringUtil.getStr(unitInfo.getCompanyLat()));
        updateUnitReq.setCompanyLng(StringUtil.getStr(unitInfo.getCompanyLng()));
        updateUnitReq.setContactPhone(bind.unitphone.getMidET().getText().toString());
        updateUnitReq.setBelongArea(unitInfo.getBelongArea());
        updateUnitReq.setContactName(bind.unitcontact.getMidET().getText().toString());
        updateUnitReq.setHighCompany(unitInfo.getParentCompanyId());
        return updateUnitReq;
    }

    public boolean canGo(){
        if(NullUtil.isStrEmpty(bind.itemUnitname.getMidET().getText().toString())){
            ToastUtil.getInstance().showShort(getActivity(),"单位名称为空");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.itemNunitshortname.getMidET().getText().toString())){
            ToastUtil.getInstance().showShort(getActivity(),"单位简称为空");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.unitaddr.getMidTV().getText().toString())){
            ToastUtil.getInstance().showShort(getActivity(),"单位地址为空");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.unitcontact.getMidET().getText().toString())){
            ToastUtil.getInstance().showShort(getActivity(),"联系人为空");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.unitphone.getMidET().getText().toString())){
            ToastUtil.getInstance().showShort(getActivity(),"联系电话为空");
            return false;
        }
        return true;
    }


    public void initUI(String type){
        switch (type){
            case NewUnitFrag.修改单位信息:
                bind.title.getMidTV().setText("单位信息");
                break;
            case NewUnitFrag.展示单位信息:
                bind.itemUnitname.getMidET().setEnabled(false);
                bind.itemNunitshortname.getMidET().setEnabled(false);
                bind.unitcontact.getMidET().setEnabled(false);
                bind.unitphone.getMidET().setEnabled(false);
                bind.upunit.setEnabled(false);bind.upunit.getRightIV().setBackgroundResource(R.color.transparent);
                bind.unitaddr.setEnabled(false);bind.unitaddr.getRightIV().setBackgroundResource(R.color.transparent);
                bind.area.setEnabled(false);bind.area.getRightIV().setBackgroundResource(R.color.transparent);
                bind.title.getMidTV().setText("单位信息");
                bind.title.getRightIV2().setImageResource(R.drawable.icon_hv_quit);



                break;
            case NewUnitFrag.其他人查看单位信息:
                bind.itemUnitname.getMidET().setEnabled(false);
                bind.itemNunitshortname.getMidET().setEnabled(false);
                bind.unitcontact.getMidET().setEnabled(false);
                bind.unitphone.getMidET().setEnabled(false);
                bind.upunit.setEnabled(false);bind.upunit.getRightIV().setImageResource(R.color.transparent);
                bind.unitaddr.setEnabled(false);bind.unitaddr.getRightIV().setImageResource(R.color.transparent);
                bind.area.setEnabled(false);bind.area.getRightIV().setImageResource(R.color.transparent);
                bind.title.getMidTV().setText("单位信息");
                bind.title.getRightIV2().setEnabled(false);
                bind.title.getRightIV2().setVisibility(View.GONE);
            case NewUnitFrag.新建单位:
                bind.title.getMidTV().setText("新建单位");
                bind.unitphone.setMidEtTxt(LocalValue.get登录返回信息().getTel());
                bind.unitcontact.setMidEtTxt(LocalValue.get登录返回信息().getTrueName());
                break;

        }
    }




    public void initinfo(UnitInfo unitInfo){
        if(unitInfo==null){
            return;
        }
        bind.itemUnitname.setMidEtTxt(unitInfo.getCompanyName());
        bind.itemNunitshortname.setMidEtTxt(unitInfo.getAbbreviationName());
        bind.upunit.setMidTVTxt(StringUtil.getStr(unitInfo.getParentCompanyName()));
        bind.unitaddr.setMidTVTxt(unitInfo.getCompanyAddress());
        bind.area.setMidTVTxt(unitInfo.getBelongAreaDes());
        bind.unitcontact.setMidEtTxt(unitInfo.getContactName());
        bind.unitphone.setMidEtTxt(unitInfo.getContactPhone());
    }

    public void initUPUnitinfo(UnitInfo unitInfo){
        if(unitInfo==null){
            return;
        }
        bind.upunit.setMidTVTxt(StringUtil.getStr(unitInfo.getParentCompanyName()));
    }


    public void initAreaInfo(UnitInfo unitInfo){
        if(unitInfo==null){
            return;
        }
        bind.area.setMidTVTxt(unitInfo.getBelongAreaDes());
    }


    public void initAddrinfo(UnitInfo unitInfo){
        if(unitInfo==null){
            return;
        }
        bind.unitaddr.setMidTVTxt(unitInfo.getCompanyAddress());
    }


    public void updateInfo(){
        if(StringUtil.equals(LocalValue.get登录返回信息().getUserRole(), LoginResBean.USER_ROLE_SUPER_ADMIN)){
            bind.itemUnitname.setEdit(true);
            bind.itemNunitshortname.setEdit(true);
            bind.upunit.getRightIV().setImageResource(R.drawable.icon_hv_into);
            bind.unitaddr.getRightIV().setImageResource(R.drawable.icon_hv_into);
            bind.area.getRightIV().setImageResource(R.drawable.icon_hv_into);
            bind.unitcontact.setEdit(true);
            bind.unitphone.setEdit(true);
        }
    }

    FragManager2 fragManager2;

    public void showTip(View.OnClickListener onClickListener){
        DiaLogCenterFrag diaLogCenterFrag = new DiaLogCenterFrag();
        diaLogCenterFrag.setCustomView(LayoutInflater.from(context).inflate(R.layout.frag_myce_unit_bind_tip_leave,null));
        diaLogCenterFrag.setOnClickListener(onClickListener,R.id.close,R.id.sure);
        fragManager2 = FragManager2.getInstance().setStartAnim(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in,R.anim.fade_out).setFinishAnim(R.anim.fade_in,R.anim.fade_out).setHideLast(false);
        fragManager2.start(getActivity(), getFrag().get容器(),diaLogCenterFrag);
    }

    FragManager2 unitexistfragm = null;

    public void showUnitExistTip(String moudle,String name,View.OnClickListener onClickListener){
        DiaLogCenterFrag diaLogCenterFrag = new DiaLogCenterFrag();
        diaLogCenterFrag.setCustomView(LayoutInflater.from(context).inflate(R.layout.frag_myce_unit_bind_tip_exist,null));
        TextView textView = diaLogCenterFrag.getCustomerView().findViewById(R.id.tv_tip_title);
        textView.setText(StringUtil.getStr(name));
        diaLogCenterFrag.setOnClickListener(onClickListener,R.id.close,R.id.sure);
        unitexistfragm = FragManager2.getInstance().setHideLast(false).setStartAnim(R.anim.scale_in,R.anim.scale_out,R.anim.scale_in,R.anim.scale_out).setFinishAnim(R.anim.fade_in,R.anim.fade_out);
        unitexistfragm.start(getActivity(), moudle,diaLogCenterFrag);
    }

    public void unitCheck(final OnFinishListener onFinishListener){
        BaseTextWather baseTextWather = new BaseTextWather(){
            @Override
            public void afterTextChanged(Editable s) {
              if(onFinishListener!=null){
                  if(!NullUtil.isStrEmpty(s.toString())){
                      onFinishListener.onFinish(s.toString());
                  }
              }
            }
        };
        bind.itemNunitshortname.getMidET().addTextChangedListener(baseTextWather);
        bind.itemUnitname.getMidET().addTextChangedListener(baseTextWather);
    }

    public FragManager2 getFragManager2() {
        return fragManager2;
    }

    public FragManager2 getUnitexistfragm() {
        return unitexistfragm;
    }
}
