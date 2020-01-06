package com.siweisoft.heavycenter.module.view.menu;

//by summer on 2017-12-19.

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.lib.util.LogUtil;
import com.siweisoft.heavycenter.R;

import java.util.ArrayList;

public class TopTypeView extends RelativeLayout implements View.OnClickListener{




    private String[] strs;

    private ViewPager viewPager;

    ScrollMenu scrollMenu;

    LinearLayout viewGroup;


    private ArrayList<TextView> textViews = new ArrayList<>();

    public TopTypeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.style_toptypeview);
        String txts = a.getString(R.styleable.style_toptypeview_txts);
        strs = txts.split(",");

        if(true){
            LayoutInflater.from(context).inflate(R.layout.item_main_msg_top,this,true);
            viewGroup = (LinearLayout) findViewById(R.id.ll_root);
            scrollMenu = findViewById(R.id.scrollmenu);
            for(int i=0;i<strs.length;i++){
                TextView t= (TextView) LayoutInflater.from(context).inflate(R.layout.item_main_msg_top_txt,null);
                t.setText(strs[i]);
                viewGroup.addView(t,new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1));
                t.setTag(R.id.position,i);
                t.setOnClickListener(this);
                textViews.add(t);
            }
        }

    }

    public void initTxtView(ArrayList<String> strs){
        viewGroup.removeAllViews();
        textViews.clear();
        for(int i=0;i<strs.size();i++){
            TextView t= (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_main_msg_top_txt,null);
            t.setText(strs.get(i));
            viewGroup.addView(t,new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1));
            t.setTag(R.id.position,i);
            t.setOnClickListener(this);
            textViews.add(t);
        }
    }



    public void setIndex(int index){
        if(index>=strs.length){
            index = strs.length;
        }
    }
    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        final ViewPager.OnPageChangeListener  listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                textViews.get(position).setTextSize(TypedValue.COMPLEX_UNIT_SP,15+5*(1-positionOffset));
//                if((position+1)<textViews.size()){
//                    textViews.get((position+1)).setTextSize(TypedValue.COMPLEX_UNIT_SP,15+5*(positionOffset));
//                }
            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<textViews.size();i++){
                    if(position==i){
                        textViews.get(i).setTextColor(getResources().getColorStateList(R.color.color_hv_yelll));
                        textViews.get(i).setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
                    }else{
                        textViews.get(i).setTextColor(getResources().getColorStateList(R.color.white));
                        textViews.get(i).setTextSize(TypedValue.COMPLEX_UNIT_SP,13);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        this.viewPager.addOnPageChangeListener(listener);
        if(viewPager.getAdapter()!=null&&viewPager.getAdapter().getCount()>0){
            viewPager.post(new Runnable() {
                @Override
                public void run() {
                    listener.onPageSelected(0);
                }
            });
        }
        scrollMenu.setViewPager(viewPager);

    }

    public void setTxt(int index,String str){
        if(index<0 && index>=str.length()){
            return;
        }
        textViews.get(index).setText(str);
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    @Override
    public void onClick(View v) {
        int i= (int) v.getTag(R.id.position);
        if(getViewPager()!=null){
            getViewPager().setCurrentItem(i,true);
        }
    }
}
