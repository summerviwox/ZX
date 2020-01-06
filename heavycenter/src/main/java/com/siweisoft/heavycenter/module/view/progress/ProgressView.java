package com.siweisoft.heavycenter.module.view.progress;

//by summer on 2018-01-03.

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.lib.util.ScreenUtil;
import com.siweisoft.heavycenter.R;

public class ProgressView extends RelativeLayout {

    ProValue proValue = new ProValue();

    View nowV;

    View minV;

    View child;

    float w= ScreenUtil.w;


    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.item_store_progress,this,true);
        child = getChildAt(0);
        nowV = findViewById(R.id.now);
        minV = findViewById(R.id.min);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    public void setValues(float max, float min, float now){
        proValue.max = max;
        proValue.min = min;
        proValue.now = now;

        RelativeLayout.LayoutParams p = (LayoutParams) nowV.getLayoutParams();
        p.width = (int) (w*proValue.now/proValue.max);
        nowV.setLayoutParams(p);


        RelativeLayout.LayoutParams q = (LayoutParams) minV.getLayoutParams();
        q.leftMargin = (int) (w*proValue.min/proValue.max);
        minV.setLayoutParams(q);

        if(now<=min){
            nowV.setBackgroundResource(R.drawable.bg_hv_sharp10_gradient_yell_red);
        }

    }




    public ProValue getProValue() {
        return proValue;
    }
}
