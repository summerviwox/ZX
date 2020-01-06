package com.siweisoft.heavycenter.module.view.text;

//by summer on 2018-01-09.

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.siweisoft.heavycenter.R;

@SuppressLint("AppCompatCustomView")
public class BgTextView extends TextView {



    Paint paint = new Paint();

    GradientDrawable showDrawable = new GradientDrawable();

    GradientDrawable hideDrawable = new GradientDrawable();

    public BgTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs){


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.style_common);


        showDrawable.setColor(a.getColor(R.styleable.style_common_color_one,context.getResources().getColor(android.R.color.transparent)));
        showDrawable.setStroke(
                (int)a.getDimension(R.styleable.style_common_stroke,0),
                a.getColor(R.styleable.style_common_color_stroke,
                        a.getColor(R.styleable.style_common_color_one,context.getResources().getColor(android.R.color.transparent))));
        showDrawable.setCornerRadius(a.getDimension(R.styleable.style_common_corner,0));
        if(a.getBoolean(R.styleable.style_common_boo_one,false)){
            hideDrawable.setColor(a.getColor(R.styleable.style_common_color_two,context.getResources().getColor(android.R.color.transparent)));
            hideDrawable.setStroke(
                    (int)a.getDimension(R.styleable.style_common_stroke_two,0),
                    a.getColor(R.styleable.style_common_color_stroke_two,
                            a.getColor(R.styleable.style_common_color_one,context.getResources().getColor(android.R.color.transparent))));
            hideDrawable.setCornerRadius(a.getDimension(R.styleable.style_common_corner_two,0));
        }else{
            hideDrawable = showDrawable;
        }

        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed},hideDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused},hideDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected},hideDrawable);
        stateListDrawable.addState(new int[]{},showDrawable);
        setBackground(stateListDrawable);


        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[] { -android.R.attr.state_pressed},
                        new int[] {android.R.attr.state_pressed},
                        new int[] { -android.R.attr.state_selected},
                        new int[] {android.R.attr.state_selected}},


                new int[]{
                        a.getColor(R.styleable.style_common_color_txt,Color.WHITE),
                        a.getColor(R.styleable.style_common_color_txt_two,Color.GRAY),
                        a.getColor(R.styleable.style_common_color_txt,Color.WHITE),
                        a.getColor(R.styleable.style_common_color_txt_two,Color.GRAY)});
        setTextColor(colorStateList);

    }
}
