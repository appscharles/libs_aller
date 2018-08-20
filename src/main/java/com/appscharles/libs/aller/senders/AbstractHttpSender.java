package com.appscharles.libs.aller.senders;

import com.appscharles.libs.aller.exceptions.AllerException;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The type Abstract http sender.
 */
public abstract class AbstractHttpSender implements IHttpSender {

    /**
     * The Encoding.
     */
    protected String encoding;
    /**
     * The Url.
     */
    protected URL url;

    /**
     * The Request properties.
     */
    protected Map<String, String> requestProperties;

    /**
     * The Url parameters.
     */
    protected Map<String, String> urlParameters;


    /**
     * Instantiates a new Abstract http sender.
     *
     * @param url the url
     */
    public AbstractHttpSender(URL url) {
        this.encoding = "UTF-8";
        this.url = url;
        this.urlParameters = new HashMap<>();
        this.requestProperties = new HashMap<>();
    }

    /**
     * Gets url parameters.
     *
     * @return the url parameters
     * @throws AllerException the aller exception
     */
    protected String getUrlParameters() throws AllerException {
        try {
            String urlParameters = "";
            Iterator it = this.urlParameters.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
                String key = pair.getKey();
                String value = URLEncoder.encode(pair.getValue(), this.encoding);
                urlParameters += key + "=" + value;
                if (it.hasNext()) {
                    urlParameters += "&";
                }
            }
            return (urlParameters.isEmpty()) ? urlParameters : "?" + urlParameters;
        } catch (UnsupportedEncodingException e) {
            throw new AllerException(e);
        }
    }

    @Override
    public <T> T setEncoding(String encoding) {
        this.encoding = encoding;
        return (T) this;
    }


    @Override
    public <T> T addUrlParameter(String key, String value) {
        this.urlParameters.put(key, value);
        return (T) this;
    }

    @Override
    public <T> T setUrlParameters(Map<String, String> urlParameters) {
        this.urlParameters = urlParameters;
        return (T) this;
    }

    @Override
    public <T> T addRequestProperty(String key, String value) {
        this.requestProperties.put(key, value);
        return (T) this;
    }
}
