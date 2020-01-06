package com.siweisoft.heavycenter.module.main.store.news;

//by summer on 2017-12-11.

import android.view.View;

import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.main.store.check.CheckFrag;

import butterknife.OnClick;

public class NewFrag extends AppFrag<NewUIOpe,NewDAOpe> {

    @Override
    public void initNow() {
        super.initNow();
        getP().getU().initRefresh();
        getP().getU().initRecycle();
        getP().getU().LoadListData(getP().getD().getData());
    }

    @OnClick({R.id.ftv_right2})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ftv_back:
                ((MainAct)getActivity()).getP().getU().switchDrawer();
                break;
            case R.id.ftv_right2:
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),new CheckFrag());
        }
    }
}
