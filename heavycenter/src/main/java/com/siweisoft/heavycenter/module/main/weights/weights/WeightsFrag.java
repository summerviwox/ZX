package com.siweisoft.heavycenter.module.main.weights.weights;

//by summer on 2017-12-11.

import android.view.View;

import butterknife.Optional;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.GsonUtil;
import com.google.zxing.integration.android.IntentIntegrator;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.jpush.WeightMsg;
import com.siweisoft.heavycenter.data.netd.weight.list.WeightListRes;
import com.siweisoft.heavycenter.data.netd.weight.save.SaveWeightRes;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.main.weights.weight.WeigtFrag;
import com.siweisoft.heavycenter.module.view.scan.ScanAct;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.OnClick;

public class WeightsFrag extends AppFrag<WeightsUIOpe,WeightsDAOpe> {


    @Override
    protected void onFristVisibleDelayInit() {
        getDE().listWeight(new UINetAdapter<WeightListRes>(this) {
            @Override
            public void onSuccess(WeightListRes o) {
                super.onSuccess(o);
                getUI().initPages(getFrag(),getDE().initPages());
            }
        });
    }


    @Optional
    @OnClick({R.id.tv_save,R.id.tv_save_sel,R.id.tv_select,R.id.tv_select_sel})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ftv_back:
                ((MainAct)getBaseUIAct()).getUI().switchDrawer();
                break;
            case R.id.ftv_right:
                if(getActivity() instanceof MainAct){
                    new IntentIntegrator(getBaseAct()).setCaptureActivity(ScanAct.class).initiateScan();
                }
                break;
            case R.id.tv_save:
                WeigtFrag weigtFrag = (WeigtFrag) getDE().getPages().get(0);
                if(weigtFrag.getDE().getWeightMsg().getMessage().getWeigh()!=0&&getDE().getWeightMsg()!=null&&getDE().getWeightMsg().getMessage()!=null){
                    getDE().getWeightMsg().getMessage().setWeigh(weigtFrag.getDE().getWeightMsg().getMessage().getWeigh());
                }
                getUI().showBottomView(true);
                if(weigtFrag.getDE().getWeightMsg()!=null&&weigtFrag.getDE().getWeightMsg().getMessage()!=null){
                    getDE().saveWeight(getDE().getWeightMsg(), new UINetAdapter<SaveWeightRes>(this,true) {
                        @Override
                        public void onSuccess(SaveWeightRes o) {
                            super.onSuccess(o);
                            getUI().bind.bottom.tvSave.setVisibility(View.INVISIBLE);
                        }
                    });
                }
                break;
            case R.id.tv_select:
                getUI().showBottomView(true);
                break;
            case R.id.tv_select_sel:
                getUI().showBottomView(false);
                break;
            case R.id.tv_save_sel:
                getUI().showBottomView(false);
                break;

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void XXX(String str) {
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(jsonObject==null){
            return ;
        }

        WeightMsg weightMsg = GsonUtil.getInstance().fromJson(str,WeightMsg.class);
        if(weightMsg==null|| weightMsg.getMessage()==null || weightMsg.getMessage().getOrder()==null){
            return;
        }
        getUI().showBottomView(false);
        getDE().setWeightMsg(weightMsg);
        getUI().initUI(getDE().getWeightMsg());
        getUI().bind.bottom.tvSave.setVisibility(View.VISIBLE);
        initPage(weightMsg);
    }

    public void initPage(WeightMsg weightMsg){
           for(int i=0;i<getDE().getPages().size();i++){
               WeigtFrag weigtFrag = (WeigtFrag) getDE().getPages().get(i);
               weigtFrag.getDE().setWeightMsg(weightMsg);
                weigtFrag.refresh();
           }
    }

    @Override
    protected boolean registerEventBus() {
        return true;
    }
}
