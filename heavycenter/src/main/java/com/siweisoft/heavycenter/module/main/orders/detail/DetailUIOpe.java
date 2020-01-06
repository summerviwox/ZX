package com.siweisoft.heavycenter.module.main.orders.detail;

//by summer on 2017-12-19.

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.constant.ValueConstant;
import com.android.lib.util.LogUtil;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.data.DateFormatUtil;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersReq;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersRes;
import com.siweisoft.heavycenter.data.netd.order.news.NewsOrderReqBean;
import com.siweisoft.heavycenter.databinding.FragMainOrderDetailBinding;
import com.siweisoft.heavycenter.databinding.ItemMainOrderDetailBeginBinding;
import com.siweisoft.heavycenter.databinding.ItemMainOrderDetailDoingBinding;
import com.siweisoft.heavycenter.databinding.ItemMainOrderDetailDoneBinding;
import com.siweisoft.heavycenter.databinding.ItemMainOrderDetailDriverBinding;
import com.tubb.smrv.SwipeHorizontalMenuLayout;
import com.tubb.smrv.SwipeMenuLayout;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;

public class DetailUIOpe extends AppUIOpe<FragMainOrderDetailBinding>{



    public void initUI() {
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));

    }

    public void initUI(String type, OrdersRes.ResultsBean res){
        final String comname = LocalValue.get登录返回信息().getAbbreviationName();

        switch (type){
            case OrdersReq.新订单:
                bind.itemStarttime.setVisibility(View.GONE);
                bind.itemEndtime.setVisibility(View.GONE);
                ItemMainOrderDetailBeginBinding beginBinding =  ItemMainOrderDetailBeginBinding.inflate(LayoutInflater.from(context));
                bind.rlTopcontainer.addView(beginBinding.getRoot(),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                beginBinding.setVariable(BR.item_main_order_detail_begin,res);
                break;
            case OrdersReq.进行中订单:
                bind.itemEndtime.setVisibility(View.GONE);
                ItemMainOrderDetailDoingBinding doingBinding =  ItemMainOrderDetailDoingBinding.inflate(LayoutInflater.from(context));
                bind.rlTopcontainer.addView(doingBinding.getRoot(),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                doingBinding.setVariable(BR.item_main_order_detail_doing,res);

                int progress = (int) (100*res.getActualSh()/res.getPlanNumber());
                if(progress<0){
                    progress = 0 ;
                }
                if(progress>=50){
                    doingBinding.circlebar.setCircleColor(context.getResources().getColor(R.color.color_hv_blue));
                }else{
                    doingBinding.circlebar.setCircleColor(context.getResources().getColor(R.color.color_hv_yelll));
                }
                doingBinding.circlebar.update(progress,false);
                doingBinding.tvCarno.setOnClickListener(getFrag());
                break;
            case OrdersReq.已完成订单:
                ItemMainOrderDetailDoneBinding doneBinding = ItemMainOrderDetailDoneBinding.inflate(LayoutInflater.from(context));
                bind.rlTopcontainer.addView(doneBinding.getRoot(),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                bind.recycle.setVisibility(View.GONE);
                bind.itemTip.setVisibility(View.GONE);
                bind.ivLocal.setVisibility(View.GONE);
                doneBinding.setVariable(BR.item_main_order_detail_done,res);
                doneBinding.tvTotalcarnum.setOnClickListener(getFrag());
                break;
        }
        if(res==null){
            return;
        }
        bind.setVariable(BR.frag_main_order_detail,res);
    }

    public void initdata(List<CarsResBean.CarInfoRes> list, ViewListener listener ){
        if(bind.recycle.getVisibility()==View.GONE){
            return;
        }
        bind.recycle.setAdapter(new AppsDataBindingAdapter(getActivity(),R.layout.item_main_order_detail_driver,BR.item_main_order_detail_driver,list,listener){
            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                final ItemMainOrderDetailDriverBinding binding = (ItemMainOrderDetailDriverBinding) holder.viewDataBinding;

                View content = binding.sml.getChildAt(1);
                TextView menu = (TextView) binding.sml.getChildAt(0);

                setTag(menu,position);
                menu.setTag(R.id.data1,binding.sml);

                setTag(content,position);

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


}
