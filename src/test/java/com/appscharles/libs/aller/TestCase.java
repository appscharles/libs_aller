package com.appscharles.libs.aller;

import com.appscharles.libs.aller.accesses.ApiKeyAccess;
import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.authorizations.TokenAuthorization;
import com.appscharles.libs.aller.authorizations.url.UrlCodeAuthorization;
import com.appscharles.libs.aller.builders.ApiKeyAccessBuilder;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.getters.AvailablePortGetter;
import com.appscharles.libs.aller.getters.ResourceContentGetter;
import com.appscharles.libs.aller.listeners.AuthorizationCodeListener;
import com.appscharles.libs.aller.listeners.IAuthorizationCodeListener;
import com.sun.javafx.application.PlatformImpl;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * The type Test case.
 */
public class TestCase {

    /**
     * The Temp.
     */
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    /**
     * Gets properties.
     *
     * @return the properties
     * @throws IOException the io exception
     */
    public Properties getProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(System.getProperty("user.home"), "appscharles/libs/aller/properties.properties")));
        return properties;
    }

    public TokenAccess getTokenAccess() throws AllerException, MalformedURLException {
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

    public ApiKeyAccess getApiKeyAccess() throws AllerException {
        return ApiKeyAccessBuilder.create(new File(System.getProperty("user.home"), "appscharles/libs/aller/properties.properties")).build();
    }
}
