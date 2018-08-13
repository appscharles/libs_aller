package com.appscharles.libs.aller.getters;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.listeners.AuthorizationCodeListener;
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
 * The type Authorize code getter.
 */
public class AuthorizeCodeGetter extends AbstractAuthorizeCodeGetter {

    private final static String DEFAULT_AUTHORIZATION_END_POINT = "https://allegro.pl/auth/oauth/";

    private static final Logger logger = LogManager.getLogger(AuthorizeCodeGetter.class);

    private Integer[] redirectPorts;

    private String htmlSuccessResponse;

    private String htmlFailedResponse;

    private ResourceBundle resourceBundle;

    private String iconStageResource;

    private URL authorizationEndPoint;

    private String clientId;

    private long timeout;

    /**
     * Instantiates a new Authorize code getter.
     *
     * @param redirectPorts the redirect ports
     */
    public AuthorizeCodeGetter(String clientId, long timeout, Integer... redirectPorts) {
        this.clientId = clientId;
        this.timeout = timeout;
        this.redirectPorts = redirectPorts;
        this.resourceBundle = ResourceBundle.getBundle("com/appscharles/libs/aller/getters/translations/OpenBrowser", new UTF8Control());
    }

    public String get() throws AllerException {
        try {
            this.authorizationEndPoint = (this.authorizationEndPoint == null)? new URL(DEFAULT_AUTHORIZATION_END_POINT) : this.authorizationEndPoint;
        } catch (MalformedURLException e) {
           throw new AllerException(e);
        }
        Integer port = AvailablePortGetter.get(this.redirectPorts);
        String patternAllegroAuthorizeUrl = this.authorizationEndPoint + "authorize?response_type=code&client_id=%1$s&redirect_uri=%2$s";
        String redirectUrl = "http://localhost:" + port;
        AuthorizationCodeListener codeListener = new AuthorizationCodeListener(port, this.timeout);
        if (this.htmlSuccessResponse != null) {
            codeListener.setHtmlSuccessResponse(this.htmlSuccessResponse);
        }
        if (this.htmlFailedResponse != null) {
            codeListener.setHtmlFailedResponse(this.htmlFailedResponse);
        }
        ObjectProperty<Alert> alert = new SimpleObjectProperty<>();
        ObjectProperty<Alert> alertError = new SimpleObjectProperty<>();
        StringProperty code = new SimpleStringProperty();
        if (this.test == false) {
            PlatformImpl.startup(() -> {
            });
            PlatformImpl.runAndWait(() -> {
                AlertFactory alertFactory = AlertFactory.create(Alert.AlertType.INFORMATION, this.resourceBundle.getString("dialog.title"), "")
                        .setHeaderText(this.resourceBundle.getString("dialog.content_text.open_browser_and_authorize"))
                        .setIconStageResource((this.iconStageResource != null) ? this.iconStageResource : "/com/appscharles/libs/aller/getters/OpenBrowserIcon.png");
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
                                        .setIconStageResource((this.iconStageResource != null) ? this.iconStageResource : "/com/appscharles/libs/aller/getters/OpenBrowserIcon.png");
                                alertError.setValue(alertErrorFactory.build());
                                alertError.get().show();
                                event.consume();
                            }
                        }
                );
                alert.get().getDialogPane().setContent(hyperlink);
                alert.get().setOnCloseRequest((event) -> {
                    if (code.getValue() == null) {
                        codeListener.interrupt();
                    }
                    if (alertError.get() != null) {
                        PlatformImpl.runAndWait(() -> {
                            alertError.get().close();
                        });
                    }
                });

                alert.get().show();
            });
        }
        try {
            code.setValue(codeListener.waitAndGet());
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
     * Sets html success response.
     *
     * @param html the html
     */
    public void setHtmlSuccessResponse(String html) {
        this.htmlSuccessResponse = html;
    }

    /**
     * Sets html failed response.
     *
     * @param html the html
     */
    public void setHtmlFailedResponse(String html) {
        this.htmlFailedResponse = html;
    }

    /**
     * Setter for property 'iconStageResource'.
     *
     * @param iconStageResource Value to set for property 'iconStageResource'.
     */
    public void setIconStageResource(String iconStageResource) {
        this.iconStageResource = iconStageResource;
    }

    /**
     * Setter for property 'authorizationEndPoint'.
     *
     * @param authorizationEndPoint Value to set for property 'authorizationEndPoint'.
     */
    public void setAuthorizationEndPoint(URL authorizationEndPoint) {
        this.authorizationEndPoint = authorizationEndPoint;
    }
}
