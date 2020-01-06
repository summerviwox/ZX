package com.siweisoft.heavycenter.data.netd.order.ordernum;

//by summer on 2018-02-05.

import com.android.lib.bean.BaseBean;

public class OrderNumRes extends BaseBean {


    /**
     * percent : 0.3
     * newCount : 12
     * ingCount : 16
     * doneCount : 1
     * defaultType : R
     */

    private double percent;
    private int newCount;
    private int ingCount;
    private int doneCount;
    private String defaultType;

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getNewCount() {
        return newCount;
    }

    public void setNewCount(int newCount) {
        this.newCount = newCount;
    }

    public int getIngCount() {
        return ingCount;
    }

    public void setIngCount(int ingCount) {
        this.ingCount = ingCount;
    }

    public int getDoneCount() {
        return doneCount;
    }

    public void setDoneCount(int doneCount) {
        this.doneCount = doneCount;
    }

    public String getDefaultType() {
        return defaultType;
    }

    public void setDefaultType(String defaultType) {
        this.defaultType = defaultType;
    }
}
