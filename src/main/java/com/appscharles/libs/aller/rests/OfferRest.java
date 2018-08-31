package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.converters.JsonToObjectConverter;
import com.appscharles.libs.aller.converters.ObjectToJsonConverter;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.Offer;
import com.appscharles.libs.aller.senders.rest.ApiVersion;

/**
 * The type Offer rest.
 */
public class OfferRest {

    private static final ApiVersion API_VERSION = ApiVersion.V1;

    private static final String RESOURCE = "sale/offers";

    /**
     * Add offer.
     *
     * @param offer        the offer
     * @param loginAllegro the login allegro
     * @return the offer
     * @throws AllerException the aller exception
     */
    public static Offer add(Offer offer, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(offer);
        String response = RestManager.post(RESOURCE, API_VERSION, json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, Offer.class);
    }

    /**
     * Get offer.
     *
     * @param offerId      the offer id
     * @param loginAllegro the login allegro
     * @return the offer
     * @throws AllerException the aller exception
     */
    public static Offer get(String offerId, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE + "/" + offerId, API_VERSION, loginAllegro);
        return JsonToObjectConverter.convert(response, Offer.class);
    }

    /**
     * Update offer.
     *
     * @param offer        the offer
     * @param loginAllegro the login allegro
     * @return the offer
     * @throws AllerException the aller exception
     */
    public static Offer update(Offer offer, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(offer);
        String response = RestManager.put(RESOURCE + "/" + offer.getId(), API_VERSION, json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, Offer.class);
    }
}
