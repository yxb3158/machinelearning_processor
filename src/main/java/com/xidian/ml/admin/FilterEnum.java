package com.xidian.ml.admin;


/**
 * Created by yxb on 2017/11/30.
 */
public enum FilterEnum {
    //商家劵
    COUNT_PER_PACKAGE_POI_COUPON_FILTER_TYPE(1, "asdf"),
    DISCOUNT_RATE_POI_COUPON_FILTER_TYPE(2, "qwert"),
    EXCLUDE_NEW_CUSTOMER_POI_COUPON_FILTER_TYPE(3, "新客券"),
    MIN_PRICE_POI_COUPON_FILTER_TYPE(4, "金额");


    private int filterType;
    private String filterName;

    FilterEnum(int filterType, String filterName) {
        this.filterType = filterType;
        this.filterName = filterName;
    }

    public int getFilterType() {
        return filterType;
    }

    public void setFilterType(int filterType) {
        this.filterType = filterType;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public static String getFilterNameById(int id) {
        FilterEnum[] filterEnums = FilterEnum.values();
        for (FilterEnum filterEnum : filterEnums) {
            if (filterEnum.getFilterType() == id) {
                return filterEnum.getFilterName();
            }
        }
        return null;
    }

}
