package com.siweisoft.heavycenter.data.netd;

//by summer on 2018-01-09.

import android.content.Context;

import com.android.lib.network.news.NetGet;
import com.android.lib.network.news.NetI;
import com.siweisoft.heavycenter.data.netd.acct.code.CodeReqBean;
import com.siweisoft.heavycenter.data.netd.acct.code.CodeResBean;
import com.siweisoft.heavycenter.data.netd.acct.forget.ForGetReqBean;
import com.siweisoft.heavycenter.data.netd.acct.forget.ForGetResBean;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginReqBean;
import com.siweisoft.heavycenter.data.netd.acct.login.LoginResBean;
import com.siweisoft.heavycenter.data.netd.acct.logout.LogOutReqBean;
import com.siweisoft.heavycenter.data.netd.acct.logout.LogOutResBean;
import com.siweisoft.heavycenter.data.netd.acct.regist.RegistReqBean;
import com.siweisoft.heavycenter.data.netd.acct.regist.RegistResBean;
import com.siweisoft.heavycenter.data.netd.acct.rename.ReNameReqBean;
import com.siweisoft.heavycenter.data.netd.acct.rename.ReNameResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.bind.BindCarReq;
import com.siweisoft.heavycenter.data.netd.mana.car.bind.BindCarRes;
import com.siweisoft.heavycenter.data.netd.mana.car.info.CarInfoReq;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsReqBean;
import com.siweisoft.heavycenter.data.netd.mana.car.list.CarsResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.news.CarNewReqBean;
import com.siweisoft.heavycenter.data.netd.mana.car.news.CarNewResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.status.StopCarReqBean;
import com.siweisoft.heavycenter.data.netd.mana.car.status.StopCarResBean;
import com.siweisoft.heavycenter.data.netd.mana.car.update.UpdateCarReq;
import com.siweisoft.heavycenter.data.netd.mana.car.update.UpdateCarRes;
import com.siweisoft.heavycenter.data.netd.mana.good.detial.GoodDetailReq;
import com.siweisoft.heavycenter.data.netd.mana.good.list.GoodListReq;
import com.siweisoft.heavycenter.data.netd.mana.good.list.GoodListRes;
import com.siweisoft.heavycenter.data.netd.mana.good.names.NamesReq;
import com.siweisoft.heavycenter.data.netd.mana.good.names.NamesRes;
import com.siweisoft.heavycenter.data.netd.mana.good.news.NewsGoodReq;
import com.siweisoft.heavycenter.data.netd.mana.good.news.NewsGoodRes;
import com.siweisoft.heavycenter.data.netd.mana.good.specs.SpecsReq;
import com.siweisoft.heavycenter.data.netd.mana.good.specs.SpecsRes;
import com.siweisoft.heavycenter.data.netd.mana.good.status.GoodStatusReq;
import com.siweisoft.heavycenter.data.netd.mana.good.status.GoodStatusRes;
import com.siweisoft.heavycenter.data.netd.mana.good.upd.UpdGoodReq;
import com.siweisoft.heavycenter.data.netd.mana.good.upd.UpdGoodRes;
import com.siweisoft.heavycenter.data.netd.mana.store.add.NewStoreReqBean;
import com.siweisoft.heavycenter.data.netd.mana.store.add.NewStoreResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.check.CheckStoreReqBean;
import com.siweisoft.heavycenter.data.netd.mana.store.check.CheckStoreResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.detail.StoreDetailReq;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoreDetail;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoresReqBean;
import com.siweisoft.heavycenter.data.netd.mana.store.list.StoresResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.status.StatusStoresReqBean;
import com.siweisoft.heavycenter.data.netd.mana.store.status.StatusStoresResBean;
import com.siweisoft.heavycenter.data.netd.mana.store.update.UpdateStoreReq;
import com.siweisoft.heavycenter.data.netd.mana.store.update.UpdateStoreRes;
import com.siweisoft.heavycenter.data.netd.mana.user.add.AddUserReqBean;
import com.siweisoft.heavycenter.data.netd.mana.user.add.AddUserResBean;
import com.siweisoft.heavycenter.data.netd.msg.deal.MsgDealReqBean;
import com.siweisoft.heavycenter.data.netd.msg.deal.MsgDealResBean;
import com.siweisoft.heavycenter.data.netd.msg.list.MsgsReqBean;
import com.siweisoft.heavycenter.data.netd.msg.list.MsgsResBean;
import com.siweisoft.heavycenter.data.netd.order.addcar.AddCarReq;
import com.siweisoft.heavycenter.data.netd.order.addcar.AddCarRes;
import com.siweisoft.heavycenter.data.netd.order.detail.OrderDetailReq;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersReq;
import com.siweisoft.heavycenter.data.netd.order.list.OrdersRes;
import com.siweisoft.heavycenter.data.netd.order.news.NewOrderRes;
import com.siweisoft.heavycenter.data.netd.order.news.NewsOrderReqBean;
import com.siweisoft.heavycenter.data.netd.order.ordernum.OrderNumReq;
import com.siweisoft.heavycenter.data.netd.order.ordernum.OrderNumRes;
import com.siweisoft.heavycenter.data.netd.order.receipt.ReceiptOrderReq;
import com.siweisoft.heavycenter.data.netd.order.receipt.ReceiptOrderRes;
import com.siweisoft.heavycenter.data.netd.other.city.CityReqBean;
import com.siweisoft.heavycenter.data.netd.other.city.CityResBean;
import com.siweisoft.heavycenter.data.netd.scan.weight.WeightReq;
import com.siweisoft.heavycenter.data.netd.scan.weight.WeightRes;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailReq;
import com.siweisoft.heavycenter.data.netd.trans.detail.TransDetailRes;
import com.siweisoft.heavycenter.data.netd.trans.sign.TransSignReq;
import com.siweisoft.heavycenter.data.netd.trans.sign.TransSignRes;
import com.siweisoft.heavycenter.data.netd.trans.strans.StransReq;
import com.siweisoft.heavycenter.data.netd.trans.trans.TransReq;
import com.siweisoft.heavycenter.data.netd.trans.trans.TransRes;
import com.siweisoft.heavycenter.data.netd.unit.dirvers.DriverRes;
import com.siweisoft.heavycenter.data.netd.unit.dirvers.DriversReq;
import com.siweisoft.heavycenter.data.netd.unit.historyfh.HistoryFhUnitReq;
import com.siweisoft.heavycenter.data.netd.unit.historysh.HistoryShUnitReq;
import com.siweisoft.heavycenter.data.netd.unit.info.UnitInfoReqBean;
import com.siweisoft.heavycenter.data.netd.unit.list.ListReqBean;
import com.siweisoft.heavycenter.data.netd.unit.list.ListResBean;
import com.siweisoft.heavycenter.data.netd.unit.list.UnitInfo;
import com.siweisoft.heavycenter.data.netd.unit.news.NewReqBean;
import com.siweisoft.heavycenter.data.netd.unit.news.NewResBean;
import com.siweisoft.heavycenter.data.netd.unit.search.SearchReqBean;
import com.siweisoft.heavycenter.data.netd.unit.search.SearchResBean;
import com.siweisoft.heavycenter.data.netd.unit.update.UpdateUnitReq;
import com.siweisoft.heavycenter.data.netd.unit.update.UpdateUnitRes;
import com.siweisoft.heavycenter.data.netd.unit.user.UnitUserResBean;
import com.siweisoft.heavycenter.data.netd.unit.user.UnitUsersReqBean;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadReqBean;
import com.siweisoft.heavycenter.data.netd.user.head.UpdateHeadResBean;
import com.siweisoft.heavycenter.data.netd.user.info.UserInfoReqBean;
import com.siweisoft.heavycenter.data.netd.user.unit.bind.BindReqBean;
import com.siweisoft.heavycenter.data.netd.user.unit.bind.BindResBean;
import com.siweisoft.heavycenter.data.netd.user.unit.unbind.UnBindReqBean;
import com.siweisoft.heavycenter.data.netd.user.unit.unbind.UnBindResBean;
import com.siweisoft.heavycenter.data.netd.user.userrole.UserRoleReq;
import com.siweisoft.heavycenter.data.netd.user.userrole.UserRoleRes;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeResBean;
import com.siweisoft.heavycenter.data.netd.weight.list.WeightListReq;
import com.siweisoft.heavycenter.data.netd.weight.list.WeightListRes;
import com.siweisoft.heavycenter.data.netd.weight.save.SaveWeightReq;
import com.siweisoft.heavycenter.data.netd.weight.save.SaveWeightRes;

