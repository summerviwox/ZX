package com.siweisoft.heavycenter.module.main.store;

//by summer on 2017-12-11.

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.util.StringUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoresResBean;
import com.siweisoft.heavycenter.databinding.FragMainStoreBinding;
import com.siweisoft.heavycenter.databinding.ItemMainStoreBinding;
import com.siweisoft.heavycenter.tools.ZXTools;

import java.util.List;

public class StoreUIOpe extends BaseUIOpe<FragMainStoreBinding>{

    @Override
    public void initUI() {
        super.initUI();
        final List<LoginResBean.BranchCompanyListBean> coms = LocalValue.get登录返回信息().getBranchCompanyList();
        if(coms!=null&&coms.size()>0){
            bind.title.getMidTV().setText(StringUtil.getStr(coms.get(0).getAbbreviationName()));
            bind.title.getMidIconIV().setImageResource(R.drawable.arrow_down);
            bind.title.getMidIconIV().setVisibility(View.VISIBLE);
        }
    }

    public void initRefresh(OnRefreshListener refreshListener, OnLoadmoreListener loadmoreListener){
        bind.refresh.setOnRefreshListener(refreshListener);
        bind.refresh.setOnLoadmoreListener(loadmoreListener);
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


    public void autoRefresh(int delay){
        bind.refresh.autoRefresh(delay);
    }



    public void notifyDataSetChanged(final StoresResBean o, ViewListener listener){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyDataSetChanged();
        }else{
            LoadListData(o,listener);
        }
    }

    public void initRecycle(){
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
    }

    public void LoadListData(final StoresResBean o, ViewListener listener) {
        if(o==null || o.getResults()==null || o.getResults().size()==0){
            getFrag().showTips("暂无数据");
            return;
        }
        getFrag().removeTips();
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_main_store, BR.item_main_store, o.getResults(),listener){

            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ItemMainStoreBinding storeBinding = (ItemMainStoreBinding) holder.viewDataBinding;
                storeBinding.getRoot().setSelected(position%2==0?true:false);
                storeBinding.tvCurrent.setText("剩余:"+StringUtil.getStr(o.getResults().get(position).getCurrentStock())+"t");
                storeBinding.pvProgress.setValues(ZXTools.get仓库最小最大当前(o.getResults().get(position),1),
                        ZXTools.get仓库最小最大当前(o.getResults().get(position),0),
                        ZXTools.get仓库最小最大当前(o.getResults().get(position),2)
                        );

            }
        });
    }
}
