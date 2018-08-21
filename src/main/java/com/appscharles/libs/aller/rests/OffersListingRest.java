package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.converters.JsonToObjectConverter;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.offersListing.ListingResponse;
import com.appscharles.libs.aller.senders.rest.ApiVersion;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * The type Offers listing rest.
 */
public class OffersListingRest {

    private static final ApiVersion API_VERSION = ApiVersion.V1;

    private static final String RESOURCE = "offers/listing";


    /**
     * Get listing response.
     *
     * @param parameters   the parameters
     * @param loginAllegro the login allegro
     * @return the listing response
     * @throws AllerException the aller exception
     */
    public static ListingResponse get(Map<String, String> parameters, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE, API_VERSION, parameters, loginAllegro);
        return JsonToObjectConverter.convert(response, ListingResponse.class);
    }

    /**
     * Get listing response.
     *
     * @param sellerId     the seller id
     * @param loginAllegro the login allegro
     * @return the listing response
     * @throws AllerException the aller exception
     */
    public static ListingResponse get(String sellerId, String loginAllegro) throws AllerException {
       return get(ImmutableMap.of("seller.id", sellerId), loginAllegro);
    }

}
