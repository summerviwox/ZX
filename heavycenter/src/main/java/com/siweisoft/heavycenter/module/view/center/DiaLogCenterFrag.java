package com.siweisoft.heavycenter.module.view.center;

//by summer on 2017-12-18.

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.util.fragment.FragManager;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.module.acct.acct.AcctAct;

import butterknife.OnClick;
import butterknife.Optional;

public class DiaLogCenterFrag extends BaseUIFrag<DialogCenterUIOpe,DialogCenterDAOpe> {


    View.OnClickListener onClickListener;

    View customerView;


    int[] views ;

    FragManager2 fragManager2;

    int viewlayout;

    ViewGroup container;



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        container =view.findViewById(R.id.rl_center);
        if(customerView!=null){
        container.addView(customerView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        }
        if(viewlayout!=0){
            LayoutInflater.from(getContext()).inflate(viewlayout, (ViewGroup) view,true);
        }
        if(views!=null){
            for(int i=0;i<views.length;i++){
                View view1 = getView().findViewById(views[i]);
                view1.setOnClickListener(this);
            }
        }

    }

    public void close(){

    }

    public void setCustomView(View v){
        customerView = v;

    }

    public View getCustomerView() {
        return customerView;
    }

    public void setCustomerView(View customerView) {
        this.customerView = customerView;
    }

    public void onClick(View v) {
        if(onClickListener!=null){
            onClickListener.onClick(v);
        }
        close();
    }



    public void setOnClickListener(View.OnClickListener onClickListener,int... views) {
        this.onClickListener = onClickListener;
        this.views = views;
    }

    public void setViewlayout(int viewlayout) {
        this.viewlayout = viewlayout;
    }
}
