package com.appscharles.libs.aller.models.shippingRate;

/**
 * The type Shipping time.
 */
public class ShippingTime {

    private String from;

    private String to;

    /**
     * Instantiates a new Shipping time.
     */
    public ShippingTime() {
    }

    /**
     * Instantiates a new Shipping time.
     *
     * @param from the from
     * @param to   the to
     */
    public ShippingTime(String from, String to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Gets from.
     *
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets from.
     *
     * @param from the from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(String to) {
        this.to = to;
    }
}
