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
public abstract class AbstractPostHttpSender implements IHttpSender, IUrlEncodable, IPostDatable, IRequestPropertable {

    /**
     * The Url encode.
     */
    protected String urlEncode;
    /**
     * The Url.
     */
    protected URL url;

    /**
     * The Post data.
     */
    protected Map<String, String> postData;

    /**
     * The Request properties.
     */
    protected Map<String, String> requestProperties;


    /**
     * Instantiates a new Abstract post http sender.
     *
     * @param url the url
     */
    public AbstractPostHttpSender(URL url) {
        this.urlEncode = "UTF-8";
        this.url = url;
        this.postData = new HashMap<>();
        this.requestProperties = new HashMap<>();
    }

    /**
     * Post data from parameters byte [ ].
     *
     * @return the byte [ ]
     * @throws AllerException the aller exception
     */
    protected byte[] postDataFromParameters() throws AllerException {
        try {
            String urlParameters = "";
            Iterator it = this.postData.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
                String key = pair.getKey();
                String value = URLEncoder.encode(pair.getValue(), this.urlEncode);
                urlParameters += key + "=" + value;
                if (it.hasNext()) {
                    urlParameters += "&";
                }
            }
            return urlParameters.getBytes(this.urlEncode);
        } catch (UnsupportedEncodingException e) {
            throw new AllerException(e);
        }
    }

    @Override
    public <T extends AbstractPostHttpSender> T setUrlEncode(String urlEncode) {
        this.urlEncode = urlEncode;
        return (T) this;
    }


    public <T extends AbstractPostHttpSender> T addPostData(String key, String value) {
        this.postData.put(key, value);
        return (T)this;
    }

    @Override
    public <T extends AbstractPostHttpSender> T addRequestProperty(String key, String value) {
        this.requestProperties.put(key, value);
        return (T) this;
    }
}
