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
        getUI().init(getDE().getWeightMsg());
    }


    public void refresh(){
        if(getP()!=null&&getUI()!=null){
            getUI().init(getDE().getWeightMsg());
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

        getUI().showTip(title,getDE().getWeightMsg(), new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                switch (vv.getId()){
                    case R.id.tv_sure:
                        double d  = (double) vv.getTag(R.id.data);
                        switch (v.getId()){
                            case R.id.tv_weight:
                                DecimalFormat df = new DecimalFormat("#.#");
                                getUI().bind.tvWeight.setText(StringUtil.getStr(Double.parseDouble(df.format(d))));
                                switch (v.getId()){
                                    case R.id.tv_weight:
                                        getDE().getWeightMsg().getMessage().setWeigh(d);
                                        break;
                                    case R.id.tv_mz:
                                        getDE().getWeightMsg().getMessage().setMz(d);
                                        break;
                                    case R.id.tv_pz:
                                        getDE().getWeightMsg().getMessage().setPz(d);
                                        break;
                                    case R.id.tv_kc:
                                        getDE().getWeightMsg().getMessage().setKc(d);
                                        break;
                                }

                                getDE().getWeightMsg().getMessage().setWeigh(d);
                                break;
                            case R.id.tv_kc:
                                getDE().getWeightMsg().getMessage().setKc(d);
                                break;
                        }
                        break;
                    case R.id.tv_close:

                        break;
                }
                getUI().getFragManager2().finish(getBaseUIAct(), get容器(), true);
            }
        });
    }
}
