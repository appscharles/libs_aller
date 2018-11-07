package com.appscharles.libs.aller.models.promotions;

import com.appscharles.libs.aller.models.promotions.enums.SellerRebateStatus;

import java.util.Calendar;
import java.util.List;

/**
 * The type Seller rebate.
 */
public class SellerRebate {

    private String id;

    private List<Benefit> benefits;

    private SellerRebateStatus status;

    private List<PromotionOfferCriterium> offerCriteria;

    private Calendar createdAt;

    /**
     * Instantiates a new Seller rebate.
     */
    public SellerRebate() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets benefits.
     *
     * @return the benefits
     */
    public List<Benefit> getBenefits() {
        return benefits;
    }

    /**
     * Sets benefits.
     *
     * @param benefits the benefits
     */
    public void setBenefits(List<Benefit> benefits) {
        this.benefits = benefits;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public SellerRebateStatus getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(SellerRebateStatus status) {
        this.status = status;
    }

    /**
     * Gets offer criteria.
     *
     * @return the offer criteria
     */
    public List<PromotionOfferCriterium> getOfferCriteria() {
        return offerCriteria;
    }

    /**
     * Sets offer criteria.
     *
     * @param offerCriteria the offer criteria
     */
    public void setOfferCriteria(List<PromotionOfferCriterium> offerCriteria) {
        this.offerCriteria = offerCriteria;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Calendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }
}
