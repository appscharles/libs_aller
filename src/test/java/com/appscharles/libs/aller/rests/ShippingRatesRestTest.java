package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.DeliveryMethod;
import com.appscharles.libs.aller.models.ShippingRate;
import com.appscharles.libs.aller.models.shippingRate.ItemRate;
import com.appscharles.libs.aller.models.shippingRate.Rate;
import com.appscharles.libs.aller.models.shippingRate.ShippingTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 16:00
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ShippingRatesRestTest extends TestCase {

    @Test
    public void shouldGetShippingRates() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        List<ShippingRate> list = ShippingRatesRest.getAll(sellerId, getLoginAllegro());
    }

    @Test
    public void shouldAddShippingRate() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        ShippingRate shippingRate = null;
        for (ShippingRate rate : ShippingRatesRest.getAll(RestManager.getSellerId(getLoginAllegro()), getLoginAllegro())) {
            shippingRate = ShippingRatesRest.get(rate.getId(), getLoginAllegro());
            break;
        }
        if (shippingRate == null || shippingRate.getRates() == null){
            throw new AllerException("Shipping rate is null, add shipping rate");
        }
        Assert.assertNotNull(shippingRate.getId());
    }

    @Test
    public void shouldGetShippingRate() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        Boolean got = false;
        List<ShippingRate> list = ShippingRatesRest.getAll(sellerId, getLoginAllegro());
        for (ShippingRate shippingRate : list) {
            ShippingRate sR = ShippingRatesRest.get(shippingRate.getId(), getLoginAllegro());
            if (sR != null){
                got = true;
                break;
            }
        }
        Assert.assertTrue(got);
    }

    @Test
    public void shouldUpdateShippingRate() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        ShippingRate shippingRate = ShippingRatesRest.getAll(sellerId, getLoginAllegro()).get(0);
        shippingRate = ShippingRatesRest.get(shippingRate.getId(), getLoginAllegro());
        shippingRate.setName("New name");
        ShippingRatesRest.update(shippingRate, getLoginAllegro());
        shippingRate = ShippingRatesRest.get(shippingRate.getId(), getLoginAllegro());
        Assert.assertTrue(shippingRate.getName().contains("New name"));
    }
}