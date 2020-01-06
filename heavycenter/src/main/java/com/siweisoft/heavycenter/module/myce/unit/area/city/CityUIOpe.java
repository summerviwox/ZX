package com.siweisoft.heavycenter.module.myce.unit.area.city;

//by summer on 2017-12-19.

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.constant.ValueConstant;
import com.android.lib.util.NullUtil;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.other.city.CityResBean;
import com.siweisoft.heavycenter.databinding.FragMyceUnitNewCityBinding;
import com.siweisoft.heavycenter.databinding.ItemMyceUnitNewCityBinding;

import java.util.ArrayList;
import java.util.List;

public class CityUIOpe extends AppUIOpe<FragMyceUnitNewCityBinding>{

    @Override
    public void initUI() {
        super.initUI();
        bind.title.getMidTV().setText(getFrag().getArguments().getString(ValueConstant.DATA_TYPE,"选择城市"));
    }


    public void initRecycle(){
        bind.recycle.setLayoutManager(new GridLayoutManager(context,3));
    }

    public void LoadListData(final List<CityResBean.ProvinceListBean.CityListBean> data, final ViewListener listener) {
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_myce_unit_new_city, BR.item_myce_unit_new_city, data,listener){


            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ItemMyceUnitNewCityBinding binding = (ItemMyceUnitNewCityBinding) holder.viewDataBinding;
                binding.typeimage.setType(data.get(position).getCheckStatus());
            }
        });
    }

    public void notifyDataSetChanged(){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyDataSetChanged();
        }
    }

}
