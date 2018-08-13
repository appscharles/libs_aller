package com.appscharles.libs.aller.getters;

/**
 * The type Abstract authorize code getter.
 */
public abstract class AbstractAuthorizeCodeGetter implements IAuthorizeCodeGetter, ISetTestable {

    protected Boolean test;

    /**
     * Instantiates a new Abstract authorize code getter.
     */
    public AbstractAuthorizeCodeGetter() {
        this.test = false;
    }

    /**
     * Enable test.
     */
    public void enableTest() {
        this.test = true;
    }
}
