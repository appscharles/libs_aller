package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.converters.JsonToObjectConverter;
import com.appscharles.libs.aller.converters.ObjectToJsonConverter;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.Offer;
import com.appscharles.libs.aller.models.PointOfService;
import com.appscharles.libs.aller.senders.rest.ApiVersion;

/**
 * The type Offer rest.
 */
public class OfferRest {

    private static final ApiVersion API_VERSION = ApiVersion.V1;

    private static final String RESOURCE = "sale/offers";

    public static Offer add(Offer offer, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(offer);
        String response = RestManager.post(RESOURCE, API_VERSION,json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, Offer.class);
    }


    /**
     * Get points of service.
     *
     * @param offerId      the offer id
     * @param loginAllegro the login allegro
     * @return the points of service
     * @throws AllerException the aller exception
     */
    public static PointOfService get(String offerId, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE + "/" + offerId, API_VERSION, loginAllegro);
        System.out.println(response);
        return null;
        //return JsonToObjectConverter.convert(response, PointsOfService.class);
    }
}
