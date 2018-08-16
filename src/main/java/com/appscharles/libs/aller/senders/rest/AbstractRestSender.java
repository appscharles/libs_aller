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
public abstract class AbstractRestSender implements IRestSender, ICallMethodUrlable, IApiVersionable, IResourceParametable {

    protected Map<String, String> resourceParameters;

    protected URL callMethodUrl;

    protected String resource;

    protected String token;

    protected String apiVersion;

    public AbstractRestSender(String resource, String token) {
        this.resource = resource;
        this.token = token;
        this.resourceParameters = new HashMap<>();
    }

    @Override
    public void setCallMethodUrl(URL callMethodUrl) {
        this.callMethodUrl = callMethodUrl;
    }

    @Override
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public void addResourceParameter(String key, String value) {
        this.resourceParameters.put(key, value);
    }
}
