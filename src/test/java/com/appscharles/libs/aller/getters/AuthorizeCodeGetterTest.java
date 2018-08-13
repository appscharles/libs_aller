package com.appscharles.libs.aller.getters;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.senders.UrlRequestHttpSender;
import org.junit.Assert;
import org.junit.Test;

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
    public void shouldGetAuthorizeCode() throws AllerException {
        Integer port = 3211;
        AuthorizeCodeGetter getter = new AuthorizeCodeGetter("1wetetetc7b04a83rr0331c41bdc2", 5* 60000, port);
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

    @Test(expected = AllerException.class)
    public void shouldGetAuthorizeCode2() throws AllerException {
        Integer port = 3212;
        AuthorizeCodeGetter getter = new AuthorizeCodeGetter("1wetetetc7b04a83rr0331c41bdc2", 10000, port);
        Assert.assertEquals(getter.get(), "code_test");
    }
}