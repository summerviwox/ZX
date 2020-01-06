package com.siweisoft.heavycenter.module.view.drawer;

//by summer on 2017-12-13.

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.android.lib.util.LogUtil;
import com.siweisoft.heavycenter.R;

public class DrawerView extends RelativeLayout {

    private View handView;

    private RecyclerView recyclerView;


    private View topView;

    private float[] f = new float[]{0f,0f};

    private  int  topdis = 0;

    private   int  bottomdis = 0;

    private   int  middis = 0;

    public DrawerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        addView(LayoutInflater.from(getContext()).inflate(R.layout.view_scrollrecycle,null),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        handView = findViewById(R.id.hand);
        topView = findViewById(R.id.top);
        recyclerView= (RecyclerView) findViewById(R.id.scrollrecycle);
        //initListener();
    }


//    private void initListener() {
//        handView.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        f[1] = event.getY();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        LogUtil.E(event.getX()+":"+event.getY());
//                        f[0]= event.getY();
//                        deal(f[0]);
//                        f[1] = event.getY();
//                        break;
//                    case MotionEvent.ACTION_CANCEL:
//                    case MotionEvent.ACTION_UP:
//                        break;
//                }
//
//                return true;
//            }
//        });
//    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                topdis = getHeight()/3;
                bottomdis = getHeight()*2/3;
                middis = getHeight()/2;
                f[1] = event.getY();
                if(f[1]>handView.getTop()&&f[1]<handView.getBottom()){
                    return true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                f[0]= event.getY()-f[1];
                deal(f[0]);
                f[1] = event.getY();
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                if(handView.getTop()<=topdis){
                    createAnimatorTranslationY(topView,handView.getTop(),0);
                }else
                if(handView.getTop()>=bottomdis){
                    createAnimatorTranslationY(topView,handView.getTop(),getHeight()-handView.getHeight()-100);
                }else
                {
                    createAnimatorTranslationY(topView,handView.getTop(),middis);
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private void deal(float dis){
        topView.getLayoutParams().height += dis;
        topView.requestLayout();
    }

    private void deal2(float dis){

        LogUtil.E(dis);
        topView.getLayoutParams().height = (int) dis;
        topView.requestLayout();
    }

    public View getHandView() {
        return handView;
    }

    public void setHandView(View handView) {
        this.handView = handView;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }


    public void createAnimatorTranslationY(final View v, int from ,int end) {

        ValueAnimator valueAnimator = ObjectAnimator.ofInt(from,end);
        valueAnimator.setDuration(250);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int h = (int) animation.getAnimatedValue();
                deal2(h);
            }
        });


    }
}
