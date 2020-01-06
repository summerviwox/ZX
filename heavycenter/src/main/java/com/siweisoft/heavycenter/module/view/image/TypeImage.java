package com.siweisoft.heavycenter.module.view.image;

//by summer on 2018-01-09.

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.siweisoft.heavycenter.R;

@SuppressLint("AppCompatCustomView")
public class TypeImage extends ImageView {

    public static final int TYPE_FULL = 2;

    public static final int TYPE_HELF = 1;

    public static final int TYPE_NULL = 0;

    public TypeImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setType(int type){
        switch (type){
            case TYPE_FULL:
                setBackgroundResource(R.drawable.icon_hv_myce_unit_new_area_full);
                break;
            case TYPE_HELF:
                setBackgroundResource(R.drawable.icon_hv_myce_unit_new_area_helf);
                break;
            case TYPE_NULL:
                setBackgroundResource(R.drawable.icon_hv_myce_unit_new_area_null);
            default:
                setBackgroundResource(R.drawable.icon_hv_myce_unit_new_area_null);
                break;
        }
    }
}
