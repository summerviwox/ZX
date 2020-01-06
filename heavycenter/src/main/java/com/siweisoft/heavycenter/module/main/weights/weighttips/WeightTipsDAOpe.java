package com.siweisoft.heavycenter.module.main.weights.weighttips;

import com.android.lib.base.ope.BaseDAOpe;
import com.siweisoft.heavycenter.data.netd.jpush.WeightMsg;

/**
 * Created by summer on 2018/1/30 23:16.
 */

public class WeightTipsDAOpe extends BaseDAOpe{

    WeightMsg weightMsg = new WeightMsg();


    public WeightMsg getWeightMsg() {
        return weightMsg;
    }

    public void setWeightMsg(WeightMsg weightMsg) {
        this.weightMsg = weightMsg;
    }
}
