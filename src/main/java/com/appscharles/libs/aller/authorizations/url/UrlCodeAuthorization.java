package com.appscharles.libs.aller.authorizations.url;

import com.appscharles.libs.aller.authorizations.ICodeAuthorization;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.listeners.IAuthorizationCodeListener;
import com.appscharles.libs.dialoger.factories.AlertFactory;
import com.appscharles.libs.fxer.controls.UTF8Control;
import com.sun.javafx.application.PlatformImpl;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Code authorization.
 */
public class UrlCodeAuthorization implements ICodeAuthorization {

    private final static String DEFAULT_AUTHORIZATION_END_POINT = "https://allegro.pl/auth/oauth/";

    private static final Logger logger = LogManager.getLogger(UrlCodeAuthorization.class);

    private Integer redirectPort;

    private IAuthorizationCodeListener authorizationCodeListener;

    private ResourceBundle resourceBundle;

    private String iconStageResource;

    private URL authorizationEndPoint;

    private String clientId;

    /**
     * Instantiates a new Code authorization.
     *
     * @param clientId                  the client id
     * @param redirectPort              the redirect port
     * @param authorizationCodeListener the authorization code listener
     */
    public UrlCodeAuthorization(String clientId, Integer redirectPort, IAuthorizationCodeListener authorizationCodeListener) {
        this.clientId = clientId;
        this.redirectPort = redirectPort;
        this.authorizationCodeListener = authorizationCodeListener;
        this.resourceBundle = ResourceBundle.getBundle("com/appscharles/libs/aller/authorizations/url/translations/UrlCodeAuthorization", new UTF8Control());
    }

    public String getCode() throws AllerException {
        try {
            this.authorizationEndPoint = (this.authorizationEndPoint == null)? new URL(DEFAULT_AUTHORIZATION_END_POINT) : this.authorizationEndPoint;
        } catch (MalformedURLException e) {
           throw new AllerException(e);
        }
        String patternAllegroAuthorizeUrl = this.authorizationEndPoint + "authorize?response_type=code&client_id=%1$s&redirect_uri=%2$s";
        String redirectUrl = "http://localhost:" + this.redirectPort;
        ObjectProperty<Alert> alert = new SimpleObjectProperty<>();
        ObjectProperty<Alert> alertError = new SimpleObjectProperty<>();
        StringProperty code = new SimpleStringProperty();
        PlatformImpl.startup(() -> {
        });
        PlatformImpl.runAndWait(() -> {
            AlertFactory alertFactory = AlertFactory.create(Alert.AlertType.INFORMATION, this.resourceBundle.getString("dialog.title"), "")
                    .setHeaderText(this.resourceBundle.getString("dialog.content_text.open_browser_and_authorize"))
                    .setIconStageResource((this.iconStageResource != null) ? this.iconStageResource : "/com/appscharles/libs/aller/authorizations/CodeAuthorizationIcon.png");
            alert.setValue(alertFactory.build());
            Hyperlink hyperlink = new Hyperlink(String.format(patternAllegroAuthorizeUrl, "\n" + this.clientId, redirectUrl));
            hyperlink.setFocusTraversable(false);
            hyperlink.setOnAction((event) -> {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI(String.format(patternAllegroAuthorizeUrl, this.clientId, redirectUrl)));
                    } catch (IOException | URISyntaxException e) {
                        logger.error(e);
                    }
                }
            });
            final Button buttonOk = (Button) alert.get().getDialogPane().lookupButton(alertFactory.getButtonOk());
            buttonOk.addEventFilter(ActionEvent.ACTION,
                    event -> {
                        if (code.getValue() == null) {
                            AlertFactory alertErrorFactory = AlertFactory.create(Alert.AlertType.ERROR, this.resourceBundle.getString("dialog.title"), this.resourceBundle.getString("dialog.content_text.no_authorization"))
                                    .setIconStageResource((this.iconStageResource != null) ? this.iconStageResource : "/com/appscharles/libs/aller/authorizations/OpenBrowserIcon.png");
                            alertError.setValue(alertErrorFactory.build());
                            alertError.get().show();
                            event.consume();
                        }
                    }
            );
            alert.get().getDialogPane().setContent(hyperlink);
            alert.get().setOnCloseRequest((event) -> {
                if (code.getValue() == null) {
                    this.authorizationCodeListener.interrupt();
                }
                if (alertError.get() != null) {
                    PlatformImpl.runAndWait(() -> {
                        alertError.get().close();
                    });
                }
            });

            alert.get().show();
        });
        try {
            code.setValue(this.authorizationCodeListener.waitAndGet());
        } finally {
            if (alert.get() != null && alert.get().isShowing()) {
                PlatformImpl.runAndWait(() -> {
                    alert.get().close();
                });
            }
        }
        return code.getValue();
    }

    /**
     * Sets icon stage resource.
     *
     * @param iconStageResource the icon stage resource
     */
    public void setIconStageResource(String iconStageResource) {
        this.iconStageResource = iconStageResource;
    }

    /**
     * Sets authorization end point.
     *
     * @param authorizationEndPoint the authorization end point
     */
    public void setAuthorizationEndPoint(URL authorizationEndPoint) {
        this.authorizationEndPoint = authorizationEndPoint;
    }
}
