package com.siweisoft.heavycenter.module.main.weights.weighttips;

import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.util.StringUtil;
import com.siweisoft.heavycenter.data.netd.jpush.WeightMsg;
import com.siweisoft.heavycenter.databinding.FragMainWeightSetBinding;

/**
 * Created by summer on 2018/1/30 23:16.
 */

public class WeightTipsUIOpe extends BaseUIOpe<FragMainWeightSetBinding> {



    public void init(WeightMsg weightMsg){
        if(weightMsg==null||weightMsg.getMessage()==null){
            return;
        }
        bind.tvNewvalue.setText(StringUtil.getStr(weightMsg.getMessage().getWeigh()));
        bind.tvValue.setText(StringUtil.getStr(weightMsg.getMessage().getWeigh()));
    }

}
