package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.getters.PromotionsGetter;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.promotions.*;
import com.appscharles.libs.aller.models.promotions.enums.BenefitSpecificationType;
import com.appscharles.libs.aller.models.promotions.enums.PromotionCriteriaType;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type PromotionRestTest.
 */
public class PromotionRestTest extends TestCase {

    @Test
    public void shouldGetPromotions() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String userId = RestManager.getSellerId(getLoginAllegro());
        Map<String, String> parameters = ImmutableMap.of("user.id", userId, "limit", "50", "offset", "0");
        SellerRebates response = PromotionRest.get(parameters, getLoginAllegro());
        Assert.assertNotNull(response);
    }

    @Test
    public void shouldAddPromotions() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String userId = RestManager.getSellerId(getLoginAllegro());
        Map<String, String> parameters = new HashMap<>(ImmutableMap.of("user.id", userId));
        List<SellerRebate> promotions = new PromotionsGetter().get(parameters,getLoginAllegro());
        for (SellerRebate promotion : promotions) {
            PromotionRest.delete(promotion.getId(), getLoginAllegro());
        }

        SellerCreateRebateRequest request = new SellerCreateRebateRequest(
                Lists.newArrayList(new Benefit(new BenefitSpecification(
                        BenefitSpecificationType.ORDER_FIXED_DISCOUNT,
                        new BenefitSpecificationValue(0.0, "PLN")
                ))),
                Lists.newArrayList(new PromotionOfferCriterium(
                        Lists.newArrayList(
                                new PromotionOffer("6205627173", 1, true),
                                new PromotionOffer("6205615805", 1, false)
                        ), PromotionCriteriaType.CONTAINS_OFFERS
                ))
        );

        PromotionRest.add(request, getLoginAllegro());
        SellerRebates response = PromotionRest.get(parameters, getLoginAllegro());
        Integer sizeAfter = response.getTotalCount();
        Assert.assertTrue(sizeAfter.equals(1));
    }

    @Test
    public void shouldDeletePromotions() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String userId = RestManager.getSellerId(getLoginAllegro());
        Map<String, String> parameters = new HashMap<>(ImmutableMap.of("user.id", userId));
        List<SellerRebate> promotions = new PromotionsGetter().get(parameters,getLoginAllegro());
        for (SellerRebate promotion : promotions) {
            PromotionRest.delete(promotion.getId(), getLoginAllegro());
        }
        SellerCreateRebateRequest request = new SellerCreateRebateRequest(
                Lists.newArrayList(new Benefit(new BenefitSpecification(
                        BenefitSpecificationType.ORDER_FIXED_DISCOUNT,
                        new BenefitSpecificationValue(0.0, "PLN")
                ))),
                Lists.newArrayList(new PromotionOfferCriterium(
                        Lists.newArrayList(
                                new PromotionOffer("6205627173", 1, true),
                                new PromotionOffer("6205615805", 1, false)
                        ), PromotionCriteriaType.CONTAINS_OFFERS
                ))
        );

        SellerRebate promotionAdded = PromotionRest.add(request, getLoginAllegro());
      PromotionRest.delete(promotionAdded.getId(), getLoginAllegro());
    }
}