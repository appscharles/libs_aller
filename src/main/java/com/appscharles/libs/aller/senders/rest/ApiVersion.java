package com.appscharles.libs.aller.senders.rest;

/**
 * The enum Api version.
 */
public enum ApiVersion {

    /**
     * V 1 api version.
     */
    V1("v1"),
    /**
     * V 2 api version.
     */
    V2("v2");

    ApiVersion(String version) {
        this.version = version;
    }

    private final String version;

    /**
     * Gets version.
     *
     * @return the version
     */
    public String getVersion() {
        return this.version;
    }
}
