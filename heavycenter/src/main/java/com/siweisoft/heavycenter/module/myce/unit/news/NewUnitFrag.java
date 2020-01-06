package com.siweisoft.heavycenter.module.myce.unit.news;

//by summer on 2017-12-19.

import android.os.Bundle;
import android.view.View;

import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.constant.ValueConstant;
import com.android.lib.network.news.UINetAdapter;
import com.android.lib.util.StringUtil;
import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;
import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;
import com.siweisoft.heavycenter.data.netd.unit.news.NewResBean;
import com.siweisoft.heavycenter.data.netd.unit.search.SearchResBean;
import com.siweisoft.heavycenter.data.netd.unit.update.UpdateUnitRes;
import com.siweisoft.heavycenter.data.netd.user.unit.unbind.UnBindResBean;
import com.siweisoft.heavycenter.module.main.main.MainAct;
import com.siweisoft.heavycenter.module.myce.unit.addr.AddrFrag;
import com.siweisoft.heavycenter.module.myce.unit.area.prov.ProvFrag;
import com.siweisoft.heavycenter.module.myce.unit.list.UnitListDAOpe;
import com.siweisoft.heavycenter.module.myce.unit.list.UnitListFrag;

import butterknife.OnClick;

public class NewUnitFrag extends AppFrag<NewUnitUIOpe,NewUnitDAOpe> implements OnFinishListener{

    public static final String 展示单位信息 = "展示单位信息";

    public static final String 其他人查看单位信息 = "其他人查看单位信息";

    public static final String 新建单位 = "新建单位";

    public static final String 修改单位信息 = "修改单位信息";

    @Override
    public void initNow() {
        super.initNow();
        getP().getU().initUI(getArguments().getString(ValueConstant.DATA_TYPE));
        if("新建单位".equals(getArguments().getString(ValueConstant.DATA_TYPE))){
            getP().getU().unitCheck(this);
        }
    }

    private void getInfoAndInit(final OnFinishListener listener){
        getP().getD().getInfo(getArguments().getInt(ValueConstant.DATA_DATA,-1),new UINetAdapter<UnitInfo>(this) {
            @Override
            public void onSuccess(UnitInfo o) {
                getP().getD().setUnit(o);
                if(o==null){
                    return;
                }
                getP().getD().getUnit().setBelongAreaDes(getP().getD().getUnit().getBelongArea());
                getP().getD().getUnit().setBelongArea(getP().getD().getUnit().getBelongAreaNo());
                getP().getU().initinfo(getP().getD().getUnit());
                if(listener!=null){
                    listener.onFinish(null);
                }
            }
        });
    }



    @Override
    public void initdelay() {
        super.initdelay();
        switch (getArguments().getString(ValueConstant.DATA_TYPE)){
            case 其他人查看单位信息:
            case 展示单位信息:
                getInfoAndInit(null);
                break;
            case 新建单位:
                break;
            case 修改单位信息:
                getP().getU().updateInfo();
                getInfoAndInit(null);
                break;
        }

    }


