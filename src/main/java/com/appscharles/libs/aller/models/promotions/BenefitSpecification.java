package com.appscharles.libs.aller.models.promotions;

import com.appscharles.libs.aller.models.promotions.enums.BenefitSpecificationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The type BenefitSpecification.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BenefitSpecification {

    private BenefitSpecificationType type;

    private BenefitSpecificationValue value;

    public BenefitSpecification() {
    }

    public BenefitSpecification(BenefitSpecificationType type, BenefitSpecificationValue value) {
        this.type = type;
        this.value = value;
    }

    public BenefitSpecificationType getType() {
        return type;
    }

    public void setType(BenefitSpecificationType type) {
        this.type = type;
    }

    /**
     * Getter for property 'value'.
     *
     * @return Value for property 'value'.
     */
    public BenefitSpecificationValue getValue() {
        return value;
    }

    /**
     * Setter for property 'value'.
     *
     * @param value Value to set for property 'value'.
     */
    public void setValue(BenefitSpecificationValue value) {
        this.value = value;
    }
}
