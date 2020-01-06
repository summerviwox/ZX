package com.siweisoft.heavycenter.module.main.trans.strans;

//by summer on 2018-03-14.

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailRes;
import com.siweisoft.heavycenter.databinding.FragMainStransBinding;

import java.util.List;

public class StransUIOpe extends AppUIOpe<FragMainStransBinding>{

    @Override
    public void initUI() {
        super.initUI();
        if(getFrag() instanceof OnRefreshListener){
            bind.refresh.setOnRefreshListener((OnRefreshListener) getFrag());
        }
        if(getFrag() instanceof OnLoadmoreListener){
            bind.refresh.setOnLoadmoreListener((OnLoadmoreListener) getFrag());
        }
        bind.title.getMidTV().setText(getFrag().getArguments().getString(ValueConstant.DATA_DATA2,"运输单"));
    }


    public void LoadListData(final List<TransDetailRes> s) {

        if(s==null || s.size()==0){
            getFrag().showTips("暂无数据");
            return;
        }
        getFrag().removeTips();

        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_main_strans, BR.item_main_strans, s){

        });
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

    public void autoRefreshNoSearch(){
        bind.refresh.autoRefresh();
    }

    public void notifyDataSetChanged(){
        if(bind.recycle.getAdapter()!=null){
            bind.recycle.getAdapter().notifyDataSetChanged();
        }
    }

}
