package com.appscharles.libs.aller._tools;

import com.appscharles.libs.aller.builders.RestManagerConfigurationBuilder;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.getters.PromotionsGetter;
import com.appscharles.libs.aller.getters.RegularSellerAuctionGetter;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.managers.RestManagerConfiguration;
import com.appscharles.libs.aller.models.offersListing.ListingOffer;
import com.appscharles.libs.aller.models.promotions.*;
import com.appscharles.libs.aller.models.promotions.enums.BenefitSpecificationType;
import com.appscharles.libs.aller.models.promotions.enums.PromotionCriteriaType;
import com.appscharles.libs.aller.rests.PromotionRest;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Zestawy.
 */
public class SetTool {

    private static final String LOGIN_ALLEGRO = "xxx";
    
    private static final String OFFER_WITH_TITLE = "KOŁO PASOWE";

    private static final String INCLUDE_AUCTION = "xxx";

    private static final String CLIENT_ID = "xxx";

    private static final String CLIENT_SECRET = "xxx";

    private List<SellerRebate> promotions;

    private List<ListingOffer> listingOffers;

    public SetTool() throws AllerException {
        RestManagerConfiguration restManagerConfiguration = RestManagerConfigurationBuilder
                .create(false, CLIENT_ID, CLIENT_SECRET, 11001, "salt", new File("E:\\others\\tests\\libs\\aller", "SetToolTokens.data")).build();
        RestManager.setConfiguration(restManagerConfiguration);
        promotions = getAllPromotions();
        listingOffers = getAllOffers();
    }

    public static void main(String[] args) throws AllerException {
        new SetTool().run();
    }
    
    private void run() throws AllerException {
        Integer counter = 0;
        List<ListingOffer> offers = getOffersByTitle(OFFER_WITH_TITLE);
        for (ListingOffer offer : offers) {
            counter++;
            System.out.println(counter + " of " + offers.size() + ": " + offer.getName());
            if (isSet(offer)){
                continue;
            }
            SellerCreateRebateRequest request = new SellerCreateRebateRequest(
                    Lists.newArrayList(new Benefit(new BenefitSpecification(
                            BenefitSpecificationType.ORDER_FIXED_DISCOUNT,
                            new BenefitSpecificationValue(0.0, "PLN")
                    ))),
                    Lists.newArrayList(new PromotionOfferCriterium(
                            Lists.newArrayList(
                                    new PromotionOffer(offer.getId(), 1, true),
                                    new PromotionOffer(INCLUDE_AUCTION, 1, false)
                            ), PromotionCriteriaType.CONTAINS_OFFERS
                    ))
            );
            PromotionRest.add(request, LOGIN_ALLEGRO);
        }
        System.out.println("END");
    }

    private List<ListingOffer> getOffersByTitle(String containsText) {
        return listingOffers.stream().filter(offer->offer.getName().toLowerCase().contains(containsText.toLowerCase())).collect(Collectors.toList());
    }

    private Boolean isSet(ListingOffer listingOffer) {
        for (SellerRebate promotion : promotions) {
            for (PromotionOfferCriterium offerCriterion : promotion.getOfferCriteria()) {
                for (PromotionOffer promotionOffer : offerCriterion.getOffers()) {
                    if (promotionOffer.getId().equals(listingOffer.getId())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private List<SellerRebate> getAllPromotions() throws AllerException {
        String userId = RestManager.getSellerId(LOGIN_ALLEGRO);
        Map<String, String> parameters = new HashMap<>(ImmutableMap.of("user.id", userId));
        return new PromotionsGetter().get(parameters, LOGIN_ALLEGRO);
    }

    private List<ListingOffer> getAllOffers() throws AllerException {
        List<ListingOffer> offers = Lists.newArrayList();
     //   offers.addAll(new ClosedSellerAuctionGetter().getAll(LOGIN_ALLEGRO));
        offers.addAll(new RegularSellerAuctionGetter().getAll(LOGIN_ALLEGRO));
        return offers;
    }
}
