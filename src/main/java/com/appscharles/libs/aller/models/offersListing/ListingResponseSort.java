package com.appscharles.libs.aller.models.offersListing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The type Listing response sort.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingResponseSort {

    private String value;

    private String name;

    private String order;

    private Boolean selected;

    /**
     * Instantiates a new Listing response sort.
     */
    public ListingResponseSort() {
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
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
     * Gets order.
     *
     * @return the order
     */
    public String getOrder() {
        return order;
    }

    /**
     * Sets order.
     *
     * @param order the order
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * Gets selected.
     *
     * @return the selected
     */
    public Boolean getSelected() {
        return selected;
    }

    /**
     * Sets selected.
     *
     * @param selected the selected
     */
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
