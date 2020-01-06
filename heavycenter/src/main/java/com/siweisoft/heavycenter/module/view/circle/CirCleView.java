package com.siweisoft.heavycenter.module.view.circle;

//by summer on 2018-01-25.

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.siweisoft.heavycenter.R;

public class CirCleView extends View {

    Paint paint = new Paint();

    public CirCleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray t = context.obtainStyledAttributes(attrs,R.styleable.style_common);
        if(t.getBoolean(R.styleable.style_common_boo_one,false)){
            paint.setStyle(Paint.Style.FILL);
        }else{
            paint.setStyle(Paint.Style.STROKE);
        }
        paint.setColor(t.getColor(R.styleable.style_common_color_one, getResources().getColor(R.color.color_hv_yelll)));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth()/2,getHeight()/2,Math.min(getWidth(),getHeight())/2,paint);
    }
}
