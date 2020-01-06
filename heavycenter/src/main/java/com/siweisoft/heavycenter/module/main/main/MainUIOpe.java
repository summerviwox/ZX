package com.siweisoft.heavycenter.module.main.main;

//by summer on 17-08-23.

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;

import com.android.lib.base.adapter.HomePageAdapter;
import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.base.interf.view.OnAppItemSelectListener;
import com.android.lib.base.listener.BaseOnPagerChangeListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.util.ScreenUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.android.lib.view.bottommenu.BottomMenuBean;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.databinding.ActMainBinding;
import com.siweisoft.heavycenter.module.myce.myce.MyceFrag;
import com.siweisoft.heavycenter.module.myce.unit.nobind.NoBindFrag;

import java.util.ArrayList;

public class MainUIOpe extends AppUIOpe<ActMainBinding> {

    @Override
    public void initUI() {
        bind.incloud.hvLeftDrawer.getLayoutParams().width = (int) (ScreenUtil.w *80/ 100);
        bind.incloud.hvLeftDrawer.requestLayout();
    }

    public void setBottomMenuViewData(ArrayList<BottomMenuBean> data){
        bind.bottommenu.initItems(data);
        bind.bottommenu.setIndex(0);
    }


    public void initDrawerMenu(MyceFrag myceFrag ){
        FragManager2.getInstance().setAnim(false).start(getActivity(),MainValue.个人中心,bind.incloud.hvLeftDrawer.getId(),myceFrag);
    }

    public void initPages(final ArrayList<BottomMenuBean> pages,OnAppItemSelectListener listener){
        FragManager2.getInstance().clear();
        bind.content.setOffscreenPageLimit(pages.size());
        final BaseOnPagerChangeListener listener1 = bind.bottommenu.setViewPager(bind.content);
        bind.bottommenu.setOnAppItemClickListener(listener);
        final ArrayList<View> views = new ArrayList<>();
        for(int i=0;i<pages.size();i++){
            views.add(pages.get(i).getContainerView());
        }

        bind.content.setAdapter(new HomePageAdapter(context, views, new OnFinishListener() {

            @Override
            public void onFinish(Object o) {
                for(int i=0;i<pages.size();i++){
                    FragManager2.getInstance().setAnim(false).start(getActivity(),pages.get(i).getName(),pages.get(i).getContainerView().getId(),pages.get(i).getFragment());
                    getActivity().setMoudle(pages.get(i).getName());
                }
                bind.content.post(new Runnable() {
                    @Override
                    public void run() {
                        listener1.onPageSelected(0);
                    }
                });
            }
        }));

    }

    public void nobind(){
        Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag(NoBindFrag.class.getName());
        if(fragment!=null){
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.show(fragment);
            transaction.commitNow();
        }else{
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            NoBindFrag noBindFrag = new NoBindFrag();
            noBindFrag.setArguments(new Bundle());
            noBindFrag.getArguments().putString(ValueConstant.容器,MainValue.主界面);
            transaction.add(MainValue.主界面ID,noBindFrag,NoBindFrag.class.getName());
            transaction.commitNow();
        }
    }


    public void hideshowunbind(boolean show){
        Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag(NoBindFrag.class.getName());
        if(fragment==null){
            return;
        }
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        if(show){
            transaction.show(fragment);
        }else{
            transaction.hide(fragment);
        }
        transaction.commitNow();
    }


    public void setCurrentItem(int item){
        if(bind.content.getAdapter().getCount()<=item){
            return;
        }
        bind.content.setCurrentItem(item,false);
    }

    public void switchDrawer(){
        if(bind.drawerLayout.isDrawerOpen(Gravity.LEFT)){
            bind.drawerLayout.closeDrawer(Gravity.LEFT);
        }else{
            bind.drawerLayout.openDrawer(Gravity.LEFT);
        }
    }

    public void switchDrawerNoanim(){
        if(bind.drawerLayout.isDrawerOpen(Gravity.LEFT)){
            bind.drawerLayout.closeDrawer(Gravity.LEFT,false);
        }else{
            bind.drawerLayout.openDrawer(Gravity.LEFT,false);
        }
    }

    public void switchDrawer(boolean show){
        if(!show){
            bind.drawerLayout.closeDrawer(Gravity.LEFT);
        }else{
            bind.drawerLayout.openDrawer(Gravity.LEFT);
        }
    }
}
