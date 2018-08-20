package com.appscharles.libs.aller.authorizations.browser;

import com.appscharles.libs.aller.authorizations.browser.business.configurations.BrowserCodeAuthorizationConfiguration;
import com.appscharles.libs.aller.authorizations.browser.business.services.AsyncOpenBrowserService;
import com.appscharles.libs.aller.authorizations.browser.business.services.ListenerCodeService;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.fxer.controllers.AbstractControllerFX;
import com.sun.javafx.application.PlatformImpl;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.WindowEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type Browser code authorization controller.
 */
public class BrowserCodeAuthorizationController extends AbstractControllerFX {

    private static final Logger logger = LogManager.getLogger(BrowserCodeAuthorizationController.class);

    /**
     * The Resource bundle.
     */
    public ResourceBundle resourceBundle;

    /**
     * The Configuration.
     */
    public BrowserCodeAuthorizationConfiguration configuration;

    /**
     * The Web view.
     */
    @FXML
    public WebView webView;

    /**
     * The Web engine.
     */
    public WebEngine webEngine;

    private String code;

    /**
     * The Login.
     */
    @FXML
    public Label login;

    /**
     * The Progress bar.
     */
    @FXML
    public ProgressBar progressBar;

    private AsyncOpenBrowserService asyncOpenBrowserService;

    private ListenerCodeService listenerCodeService;

    private ObjectProperty<Exception> exception;

    /**
     * Instantiates a new Browser code authorization controller.
     *
     * @param configuration the configuration
     */
    public BrowserCodeAuthorizationController(BrowserCodeAuthorizationConfiguration configuration) {
        this.configuration = configuration;
        this.exception = new SimpleObjectProperty<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        Platform.runLater(() -> {
            this.fXStage.setTitle(this.resourceBundle.getString("stage.title"));
            this.login.setText(this.configuration.getLoginAllegro());
        });
        this.webEngine = this.webView.getEngine();
        this.webEngine.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        this.asyncOpenBrowserService = new AsyncOpenBrowserService(this.configuration, this.webView);
        this.listenerCodeService = new ListenerCodeService(this.configuration);
        this.fXStage.setOnHidden(event->{
            this.listenerCodeService.interrupt();
        });
        this.progressBar.progressProperty().bind(this.webEngine.getLoadWorker().progressProperty());
        this.webEngine.getLoadWorker().stateProperty().addListener((args, oldVal, newVal) ->{
            if (newVal == Worker.State.SUCCEEDED){
                this.progressBar.setVisible(false);
            } else if (newVal == Worker.State.RUNNING){
                this.progressBar.setVisible(true);
            }
        });
    }

    @Override
    public void onShown(WindowEvent event) {
        this.asyncOpenBrowserService.open();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(()->{
            try {
                this.code = this.listenerCodeService.waitAndGet();
                PlatformImpl.runLater(()-> {
                    this.fXStage.close();
                });
            } catch (AllerException e) {
                this.exception.setValue(e);
                PlatformImpl.runLater(()-> {
                    this.fXStage.close();
                });
            }
        });
        service.shutdown();
    }

    /**
     * Gets code.
     *
     * @return the code
     * @throws AllerException the aller exception
     */
    public String getCode() throws AllerException {
        if (this.asyncOpenBrowserService.getException() != null) {
            throw new AllerException(this.asyncOpenBrowserService.getException());
        }
        if (this.exception.getValue() != null){
            throw new AllerException(this.exception.getValue());
        }
        if (this.code == null) {
            throw new AllerException("Code is null");
        }
        return this.code;
    }
}
