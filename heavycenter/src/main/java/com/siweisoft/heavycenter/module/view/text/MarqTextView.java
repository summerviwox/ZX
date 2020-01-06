package com.siweisoft.heavycenter.module.view.text;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by summer on 2018/3/11 13:01.
 */

public class MarqTextView extends android.support.v7.widget.AppCompatTextView{

    public MarqTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setSelected(true);
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setSelected(true);
    }
}
