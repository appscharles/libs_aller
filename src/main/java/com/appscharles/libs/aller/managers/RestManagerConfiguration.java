package com.appscharles.libs.aller.managers;

import java.net.URL;

/**
 * The type Rest manager configuration.
 */
public class RestManagerConfiguration {

    private URL urlCallMethod;

    private TokenManagerConfiguration tokenManagerConfiguration;

    /**
     * Instantiates a new Rest manager configuration.
     *
     * @param urlCallMethod             the url call method
     * @param tokenManagerConfiguration the token manager configuration
     */
    public RestManagerConfiguration(URL urlCallMethod, TokenManagerConfiguration tokenManagerConfiguration) {
        this.urlCallMethod = urlCallMethod;
        this.tokenManagerConfiguration = tokenManagerConfiguration;
    }

    /**
     * Gets url call method.
     *
     * @return the url call method
     */
    public URL getUrlCallMethod() {
        return urlCallMethod;
    }

    /**
     * Gets token manager configuration.
     *
     * @return the token manager configuration
     */
    public TokenManagerConfiguration getTokenManagerConfiguration() {
        return tokenManagerConfiguration;
    }
}
