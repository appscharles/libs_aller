package com.appscharles.libs.aller.authorizations;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.accesses.ApiKeyAccess;
import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.authorizations.url.UrlCodeAuthorization;
import com.appscharles.libs.aller.builders.ApiKeyAccessBuilder;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.getters.AvailablePortGetter;
import com.appscharles.libs.aller.getters.ResourceContentGetter;
import com.appscharles.libs.aller.listeners.AuthorizationCodeListener;
import com.appscharles.libs.aller.listeners.IAuthorizationCodeListener;
import com.sun.javafx.application.PlatformImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.08.2018
 * Time: 16:22
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class TokenAuthorizationTest extends TestCase {

    @Test
    public void shouldGetToken() throws AllerException, MalformedURLException {

        TokenAccess access = getTokenAccess();
        Assert.assertNotNull(access.getExpiresIn());
        Assert.assertNotNull(access.getJti());
        Assert.assertNotNull(access.getRefreshToken());
        Assert.assertNotNull(access.getScope());
        Assert.assertNotNull(access.getToken());
        Assert.assertNotNull(access.getType());


    }

    public static TokenAccess getTokenAccess() throws AllerException, MalformedURLException {
        PlatformImpl.setImplicitExit(false);
        ApiKeyAccess apiKeyAccess = getApiKeyAccess();
        Integer port = AvailablePortGetter.get(11001);
        ResourceContentGetter resourceContentGetter = new ResourceContentGetter();
        IAuthorizationCodeListener authorizationCodeListener = new AuthorizationCodeListener(port, 60000, resourceContentGetter.get("com/appscharles/libs/aller/listeners/HtmlSuccessResponse.html"), "FAILED");

        UrlCodeAuthorization authorizeCodeGetter = new UrlCodeAuthorization(apiKeyAccess.getClientId(), port, authorizationCodeListener);
        authorizeCodeGetter.setAuthorizationEndPoint(new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth/"));

        TokenAuthorization tokenGetter = new TokenAuthorization(apiKeyAccess.getClientId(), apiKeyAccess.getClientSecret(), port, authorizeCodeGetter);
        tokenGetter.setAuthorizationEndPoint(new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth/"));
        return tokenGetter.getTokenAccess();
    }

    public static ApiKeyAccess getApiKeyAccess() throws AllerException {
        return ApiKeyAccessBuilder.create(new File(System.getProperty("user.home"), "appscharles/libs/aller/properties.properties")).build();
    }
}