import org.xutils.common.util.KeyValue;

import java.util.ArrayList;
import java.util.List;

public class NetDataOpe {



    public static void getCode(Context context, String moudle, CodeReqBean reqBean, NetI<CodeResBean> adapter) {
        NetGet.postData(context,moudle,reqBean,adapter);
    }

    public static void onRegist(Context context,String moudle, RegistReqBean reqBean, NetI<RegistResBean> adapter) {

        NetGet.postData(context,moudle,reqBean,adapter);
    }

    public static void onLogin(Context context, LoginReqBean reqBean, NetI<LoginResBean> adapter) {
        NetGet.postDataGetCookie(context,NetValue.获取地址("/user/appLogin"),reqBean,adapter);
    }

    public static void updatePwd(Context context, String moudle, ForGetReqBean reqBean, NetI<ForGetResBean> adapter) {
        NetGet.postData(context,moudle,reqBean,adapter);
    }

    public static void setUserType(Context context, String moudle, UserTypeReqBean reqBean, NetI<UserTypeResBean> adapter) {
        NetGet.postData(context,moudle,reqBean,adapter);
    }

    public static void logOut(Context context, LogOutReqBean reqBean, NetI<LogOutResBean> adapter) {
        NetGet.postData(context,NetValue.获取地址("/user/appExit"),reqBean,adapter);
    }

