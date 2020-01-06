package com.siweisoft.heavycenter.module.main.weights.weight;

//by summer on 2017-12-11.

import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;

import com.android.lib.constant.ValueConstant;
import com.android.lib.util.StringUtil;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.module.main.weights.weights.WeightsFrag;

import java.text.DecimalFormat;


public class WeigtFrag extends AppFrag<WeigtUIOpe,WeigtDAOpe> {


    public static WeigtFrag getInstance(String moudle){
        WeigtFrag weigtFrag = new WeigtFrag();
        weigtFrag.setArguments(new Bundle());
        weigtFrag.getArguments().putString(ValueConstant.容器,moudle);
        return  weigtFrag;
    }

    @Override
    public void initdelay() {
        super.initdelay();
        getP().getU().init(getP().getD().getWeightMsg());
    }


    public void refresh(){
        if(getP()!=null&&getP().getU()!=null){
            getP().getU().init(getP().getD().getWeightMsg());
        }
    }


    @OnClick({R.id.tv_weight,R.id.tv_mz,R.id.tv_pz,R.id.tv_kc})
    public void onClick(final View v) {
        String title = "";
        switch (v.getId()){
            case R.id.tv_weight:
              title ="校验";
                break;
            case R.id.tv_mz:
                title ="毛重校验";
                break;
            case R.id.tv_pz:
                title ="皮重校验";
                break;
            case R.id.tv_kc:
                title ="扣除校验";
                break;
        }

        getP().getU().showTip(title,getP().getD().getWeightMsg(), new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                switch (vv.getId()){
                    case R.id.tv_sure:
                        double d  = (double) vv.getTag(R.id.data);
                        switch (v.getId()){
                            case R.id.tv_weight:
                                DecimalFormat df = new DecimalFormat("#.#");
                                getP().getU().bind.tvWeight.setText(StringUtil.getStr(Double.parseDouble(df.format(d))));
                                switch (v.getId()){
                                    case R.id.tv_weight:
                                        getP().getD().getWeightMsg().getMessage().setWeigh(d);
                                        break;
                                    case R.id.tv_mz:
                                        getP().getD().getWeightMsg().getMessage().setMz(d);
                                        break;
                                    case R.id.tv_pz:
                                        getP().getD().getWeightMsg().getMessage().setPz(d);
                                        break;
                                    case R.id.tv_kc:
                                        getP().getD().getWeightMsg().getMessage().setKc(d);
                                        break;
                                }

                                getP().getD().getWeightMsg().getMessage().setWeigh(d);
                                break;
                            case R.id.tv_kc:
                                getP().getD().getWeightMsg().getMessage().setKc(d);
                                break;
                        }
                        break;
                    case R.id.tv_close:

                        break;
                }
                getP().getU().getFragManager2().finish(getBaseUIAct(), get容器(), true);
            }
        });
    }
}
