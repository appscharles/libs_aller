package com.appscharles.libs.aller.models.offersListing;

import java.util.List;

/**
 * The type Offer seller contact.
 */
public class OfferSellerContact {

    private List<OfferSellerContactPhone> phones;

    /**
     * Instantiates a new Offer seller contact.
     */
    public OfferSellerContact() {
    }

    /**
     * Gets phones.
     *
     * @return the phones
     */
    public List<OfferSellerContactPhone> getPhones() {
        return phones;
    }

    /**
     * Sets phones.
     *
     * @param phones the phones
     */
    public void setPhones(List<OfferSellerContactPhone> phones) {
        this.phones = phones;
    }
}
