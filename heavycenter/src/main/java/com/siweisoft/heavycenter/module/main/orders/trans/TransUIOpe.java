package com.siweisoft.heavycenter.module.main.orders.trans;

//by summer on 2017-12-19.

import android.support.v7.widget.LinearLayoutManager;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.bean.AppViewHolder;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.databinding.FragMainOrderTransBinding;
import com.siweisoft.heavycenter.databinding.ItemMainOrderBeginBinding;

import java.util.List;

public class TransUIOpe extends AppUIOpe<FragMainOrderTransBinding>{





    public void initUI() {
        initRecycle();
    }

    private void initRecycle(){
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
    }

    public void LoadListData(List<String> s){

        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_main_order_begin, BR.item_main_order_begin,s){

            int darkcolor = context.getResources().getColor(R.color.color_item_main_trans_dark);
            int lightcolor = context.getResources().getColor(R.color.color_item_main_trans_light);

            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ItemMainOrderBeginBinding beginBinding = (ItemMainOrderBeginBinding) holder.viewDataBinding;
                beginBinding.getRoot().setSelected(position%2==0?true:false);
            }
        });
//        bind.recycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                switch (newState){
//                    case RecyclerView.SCROLL_STATE_DRAGGING:
//                        for(int i=0;i<recyclerView.getChildCount();i++){
//                            SwipeLayout swipeLayout = (SwipeLayout) recyclerView.getChildAt(i);
//                            swipeLayout.close(true);
//                        }
//                        break;
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//            }
//        });
    }

    public void initRefresh(){
        bind.refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        bind.refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });
    }
}
