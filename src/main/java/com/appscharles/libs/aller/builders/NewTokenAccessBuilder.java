package com.appscharles.libs.aller.builders;

import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.authorizations.ICodeAuthorization;
import com.appscharles.libs.aller.authorizations.TokenAuthorization;
import com.appscharles.libs.aller.authorizations.browser.BrowserCodeAuthorization;
import com.appscharles.libs.aller.authorizations.browser.business.configurations.BrowserCodeAuthorizationConfiguration;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.getters.AvailablePortGetter;

import java.net.URL;

/**
 * The type New token access builder.
 */
public class NewTokenAccessBuilder {

    private String loginAllegro;

    private String clientId;

    private String clientSecret;

    private Integer[] redirectPorts;

    private URL authorizationEndPoint;

    private String htmlSuccessResponse;

    private NewTokenAccessBuilder(){

    }

    /**
     * Create new token access builder.
     *
     * @param loginAllegro          the login allegro
     * @param clientId              the client id
     * @param clientSecret          the client secret
     * @param redirectPorts         the redirect ports
     * @param authorizationEndPoint the authorization end point
     * @return the new token access builder
     */
    public static NewTokenAccessBuilder create(String loginAllegro, String clientId, String clientSecret, Integer[] redirectPorts, URL authorizationEndPoint){
        NewTokenAccessBuilder instance = new NewTokenAccessBuilder();
        instance.loginAllegro = loginAllegro;
        instance.clientId = clientId;
        instance.clientSecret = clientSecret;
        instance.redirectPorts = redirectPorts;
        instance.authorizationEndPoint = authorizationEndPoint;
        instance.htmlSuccessResponse = "OK";
        return instance;
    }

    /**
     * Build token access.
     *
     * @return the token access
     * @throws AllerException the aller exception
     */
    public TokenAccess build() throws AllerException {
        Integer port = AvailablePortGetter.get(this.redirectPorts);
        BrowserCodeAuthorizationConfiguration browserCodeAuthorizationConfiguration = new BrowserCodeAuthorizationConfiguration(
                this.authorizationEndPoint, this.clientId, this.loginAllegro, port, this.htmlSuccessResponse);
        ICodeAuthorization codeAuthorization = new BrowserCodeAuthorization(browserCodeAuthorizationConfiguration);
        TokenAuthorization tokenGetter = new TokenAuthorization(this.clientId, this.clientSecret, port, codeAuthorization);
        tokenGetter.setAuthorizationEndPoint(this.authorizationEndPoint);
        TokenAccess tokenAccess = tokenGetter.getTokenAccess();
        tokenAccess.setLoginAllegro(this.loginAllegro);
        return tokenAccess;
    }

    /**
     * Sets html success response.
     *
     * @param htmlSuccessResponse the html success response
     * @return the html success response
     */
    public NewTokenAccessBuilder setHtmlSuccessResponse(String htmlSuccessResponse) {
        this.htmlSuccessResponse = htmlSuccessResponse;
        return this;
    }
}
