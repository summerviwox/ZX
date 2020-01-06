package com.siweisoft.heavycenter.module.view.menu;

//by summer on 2018-01-02.

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.siweisoft.heavycenter.R;

public class ScrollMenu extends RelativeLayout {


    private View line ;

    private float aaa = 3/4f;

    private float bbb = 1-aaa;


    private int num=3;

    private ViewPager viewPager;

    public ScrollMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.item_main_msg_top_scroll,this,true);
    }



    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        num = viewPager.getAdapter().getCount();
        if(line==null){
            line = findViewById(R.id.line);
            line.getLayoutParams().width = (int) ((aaa)*getWidth()/num);
            line.requestLayout();
        }
        final float trans1 =  (getWidth()/num);
        final float trnas2 = (trans1*((1-aaa)/2));
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ViewCompat.setTranslationX(line,trans1*(position+positionOffset)+trnas2);
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
