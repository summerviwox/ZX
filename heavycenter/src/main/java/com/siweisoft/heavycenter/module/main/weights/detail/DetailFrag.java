package com.siweisoft.heavycenter.module.main.weights.detail;

//by summer on 2017-12-11.

import android.view.View;

import com.android.lib.util.GsonUtil;
import com.android.lib.util.LogUtil;
import com.android.lib.util.NullUtil;
import com.google.zxing.integration.android.IntentIntegrator;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.jpush.WeightMsg;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.view.scan.ScanAct;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import io.paperdb.Paper;

public class DetailFrag extends AppFrag<DetailUIOpe,DetailDAOpe> {

    public DetailFrag() {
        LogUtil.E(343);
    }

    @Override
    public void initNow() {
        super.initNow();
        getP().getD().setWeightMsgs(Paper.book().read("weights"+ LocalValue.get登录返回信息().getUserId(),new ArrayList<WeightMsg.MessageBean>()));
        getP().getU().LoadListData(getP().getD().getWeightMsgs());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ftv_back:
                ((MainAct)getBaseUIAct()).getP().getU().switchDrawer();
                break;
            case R.id.ftv_right:
                if(getActivity() instanceof MainAct){
                    new IntentIntegrator(getBaseAct()).setCaptureActivity(ScanAct.class).initiateScan();
                }
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void XXX(String str) {
        WeightMsg.MessageBean m = GsonUtil.getInstance().fromJson(str,WeightMsg.class).getMessage();
        if(m==null){
            return ;
        }
        getP().getU().initTopUI(m);
        if(NullUtil.isStrEmpty(m.getMessageType())||NullUtil.isStrEmpty(m.getState())){
            return;
        }
        ArrayList<WeightMsg.MessageBean> list = new ArrayList<>();
        list.add(m);
        getP().getD().getWeightMsgs().add(m);
        Paper.book().write("weights"+ LocalValue.get登录返回信息().getUserId(),getP().getD().getWeightMsgs());
        getP().getU().notifyDataSetChanged();

    }


    @Override
    protected boolean registerEventBus() {
        return  true;
    }
}