    public static void reName(Context context, ReNameReqBean reqBean, NetI<ReNameResBean> adapter) {
        NetGet.postData(context,NetValue.获取地址("/user/update"),reqBean,adapter);
    }

    public static void unitList(Context context, ListReqBean reqBean, NetI<ListResBean> adapter) {
        NetGet.getData(context,NetValue.获取地址("/company/list"),reqBean,adapter);
    }

    public static void unitCreate(Context context, NewReqBean reqBean, NetI<NewResBean> adapter) {
        NetGet.getData(context,NetValue.获取地址("/company/insert"),reqBean,adapter);
    }

    public static void get省市列表接口数据(Context context, CityReqBean reqBean, NetI<ArrayList<CityResBean>> adapter) {
        NetGet.getData(context,NetValue.获取地址("/metadata/getCity"),reqBean,adapter);
    }




    public static class Order{


        public static void newOrder(Context context, NewsOrderReqBean reqBean, NetI<NewOrderRes> adapter) {
            NetGet.postData(context,NetValue.获取地址("/orders/insert"),reqBean,adapter);
        }

        public static void orders(Context context, OrdersReq reqBean, NetI<OrdersRes> adapter) {
            NetGet.getData(context,NetValue.获取地址("/orders/list"),reqBean,adapter);
        }


        public static void addCar(Context context, AddCarReq reqBean, NetI<AddCarRes> adapter) {
            NetGet.postData(context,NetValue.获取地址("/orders/addVehicle"),reqBean,adapter);
        }

        public static void detail(Context context, OrderDetailReq reqBean, NetI<OrdersRes.ResultsBean> adapter) {
            NetGet.getData(context,NetValue.获取地址("/orders/getDetail"),reqBean,adapter);
        }


        public static void receipt(Context context, ReceiptOrderReq reqBean, NetI<ReceiptOrderRes> adapter) {
            NetGet.postData(context,NetValue.获取地址("/orders/auditOrder"),reqBean,adapter);
        }


        public static void getOrderCount(Context context, OrderNumReq reqBean, NetI<OrderNumRes> adapter) {
            NetGet.getData(context,NetValue.获取地址("/orders/getOrderCount"),reqBean,adapter);
        }


        public static void getStrans(Context context, StransReq reqBean, NetI<TransRes> adapter) {
            NetGet.getData(context,NetValue.获取地址("/ysRecord/list"),reqBean,adapter);
        }
    }

    public static class Trans{


        public static void transs(Context context, TransReq reqBean, NetI<TransRes> adapter) {
            NetGet.getData(context,NetValue.获取地址("/ysRecord/list"),reqBean,adapter);
        }


        public static void signTrans(Context context, TransSignReq reqBean, NetI<TransSignRes> adapter) {
            NetGet.postData(context,NetValue.获取地址("/ysRecord/signTranSportRecord"),reqBean,adapter);
        }


        public static void detailTrans(Context context, TransDetailReq reqBean, NetI<TransDetailRes> adapter) {
            NetGet.getData(context,NetValue.获取地址("/ysRecord/getDetail"),reqBean,adapter);
        }


    }



    public static class Unit{

        public static void search(Context context, SearchReqBean reqBean, NetI<SearchResBean> adapter) {
            NetGet.getData(context,NetValue.获取地址("/company/search"),reqBean,adapter);
        }

        public static void getInfo(Context context, UnitInfoReqBean reqBean, NetI<UnitInfo> adapter) {
            NetGet.getData(context,NetValue.获取地址("/company/getDetail"),reqBean,adapter);
        }

