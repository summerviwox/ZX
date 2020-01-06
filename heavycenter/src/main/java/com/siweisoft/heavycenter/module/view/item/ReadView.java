package com.siweisoft.heavycenter.module.view.item;

//by summer on 2018-01-10.

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.module.view.check.CheckIV;

public class ReadView extends LinearLayout implements View.OnClickListener{

    private CheckIV checkIV;

    private TextView readTV;

    private TextView agreeTV;

    public ReadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.item_check_read,this,true);
        checkIV = (CheckIV) findViewById(R.id.iv_check);
        readTV = (TextView) findViewById(R.id.tv_read1);
        agreeTV = (TextView) findViewById(R.id.tv_agree1);
        readTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_read1:
                checkIV.setSelected(!checkIV.isSelected());
                break;
        }
    }

    public CheckIV getCheckIV() {
        return checkIV;
    }

    public TextView getReadTV() {
        return readTV;
    }

    public TextView getAgreeTV() {
        return agreeTV;
    }
}
