package com.appscharles.libs.aller.models.promotions;

import java.util.List;

/**
 * The type SellerRebates.
 */
public class SellerRebates {

    private Integer totalCount;

    private List<SellerRebate> promotions;

    public SellerRebates() {
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<SellerRebate> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<SellerRebate> promotions) {
        this.promotions = promotions;
    }
}
