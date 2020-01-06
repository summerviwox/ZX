package com.siweisoft.heavycenter.module.myce.car.bind;

//by summer on 2017-12-19.

import android.view.View;

import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.fragment.two.FragManager2;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.module.mana.car.detail.CarDetailValue;
import com.siweisoft.heavycenter.module.mana.car.detail.DetailDAOpe;
import com.siweisoft.heavycenter.module.mana.car.detail.DetailFrag;

import butterknife.OnClick;

public class BindFrag extends AppFrag<BindUIOpe,BindDAOpe> implements ViewListener,OnRefreshListener,OnFinishListener {

    @Override
    public void initdelay() {
        super.initdelay();
        getP().getU().initRecycle();
        getP().getU().initRefresh(this);
        onRefresh(null);
        getP().getU().实时搜索(this);
    }

    @OnClick({R.id.ftv_right,R.id.ftv_right2,R.id.tv_y})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.ftv_right:

                break;
            case R.id.ftv_right2:
//                Bundle bundle = new Bundle();
//                bundle.putInt(ValueConstant.FARG_REQ,1);
//                FragManager2.getInstance().start(getBaseUIAct(),get容器(),MainAct.主界面ID,new NewUnitFrag(),bundle);
                break;
            case R.id.tv_y:
                if(getP().getU().canSearchGo()){
                    getP().getD().infoCar(getP().getU().getInputText(), new UINetAdapter<CarsResBean.CarInfoRes>(this) {
                        @Override
                        public void onResult(boolean success, String msg, CarsResBean.CarInfoRes o) {
                            super.onResult(success, msg, o);
                            if(!DetailDAOpe.IsNewCar(o)){
                                FragManager2.getInstance().setAnim(false).start(getBaseUIAct(), get容器(),DetailFrag.getInstance(CarDetailValue.绑定车辆,"绑定车辆",o));
                            }else{
                                FragManager2.getInstance().setAnim(false).start(getBaseUIAct(),get容器(),DetailFrag.getInstance(CarDetailValue.新建车辆并绑定,getP().getU().getInputText(),null));
                            }
                        }
                    });
                }
                break;
        }
    }


    @Override
    public void onInterupt(int type, View v) {
        switch (type){
            case ViewListener.TYPE_ONCLICK:

                CarsResBean.CarInfoRes data = (CarsResBean.CarInfoRes) v.getTag(R.id.data);
                FragManager2.getInstance().setAnim(false).start(getBaseUIAct(),get容器(),DetailFrag.getInstance(CarDetailValue.绑定车辆,"绑定车辆",data));

//                getP().getD().bindCar(data.getVehicleId(), new UINetAdapter<BindCarRes>(getActivity()) {
//                    @Override
//                    public void onResult(boolean success, String msg, BindCarRes o) {
//                        super.onResult(success, msg, o);
//                        if(success){
//                            ((MainAct)getBaseUIAct()).getP().getD().getMyceFrag().initUINET();
//                            getBaseUIAct().onBackPressed();
//                        }
//                    }
//                });
                break;
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        getP().getU().clearKey();
        getP().getD().Cars(new UINetAdapter<CarsResBean>(getActivity()) {
            @Override
            public void onResult(boolean success, String msg, CarsResBean o) {
                super.onResult(success, msg, o);
                getP().getD().setNetCars(o);
                getP().getU().LoadListData(getP().getD().getSelCars(""),BindFrag.this);
                getP().getU().finishRefresh();
            }
        });
    }

    @Override
    public void onFinish(Object o) {
        getP().getU().LoadListData(getP().getD().getSelCars(o.toString()),BindFrag.this);
    }
}
