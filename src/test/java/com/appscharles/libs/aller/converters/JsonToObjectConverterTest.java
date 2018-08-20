package com.appscharles.libs.aller.converters;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.PointsOfService;
import com.appscharles.libs.aller.senders.rest.ApiVersion;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 08:32
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class JsonToObjectConverterTest extends TestCase {

    @Test
    public void shouldConvertJsonToObject() throws AllerException, IOException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String json = readTestResource("com/appscharles/libs/aller/managers/PutPointsOfService.json");
        json = json.replace("{{sellerId}}", RestManager.getSellerId(getLoginAllegro()));
        String response = RestManager.post("points-of-service", ApiVersion.V1,json, getLoginAllegro(), true);
        PointsOfService pointsOfService = JsonToObjectConverter.convert(response, PointsOfService.class);
        Assert.assertNotNull(pointsOfService);
    }
}