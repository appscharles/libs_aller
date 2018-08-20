package com.appscharles.libs.aller.models.pointsOfServices;

import com.appscharles.libs.aller.models.pointsOfServices.enums.MethodPayment;

/**
 * The type Payment.
 */
public class Payment {

    private MethodPayment method;

    /**
     * Instantiates a new Payment.
     */
    public Payment() {
    }

    /**
     * Instantiates a new Payment.
     *
     * @param method the method
     */
    public Payment(MethodPayment method) {
        this.method = method;
    }

    /**
     * Gets method.
     *
     * @return the method
     */
    public MethodPayment getMethod() {
        return method;
    }

    /**
     * Sets method.
     *
     * @param method the method
     */
    public void setMethod(MethodPayment method) {
        this.method = method;
    }
}
