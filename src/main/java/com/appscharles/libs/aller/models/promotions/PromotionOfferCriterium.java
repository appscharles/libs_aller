package com.appscharles.libs.aller.models.promotions;

import com.appscharles.libs.aller.models.promotions.enums.PromotionCriteriaType;

import java.util.List;

/**
 * The type Promotion offer criterium.
 */
public class PromotionOfferCriterium {

    private PromotionCriteriaType type;

    private List<PromotionOffer> offers;

    /**
     * Instantiates a new Promotion offer criterium.
     */
    public PromotionOfferCriterium() {
    }

    /**
     * Instantiates a new Promotion offer criterium.
     *
     * @param offers the offers
     * @param type   the type
     */
    public PromotionOfferCriterium(List<PromotionOffer> offers, PromotionCriteriaType type) {
        this.offers = offers;
        this.type = type;
    }

    /**
     * Gets offers.
     *
     * @return the offers
     */
    public List<PromotionOffer> getOffers() {
        return offers;
    }

    /**
     * Sets offers.
     *
     * @param offers the offers
     */
    public void setOffers(List<PromotionOffer> offers) {
        this.offers = offers;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public PromotionCriteriaType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(PromotionCriteriaType type) {
        this.type = type;
    }
}
