package com.appscharles.libs.aller.models;

import com.appscharles.libs.aller.models.shippingRate.Rate;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 15:45
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ShippingRate {

    private String id;

    private String name;

    private List<Rate> rates;

    private String lastModified;

    public ShippingRate() {
    }

    public ShippingRate(String name, List<Rate> rates) {
        this.name = name;
        this.rates = rates;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'lastModified'.
     *
     * @return Value for property 'lastModified'.
     */
    public String getLastModified() {
        return lastModified;
    }

    /**
     * Setter for property 'lastModified'.
     *
     * @param lastModified Value to set for property 'lastModified'.
     */
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Getter for property 'rates'.
     *
     * @return Value for property 'rates'.
     */
    public List<Rate> getRates() {
        return rates;
    }

    /**
     * Setter for property 'rates'.
     *
     * @param rates Value to set for property 'rates'.
     */
    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