        public static void unitUsers(Context context, UnitUsersReqBean reqBean, NetI<UnitUserResBean> adapter) {
            NetGet.getData(context,NetValue.获取地址("/user/list"),reqBean,adapter);
        }

        public static void createUnit(Context context, NewReqBean reqBean, NetI<NewResBean> adapter) {
            NetGet.postData(context,NetValue.获取地址("/company/insert"),reqBean,adapter);
        }


        public static void drvers(Context context, DriversReq reqBean, NetI<ArrayList<DriverRes>> adapter) {
            NetGet.getData(context,NetValue.获取地址("/user/getDriver"),reqBean,adapter);
        }

        public static void updateUnit(Context context, UpdateUnitReq reqBean, NetI<UpdateUnitRes> adapter) {
            NetGet.postData(context,NetValue.获取地址("/company/update"),reqBean,adapter);
        }


        public static void historyFhUnit(Context context, HistoryFhUnitReq reqBean, NetI<ListResBean> adapter) {
            NetGet.getData(context,NetValue.获取地址("/orders/historyFhdw"),reqBean,adapter);
        }

        public static void historyShUnit(Context context, HistoryShUnitReq reqBean, NetI<ListResBean> adapter) {
            NetGet.getData(context,NetValue.获取地址("/orders/historyShdw"),reqBean,adapter);
        }

    }

    public static class Msg{

        public static void list(Context context, MsgsReqBean reqBean, NetI<MsgsResBean> adapter) {
            NetGet.getData(context,NetValue.获取地址("/message/list"),reqBean,adapter);
        }

        public static void deal(Context context, MsgDealReqBean reqBean, NetI<MsgDealResBean> adapter) {
            NetGet.postData(context,NetValue.获取地址("/message/deal"),reqBean,adapter);
        }

    }

    public static class User{

        public static void binUnit(Context context, BindReqBean reqBean, NetI<BindResBean> adapter) {
            NetGet.postData(context,NetValue.获取地址("/user/bindCompany"),reqBean,adapter);
        }

        public static void unBinUnit(Context context, UnBindReqBean reqBean, NetI<UnBindResBean> adapter) {
            NetGet.postData(context,NetValue.获取地址("/user/unBindCompany"),reqBean,adapter);
        }


        public static void get用户信息(Context context, UserInfoReqBean reqBean, NetI<LoginResBean> adapter) {
            NetGet.getData(context,NetValue.获取地址("/user/getDetail"),reqBean,adapter);
        }


        public static void uploadPhoto(Context context, List<KeyValue> keyValues,final NetI netI){
            NetGet.file(context,NetValue.获取地址("/uploadPic/picture"),keyValues,netI);
        }


        public static void updatePhoto(Context context, UpdateHeadReqBean reqBean, NetI<UpdateHeadResBean> adapter) {
            NetGet.postData(context,NetValue.获取地址("/user/updatePhoto"),reqBean,adapter);
        }


        public static void updateDriver(Context context, UpdateHeadReqBean reqBean, NetI<UpdateHeadResBean> adapter) {
            NetGet.postData(context,NetValue.获取地址("/user/updateDriverInfo"),reqBean,adapter);
        }

        public static void setUserRole(Context context, UserRoleReq reqBean, NetI<UserRoleRes> adapter) {
            NetGet.postData(context,NetValue.获取地址("/user/setUserRole"),reqBean,adapter);
        }


    }

    public static class Mana{

        public static class Store{

            public static void sotresInfo(Context context, StoresReqBean reqBean, NetI<StoresResBean> adapter) {
                NetGet.getData(context,NetValue.获取地址("/wareHouse/list"),reqBean,adapter);
            }

            public static void newStore(Context context, NewStoreReqBean reqBean, NetI<NewStoreResBean> adapter) {
                NetGet.postData(context,NetValue.获取地址("/wareHouse/insert"),reqBean,adapter);
            }

            public static void statusStore(Context context, StatusStoresReqBean reqBean, NetI<StatusStoresResBean> adapter) {
                NetGet.postData(context,NetValue.获取地址("/wareHouse/updateWareHouseStatus"),reqBean,adapter);
            }

            public static void checkStore(Context context, CheckStoreReqBean reqBean, NetI<CheckStoreResBean> adapter) {
                NetGet.postData(context,NetValue.获取地址("/wareHouse/inventory"),reqBean,adapter);
            }

