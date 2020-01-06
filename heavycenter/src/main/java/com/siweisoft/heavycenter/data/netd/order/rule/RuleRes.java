package com.siweisoft.heavycenter.data.netd.order.rule;

//by summer on 2018-01-17.

import com.android.lib.bean.BaseBean;

import java.util.ArrayList;

public class RuleRes extends BaseBean {

    ArrayList<Rule> data;

    public ArrayList<Rule> getData() {
        return data;
    }

    public void setData(ArrayList<Rule> data) {
        this.data = data;
    }
}
