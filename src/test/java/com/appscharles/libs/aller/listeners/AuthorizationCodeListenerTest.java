package com.appscharles.libs.aller.listeners;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.senders.GetHttpSender;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.08.2018
 * Time: 13:05
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class AuthorizationCodeListenerTest extends TestCase {

    @Test
    public void shouldGetAuthorizationCode() throws AllerException {
        Integer port = 4231;
        AuthorizationCodeListener listener = new AuthorizationCodeListener(port, 60000, "OK", "FAILED");
        Executors.newSingleThreadExecutor().submit(()->{
            try {
                Thread.sleep(2000);
                new GetHttpSender(new URL("http://localhost:" + port + "/?code=code_test")).getResponse();
            } catch (InterruptedException | MalformedURLException | AllerException e) {
                e.printStackTrace();
            }
        });
        Assert.assertEquals(listener.waitAndGet(), "code_test");
    }
}