package com.siweisoft.heavycenter.module.view.weight;

//by summer on 2018-01-08.

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.android.lib.util.ColorUtil;
import com.android.lib.util.LogUtil;
import com.android.lib.util.ScreenUtil;
import com.siweisoft.heavycenter.R;

import java.util.ArrayList;

public class WeightView extends View implements View.OnClickListener{

    private int w;

    private int h;

    private double r;

    private double lengh = ScreenUtil.最小DIMEN *15;

    private ArrayList<WeightBean[]> p = new ArrayList<>();
    private ArrayList<WeightBean[]> pp = new ArrayList<>();
    private double num = 120;
    private double e = 360/(num);

    private Paint paint = new Paint();

    private boolean done = false;

    private int size = 0;

    public WeightView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }




    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        w = getWidth();
        h = getHeight();
        r = Math.min(w,h)/2;
        init();
    }

    public void init(){
        if(p.size()>0){
            return;
        }
        setLayerType( LAYER_TYPE_SOFTWARE , null);
       new Thread(new Runnable() {
           @Override
           public void run() {
               for(int i=0;i<num;i++){
                   WeightBean[] beans  = new WeightBean[]{new WeightBean(),new WeightBean()};
                   beans[0].x = -r*Math.sin(Math.toRadians(e*i))+w/2;
                   beans[0].y = r*Math.cos(Math.toRadians(e*i))+h/2;
                   beans[0].color = ColorUtil.getInstance().getGradualColor(getResources().getColor(R.color.color_hv_weightview_start),getResources().getColor(R.color.color_hv_weightview_end),i/num);
                   beans[1].x = -(r-lengh)*Math.sin(Math.toRadians(e*i))+w/2;
                   beans[1].y = (r-lengh)*Math.cos(Math.toRadians(e*i))+h/2;
                   p.add(beans);
                   pp.add(beans);
                   try {
                       Thread.sleep(10);
                   } catch (InterruptedException e1) {
                       e1.printStackTrace();
                   }
                   postInvalidate();
               }
           }
       }).start();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i=0;i<pp.size();i++){
            paint.setColor(pp.get(i)[0].color);
            //paint.setShadowLayer(3,0,0,p.get(i)[0].color);
            canvas.drawLine((float) pp.get(i)[0].x,(float)pp.get(i)[0].y,(float)pp.get(i)[1].x,(float)pp.get(i)[1].y,paint);
        }
    }

    private boolean anim = true;

    public void anim(){
        if(!anim){
            return;
        }
        pp.clear();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<p.size();i++){
                    pp.add(p.get(i));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    postInvalidate();
                    if(i==0){
                        anim = false;
                    }
                    if(i==p.size()-1){
                        anim = true;
                    }
                }
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        anim();
    }
}
