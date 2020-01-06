package com.siweisoft.heavycenter.data.netd.mana.good.names;

//by summer on 2018-01-17.

import com.android.lib.bean.BaseBean;

import java.util.List;

public class NamesRes extends BaseBean {


    /**
     * totalCount : 47
     * pageIndex : -100
     * pageCount : 1
     * pageSize : 100
     * results : [{"productId":2,"specifications":"100t","productName":"沙子"},{"productId":2,"specifications":"100t","productName":"沙子"},{"productId":4,"specifications":"P\u2022O42.5R","productName":"普通硅酸盐水泥"},{"productId":3,"specifications":"200f","productName":"水泥"},{"productId":1,"specifications":"C30","productName":"混凝土"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":2,"specifications":"100t","productName":"沙子"},{"productId":1,"specifications":"C30","productName":"混凝土"},{"productId":1,"specifications":"C30","productName":"混凝土"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":1,"specifications":"C30","productName":"混凝土"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":3,"specifications":"300t","productName":"水泥"},{"productId":1,"specifications":"C30","productName":"混凝土"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"200t","productName":"沙子"},{"productId":2,"specifications":"100t","productName":"沙子"},{"productId":2,"specifications":"100t","productName":"沙子"},{"productId":2,"specifications":"100t","productName":"沙子"},{"productId":2,"specifications":"100t","productName":"沙子"},{"productId":2,"specifications":"100t","productName":"沙子"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":1,"specifications":"C50","productName":"混凝土"},{"productId":1,"specifications":"C30","productName":"混凝土"},{"productId":1,"specifications":"C30","productName":"混凝土"},{"productId":1,"specifications":"C30","productName":"混凝土"},{"productId":1,"specifications":"C30","productName":"混凝土"},{"productId":1,"specifications":"C30","productName":"混凝土"}]
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

    public static class ResultsBean extends BaseBean {
        /**
         * productId : 2
         * specifications : 100t
         * productName : 沙子
         */

        private int productId;
        private String specifications;
        private String productName;
        private int specificationsId;
        /**
         * createTime : 1516093419000
         * materielName : 粉煤灰
         * creater : 1
         * editTime : 1516093419000
         * id : 7
         * editer : 1
         * status : 1
         */

        private long createTime;
        private String materielName;
        private int creater;
        private long editTime;
        private int id;
        private int editer;
        private int status;


        public int getSpecificationsId() {
            return specificationsId;
        }

        public void setSpecificationsId(int specificationsId) {
            this.specificationsId = specificationsId;
        }

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

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getMaterielName() {
            return materielName;
        }

        public void setMaterielName(String materielName) {
            this.materielName = materielName;
        }

        public int getCreater() {
            return creater;
        }

        public void setCreater(int creater) {
            this.creater = creater;
        }

        public long getEditTime() {
            return editTime;
        }

        public void setEditTime(long editTime) {
            this.editTime = editTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEditer() {
            return editer;
        }

        public void setEditer(int editer) {
            this.editer = editer;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
