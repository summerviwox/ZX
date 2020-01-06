package com.siweisoft.heavycenter.module.mana.store.info;

import android.content.Context;
import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.constant.ValueConstant;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.data.netd.mana.store.add.NewStoreReqBean;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoreDetail;
import com.siweisoft.heavycenter.data.netd.mana.store.update.UpdateStoreReq;
import com.siweisoft.heavycenter.databinding.FragManaStoreInfoBinding;

/**
 * Created by summer on 2018/1/31 0:12.
 */

public class StoreInfoUIOpe  extends BaseUIOpe<FragManaStoreInfoBinding>{


    @Override
    public void initUI() {
        super.initUI();
        switch (getFrag().getArguments().getString(StoreInfoValue.仓库类型)){
            case StoreInfoValue.修改仓库:
                bind.title.getMidTV().setText("仓库详情");
                break;
            case StoreInfoValue.新建仓库:
                bind.title.getMidTV().setText("新建仓库");
                break;
        }
    }

    public void initUI(StoreDetail storeDetail){
        bind.itemMaxstock.setMidEtTxt(StringUtil.getStr(storeDetail.getMaxStock()));
        bind.itemMinstock.setMidEtTxt(StringUtil.getStr(storeDetail.getMinStock()));
        bind.itemId.setMidEtTxt(StringUtil.getStr(storeDetail.getWarehouseName()));
        bind.itemDes.setMidEtTxt(StringUtil.getStr(storeDetail.getLocate()));
    }

    public NewStoreReqBean getNewStoreReqBean(NewStoreReqBean newStoreReqBean) {
        newStoreReqBean.setWarehouseName(bind.itemId.getMidEtTxt());
        newStoreReqBean.setMaxStock(Float.parseFloat(bind.itemMaxstock.getMidEtTxt()));
        newStoreReqBean.setMinStock(Float.parseFloat(bind.itemMinstock.getMidEtTxt()));
        newStoreReqBean.setLocate(StringUtil.getStr(bind.itemDes.getMidEtTxt()));
        return newStoreReqBean;
    }


    public UpdateStoreReq getUpdateStoreReq(UpdateStoreReq updateStoreReq) {
        updateStoreReq.setWarehouseName(StringUtil.getStr(bind.itemId.getMidEtTxt()));
        updateStoreReq.setMinStock(Double.parseDouble(bind.itemMinstock.getMidEtTxt()));
        updateStoreReq.setMaxStock(Double.parseDouble(bind.itemMaxstock.getMidEtTxt()));
        updateStoreReq.setLocate(StringUtil.getStr(bind.itemDes.getMidEtTxt()));
        return updateStoreReq;
    }

    public boolean canGo(){
        if(NullUtil.isStrEmpty(bind.itemId.getMidEtTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"仓库名称为空");
            return false;
        }

        if(NullUtil.isStrEmpty(bind.itemMaxstock.getMidEtTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"最大库存为空");
            return false;
        }

        if(NullUtil.isStrEmpty(bind.itemMinstock.getMidEtTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"安全库存为空");
            return false;
        }


        if(Double.parseDouble(bind.itemMaxstock.getMidEtTxt())<Double.parseDouble(bind.itemMinstock.getMidEtTxt())){
            ToastUtil.getInstance().showShort(getActivity(),"安全库存不能大于最大库存");
            return false;
        }

        return true;
    }
}
