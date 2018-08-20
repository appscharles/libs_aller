package com.appscharles.libs.aller.managers;

import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.extractors.JwtTokenExtractor;
import com.appscharles.libs.aller.senders.*;
import com.appscharles.libs.aller.senders.rest.ApiVersion;
import com.appscharles.libs.aller.senders.rest.IRestSender;
import com.appscharles.libs.aller.senders.rest.RequestRestSender;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * The type Rest manager.
 */
public class RestManager {

    private static RestManagerConfiguration configuration;

    /**
     * Get string.
     *
     * @param resource                the resource
     * @param apiVersion              the api version
     * @param urlParameters           the url parameters
     * @param loginAllegro            the login allegro
     * @param requestProperties       the request properties
     * @param contentTypeSameAsAccept the content type same as accept
     * @return the string
     * @throws AllerException the aller exception
     */
    public static String get(String resource, ApiVersion apiVersion, Map<String, String> urlParameters, String loginAllegro, Map<String, String> requestProperties, Boolean contentTypeSameAsAccept) throws AllerException {
        checkConfiguration();
        try {
            IHttpSender httpSender = new GetHttpSender(new URL(configuration.getUrlCallMethod() + "/" + resource));
            return getResponse(httpSender, apiVersion, urlParameters, loginAllegro, requestProperties, contentTypeSameAsAccept);
        } catch (MalformedURLException e) {
            throw new AllerException(e);
        }
    }

    /**
     * Get string.
     *
     * @param resource      the resource
     * @param apiVersion    the api version
     * @param urlParameters the url parameters
     * @param loginAllegro  the login allegro
     * @return the string
     * @throws AllerException the aller exception
     */
    public static String get(String resource, ApiVersion apiVersion, Map<String, String> urlParameters, String loginAllegro) throws AllerException {
        return get(resource, apiVersion, urlParameters, loginAllegro, null, false);
    }

    /**
     * Get string.
     *
     * @param resource     the resource
     * @param apiVersion   the api version
     * @param loginAllegro the login allegro
     * @return the string
     * @throws AllerException the aller exception
     */
    public static String get(String resource, ApiVersion apiVersion, String loginAllegro) throws AllerException {
        return get(resource, apiVersion, null, loginAllegro, null, false);
    }

    /**
     * Post string.
     *
     * @param resource                the resource
     * @param apiVersion              the api version
     * @param data                    the data
     * @param loginAllegro            the login allegro
     * @param urlParameters           the url parameters
     * @param requestProperties       the request properties
     * @param contentTypeSameAsAccept the content type same as accept
     * @return the string
     * @throws AllerException the aller exception
     */
    public static String post(String resource, ApiVersion apiVersion, String data, String loginAllegro, Map<String, String> urlParameters, Map<String, String> requestProperties, Boolean contentTypeSameAsAccept) throws AllerException {
        checkConfiguration();
        try {
            IHttpSender httpSender = new PostHttpSender(new URL(configuration.getUrlCallMethod() + "/" + resource));
            ((PostHttpSender) httpSender).setData(data);
            return getResponse(httpSender, apiVersion, urlParameters, loginAllegro, requestProperties, contentTypeSameAsAccept);
        } catch (MalformedURLException e) {
            throw new AllerException(e);
        }
    }

    /**
     * Post string.
     *
     * @param resource                the resource
     * @param apiVersion              the api version
     * @param data                    the data
     * @param loginAllegro            the login allegro
     * @param contentTypeSameAsAccept the content type same as accept
     * @return the string
     * @throws AllerException the aller exception
     */
    public static String post(String resource, ApiVersion apiVersion, String data, String loginAllegro, Boolean contentTypeSameAsAccept) throws AllerException {
       return post(resource, apiVersion, data, loginAllegro, null, null, contentTypeSameAsAccept);
    }

    /**
     * Put string.
     *
     * @param resource                the resource
     * @param apiVersion              the api version
     * @param data                    the data
     * @param loginAllegro            the login allegro
     * @param urlParameters           the url parameters
     * @param requestProperties       the request properties
     * @param contentTypeSameAsAccept the content type same as accept
     * @return the string
     * @throws AllerException the aller exception
     */
    public static String put(String resource, ApiVersion apiVersion, String data, String loginAllegro, Map<String, String> urlParameters, Map<String, String> requestProperties, Boolean contentTypeSameAsAccept) throws AllerException {
        checkConfiguration();
        try {
            IHttpSender httpSender = new PutHttpSender(new URL(configuration.getUrlCallMethod() + "/" + resource));
            ((PutHttpSender) httpSender).setData(data);
            return getResponse(httpSender, apiVersion, urlParameters, loginAllegro, requestProperties, contentTypeSameAsAccept);
        } catch (MalformedURLException e) {
            throw new AllerException(e);
        }
    }

