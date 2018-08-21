package com.appscharles.libs.aller.models.offersListing;

/**
 * The type Offer seller.
 */
public class OfferSeller {

    private String id;

    private boolean company;

    private boolean superSeller;

    private OfferSellerContact contact;

    /**
     * Instantiates a new Offer seller.
     */
    public OfferSeller() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Is company boolean.
     *
     * @return the boolean
     */
    public boolean isCompany() {
        return company;
    }

    /**
     * Sets company.
     *
     * @param company the company
     */
    public void setCompany(boolean company) {
        this.company = company;
    }

    /**
     * Is super seller boolean.
     *
     * @return the boolean
     */
    public boolean isSuperSeller() {
        return superSeller;
    }

    /**
     * Sets super seller.
     *
     * @param superSeller the super seller
     */
    public void setSuperSeller(boolean superSeller) {
        this.superSeller = superSeller;
    }

    /**
     * Gets contact.
     *
     * @return the contact
     */
    public OfferSellerContact getContact() {
        return contact;
    }

    /**
     * Sets contact.
     *
     * @param contact the contact
     */
    public void setContact(OfferSellerContact contact) {
        this.contact = contact;
    }
}
