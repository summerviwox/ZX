package com.siweisoft.heavycenter.module.main.orders;

//by summer on 2017-12-11.

import android.support.v4.app.Fragment;
import android.view.View;

import com.android.lib.base.adapter.AppBasePagerAdapter2;
import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.base.listener.BaseOnPagerChangeListener;
import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.util.LogUtil;
import com.android.lib.util.StringUtil;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersRes;
import com.siweisoft.heavycenter.data.netd.order.ordernum.OrderNumRes;
import com.siweisoft.heavycenter.databinding.FragMainOrderBinding;

import java.util.ArrayList;
import java.util.List;

public class OrdersUIOpe extends BaseUIOpe<FragMainOrderBinding>{


    @Override
    public void initUI() {
        super.initUI();
        final List<LoginResBean.BranchCompanyListBean> coms = LocalValue.get下级单位列表();
        if(coms!=null&&coms.size()>0){
            bind.title.getMidTV().setText(StringUtil.getStr(coms.get(0).getAbbreviationName()));
            bind.title.getMidIconIV().setImageResource(R.drawable.arrow_down);
            bind.title.getMidIconIV().setVisibility(View.VISIBLE);
        }
    }

    public void initPages(Fragment fragment, final ArrayList<Fragment> pages){
        bind.llCntent.setOffscreenPageLimit(pages.size());

        bind.llCntent.setAdapter(new AppBasePagerAdapter2(fragment.getChildFragmentManager(),context,pages));
        bind.topview.setViewPager(bind.llCntent);
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
        bind.llCntent.addOnPageChangeListener(baseOnPagerChangeListener);
        bind.llCntent.post(new Runnable() {
            @Override
            public void run() {
                baseOnPagerChangeListener.onPageSelected(0);
            }
        });
    }

    public void refreshTopMenu(OrderNumRes orderNumRes){
        if(orderNumRes==null){
            return;
        }
        bind.topview.setTxt(0, "新订单("+StringUtil.getStr(orderNumRes.getNewCount())+")");
        bind.topview.setTxt(1, "进行中("+StringUtil.getStr(orderNumRes.getIngCount())+")");
        bind.topview.setTxt(2, "已完成("+StringUtil.getStr(orderNumRes.getDoneCount())+")");
    }


    public void refreshTopMenu(OrdersRes orderNumRes){
        if(orderNumRes==null){
            return;
        }
        bind.topview.setTxt(0, "新订单("+StringUtil.getNUM(orderNumRes.getNewCount())+")");
        bind.topview.setTxt(1, "进行中("+StringUtil.getNUM(orderNumRes.getIngCount())+")");
        bind.topview.setTxt(2, "已完成("+StringUtil.getNUM(orderNumRes.getDoneCount())+")");
    }


    public void setCurrent(int pos){
        if(bind.llCntent.getAdapter()!=null){
            bind.llCntent.setCurrentItem(pos);
        }
    }


}
