package com.appscharles.libs.aller.models.offersListing;

/**
 * The type Offer price.
 */
public class OfferPrice {

    private Double amount;

    private String currency;

    /**
     * Instantiates a new Offer price.
     */
    public OfferPrice() {
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
