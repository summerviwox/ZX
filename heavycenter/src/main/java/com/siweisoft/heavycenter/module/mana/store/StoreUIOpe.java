package com.siweisoft.heavycenter.module.mana.store;

//by summer on 2017-12-14.

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.network.news.NetI;
import com.android.lib.util.StringUtil;
import com.daimajia.swipe.SwipeLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoreDetail;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoresResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.status.StatusStoresReqBean;
import com.siweisoft.heavycenter.data.netd.mana.store.status.StatusStoresResBean;
import com.siweisoft.heavycenter.databinding.FragManaStoreBinding;
import com.siweisoft.heavycenter.databinding.ItemManaGoodBinding;
import com.siweisoft.heavycenter.databinding.ItemManaStoreBinding;
import com.siweisoft.heavycenter.module.view.MySwipeListener;
import com.tubb.smrv.SwipeHorizontalMenuLayout;
import com.tubb.smrv.SwipeMenuLayout;

import java.util.List;

public class StoreUIOpe extends AppUIOpe<FragManaStoreBinding> {

    private boolean swipe = true;


    public void initRecycle(){
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
    }

    public void LoadListData(final StoresResBean o, final ViewListener listener) {
        if(o==null || o.getResults()==null || o.getResults().size()==0){
            getFrag().showTips("暂无数据");
            return;
        }
        getFrag().removeTips();
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_mana_store, BR.item_mana_store, o.getResults(),listener){
            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                final ItemManaStoreBinding binding = (ItemManaStoreBinding) holder.viewDataBinding;
                binding.tvMaxstock.setText("最大库存:"+ StringUtil.getStr(o.getResults().get(position).getMaxStock())+"t");
                binding.tvMinstock.setText("安全库存:"+ StringUtil.getStr(o.getResults().get(position).getMinStock())+"t");

                //TextView textView = binding.


                View content = binding.sml.getChildAt(1);
                TextView menu = (TextView) binding.sml.getChildAt(0);

                content.setOnClickListener(this);
                content.setTag(R.id.position,position);
                content.setTag(R.id.data,list.get(position));


                menu.setOnClickListener(this);
                menu.setTag(R.id.position,position);
                menu.setTag(R.id.data,list.get(position));
                menu.setTag(R.id.data1,binding.sml);
                menu.setTag(R.id.type,0);



                switch (o.getResults().get(position).getStatus()){
                    case StoreDetail.STATUS_OFF:
                        menu.setText(StoreDetail.STATUS_ON_CN);
                        menu.setBackgroundColor(context.getResources().getColor(R.color.color_hv_red));
                        content.setSelected(true);
                        break;
                    default:
                        menu.setText(StoreDetail.STATUS_OFF_CN);
                        menu.setBackgroundColor(context.getResources().getColor(R.color.color_hv_yelll));
                        content.setSelected(false);
                        break;
                }





                binding.sml.setSwipeListener(new com.siweisoft.heavycenter.module.view.swipe.MySwipeListener(){
                    @Override
                    public void endMenuOpened(SwipeMenuLayout swipeMenuLayout) {
                        for(int i=0;i<bind.recycle.getChildCount();i++){
                            SwipeHorizontalMenuLayout swipeLayout= (SwipeHorizontalMenuLayout) bind.recycle.getChildAt(i);
                            if(swipeLayout!=binding.sml){
                                swipeLayout.smoothCloseMenu(400);
                            }
                        }
                    }
                });

            }


            @Override
            public void onClick(View v) {
                super.onClick(v);

                switch (v.getId()){
                    case R.id.smMenuViewRight:
                        SwipeHorizontalMenuLayout swipeLayout= (SwipeHorizontalMenuLayout) v.getTag(R.id.data1);
                        swipeLayout.smoothCloseMenu(400);
                        break;
                }
            }
        });


        bind.recycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState){
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        for(int i=0;i<recyclerView.getChildCount();i++){
                            SwipeHorizontalMenuLayout swipeLayout= (SwipeHorizontalMenuLayout) recyclerView.getChildAt(i);
                            swipeLayout.smoothCloseMenu(400);
                        }
                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
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


    public void statusStore(StatusStoresReqBean statusStoresReqBean){

    }


    public void notifyDataSetChanged(){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyDataSetChanged();
        }
    }

    public StatusStoresReqBean getStatusStoresReqBean(StatusStoresReqBean reqBean,int storeid, int  status) {
        reqBean.setId(storeid);
        switch (status){
            case StoreDetail.STATUS_OFF:
                status = StoreDetail.STATUS_ON;
                break;
            case StoreDetail.STATUS_ON:
                status = StoreDetail.STATUS_OFF;
                break;
        }
        reqBean.setStatus(status);
        return reqBean;
    }


    public boolean isSwipe() {
        return swipe;
    }

    public void setSwipe(boolean swipe) {
        this.swipe = swipe;
    }
}
