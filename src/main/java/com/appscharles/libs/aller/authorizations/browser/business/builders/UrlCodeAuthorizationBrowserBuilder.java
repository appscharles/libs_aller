package com.appscharles.libs.aller.authorizations.browser.business.builders;

import com.appscharles.libs.aller.exceptions.AllerException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 17.08.2018
 * Time: 12:24
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class UrlCodeAuthorizationBrowserBuilder {

    private String clientId;

    private Integer redirectPort;

    private URL authorizationEndPoint;

    private UrlCodeAuthorizationBrowserBuilder(){

    }

    public static UrlCodeAuthorizationBrowserBuilder create(String clientId, URL authorizationEndPoint, Integer redirectPort){
        UrlCodeAuthorizationBrowserBuilder instance = new UrlCodeAuthorizationBrowserBuilder();
        instance.clientId = clientId;
        instance.authorizationEndPoint = authorizationEndPoint;
        instance.redirectPort = redirectPort;
        return instance;
    }

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
