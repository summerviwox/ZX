package com.siweisoft.heavycenter.module.main.trans.detail.detail;

//by summer on 2018-02-27.

import android.os.Bundle;

import com.android.lib.constant.ValueConstant;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailRes;

import java.util.ArrayList;
import java.util.List;

public class TransDetailRecordFrag extends AppFrag<TransDetailRecordUIOpe,TransDetailRecordDAOpe>{


    public static TransDetailRecordFrag getInstance(ArrayList<TransDetailRes.DeliverRecordListBean> data){
        TransDetailRecordFrag transDetailRecordFrag = new TransDetailRecordFrag();
        transDetailRecordFrag.setArguments(new Bundle());
        transDetailRecordFrag.getArguments().putSerializable(ValueConstant.DATA_DATA,data);
        return transDetailRecordFrag;
    }

    @Override
    public void initNow() {
        super.initNow();
        getP().getU().initUI((List<TransDetailRes.DeliverRecordListBean>) getArguments().getSerializable(ValueConstant.DATA_DATA));
    }
}
