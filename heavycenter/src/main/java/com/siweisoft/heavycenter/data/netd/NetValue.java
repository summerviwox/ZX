package com.siweisoft.heavycenter.data.netd;

//by summer on 2017-12-21.

import android.content.Context;

import com.android.lib.util.NullUtil;
import com.android.lib.util.SPUtil;

public class NetValue {

    public static final String 奔溃日志 = "http://www.summernecro.com:8888/server/crash/sendCrash";

    public static final String HTTP前缀 = "http://";

    protected static  String 项目名 = "/zhongxin";

    public static String 正式域名 = "sx.siweisoft.cn:8079";

    protected static String 测试域名 = "192.168.1.205:8080";

    protected static String 测试域名1 = "172.26.1.15:8080";

    protected static String 测试域名林子 = "172.26.1.12:8080";

    protected static String 域名 = 测试域名;


    protected static String 文件路径 = "/files";

    protected static boolean isOffice = true;

    public static final int PAGE_INDEX_START = 1;

    public static String 获取地址(String module){
        return  HTTP前缀+域名+项目名+module;
    }


    public static String 获取文件路径(String module){
        return  HTTP前缀+域名+文件路径+module;
    }


    public static void 保存域名到文件(Context context, String 域名){
        SPUtil.getInstance().init(context).saveStr("域名", 域名);
        NetValue.域名= 域名;
    }

    public static String 获取域名从文件(Context context){
        String 域名 = SPUtil.getInstance().init(context).getStr("域名");
        if(NullUtil.isStrEmpty(域名)){
            域名 = NetValue.域名;
        }
        NetValue.域名= 域名;
        return 域名;
    }
}
