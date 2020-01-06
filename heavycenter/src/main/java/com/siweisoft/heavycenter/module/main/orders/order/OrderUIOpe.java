package com.siweisoft.heavycenter.module.main.orders.order;

//by summer on 2017-12-19.

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.bean.AppViewHolder;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersReq;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersRes;
import com.siweisoft.heavycenter.databinding.FragMainOrderBeginBinding;
import com.siweisoft.heavycenter.databinding.ItemMainOrderBeginBinding;
import com.siweisoft.heavycenter.databinding.ItemMainOrderDoingBinding;
import com.siweisoft.heavycenter.databinding.ItemMainOrderDoneBinding;

public class OrderUIOpe extends AppUIOpe<FragMainOrderBeginBinding>{

    public void initUI() {
        initRecycle();
    }

    private void initRecycle(){
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
    }

    public void LoadListData(final String type, final OrdersRes s, ViewListener listener){
        if(s==null || s.getResults()==null || s.getResults().size()==0){
            getFrag().showTips("暂无数据");
            return;
        }
        getFrag().removeTips();
        switch (type){
            case OrdersReq.新订单:
                bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_main_order_begin, BR.item_main_order_begin,s.getResults(),listener){

                    @Override
                    public void onBindViewHolder(AppViewHolder holder, int position) {
                        super.onBindViewHolder(holder, position);
                        ItemMainOrderBeginBinding beginBinding = (ItemMainOrderBeginBinding) holder.viewDataBinding;
                        beginBinding.getRoot().setSelected(position%2==0?true:false);
                        beginBinding.getRoot().setTag(R.id.type,type);

                        setTag(beginBinding.btSure,position);
                        setTag(beginBinding.btReject,position);

                    }
                });
                break;
            case OrdersReq.进行中订单:
                bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_main_order_doing, BR.item_main_order_doing, s.getResults(),listener) {


                    @Override
                    public void onBindViewHolder(AppViewHolder holder, int position) {
                        super.onBindViewHolder(holder,position);
                        ItemMainOrderDoingBinding doingBinding = (ItemMainOrderDoingBinding) holder.viewDataBinding;
                        doingBinding.getRoot().setSelected(position % 2 == 0 ? true : false);
                        doingBinding.getRoot().setTag(R.id.type,type);
                    }
                });
                break;
            case OrdersReq.已完成订单:
                bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_main_order_done, BR.item_main_order_done,s.getResults(),listener){

                    @Override
                    public void onBindViewHolder(AppViewHolder holder, int position) {
                        super.onBindViewHolder(holder,position);
                        ItemMainOrderDoneBinding doneBinding = (ItemMainOrderDoneBinding) holder.viewDataBinding;
                        doneBinding.getRoot().setSelected(position%2==0?true:false);
                        doneBinding.getRoot().setTag(R.id.type,type);

                    }
                });
                break;
        }

    }


    public void initRefresh(OnRefreshListener refreshListener,OnLoadmoreListener loadmoreListener){
        bind.refresh.setOnRefreshListener(refreshListener);
        bind.refresh.setOnLoadmoreListener(loadmoreListener);
    }

    public void finishRefresh(){
        bind.refresh.finishRefresh();
    }

    public void finishLoadmore(){
        bind.refresh.finishLoadmore();
    }

    public void notifyDataSetChanged(final String type, final OrdersRes s, ViewListener listener){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyDataSetChanged();
        }else{
            LoadListData(type,s,listener);
        }
    }


    public void autoRefresh(){
        bind.refresh.autoRefresh();
    }
}
