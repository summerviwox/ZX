package com.siweisoft.heavycenter.data.netd.mana.good.list;

//by summer on 2018-01-17.

import com.android.lib.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

public class GoodListRes extends BaseBean{


    /**
     * totalCount : 1
     * pageIndex : 0
     * pageCount : 1
     * pageSize : 20
     * results : [{"belongArea":"漯河市,商丘市","specifications":"P\u2022O42.5R","warehouseName":"仓库2","productInfoId":68,"productName":"普通硅酸盐水泥"}]
     */

    private int totalCount;
    private int pageIndex;
    private int pageCount;
    private int pageSize;
    private List<ResultsBean> results = new ArrayList<>();

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean extends BaseBean{
        /**
         * belongArea : 漯河市,商丘市
         * specifications : P•O42.5R
         * warehouseName : 仓库2
         * productInfoId : 68
         * productName : 普通硅酸盐水泥
         */

        private String belongArea;
        private String specifications;
        private String warehouseName;
        private int productInfoId;
        private String productName;
        private int productId;
        private int warehouseId;
        private float maxStock;
        private float minStock;
        private int status;

        public static final int 启用 =1;

        public static final int 停用 = 0;

        public static final String 启用CN ="启用";

        public static final String 停用CN = "停用";


        public String getBelongArea() {
            return belongArea;
        }

        public void setBelongArea(String belongArea) {
            this.belongArea = belongArea;
        }

        public String getSpecifications() {
            return specifications;
        }

        public void setSpecifications(String specifications) {
            this.specifications = specifications;
        }

        public String getWarehouseName() {
            return warehouseName;
        }

        public void setWarehouseName(String warehouseName) {
            this.warehouseName = warehouseName;
        }

        public int getProductInfoId() {
            return productInfoId;
        }

        public void setProductInfoId(int productInfoId) {
            this.productInfoId = productInfoId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getWarehouseId() {
            return warehouseId;
        }

        public void setWarehouseId(int warehouseId) {
            this.warehouseId = warehouseId;
        }

        public float getMaxStock() {
            return maxStock;
        }

        public void setMaxStock(float maxStock) {
            this.maxStock = maxStock;
        }

        public float getMinStock() {
            return minStock;
        }

        public void setMinStock(float minStock) {
            this.minStock = minStock;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
