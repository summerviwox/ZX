package com.siweisoft.heavycenter;

//by summer on 2018-01-11.

import android.os.Environment;

import com.siweisoft.heavycenter.data.locd.LocalValue;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.mana.good.list.GoodListRes;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoreDetail;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoresResBean;
import com.siweisoft.heavycenter.data.netd.msg.list.MsgsResBean;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersReq;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersRes;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailRes;
import com.siweisoft.heavycenter.data.netd.trans.trans.TransRes;
import com.siweisoft.heavycenter.data.netd.unit.list.ListResBean;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;
import com.siweisoft.heavycenter.data.netd.unit.user.UnitUserResBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {



    private static HashMap<String,String> testdata = new HashMap<>();

    public void init(){
        testData();
        initTestData();
    }

    private void testData(){
        LoginResBean loginResBean = new LoginResBean();
        loginResBean.setAbbreviationName("公司简称");
        loginResBean.setBindCompanyState(LoginResBean.BIND_UNIT_STATE_BINDED);
        loginResBean.setBindCompanyTime(System.currentTimeMillis());

        ArrayList<LoginResBean.BranchCompanyListBean> branchCompanyList = new ArrayList<>();
        LoginResBean.BranchCompanyListBean branchCompanyListBean = new LoginResBean.BranchCompanyListBean();
        branchCompanyListBean.setAbbreviationName("公司简称");
        branchCompanyListBean.setBranchId(40);
        branchCompanyListBean.setCompanyName("id为40的公司");
        branchCompanyList.add(branchCompanyListBean);
        loginResBean.setBranchCompanyList(branchCompanyList);
        loginResBean.setCompanyId(40);
        loginResBean.setCompanyName("公司名称");
        loginResBean.setDeviceId("fdjfoewhgiehgoir");
        loginResBean.setDeviceType(1);
        loginResBean.setLoginStatus(1);
        loginResBean.setPassWord("123456");
        loginResBean.setProductCount(10);
        loginResBean.setTel("18721607438");
        loginResBean.setTrueName("唐杰");
        loginResBean.setUserCount(10);
        loginResBean.setUserId(150);
        loginResBean.setUserPhoto("13355550000");
        loginResBean.setUserRole(LoginResBean.USER_ROLE_ADMIN);
        loginResBean.setUserType(UserTypeReqBean.非驾驶员);
        loginResBean.setVehicleCount(10);
        loginResBean.setWareHouseCount(10);
        LocalValue.save登录返回信息(loginResBean);

    }


    private void initTestData(){

    }


    public MsgsResBean getMsgsResBean(){
        MsgsResBean msgsResBean = new MsgsResBean();
        msgsResBean.setResults(new ArrayList<MsgsResBean.ResultsBean>());
        for(int i=0;i<10;i++){
            MsgsResBean.ResultsBean resultsBean = new MsgsResBean.ResultsBean();
            resultsBean.setAuditor(0);
            resultsBean.setAuditorName("授权人");
            resultsBean.setAuditState(0);
            resultsBean.setAuditTime("2017/12/12");
            resultsBean.setMessageCate("");
            resultsBean.setMessageContent("吊装国际有限公司的null向你们单位发了一个新的收货订单，请注意确认");
            resultsBean.setMessageId(10);
            resultsBean.setMessageType("非驾驶员消息类型");
            resultsBean.setSender(1);
            resultsBean.setSenderName("发送人");
            resultsBean.setSendTime(System.currentTimeMillis());
            msgsResBean.getResults().add(resultsBean);
        }
        return msgsResBean;
    }


    public StoresResBean getStoresResBean(){
        StoresResBean storesResBean = new StoresResBean();
        for(int i=0;i<10;i++){
            StoreDetail storeDetail = new StoreDetail();
            storeDetail.setAfterAdjust(123);
            storeDetail.setAllProfitNum("allprofit");
            storeDetail.setCompanyName("公司");
            storeDetail.setCurrentStock(123.6f);
            storeDetail.setLocate("南门");
            storeDetail.setMaxStock(1235.6f);
            storeDetail.setMinStock(35f);
            storeDetail.setProductId(1);
            storeDetail.setProductMaxStock(132f);
            storeDetail.setProductMinStock(34f);
            storeDetail.setSpecifications("300f");
            storeDetail.setStatus(1);
            storeDetail.setTodayOutStorage("344.5");
            storeDetail.setTodayProfitNum("profitnum");
            storeDetail.setTodayStorage("100.5");
            storeDetail.setWarehouseId(1);
            storeDetail.setWarehouseName("仓库1");
            storesResBean.getResults().add(storeDetail);
        }
        return storesResBean;
    }

    public StoreDetail getStoreDetail(){
        StoreDetail storeDetail = new StoreDetail();
        storeDetail.setAfterAdjust(123);
        storeDetail.setAllProfitNum("allprofit");
        storeDetail.setCompanyName("公司");
        storeDetail.setCurrentStock(123.6f);
        storeDetail.setLocate("南门");
        storeDetail.setMaxStock(1235.6f);
        storeDetail.setMinStock(35f);
        storeDetail.setProductId(1);
        storeDetail.setProductMaxStock(1302f);
        storeDetail.setProductMinStock(34f);
        storeDetail.setSpecifications("300f");
        storeDetail.setStatus(1);
        storeDetail.setTodayOutStorage("344.5");
        storeDetail.setTodayProfitNum("profitnum");
        storeDetail.setTodayStorage("100.5");
        storeDetail.setWarehouseId(1);
        storeDetail.setWarehouseName("仓库1");
        return storeDetail;
    }

    public OrdersRes getOrdersRes(){
        OrdersRes ordersRes = new OrdersRes();
        for(int i=0;i<10;i++){
            OrdersRes.ResultsBean resultsBean = new OrdersRes.ResultsBean();
            resultsBean.setAddress("安徽省广德桃州镇");
            resultsBean.setFhdwName("发货单位");
            resultsBean.setFhdwQName("发货单位简称");
            resultsBean.setOrderId(1);
            resultsBean.setOrderNo("NO123reffd");
            resultsBean.setOrderStatus(OrdersReq.进行中订单);
            resultsBean.setOrderType("S");
            resultsBean.setPlanNumber(110);
            resultsBean.setPlanTime(System.currentTimeMillis());
            resultsBean.setProductName("沙子");
            resultsBean.setShdwName("收货单位");
            resultsBean.setShdwQName("收货单位简称");
            resultsBean.setSignRule("驾驶员直接签收");
            resultsBean.setSpecification("规格型号");
            ordersRes.getResults().add(resultsBean);
        }
        return ordersRes;
    }

    public TransRes getTransRes(){
        TransRes transRes = new TransRes();
        for(int i=0;i<10;i++){
            TransDetailRes resultsBean = new TransDetailRes();
            resultsBean.setCarLicenseNo("车牌号");
            resultsBean.setCarNumber(11);
            resultsBean.setDeveliverCompanyName("运输公司运输公司运输公司运输公司运输公司");
            resultsBean.setDeveliverNum(233);
           // resultsBean.setFhTime("发货时间");
            resultsBean.setOrdersId(1);
            resultsBean.setOrderType("R");
           // resultsBean.setPlanNumber(123);
            resultsBean.setProductName("产品产品产品产品产品产品");
            resultsBean.setReceiveCompanyName("收货单位");
            resultsBean.setReceiveNum(3333);
           // resultsBean.setShTime(System.currentTimeMillis());
            resultsBean.setSignStatus(1);
            resultsBean.setSpecifications("规格规格规格规格规格规格");
            resultsBean.setTel("18721547854");
            resultsBean.setTotalSuttle(20);
            resultsBean.setPlanNumber(50);
            resultsBean.setTransportrecordId(1);
            resultsBean.setTrueName("唐杰唐杰唐杰唐杰唐杰唐杰唐杰");
            resultsBean.setUserId(1);
            resultsBean.setFhTime(System.currentTimeMillis());
            resultsBean.setShTime(System.currentTimeMillis());
            transRes.getResults().add(resultsBean);
        }
        return transRes;
    }

    public ListResBean getListResBean(){
        ListResBean listResBean = new ListResBean();
        for(int i=0;i<10;i++){
            UnitInfo unitInfo = new UnitInfo();
            unitInfo.setAbbreviationName("单位简称");
            unitInfo.setBelongArea("000000");
            unitInfo.setBelongAreaDes("山海");
            unitInfo.setBusinessLicense("驾驶员号");
            unitInfo.setCompanyAddress("公司地址");
            unitInfo.setCompanyFax("");
            unitInfo.setCompanyIsNull(0);
            unitInfo.setCompanyLat(0d);
            unitInfo.setCompanyLng(0d);
            unitInfo.setCompanyName("公司名称");
            unitInfo.setCompanyType(1);
            unitInfo.setContactPhone("18754251245");
            unitInfo.setContactName("唐杰");
            unitInfo.setCpNum(1);
            unitInfo.setCreater(1);
            unitInfo.setId(1);
            unitInfo.setYhNum(10);
            listResBean.getResults().add(unitInfo);
        }
        return listResBean;
    }


    public GoodListRes getGoodListRes(){
        GoodListRes goodListRes = new GoodListRes();
        for(int i=0;i<10;i++){
            GoodListRes.ResultsBean resultsBean = new GoodListRes.ResultsBean();
            resultsBean.setBelongArea("00000");
            resultsBean.setMaxStock(100);
            resultsBean.setMinStock(10);
            resultsBean.setProductId(1);
            resultsBean.setProductInfoId(1);
            resultsBean.setProductName("产品名称");
            resultsBean.setSpecifications("规格");
            resultsBean.setStatus(1);
            resultsBean.setWarehouseId(1);
            resultsBean.setWarehouseName("仓库");
            goodListRes.getResults().add(resultsBean);
        }
        return goodListRes;
    }


    public UnitUserResBean getUnitUserResBean(){
        UnitUserResBean unitUserResBean = new UnitUserResBean();
        for(int i=0;i<10;i++){
            UnitUserResBean.ResultsBean resultsBean = new UnitUserResBean.ResultsBean();
            resultsBean.setAuditerName("auditernaem");
            resultsBean.setBindCompanyState(2);
            resultsBean.setBindCompanyTime(System.currentTimeMillis());
            resultsBean.setStatus(1);
            resultsBean.setTel("1875465822");
            resultsBean.setTrueName("唐杰");
            resultsBean.setUserId(1);
            resultsBean.setUserPhoto("fdf");
            resultsBean.setUserRole("general");
            unitUserResBean.getResults().add(resultsBean);
        }
        return  unitUserResBean;
    }

    public static HashMap<String, String> getTestdata() {
        return testdata;
    }

    public void saveFile(String url,String data){
        File file = new File(Environment.getDownloadCacheDirectory()+"/hv",url.replace("\\",""));
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileReader fileReader = new FileReader(file);
            char[] c = data.toCharArray();
            fileReader.read(c,0,c.length);
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  CarsResBean getCarsResBean(){
        CarsResBean carsResBean = new CarsResBean();
        for(int i=0;i<30;i++){
            CarsResBean.CarInfoRes carInfoRes = new CarsResBean.CarInfoRes();
            carInfoRes.setCarBrand("品牌");
            carInfoRes.setCarLat(13.4444);
            carInfoRes.setCarLicenseNo("沪A3232q");
            carInfoRes.setCarLng(34.4444);
            carInfoRes.setCompanyId(0);
            carInfoRes.setCompanyName("公司名称");
            carInfoRes.setCreater(0);
            carInfoRes.setCurrentDriver(0);
            carInfoRes.setEmptyWeight(12);
            carInfoRes.setIcCard("fdsgsdfsf");
            carInfoRes.setMaxCapacity(34);
            carInfoRes.setSpecifications("规格");
            carInfoRes.setStatus(1);
            carInfoRes.setTel("16355252251");
            carInfoRes.setTrueName("唐杰");
            carInfoRes.setVehicleId(0);
            carInfoRes.setVehicleLicense("fjdfd");
            carsResBean.getResults().add(carInfoRes);
        }
        return carsResBean;
    }

}
