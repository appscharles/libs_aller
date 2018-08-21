package com.appscharles.libs.aller.models.offersListing;

/**
 * The type Offer lowest price.
 */
public class OfferLowestPrice {

    private Double amount;

    private String currency;

    /**
     * Instantiates a new Offer lowest price.
     */
    public OfferLowestPrice() {
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
