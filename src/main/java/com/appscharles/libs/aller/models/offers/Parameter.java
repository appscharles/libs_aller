package com.appscharles.libs.aller.models.offers;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Parameter.
 */
public class Parameter {

    private String id;

    private ParameterRangeValue rangeValue;

    private List<String> values;

    private List<String> valuesIds;

    /**
     * Instantiates a new Parameter.
     */
    public Parameter() {
    }

    /**
     * Instantiates a new Parameter.
     *
     * @param id the id
     */
    public Parameter(String id, List<String> valuesIds) {
        this.id = id;
        this.values = new ArrayList<>();
        this.valuesIds = valuesIds;
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
     * Gets range value.
     *
     * @return the range value
     */
    public ParameterRangeValue getRangeValue() {
        return rangeValue;
    }

    /**
     * Sets range value.
     *
     * @param rangeValue the range value
     */
    public void setRangeValue(ParameterRangeValue rangeValue) {
        this.rangeValue = rangeValue;
    }

    /**
     * Gets values.
     *
     * @return the values
     */
    public List<String> getValues() {
        return values;
    }

    /**
     * Sets values.
     *
     * @param values the values
     */
    public void setValues(List<String> values) {
        this.values = values;
    }

    /**
     * Gets values ids.
     *
     * @return the values ids
     */
    public List<String> getValuesIds() {
        return valuesIds;
    }

    /**
     * Sets values ids.
     *
     * @param valuesIds the values ids
     */
    public void setValuesIds(List<String> valuesIds) {
        this.valuesIds = valuesIds;
    }
}
