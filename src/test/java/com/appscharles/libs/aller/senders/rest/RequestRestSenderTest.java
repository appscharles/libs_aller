package com.appscharles.libs.aller.senders.rest;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.sun.javafx.application.PlatformImpl;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 16.08.2018
 * Time: 09:38
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class RequestRestSenderTest extends TestCase {

    @Test
    public void shouldGetResponse() throws MalformedURLException, AllerException {

        RequestRestSender sender = new RequestRestSender("categories/2", null);
        sender.setApiVersion("public.v1");
        sender.setCallMethodUrl(new URL("https://api.allegro.pl.allegrosandbox.pl"));
        Assert.assertTrue(sender.getResponse().contains("id\":"));
    }

    @Test
    public void shouldGetResponse2() throws MalformedURLException, AllerException {
        PlatformImpl.startup(()->{});
        PlatformImpl.setImplicitExit(false);
        TokenAccess access = getTokenAccess();

        RequestRestSender sender = new RequestRestSender("sale/delivery-methods", access.getToken());
        sender.setCallMethodUrl(new URL("https://api.allegro.pl.allegrosandbox.pl"));
        String response = sender.getResponse();
        System.out.println(response);
        Assert.assertTrue(response.contains("id\":"));
    }
}