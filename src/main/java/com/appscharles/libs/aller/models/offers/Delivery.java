package com.appscharles.libs.aller.models.offers;

import java.util.Calendar;

/**
 * The type Delivery.
 */
public class Delivery {

    private String additionalInfo;

    private String handlingTime;

    private Calendar shipmentDate;

    private JustId shippingRates;

    /**
     * Instantiates a new Delivery.
     */
    public Delivery() {
    }

    public Delivery(String handlingTime, JustId shippingRates) {
        this.handlingTime = handlingTime;
        this.shippingRates = shippingRates;
    }

    /**
     * Gets additional info.
     *
     * @return the additional info
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets additional info.
     *
     * @param additionalInfo the additional info
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Gets handling time.
     *
     * @return the handling time
     */
    public String getHandlingTime() {
        return handlingTime;
    }

    /**
     * Sets handling time.
     *
     * @param handlingTime the handling time
     */
    public void setHandlingTime(String handlingTime) {
        this.handlingTime = handlingTime;
    }

    /**
     * Gets shipment date.
     *
     * @return the shipment date
     */
    public Calendar getShipmentDate() {
        return shipmentDate;
    }

    /**
     * Sets shipment date.
     *
     * @param shipmentDate the shipment date
     */
    public void setShipmentDate(Calendar shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    /**
     * Gets shipping rates.
     *
     * @return the shipping rates
     */
    public JustId getShippingRates() {
        return shippingRates;
    }

    /**
     * Sets shipping rates.
     *
     * @param shippingRates the shipping rates
     */
    public void setShippingRates(JustId shippingRates) {
        this.shippingRates = shippingRates;
    }
}
