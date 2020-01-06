package com.siweisoft.heavycenter.module.main.weights.weights;

//by summer on 2017-12-11.

import android.support.v4.app.Fragment;

import android.view.View;
import com.android.lib.base.adapter.AppBasePagerAdapter2;
import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.base.listener.BaseOnPagerChangeListener;
import com.android.lib.util.LogUtil;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.jpush.WeightMsg;
import com.siweisoft.heavycenter.databinding.FragMainWeigtsBinding;
import com.siweisoft.heavycenter.BR;

import java.util.ArrayList;

public class WeightsUIOpe extends AppUIOpe<FragMainWeigtsBinding> {


    public void initRefresh(){
    }

    public void initPages(Fragment fragment, final ArrayList<Fragment> pages){
        bind.viewpager.setOffscreenPageLimit(pages.size());
        bind.viewpager.setAdapter(new AppBasePagerAdapter2(fragment.getChildFragmentManager(),context,pages));
        bind.topview.setViewPager(bind.viewpager);
        final BaseOnPagerChangeListener baseOnPagerChangeListener = new BaseOnPagerChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                LogUtil.E("fdfdfdfdf"+position);
                if(pages.get(position) instanceof BaseUIFrag){
                    BaseUIFrag baseUIFrag = (BaseUIFrag) pages.get(position);
                    baseUIFrag.onFristVisible();
                }
            }
        };
        bind.viewpager.addOnPageChangeListener(baseOnPagerChangeListener);
        bind.viewpager.post(new Runnable() {
            @Override
            public void run() {
                baseOnPagerChangeListener.onPageSelected(0);
            }
        });
    }


    public void showBottomView(boolean sel){
        if(sel){
            bind.bottomSel.getRoot().setVisibility(View.VISIBLE);
            bind.bottom.getRoot().setVisibility(View.GONE);
        }else{
            bind.bottomSel.getRoot().setVisibility(View.GONE);
            bind.bottom.getRoot().setVisibility(View.VISIBLE);
        }
    }


    public void initUI(WeightMsg weightMsg){
        bind.bottom.setVariable(BR.frag_main_weigts_bottom,weightMsg.getMessage());
    }
}
