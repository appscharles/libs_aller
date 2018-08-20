package com.appscharles.libs.aller.senders.rest;

import com.appscharles.libs.aller.senders.IHttpSender;

/**
 * The type Abstract rest sender.
 */
public abstract class AbstractRestSender implements IRestSender {

    /**
     * The Http sender.
     */
    protected IHttpSender httpSender ;

    /**
     * The Token.
     */
    protected String token;

    /**
     * The Api version.
     */
    protected ApiVersion apiVersion;

    /**
     * The Content type same as accept.
     */
    protected Boolean contentTypeSameAsAccept;

    /**
     * Instantiates a new Abstract rest sender.
     *
     * @param httpSender              the http sender
     * @param apiVersion              the api version
     * @param token                   the token
     * @param contentTypeSameAsAccept the content type same as accept
     */
    public AbstractRestSender(IHttpSender httpSender, ApiVersion apiVersion, String token, Boolean contentTypeSameAsAccept) {
        this.httpSender = httpSender;
        this.apiVersion = apiVersion;
        this.token = token;
        this.contentTypeSameAsAccept = contentTypeSameAsAccept;
    }
}
