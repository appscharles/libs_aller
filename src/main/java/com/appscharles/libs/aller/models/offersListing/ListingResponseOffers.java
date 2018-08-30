package com.appscharles.libs.aller.models.offersListing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * The type Listing response offers.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingResponseOffers {

    private List<ListingOffer> promoted;

    private List<ListingOffer> regular;

    /**
     * Instantiates a new Listing response offers.
     */
    public ListingResponseOffers() {
    }

    /**
     * Gets promoted.
     *
     * @return the promoted
     */
    public List<ListingOffer> getPromoted() {
        return promoted;
    }

    /**
     * Sets promoted.
     *
     * @param promoted the promoted
     */
    public void setPromoted(List<ListingOffer> promoted) {
        this.promoted = promoted;
    }

    /**
     * Gets regular.
     *
     * @return the regular
     */
    public List<ListingOffer> getRegular() {
        return regular;
    }

    /**
     * Sets regular.
     *
     * @param regular the regular
     */
    public void setRegular(List<ListingOffer> regular) {
        this.regular = regular;
    }
}
