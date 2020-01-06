package com.siweisoft.heavycenter.module.main.orders.news.rule;

//by summer on 2018-01-17.

import android.view.View;

import com.android.lib.base.interf.listener.ViewListener;
import com.android.lib.constant.ValueConstant;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.order.rule.Rule;

public class RuleFrag extends AppFrag<RuleUIOpe,RuleDAOpe> implements ViewListener {

    @Override
    public void initNow() {
        super.initNow();
        getP().getU().LoadListData(RuleDAOpe.getRuleRes(), RuleFrag.this);
    }

    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.type:
                Rule rule  = (Rule) v.getTag(R.id.data);
                getArguments().putSerializable(ValueConstant.DATA_DATA2,rule);
                getBaseUIAct().onBackPressed();
                break;
        }
    }
}
