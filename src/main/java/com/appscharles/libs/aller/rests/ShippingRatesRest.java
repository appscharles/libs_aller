package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.converters.JsonToObjectConverter;
import com.appscharles.libs.aller.converters.ObjectToJsonConverter;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.ShippingRate;
import com.appscharles.libs.aller.models.shippingRate.ShippingRateList;
import com.appscharles.libs.aller.senders.rest.ApiVersion;
import com.google.common.collect.ImmutableMap;

import java.util.List;

/**
 * The type Shipping rates rest.
 */
public class ShippingRatesRest {

    private static final ApiVersion API_VERSION = ApiVersion.V1;

    private static final String RESOURCE = "sale/shipping-rates";

    /**
     * Add shipping rate.
     *
     * @param shippingRate the shipping rate
     * @param loginAllegro the login allegro
     * @return the shipping rate
     * @throws AllerException the aller exception
     */
    public static ShippingRate add(ShippingRate shippingRate, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(shippingRate);
        String response = RestManager.post(RESOURCE, API_VERSION,json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, ShippingRate.class);
    }

    /**
     * Gets all.
     *
     * @param sellerId     the seller id
     * @param loginAllegro the login allegro
     * @return the all
     * @throws AllerException the aller exception
     */
    public static List<ShippingRate> getAll(String sellerId, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE, API_VERSION, ImmutableMap.of("seller.id", sellerId), loginAllegro);
        ShippingRateList list = JsonToObjectConverter.convert(response, ShippingRateList.class);
        return list.getShippingRates();
    }

    /**
     * Get shipping rate.
     *
     * @param id           the id
     * @param loginAllegro the login allegro
     * @return the shipping rate
     * @throws AllerException the aller exception
     */
    public static ShippingRate get(String id, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE + "/" + id, API_VERSION, loginAllegro);
        return JsonToObjectConverter.convert(response, ShippingRate.class);
    }

    /**
     * Update shipping rate.
     *
     * @param shippingRate the shipping rate
     * @param loginAllegro the login allegro
     * @return the shipping rate
     * @throws AllerException the aller exception
     */
    public static ShippingRate update(ShippingRate shippingRate, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(shippingRate);
        String response = RestManager.put(RESOURCE + "/" + shippingRate.getId(), API_VERSION, json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, ShippingRate.class);
    }
}
