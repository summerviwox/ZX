package com.siweisoft.heavycenter.module.view.store;

//by summer on 2018-01-08.

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.lib.util.ScreenUtil;
import com.android.lib.util.StringUtil;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.module.view.progress.ProgressView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StoreView extends RelativeLayout {

    private TextView minGoodTV;

    private TextView maxGoodTV;

    private TextView minStoreTV;

    private TextView maxStoreTV;

    private TextView currentTV;

    private ProgressView progressView;

    private View minView;

    private View maxView;


    private View currentView;



    public StoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.item_main_store_detail_top,this,true);
        minGoodTV = (TextView) findViewById(R.id.tv_minwuliao);
        maxGoodTV = (TextView) findViewById(R.id.tv_maxwuliao);
        minStoreTV = (TextView) findViewById(R.id.tv_minstore);
        maxStoreTV = (TextView) findViewById(R.id.tv_maxstore);
        currentView = findViewById(R.id.ll_current);
        currentTV = findViewById(R.id.tv_current);
        minView = findViewById(R.id.ll_min);
        maxView = findViewById(R.id.ll_max);
        progressView = findViewById(R.id.progress);

    }

    public void setTxt(float minstore,float mingood,float maxstore,float maxgood,float now){

        maxView.setVisibility(View.VISIBLE);
        minView.setVisibility(View.VISIBLE);
        currentTV.setVisibility(View.VISIBLE);


        minStoreTV.setText("仓库安全:"+StringUtil.getStr( new BigDecimal(minstore).setScale(1, RoundingMode.HALF_UP).toString())+"t");
        minGoodTV.setText("物料安全:"+StringUtil.getStr(  new BigDecimal(mingood).setScale(1, RoundingMode.HALF_UP).toString())+"t");
        maxStoreTV.setText("仓库最大:"+StringUtil.getStr(  new BigDecimal(maxstore).setScale(1, RoundingMode.HALF_UP).toString())+"t");
        maxGoodTV.setText("物料最大:"+StringUtil.getStr(  new BigDecimal(maxgood).setScale(1, RoundingMode.HALF_UP).toString())+"t");
        currentTV.setText("当前:"+StringUtil.getStr(new BigDecimal(now).setScale(1, RoundingMode.HALF_UP).toString())+"t");

        float max = Math.min(maxstore,maxgood);
        float min = Math.max(mingood,minstore);

        ConstraintLayout.LayoutParams p = (ConstraintLayout.LayoutParams) currentView.getLayoutParams();
        p.leftMargin = (int) (getW()*now/max);
        if(now>max/2){
            currentView.setBackgroundResource(R.drawable.icon_hv_main_store_tip_rd);
            p.leftMargin = (int) (p.leftMargin+ScreenUtil.最小DIMEN*14- currentTV.getPaint().measureText(currentTV.getText().toString()));
        }else{
            currentView.setBackgroundResource(R.drawable.icon_hv_main_store_tip_ld);
        }

        currentView.setLayoutParams(p);

        ConstraintLayout.LayoutParams p1 = (ConstraintLayout.LayoutParams) minView.getLayoutParams();
        p1.leftMargin = (int) (getW()*min/max);
        if(min>max/2){
            minView.setBackgroundResource(R.drawable.icon_hv_main_store_rt);
            p1.leftMargin = (int) (p1.leftMargin- Math.max(minGoodTV.getPaint().measureText(minGoodTV.getText().toString()),minStoreTV.getPaint().measureText(minStoreTV.getText().toString())));
        }else{
            minView.setBackgroundResource(R.drawable.icon_hv_main_store_lt);
        }
        minView.setLayoutParams(p1);

        progressView.setValues(Math.min(maxstore,maxgood),Math.max(mingood,minstore),now);

    }

    private int getW(){
        return (int) (ScreenUtil.w-ScreenUtil.最小DIMEN *14);
    }
}
