package com.appscharles.libs.aller.models.offersListing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The type Listing response filter value.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingResponseFilterValue {

    private String name;

    private String value;

    private String idSuffix;

    private Integer count;

    private Boolean selected;

    /**
     * Instantiates a new Listing response filter value.
     */
    public ListingResponseFilterValue() {
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
     * Gets id suffix.
     *
     * @return the id suffix
     */
    public String getIdSuffix() {
        return idSuffix;
    }

    /**
     * Sets id suffix.
     *
     * @param idSuffix the id suffix
     */
    public void setIdSuffix(String idSuffix) {
        this.idSuffix = idSuffix;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(Integer count) {
        this.count = count;
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
