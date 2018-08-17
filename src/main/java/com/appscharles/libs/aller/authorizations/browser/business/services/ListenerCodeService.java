package com.appscharles.libs.aller.authorizations.browser.business.services;

import com.appscharles.libs.aller.authorizations.browser.business.configurations.BrowserCodeAuthorizationConfiguration;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.listeners.BrowserAuthorizationCodeListener;
import com.appscharles.libs.aller.listeners.IAuthorizationCodeListener;

/**
 * The type Listener code service.
 */
public class ListenerCodeService {

    private BrowserCodeAuthorizationConfiguration configuration;

    private IAuthorizationCodeListener authorizationCodeListener;

    /**
     * Instantiates a new Listener code service.
     *
     * @param configuration the configuration
     */
    public ListenerCodeService(BrowserCodeAuthorizationConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * Wait and get string.
     *
     * @return the string
     * @throws AllerException the aller exception
     */
    public String waitAndGet() throws AllerException {
        try {
            this.authorizationCodeListener = new BrowserAuthorizationCodeListener(this.configuration.getRedirectPort(), this.configuration.getHtmlSuccessResponse());
            return authorizationCodeListener.waitAndGet();
        } catch (AllerException e) {
            throw new AllerException(e);
        }
    }

    /**
     * Interrupt.
     */
    public void interrupt(){
        if (this.authorizationCodeListener != null){
            this.authorizationCodeListener.interrupt();
        }
    }
}
