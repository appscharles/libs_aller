package com.appscharles.libs.aller.models.offersListing;

/**
 * The type Offer delivery.
 */
public class OfferDelivery {

    private boolean availableForFree;

    private OfferLowestPrice lowestPrice;

    /**
     * Instantiates a new Offer delivery.
     */
    public OfferDelivery() {
    }

    /**
     * Gets available for free.
     *
     * @return the available for free
     */
    public boolean getAvailableForFree() {
        return availableForFree;
    }

    /**
     * Sets available for free.
     *
     * @param availableForFree the available for free
     */
    public void setAvailableForFree(boolean availableForFree) {
        this.availableForFree = availableForFree;
    }

    /**
     * Gets lowest price.
     *
     * @return the lowest price
     */
    public OfferLowestPrice getLowestPrice() {
        return lowestPrice;
    }

    /**
     * Sets lowest price.
     *
     * @param lowestPrice the lowest price
     */
    public void setLowestPrice(OfferLowestPrice lowestPrice) {
        this.lowestPrice = lowestPrice;
    }
}