    @OnClick({R.id.unitaddr,R.id.upunit,R.id.area,R.id.ftv_right2})
    public void onClick(View v) {
        super.onClick(v);
        final Bundle bundle = new Bundle();
        switch (v.getId()){
            case R.id.unitaddr:
                bundle.putInt(ValueConstant.FARG_REQ,2);
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),new AddrFrag(),bundle);
                break;
            case R.id.upunit:
                bundle.putInt(ValueConstant.FARG_REQ,3);
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),UnitListFrag.getInstance(UnitListDAOpe.上级单位),bundle);
                break;
            case R.id.area:
                bundle.putInt(ValueConstant.FARG_REQ,4);
                FragManager2.getInstance().start(getBaseUIAct(), get容器(),new ProvFrag(),bundle);
                break;
            case R.id.ftv_right2:
                switch (getArguments().getString(ValueConstant.DATA_TYPE)){
                    case 展示单位信息:
                        getP().getU().showTip(new View.OnClickListener() {
                            @Override
                            public void onClick(View vv) {
                                switch (vv.getId()){
                                    case R.id.close:
                                        break;
                                    case R.id.sure:
                                        getP().getD().unBinUnit(new UINetAdapter<UnBindResBean>(NewUnitFrag.this,UINetAdapter.Loading,true) {
                                            @Override
                                            public void onSuccess(UnBindResBean o) {
                                                getP().getD().getUserInfo(new UINetAdapter<LoginResBean>(getContext()) {
                                                    @Override
                                                    public void onResult(boolean success, String msg, LoginResBean o) {
                                                        super.onResult(success, msg, o);
                                                        if(success){
                                                            LocalValue.save登录返回信息(o);
                                                            getBaseUIAct().onBackPressed();
                                                            ((MainAct) getBaseUIAct()).go判断是否绑定单位处理();
                                                        }
                                                    }
                                                });
                                            }
                                        });
                                        break;
                                }
                                if(getP().getU().getFragManager2()!=null){
                                    getP().getU().getFragManager2().finish(getBaseUIAct(), getBaseUIAct().getMoudle(),false);
                                }
                            }
                        });
                        break;
                    case 新建单位:
                        if(getP().getU().canGo()){
                            getP().getD().createUnit(getP().getU().getNewReqBean(getP().getD().getUnit()), new UINetAdapter<NewResBean>(this,UINetAdapter.Loading,true) {
                                @Override
                                public void onSuccess(NewResBean o) {
                                    getArguments().putBoolean(ValueConstant.DATA_RES,true);
                                    getBaseUIAct().onBackPressed();
                                }
                            });
                        }
                        break;
                    case 修改单位信息:
                        if(getP().getU().canGo()){
                            getP().getD().updateUnit(getP().getU().getUpdateUnitReq(getP().getD().getUnit()), new UINetAdapter<UpdateUnitRes>(this,UINetAdapter.Loading,true) {
                                @Override
                                public void onSuccess(UpdateUnitRes o) {
                                    getInfoAndInit(new OnFinishListener() {
                                        @Override
                                        public void onFinish(Object o) {
                                            ((MainAct)getBaseUIAct()).getP().getD().getMyceFrag().initUINET();
                                            getBaseUIAct().onBackPressed();
                                        }
                                    });
                                }
                            });
                        }
                        break;
                }
                break;
        }
    }

    @Override
    public void onResult(int res, Bundle bundle) {
        super.onResult(res, bundle);
        switch (res){
            case 2:
                if(bundle==null || bundle.getSerializable(ValueConstant.DATA_DATA)==null){
                    return;
                }
                UnitInfo unitInfo = (UnitInfo) bundle.getSerializable( ValueConstant.DATA_DATA);
                getP().getD().getUnit().setCompanyLng(unitInfo.getCompanyLng());
                getP().getD().getUnit().setCompanyLat(unitInfo.getCompanyLat());
                getP().getD().getUnit().setCompanyAddress(unitInfo.getCompanyAddress());
                getP().getU().initAddrinfo(getP().getD().getUnit());
                break;
            case 3:
                if(bundle!=null && bundle.getSerializable(ValueConstant.DATA_DATA2)!=null){
                    UnitInfo unit = (UnitInfo) bundle.getSerializable(ValueConstant.DATA_DATA2);
                    getP().getD().getUnit().setParentCompanyName(unit.getCompanyName());
                    getP().getD().getUnit().setParentCompanyId(unit.getTrueComId());
                    getP().getU().initUPUnitinfo(getP().getD().getUnit());
                }
                break;
            case 4:
                    if(bundle==null||!bundle.getBoolean(ValueConstant.DATA_INTENT2,false)){
                    return ;
                }
                getP().getD().getUnit().setBelongArea(StringUtil.getStr(bundle.getString(ValueConstant.DATA_RES2)));
                getP().getD().getUnit().setBelongAreaDes(StringUtil.getStr(bundle.getString(ValueConstant.DATA_RES)));
                getP().getU().initAreaInfo(getP().getD().getUnit());
                break;
        }
    }

    @Override
    public void onFinish(Object o) {
        String s = o.toString();
        getP().getD().searchUnitInfo(s, new UINetAdapter<SearchResBean>(this) {
            @Override
            public void onSuccess(final SearchResBean o) {
                super.onSuccess(o);
                if(o.getResults()!=null&& o.getResults().get(0)!=null){
                    getP().getU().showUnitExistTip(get容器(), o.getResults().get(0).getCompanyName(), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(getP().getU().getUnitexistfragm()!=null){
                                getP().getU().getUnitexistfragm().finish(getBaseUIAct(), getBaseUIAct().getMoudle(),false);
                            }
                            switch (v.getId()){
                                case R.id.sure:
                                    getArguments().putSerializable(ValueConstant.DATA_DATA2,o.getResults().get(0));
                                    getActivity().onBackPressed();
                                    break;
                                case R.id.close:

                                    break;
                            }
                        }
                    });
                }

            }
        });

    }
}
