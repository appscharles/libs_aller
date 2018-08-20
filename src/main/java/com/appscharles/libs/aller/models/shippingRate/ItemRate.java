package com.appscharles.libs.aller.models.shippingRate;

/**
 * The type Item rate.
 */
public class ItemRate {

    private String amount;

    private String currency;

    /**
     * Instantiates a new Item rate.
     */
    public ItemRate() {
    }

    /**
     * Instantiates a new Item rate.
     *
     * @param amount   the amount
     * @param currency the currency
     */
    public ItemRate(String amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(String amount) {
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
