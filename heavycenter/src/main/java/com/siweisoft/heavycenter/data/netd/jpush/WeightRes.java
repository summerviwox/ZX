package com.siweisoft.heavycenter.data.netd.jpush;

//by summer on 2018-02-02.

import com.android.lib.network.bean.res.BaseResBean;

public class WeightRes extends BaseResBean {

    private double weight;

    private double deduct;

    private double pz;

    private double mz;

    private double kc;

    private double jz;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDeduct() {
        return deduct;
    }

    public void setDeduct(double deduct) {
        this.deduct = deduct;
    }

    public double getPz() {
        return pz;
    }

    public void setPz(double pz) {
        this.pz = pz;
    }

    public double getMz() {
        return mz;
    }

    public void setMz(double mz) {
        this.mz = mz;
    }

    public double getKc() {
        return kc;
    }

    public void setKc(double kc) {
        this.kc = kc;
    }

    public double getJz() {
        return jz;
    }

    public void setJz(double jz) {
        this.jz = jz;
    }
}
