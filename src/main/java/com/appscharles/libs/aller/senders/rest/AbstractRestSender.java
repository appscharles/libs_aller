package com.appscharles.libs.aller.senders.rest;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 16.08.2018
 * Time: 09:06
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public abstract class AbstractRestSender implements IRestSender {

    protected Map<String, String> data;

    protected Map<String, String> requestProperties;

    protected URL urlCallMethod ;

    protected String resource;

    protected String token;

    protected ApiVersion apiVersion;

    public AbstractRestSender(String resource, ApiVersion apiVersion, String token, URL urlCallMethod) {
        this.resource = resource;
        this.apiVersion = apiVersion;
        this.token = token;
        this.urlCallMethod = urlCallMethod;
        this.data = new HashMap<>();
        this.requestProperties =  new HashMap<>();
    }

    @Override
    public <T> T addData(String key, String value) {
        this.data.put(key, value);
        return (T)this;
    }

    @Override
    public <T> T setData(Map<String, String> data) {
        this.data = data;
        return (T)this;
    }

    @Override
    public <T> T addRequestProperty(String key, String value) {
        this.requestProperties.put(key, value);
        return (T) this;
    }
}
