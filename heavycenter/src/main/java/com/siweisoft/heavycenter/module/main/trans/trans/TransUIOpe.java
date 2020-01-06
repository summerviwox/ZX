package com.siweisoft.heavycenter.module.main.trans.trans;

//by summer on 2017-12-11.

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.view.*;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.util.StringUtil;
import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailRes;
import com.siweisoft.heavycenter.data.netd.trans.trans.TransReq;
import com.siweisoft.heavycenter.databinding.FragMainTransBinding;

import java.text.DecimalFormat;
import java.util.List;

public class TransUIOpe extends BaseUIOpe<FragMainTransBinding>{


    @Override
    public void initUI() {
        super.initUI();
        initRecycle();
        final List<LoginResBean.BranchCompanyListBean> coms = LocalValue.get登录返回信息().getBranchCompanyList();
        if(coms!=null&&coms.size()>0){
            bind.title.getMidTV().setText(StringUtil.getStr(coms.get(0).getAbbreviationName()));
            bind.title.getMidIconIV().setImageResource(R.drawable.arrow_down);
            bind.title.getMidIconIV().setVisibility(View.VISIBLE);
        }
    }



    public void initRecycle(){
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
    }

    public void LoadListData(final List<TransDetailRes> s, final ViewListener listener) {

        if(s==null || s.size()==0){
            getFrag().showTips("暂无数据");
            return;
        }
        getFrag().removeTips();

        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_main_trans2, BR.item_main_trans2, s,listener){

            public static final int 驾驶员 = 1;

            public static final int 发货单位 = 2;

            public static final int 收货单位 = 3;

            @Override
            public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                switch (viewType){
                    case 驾驶员:
                        return new AppViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_main_trans_driver, parent, false));
                    case 发货单位:
                        return new AppViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_main_trans_send, parent, false));
                    default:
                        return new AppViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_main_trans_receipt, parent, false));
                }
            }

            @Override
            public int getItemViewType(int position) {
                if(LocalValue.get登录返回信息().is驾驶员()){
                    return 驾驶员;
                }else{
                    if(s.get(position).isIDiliverCom()){
                        return 发货单位;
                    }
                  return 收货单位;
                }
            }


            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                ViewDataBinding viewDataBinding = holder.viewDataBinding;
                setTag(viewDataBinding.getRoot(),position);
                switch (getItemViewType(position)){
                    case 驾驶员:
                        viewDataBinding.setVariable(BR.item_main_trans_driver, list.get(position));
                        break;
                    case 发货单位:
                        viewDataBinding.setVariable(BR.item_main_trans_send, list.get(position));
                        default:
                            viewDataBinding.setVariable(BR.item_main_trans_receipt, list.get(position));
                            break;
                }
                viewDataBinding.executePendingBindings();//加一行，问题解决
                holder.viewDataBinding.getRoot().setSelected(position%2==0?true:false);
            }

        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void search(OnFinishListener onFinishListener){
        if(bind.title.getRightIV2().isSelected()){
            bind.title.getRightIV2().setSelected(false);
            ViewAnimator.animate(bind.search.llSearch).duration(150).translationY(0,-1).onStop(new AnimationListener.Stop(){
                @Override
                public void onStop() {
                    bind.search.getRoot().setVisibility(View.GONE);
                    onFinishListener.onFinish(true);
                }
            }).start();
        }else{
            bind.title.getRightIV2().setSelected(true);
            bind.search.getRoot().setVisibility(View.VISIBLE);
            ViewAnimator.animate(bind.search.llSearch).duration(150).translationY(-1,0).start();
            onFinishListener.onFinish(false);
        }

    }

    public void initRefresh(OnRefreshListener onRefreshListener,OnLoadmoreListener onLoadmoreListener){
        bind.refresh.setOnRefreshListener(onRefreshListener);
        bind.refresh.setOnLoadmoreListener(onLoadmoreListener);
    }

    public void finishRefresh(){
        bind.refresh.finishRefresh();
    }

    public void finishLoadmore(){
        bind.refresh.finishLoadmore();
    }

    public void autoRefresh(){
        bind.refresh.autoRefresh();
    }

    public void autoRefreshNoSearch(){
        clearSel();
        bind.refresh.autoRefresh();
    }

    public void notifyDataSetChanged(final List<TransDetailRes> s, final ViewListener listener){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyDataSetChanged();
        }else{
            LoadListData(s,listener);
        }
    }



    public void refreshSearch(){
        bind.title.getRightIV2().setSelected(false);
        bind.search.getRoot().setVisibility(View.GONE);
    }


    public TransReq getTransReq(TransReq transReq) {
        transReq.setMateriel(bind.search.itemGood.getMidEtTxt());
        transReq.setCompanyName(bind.search.itemUnitname.getMidEtTxt());
        transReq.setCompanyAddress(bind.search.itemUnitaddr.getMidEtTxt());
        transReq.setCarLicenseNo(bind.search.itemUnitcar.getMidEtTxt());
        return transReq;
    }


    public void  clearSel() {
        bind.search.itemGood.getMidET().setText("");
        bind.search.itemUnitname.getMidET().setText("");
        bind.search.itemUnitaddr.getMidET().setText("");
        bind.search.itemUnitcar.getMidET().setText("");
    }

    public void setUnit(String unitname){
        bind.search.itemUnitname.getMidET().setText(StringUtil.getStr(unitname));
    }

}
