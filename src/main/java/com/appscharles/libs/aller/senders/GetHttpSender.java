package com.appscharles.libs.aller.senders;

import com.appscharles.libs.aller.exceptions.AllerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * The type Post http sender.
 */
public class GetHttpSender extends AbstractGetHttpSender {

    private String content;

    /**
     * Instantiates a new Post http sender.
     *
     * @param url the url
     */
    public GetHttpSender(URL url) {
        super(url);
    }

    @Override
    public void send() throws AllerException {
        HttpURLConnection connection = null;
        try {
            this.url = new URL(this.url + getDataFromParameters());
            connection = (HttpURLConnection) this.url.openConnection();
            connection.setRequestMethod("GET");
            for (Map.Entry<String, String> entry : this.requestProperties.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            this.content = content.toString();
        } catch (IOException e) {
            throw new AllerException(e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }
}
