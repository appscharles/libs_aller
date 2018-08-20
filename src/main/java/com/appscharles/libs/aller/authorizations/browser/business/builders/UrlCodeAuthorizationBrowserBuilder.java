package com.appscharles.libs.aller.authorizations.browser.business.builders;

import com.appscharles.libs.aller.exceptions.AllerException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * The type Url code authorization browser builder.
 */
public class UrlCodeAuthorizationBrowserBuilder {

    private String clientId;

    private Integer redirectPort;

    private URL authorizationEndPoint;

    private UrlCodeAuthorizationBrowserBuilder(){

    }

    /**
     * Create url code authorization browser builder.
     *
     * @param clientId              the client id
     * @param authorizationEndPoint the authorization end point
     * @param redirectPort          the redirect port
     * @return the url code authorization browser builder
     */
    public static UrlCodeAuthorizationBrowserBuilder create(String clientId, URL authorizationEndPoint, Integer redirectPort){
        UrlCodeAuthorizationBrowserBuilder instance = new UrlCodeAuthorizationBrowserBuilder();
        instance.clientId = clientId;
        instance.authorizationEndPoint = authorizationEndPoint;
        instance.redirectPort = redirectPort;
        return instance;
    }

    /**
     * Build url.
     *
     * @return the url
     * @throws AllerException the aller exception
     */
    public URL build() throws AllerException{
        try {
            String patternAllegroAuthorizeUrl = this.authorizationEndPoint + "/authorize?response_type=code&client_id=%1$s&redirect_uri=%2$s";
            String redirectUrl = "http://localhost:" + this.redirectPort;
            return new URL((String.format(patternAllegroAuthorizeUrl, this.clientId, redirectUrl)));
        } catch (MalformedURLException e) {
            throw new AllerException(e);
        }
    }
}
