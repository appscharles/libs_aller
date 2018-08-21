package com.appscharles.libs.aller.models.offersListing;

import com.appscharles.libs.aller.models.offersListing.enums.Filters;

import java.util.List;

/**
 * The type Listing response filter.
 */
public class ListingResponseFilter {

    private String id;

    private Filters type;

    private String name;

    private List<ListingResponseFilterValue> values;

    private Double minValue;

    private Double maxValue;

    /**
     * Instantiates a new Listing response filter.
     */
    public ListingResponseFilter() {
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
     * Gets type.
     *
     * @return the type
     */
    public Filters getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Filters type) {
        this.type = type;
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
     * Gets values.
     *
     * @return the values
     */
    public List<ListingResponseFilterValue> getValues() {
        return values;
    }

    /**
     * Sets values.
     *
     * @param values the values
     */
    public void setValues(List<ListingResponseFilterValue> values) {
        this.values = values;
    }

    /**
     * Gets min value.
     *
     * @return the min value
     */
    public Double getMinValue() {
        return minValue;
    }

    /**
     * Sets min value.
     *
     * @param minValue the min value
     */
    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    /**
     * Gets max value.
     *
     * @return the max value
     */
    public Double getMaxValue() {
        return maxValue;
    }

    /**
     * Sets max value.
     *
     * @param maxValue the max value
     */
    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }
}
