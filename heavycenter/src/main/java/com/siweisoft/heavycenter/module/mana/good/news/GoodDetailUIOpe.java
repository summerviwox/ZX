package com.siweisoft.heavycenter.module.mana.good.news;

//by summer on 2017-12-19.

import android.content.Context;

import com.android.lib.constant.ValueConstant;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.mana.good.list.GoodListRes;
import com.siweisoft.heavycenter.data.netd.mana.good.news.NewsGoodReq;
import com.siweisoft.heavycenter.data.netd.mana.good.upd.UpdGoodReq;
import com.siweisoft.heavycenter.databinding.FragManaGoodNewBinding;

public class GoodDetailUIOpe extends AppUIOpe<FragManaGoodNewBinding>{


    @Override
    public void initUI() {
        super.initUI();
        switch (getFrag().getArguments().getString(ValueConstant.DATA_TYPE,"")){
            case GoodDetailValue.新建物料:
                break;
            case GoodDetailValue.物料详情:
                bind.itemWuniaoname.getMidTV().setHint("");
                bind.itemWuliaoguige.getMidTV().setHint("");
                bind.itemCangku.getMidTV().setHint("");
                bind.itemMinstock.getMidTV().setHint("");
                bind.itemMaxstock.getMidTV().setHint("");
                bind.itemArea.getMidTV().setHint("");
                break;
        }

        bind.title.getMidTV().setText(StringUtil.getStr(getFrag().getArguments().getString(ValueConstant.DATA_TYPE)));
    }

    public void edit(GoodListRes.ResultsBean o){
        bind.itemWuniaoname.setMidTVTxt(StringUtil.getStr(o.getProductName()),"请选择");
        bind.itemWuliaoguige.setMidTVTxt(StringUtil.getStr(o.getSpecifications()),"请选择");
        bind.itemCangku.setMidTVTxt(StringUtil.getStr(o.getWarehouseName()),"请选择");
        bind.itemMaxstock.setMidEtTxt(StringUtil.getStr(o.getMaxStock()));
        bind.itemMinstock.setMidEtTxt(StringUtil.getStr(o.getMinStock()));
        bind.itemArea.setMidTVTxt(StringUtil.getStr(o.getBelongArea()),"请选择");
    }

    public boolean canSpecsGo(NewsGoodReq newsGoodReq){
        if(newsGoodReq.getMaterielId()==-1){
            ToastUtil.getInstance().showShort(getActivity(),"请先选择物料");
            return false;
        }
        return true;
    }

    public boolean canGo(NewsGoodReq newsGoodReq){
        if(NullUtil.isStrEmpty(bind.itemWuniaoname.getMidTvTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请选择物料");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.itemWuliaoguige.getMidTvTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请选择物料规格");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.itemCangku.getMidTvTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请选择仓库");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.itemMaxstock.getMidEtTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请输入最大库存");
            return false;
        }
        if(NullUtil.isStrEmpty(bind.itemMinstock.getMidEtTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请输入安全库存");
            return false;
        }
        if(Float.parseFloat(bind.itemMaxstock.getMidEtTxt())<Float.parseFloat(bind.itemMinstock.getMidEtTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"最大库存不应该小于安全库存");
            return false;
        }

//        if(Float.parseFloat(bind.itemMaxstock.getMidEtTxt())>newsGoodReq.getMaxStock()){
//            ToastUtil.getInstance().showShort(getActivity(),"最大物料库存不应该大于最大仓库库存");
//            return false;
//        }
        return true;
    }

    public void init(NewsGoodReq newsGoodReq){
        bind.itemWuniaoname.setMidTVTxt(StringUtil.getStr(newsGoodReq.getMaterielName()),"请选择");
        bind.itemWuliaoguige.setMidTVTxt(StringUtil.getStr(newsGoodReq.getMaterielSpecName()),"请选择");
        bind.itemArea.setMidTVTxt(StringUtil.getStr(newsGoodReq.getBelongAreaName()),"请选择");
        bind.itemCangku.setMidTVTxt(StringUtil.getStr(newsGoodReq.getWarehouseName()),"请选择");
    }

    public NewsGoodReq getNewsGoodReq(NewsGoodReq newsGoodReq){
        newsGoodReq.setMaxStock(Float.parseFloat(bind.itemMaxstock.getMidEtTxt().toString()));
        newsGoodReq.setMinStock(Float.parseFloat(bind.itemMinstock.getMidEtTxt().toString()));
        return newsGoodReq;
    }


    public UpdGoodReq getUpdGoodReq(UpdGoodReq updGoodReq) {
        updGoodReq.setMaxStock(Float.parseFloat(bind.itemMaxstock.getMidEtTxt()));
        updGoodReq.setMinStock(Float.parseFloat(bind.itemMinstock.getMidEtTxt()));
        return updGoodReq;
    }
}
