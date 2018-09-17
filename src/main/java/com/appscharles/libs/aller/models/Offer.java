package com.appscharles.libs.aller.models;

import com.appscharles.libs.aller.models.offers.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Calendar;
import java.util.List;

/**
 * The type Offer.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Offer {

    private String id;

    private String name;

    private Category category;

    private List<Parameter> parameters;

    private String ean;

    private OfferDescription description;

    private CompatibilityList compatibilityList;

    private List<ImageUrl> images;

    private SellingMode sellingMode;

    private Stock stock;

    private Publication publication;

    private Delivery delivery;

    private Payments payments;

    private AfterSalesServices afterSalesServices;

    private JustId additionalServices;

    private JustId sizeTable;

    private Promotion promotion;

    private Location location;

    private JustId external;

    private JustId contact;

    private Validation validation;

    private Calendar createdAt;

    private Calendar updatedAt;

    /**
     * Instantiates a new Offer.
     */
    public Offer() {
    }

    /**
     * Instantiates a new Offer.
     *
     * @param name        the name
     * @param category    the category
     * @param description the description
     * @param sellingMode the selling mode
     * @param stock       the stock
     * @param payments    the payments
     * @param location    the location
     */
    public Offer(String name, Category category, List<Parameter> parameters, OfferDescription description, SellingMode sellingMode, Stock stock, Delivery delivery, Payments payments, Location location) {
        this.name = name;
        this.category = category;
        this.parameters = parameters;
        this.description = description;
        this.sellingMode = sellingMode;
        this.stock = stock;
        this.delivery = delivery;
        this.payments = payments;
        this.location = location;
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
     * Gets category.
     *
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets parameters.
     *
     * @return the parameters
     */
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * Sets parameters.
     *
     * @param parameters the parameters
     */
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * Gets ean.
     *
     * @return the ean
     */
    public String getEan() {
        return ean;
    }

    /**
     * Sets ean.
     *
     * @param ean the ean
     */
    public void setEan(String ean) {
        this.ean = ean;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public OfferDescription getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(OfferDescription description) {
        this.description = description;
    }

    /**
     * Gets compatibility list.
     *
     * @return the compatibility list
     */
    public CompatibilityList getCompatibilityList() {
        return compatibilityList;
    }

    /**
     * Sets compatibility list.
     *
     * @param compatibilityList the compatibility list
     */
    public void setCompatibilityList(CompatibilityList compatibilityList) {
        this.compatibilityList = compatibilityList;
    }

    /**
     * Gets images.
     *
     * @return the images
     */
    public List<ImageUrl> getImages() {
        return images;
    }

    /**
     * Sets images.
     *
     * @param images the images
     */
    public void setImages(List<ImageUrl> images) {
        this.images = images;
    }

    /**
     * Gets selling mode.
     *
     * @return the selling mode
     */
    public SellingMode getSellingMode() {
        return sellingMode;
    }

    /**
     * Sets selling mode.
     *
     * @param sellingMode the selling mode
     */
    public void setSellingMode(SellingMode sellingMode) {
        this.sellingMode = sellingMode;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    /**
     * Gets publication.
     *
     * @return the publication
     */
    public Publication getPublication() {
        return publication;
    }

    /**
     * Sets publication.
     *
     * @param publication the publication
     */
    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    /**
     * Gets delivery.
     *
     * @return the delivery
     */
    public Delivery getDelivery() {
        return delivery;
    }

    /**
     * Sets delivery.
     *
     * @param delivery the delivery
     */
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    /**
     * Gets payments.
     *
     * @return the payments
     */
    public Payments getPayments() {
        return payments;
    }

    /**
     * Sets payments.
     *
     * @param payments the payments
     */
    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    /**
     * Gets after sales services.
     *
     * @return the after sales services
     */
    public AfterSalesServices getAfterSalesServices() {
        return afterSalesServices;
    }

    /**
     * Sets after sales services.
     *
     * @param afterSalesServices the after sales services
     */
    public void setAfterSalesServices(AfterSalesServices afterSalesServices) {
        this.afterSalesServices = afterSalesServices;
    }

    /**
     * Gets additional services.
     *
     * @return the additional services
     */
    public JustId getAdditionalServices() {
        return additionalServices;
    }

    /**
     * Sets additional services.
     *
     * @param additionalServices the additional services
     */
    public void setAdditionalServices(JustId additionalServices) {
        this.additionalServices = additionalServices;
    }

    /**
     * Gets size table.
     *
     * @return the size table
     */
    public JustId getSizeTable() {
        return sizeTable;
    }

    /**
     * Sets size table.
     *
     * @param sizeTable the size table
     */
    public void setSizeTable(JustId sizeTable) {
        this.sizeTable = sizeTable;
    }

    /**
     * Gets promotion.
     *
     * @return the promotion
     */
    public Promotion getPromotion() {
        return promotion;
    }

    /**
     * Sets promotion.
     *
     * @param promotion the promotion
     */
    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Gets external.
     *
     * @return the external
     */
    public JustId getExternal() {
        return external;
    }

    /**
     * Sets external.
     *
     * @param external the external
     */
    public void setExternal(JustId external) {
        this.external = external;
    }

    /**
     * Gets contact.
     *
     * @return the contact
     */
    public JustId getContact() {
        return contact;
    }

    /**
     * Sets contact.
     *
     * @param contact the contact
     */
    public void setContact(JustId contact) {
        this.contact = contact;
    }

    /**
     * Gets validation.
     *
     * @return the validation
     */
    public Validation getValidation() {
        return validation;
    }

    /**
     * Sets validation.
     *
     * @param validation the validation
     */
    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Calendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updated at.
     *
     * @return the updated at
     */
    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }
}
