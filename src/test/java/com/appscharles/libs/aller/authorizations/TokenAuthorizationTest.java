package com.appscharles.libs.aller.authorizations;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.sun.javafx.application.PlatformImpl;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

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
        PlatformImpl.startup(()->{});
        PlatformImpl.setImplicitExit(false);
        TokenAccess access = getTokenAccess();
        Assert.assertNotNull(access.getExpiresIn());
        Assert.assertNotNull(access.getJti());
        Assert.assertNotNull(access.getRefreshToken());
        Assert.assertNotNull(access.getScope());
        Assert.assertNotNull(access.getToken());
        Assert.assertNotNull(access.getType());


    }


}