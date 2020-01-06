package com.siweisoft.heavycenter.module.mana.car.news;

//by summer on 2017-12-19.

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.util.NullUtil;
import com.android.lib.util.StringUtil;
import com.android.lib.util.ToastUtil;
import com.siweisoft.heavycenter.BR;
import com.siweisoft.heavycenter.GlideApp;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.NetValue;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.news.CarNewReqBean;
import com.siweisoft.heavycenter.data.netd.mana.car.update.UpdateCarReq;
import com.siweisoft.heavycenter.data.netd.unit.dirvers.DriverRes;
import com.siweisoft.heavycenter.databinding.FragManaCarDetailBinding;
import com.siweisoft.heavycenter.databinding.ItemManaCarDetailDriverBinding;

import java.util.ArrayList;
import java.util.List;

public class NewCarUIOpe extends AppUIOpe<FragManaCarDetailBinding>{


    @Override
    public void initUI() {
        super.initUI();
        bind.title.getMidTV().setText("新建车辆");
        bind.content.setVisibility(View.INVISIBLE);
        bind.tvY.setText("确定");
    }

    public boolean nowReInput(){
        if(StringUtil.equals(bind.tvY.getText().toString(),"重新输入")){
            return true;
        }else{
            return false;
        }
    }

    public void LoadListData(final ArrayList<DriverRes> o, ViewListener listener) {
        bind.recycle.setAdapter(new AppsDataBindingAdapter(context, R.layout.item_mana_car_detail_driver, BR.item_mana_car_detail_driver, o,listener){

            @Override
            public void onBindViewHolder(AppViewHolder holder, int position, List<Object> payloads) {
                super.onBindViewHolder(holder, position, payloads);
                ItemManaCarDetailDriverBinding binding = (ItemManaCarDetailDriverBinding) holder.viewDataBinding;

                if(o.get(position).getIsCurrentDriver()==DriverRes.是当前驾驶员){
                    binding.ivCheck.setSelected(true);
                }else{
                    binding.ivCheck.setSelected(false);
                }
            }

            @Override
            public void onClick(View v) {
                super.onClick(v);
                selecPos = (int) v.getTag(R.id.position);
                notifyDataSetChanged();
            }
        });
    }

    public void initData(CarsResBean.CarInfoRes data){
        //bind.etName.setText(StringUtil.getStr(data.getCarLicenseNo()));
        bind.itemBrand.setMidEtTxt(StringUtil.getStr(data.getCarBrand()));
        bind.itemEmptyweight.setMidEtTxt(StringUtil.getStr(data.getEmptyWeight()));
        bind.itemMaxweight.setMidEtTxt(StringUtil.getStr(data.getMaxCapacity()));
        bind.itemIccard.setMidEtTxt(StringUtil.getStr(data.getIcCard()));
        // bind.title.getMidTV().setText(StringUtil.getStr(data.getCarLicenseNo()));
        GlideApp.with(context).asBitmap().load(NetValue.获取地址(data.getVehiclePhoto())).placeholder(R.drawable.icon_hv_car).centerCrop().into(bind.ivVehiclePhoto);
        GlideApp.with(context).asBitmap().load(NetValue.获取地址(data.getVehicleLicensePhoto())).placeholder(R.drawable.icon_hv_driveid).centerCrop().into(bind.ivVehicleLicensePhoto);
    }

    public UpdateCarReq getUpdateCarReq(UpdateCarReq updateCarReq) {
        updateCarReq.setCarBrand(bind.itemBrand.getMidEtTxt());
        updateCarReq.setEmptyWeight(Float.parseFloat(bind.itemEmptyweight.getMidEtTxt()));
        updateCarReq.setMaxCapacity(Float.parseFloat(bind.itemMaxweight.getMidEtTxt()));
        updateCarReq.setIcCard(bind.itemIccard.getMidEtTxt());
        return updateCarReq;
    }

    public void initPhoto(String vehiclephoto,String vehiclelicensephot0){
        GlideApp.with(context).asBitmap().load(NetValue.获取地址(vehiclephoto)).placeholder(R.drawable.icon_hv_car).centerCrop().into(bind.ivVehiclePhoto);
        GlideApp.with(context).asBitmap().load(NetValue.获取地址(vehiclelicensephot0)).placeholder(R.drawable.icon_hv_driveid).centerCrop().into(bind.ivVehicleLicensePhoto);
    }


    public CarNewReqBean getCarNewReqBean(CarNewReqBean carNewReqBean) {
        carNewReqBean.setCarLicenseNo(bind.etName.getText().toString());
        carNewReqBean.setCarBrand(bind.itemBrand.getMidET().getText().toString());
        carNewReqBean.setMaxCapacity(Integer.parseInt(bind.itemMaxweight.getMidET().getText().toString()));
        carNewReqBean.setEmptyWeight(Integer.parseInt(bind.itemEmptyweight.getMidET().getText().toString()));
        carNewReqBean.setIcCard(bind.itemIccard.getMidET().getText().toString());
        return carNewReqBean;
    }

    public boolean canNewGo() {
        if (NullUtil.isStrEmpty(bind.etName.getText().toString())) {
            ToastUtil.getInstance().showShort(getActivity(), "请输入车牌号");
            return false;
        }
        if (NullUtil.isStrEmpty(bind.itemBrand.getMidET().getText().toString())) {
            ToastUtil.getInstance().showShort(getActivity(), "请输入车辆品牌");
            return false;
        }
        if (NullUtil.isStrEmpty(bind.itemMaxweight.getMidET().getText().toString())) {
            ToastUtil.getInstance().showShort(getActivity(), "请输入车辆载重");
            return false;
        }
        if (NullUtil.isStrEmpty(bind.itemEmptyweight.getMidET().getText().toString())) {
            ToastUtil.getInstance().showShort(getActivity(), "请输入车辆自重");
            return false;
        }
        return true;
    }


    public void notifyDataSetChanged(){
        bind.recycle.getAdapter().notifyDataSetChanged();
    }

    public boolean canSearchCar(){
        if(bind.etName.getText().toString().length()!=7){
            ToastUtil.getInstance().showShort(getActivity(),"车牌号输入不正确");
            return false;
        }
        return true;
    }

    public String getCarNO(){
        return bind.etName.getText().toString();
    }

    public void showCotent(boolean show){
        bind.content.setVisibility(show?View.VISIBLE:View.INVISIBLE);
    }

    public boolean canSearch(){
        if(bind.etName.getText().toString().length()!=7){
            ToastUtil.getInstance().showShort(getActivity(),"车牌号不正确");
            return false;
        }
        return true;
    }
}
