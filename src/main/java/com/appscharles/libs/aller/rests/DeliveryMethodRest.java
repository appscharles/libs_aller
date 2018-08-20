package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.converters.JsonToObjectConverter;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.DeliveryMethod;
import com.appscharles.libs.aller.models.deliveryMethod.DeliveryMethodList;
import com.appscharles.libs.aller.senders.rest.ApiVersion;

import java.util.List;

/**
 * The type Delivery method rest.
 */
public class DeliveryMethodRest {

    private static final ApiVersion API_VERSION = ApiVersion.V1;

    private static final String RESOURCE = "sale/delivery-methods";


    /**
     * Gets all.
     *
     * @param loginAllegro the login allegro
     * @return the all
     * @throws AllerException the aller exception
     */
    public static List<DeliveryMethod> getAll(String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE, API_VERSION, loginAllegro);
        DeliveryMethodList list = JsonToObjectConverter.convert(response, DeliveryMethodList.class);
        return list.getDeliveryMethods();
    }
}
