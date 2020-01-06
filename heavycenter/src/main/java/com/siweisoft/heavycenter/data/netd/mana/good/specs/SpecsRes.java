package com.siweisoft.heavycenter.data.netd.mana.good.specs;

//by summer on 2018-01-17.

import com.android.lib.bean.BaseBean;

import java.util.List;

public class SpecsRes extends BaseBean {


    /**
     * totalCount : 27
     * pageIndex : 0
     * pageCount : 2
     * pageSize : 20
     * results : [{"productId":4,"specifications":"P\u2022O42.5","specificationsId":9},{"productId":4,"specifications":"P\u2022O42.5R","specificationsId":10},{"productId":4,"specifications":"P\u2022O52.5","specificationsId":11},{"productId":4,"specifications":"P\u2022O52.5R","specificationsId":12}]
     */

    private int totalCount;
    private int pageIndex;
    private int pageCount;
    private int pageSize;
    private List<ResultsBean> results;

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
         * productId : 4
         * specifications : P•O42.5
         * specificationsId : 9
         */

        private int productId;
        private String specifications;
        private int specificationsId;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getSpecifications() {
            return specifications;
        }

        public void setSpecifications(String specifications) {
            this.specifications = specifications;
        }

        public int getSpecificationsId() {
            return specificationsId;
        }

        public void setSpecificationsId(int specificationsId) {
            this.specificationsId = specificationsId;
        }
    }
}
