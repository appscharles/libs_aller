package com.appscharles.libs.aller.managers;

import java.net.URL;

/**
 * The type Rest manager configuration.
 */
public class RestManagerConfiguration {

    private URL urlCallMethod;

    private LimitManagerConfiguration limitManagerConfiguration;

    private TokenManagerConfiguration tokenManagerConfiguration;

    /**
     * Instantiates a new Rest manager configuration.
     *
     * @param urlCallMethod             the url call method
     * @param limitManagerConfiguration the limit manager configuration
     * @param tokenManagerConfiguration the token manager configuration
     */
    public RestManagerConfiguration(URL urlCallMethod, LimitManagerConfiguration limitManagerConfiguration,  TokenManagerConfiguration tokenManagerConfiguration) {
        this.urlCallMethod = urlCallMethod;
        this.limitManagerConfiguration = limitManagerConfiguration;
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
     * Gets limit manager configuration.
     *
     * @return the limit manager configuration
     */
    public LimitManagerConfiguration getLimitManagerConfiguration() {
        return limitManagerConfiguration;
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
