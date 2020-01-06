package com.siweisoft.heavycenter.module.mana.user.list;

//by summer on 2017-12-14.

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.util.OjectUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.data.DateFormatUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.daimajia.swipe.SwipeLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.unit.user.UnitUserResBean;
import com.siweisoft.heavycenter.databinding.FragManaUserBinding;
import com.siweisoft.heavycenter.databinding.ItemManaUserBinding;
import com.siweisoft.heavycenter.module.view.MySwipeListener;
import com.siweisoft.heavycenter.module.view.center.DiaLogCenterFrag;
import com.tubb.smrv.SwipeHorizontalMenuLayout;
import com.tubb.smrv.SwipeMenuLayout;

import java.util.Date;
import java.util.List;

public class UserUIOpe extends AppUIOpe<FragManaUserBinding> {

    public final static String 解除绑定 = "解除\n绑定";

    public final static String 重新邀请 = "重新\n邀请";

    public final static String 指定新的超管 = "指定新的\n超管";

    private boolean swipe = true;


    public void initRecycle(){
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
    }

    public void LoadListData(final UnitUserResBean o, ViewListener listener) {
        if(o==null || o.getResults()==null || o.getResults().size()==0){
            getFrag().showTips("暂无数据");
            return;
        }
        getFrag().removeTips();
        final List<UnitUserResBean.ResultsBean> data = o.getResults();
        final LoginResBean loginResBean = LocalValue.get登录返回信息();
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_mana_user, BR.item_mana_user, data,listener){
            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                final ItemManaUserBinding binding = (ItemManaUserBinding) holder.viewDataBinding;

                if(data.get(position).getLoginStatus()== UnitUserResBean.ResultsBean.STATUS_ONLINE){
                    binding.tvState.setText(UnitUserResBean.ResultsBean.STATUS_ONLINE_CN);
                    binding.ivHead.setSelected(true);
                }else{
                    binding.tvState.setText(UnitUserResBean.ResultsBean.STATUS_OFFLINE_CN);
                    binding.ivHead.setSelected(false);
                }

                switch (data.get(position).getBindCompanyState()){
                    case LoginResBean.BIND_UNIT_STATE_BINDED:
                        //binding.tvState.setText(LoginResBean.BIND_UNIT_STATE_BINDED_CN);
                        break;
                    case LoginResBean.BIND_UNIT_STATE_CHECK:
                        binding.tvState.setText(LoginResBean.BIND_UNIT_STATE_CHECK_CN);
                        break;
                    case LoginResBean.BIND_UNIT_STATE_REJECT:
                        binding.tvState.setText(LoginResBean.BIND_UNIT_STATE_REJECT_CN);
                        break;
                    case LoginResBean.BIND_UNIT_STATE_UNBIND:
                        binding.tvState.setText(LoginResBean.BIND_UNIT_STATE_UNBIND_CN);
                        break;
                    case LoginResBean.已解绑:
                        binding.tvState.setText(LoginResBean.BIND_UNIT_STATE_已解绑_CN);
                        break;
                        default:
                            break;
                }

                View content = binding.sml.getChildAt(1);
                TextView menu = (TextView) binding.sml.getChildAt(0);

                content.setOnClickListener(this);
                content.setTag(R.id.position,position);
                content.setTag(R.id.data,data.get(position));


                menu.setOnClickListener(this);
                menu.setTag(R.id.position,position);
                menu.setTag(R.id.data,data.get(position));
                menu.setTag(R.id.data1,binding.sml);
                menu.setTag(R.id.type,0);
                if(data.get(position).getBindCompanyTime()!=null){
                    binding.tvDes.setText("由管理员审核于"+ StringUtil.getStr(DateFormatUtil.getdDateStr(DateFormatUtil.YYYY_MM_DD_HH_MM,new Date(data.get(position).getBindCompanyTime()))));
                }

                switch (data.get(position).getBindCompanyState()){
                    case LoginResBean.BIND_UNIT_STATE_BINDED:
                        menu.setText(解除绑定);
                        menu.setBackgroundColor(context.getResources().getColor(R.color.color_hv_red));
                        break;
                    default:
                        menu.setText(重新邀请);
                        menu.setBackgroundColor(context.getResources().getColor(R.color.color_hv_yelll));
                        break;
                }

                if(OjectUtil.equals(loginResBean.getUserRole(),LoginResBean.USER_ROLE_SUPER_ADMIN)&&
                        OjectUtil.equals(data.get(position).getUserId(),loginResBean.getUserId())){
                    menu.setText(指定新的超管);
                    menu.setBackgroundColor(context.getResources().getColor(R.color.color_hv_red));
                    menu.setTag(R.id.type,1);
                }

                if(isSwipe()){
                    binding.sml.setSwipeEnable(true);
                }else{
                    binding.sml.setSwipeEnable(false);
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


    FragManager2 showBindTipM;

    public FragManager2 showBindTip(String name,String moudle, View.OnClickListener onClickListener){
        DiaLogCenterFrag diaLogCenterFrag = new DiaLogCenterFrag();
        View view = LayoutInflater.from(context).inflate(R.layout.frag_mana_superuser,null);
        TextView textView = view.findViewById(R.id.tv_tip1);
        textView.setText("您将指定"+name+"成为新的超级管理员");
        diaLogCenterFrag.setCustomView(view);
        diaLogCenterFrag.setOnClickListener(onClickListener,R.id.tv_y,R.id.tv_n,R.id.iv_close);
        showBindTipM = FragManager2.getInstance();
        showBindTipM.setStartAnim(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in,R.anim.fade_out).setHideLast(false).setFinishAnim(R.anim.fade_in,R.anim.fade_out).start(getActivity(), moudle,diaLogCenterFrag);
        return showBindTipM;
    }


    public void initRefresh(OnRefreshListener refreshListener, OnLoadmoreListener loadmoreListener){
        bind.refresh.setOnRefreshListener(refreshListener);
        bind.refresh.setOnLoadmoreListener(loadmoreListener);
    }

    public FragManager2 getShowBindTipM() {
        return showBindTipM;
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

    public boolean isSwipe() {
        return swipe;
    }

    public void setSwipe(boolean swipe) {
        this.swipe = swipe;
    }
}
