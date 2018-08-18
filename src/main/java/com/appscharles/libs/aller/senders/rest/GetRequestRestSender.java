package com.appscharles.libs.aller.senders.rest;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.senders.GetHttpSender;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 16.08.2018
 * Time: 09:05
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class GetRequestRestSender extends AbstractRestSender {

    public GetRequestRestSender(String resource, ApiVersion apiVersion, String token, URL urlCallMethod) {
        super(resource, apiVersion, token, urlCallMethod);
    }


    @Override
    public String getResponse() throws AllerException {
        try {
            URL url = new URL(this.urlCallMethod + "/" + this.resource);
            GetHttpSender sender = new GetHttpSender(url);
            sender.addRequestProperty("Accept-Language", "pl-PL");
            sender.addRequestProperty("Authorization", "Bearer " + this.token);
            sender.addRequestProperty("Accept", "application/vnd.allegro." + this.apiVersion.getName() +"+json");
            sender.setData(this.data);
            return sender.getResponse();
        } catch (MalformedURLException e) {
            throw new AllerException(e);
        }
    }
}
