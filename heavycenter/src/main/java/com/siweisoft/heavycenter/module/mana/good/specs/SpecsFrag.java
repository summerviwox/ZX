package com.siweisoft.heavycenter.module.mana.good.specs;

//by summer on 2018-01-17.

import android.view.View;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.mana.good.specs.SpecsRes;

public class SpecsFrag extends AppFrag<SpecsUIOpe,SpecsDAOpe> implements ViewListener{

    @Override
    public void initdelay() {
        super.initdelay();
        getP().getD().SpecsGood(getArguments().getInt(ValueConstant.DATA_POSITION2), new UINetAdapter<SpecsRes>(this) {
            @Override
            public void onSuccess(SpecsRes o) {
                getP().getU().LoadListData(o,SpecsFrag.this);
            }
        });
    }

    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.type:
                SpecsRes.ResultsBean data = (SpecsRes.ResultsBean) v.getTag(R.id.data);
                getArguments().putSerializable(ValueConstant.DATA_DATA2,data);
                getBaseUIAct().onBackPressed();
                break;
        }
    }
}
