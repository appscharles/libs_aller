package com.appscharles.libs.aller.senders;

import com.appscharles.libs.aller.exceptions.AllerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * The type Get http sender.
 */
public class GetHttpSender extends AbstractHttpSender {

    /**
     * Instantiates a new Get http sender.
     *
     * @param url the url
     */
    public GetHttpSender(URL url) {
        super(url);
    }

    @Override
    public String getResponse() throws AllerException {
        HttpURLConnection connection = null;
        StringBuilder content;
        try {
            this.url = new URL(this.url +getUrlParameters());
            connection = (HttpURLConnection) this.url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            for (Map.Entry<String, String> entry : this.requestProperties.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            if (connection.getResponseCode() >= 200 && connection.getResponseCode() <  400) {
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), "UTF-8"))) {
                    String line;
                    content = new StringBuilder();
                    while ((line = in.readLine()) != null) {
                        content.append(line);
                        content.append(System.lineSeparator());
                    }
                }
            } else {
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getErrorStream(), "UTF-8"))) {
                    String line;
                    content = new StringBuilder();
                    while ((line = in.readLine()) != null) {
                        content.append(line);
                        content.append(System.lineSeparator());
                    }
                }
                throw new AllerException(connection.getResponseCode() + " " + connection.getResponseMessage() + " " + content.toString());
            }

        } catch (IOException e) {
            throw new AllerException(e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return content.toString();
    }
}
