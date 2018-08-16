package com.appscharles.libs.aller.senders;

import com.appscharles.libs.aller.exceptions.AllerException;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The type Abstract post http sender.
 */
public abstract class AbstractGetHttpSender implements IHttpSender, IEncodable, IGetDatable, IRequestPropertable {

    /**
     * The Url encode.
     */
    protected String encoding;
    /**
     * The Url.
     */
    protected URL url;

    /**
     * The Post data.
     */
    protected Map<String, String> getData;

    /**
     * The Request properties.
     */
    protected Map<String, String> requestProperties;


    /**
     * Instantiates a new Abstract post http sender.
     *
     * @param url the url
     */
    public AbstractGetHttpSender(URL url) {
        this.encoding = "UTF-8";
        this.url = url;
        this.getData = new HashMap<>();
        this.requestProperties = new HashMap<>();
    }

    /**
     * Post data from parameters byte [ ].
     *
     * @return the byte [ ]
     * @throws AllerException the aller exception
     */
    protected String getDataFromParameters() throws AllerException {
        try {
            String urlParameters = "";
            Iterator it = this.getData.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
                String key = pair.getKey();
                String value = URLEncoder.encode(pair.getValue(), this.encoding);
                urlParameters += key + "=" + value;
                if (it.hasNext()) {
                    urlParameters += "&";
                }
            }
            urlParameters = (urlParameters.isEmpty()) ? urlParameters : "?" + urlParameters;
            return urlParameters;
        } catch (UnsupportedEncodingException e) {
            throw new AllerException(e);
        }
    }

    @Override
    public <T> T setEncoding(String encoding) {
        this.encoding = encoding;
        return (T) this;
    }


    public <T> T addGetData(String key, String value) {
        this.getData.put(key, value);
        return (T)this;
    }

    @Override
    public <T> T addRequestProperty(String key, String value) {
        this.requestProperties.put(key, value);
        return (T) this;
    }
}
