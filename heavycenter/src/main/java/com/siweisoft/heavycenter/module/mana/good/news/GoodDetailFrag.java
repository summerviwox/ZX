package com.siweisoft.heavycenter.module.mana.good.news;

//by summer on 2017-12-19.

import android.os.Bundle;
import android.view.View;

import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.netd.mana.good.list.GoodListRes;
import com.siweisoft.heavycenter.data.netd.mana.good.names.NamesRes;
import com.siweisoft.heavycenter.data.netd.mana.good.news.NewsGoodRes;
import com.siweisoft.heavycenter.data.netd.mana.good.specs.SpecsRes;
import com.siweisoft.heavycenter.data.netd.mana.good.upd.UpdGoodRes;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoreDetail;
import com.siweisoft.heavycenter.module.mana.good.lists.NamesFrag;
import com.siweisoft.heavycenter.module.mana.good.specs.SpecsFrag;
import com.siweisoft.heavycenter.module.mana.store.StoreFrag;
import com.siweisoft.heavycenter.module.myce.unit.area.prov.ProvFrag;

import butterknife.OnClick;

public class GoodDetailFrag extends AppFrag<GoodDetailUIOpe,GoodDetailDAOpe> {


    public static GoodDetailFrag getInstance(String type,int goodid){
        GoodDetailFrag goodDetailFrag = new GoodDetailFrag();
        goodDetailFrag.setArguments(new Bundle());
        goodDetailFrag.getArguments().putString(ValueConstant.DATA_TYPE,type);
        goodDetailFrag.getArguments().putInt(ValueConstant.DATA_DATA,goodid);
        return goodDetailFrag;
    }

    @Override
    public void initdelay() {
        super.initdelay();
        if(getArguments().getInt(ValueConstant.DATA_DATA,-1)!=-1){
            getP().getD().detailGood(getArguments().getInt(ValueConstant.DATA_DATA), new UINetAdapter<GoodListRes.ResultsBean>(this) {
                @Override
                public void onSuccess(GoodListRes.ResultsBean o) {
                    super.onSuccess(o);
                    getP().getD().setO(o);

                    getP().getD().getNewsGoodReq().setBelongAreaName(getP().getD().getO().getBelongArea());
                    getP().getD().getNewsGoodReq().setBelongArea(getP().getD().initArea(getP().getD().getO()));
                    getP().getD().getNewsGoodReq().setWarehouseId(getP().getD().getO().getWarehouseId());
                    getP().getD().getNewsGoodReq().setWarehouseName(getP().getD().getO().getWarehouseName());
                    getP().getD().getNewsGoodReq().setMinStock(getP().getD().getO().getMinStock());
                    getP().getD().getNewsGoodReq().setMaxStock(getP().getD().getO().getMaxStock());
                    getP().getD().getNewsGoodReq().setMaterielName(getP().getD().getO().getProductName());
                    getP().getD().getNewsGoodReq().setMaterielId(getP().getD().getO().getProductInfoId());
                    getP().getD().getNewsGoodReq().setMaterielSpecName(getP().getD().getO().getSpecifications());




                    getP().getU().edit(getP().getD().getO());
                }
            });
        }
    }

