package com.siweisoft.heavycenter.module.acct.repwd;

//by summer on 2017-12-14.

import android.view.View;

import com.android.lib.base.interf.OnLoadingInterf;
import com.android.lib.network.bean.res.BaseResBean;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.acct.forget.ForGetResBean;

import butterknife.OnClick;

public class RepwdFrag extends AppFrag<RepwdUIOpe,RepwdDAOpe> {

    @Override
    public void initNow() {
        super.initNow();
        getUI().initBg(getDE().getImageUrl());

    }


    @OnClick({R.id.regist})
    public void onClick(View v){
        super.onClick(v);
        switch (v.getId()){
            case R.id.regist:
                if(getUI().go()){
                    getDE().updatePwd(getUI().getforGetReqBean(), new com.android.lib.network.news.UINetAdapter<ForGetResBean>(this,true) {
                        @Override
                        public void onNetFinish(boolean haveData, String url, BaseResBean baseResBean) {
                            if(baseResBean.getCode().equals("200")){
                                ToastUtil.getInstance().showShort(getContext(),"更换密码成功");
                                getBaseUIAct().onBackPressed();
                            }else{
                                ToastUtil.getInstance().showShort(getContext(),baseResBean.getMessage());
                            }
                            stopLoading();
                        }
                    });
                }
                break;
            case R.id.tv_code:
                if(getUI().canGetCode()){
                    getDE().getCode(getUI().getCodeReqBean());
                    getDE().getThreadUtil().run(this,v,60,1000, new OnLoadingInterf() {
                        @Override
                        public Void onStarLoading(Object o) {
                            getUI().bind.code.getCodeText().setText((60 - (int) o) + "StransUIOpe");
                            if ((60 - (int) o) <= 0) {
                                getUI().bind.code.setEnabled(true);
                                getDE().getThreadUtil().stop();
                                getUI().bind.code.getCodeText().setText("重新获取验证码");
                            }
                            return null;
                        }

                        @Override
                        public Void onStopLoading(Object o) {
                            return null;
                        }
                    });
                }
                break;
        }
    }

}
