package com.siweisoft.heavycenter.module.main.orders.detail;

//by summer on 2017-12-19.

import com.android.lib.network.news.NetI;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.base.AppDAOpe;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.order.addcar.AddCarReq;
import com.siweisoft.heavycenter.data.netd.order.addcar.AddCarRes;
import com.siweisoft.heavycenter.data.netd.order.detail.OrderDetailReq;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersRes;

public class DetailDAOpe extends AppDAOpe {

    private OrdersRes.ResultsBean data;




    public OrdersRes.ResultsBean getData() {
        return data;
    }

    public void setData(OrdersRes.ResultsBean data) {
        this.data = data;
    }


    public void addCar(int carid, String oper, NetI<AddCarRes> adapter){
        AddCarReq addCarReq = new AddCarReq();
        addCarReq.setId(getData().getOrderId());
        addCarReq.setEditer(LocalValue.get登录返回信息().getUserId());
        addCarReq.setVehicleList(carid);
        addCarReq.setOper(oper);
        NetDataOpe.Order.addCar(getActivity(),addCarReq,adapter);
    }

    public void detail(int id, NetI<OrdersRes.ResultsBean> adapter){
        OrderDetailReq orderDetailReq = new OrderDetailReq();
        orderDetailReq.setIsApp(1);
        orderDetailReq.setId(id);
        NetDataOpe.Order.detail(getActivity(),orderDetailReq,adapter);
    }

    public boolean haveAddCar(CarsResBean.CarInfoRes bean){
        if(bean==null){
            return true;
        }
        boolean have = false;
        for(int i=0;data!=null&&data.getVehicleList()!=null&&i<data.getVehicleList().size();i++){
            if(bean.getVehicleId()==data.getVehicleList().get(i).getVehicleId()){
                have = true;
            }
        }
        if(!have){
            return false;
        }else{
            ToastUtil.getInstance().showShort(getActivity(),"该车辆已在指定承运车辆列表中");
            return true;
        }
    }

}
