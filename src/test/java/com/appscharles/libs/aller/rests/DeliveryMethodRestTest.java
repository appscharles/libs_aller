package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.DeliveryMethod;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 15:52
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class DeliveryMethodRestTest extends TestCase {

    @Test
    public void shouldGetDeliveryMethods() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        List<DeliveryMethod> deliveryMethods = DeliveryMethodRest.getAll(getLoginAllegro());
        Assert.assertTrue(deliveryMethods.size()>0);
    }
}