package com.siweisoft.heavycenter.module.main.weights.detail;

//by summer on 2017-12-11.

import android.support.v7.widget.LinearLayoutManager;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.jpush.WeightMsg;
import com.siweisoft.heavycenter.databinding.FragMainWeigtsDetailBinding;
import com.siweisoft.heavycenter.databinding.ItemMainWeightDetailBinding;

import java.util.ArrayList;

public class DetailUIOpe extends AppUIOpe<FragMainWeigtsDetailBinding> {


    @Override
    public void initUI() {
        super.initUI();
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
    }


    public void LoadListData(final ArrayList<WeightMsg.MessageBean> s) {
//        if(o==null || o.getResults()==null || o.getResults().size()==0){
//            getFrag().showtoast("暂无数据");
//            return;
//        }
//        getFrag().removeTips();
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_main_weight_detail, BR.item_main_weight_detail, s){
            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ItemMainWeightDetailBinding binding = (ItemMainWeightDetailBinding) holder.viewDataBinding;
//                binding.tvTime.setText(StringUtil.getStr(StransUIOpe.get(position).getMessage().getTime()));
//                binding.tvTxt.setText(StringUtil.getStr(StransUIOpe.get(position).getMessage().getContent()));
                binding.tvTime.setText(s.get(position).getTimeCN());

                StringBuffer sb = new StringBuffer();
                switch (s.get(position).getMessageType()){
                    case "bridge":
                        sb.append(s.get(position).getContent()).append("\n").append("正在称重中...");
                        break;
                    case "weight":
                        sb.append(StringUtil.getStr(s.get(position).getContent()))
                                .append("\n");
                                if(!NullUtil.isStrEmpty(s.get(position).getWarnMessage())){
                                    sb.append(StringUtil.getStr(s.get(position).getWarnMessage()))
                                            .append("\n");
                                }
                        sb.append(StringUtil.getStr(s.get(position).getWeighResult()))
                                .append("\n")
                                .append(StringUtil.getStr(s.get(position).getSuttle()));
                        break;
                }

                switch (s.get(position).getState()){
                    case "s0":

                        break;
                }

                binding.tvTxt.setText(sb.toString());
            }
        });

        bind.recycle.scrollToPosition(bind.recycle.getAdapter().getItemCount()-1);
    }

    public void initTopUI(WeightMsg.MessageBean data){
        if(data==null||data.getOrder()==null){
            return;
        }
        bind.tvOrderandtransno.setText("订单"+StringUtil.getStr(data.getOrder().getOrderNo())+"     运输单:"+StringUtil.getStr(data.getOrder().getYsdNo()));
        bind.tvGoodnameanspes.setText(StringUtil.getStr(data.getOrder().getProductName())+"        "+StringUtil.getStr(data.getOrder().getSpecification()));
        bind.tvFrom.setText(StringUtil.getStr(data.getOrder().getDeveliverCompanyName()));
        bind.tvTo.setText(StringUtil.getStr(data.getOrder().getReceiveCompanyName()));
    }

    public void  notifyDataSetChanged(){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyDataSetChanged();
            bind.recycle.scrollToPosition(bind.recycle.getAdapter().getItemCount()-1);
        }
    }

}
