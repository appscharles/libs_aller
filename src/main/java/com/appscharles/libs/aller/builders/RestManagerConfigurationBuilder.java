package com.appscharles.libs.aller.builders;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.LimitManagerConfiguration;
import com.appscharles.libs.aller.managers.RestManagerConfiguration;
import com.appscharles.libs.aller.managers.TokenManagerConfiguration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Rest manager configuration builder.
 */
public class RestManagerConfigurationBuilder {

    private static final String SANDBOX_AUTHORIZATION_END_POINT = "https://allegro.pl.allegrosandbox.pl/auth/oauth";

    private static final String AUTHORIZATION_END_POINT = "https://allegro.pl/auth/oauth";

    private static final String SANDBOX_API_CALL_METHODS = "https://api.allegro.pl.allegrosandbox.pl";

    private static final String API_CALL_METHODS = "https://api.allegro.pl";

    private String clientId;

    private String clientSecret;

    private Boolean sandbox;

    private List<Integer> redirectPorts;

    private String saltPassword;

    private File configurationTokensFile;

    private String htmlSuccessResponse;

    private long ipRequestPerSeconds;

    private RestManagerConfigurationBuilder() {
        this.redirectPorts = new ArrayList<>();
    }

    /**
     * Create rest manager configuration builder.
     *
     * @param sandbox                 the sandbox
     * @param clientId                the client id
     * @param clientSecret            the client secret
     * @param redirectPort            the redirect port
     * @param saltPassword            the salt password
     * @param configurationTokensFile the configuration tokens file
     * @return the rest manager configuration builder
     */
    public static RestManagerConfigurationBuilder create(Boolean sandbox, String clientId, String clientSecret, Integer redirectPort, String saltPassword, File configurationTokensFile) {
        RestManagerConfigurationBuilder instance = new RestManagerConfigurationBuilder();
        instance.sandbox = sandbox;
        instance.clientId = clientId;
        instance.clientSecret = clientSecret;
        instance.redirectPorts.add(redirectPort);
        instance.saltPassword = saltPassword;
        instance.configurationTokensFile = configurationTokensFile;
        instance.ipRequestPerSeconds = 110;
        return instance;
    }

    /**
     * Build rest manager configuration.
     *
     * @return the rest manager configuration
     * @throws AllerException the aller exception
     */
    public RestManagerConfiguration build() throws AllerException {
        URL authorizationEndPointUrl;
        URL apiCallMethodsUrl;

        try {
            if (this.sandbox) {
                authorizationEndPointUrl = new URL(SANDBOX_AUTHORIZATION_END_POINT);
                apiCallMethodsUrl = new URL(SANDBOX_API_CALL_METHODS);
            } else {
                authorizationEndPointUrl = new URL(AUTHORIZATION_END_POINT);
                apiCallMethodsUrl = new URL(API_CALL_METHODS);
            }
        } catch (MalformedURLException e) {
            throw new AllerException(e);
        }
        TokenManagerConfiguration tokenManagerConfiguration = new TokenManagerConfiguration(this.clientId, this.clientSecret, authorizationEndPointUrl, this.redirectPorts.toArray(new Integer[ this.redirectPorts.size()]), this.configurationTokensFile, this.saltPassword);
        if (this.htmlSuccessResponse != null){
            tokenManagerConfiguration.setHtmlSuccessResponse(this.htmlSuccessResponse);
        }
        LimitManagerConfiguration limitManagerConfiguration = new LimitManagerConfiguration();
        if (Objects.isNull(this.ipRequestPerSeconds) == false){
            limitManagerConfiguration.setIpRequestPerSeconds(this.ipRequestPerSeconds);
        }
        return new RestManagerConfiguration(apiCallMethodsUrl, limitManagerConfiguration, tokenManagerConfiguration);
    }

    /**
     * Add redirect port rest manager configuration builder.
     *
     * @param redirectPort the redirect port
     * @return the rest manager configuration builder
     */
    public RestManagerConfigurationBuilder addRedirectPort(Integer redirectPort) {
        if (this.redirectPorts.contains(redirectPort) == false) {
            this.redirectPorts.add(redirectPort);
        }
        return this;
    }

    /**
     * Set html success response rest manager configuration builder.
     *
     * @param htmlSuccessResponse the html success response
     * @return the rest manager configuration builder
     */
    public RestManagerConfigurationBuilder setHtmlSuccessResponse(String htmlSuccessResponse){
        this.htmlSuccessResponse = htmlSuccessResponse;
        return this;
    }

    /**
     * Set ip request per seconds rest manager configuration builder.
     *
     * @param ipRequestPerSeconds the ip request per seconds
     * @return the rest manager configuration builder
     */
    public RestManagerConfigurationBuilder setIpRequestPerSeconds(long ipRequestPerSeconds){
        this.ipRequestPerSeconds = ipRequestPerSeconds;
        return this;
    }
}
