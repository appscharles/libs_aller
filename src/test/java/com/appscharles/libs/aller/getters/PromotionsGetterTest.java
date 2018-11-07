package com.appscharles.libs.aller.getters;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.promotions.SellerRebate;
import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type PromotionsGetterTest.
 */
public class PromotionsGetterTest extends TestCase {

    @Test
    public void shouldGetPromotions() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String userId = RestManager.getSellerId(getLoginAllegro());
        Map<String, String> parameters = new HashMap<>(ImmutableMap.of("user.id", userId));
        PromotionsGetter getter = new PromotionsGetter();
        List<SellerRebate> promotions =  getter.get(parameters, getLoginAllegro());
        Assert.assertNotNull(promotions.size() > 0);
    }


}