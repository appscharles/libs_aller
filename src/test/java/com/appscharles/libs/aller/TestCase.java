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
import com.appscharles.libs.aller.managers.LimitManagerConfiguration;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.managers.RestManagerConfiguration;
import com.appscharles.libs.aller.managers.TokenManagerConfiguration;
import com.appscharles.libs.ioer.services.FileReader;
import com.appscharles.libs.logger.configurators.Log4j2Console;
import com.appscharles.libs.logger.services.LoggerConfigurator;
import com.sun.javafx.application.PlatformImpl;
import org.apache.logging.log4j.Level;
import org.junit.Before;
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

    @Before
    public void before(){
        LoggerConfigurator.config(new Log4j2Console(Level.INFO));
        PlatformImpl.startup(()->{});
        PlatformImpl.setImplicitExit(false);
    }

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
        authorizeCodeGetter.setAuthorizationEndPoint(new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth"));

        TokenAuthorization tokenGetter = new TokenAuthorization(apiKeyAccess.getClientId(), apiKeyAccess.getClientSecret(), port, authorizeCodeGetter);
        tokenGetter.setAuthorizationEndPoint(new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth"));
        return tokenGetter.getTokenAccess();
    }

    public ApiKeyAccess getApiKeyAccess() throws AllerException {
        return ApiKeyAccessBuilder.create(new File(System.getProperty("user.home"), "appscharles/libs/aller/properties.properties")).build();
    }

    public File getFileConfigurationTokens() {
        return new File("E:\\others\\aller_test\\tokens3.data");
    }

    public RestManagerConfiguration getRestManagerConfiguration() throws AllerException {
        try {
            TokenManagerConfiguration tokenManagerConfiguration = getTokenManagerConfiguration();
            return new RestManagerConfiguration(
                    new URL("https://api.allegro.pl.allegrosandbox.pl"),
                    new LimitManagerConfiguration(),
                    tokenManagerConfiguration
            );
        } catch (MalformedURLException e) {
            throw new AllerException(e);
        }
    }

    public void initRestManager() throws AllerException {
        if (RestManager.getConfiguration() == null){
            RestManager.setConfiguration(getRestManagerConfiguration());
        }
    }

    public TokenManagerConfiguration getTokenManagerConfiguration() throws MalformedURLException, AllerException {
        return new TokenManagerConfiguration(
                getApiKeyAccess().getClientId(), getApiKeyAccess().getClientSecret(),
                new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth"),
                new Integer[]{11001}, getFileConfigurationTokens(), "saltPassword"
        );
    }

    public String getLoginAllegro() throws AllerException {
        try {
            return getProperties().getProperty("libs_aller.test.login_allegro");
        } catch (IOException e) {
            throw new AllerException(e);
        }
    }

    public String readTestResource(String testResource) throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(testResource);
        File file = new File(url.getPath());
        return FileReader.read(file);
    }
}
