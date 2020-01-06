package com.siweisoft.heavycenter.module.main.weights.weight;

//by summer on 2017-12-11.

import android.view.View;

import com.android.lib.util.StringUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.jpush.WeightMsg;
import com.siweisoft.heavycenter.databinding.FragMainWeigtBinding;
import com.siweisoft.heavycenter.module.main.weights.weighttips.WeightTipsFrag;
import com.siweisoft.heavycenter.BR;

import java.text.DecimalFormat;

public class WeigtUIOpe extends AppUIOpe<FragMainWeigtBinding> {


    FragManager2 fragManager2;

    public void initRefresh(){
    }


    public void showTip(String title,WeightMsg weightMsg,View.OnClickListener onClickListener){
        WeightTipsFrag weightTipsFrag = new WeightTipsFrag();
        weightTipsFrag.setOnClickListener(onClickListener);
        weightTipsFrag.getP().getD().setWeightMsg(weightMsg);
        fragManager2 = FragManager2.getInstance().setStartAnim(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in,R.anim.fade_out).setFinishAnim(R.anim.fade_in,R.anim.fade_out).setHideLast(false);
        fragManager2.start(getActivity(), getFrag().get容器(),weightTipsFrag);

    }

    public FragManager2 getFragManager2() {
        return fragManager2;
    }

    public void init(WeightMsg weightMsg){
        if(weightMsg==null|| weightMsg.getMessage()==null){
            return;
        }
        WeightMsg.MessageBean m = weightMsg.getMessage();
        DecimalFormat df = new DecimalFormat("#.#");
        bind.tvWeight.setText(StringUtil.getStr(Double.parseDouble(df.format(m.getWeigh()))));
        bind.tvMz.setText(StringUtil.getStr(m.getWeigh()));
        bind.tvPz.setText(StringUtil.getStr(m.getPz()));
        bind.tvKc.setText(StringUtil.getStr(m.getKc()));
        bind.tvJz.setText(StringUtil.getStr(m.getJz()));
        //bind.weight.anim();
        bind.setVariable(BR.frag_main_weigt,weightMsg.getMessage());
    }
}
