package com.siweisoft.heavycenter.module.myce.car.bind;

//by summer on 2017-12-19.

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.base.listener.BaseTextWather;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.util.NullUtil;
import com.android.lib.util.ToastUtil;
import com.daimajia.swipe.SwipeLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsReqBean;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.databinding.FragMyceCarBindBinding;
import com.siweisoft.heavycenter.databinding.ItemManaCarMyBinding;

import java.util.List;

public class BindUIOpe extends AppUIOpe<FragMyceCarBindBinding>{
    CarsResBean cars;


    public void initRecycle(){
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
    }

    public void 实时搜索(final OnFinishListener listener){
        bind.etName.addTextChangedListener(new BaseTextWather(){
            @Override
            public void afterTextChanged(Editable s) {
                listener.onFinish(s.toString());
            }
        });
    }

    public void LoadListData(CarsResBean data,ViewListener listener){
        if(data==null){
            return;
        }
        this.cars = data;
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_mana_car_my, BR.item_mana_car_my,cars.getResults(),listener){
            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ItemManaCarMyBinding binding = (ItemManaCarMyBinding) holder.viewDataBinding;
                binding.sml.setSwipeEnable(false);
            }

        });
    }
    public CarsResBean getCars() {
        return cars;
    }

    public void setCars(CarsResBean cars) {
        this.cars = cars;
    }

    public void notifyDataSetChanged(){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyDataSetChanged();
        }
    }

    public void initRefresh(OnRefreshListener refreshListener){
        bind.refresh.setOnRefreshListener(refreshListener);
    }

    public boolean canSearchGo(){
        if(NullUtil.isStrEmpty(bind.etName.getText().toString())){
            ToastUtil.getInstance().showShort(getActivity(),"车牌号为输入");
            return false;
        }
        if(bind.etName.getText().toString().length()!=7){
            ToastUtil.getInstance().showShort(getActivity(),"车牌号输入有误");
            return false;
        }
        return true;
    }

    public String getInputText(){
        return bind.etName.getText().toString();
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


    public String getKeyWord(){
        return bind.etName.getText().toString();
    }

    public void clearKey(){
        bind.etName.setText("");
    }
}
