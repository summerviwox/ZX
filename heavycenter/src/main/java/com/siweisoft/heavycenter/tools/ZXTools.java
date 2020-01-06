package com.siweisoft.heavycenter.tools;

//by summer on 2018-03-07.

import com.siweisoft.heavycenter.data.netd.mana.store.list.StoreDetail;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersRes;
import com.siweisoft.heavycenter.data.netd.order.news.NewsOrderReqBean;

public class ZXTools {

    public static float get仓库最小最大当前(StoreDetail data,int i){
        switch (i){
            case 0:
                return Math.max(data.getMinStock(),data.getProductMinStock());
            case 1:
                return Math.min(data.getMaxStock(),data.getProductMaxStock());
            case 2:
                return data.getCurrentStock();
                default:
                    return 0f;
        }
    }


    public static boolean isNewOrderNeedMyMakeSure(OrdersRes.ResultsBean data){
        if((data.getAuditState()== OrdersRes.ResultsBean.AUDITSTATE_未审核)&&
                NewsOrderReqBean.发货.equals(data.getOrderType())){
            return true;
        }
        return false;
    }

}
