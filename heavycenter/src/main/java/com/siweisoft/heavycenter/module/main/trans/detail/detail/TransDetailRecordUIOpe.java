package com.siweisoft.heavycenter.module.main.trans.detail.detail;

//by summer on 2018-02-27.

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.util.data.DateFormatUtil;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailRes;
import com.siweisoft.heavycenter.databinding.FragMainTransDetailDetailBinding;
import com.siweisoft.heavycenter.databinding.ItemMainTransDetailBinding;

import java.util.Date;
import java.util.List;

public class TransDetailRecordUIOpe extends AppUIOpe<FragMainTransDetailDetailBinding>{

    public void initUI(final List<TransDetailRes.DeliverRecordListBean> data){
        if(data==null){
            return;
        }
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_main_trans_detail, BR.item_main_trans_detail,data){
            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                super.onBindViewHolder(holder,position);
            }
        });
    }
}
