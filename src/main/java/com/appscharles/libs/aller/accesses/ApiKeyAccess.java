package com.appscharles.libs.aller.accesses;

/**
 * The type Api key access.
 */
public class ApiKeyAccess {

    private String clientId;

    private String clientSecret;

    /**
     * Instantiates a new Api key access.
     *
     * @param clientId     the client id
     * @param clientSecret the client secret
     */
    public ApiKeyAccess(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Gets client secret.
     *
     * @return the client secret
     */
    public String getClientSecret() {
        return clientSecret;
    }
}
