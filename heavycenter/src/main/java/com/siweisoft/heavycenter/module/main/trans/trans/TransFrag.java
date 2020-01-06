package com.siweisoft.heavycenter.module.main.trans.trans;

//by summer on 2017-12-11.

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.base.interf.view.OnAppItemClickListener;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.fragment.two.FragManager2;
import com.google.zxing.integration.android.IntentIntegrator;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailRes;
import com.siweisoft.heavycenter.data.netd.trans.sign.TransSignRes;
import com.siweisoft.heavycenter.data.netd.trans.trans.TransRes;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.main.trans.detail.TransDetailFrag;
import com.siweisoft.heavycenter.module.upunit.TitleTipFrag;
import com.siweisoft.heavycenter.module.view.scan.ScanAct;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import butterknife.Optional;

public class TransFrag extends AppFrag<TransUIOpe,TransDAOpe> implements ViewListener,OnRefreshListener,OnLoadmoreListener {


    @Override
    public void onFristVisibleDelayInit() {
        getUI().initRefresh(this,this);
        getUI().initRecycle();
        onRefresh(null);
    }

    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:
                final TransDetailRes resultsBean = (TransDetailRes) v.getTag(R.id.data);
                switch (v.getId()){
                    case R.id.bt_sure:
                        getDE().signTrans(resultsBean.getTransportrecordId(), new UINetAdapter<TransSignRes>(getContext()) {
                            @Override
                            public void onResult(boolean success, String msg, TransSignRes o) {
                                super.onResult(success, msg, o);
                                if(success){
                                    resultsBean.setSignStatus(TransDetailRes.SING_STATUS_已确认);
                                    getUI().notifyDataSetChanged(getDE().getTransRes().getResults(),TransFrag.this);
                                }
                            }
                        });
                        break;
                        default:
                            Bundle bundle = new Bundle();
                            bundle.putInt(ValueConstant.DATA_DATA,resultsBean.getTransportrecordId());
                            FragManager2.getInstance().start(getBaseUIAct(), get容器(),new TransDetailFrag(),bundle);
                            break;
                }
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Optional
    @OnClick({R.id.ftv_right2,R.id.search,R.id.view,R.id.ftv_title,R.id.ftv_midicon})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ftv_back:
                ((MainAct)getBaseUIAct()).getUI().switchDrawer();
                break;
            case R.id.ftv_right2:
                getUI().search(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        boolean b = (boolean) o;
                        if(b){
                            getDE().setPageIndex(0);
                            getUI().autoRefresh();
                        }
                    }
                });
                break;
            case R.id.view:
                if(getUI().bind.search.getRoot().getVisibility()==View.VISIBLE){
                    getUI().bind.title.getRightIV2().setSelected(false);
                    getUI().bind.search.getRoot().setVisibility(View.GONE);
                }
                break;
            case R.id.search:
                getUI().refreshSearch();
                break;
            case R.id.ftv_right:
                if(getActivity() instanceof MainAct){
                    new IntentIntegrator(getBaseAct()).setCaptureActivity(ScanAct.class).initiateScan();
                }
                break;
            case R.id.ftv_midicon:
            case R.id.ftv_title:
                TitleTipFrag tipFrag = TitleTipFrag.getInstance(LocalValue.get下级单位列表());
                tipFrag.setOnAppItemsClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        LoginResBean.BranchCompanyListBean data = (LoginResBean.BranchCompanyListBean) view.getTag(R.id.data);
                        getDE().setComid(data.getBranchId());
                        getUI().bind.title.getMidTV().setText(data.getAbbreviationName());
                        getUI().autoRefresh();
                    }
                });
                FragManager2.getInstance().setAnim(false).setHideLast(false).start(getBaseUIAct(),get容器(),tipFrag);
                break;
        }
    }

    @Override
    public void onRefresh(final RefreshLayout refreshlayout) {
        getDE().setPageIndex(NetValue.PAGE_INDEX_START);
        getDE().transs(getUI().getTransReq(getDE().getTransReq(getDE().getPageIndex())), new UINetAdapter<TransRes>(this) {
            @Override
            public void onSuccess(TransRes o) {
                //o= new Test().getTransRes();
                getDE().getTransRes().getResults().clear();
                getDE().getTransRes().getResults().addAll(o==null? new TransRes().getResults():o.getResults());
                getUI().notifyDataSetChanged(getDE().getTransRes().getResults(),TransFrag.this);
            }
        });

    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        getDE().setPageIndex(getDE().getPageIndex()+1);
        getDE().transs(getUI().getTransReq(getDE().getTransReq(getDE().getPageIndex())), new UINetAdapter<TransRes>(this) {
            @Override
            public void onSuccess(TransRes o) {
                //o = new Test().getTransRes();
                getDE().getTransRes().getResults().addAll(o.getResults());
                getUI().notifyDataSetChanged(getDE().getTransRes().getResults(),TransFrag.this);
            }
        });
    }
}
