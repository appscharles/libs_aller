package com.appscharles.libs.aller.models.promotions;

import java.util.List;

/**
 * The type SellerCreateRebateRequest.
 */
public class SellerCreateRebateRequest {

    private List<Benefit> benefits;

    private List<PromotionOfferCriterium> offerCriteria;

    public SellerCreateRebateRequest() {
    }

    public SellerCreateRebateRequest(List<Benefit> benefits, List<PromotionOfferCriterium> offerCriteria) {
        this.benefits = benefits;
        this.offerCriteria = offerCriteria;
    }

    /**
     * Getter for property 'benefits'.
     *
     * @return Value for property 'benefits'.
     */
    public List<Benefit> getBenefits() {
        return benefits;
    }

    /**
     * Setter for property 'benefits'.
     *
     * @param benefits Value to set for property 'benefits'.
     */
    public void setBenefits(List<Benefit> benefits) {
        this.benefits = benefits;
    }

    /**
     * Getter for property 'offerCriteria'.
     *
     * @return Value for property 'offerCriteria'.
     */
    public List<PromotionOfferCriterium> getOfferCriteria() {
        return offerCriteria;
    }

    /**
     * Setter for property 'offerCriteria'.
     *
     * @param offerCriteria Value to set for property 'offerCriteria'.
     */
    public void setOfferCriteria(List<PromotionOfferCriterium> offerCriteria) {
        this.offerCriteria = offerCriteria;
    }
}
