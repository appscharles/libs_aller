package com.appscharles.libs.aller.senders;

import com.appscharles.libs.aller.exceptions.AllerException;

/**
 * The interface Http responsable.
 */
public interface IHttpResponsable {

    /**
     * Gets response.
     *
     * @return the response
     * @throws AllerException the aller exception
     */
    String getResponse() throws AllerException;
}
