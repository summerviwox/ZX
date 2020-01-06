package com.siweisoft.heavycenter.module.view.check;

//by summer on 2018-01-08.

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class CheckIV extends ImageView implements View.OnClickListener{

    private boolean check = false;


    public CheckIV(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }
    private void init(Context context, @Nullable AttributeSet attrs){
        setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        check = ! check;
        setSelected(check);
    }
}
