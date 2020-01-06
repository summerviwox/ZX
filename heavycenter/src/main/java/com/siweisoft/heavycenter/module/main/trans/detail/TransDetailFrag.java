package com.siweisoft.heavycenter.module.main.trans.detail;

//by summer on 2017-12-18.

import android.view.View;

import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.Test;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailRes;

import butterknife.OnClick;

public class TransDetailFrag extends AppFrag<TransDetailUIOpe,TransDetailDAOpe> {


    @Override
    public void initdelay() {
        super.initdelay();
        getDE().setTransid(getArguments().getInt(ValueConstant.DATA_DATA,-1));
        getDE().detailTrans(getDE().getTransid(), new UINetAdapter<TransDetailRes>(this,UINetAdapter.Loading) {
            @Override
            public void onSuccess(TransDetailRes o) {
                //o= new Test().getTransRes().getResults().get(0);
                getUI().initUI(o);
            }
        });
    }

    @OnClick({R.id.tv_receipt,R.id.tv_lab_receipt,R.id.tv_delivenum,R.id.tv_lab_delive})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_receipt:
            case R.id.tv_lab_receipt:
                getUI().setCurrent(1);
                break;
            case R.id.tv_delivenum:
            case R.id.tv_lab_delive:
                getUI().setCurrent(0);
                break;
        }
    }
}
