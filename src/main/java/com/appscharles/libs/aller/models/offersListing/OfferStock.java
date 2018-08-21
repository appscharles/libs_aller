package com.appscharles.libs.aller.models.offersListing;

import com.appscharles.libs.aller.models.offers.enums.Unit;

/**
 * The type Offer stock.
 */
public class OfferStock {

    private Unit unit;

    private Integer available;

    /**
     * Instantiates a new Offer stock.
     */
    public OfferStock() {
    }

    /**
     * Gets unit.
     *
     * @return the unit
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Sets unit.
     *
     * @param unit the unit
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * Gets available.
     *
     * @return the available
     */
    public Integer getAvailable() {
        return available;
    }

    /**
     * Sets available.
     *
     * @param available the available
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }
}
