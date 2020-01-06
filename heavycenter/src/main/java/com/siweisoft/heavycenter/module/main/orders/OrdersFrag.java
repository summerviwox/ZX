package com.siweisoft.heavycenter.module.main.orders;

//by summer on 2017-12-11.

import android.os.Bundle;
import android.view.View;

import com.android.lib.base.interf.view.OnAppItemClickListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.NetAdapter;
import com.android.lib.util.fragment.two.FragManager2;
import com.google.zxing.integration.android.IntentIntegrator;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.order.ordernum.OrderNumRes;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.main.orders.order.OrderFrag;
import com.siweisoft.heavycenter.module.main.orders.news.NewOrderFrag;
import com.siweisoft.heavycenter.module.upunit.TitleTipFrag;
import com.siweisoft.heavycenter.module.view.scan.ScanAct;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import butterknife.Optional;

public class OrdersFrag extends AppFrag<OrdersUIOpe,OrdersDAOpe> {




    @Override
    public void onFristVisibleDelayInit() {
        getP().getU().initPages(getFrag(),getP().getD().initPages());

    }

    @Optional
    @OnClick({R.id.ftv_right,R.id.ftv_title,R.id.ftv_right2,R.id.ftv_midicon})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ftv_back:
                ((MainAct)getBaseAct()).getP().getU().switchDrawer();
                break;
            case R.id.ftv_midicon:
            case R.id.ftv_title:
                TitleTipFrag tipFrag = TitleTipFrag.getInstance(LocalValue.get下级单位列表());
                tipFrag.setOnAppItemsClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        LoginResBean.BranchCompanyListBean data = (LoginResBean.BranchCompanyListBean) view.getTag(R.id.data);
                        getP().getD().setCompanyid(data.getBranchId());
                        getP().getU().bind.title.getMidTV().setText(data.getAbbreviationName());
                        refreshOrders();
                    }
                });
                FragManager2.getInstance().setAnim(false).setHideLast(false).start(getBaseUIAct(),get容器(),tipFrag);
                break;
            case R.id.ftv_right2:

//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//
//                    SharedElementFragment1 detailFrag = new SharedElementFragment1();
//                    detailFrag.iid = MainValue.订单ID;
//                    getFragmentManager().beginTransaction()
//                            .add(detailFrag.iid,detailFrag)
//                            .addToBackStack(null)
//                            .commit();
//                    return;
//                }


                Bundle bundle = new Bundle();
                bundle.putInt(ValueConstant.FARG_REQ,2);
                bundle.putString(ValueConstant.DATA_TYPE,getP().getD().get较多的订单类型());
                FragManager2.getInstance().start(getBaseUIAct(),get容器(),new NewOrderFrag(),bundle);
                break;
            case R.id.ftv_right:
                if(getActivity() instanceof MainAct){
                    new IntentIntegrator(getBaseAct()).setCaptureActivity(ScanAct.class).initiateScan();
                }
                break;
        }
    }

    @Override
    public void onResult(int res, Bundle bundle) {
        super.onResult(res, bundle);
        switch (res){
            case 2:
                if(bundle==null||!bundle.getBoolean(ValueConstant.DATA_DATA,false)){
                    return;
                }
                getP().getU().setCurrent(0);
                OrderFrag orderFrag = (OrderFrag) getP().getD().getPages().get(0);
                orderFrag.getP().getU().autoRefresh();
                break;
        }
    }

    public void refreshOrders(){
        for(int i=0;i<getP().getD().getPages().size();i++){
            OrderFrag orderFrag = (OrderFrag) getP().getD().getPages().get(i);
            orderFrag.getP().getU().autoRefresh();
        }
    }
}
