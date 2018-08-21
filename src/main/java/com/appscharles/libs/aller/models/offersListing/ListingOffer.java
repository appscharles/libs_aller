package com.appscharles.libs.aller.models.offersListing;

import java.util.List;

/**
 * The type Listing offer.
 */
public class ListingOffer {

    private String id;

    private String name;

    private OfferSeller seller;

    private OfferPromotion promotion;

    private OfferDelivery delivery;

    private List<OfferImage> images;

    private OfferSellingMode sellingMode;

    private OfferStock stock;

    private OfferVendor vendor;

    private OfferCategory category;

    private OfferPublication publication;

    /**
     * Instantiates a new Listing offer.
     */
    public ListingOffer() {
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets seller.
     *
     * @return the seller
     */
    public OfferSeller getSeller() {
        return seller;
    }

    /**
     * Sets seller.
     *
     * @param seller the seller
     */
    public void setSeller(OfferSeller seller) {
        this.seller = seller;
    }

    /**
     * Gets promotion.
     *
     * @return the promotion
     */
    public OfferPromotion getPromotion() {
        return promotion;
    }

    /**
     * Sets promotion.
     *
     * @param promotion the promotion
     */
    public void setPromotion(OfferPromotion promotion) {
        this.promotion = promotion;
    }

    /**
     * Gets delivery.
     *
     * @return the delivery
     */
    public OfferDelivery getDelivery() {
        return delivery;
    }

    /**
     * Sets delivery.
     *
     * @param delivery the delivery
     */
    public void setDelivery(OfferDelivery delivery) {
        this.delivery = delivery;
    }

    /**
     * Gets images.
     *
     * @return the images
     */
    public List<OfferImage> getImages() {
        return images;
    }

    /**
     * Sets images.
     *
     * @param images the images
     */
    public void setImages(List<OfferImage> images) {
        this.images = images;
    }

    /**
     * Gets selling mode.
     *
     * @return the selling mode
     */
    public OfferSellingMode getSellingMode() {
        return sellingMode;
    }

    /**
     * Sets selling mode.
     *
     * @param sellingMode the selling mode
     */
    public void setSellingMode(OfferSellingMode sellingMode) {
        this.sellingMode = sellingMode;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public OfferStock getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(OfferStock stock) {
        this.stock = stock;
    }

    /**
     * Gets vendor.
     *
     * @return the vendor
     */
    public OfferVendor getVendor() {
        return vendor;
    }

    /**
     * Sets vendor.
     *
     * @param vendor the vendor
     */
    public void setVendor(OfferVendor vendor) {
        this.vendor = vendor;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public OfferCategory getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(OfferCategory category) {
        this.category = category;
    }

    /**
     * Gets publication.
     *
     * @return the publication
     */
    public OfferPublication getPublication() {
        return publication;
    }

    /**
     * Sets publication.
     *
     * @param publication the publication
     */
    public void setPublication(OfferPublication publication) {
        this.publication = publication;
    }
}
