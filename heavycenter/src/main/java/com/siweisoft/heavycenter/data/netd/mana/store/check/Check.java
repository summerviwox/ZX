package com.siweisoft.heavycenter.data.netd.mana.store.check;

import com.android.lib.bean.BaseBean;

public class Check extends BaseBean {

        private int warehouseId;

        private int productId;

        private float beforeAdjust ;

        private float afterAdjust;

        public Check() {
        }

        public int getWarehouseId() {
            return warehouseId;
        }

        public void setWarehouseId(int warehouseId) {
            this.warehouseId = warehouseId;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public float getBeforeAdjust() {
            return beforeAdjust;
        }

        public void setBeforeAdjust(float beforeAdjust) {
            this.beforeAdjust = beforeAdjust;
        }

        public float getAfterAdjust() {
            return afterAdjust;
        }

        public void setAfterAdjust(float afterAdjust) {
            this.afterAdjust = afterAdjust;
        }
    }