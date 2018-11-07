package com.appscharles.libs.aller.models.promotions;

/**
 * The type Benefit.
 */
public class Benefit {

    private BenefitSpecification specification;

    public Benefit() {
    }

    public Benefit(BenefitSpecification specification) {
        this.specification = specification;
    }

    /**
     * Getter for property 'specification'.
     *
     * @return Value for property 'specification'.
     */
    public BenefitSpecification getSpecification() {
        return specification;
    }

    /**
     * Setter for property 'specification'.
     *
     * @param specification Value to set for property 'specification'.
     */
    public void setSpecification(BenefitSpecification specification) {
        this.specification = specification;
    }
}
