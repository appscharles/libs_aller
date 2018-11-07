package com.appscharles.libs.aller.models.promotions;

/**
 * The type BenefitSpecificationValue.
 */
public class BenefitSpecificationValue {

    private Double amount;

    private String currency;

    public BenefitSpecificationValue() {
    }

    public BenefitSpecificationValue(Double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Getter for property 'amount'.
     *
     * @return Value for property 'amount'.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Setter for property 'amount'.
     *
     * @param amount Value to set for property 'amount'.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Getter for property 'currency'.
     *
     * @return Value for property 'currency'.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Setter for property 'currency'.
     *
     * @param currency Value to set for property 'currency'.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