            public static void detail(Context context, StoreDetailReq reqBean, NetI<StoreDetail> adapter) {
                NetGet.getData(context,NetValue.获取地址("/wareHouse/getDetail"),reqBean,adapter);
            }


            public static void update(Context context, UpdateStoreReq reqBean, NetI<UpdateStoreRes> adapter) {
                NetGet.postData(context,NetValue.获取地址("/wareHouse/update"),reqBean,adapter);
            }

        }


        public static class Car{

            public static void Cars(Context context, CarsReqBean reqBean, NetI<CarsResBean> adapter) {
                NetGet.getData(context,NetValue.获取地址("/vehicle/list"),reqBean,adapter);
            }

            public static void newCar(Context context, CarNewReqBean reqBean, NetI<CarsResBean.CarInfoRes> adapter) {
                NetGet.postData(context,NetValue.获取地址("/vehicle/insert"),reqBean,adapter);
            }

            public static void statusCar(Context context, StopCarReqBean reqBean, NetI<StopCarResBean> adapter) {
                NetGet.postData(context,NetValue.获取地址("/vehicle/startOrStop"),reqBean,adapter);
            }

            public static void updateCar(Context context, UpdateCarReq reqBean, NetI<UpdateCarRes> adapter) {
                NetGet.postData(context,NetValue.获取地址("/vehicle/update"),reqBean,adapter);
            }


            public static void bindCar(Context context, BindCarReq reqBean, NetI<BindCarRes> adapter) {
                NetGet.postData(context,NetValue.获取地址("/vehicle/bindVehicle"),reqBean,adapter);
            }


            public static void infoCar(Context context, CarInfoReq reqBean, NetI<CarsResBean.CarInfoRes> adapter) {
                NetGet.getData(context,NetValue.获取地址("/vehicle/getDetail"),reqBean,adapter);
            }

        }

        public static class User{

            public static void addUser(Context context, AddUserReqBean reqBean, NetI<AddUserResBean> adapter) {
                NetGet.postData(context,NetValue.获取地址("/user/insertUserApp"),reqBean,adapter);
            }

        }


        public static class Good{

            public static void listGood(Context context, GoodListReq reqBean, NetI<GoodListRes> adapter) {
                NetGet.getData(context,NetValue.获取地址("/product/list"),reqBean,adapter);
            }


            public static void NamesGood(Context context, NamesReq reqBean, NetI<NamesRes> adapter) {
                NetGet.getData(context,NetValue.获取地址("/product/productList"),reqBean,adapter);
            }


            public static void ProductList(Context context, NamesReq reqBean, NetI<NamesRes> adapter) {
                NetGet.getData(context,NetValue.获取地址("/materiel/list"),reqBean,adapter);
            }


            public static void NewsGood(Context context, NewsGoodReq reqBean, NetI<NewsGoodRes> adapter) {
                NetGet.postData(context,NetValue.获取地址("/product/insertProduct"),reqBean,adapter);
            }

            public static void SpecsGood(Context context, SpecsReq reqBean, NetI<SpecsRes> adapter) {
                NetGet.getData(context,NetValue.获取地址("/materielSpec/list"),reqBean,adapter);
            }


            public static void detailGood(Context context, GoodDetailReq reqBean, NetI<GoodListRes.ResultsBean> adapter) {
                NetGet.getData(context,NetValue.获取地址("/product/productDetail"),reqBean,adapter);
            }


            public static void updGood(Context context, UpdGoodReq reqBean, NetI<UpdGoodRes> adapter) {
                NetGet.postData(context,NetValue.获取地址("/product/updateProduct"),reqBean,adapter);
            }


            public static void updateStatus(Context context, GoodStatusReq reqBean, NetI<GoodStatusRes> adapter) {
                NetGet.postData(context,NetValue.获取地址("/product/updateProductStatus"),reqBean,adapter);
            }

        }

    }


    public static class Scan{

        public static void triggerWeigh(Context context, WeightReq reqBean, NetI<WeightRes> adapter) {
            NetGet.postData(context,NetValue.获取地址("/weigh/triggerWeigh"),reqBean,adapter);
        }


    }


    public static class Weight{

        public static void listWeight(Context context, WeightListReq reqBean, NetI<WeightListRes> adapter) {
            NetGet.getData(context,NetValue.获取地址("/weighbridge/list"),reqBean,adapter);
        }

        public static void saveWeight(Context context, SaveWeightReq reqBean, NetI<SaveWeightRes> adapter) {
            NetGet.postData(context,NetValue.获取地址("/weigh/saveWeigh"),reqBean,adapter);
        }
    }


}
