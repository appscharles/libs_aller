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
public class PostHttpSender extends AbstractPostHttpSender {

    private String content;

    /**
     * Instantiates a new Post http sender.
     *
     * @param url the url
     */
    public PostHttpSender(URL url) {
        super(url);
    }

    @Override
    public void send() throws AllerException {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) this.url.openConnection();
            connection.setRequestMethod("POST");
            for (Map.Entry<String, String> entry : this.requestProperties.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            if (this.postData.size() > 0){
                connection.setDoOutput(true);
                try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                    byte[] postData = postDataFromParameters();
                    wr.write(postData);
                }
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
            if (connection != null){
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
