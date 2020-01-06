package com.siweisoft.heavycenter.module.view.circle;

//by summer on 2017-12-29.

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.android.lib.util.ScreenUtil;

public class UpCircleView extends View {


    Paint paint = new Paint();

    private static int up = 1;

    public UpCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs){
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
        canvas.drawCircle(getWidth()/2,0,getWidth()/2,paint);
    }
}
