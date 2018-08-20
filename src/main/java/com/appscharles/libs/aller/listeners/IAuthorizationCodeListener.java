package com.appscharles.libs.aller.listeners;

import com.appscharles.libs.aller.exceptions.AllerException;

/**
 * The interface Authorization code listener.
 */
public interface IAuthorizationCodeListener extends IInterruptable {

    /**
     * Wait and get string.
     *
     * @return the string
     * @throws AllerException the aller exception
     */
    String waitAndGet() throws AllerException;
}
