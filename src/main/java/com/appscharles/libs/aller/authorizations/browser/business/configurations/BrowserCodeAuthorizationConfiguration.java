package com.appscharles.libs.aller.authorizations.browser.business.configurations;

import java.net.URL;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 16.08.2018
 * Time: 11:28
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class BrowserCodeAuthorizationConfiguration {

    private URL authorizationEndPoint;

    private String clientId;

    private String loginAllegro;

    private Integer redirectPort;

    private String htmlSuccessResponse;

    public BrowserCodeAuthorizationConfiguration(URL authorizationEndPoint, String clientId, String loginAllegro, Integer redirectPort, String htmlSuccessResponse) {
        this.authorizationEndPoint = authorizationEndPoint;
        this.clientId = clientId;
        this.loginAllegro = loginAllegro;
        this.redirectPort = redirectPort;
        this.htmlSuccessResponse = htmlSuccessResponse;
    }

    /**
     * Getter for property 'clientId'.
     *
     * @return Value for property 'clientId'.
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Getter for property 'loginAllegro'.
     *
     * @return Value for property 'loginAllegro'.
     */
    public String getLoginAllegro() {
        return loginAllegro;
    }

    /**
     * Getter for property 'htmlSuccessResponse'.
     *
     * @return Value for property 'htmlSuccessResponse'.
     */
    public String getHtmlSuccessResponse() {
        return htmlSuccessResponse;
    }

    /**
     * Getter for property 'authorizationEndPoint'.
     *
     * @return Value for property 'authorizationEndPoint'.
     */
    public URL getAuthorizationEndPoint() {
        return authorizationEndPoint;
    }

    /**
     * Getter for property 'redirectPort'.
     *
     * @return Value for property 'redirectPort'.
     */
    public Integer getRedirectPort() {
        return redirectPort;
    }
}
