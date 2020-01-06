package com.siweisoft.heavycenter.module.view.input;

//by summer on 2017-12-25.

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.siweisoft.heavycenter.R;

public class CodeInputAcctItem extends RelativeLayout {

    private ImageView leftIV;

    private EditText editText;

    public CodeInputAcctItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.item_acct_input_code,this,true);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.style_common);
        leftIV = (ImageView) findViewById(R.id.iv_left);
        leftIV.setImageResource(a.getResourceId(R.styleable.style_common_iv_left,R.drawable.icon_hv_phone));
        editText= (EditText) findViewById(R.id.et_txt);
    }

    public String getText(){
        return editText.getText().toString();
    }
}
