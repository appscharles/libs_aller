package com.appscharles.libs.aller.authorizations;

import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.exceptions.AllerException;

/**
 * The interface Token authorization.
 */
public interface ITokenAuthorization {

    /**
     * Gets token access.
     *
     * @return the token access
     * @throws AllerException the aller exception
     */
    TokenAccess getTokenAccess() throws AllerException;
}
