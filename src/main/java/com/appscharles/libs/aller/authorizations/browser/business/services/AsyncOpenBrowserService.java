package com.appscharles.libs.aller.authorizations.browser.business.services;

import com.appscharles.libs.aller.authorizations.browser.business.builders.UrlCodeAuthorizationBrowserBuilder;
import com.appscharles.libs.aller.authorizations.browser.business.configurations.BrowserCodeAuthorizationConfiguration;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.weber.exceptions.WeberException;
import com.appscharles.libs.weber.services.Web;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type Async open browser service.
 */
public class AsyncOpenBrowserService {


    private BrowserCodeAuthorizationConfiguration configuration;

    private WebView webView;

    private ObjectProperty<Exception> exception;

    /**
     * Instantiates a new Async open browser service.
     *
     * @param configuration the configuration
     * @param webView       the web view
     */
    public AsyncOpenBrowserService(BrowserCodeAuthorizationConfiguration configuration, WebView webView) {
        this.configuration = configuration;
        this.webView = webView;
        this.exception = new SimpleObjectProperty<>();
    }

    /**
     * Open.
     */
    public void open() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(()->{
            Web web = new Web(this.webView);
            try {
               URL urlAuthorizationCodeBrowser = UrlCodeAuthorizationBrowserBuilder.create(this.configuration.getClientId(), this.configuration.getAuthorizationEndPoint(), this.configuration.getRedirectPort()).build();
                web.navigate(urlAuthorizationCodeBrowser.toString());
            } catch (WeberException | AllerException e) {
                this.exception.setValue(e);
            }
        });
        service.shutdown();
    }

    /**
     * Gets exception.
     *
     * @return the exception
     */
    public Exception getException() {
        return exception.get();
    }
}
