package com.appscharles.libs.aller.authorizations;

import com.appscharles.libs.aller.exceptions.AllerException;

/**
 * The interface Code authorization.
 */
public interface ICodeAuthorization {

    /**
     * Gets code.
     *
     * @return the code
     * @throws AllerException the aller exception
     */
    String getCode() throws AllerException;
}
