package com.siweisoft.heavycenter.module.mana.car;

//by summer on 2017-12-14.

import android.content.Context;
import android.support.v4.app.Fragment;

import com.android.lib.base.adapter.AppBasePagerAdapter2;
import com.android.lib.base.listener.BaseOnPagerChangeListener;
import com.android.lib.util.LogUtil;
import com.android.lib.util.ScreenUtil;
import com.android.lib.util.StringUtil;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersRes;
import com.siweisoft.heavycenter.data.netd.order.ordernum.OrderNumRes;
import com.siweisoft.heavycenter.databinding.FragManaCarsBinding;
import com.siweisoft.heavycenter.module.mana.car.car.CarFrag;

import java.util.ArrayList;

public class CarsUIOpe extends AppUIOpe<FragManaCarsBinding> {



    public void initPages(Fragment fragment, ArrayList<Fragment> pages){
        if(!fragment.isAdded()){
           return;
        }
        bind.llCntent.setOffscreenPageLimit(pages.size());
        bind.llCntent.setAdapter(new AppBasePagerAdapter2(fragment.getChildFragmentManager(),context,pages));
        bind.topview.setViewPager(bind.llCntent);
        final int gap = (int) (25* ScreenUtil.最小DIMEN);
        bind.llCntent.setGapw(gap);
        bind.llCntent.addOnPageChangeListener(new BaseOnPagerChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position==1){
                    CarFrag carFrag = (CarFrag) pages.get(1);
                    if(carFrag.getP().getU().bind.recycle.getAdapter()==null||carFrag.getP().getU().bind.recycle.getAdapter().getItemCount()==0){
                        bind.llCntent.setGapw((int) ScreenUtil.w);
                    }else{
                        bind.llCntent.setGapw(gap);
                    }
                }else{
                    bind.llCntent.setGapw((int) ScreenUtil.w);
                }
            }
        });
    }

    public void refreshTopMenu(CarsResBean o){
        if(o==null){
            return;
        }
        bind.topview.setTxt(0, "发货中("+StringUtil.getStr(o.getFhCount())+")");
        bind.topview.setTxt(1, "我的车辆("+StringUtil.getStr(o.getMyCount())+")");
        bind.topview.setTxt(2, "收货中("+StringUtil.getStr(o.getShCount())+")");
    }

}
