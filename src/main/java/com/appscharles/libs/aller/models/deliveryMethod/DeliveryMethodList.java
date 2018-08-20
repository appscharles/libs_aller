package com.appscharles.libs.aller.models.deliveryMethod;

import com.appscharles.libs.aller.models.DeliveryMethod;

import java.util.List;

/**
 * The type Delivery method list.
 */
public class DeliveryMethodList {

    private List<DeliveryMethod> deliveryMethods;

    /**
     * Instantiates a new Delivery method list.
     */
    public DeliveryMethodList() {
    }

    /**
     * Instantiates a new Delivery method list.
     *
     * @param deliveryMethods the delivery methods
     */
    public DeliveryMethodList(List<DeliveryMethod> deliveryMethods) {
        this.deliveryMethods = deliveryMethods;
    }

    /**
     * Gets delivery methods.
     *
     * @return the delivery methods
     */
    public List<DeliveryMethod> getDeliveryMethods() {
        return deliveryMethods;
    }

    /**
     * Sets delivery methods.
     *
     * @param deliveryMethods the delivery methods
     */
    public void setDeliveryMethods(List<DeliveryMethod> deliveryMethods) {
        this.deliveryMethods = deliveryMethods;
    }
}
