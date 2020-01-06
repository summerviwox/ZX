package com.siweisoft.heavycenter.module.view.input;

//by summer on 2017-12-25.

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.view.ViewCompat;

import com.siweisoft.heavycenter.R;

public class EditLoginAcctItem extends RelativeLayout implements View.OnClickListener,View.OnTouchListener{

    private ImageView leftIV;

    private ImageView rightIV;

    private EditText editText;

    private TextView codeText;

    public EditLoginAcctItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.item_acct_login_edit,this,true);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.style_common);
        leftIV = (ImageView) findViewById(R.id.iv_left);
        leftIV.setImageResource(a.getResourceId(R.styleable.style_common_iv_left,R.drawable.icon_hv_phone));

        rightIV = (ImageView) findViewById(R.id.iv_right);
        if(a.getResourceId(R.styleable.style_common_iv_right,-1)!=-1){
            rightIV.setImageResource(a.getResourceId(R.styleable.style_common_iv_right,-1));
        }else{
            rightIV.setVisibility(View.GONE);
        }
        editText = (EditText) findViewById(R.id.et_txt);
        editText.setHint(a.getString(R.styleable.style_common_txt_mid));
        rightIV.setOnClickListener(this);
        rightIV.setOnTouchListener(this);
        boolean showcode = a.getBoolean(R.styleable.style_common_boo_one,false);
        codeText = (TextView) findViewById(R.id.tv_code);
        if(showcode){
            codeText.setVisibility(View.VISIBLE);
            rightIV.setVisibility(View.GONE);
        }else{
            codeText.setVisibility(View.GONE);
            rightIV.setVisibility(View.VISIBLE);
        }
        if(a.getInt(R.styleable.style_common_txt_maxlenth,-1)!=-1){
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(a.getInt(R.styleable.style_common_txt_maxlenth,-1))});
        }
        switch (a.getInt(R.styleable.style_common_inputType,-1)){
            case 0:
                editText.setInputType(InputType.TYPE_CLASS_PHONE|InputType.TYPE_CLASS_NUMBER);
                break;
            case 1:
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD|InputType.TYPE_CLASS_TEXT);
                break;
            case 2:
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD|InputType.TYPE_CLASS_TEXT);
                break;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_right:
                editText.setText("");
                break;
        }
    }

    public String getText(){
        return editText.getText().toString();
    }

    public TextView getCodeText() {
        return codeText;
    }

    public EditText getEditText() {
        return editText;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                ViewCompat.setScaleX(v,0.7f);
                ViewCompat.setScaleY(v,0.7f);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                ViewCompat.setScaleX(v,1f);
                ViewCompat.setScaleY(v,1f);
                break;
        }
        return false;
    }
}
