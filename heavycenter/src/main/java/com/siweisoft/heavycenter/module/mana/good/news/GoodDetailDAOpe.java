package com.siweisoft.heavycenter.module.mana.good.news;

//by summer on 2017-12-19.

import android.content.Context;

import com.android.lib.network.news.NetI;
import com.android.lib.util.NullUtil;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.mana.good.detial.GoodDetailReq;
import com.siweisoft.heavycenter.data.netd.mana.good.list.GoodListRes;
import com.siweisoft.heavycenter.data.netd.mana.good.news.NewsGoodReq;
import com.siweisoft.heavycenter.data.netd.mana.good.news.NewsGoodRes;
import com.siweisoft.heavycenter.data.netd.mana.good.upd.UpdGoodReq;
import com.siweisoft.heavycenter.data.netd.mana.good.upd.UpdGoodRes;

import java.util.HashMap;

public class GoodDetailDAOpe extends AppDAOpe {

    private NewsGoodReq newsGoodReq = new NewsGoodReq();

    private GoodListRes.ResultsBean o= new GoodListRes.ResultsBean();

    private UpdGoodReq updGoodReq = new UpdGoodReq();


    public NewsGoodReq getNewsGoodReq() {
        newsGoodReq.setCompanyId(LocalValue.get登录返回信息().getCompanyId());
        return newsGoodReq;
    }

    public void NewsGood(NewsGoodReq newsGoodReq, NetI<NewsGoodRes> adapter){
        NetDataOpe.Mana.Good.NewsGood(getActivity(),newsGoodReq,adapter);
    }

    public void detailGood(int id,NetI<GoodListRes.ResultsBean> adapter){
        GoodDetailReq goodDetailReq = new GoodDetailReq();
        goodDetailReq.setProductInfoId(id);
        NetDataOpe.Mana.Good.detailGood(getActivity(),goodDetailReq,adapter);
    }

    public void updGood(UpdGoodReq updGoodReq, NetI<UpdGoodRes> adapter){
        NetDataOpe.Mana.Good.updGood(getActivity(),updGoodReq,adapter);
    }

    public GoodListRes.ResultsBean getO() {
        return o;
    }

    public void setO(GoodListRes.ResultsBean o) {
        this.o = o;
    }

    public UpdGoodReq getUpdGoodReq(NewsGoodReq newsGoodReq) {
        updGoodReq.setId(newsGoodReq.getMaterielId());
        updGoodReq.setMaxStock(newsGoodReq.getMaxStock());
        updGoodReq.setMinStock(newsGoodReq.getMinStock());
        updGoodReq.setWarehouseId(newsGoodReq.getWarehouseId());
        updGoodReq.setBelongArea(newsGoodReq.getBelongArea());
        return updGoodReq;
    }


    public String initArea(GoodListRes.ResultsBean o){
        HashMap<String,String> map = LocalValue.get代码从市名();
        String[] str = o.getBelongArea().split(",");
        String s = "";
        for(int i=0;i<str.length;i++){
           String ss =  map.get(str[i]);
           if(!NullUtil.isStrEmpty(ss)){
               s =s +ss+",";
           }
        }
        if(s.endsWith(",")){
            s =s.substring(0,s.length()-1);
        }
        return s;
    }
}
