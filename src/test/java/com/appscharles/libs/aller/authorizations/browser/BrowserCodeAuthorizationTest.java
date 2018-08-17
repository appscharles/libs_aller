package com.appscharles.libs.aller.authorizations.browser;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.accesses.ApiKeyAccess;
import com.appscharles.libs.aller.authorizations.browser.business.configurations.BrowserCodeAuthorizationConfiguration;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.getters.AvailablePortGetter;
import com.sun.javafx.application.PlatformImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 16.08.2018
 * Time: 11:13
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class BrowserCodeAuthorizationTest extends TestCase {

    @Test
    public void shouldGetCodeAuthorization() throws AllerException, IOException {
        PlatformImpl.startup(()->{});
        PlatformImpl.setImplicitExit(false);
        String loginAllegro = getProperties().getProperty("libs_aller.test.login_allegro");
        ApiKeyAccess apiKeyAccess = getApiKeyAccess();
        Integer port = AvailablePortGetter.get(11001);
        BrowserCodeAuthorizationConfiguration configuration = new BrowserCodeAuthorizationConfiguration(new URL("https://allegro.pl.allegrosandbox.pl/auth/oauth"), apiKeyAccess.getClientId(), loginAllegro, port, "OK");
        BrowserCodeAuthorization browserCodeAuthorization = new BrowserCodeAuthorization(configuration);
        String code = browserCodeAuthorization.getCode();
        Assert.assertNotNull(code);
        Assert.assertFalse(code.isEmpty());
    }


}