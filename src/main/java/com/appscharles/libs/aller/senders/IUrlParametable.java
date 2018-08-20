package com.appscharles.libs.aller.senders;

import java.util.Map;

/**
 * The interface Url parametable.
 */
public interface IUrlParametable {

    /**
     * Add url parameter t.
     *
     * @param <T>   the type parameter
     * @param key   the key
     * @param value the value
     * @return the t
     */
    <T>  T addUrlParameter(String key, String value);

    /**
     * Sets url parameters.
     *
     * @param <T>           the type parameter
     * @param urlParameters the url parameters
     * @return the url parameters
     */
    <T>  T setUrlParameters(Map<String, String> urlParameters);
}
