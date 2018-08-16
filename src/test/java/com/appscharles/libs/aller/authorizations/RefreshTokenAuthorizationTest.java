package com.appscharles.libs.aller.authorizations;

import com.appscharles.libs.aller.accesses.ApiKeyAccess;
import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.exceptions.AllerException;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.appscharles.libs.aller.authorizations.TokenAuthorizationTest.getApiKeyAccess;
import static com.appscharles.libs.aller.authorizations.TokenAuthorizationTest.getTokenAccess;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 16.08.2018
 * Time: 10:25
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class RefreshTokenAuthorizationTest {

    @Test
    public void shouldGetRefreshToken() throws MalformedURLException, AllerException {
        TokenAccess tokenAccess = getTokenAccess();
        ApiKeyAccess apiKeyAccess = getApiKeyAccess();
        RefreshTokenAuthorization refreshTokenAuthorization = new RefreshTokenAuthorization(apiKeyAccess.getClientId(), apiKeyAccess.getClientSecret(), 11001, tokenAccess.getRefreshToken());
        refreshTokenAuthorization.setAuthorizationEndPoint(new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth"));
        TokenAccess refreshTokenAccess = refreshTokenAuthorization.getTokenAccess();
        Assert.assertNotNull(refreshTokenAccess.getExpiresIn());
        Assert.assertNotNull(refreshTokenAccess.getJti());
        Assert.assertNotNull(refreshTokenAccess.getRefreshToken());
        Assert.assertNotNull(refreshTokenAccess.getScope());
        Assert.assertNotNull(refreshTokenAccess.getToken());
        Assert.assertNotNull(refreshTokenAccess.getType());
        Assert.assertNotEquals(tokenAccess.getToken(), refreshTokenAccess.getToken());
    }
}