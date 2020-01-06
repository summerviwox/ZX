package com.siweisoft.heavycenter.module.view.item;

//by summer on 2017-12-25.

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.siweisoft.heavycenter.R;

public class NewUnitMyceItem extends RelativeLayout {

    private TextView leftTV;

    private ImageView rightIV;


    private float leftW = 0;


    private boolean edit = false;

    private ViewGroup container;

    private TextView midTV;

    private String txt_mid;



    public NewUnitMyceItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.item_myce_unit_new,this,true);
        leftTV = (TextView) findViewById(R.id.tv_left);
        rightIV = (ImageView) findViewById(R.id.iv_right);
        container = findViewById(R.id.txtcontainer);

        TypedArray a  =context.obtainStyledAttributes(attrs,R.styleable.style_common);
        String leftStr = a.getString(R.styleable.style_common_txt_left);
        if(leftStr!=null){
            leftTV.setText(leftStr);
        }
        int rightivres = a.getResourceId(R.styleable.style_common_iv_right,0);
        if(rightivres!=0){
            rightIV.setImageResource(rightivres);
            rightIV.setVisibility(View.VISIBLE);
        }else{
            rightIV.setVisibility(View.GONE);
        }
        leftW = a.getDimension(R.styleable.style_common_minwidth,0);
        leftTV.setMinWidth((int) leftW);
        edit = a.getBoolean(R.styleable.style_common_boo_edit,false);

       if(edit){
           midTV= (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_myce_unit_new_edit,null);
           container.addView(midTV,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
       }else{
           midTV= (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_myce_unit_new_txt,null);
           container.addView(midTV,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
       }

        String hint = a.getString(R.styleable.style_common_txt_hint);
        txt_mid = a.getString(R.styleable.style_common_txt_mid)==null?txt_mid:a.getString(R.styleable.style_common_txt_mid);


        midTV.setHint(StringUtil.getStr(hint));
        if(!NullUtil.isStrEmpty(txt_mid)){
            midTV.setText(txt_mid);
        }

        switch (a.getInt(R.styleable.style_common_inputType,-1)){
            case 0:
                midTV.setInputType(InputType.TYPE_CLASS_PHONE|InputType.TYPE_CLASS_NUMBER);
                break;
            case 1:
                midTV.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD|InputType.TYPE_CLASS_TEXT);
                break;
            case 2:
                midTV.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD|InputType.TYPE_CLASS_TEXT);
                break;
            case 3:
                midTV.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL|InputType.TYPE_CLASS_NUMBER);
                //midTV.setKeyListener(DigitsKeyListener.getInstance("0123456789."));
                break;
        }

        if(a.getInt(R.styleable.style_common_txt_maxlenth,-1)!=-1){
            midTV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(a.getInt(R.styleable.style_common_txt_maxlenth,-1))});
        }

    }

    public EditText getMidET() {
        return (EditText) midTV;
    }

    public TextView getMidTV() {
        return midTV;
    }

    public String getMidEtTxt(){
        return midTV.getText().toString();
    }

    public String getMidTvTxt(){
        return midTV.getText().toString();
    }

    public TextView getLeftTV() {
        return leftTV;
    }

    public ImageView getRightIV() {
        return rightIV;
    }

    public void setMidTVTxt(String Str){
        midTV.setText(Str);
    }

    public void setMidTVTxt(String Str,String hint){
        if(NullUtil.isStrEmpty(Str)){
            midTV.setHint(hint);
            midTV.setText("");
        }else{
            midTV.setText(Str);
        }
    }


    public void setMidEtTxt(String Str){
        midTV.setText(Str);
    }


    public String getTxt_mid() {
        return txt_mid;
    }

    public void setTxt_mid(String txt_mid) {
        this.txt_mid = txt_mid;
        midTV.setText(txt_mid);
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
        if(edit){
            container.removeAllViews();
            midTV= (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_myce_unit_new_edit,null);
            container.addView(midTV,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        }else{
            container.removeAllViews();
            midTV= (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_myce_unit_new_txt,null);
            container.addView(midTV,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        }
    }
}
