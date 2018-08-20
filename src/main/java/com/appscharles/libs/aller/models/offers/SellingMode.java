package com.appscharles.libs.aller.models.offers;

import com.appscharles.libs.aller.models.offers.enums.Format;

/**
 * The type Selling mode.
 */
public class SellingMode {

    private Format format;

    private Price minimalPrice;

    private Price price;

    private Price startingPrice;

    /**
     * Instantiates a new Selling mode.
     */
    public SellingMode() {
    }

    /**
     * Instantiates a new Selling mode.
     *
     * @param format        the format
     * @param minimalPrice  the minimal price
     * @param price         the price
     * @param startingPrice the starting price
     */
    public SellingMode(Format format, Price price) {
        this.format = format;
        this.price = price;
    }

    /**
     * Gets format.
     *
     * @return the format
     */
    public Format getFormat() {
        return format;
    }

    /**
     * Sets format.
     *
     * @param format the format
     */
    public void setFormat(Format format) {
        this.format = format;
    }

    /**
     * Gets minimal price.
     *
     * @return the minimal price
     */
    public Price getMinimalPrice() {
        return minimalPrice;
    }

    /**
     * Sets minimal price.
     *
     * @param minimalPrice the minimal price
     */
    public void setMinimalPrice(Price minimalPrice) {
        this.minimalPrice = minimalPrice;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Price getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Price price) {
        this.price = price;
    }

    /**
     * Gets starting price.
     *
     * @return the starting price
     */
    public Price getStartingPrice() {
        return startingPrice;
    }

    /**
     * Sets starting price.
     *
     * @param startingPrice the starting price
     */
    public void setStartingPrice(Price startingPrice) {
        this.startingPrice = startingPrice;
    }
}
