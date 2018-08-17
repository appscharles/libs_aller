package com.appscharles.libs.aller.managers;

import java.io.File;
import java.net.URL;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 17.08.2018
 * Time: 13:48
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class TokenManagerConfiguration {

    private String clientId;

    private String clientSecret;

    private URL authorizationEndPoint;

    private Integer[] redirectPorts;

    private String htmlSuccessResponse;

    private File fileConfigurationsTokens;

    private String saltPassword;

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
     * Getter for property 'clientId'.
     *
     * @return Value for property 'clientId'.
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Getter for property 'clientSecret'.
     *
     * @return Value for property 'clientSecret'.
     */
    public String getClientSecret() {
        return clientSecret;
    }

    public URL getAuthorizationEndPoint() {
        return authorizationEndPoint;
    }

    public Integer[] getRedirectPorts() {
        return redirectPorts;
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
     * Setter for property 'htmlSuccessResponse'.
     *
     * @param htmlSuccessResponse Value to set for property 'htmlSuccessResponse'.
     */
    public void setHtmlSuccessResponse(String htmlSuccessResponse) {
        this.htmlSuccessResponse = htmlSuccessResponse;
    }

    /**
     * Getter for property 'fileConfigurationsTokens'.
     *
     * @return Value for property 'fileConfigurationsTokens'.
     */
    public File getFileConfigurationsTokens() {
        return fileConfigurationsTokens;
    }

    /**
     * Getter for property 'saltPassword'.
     *
     * @return Value for property 'saltPassword'.
     */
    public String getSaltPassword() {
        return saltPassword;
    }
}
