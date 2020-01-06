package com.siweisoft.heavycenter.module.main.orders.news;

//by summer on 2018-01-17.

import android.os.Bundle;
import android.view.View;

import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.data.DateFormatUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.android.lib.view.pickerview.TimePickerDialog;
import com.android.lib.view.pickerview.data.Type;
import com.android.lib.view.pickerview.listener.OnDateSetListener;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.mana.good.names.NamesRes;
import com.siweisoft.heavycenter.data.netd.mana.good.specs.SpecsRes;
import com.siweisoft.heavycenter.data.netd.order.news.NewOrderRes;
import com.siweisoft.heavycenter.data.netd.order.news.NewsOrderReqBean;
import com.siweisoft.heavycenter.data.netd.order.rule.Rule;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;
import com.siweisoft.heavycenter.module.main.orders.news.rule.RuleFrag;
import com.siweisoft.heavycenter.module.mana.good.lists.NamesFrag;
import com.siweisoft.heavycenter.module.mana.good.specs.SpecsFrag;
import com.siweisoft.heavycenter.module.myce.unit.addr.AddrFrag;
import com.siweisoft.heavycenter.module.myce.unit.list.UnitListDAOpe;
import com.siweisoft.heavycenter.module.myce.unit.list.UnitListFrag;

import java.util.Date;

import butterknife.OnClick;

public class NewOrderFrag  extends AppFrag<NewOrderUIOpe,NewOrderDAOpe>{




    @Override
    public void initNow() {
        super.initNow();
        getDE().getNewsOrderReqBean().setOrderType(NewsOrderReqBean.发货);
    }

