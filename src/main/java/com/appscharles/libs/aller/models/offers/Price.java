package com.appscharles.libs.aller.models.offers;

/**
 * The type Price.
 */
public class Price {

    private String amount;

    private String currency;

    /**
     * Instantiates a new Price.
     */
    public Price() {
    }

    /**
     * Instantiates a new Price.
     *
     * @param amount   the amount
     * @param currency the currency
     */
    public Price(String amount, String currency) {
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
