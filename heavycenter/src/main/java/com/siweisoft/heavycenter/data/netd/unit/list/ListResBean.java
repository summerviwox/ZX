package com.siweisoft.heavycenter.data.netd.unit.list;

//by summer on 2018-01-10.

import com.android.lib.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

public class ListResBean extends BaseBean {


    /**
     * totalCount : 34
     * pageIndex : 0
     * pageCount : 2
     * pageSize : 20
     * results : [{"businessLicense":"","belongArea":"210000","companyName":"huluwaCompany7","remark":"","editTime":"","companyUrl":"","companyLng":0,"highCompany":32,"creditLevel":"","companyPropery":"","companyFax":"","id":36,"companyLat":0,"abbreviationName":"huluwa7","companyType":0,"contactId":0,"contactName":"huluwa","companyStatus":"0","postcode":"","taxRegistration":"","yhNum":1,"organizationCode":"","createTime":1515492446000,"companyAddress":"国和路与清源环路交叉口东南50米","creater":111,"companyPostbox":"","editer":0,"contactPhone":"13000000000","cpNum":0,"isMarket":0,"status":1},{"businessLicense":"","belongArea":"230000","companyName":"huluwaCompany6","remark":"","editTime":"","companyUrl":"","companyLng":0,"highCompany":32,"creditLevel":"","companyPropery":"","companyFax":"","id":35,"companyLat":0,"abbreviationName":"hulu6","companyType":0,"contactId":0,"contactName":"huluwa","companyStatus":"0","postcode":"","taxRegistration":"","yhNum":0,"organizationCode":"","createTime":1515491628000,"companyAddress":"上海市杨浦区国和路587号","creater":111,"companyPostbox":"","editer":0,"contactPhone":"13000000000","cpNum":0,"isMarket":0,"status":1}]
     */

    private int totalCount;
    private int pageIndex;
    private int pageCount;
    private int pageSize;
    private List<UnitInfo> results = new ArrayList<>();

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

    public List<UnitInfo> getResults() {
        return results;
    }

    public void setResults(List<UnitInfo> results) {
        this.results = results;
    }


}
