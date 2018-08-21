package com.appscharles.libs.aller.models.offersListing;

import com.appscharles.libs.aller.models.offers.enums.Format;

/**
 * The type Offer selling mode.
 */
public class OfferSellingMode {

    private Format format;

    private OfferPrice price;

    private OfferFixedPrice fixedPrice;

    private Integer popularity;

    private Integer bidCount;

    /**
     * Instantiates a new Offer selling mode.
     */
    public OfferSellingMode() {
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
     * Gets price.
     *
     * @return the price
     */
    public OfferPrice getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(OfferPrice price) {
        this.price = price;
    }

    /**
     * Gets fixed price.
     *
     * @return the fixed price
     */
    public OfferFixedPrice getFixedPrice() {
        return fixedPrice;
    }

    /**
     * Sets fixed price.
     *
     * @param fixedPrice the fixed price
     */
    public void setFixedPrice(OfferFixedPrice fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    /**
     * Gets popularity.
     *
     * @return the popularity
     */
    public Integer getPopularity() {
        return popularity;
    }

    /**
     * Sets popularity.
     *
     * @param popularity the popularity
     */
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    /**
     * Gets bid count.
     *
     * @return the bid count
     */
    public Integer getBidCount() {
        return bidCount;
    }

    /**
     * Sets bid count.
     *
     * @param bidCount the bid count
     */
    public void setBidCount(Integer bidCount) {
        this.bidCount = bidCount;
    }
}
