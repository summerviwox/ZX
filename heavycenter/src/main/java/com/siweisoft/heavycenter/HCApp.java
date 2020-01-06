package com.siweisoft.heavycenter;

//by summer on 2017-07-28.

import android.content.Context;

import com.android.lib.aplication.LibAplication;
import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.exception.exception.CrashHander;
import com.android.lib.network.news.NetAdapter;
import com.android.lib.network.news.NetGet;
import com.android.lib.network.newsf.NetFAdapter;
import com.android.lib.util.fragment.two.FragManager2;
import com.android.lib.view.refresh.MyClassicsFooter;
import com.android.lib.view.refresh.MyClassicsHeader;
import com.baidu.mapapi.SDKInitializer;
import com.bumptech.glide.Glide;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.view.CropImageView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.crash.CrashNetOpe;

import cn.jpush.android.api.JPushInterface;

public class HCApp extends LibAplication implements OnFinishListener{


    public static boolean test  = false;

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.color_base, android.R.color.white);//全局设置主题颜色
                return new MyClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %StransUIOpe"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.color_base, android.R.color.white);//全局设置主题颜色
                MyClassicsFooter myClassicsFooter = new MyClassicsFooter(context);
                myClassicsFooter.setPrimaryColorId(R.color.color_base);
                //指定为经典Footer，默认是 BallPulseFooter
                return myClassicsFooter;
            }
        });
    }


    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        new Thread(new Runnable() {@Override public void run() {Glide.get(getApplicationContext()).clearDiskCache();}}).start();
        CrashHander.getInstance().init(getBaseContext(),this);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        FragManager2.getInstance().clear();
        initDB();
        if(test){
            LocalValue.set自动登录(false);
            NetGet.test = true;
            NetAdapter.cache = true;
            NetFAdapter.cache = true;
            new Test().init();
        }else{
            NetGet.test = false;
            NetAdapter.cache = false;
            NetFAdapter.cache = false;
        }


    }


    /**
     * 初始化图片加载了imagepicker图片选择器
     */
    public void initImagePicker() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new ImagePickerLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(1);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
    }


    @Override
    public void onFinish(Object o) {
        CrashNetOpe.setCrash(this,o.toString());
    }
}
