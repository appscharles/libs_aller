package com.appscharles.libs.aller.models.shippingRate;

import com.appscharles.libs.aller.models.ShippingRate;

import java.util.List;

/**
 * The type Delivery method list.
 */
public class ShippingRateList {

    private List<ShippingRate> shippingRates;

    /**
     * Instantiates a new Delivery method list.
     */
    public ShippingRateList() {
    }

    public ShippingRateList(List<ShippingRate> shippingRates) {
        this.shippingRates = shippingRates;
    }

    /**
     * Getter for property 'shippingRates'.
     *
     * @return Value for property 'shippingRates'.
     */
    public List<ShippingRate> getShippingRates() {
        return shippingRates;
    }

    /**
     * Setter for property 'shippingRates'.
     *
     * @param shippingRates Value to set for property 'shippingRates'.
     */
    public void setShippingRates(List<ShippingRate> shippingRates) {
        this.shippingRates = shippingRates;
    }
}
