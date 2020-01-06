package com.siweisoft.heavycenter.module.main.msg.msg;

//by summer on 2017-12-11.

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
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
import com.siweisoft.heavycenter.data.netd.msg.list.MsgsResBean;
import com.siweisoft.heavycenter.databinding.FragMainMsgsMsgBinding;
import com.siweisoft.heavycenter.databinding.ItemMainMsgAllBinding;

public class MsgUIOpe extends BaseUIOpe<FragMainMsgsMsgBinding>{



    public void initUI() {
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
    }

    public void LoadListData(final MsgsResBean o, ViewListener listener){
        if(o==null || o.getResults()==null || o.getResults().size()==0){
            getFrag().showTips("暂无数据");
            return;
        }
        getFrag().removeTips();
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_main_msg_all, BR.item_main_msg_all,o.getResults(),listener){
            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                if(o.getResults()==null || o.getResults().size()==0){
                    return;
                }
                ItemMainMsgAllBinding binding = (ItemMainMsgAllBinding) holder.viewDataBinding;
                binding.tvDes.setVisibility(View.GONE);
                binding.tvDate.setText(StringUtil.getStr(o.getResults().get(position).getSendTimeDes()));
                switch (o.getResults().get(position).getAuditState()){
                    case MsgsResBean.ResultsBean.AUDITOR_STATE_CHECKING:
                        binding.llFuction.setVisibility(View.VISIBLE);
                        switch (o.getResults().get(position).getMessageType()){
                            case MsgsResBean.ResultsBean.用户申请:
                                binding.btMana.setVisibility(View.VISIBLE);
                                binding.btMana.setOnClickListener(this);
                                binding.btReject.setOnClickListener(this);
                                binding.btAgree.setOnClickListener(this);

                                binding.btMana.setTag(R.id.data,o.getResults().get(position));
                                binding.btReject.setTag(R.id.data,o.getResults().get(position));
                                binding.btAgree.setTag(R.id.data,o.getResults().get(position));

                                binding.btMana.setTag(R.id.data1,binding.llFuction);
                                binding.btReject.setTag(R.id.data1,binding.llFuction);
                                binding.btAgree.setTag(R.id.data1,binding.llFuction);

                                binding.btMana.setTag(R.id.position,position);
                                binding.btReject.setTag(R.id.position,position);
                                binding.btAgree.setTag(R.id.position,position);
                                break;
                            default:
                                binding.btMana.setOnClickListener(this);
                                binding.btReject.setOnClickListener(this);
                                binding.btAgree.setOnClickListener(this);

                                binding.btMana.setTag(R.id.data,o.getResults().get(position));
                                binding.btReject.setTag(R.id.data,o.getResults().get(position));
                                binding.btAgree.setTag(R.id.data,o.getResults().get(position));

                                binding.btMana.setTag(R.id.data1,binding.llFuction);
                                binding.btReject.setTag(R.id.data1,binding.llFuction);
                                binding.btAgree.setTag(R.id.data1,binding.llFuction);

                                binding.btMana.setTag(R.id.position,position);
                                binding.btReject.setTag(R.id.position,position);
                                binding.btAgree.setTag(R.id.position,position);
                                break;
                        }
                        break;
                    case MsgsResBean.ResultsBean.AUDITOR_STATE_AGREEED:
                        binding.llFuction.setVisibility(View.GONE);
                        binding.tvDes.setVisibility(View.VISIBLE);
                        binding.tvDes.setText(MsgsResBean.ResultsBean.AUDITOR_STATE_AGREEED_CN);
                        break;
                    case MsgsResBean.ResultsBean.AUDITOR_STATE_REJECT:
                        binding.llFuction.setVisibility(View.GONE);
                        binding.tvDes.setVisibility(View.VISIBLE);
                        binding.tvDes.setText(MsgsResBean.ResultsBean.AUDITOR_STATE_REJECT_CN);
                        break;
                    case MsgsResBean.ResultsBean.AUDITOR_STATE_NONEED:
                        binding.llFuction.setVisibility(View.GONE);
                        break;
                        default:
                            binding.llFuction.setVisibility(View.GONE);
                            break;

                }

            }
        });
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

    public void notifyDataSetChanged(final MsgsResBean o, ViewListener listener){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyDataSetChanged();
        }else{
            LoadListData(o,listener);
        }
    }

    public void notifyDataSetChanged(int pos){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyItemChanged(pos);
        }
    }

    public void setBtnGone(final View view, final int pos){
        notifyDataSetChanged(pos);
    }

}
