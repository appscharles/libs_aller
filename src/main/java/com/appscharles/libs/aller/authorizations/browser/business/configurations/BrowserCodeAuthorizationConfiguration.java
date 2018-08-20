package com.appscharles.libs.aller.authorizations.browser.business.configurations;

import java.net.URL;

/**
 * The type Browser code authorization configuration.
 */
public class BrowserCodeAuthorizationConfiguration {

    private URL authorizationEndPoint;

    private String clientId;

    private String loginAllegro;

    private Integer redirectPort;

    private String htmlSuccessResponse;

    /**
     * Instantiates a new Browser code authorization configuration.
     *
     * @param authorizationEndPoint the authorization end point
     * @param clientId              the client id
     * @param loginAllegro          the login allegro
     * @param redirectPort          the redirect port
     * @param htmlSuccessResponse   the html success response
     */
    public BrowserCodeAuthorizationConfiguration(URL authorizationEndPoint, String clientId, String loginAllegro, Integer redirectPort, String htmlSuccessResponse) {
        this.authorizationEndPoint = authorizationEndPoint;
        this.clientId = clientId;
        this.loginAllegro = loginAllegro;
        this.redirectPort = redirectPort;
        this.htmlSuccessResponse = htmlSuccessResponse;
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
     * Gets login allegro.
     *
     * @return the login allegro
     */
    public String getLoginAllegro() {
        return loginAllegro;
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
     * Gets authorization end point.
     *
     * @return the authorization end point
     */
    public URL getAuthorizationEndPoint() {
        return authorizationEndPoint;
    }

    /**
     * Gets redirect port.
     *
     * @return the redirect port
     */
    public Integer getRedirectPort() {
        return redirectPort;
    }
}
