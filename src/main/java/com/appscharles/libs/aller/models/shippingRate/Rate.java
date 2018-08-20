package com.appscharles.libs.aller.models.shippingRate;

import com.appscharles.libs.aller.models.DeliveryMethod;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 16:08
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Rate {

    private DeliveryMethod deliveryMethod;

    private Integer maxQuantityPerPackage;

    private ItemRate firstItemRate;

    private ItemRate nextItemRate;

    private ShippingTime shippingTime;

    public Rate() {
    }

    public Rate(DeliveryMethod deliveryMethod, Integer maxQuantityPerPackage, ItemRate firstItemRate, ItemRate nextItemRate, ShippingTime shippingTime) {
        this.deliveryMethod = deliveryMethod;
        this.maxQuantityPerPackage = maxQuantityPerPackage;
        this.firstItemRate = firstItemRate;
        this.nextItemRate = nextItemRate;
        this.shippingTime = shippingTime;
    }

    /**
     * Getter for property 'deliveryMethod'.
     *
     * @return Value for property 'deliveryMethod'.
     */
    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Setter for property 'deliveryMethod'.
     *
     * @param deliveryMethod Value to set for property 'deliveryMethod'.
     */
    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * Getter for property 'maxQuantityPerPackage'.
     *
     * @return Value for property 'maxQuantityPerPackage'.
     */
    public Integer getMaxQuantityPerPackage() {
        return maxQuantityPerPackage;
    }

    /**
     * Setter for property 'maxQuantityPerPackage'.
     *
     * @param maxQuantityPerPackage Value to set for property 'maxQuantityPerPackage'.
     */
    public void setMaxQuantityPerPackage(Integer maxQuantityPerPackage) {
        this.maxQuantityPerPackage = maxQuantityPerPackage;
    }

    /**
     * Getter for property 'firstItemRate'.
     *
     * @return Value for property 'firstItemRate'.
     */
    public ItemRate getFirstItemRate() {
        return firstItemRate;
    }

    /**
     * Setter for property 'firstItemRate'.
     *
     * @param firstItemRate Value to set for property 'firstItemRate'.
     */
    public void setFirstItemRate(ItemRate firstItemRate) {
        this.firstItemRate = firstItemRate;
    }

    /**
     * Getter for property 'nextItemRate'.
     *
     * @return Value for property 'nextItemRate'.
     */
    public ItemRate getNextItemRate() {
        return nextItemRate;
    }

    /**
     * Setter for property 'nextItemRate'.
     *
     * @param nextItemRate Value to set for property 'nextItemRate'.
     */
    public void setNextItemRate(ItemRate nextItemRate) {
        this.nextItemRate = nextItemRate;
    }

    /**
     * Getter for property 'shippingTime'.
     *
     * @return Value for property 'shippingTime'.
     */
    public ShippingTime getShippingTime() {
        return shippingTime;
    }

    /**
     * Setter for property 'shippingTime'.
     *
     * @param shippingTime Value to set for property 'shippingTime'.
     */
    public void setShippingTime(ShippingTime shippingTime) {
        this.shippingTime = shippingTime;
    }
}
