package com.siweisoft.heavycenter.module.upunit;

//by summer on 2017-12-18.

import android.support.v7.widget.LinearLayoutManager;

import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.databinding.FragDialogListBinding;
import com.github.florent37.viewanimator.ViewAnimator;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;

import java.util.ArrayList;
import java.util.List;

public class TitleTipUIOpe extends BaseUIOpe<FragDialogListBinding> {


    public void init(ArrayList< LoginResBean.BranchCompanyListBean> coms, ViewListener listener){
        bind.recycle.setLayoutManager(new LinearLayoutManager(context));
        bind.recycle.setAdapter(new AppsDataBindingAdapter(getActivity(), R.layout.item_title_txt, BR.item_title_txt,coms,listener));
        ViewAnimator.animate(bind.recycle).duration(150).zoomIn().start();
    }
}
