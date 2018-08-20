package com.appscharles.libs.aller.authorizations.browser;

import com.appscharles.libs.aller.authorizations.ICodeAuthorization;
import com.appscharles.libs.aller.authorizations.browser.business.configurations.BrowserCodeAuthorizationConfiguration;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.FXStageFactory;
import com.appscharles.libs.fxer.factories.IFXStageFactory;
import com.appscharles.libs.fxer.stages.FXStage;

/**
 * The type Browser code authorization.
 */
public class BrowserCodeAuthorization implements ICodeAuthorization {

    private BrowserCodeAuthorizationConfiguration configuration;

    /**
     * Instantiates a new Browser code authorization.
     *
     * @param configuration the configuration
     */
    public BrowserCodeAuthorization(BrowserCodeAuthorizationConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String getCode() throws AllerException {
        try {
            BrowserCodeAuthorizationController controller = new BrowserCodeAuthorizationController(this.configuration);
            IFXStageFactory stageFactory = new FXStageFactory("/com/appscharles/libs/aller/authorizations/browser/BrowserCodeAuthorizationView.fxml",
                    "com/appscharles/libs/aller/authorizations/browser/translations/BrowserCodeAuthorization");
            stageFactory.setIcon("/com/appscharles/libs/aller/authorizations/CodeAuthorizationIcon.png");
            stageFactory.setController(controller);
            FXStage stage = stageFactory.create();
            stage.setResizable(false);
            stage.showAndWaitFX();
            return controller.getCode();
        } catch (FxerException e) {
            throw new AllerException(e);
        }
    }
}
