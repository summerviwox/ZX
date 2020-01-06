package com.siweisoft.heavycenter.module.mana.good;

//by summer on 2017-12-14.

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.bean.AppViewHolder;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.mana.good.list.GoodListRes;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoreDetail;
import com.siweisoft.heavycenter.databinding.FragManaGoodBinding;
import com.siweisoft.heavycenter.databinding.ItemManaGoodBinding;
import com.tubb.smrv.SwipeHorizontalMenuLayout;
import com.tubb.smrv.SwipeMenuLayout;

import java.util.List;

public class GoodUIOpe extends AppUIOpe<FragManaGoodBinding> {



    public void initRecycle(){
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
    }

    public void LoadListData(final GoodListRes o, final ViewListener listener) {
        if(o==null || o.getResults()==null || o.getResults().size()==0){
            getFrag().showTips("暂无数据");
            return;
        }
        getFrag().removeTips();
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_mana_good, BR.item_mana_good, o.getResults(),listener){
            @Override
            public void onBindViewHolder(AppViewHolder holder, int position, List<Object> payloads) {
                super.onBindViewHolder(holder, position, payloads);
                final ItemManaGoodBinding binding = (ItemManaGoodBinding) holder.viewDataBinding;

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
                    case GoodListRes.ResultsBean.停用:
                        menu.setText(GoodListRes.ResultsBean.启用CN);
                        menu.setBackgroundColor(context.getResources().getColor(R.color.color_hv_red));
                        content.setSelected(true);
                        break;
                    case GoodListRes.ResultsBean.启用:
                        menu.setText(GoodListRes.ResultsBean.停用CN);
                        menu.setBackgroundColor(context.getResources().getColor(R.color.color_hv_yelll));
                        content.setSelected(false);
                        break;
                }


                binding.sml.setSwipeEnable(true);

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

    public void initRefresh(OnRefreshListener refreshListener){
        bind.refresh.setOnRefreshListener(refreshListener);
    }

    public void finishRefresh(){
        bind.refresh.finishRefresh();
    }


    public void autoRefresh(){
        bind.refresh.autoRefresh();
    }

    public void autoRefresh(int delay){
        bind.refresh.autoRefresh(delay);
    }


    public void notifyDataSetChanged(){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyDataSetChanged();
        }
    }


}
