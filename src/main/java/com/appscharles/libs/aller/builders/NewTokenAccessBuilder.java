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
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 17.08.2018
 * Time: 14:31
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
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
     * Setter for property 'htmlSuccessResponse'.
     *
     * @param htmlSuccessResponse Value to set for property 'htmlSuccessResponse'.
     */
    public NewTokenAccessBuilder setHtmlSuccessResponse(String htmlSuccessResponse) {
        this.htmlSuccessResponse = htmlSuccessResponse;
        return this;
    }
}
