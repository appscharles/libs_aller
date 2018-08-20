package com.appscharles.libs.aller.managers;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.senders.GetHttpSender;
import com.appscharles.libs.aller.senders.rest.ApiVersion;
import com.appscharles.libs.aller.senders.rest.RequestRestSender;
import com.sun.javafx.application.PlatformImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 17.08.2018
 * Time: 15:02
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class TokenManagerTest extends TestCase {


    @Test
    public void shouldSaveTokens() throws AllerException, IOException {
        PlatformImpl.startup(()->{});
        PlatformImpl.setImplicitExit(false);
        TokenManagerConfiguration configuration = new TokenManagerConfiguration(
                getApiKeyAccess().getClientId(), getApiKeyAccess().getClientSecret(),
                new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth"),
                new Integer[]{11001},getFileConfigurationTokens(), "saltPassword"
        );
        TokenManager.setConfiguration(configuration);
        TokenAccess tokenAccess = TokenManager.getTokenAccess(getProperties().getProperty("libs_aller.test.login_allegro"));

        RequestRestSender sender = new RequestRestSender(new GetHttpSender(new URL("https://api.allegro.pl.allegrosandbox.pl/sale/delivery-methods")), ApiVersion.V1, tokenAccess.getToken(), true);
        Assert.assertTrue(sender.getResponse().contains("id\":"));
    }

    @Test
    public void shouldGetResourceFromResponse() throws AllerException, IOException {
        PlatformImpl.startup(()->{});
        PlatformImpl.setImplicitExit(false);
        TokenManagerConfiguration configuration = new TokenManagerConfiguration(
                getApiKeyAccess().getClientId(), getApiKeyAccess().getClientSecret(),
                new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth"),
                new Integer[]{11001},getFileConfigurationTokens(), "saltPassword"
        );
        TokenManager.setConfiguration(configuration);
        TokenAccess tokenAccess = TokenManager.getTokenAccess(getProperties().getProperty("libs_aller.test.login_allegro"));
        TokenAccess tokenAccess2 = TokenManager.refreshTokenAccess(getProperties().getProperty("libs_aller.test.login_allegro"), 3);
        RequestRestSender sender = new RequestRestSender(new GetHttpSender(new URL("https://api.allegro.pl.allegrosandbox.pl/sale/delivery-methods")), ApiVersion.V1, tokenAccess.getToken(), false);
        Assert.assertTrue(sender.getResponse().contains("id\":"));
        RequestRestSender sender2 = new RequestRestSender(new GetHttpSender(new URL("https://api.allegro.pl.allegrosandbox.pl/sale/delivery-methods")), ApiVersion.V1, tokenAccess.getToken(), false);
        Assert.assertTrue(sender2.getResponse().contains("id\":"));
    }

    @Test
    public void shouldGetNewTokenAccessForExpireRefreshToken() throws AllerException, IOException {
        PlatformImpl.startup(()->{});
        PlatformImpl.setImplicitExit(false);
        TokenManagerConfiguration configuration = new TokenManagerConfiguration(
                getApiKeyAccess().getClientId(), getApiKeyAccess().getClientSecret(),
                new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth"),
                new Integer[]{11001},getFileConfigurationTokens(), "saltPassword"
        );
        TokenManager.setConfiguration(configuration);
        TokenAccess tokenAccess = TokenManager.getTokenAccess(getProperties().getProperty("libs_aller.test.login_allegro"));

        RequestRestSender sender = new RequestRestSender(new GetHttpSender(new URL("https://api.allegro.pl.allegrosandbox.pl/sale/delivery-methods")), ApiVersion.V1, tokenAccess.getToken(),  false);
        Assert.assertTrue(sender.getResponse().contains("id\":"));

        Calendar refreshTokenCreatedAt = Calendar.getInstance();
        refreshTokenCreatedAt.add(Calendar.DAY_OF_YEAR, -350);
        tokenAccess.setRefreshTokenCreatedAt(refreshTokenCreatedAt);
       tokenAccess = TokenManager.getTokenAccess(getProperties().getProperty("libs_aller.test.login_allegro"));
    }
}