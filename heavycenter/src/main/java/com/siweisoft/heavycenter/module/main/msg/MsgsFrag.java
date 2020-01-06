package com.siweisoft.heavycenter.module.main.msg;

//by summer on 2017-12-11.

import android.view.View;

import com.android.lib.base.interf.view.OnAppItemClickListener;
import com.android.lib.util.fragment.two.FragManager2;
import com.google.zxing.integration.android.IntentIntegrator;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.main.msg.msg.MsgFrag;
import com.siweisoft.heavycenter.module.upunit.TitleTipFrag;
import com.siweisoft.heavycenter.module.view.scan.ScanAct;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import butterknife.Optional;

public class MsgsFrag extends AppFrag<MsgsUIOpe,MsgsDAOpe> {


    @Override
    public void onFristVisibleDelayInit() {
        getP().getU().initPages(getFrag(),getP().getD().getPages());
    }


    @Optional
    @OnClick({R.id.ftv_midicon,R.id.ftv_title})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ftv_back:
                ((MainAct)getActivity()).getP().getU().switchDrawer();
                break;
            case R.id.ftv_right:
                if(getActivity() instanceof MainAct){
                    new IntentIntegrator(getBaseAct()).setCaptureActivity(ScanAct.class).initiateScan();
                }
                break;
            case R.id.ftv_midicon:
            case R.id.ftv_title:
                TitleTipFrag tipFrag = TitleTipFrag.getInstance(LocalValue.get下级单位列表());
                tipFrag.setOnAppItemsClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        LoginResBean.BranchCompanyListBean data = (LoginResBean.BranchCompanyListBean) view.getTag(R.id.data);
                        getP().getD().setComid(data.getBranchId());
                        getP().getU().bind.title.getMidTV().setText(data.getAbbreviationName());
                        refreshMsg();
                    }
                });
                FragManager2.getInstance().setAnim(false).setHideLast(false).start(getBaseUIAct(),get容器(),tipFrag);
                break;
        }
    }

    private void refreshMsg(){
        for(int i=0;i<getP().getD().getPages().size();i++){
            MsgFrag msgFrag = (MsgFrag) getP().getD().getPages().get(i);
            msgFrag.getP().getU().autoRefresh();

        }
    }

}
