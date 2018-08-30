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
        initRestManager();
        TokenAccess tokenAccess = TokenManager.getTokenAccess(getLoginAllegro());
        RequestRestSender sender = new RequestRestSender(new GetHttpSender(new URL("https://api.allegro.pl.allegrosandbox.pl/sale/delivery-methods")), ApiVersion.V1, tokenAccess.getToken(), true);
        Assert.assertTrue(sender.getResponse().contains("id\":"));
    }

    @Test
    public void shouldGetResourceFromResponse() throws AllerException, IOException {
        initRestManager();
        TokenAccess tokenAccess = TokenManager.getTokenAccess(getProperties().getProperty("libs_aller.test.login_allegro"));
        TokenManager.refreshTokenAccess(getProperties().getProperty("libs_aller.test.login_allegro"), 3);
        RequestRestSender sender = new RequestRestSender(new GetHttpSender(new URL("https://api.allegro.pl.allegrosandbox.pl/sale/delivery-methods")), ApiVersion.V1, tokenAccess.getToken(), false);
        Assert.assertTrue(sender.getResponse().contains("id\":"));
        RequestRestSender sender2 = new RequestRestSender(new GetHttpSender(new URL("https://api.allegro.pl.allegrosandbox.pl/sale/delivery-methods")), ApiVersion.V1, tokenAccess.getToken(), false);
        Assert.assertTrue(sender2.getResponse().contains("id\":"));
    }

    @Test
    public void shouldGetNewTokenAccessForExpireRefreshToken() throws AllerException, IOException {
        initRestManager();
        TokenAccess tokenAccess = TokenManager.getTokenAccess(getLoginAllegro());
        RequestRestSender sender = new RequestRestSender(new GetHttpSender(new URL("https://api.allegro.pl.allegrosandbox.pl/sale/delivery-methods")), ApiVersion.V1, tokenAccess.getToken(),  false);
        Assert.assertTrue(sender.getResponse().contains("id\":"));
        Calendar refreshTokenCreatedAt = Calendar.getInstance();
        refreshTokenCreatedAt.add(Calendar.DAY_OF_YEAR, -350);
        tokenAccess.setRefreshTokenCreatedAt(refreshTokenCreatedAt);
        TokenManager.getTokenAccess(getLoginAllegro());
    }

    @Test
    public void shouldCheckActiveAccessToken() throws AllerException {
        initRestManager();
        TokenAccess tokenAccess = TokenManager.getTokenAccess(getLoginAllegro());
        Assert.assertTrue(TokenManager.isActiveAccessToken(tokenAccess.getLoginAllegro()));
        Assert.assertFalse(TokenManager.isActiveAccessToken("yeti"));
    }
}