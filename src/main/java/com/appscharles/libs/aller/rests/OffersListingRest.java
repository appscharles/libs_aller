package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.PointOfService;
import com.appscharles.libs.aller.senders.rest.ApiVersion;
import com.google.common.collect.ImmutableMap;

/**
 * The type Offers listing rest.
 */
public class OffersListingRest {

    private static final ApiVersion API_VERSION = ApiVersion.V1;

    private static final String RESOURCE = "offers/listing";


    /**
     * Get points of service.
     *
     * @param sellerId     the seller id
     * @param loginAllegro the login allegro
     * @return the points of service
     * @throws AllerException the aller exception
     */
    public static PointOfService get(String sellerId, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE, API_VERSION, ImmutableMap.of("seller.id", sellerId), loginAllegro);
        System.out.println(response);
        return null;
        //return JsonToObjectConverter.convert(response, PointsOfService.class);
    }
}
