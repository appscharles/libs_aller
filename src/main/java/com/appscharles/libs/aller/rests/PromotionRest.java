package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.converters.JsonToObjectConverter;
import com.appscharles.libs.aller.converters.ObjectToJsonConverter;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.promotions.SellerCreateRebateRequest;
import com.appscharles.libs.aller.models.promotions.SellerRebate;
import com.appscharles.libs.aller.models.promotions.SellerRebates;
import com.appscharles.libs.aller.senders.rest.ApiVersion;

import java.util.Map;

/**
 * The type Point of service rest.
 */
public class PromotionRest {

    private static final ApiVersion API_VERSION = ApiVersion.V1;

    private static final String RESOURCE = "sale/loyalty/promotions";

    public static SellerRebate add(SellerCreateRebateRequest sellerCreateRebateRequest , String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(sellerCreateRebateRequest);
        String response = RestManager.post(RESOURCE, API_VERSION,json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, SellerRebate.class);
    }

    /**
     * Get listing response.
     *
     * @param parameters   the parameters
     * @param loginAllegro the login allegro
     * @return the listing response
     * @throws AllerException the aller exception
     */
    public static SellerRebates get(Map<String, String> parameters, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE, API_VERSION, parameters, loginAllegro);
        return JsonToObjectConverter.convert(response, SellerRebates.class);
    }

    public static void delete(String promotionId, String loginAllegro) throws AllerException {
        RestManager.delete(RESOURCE + "/" + promotionId, API_VERSION, loginAllegro);
    }
}
