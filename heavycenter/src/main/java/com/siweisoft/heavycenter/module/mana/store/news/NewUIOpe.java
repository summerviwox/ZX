package com.siweisoft.heavycenter.module.mana.store.news;

//by summer on 2017-12-14.

import android.content.Context;

import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.mana.store.add.NewStoreReqBean;
import com.siweisoft.heavycenter.databinding.FragManaStoreNewBinding;

public class NewUIOpe extends AppUIOpe<FragManaStoreNewBinding> {



    public NewStoreReqBean getNewStoreReqBean(NewStoreReqBean newStoreReqBean) {
        newStoreReqBean.setWarehouseName(bind.itemName.getMidEtTxt());
        newStoreReqBean.setMaxStock(Float.parseFloat(bind.itemMaxstock.getMidEtTxt()));
        newStoreReqBean.setMinStock(Float.parseFloat(bind.itemMinstock.getMidEtTxt()));
        newStoreReqBean.setLocate("");
        return newStoreReqBean;
    }

    public boolean canGo(){
        if(NullUtil.isStrEmpty(bind.itemName.getMidEtTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"请输入仓库名称");
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
            ToastUtil.getInstance().showShort(getActivity(),"输入错误 最大库存小于安全库存");
            return false;
        }

        return true;
    }

}
