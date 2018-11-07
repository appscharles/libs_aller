package com.appscharles.libs.aller.senders.rest;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.senders.GetHttpSender;
import com.appscharles.libs.aller.senders.IHttpSender;
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
        RestManager.setConfiguration(getRestManagerConfiguration());
        IHttpSender sender = new GetHttpSender(new URL("https://api.allegro.pl.allegrosandbox.pl/sale/categories/2"));
        TokenAccess access = getTokenAccess();
        RequestRestSender restSender = new RequestRestSender(sender, ApiVersion.V1, access.getToken(), true);
        Assert.assertTrue(restSender.getResponse().contains("id\":"));
    }

    @Test
    public void shouldGetResponse2() throws MalformedURLException, AllerException {
        TokenAccess access = getTokenAccess();
        IHttpSender httpSender = new GetHttpSender(new URL("https://api.allegro.pl.allegrosandbox.pl/sale/delivery-methods"));

        RequestRestSender sender = new RequestRestSender(httpSender, ApiVersion.V1, access.getToken(), false);
        String response = sender.getResponse();
        System.out.println(response);
        Assert.assertTrue(response.contains("id\":"));
    }
}