package com.appscharles.libs.aller.senders.rest;

/**
 * The enum Api version.
 */
public enum ApiVersion {

    /**
     * Beta v 1 api version.
     */
    BETA_V1("beta.v1"), /**
     * Public v 1 api version.
     */
    PUBLIC_V1("public.v1"), /**
     * Beta v 2 api version.
     */
    BETA_V2("beta.v2");

    ApiVersion(String name) {
        this.name = name;
    }

    private final String name;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }
}
