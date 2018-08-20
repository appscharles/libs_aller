package com.appscharles.libs.aller.models.offers;

/**
 * The type After sales services.
 */
public class AfterSalesServices {

    private JustId impliedWarranty;

    private JustId returnPolicy;

    private JustId warranty;

    /**
     * Instantiates a new After sales services.
     */
    public AfterSalesServices() {
    }

    /**
     * Instantiates a new After sales services.
     *
     * @param impliedWarranty the implied warranty
     * @param returnPolicy    the return policy
     * @param warranty        the warranty
     */
    public AfterSalesServices(JustId impliedWarranty, JustId returnPolicy, JustId warranty) {
        this.impliedWarranty = impliedWarranty;
        this.returnPolicy = returnPolicy;
        this.warranty = warranty;
    }

    /**
     * Gets implied warranty.
     *
     * @return the implied warranty
     */
    public JustId getImpliedWarranty() {
        return impliedWarranty;
    }

    /**
     * Sets implied warranty.
     *
     * @param impliedWarranty the implied warranty
     */
    public void setImpliedWarranty(JustId impliedWarranty) {
        this.impliedWarranty = impliedWarranty;
    }

    /**
     * Gets return policy.
     *
     * @return the return policy
     */
    public JustId getReturnPolicy() {
        return returnPolicy;
    }

    /**
     * Sets return policy.
     *
     * @param returnPolicy the return policy
     */
    public void setReturnPolicy(JustId returnPolicy) {
        this.returnPolicy = returnPolicy;
    }

    /**
     * Gets warranty.
     *
     * @return the warranty
     */
    public JustId getWarranty() {
        return warranty;
    }

    /**
     * Sets warranty.
     *
     * @param warranty the warranty
     */
    public void setWarranty(JustId warranty) {
        this.warranty = warranty;
    }
}