    @OnClick({R.id.item_addr,R.id.item_wuliname,R.id.item_wuliguige,R.id.item_unit,R.id.item_starttime,R.id.item_rule,R.id.tv_send,R.id.tv_receipt,R.id.ftv_right2})
    public void onClick(final View v) {
        super.onClick(v);
        Bundle bundle = new Bundle();
        switch (v.getId()){
            case R.id.item_addr:
                bundle.putInt(ValueConstant.FARG_REQ,NewOrderValue.送货地址);
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),new AddrFrag(),bundle);
                break;
            case R.id.item_wuliname:
                bundle.putInt(ValueConstant.FARG_REQ,NewOrderValue.物料名称);
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),new NamesFrag(),bundle);
                break;
            case R.id.item_wuliguige:
                if(getUI().canGugeGo(getDE().getNewsOrderReqBean())){
                    bundle.putInt(ValueConstant.FARG_REQ,NewOrderValue.物料规格);
                    bundle.putInt(ValueConstant.DATA_POSITION2,getDE().getNewsOrderReqBean().getProductId());
                    FragManager2.getInstance().start(getBaseUIAct(), get容器(),new SpecsFrag(),bundle);
                }
                break;
            case R.id.item_unit:
                bundle.putInt(ValueConstant.FARG_REQ,NewOrderValue.收货单位);
                switch (getDE().getNewsOrderReqBean().getOrderType()){
                    case NewsOrderReqBean.发货:
                        FragManager2.getInstance().start(getBaseUIAct(), get容器(),UnitListFrag.getInstance(UnitListDAOpe.历史收货单位),bundle);
                        break;
                    case NewsOrderReqBean.收货:
                        FragManager2.getInstance().start(getBaseUIAct(), get容器(),UnitListFrag.getInstance(UnitListDAOpe.历史发货单位),bundle);
                        break;
                }
                break;
            case R.id.item_starttime:
                TimePickerDialog.Builder builder = new TimePickerDialog.Builder();
                builder.setThemeColor(getResources().getColor(R.color.color_hv_base));
                builder.setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        String s = DateFormatUtil.getdDateStr(DateFormatUtil.YYYY_MM_DD_HH_MM,new Date(millseconds));
                        getDE().getNewsOrderReqBean().setPlanTime(s);
                        getUI().init(getDE().getNewsOrderReqBean());
                    }
                });
                TimePickerDialog timePickerDialog = builder.setType(Type.MONTH_DAY_HOUR_MIN).setTitleStringId("计划开始时间").build();
                timePickerDialog.show(getFragmentManager(),"计划开始时间");

                break;
            case R.id.item_rule:
                bundle.putInt(ValueConstant.FARG_REQ,NewOrderValue.备用签收规则);
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),new RuleFrag(),bundle);
                break;
            case R.id.tv_receipt:
                getUI().onClick(v);
                getDE().getNewsOrderReqBean().setOrderType(NewsOrderReqBean.收货);
                break;
            case R.id.tv_send:
                getUI().onClick(v);
                getDE().getNewsOrderReqBean().setOrderType(NewsOrderReqBean.发货);
                break;
            case R.id.ftv_right2:
                if(getUI().canGo()){
                    getDE().newOrder(getUI().getNewsOrderReqBean(getDE().getNewsOrderReqBean()), new UINetAdapter<NewOrderRes>(this,UINetAdapter.Loading,true) {

                        @Override
                        public void onResult(boolean success, String msg, NewOrderRes o) {
                            super.onResult(success, msg, o);
                            if(success){
                                getArguments().putBoolean(ValueConstant.DATA_DATA,true);
                                getActivity().onBackPressed();
                            }
                        }
                    });
                }
                break;
        }
    }

    @Override
    public void onResult(int res, Bundle bundle) {
        super.onResult(res, bundle);
        if(bundle==null){
            return;
        }
        switch (res){
            case NewOrderValue.物料名称:
                if(bundle.getSerializable(ValueConstant.DATA_DATA2)==null){
                    return;
                }
                NamesRes.ResultsBean data = (NamesRes.ResultsBean) bundle.getSerializable(ValueConstant.DATA_DATA2);
                getDE().getNewsOrderReqBean().setProductName(data.getMaterielName());
                getDE().getNewsOrderReqBean().setProductId(data.getId());
                getDE().getNewsOrderReqBean().setSpecification(null);
                break;
            case NewOrderValue.物料规格:
                if(bundle.getSerializable(ValueConstant.DATA_DATA2)==null){
                    return;
                }
                SpecsRes.ResultsBean data1 = (SpecsRes.ResultsBean) bundle.getSerializable(ValueConstant.DATA_DATA2);
                getDE().getNewsOrderReqBean().setSpecification(data1.getSpecifications());
                break;
            case NewOrderValue.收货单位:
                if(bundle.getSerializable(ValueConstant.DATA_DATA2)==null){
                    return;
                }
                UnitInfo unitInfo = (UnitInfo) bundle.getSerializable(ValueConstant.DATA_DATA2);
                if(NewsOrderReqBean.发货.equals(getDE().getNewsOrderReqBean().getOrderType())){
                    getDE().getNewsOrderReqBean().setDeveliverCompanyId(LocalValue.get登录返回信息().getCompanyId());
                    getDE().getNewsOrderReqBean().setReceiveCompanyId(unitInfo.getTrueComId());
                }else{
                    getDE().getNewsOrderReqBean().setReceiveCompanyId(LocalValue.get登录返回信息().getCompanyId());
                    getDE().getNewsOrderReqBean().setDeveliverCompanyId(unitInfo.getTrueComId());
                }
                getDE().getNewsOrderReqBean().setTempCompanyName(unitInfo.getCompanyName());
                getDE().getNewsOrderReqBean().setTempCompany(unitInfo.getTrueComId());
                getDE().getNewsOrderReqBean().setAddress(unitInfo.getCompanyAddress());
                break;
            case NewOrderValue.备用签收规则:
                if(bundle.getSerializable(ValueConstant.DATA_DATA2)==null){
                    return;
                }
                Rule rule = (Rule) bundle.getSerializable(ValueConstant.DATA_DATA2);
                getDE().getNewsOrderReqBean().setSignRule(rule.getKey());
                getDE().getNewsOrderReqBean().setSignRuleValue(rule.getValue());
                break;
            case NewOrderValue.送货地址:
                if(bundle.getSerializable(ValueConstant.DATA_DATA)==null){
                    return;
                }
                UnitInfo unitInfo1 = (UnitInfo) bundle.getSerializable(ValueConstant.DATA_DATA);
                getDE().getNewsOrderReqBean().setAddress(unitInfo1.getCompanyAddress());
                break;
        }
        getUI().init(getDE().getNewsOrderReqBean());
    }


    public void setUnit(int id){
        getDE().getInfo(id, new UINetAdapter<UnitInfo>(getActivity()) {
            @Override
            public void onResult(boolean success, String msg, UnitInfo unitInfo) {
                super.onResult(success, msg, unitInfo);
                if(success){
                    Bundle bundle = new Bundle();
                    unitInfo.setId(unitInfo.getTrueComId());
                    bundle.putSerializable(ValueConstant.DATA_DATA2,unitInfo);
                    NewOrderFrag.this.onResult(NewOrderValue.收货单位,bundle);
                }
            }
        });
    }

}
