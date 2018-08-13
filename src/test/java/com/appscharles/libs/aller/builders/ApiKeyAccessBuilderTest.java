package com.appscharles.libs.aller.builders;

import com.appscharles.libs.aller.accesses.ApiKeyAccess;
import com.appscharles.libs.aller.exceptions.AllerException;
import org.junit.Test;

import java.io.File;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.08.2018
 * Time: 11:41
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ApiKeyAccessBuilderTest {

    @Test
    public void shouldBuildApiKeyAccess() throws AllerException {
        ApiKeyAccess apiKeyAccess = ApiKeyAccessBuilder.create(new File(System.getProperty("user.home"), "appscharles/libs/aller/properties.properties")).build();
    }
}