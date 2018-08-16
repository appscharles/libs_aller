package com.appscharles.libs.aller.senders.rest;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.senders.GetHttpSender;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 16.08.2018
 * Time: 09:05
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class RequestRestSender extends AbstractRestSender {

    private static final String DEFAULT_CALL_METHOD_URL = "https://api.allegro.pl";

    private static final String DEFAULT_API_VERSION = "beta.v1";

    public RequestRestSender(String resource, String token) {
        super(resource, token);
    }


    @Override
    public String getResponse() throws AllerException {
        try {
            URL callMethodUrl = (this.callMethodUrl == null) ? new URL(DEFAULT_CALL_METHOD_URL) : this.callMethodUrl;
            URL url = new URL(callMethodUrl + "/" + this.resource);
            GetHttpSender sender = new GetHttpSender(url);
            sender.addRequestProperty("Authorization", "Bearer " + this.token);
            String apiVersion = (this.apiVersion == null)? DEFAULT_API_VERSION : this.apiVersion;
            sender.addRequestProperty("Accept", "application/vnd.allegro." + apiVersion +"+json");
            for (Map.Entry<String, String> entry : this.resourceParameters.entrySet()) {
                sender.addGetData(entry.getKey(), entry.getValue());
            }
            sender.send();
            return sender.getContent();
        } catch (MalformedURLException e) {
            throw new AllerException(e);
        }
    }

}
