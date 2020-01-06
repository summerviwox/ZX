package com.siweisoft.heavycenter.module.myce.unit.info;

//by summer on 2017-12-19.

import android.view.View;

import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;
import com.siweisoft.heavycenter.data.netd.user.unit.unbind.UnBindResBean;
import com.siweisoft.heavycenter.module.main.main.MainAct;

import butterknife.OnClick;

public class InfoFrag extends AppFrag<InfoUIOpe,InfoDAOpe> {

    @Override
    public void initdelay() {
        super.initdelay();

        getP().getD().getInfo(getArguments().getInt(ValueConstant.DATA_DATA,-1),new UINetAdapter<UnitInfo>(this) {
            @Override
            public void onSuccess(UnitInfo o) {
                getP().getU().initinfo(o);
            }
        });
    }

    @OnClick({R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ftv_right2:
                getP().getU().showTip(new View.OnClickListener() {
                @Override
                public void onClick(View vv) {
                    switch (vv.getId()){
                        case R.id.close:
                            break;
                        case R.id.sure:
                            getP().getD().unBinUnit(new UINetAdapter<UnBindResBean>(InfoFrag.this,true) {
                                @Override
                                public void onSuccess(UnBindResBean o) {
                                    getP().getD().getUserInfo(new UINetAdapter<LoginResBean>(getContext()) {
                                        @Override
                                        public void onResult(boolean success, String msg, LoginResBean o) {
                                            super.onResult(success, msg, o);
                                            if(success){
                                                LocalValue.save登录返回信息(o);
                                                ((MainAct) getBaseUIAct()).go判断是否绑定单位处理();
                                            }
                                        }
                                    });
                                }
                            });
                            break;
                    }
                    if(getP().getU().getFragManager2()!=null){
                    getP().getU().getFragManager2().finish(getBaseUIAct(), getBaseUIAct().getMoudle(),false);
                    }
                }
            });
            break;
        }
    }
}
