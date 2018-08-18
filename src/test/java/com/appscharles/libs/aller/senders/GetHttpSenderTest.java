package com.appscharles.libs.aller.senders;

import com.appscharles.libs.aller.exceptions.AllerException;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 18.08.2018
 * Time: 08:04
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class GetHttpSenderTest {

    @Test(expected = AllerException.class)
    public void shouldGetJsonError() throws MalformedURLException, AllerException {
        URL url = new URL("https://api.allegro.pl.allegrosandbox.pl/sale/delivery-methods");
        GetHttpSender httpSender = new GetHttpSender(url);
        System.out.println(httpSender.getResponse());
    }
}