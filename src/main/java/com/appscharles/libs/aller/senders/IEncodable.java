package com.appscharles.libs.aller.senders;

/**
 * The interface Encodable.
 */
public interface IEncodable {

    /**
     * Sets encoding.
     *
     * @param <T>      the type parameter
     * @param encoding the encoding
     * @return the encoding
     */
    <T>  T setEncoding(String encoding);
}
