package com.appscharles.libs.aller.models.offers;

import com.appscharles.libs.aller.models.offers.enums.Unit;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 14:22
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Stock {

    private Integer available;

    private Unit unit;

    public Stock() {
    }

    public Stock(Integer available, Unit unit) {
        this.available = available;
        this.unit = unit;
    }

    /**
     * Getter for property 'available'.
     *
     * @return Value for property 'available'.
     */
    public Integer getAvailable() {
        return available;
    }

    /**
     * Setter for property 'available'.
     *
     * @param available Value to set for property 'available'.
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }

    /**
     * Getter for property 'unit'.
     *
     * @return Value for property 'unit'.
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Setter for property 'unit'.
     *
     * @param unit Value to set for property 'unit'.
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
