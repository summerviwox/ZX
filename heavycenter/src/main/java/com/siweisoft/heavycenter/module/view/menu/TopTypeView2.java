package com.siweisoft.heavycenter.module.view.menu;

//by summer on 2017-12-19.

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.siweisoft.heavycenter.R;

public class TopTypeView2 extends RelativeLayout {



    public TopTypeView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.item_main_order_top,this,true);
    }

}