    /**
     * Put string.
     *
     * @param resource                the resource
     * @param apiVersion              the api version
     * @param data                    the data
     * @param loginAllegro            the login allegro
     * @param contentTypeSameAsAccept the content type same as accept
     * @return the string
     * @throws AllerException the aller exception
     */
    public static String put(String resource, ApiVersion apiVersion, String data, String loginAllegro, Boolean contentTypeSameAsAccept) throws AllerException {
        return put(resource, apiVersion, data, loginAllegro, null, null, contentTypeSameAsAccept);
    }

    /**
     * Delete string.
     *
     * @param resource                the resource
     * @param apiVersion              the api version
     * @param urlParameters           the url parameters
     * @param loginAllegro            the login allegro
     * @param requestProperties       the request properties
     * @param contentTypeSameAsAccept the content type same as accept
     * @return the string
     * @throws AllerException the aller exception
     */
    public static String delete(String resource, ApiVersion apiVersion, Map<String, String> urlParameters, String loginAllegro, Map<String, String> requestProperties, Boolean contentTypeSameAsAccept) throws AllerException {
        checkConfiguration();
        try {
            IHttpSender httpSender = new DeleteHttpSender(new URL(configuration.getUrlCallMethod() + "/" + resource));
            return getResponse(httpSender, apiVersion, urlParameters, loginAllegro, requestProperties, contentTypeSameAsAccept);
        } catch (MalformedURLException e) {
            throw new AllerException(e);
        }
    }

    /**
     * Delete string.
     *
     * @param resource      the resource
     * @param apiVersion    the api version
     * @param urlParameters the url parameters
     * @param loginAllegro  the login allegro
     * @return the string
     * @throws AllerException the aller exception
     */
    public static String delete(String resource, ApiVersion apiVersion, Map<String, String> urlParameters, String loginAllegro) throws AllerException {
        return delete(resource, apiVersion, urlParameters, loginAllegro, null, false);
    }

    /**
     * Delete string.
     *
     * @param resource     the resource
     * @param apiVersion   the api version
     * @param loginAllegro the login allegro
     * @return the string
     * @throws AllerException the aller exception
     */
    public static String delete(String resource, ApiVersion apiVersion, String loginAllegro) throws AllerException {
        return delete(resource, apiVersion, null, loginAllegro, null, false);
    }


    /**
     * Gets response.
     *
     * @param httpSender              the http sender
     * @param apiVersion              the api version
     * @param urlParameters           the url parameters
     * @param loginAllegro            the login allegro
     * @param requestProperties       the request properties
     * @param contentTypeSameAsAccept the content type same as accept
     * @return the response
     * @throws AllerException the aller exception
     */
    public static String getResponse(IHttpSender httpSender, ApiVersion apiVersion, Map<String, String> urlParameters, String loginAllegro, Map<String, String> requestProperties, Boolean contentTypeSameAsAccept) throws AllerException {
        checkConfiguration();
        TokenAccess tokenAccess = TokenManager.getTokenAccess(loginAllegro);
        IRestSender restSender = new RequestRestSender(httpSender, apiVersion, tokenAccess.getToken(), contentTypeSameAsAccept);
        if (urlParameters != null) {
            httpSender.setUrlParameters(urlParameters);
        }
        if (requestProperties != null) {
            for (Map.Entry<String, String> entry : requestProperties.entrySet()) {
                httpSender.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return restSender.getResponse();
    }

    private static void checkConfiguration() throws AllerException {
        if (configuration == null) {
            throw new AllerException("Set rest manager configuration");
        }
    }

    /**
     * Sets configuration.
     *
     * @param configuration the configuration
     */
    public static void setConfiguration(RestManagerConfiguration configuration) {
        RestManager.configuration = configuration;
        TokenManager.setConfiguration(configuration.getTokenManagerConfiguration());
    }

    /**
     * Gets seller id.
     *
     * @param loginAllegro the login allegro
     * @return the seller id
     * @throws AllerException the aller exception
     */
    public static String getSellerId(String loginAllegro) throws AllerException {
        checkConfiguration();
        TokenAccess tokenAccess = TokenManager.getTokenAccess(loginAllegro);
        return new JwtTokenExtractor(tokenAccess.getToken()).extract().getUsername();
    }
}
