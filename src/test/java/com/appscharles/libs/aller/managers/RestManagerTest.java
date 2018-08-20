package com.appscharles.libs.aller.managers;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.senders.rest.ApiVersion;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 18.08.2018
 * Time: 14:14
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class RestManagerTest extends TestCase {

    @Test
    public void shouldGetResponseByGetMethod() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String response = RestManager.get("sale/delivery-methods", ApiVersion.V1, getLoginAllegro());
        Assert.assertFalse(response.isEmpty());
    }

    @Test
    public void shouldGetResponseByPostMethod() throws AllerException, IOException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String json = readTestResource("com/appscharles/libs/aller/managers/PutPointsOfService.json");
        System.out.println(RestManager.getSellerId(getLoginAllegro()));
        json = json.replace("{{sellerId}}", RestManager.getSellerId(getLoginAllegro()));
        String response = RestManager.post("points-of-service", ApiVersion.V1,json, getLoginAllegro(), true);
        System.out.println(response);
        Assert.assertFalse(response.isEmpty());
    }
}