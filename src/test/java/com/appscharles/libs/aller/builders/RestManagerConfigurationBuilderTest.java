package com.appscharles.libs.aller.builders;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManagerConfiguration;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 21.08.2018
 * Time: 10:10
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class RestManagerConfigurationBuilderTest {

    @Test
    public void shouldCreateRestManagerConfiguration() throws AllerException {
        RestManagerConfigurationBuilder configurationBuilder =
                RestManagerConfigurationBuilder.create(true, "id", "secret",
                        11001, "salt", new File("file"));
        configurationBuilder.setHtmlSuccessResponse("HTML")
                .setIpRequestPerSeconds(130);
                RestManagerConfiguration configuration = configurationBuilder.build();
        Assert.assertNotNull(configuration);

    }
}