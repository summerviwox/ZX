package com.siweisoft.heavycenter.module.main.weights.detail;

//by summer on 2017-12-11.

import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.netd.jpush.WeightMsg;

import java.util.ArrayList;

public class DetailDAOpe extends AppDAOpe {

    private ArrayList<WeightMsg.MessageBean> weightMsgs = new ArrayList<>();


    public ArrayList<WeightMsg.MessageBean> getWeightMsgs() {
        return weightMsgs;
    }

    public void setWeightMsgs(ArrayList<WeightMsg.MessageBean> weightMsgs) {
        this.weightMsgs = weightMsgs;
    }
}
