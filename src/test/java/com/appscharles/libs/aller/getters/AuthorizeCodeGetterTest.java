package com.appscharles.libs.aller.getters;

import com.appscharles.libs.aller.accesses.ApiKeyAccess;
import com.appscharles.libs.aller.builders.ApiKeyAccessBuilder;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.senders.UrlRequestHttpSender;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.08.2018
 * Time: 13:31
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class AuthorizeCodeGetterTest {

    @Test
    public void shouldGetAuthorizeCode() throws AllerException, MalformedURLException {
        Integer port = 15001;
        ApiKeyAccess apiKeyAccess = ApiKeyAccessBuilder.create(new File(System.getProperty("user.home"), "appscharles/libs/aller/properties.properties")).build();
        AuthorizeCodeGetter getter = new AuthorizeCodeGetter(apiKeyAccess.getClientId(), 5* 60000, port);
        getter.setAuthorizationEndPoint(new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth/"));
        getter.enableTest();
        Executors.newSingleThreadExecutor().submit(()->{
            try {
                Thread.sleep(2000);
                new UrlRequestHttpSender(new URL("http://localhost:" + port + "/?code=code_test")).send();
            } catch (InterruptedException | MalformedURLException | AllerException e) {
                e.printStackTrace();
            }
        });
        Assert.assertEquals(getter.get(), "code_test");
    }

    @Test
    public void shouldGetAuthorizeCode2() throws AllerException, MalformedURLException {
        Integer port = 11001;
        ApiKeyAccess apiKeyAccess = ApiKeyAccessBuilder.create(new File(System.getProperty("user.home"), "appscharles/libs/aller/properties.properties")).build();
        AuthorizeCodeGetter getter = new AuthorizeCodeGetter(apiKeyAccess.getClientId(), 100000, port);
        getter.setAuthorizationEndPoint(new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth/"));
        Assert.assertFalse(getter.get().isEmpty());
    }
}