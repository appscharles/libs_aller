package com.appscharles.libs.aller.senders.rest;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.senders.IHttpSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Request rest sender.
 */
public class RequestRestSender extends AbstractRestSender {

    private static final Logger logger = LogManager.getLogger(RequestRestSender.class);

    /**
     * Instantiates a new Request rest sender.
     *
     * @param httpSender              the http sender
     * @param apiVersion              the api version
     * @param token                   the token
     * @param contentTypeSameAsAccept the content type same as accept
     */
    public RequestRestSender(IHttpSender httpSender, ApiVersion apiVersion, String token, Boolean contentTypeSameAsAccept) {
        super(httpSender, apiVersion, token, contentTypeSameAsAccept);
    }

    @Override
    public String getResponse() throws AllerException {
        this.httpSender.addRequestProperty("Accept-Language", "pl-PL");
        this.httpSender.addRequestProperty("Authorization", "Bearer " + this.token);
        try {
            this.httpSender.addRequestProperty("Accept", "application/vnd.allegro.public." + this.apiVersion.getVersion() +"+json");
            if (this.contentTypeSameAsAccept){
                this.httpSender.addRequestProperty("Content-Type", "application/vnd.allegro.public." + this.apiVersion.getVersion() +"+json" );
            }
            return this.httpSender.getResponse();
        } catch (AllerException e) {
            logger.debug(e, e);
            this.httpSender.addRequestProperty("Accept", "application/vnd.allegro.beta." + this.apiVersion.getVersion() +"+json");
            if (this.contentTypeSameAsAccept){
                this.httpSender.addRequestProperty("Content-Type", "application/vnd.allegro.beta." + this.apiVersion.getVersion() +"+json" );
            }
            return this.httpSender.getResponse();
        }
    }
}