    @OnClick({R.id.item_wuniaoname,R.id.item_wuliaoguige,R.id.item_cangku,R.id.item_area,R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        Bundle bundle = new Bundle();
        switch (v.getId()){
            case R.id.item_wuniaoname:
                bundle.putInt(ValueConstant.FARG_REQ,1);
                FragManager2.getInstance().start(getBaseUIAct(),get容器(),new NamesFrag(),bundle);
                break;
            case R.id.item_wuliaoguige:
                if(getP().getU().canSpecsGo(getP().getD().getNewsGoodReq())){
                    bundle.putInt(ValueConstant.DATA_POSITION2,getP().getD().getNewsGoodReq().getMaterielId());
                    bundle.putInt(ValueConstant.FARG_REQ,2);
                    FragManager2.getInstance().start(getBaseUIAct(), get容器(),new SpecsFrag(),bundle);
                }
                break;
            case R.id.item_cangku:
                bundle.putInt(ValueConstant.FARG_REQ,3);
                bundle.putInt(ValueConstant.DATA_POSITION2,StoreFrag.选择一个仓库);
                FragManager2.getInstance().start(getBaseUIAct(),get容器(),new StoreFrag(),bundle);
                break;
            case R.id.item_area:
                bundle.putInt(ValueConstant.FARG_REQ,4);
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),new ProvFrag(),bundle);
                break;
            case R.id.ftv_right2:
                if(getArguments().getInt(ValueConstant.DATA_DATA,-1)!=-1){
                    if(getP().getU().canGo(getP().getD().getNewsGoodReq())){
                        getP().getD().updGood(getP().getU().getUpdGoodReq(getP().getD().getUpdGoodReq(getP().getD().getNewsGoodReq())), new UINetAdapter<UpdGoodRes>(this,true) {
                            @Override
                            public void onSuccess(UpdGoodRes o) {
                                getArguments().putBoolean(ValueConstant.FARG_TYPE,true);
                                getBaseUIAct().onBackPressed();
                            }
                        });
                    }
                }else{
                    if(getP().getU().canGo(getP().getD().getNewsGoodReq())){
                        getP().getD().NewsGood(getP().getU().getNewsGoodReq(getP().getD().getNewsGoodReq()), new UINetAdapter<NewsGoodRes>(this,true) {
                            @Override
                            public void onSuccess(NewsGoodRes o) {
                                getArguments().putBoolean(ValueConstant.FARG_TYPE,true);
                                getBaseUIAct().onBackPressed();
                            }
                        });
                    }
                }
                break;
        }
    }
    @Override
    public void onResult(int res, Bundle bundle) {
        super.onResult(res, bundle);
        switch (res){
            case 1:
                if(bundle.getSerializable(ValueConstant.DATA_DATA2)==null){
                    return;
                }
                NamesRes.ResultsBean data = (NamesRes.ResultsBean) bundle.getSerializable(ValueConstant.DATA_DATA2);
                getP().getD().getNewsGoodReq().setMaterielId(data.getId());
                getP().getD().getNewsGoodReq().setMaterielName(data.getMaterielName());
                getP().getD().getNewsGoodReq().setMaterielSpecName("");
                //getP().getD().getNewsGoodReq().setMaterielSpecId(data.getProductId());
                //getP().getD().getNewsGoodReq().setMaterielSpecName(data.getSpecifications());
                break;
            case 2:
                if(bundle.getSerializable(ValueConstant.DATA_DATA2)==null){
                    return;
                }
                SpecsRes.ResultsBean data1 = (SpecsRes.ResultsBean) bundle.getSerializable(ValueConstant.DATA_DATA2);
                getP().getD().getNewsGoodReq().setMaterielSpecId(data1.getSpecificationsId());
                getP().getD().getNewsGoodReq().setMaterielSpecName(data1.getSpecifications());
                break;
            case 3:
                if(bundle.getSerializable(ValueConstant.DATA_DATA2)!=null){
                    StoreDetail d = (StoreDetail) bundle.getSerializable(ValueConstant.DATA_DATA2);
                    getP().getD().getNewsGoodReq().setMaxStock(d.getMaxStock());
                    getP().getD().getNewsGoodReq().setWarehouseId(d.getWarehouseId());
                    getP().getD().getNewsGoodReq().setWarehouseName(d.getWarehouseName());
                }
                break;
            case 4:
                if(bundle==null||!bundle.getBoolean(ValueConstant.DATA_INTENT2,false)){
                    return;
                }
                String name = bundle.getString(ValueConstant.DATA_RES);
                String req = bundle.getString(ValueConstant.DATA_RES2);
                getP().getD().getNewsGoodReq().setBelongAreaName(name);
                getP().getD().getNewsGoodReq().setBelongArea(req);
                break;

        }
        getP().getU().init(getP().getD().getNewsGoodReq());
    }
}
