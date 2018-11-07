package com.appscharles.libs.aller.models.promotions;

/**
 * The type Offer id.
 */
public class PromotionOffer {

    private String id;

    private Integer quantity;

    private Boolean promotionEntryPoint;

    /**
     * Instantiates a new Offer id.
     */
    public PromotionOffer() {
    }

    /**
     * Instantiates a new Offer id.
     *
     * @param id                  the id
     * @param quantity            the quantity
     * @param promotionEntryPoint the promotion entry point
     */
    public PromotionOffer(String id, Integer quantity, Boolean promotionEntryPoint) {
        this.id = id;
        this.quantity = quantity;
        this.promotionEntryPoint = promotionEntryPoint;
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
     * Gets quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets promotion entry point.
     *
     * @return the promotion entry point
     */
    public Boolean getPromotionEntryPoint() {
        return promotionEntryPoint;
    }

    /**
     * Sets promotion entry point.
     *
     * @param promotionEntryPoint the promotion entry point
     */
    public void setPromotionEntryPoint(Boolean promotionEntryPoint) {
        this.promotionEntryPoint = promotionEntryPoint;
    }
}
