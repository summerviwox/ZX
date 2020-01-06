package com.siweisoft.heavycenter.module.main.map;

//by summer on 2017-12-11.

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.util.StringUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.databinding.FragMainMapBinding;
import com.siweisoft.heavycenter.databinding.FragMainStoreBinding;

import java.util.List;

public class MapUIOpe extends BaseUIOpe<FragMainMapBinding>{


    @Override
    public void initUI() {
        super.initUI();
        bind.title.getMidTV().setText(StringUtil.getStr(LocalValue.get登录返回信息().getAbbreviationName()));
    }
}
