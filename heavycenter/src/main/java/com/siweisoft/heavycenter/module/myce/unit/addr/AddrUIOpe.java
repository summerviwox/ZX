package com.siweisoft.heavycenter.module.myce.unit.addr;

//by summer on 2017-12-19.

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.base.listener.BaseTextWather;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.constant.ValueConstant;
import com.android.lib.util.LogUtil;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.PoiAddrInfo;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.databinding.FragMyceUnitAddrBinding;
import com.siweisoft.heavycenter.databinding.ItemMyceUnitAddrBinding;

import java.util.List;

public class AddrUIOpe extends AppUIOpe<FragMyceUnitAddrBinding>{


    public void LoadListData(final List<PoiInfo> addrs, final ViewListener listener) {

        bind.recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        for(int i=0;i<addrs.size();i++){
            LogUtil.E(addrs.get(i).address);
        }
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_myce_unit_addr, BR.item_myce_unit_addr, addrs,listener){

            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                ItemMyceUnitAddrBinding binding = (ItemMyceUnitAddrBinding) holder.viewDataBinding;
                binding.getRoot().setTag(com.android.lib.R.id.data, list.get(position));
                binding.getRoot().setTag(com.android.lib.R.id.position, position);
                binding.getRoot().setOnClickListener(this);
                binding.getRoot().setOnLongClickListener(this);
                binding.tvTxt.setText(StringUtil.getStr(addrs.get(position).address));
            }

            @Override
            public void onClick(View v) {
                super.onClick(v);
                selecPos = (int) v.getTag(R.id.position);
                notifyDataSetChanged();
            }
        });

    }

    public boolean canLocal(){
        if(NullUtil.isStrEmpty(bind.tvCity.getText().toString())){
            ToastUtil.getInstance().showShort(getActivity(),"城市信息正在定位中");
            return false;
        }
        return true;
    }


    public void notifyDataSetChanged(){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyDataSetChanged();
        }
    }

    public void initInput(final OnFinishListener onFinishListener){
        bind.search.getEditText().addTextChangedListener(new BaseTextWather(){
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                onFinishListener.onFinish(s.toString());
            }
        });
    }
}
