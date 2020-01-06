package com.siweisoft.heavycenter.module.main.orders.news;

//by summer on 2018-01-17.

import android.view.View;

import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.constant.ValueConstant;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.data.netd.order.news.NewsOrderReqBean;
import com.siweisoft.heavycenter.databinding.FragMainOrderNewBinding;

import java.util.ArrayList;

public class NewOrderUIOpe extends BaseUIOpe<FragMainOrderNewBinding>{

    ArrayList<View> views = new ArrayList<>();



    public void initUI() {
        views.add(bind.tvSend);
        views.add(bind.tvReceipt);
        if(StringUtil.equals(getFrag().getArguments().getString(ValueConstant.DATA_TYPE,"S"),"S")){
            bind.tvSend.setSelected(true);
            bind.tvReceipt.setSelected(false);
        }else{
            bind.tvSend.setSelected(false);
            bind.tvReceipt.setSelected(true);
        }

        changeType(true);
    }

    public void changeType(boolean send){
        if(send){
            bind.itemUnit.getLeftTV().setText("收货单位");
        }else {
            bind.itemUnit.getLeftTV().setText("发货单位");
        }
    }

    public void onClick(View v) {
        for(int i=0;i<views.size();i++){
           if(v==views.get(i)){
               views.get(i).setSelected(true);
           }else{
               views.get(i).setSelected(false);
           }
        }

        if(bind.tvSend.isSelected()){
            changeType(true);
        }else{
            changeType(false);
        }
    }

    public NewsOrderReqBean getNewsOrderReqBean(NewsOrderReqBean newsOrderReqBean) {
        newsOrderReqBean.setPlanNumber(Float.parseFloat(bind.itemPlannum.getMidEtTxt().toString()));
        return newsOrderReqBean;
    }

    public void init(NewsOrderReqBean newsOrderReqBean){
        bind.itemWuliname.setMidTVTxt(StringUtil.getStr(newsOrderReqBean.getProductName()));
        bind.itemWuliguige.setMidTVTxt(StringUtil.getStr(newsOrderReqBean.getSpecification()));
        bind.itemUnit.setMidTVTxt(StringUtil.getStr(newsOrderReqBean.getTempCompanyName()));
        bind.itemAddr.setMidTVTxt(StringUtil.getStr(newsOrderReqBean.getAddress()));
        bind.itemStarttime.setMidTVTxt(StringUtil.getStr(newsOrderReqBean.getPlanTime()));
        bind.itemRule.setMidTVTxt(StringUtil.getStr(newsOrderReqBean.getSignRuleValue()));
    }

    public boolean canGugeGo(NewsOrderReqBean newsOrderReqBean){
        if(NullUtil.isStrEmpty(newsOrderReqBean.getProductName())){
            ToastUtil.getInstance().showShort(getActivity(),"请先选择物料名称");
            return false;
        }
        return true;
    }

    public boolean canGo(){
        if(NullUtil.isStrEmpty(bind.itemWuliname.getMidTvTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请选择物料名称");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.itemWuliguige.getMidTvTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请选择物料规格");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.itemUnit.getMidTvTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请选择单位");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.itemPlannum.getMidEtTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请输入计划数量");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.itemStarttime.getMidTvTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请选择计划开始时间");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.itemRule.getMidTvTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请选择备用签收规则");
            return false;
        }
        return true;
    }
}
