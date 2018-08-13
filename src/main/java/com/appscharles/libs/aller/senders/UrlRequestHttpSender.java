package com.appscharles.libs.aller.senders;

import com.appscharles.libs.aller.exceptions.AllerException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The type Url request http sender.
 */
public class UrlRequestHttpSender {

    private URL url;

    /**
     * Instantiates a new Url request http sender.
     *
     * @param url the url
     */
    public UrlRequestHttpSender(URL url) {
        this.url = url;
    }

    /**
     * Send.
     *
     * @throws AllerException the aller exception
     */
    public void send() throws AllerException {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            try(InputStream is = connection.getInputStream()) {

            }
        } catch (IOException e) {
        throw new AllerException(e);
        }
    }
}
