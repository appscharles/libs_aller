package com.appscharles.libs.aller.senders;

import com.appscharles.libs.aller.exceptions.AllerException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * The type Post http sender.
 */
public class PostHttpSender extends AbstractHttpSender {

    /**
     * Instantiates a new Post http sender.
     *
     * @param url the url
     */
    public PostHttpSender(URL url) {
        super(url);
    }

    @Override
    public String getResponse() throws AllerException {
        HttpURLConnection connection = null;
        StringBuilder content;
        try {
            connection = (HttpURLConnection) this.url.openConnection();
            connection.setRequestMethod("POST");
            for (Map.Entry<String, String> entry : this.requestProperties.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            if (this.data.size() > 0){
                connection.setDoOutput(true);
                try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                    wr.write(getUrlParameters().getBytes(this.encoding));
                }
            }

            if (connection.getResponseCode() >= 200 && connection.getResponseCode() <  400) {
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    content = new StringBuilder();
                    while ((line = in.readLine()) != null) {
                        content.append(line);
                        content.append(System.lineSeparator());
                    }
                }
            } else {
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getErrorStream()))) {
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
            if (connection != null){
                connection.disconnect();
            }
        }
        return content.toString();
    }
}
