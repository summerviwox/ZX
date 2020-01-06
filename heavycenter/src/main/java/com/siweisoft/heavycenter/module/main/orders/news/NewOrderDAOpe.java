package com.siweisoft.heavycenter.module.main.orders.news;

//by summer on 2018-01-17.

import com.android.lib.base.ope.BaseDAOpe;
import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.NetDataOpe;
import com.siweisoft.heavycenter.data.netd.order.news.NewOrderRes;
import com.siweisoft.heavycenter.data.netd.order.news.NewsOrderReqBean;
import com.siweisoft.heavycenter.data.netd.unit.info.UnitInfoReqBean;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;

public class NewOrderDAOpe extends BaseDAOpe {

    private NewsOrderReqBean newsOrderReqBean = new NewsOrderReqBean();



    public NewsOrderReqBean getNewsOrderReqBean() {
        newsOrderReqBean.setCreater(LocalValue.get登录返回信息().getUserId());
        return newsOrderReqBean;
    }

    public void newOrder(NewsOrderReqBean newsOrderReqBean, NetI<NewOrderRes> adapter){
        NetDataOpe.Order.newOrder(getActivity(),newsOrderReqBean,adapter);
    }

    public void getInfo(int id,NetI<UnitInfo> adapter){
        UnitInfoReqBean unitInfoReqBean = new UnitInfoReqBean();
        unitInfoReqBean.setId(id);
        NetDataOpe.Unit.getInfo(getActivity(), unitInfoReqBean,adapter);
    }
}
