package com.appscharles.libs.aller.senders;

/**
 * The interface Request propertable.
 */
public interface IRequestPropertable {

    /**
     * Add request property t.
     *
     * @param <T>   the type parameter
     * @param key   the key
     * @param value the value
     * @return the t
     */
    <T>  T addRequestProperty(String key, String value);
}
