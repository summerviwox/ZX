package com.siweisoft.heavycenter.module.myce.base.info;

//by summer on 2017-12-19.

import android.view.View;

import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;

import butterknife.OnClick;

public class InfoFrag extends AppFrag<InfoUIOpe,InfoDAOpe> {


    View.OnClickListener onClickListener;

    @Override
    public void initNow() {
        super.initNow();
        getP().getU().initScan();
    }

    @Override
    public void initdelay() {
        super.initdelay();
       // getP().getU().initScan();

    }

    @OnClick({R.id.iv_close})
    public void onClick(View v) {
        if(onClickListener!=null){
            onClickListener.onClick(v);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
