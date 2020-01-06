package com.siweisoft.heavycenter.module.mana.car;

//by summer on 2017-12-14.

import android.os.Bundle;
import android.view.View;

import com.android.lib.constant.ValueConstant;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.module.mana.car.detail.CarDetailValue;
import com.siweisoft.heavycenter.module.mana.car.detail.DetailFrag;
import com.siweisoft.heavycenter.module.mana.car.car.CarFrag;

import butterknife.OnClick;

public class CarsFrag extends AppFrag<CarsUIOpe,CarsDAOpe> {

    @Override
    public void initdelay() {
        super.initdelay();
        getP().getD().initPages();
        getP().getU().initPages(getFrag(),getP().getD().getPages());

    }

    @OnClick({R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ftv_right2:
                Bundle bundle = new Bundle();
                bundle.putInt(ValueConstant.FARG_REQ,1);
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),DetailFrag.getInstance(CarDetailValue.新建车辆,"新建车辆",null),bundle);
                break;
        }

    }

    @Override
    public void onResult(int res, Bundle bundle) {
        super.onResult(res, bundle);
        switch (res){
            case 1:
                if(bundle==null || !bundle.getBoolean(ValueConstant.FARG_TYPE,false)){
                    return;
                }
                if(bundle.getBoolean(ValueConstant.FARG_TYPE,false)){
                    CarFrag carFrag = (CarFrag) getP().getD().getPages().get(1);
                    carFrag. onRefresh(null);;
                }
                break;
        }
    }
}
