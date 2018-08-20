package com.appscharles.libs.aller.managers;

import java.io.File;
import java.net.URL;

/**
 * The type Token manager configuration.
 */
public class TokenManagerConfiguration {

    private String clientId;

    private String clientSecret;

    private URL authorizationEndPoint;

    private Integer[] redirectPorts;

    private String htmlSuccessResponse;

    private File fileConfigurationsTokens;

    private String saltPassword;

    /**
     * Instantiates a new Token manager configuration.
     *
     * @param clientId                 the client id
     * @param clientSecret             the client secret
     * @param authorizationEndPoint    the authorization end point
     * @param redirectPorts            the redirect ports
     * @param fileConfigurationsTokens the file configurations tokens
     * @param saltPassword             the salt password
     */
    public TokenManagerConfiguration(String clientId, String clientSecret, URL authorizationEndPoint, Integer[] redirectPorts, File fileConfigurationsTokens, String saltPassword) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorizationEndPoint = authorizationEndPoint;
        this.redirectPorts = redirectPorts;
        this.fileConfigurationsTokens = fileConfigurationsTokens;
        this.saltPassword = saltPassword;
        this.htmlSuccessResponse = "OK";
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

    /**
     * Gets authorization end point.
     *
     * @return the authorization end point
     */
    public URL getAuthorizationEndPoint() {
        return authorizationEndPoint;
    }

    /**
     * Get redirect ports integer [ ].
     *
     * @return the integer [ ]
     */
    public Integer[] getRedirectPorts() {
        return redirectPorts;
    }

    /**
     * Gets html success response.
     *
     * @return the html success response
     */
    public String getHtmlSuccessResponse() {
        return htmlSuccessResponse;
    }

    /**
     * Sets html success response.
     *
     * @param htmlSuccessResponse the html success response
     */
    public void setHtmlSuccessResponse(String htmlSuccessResponse) {
        this.htmlSuccessResponse = htmlSuccessResponse;
    }

    /**
     * Gets file configurations tokens.
     *
     * @return the file configurations tokens
     */
    public File getFileConfigurationsTokens() {
        return fileConfigurationsTokens;
    }

    /**
     * Gets salt password.
     *
     * @return the salt password
     */
    public String getSaltPassword() {
        return saltPassword;
    }
}
