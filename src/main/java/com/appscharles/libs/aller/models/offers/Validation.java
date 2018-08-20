package com.appscharles.libs.aller.models.offers;

import java.util.Calendar;
import java.util.List;

/**
 * The type Validation.
 */
public class Validation {

    /**
     * The Errors.
     */
    List<ValidationError> errors;

    private Calendar validatedAt;

    /**
     * Instantiates a new Validation.
     */
    public Validation() {
    }

    /**
     * Instantiates a new Validation.
     *
     * @param errors      the errors
     * @param validatedAt the validated at
     */
    public Validation(List<ValidationError> errors, Calendar validatedAt) {
        this.errors = errors;
        this.validatedAt = validatedAt;
    }

    /**
     * Gets errors.
     *
     * @return the errors
     */
    public List<ValidationError> getErrors() {
        return errors;
    }

    /**
     * Sets errors.
     *
     * @param errors the errors
     */
    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }

    /**
     * Gets validated at.
     *
     * @return the validated at
     */
    public Calendar getValidatedAt() {
        return validatedAt;
    }

    /**
     * Sets validated at.
     *
     * @param validatedAt the validated at
     */
    public void setValidatedAt(Calendar validatedAt) {
        this.validatedAt = validatedAt;
    }
}
