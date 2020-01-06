package com.siweisoft.heavycenter.module.mana.good.lists;

//by summer on 2018-01-17.

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.bean.AppViewHolder;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.data.netd.mana.good.names.NamesRes;
import com.siweisoft.heavycenter.databinding.FragManaGoodNamesBinding;

import java.util.List;

public class NamesUIOpe extends BaseUIOpe<FragManaGoodNamesBinding> {




    public void initUI() {
        initRecycle();
    }

    public void initRecycle(){
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
    }

    public void LoadListData(NamesRes s, final ViewListener listener) {
        if(s==null){
            return ;
        }
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_mana_good_names, BR.item_mana_good_names, s.getResults(),listener){


        });
    }

}
