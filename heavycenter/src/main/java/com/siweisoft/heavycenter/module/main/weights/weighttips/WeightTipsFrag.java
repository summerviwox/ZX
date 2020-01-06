package com.siweisoft.heavycenter.module.main.weights.weighttips;

import android.view.View;
import butterknife.OnClick;
import butterknife.Optional;
import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.util.NullUtil;
import com.siweisoft.heavycenter.R;

/**
 * Created by summer on 2018/1/30 23:16.
 */

public class WeightTipsFrag  extends BaseUIFrag<WeightTipsUIOpe,WeightTipsDAOpe> {


    private View.OnClickListener onClickListener;

    @Override
    public void initNow() {
        super.initNow();
        getP().getU().init(getP().getD().getWeightMsg());
    }

    @Optional
    @OnClick({R.id.tv_close,R.id.tv_sure})
    public void onClick(View v) {
        super.onClick(v);
        if(onClickListener!=null ){
            if(NullUtil.isStrEmpty(getP().getU().bind.tvNewvalue.getText().toString())){
                v.setTag(R.id.data,0d);
                return;
            }
            v.setTag(R.id.data,Double.parseDouble(getP().getU().bind.tvNewvalue.getText().toString()));
            onClickListener.onClick(v);
        }

    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
