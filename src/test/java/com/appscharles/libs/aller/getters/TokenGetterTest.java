package com.appscharles.libs.aller.getters;

import com.appscharles.libs.aller.accesses.ApiKeyAccess;
import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.builders.ApiKeyAccessBuilder;
import com.appscharles.libs.aller.exceptions.AllerException;
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
public class TokenGetterTest {

    @Test
    public void shouldGetToken() throws AllerException, MalformedURLException {
        ApiKeyAccess apiKeyAccess = ApiKeyAccessBuilder.create(new File(System.getProperty("user.home"), "appscharles/libs/aller/properties.properties")).build();
        TokenGetter getter = new TokenGetter(apiKeyAccess.getClientId(), apiKeyAccess.getClientSecret(), 30000, 11001);
        getter.setHtmlSuccessResponse("Test OK");
        getter.setAuthorizationEndPoint(new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth/"));
        TokenAccess access = getter.get();
        Assert.assertNotNull(access.getExpiresIn());
        Assert.assertNotNull(access.getJti());
        Assert.assertNotNull(access.getRefreshToken());
        Assert.assertNotNull(access.getScope());
        Assert.assertNotNull(access.getToken());
        Assert.assertNotNull(access.getType());
    }
}