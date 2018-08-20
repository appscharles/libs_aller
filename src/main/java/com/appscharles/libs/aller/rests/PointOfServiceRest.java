package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.converters.JsonToObjectConverter;
import com.appscharles.libs.aller.converters.ObjectToJsonConverter;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.PointOfService;
import com.appscharles.libs.aller.models.pointsOfServices.PosList;
import com.appscharles.libs.aller.senders.rest.ApiVersion;
import com.google.common.collect.ImmutableMap;

import java.util.List;

/**
 * The type Point of service rest.
 */
public class PointOfServiceRest {

    private static final ApiVersion API_VERSION = ApiVersion.V1;

    private static final String RESOURCE = "points-of-service";

    /**
     * Add point of service.
     *
     * @param pointOfService the point of service
     * @param loginAllegro   the login allegro
     * @return the point of service
     * @throws AllerException the aller exception
     */
    public static PointOfService add(PointOfService pointOfService, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(pointOfService);
        String response = RestManager.post(RESOURCE, API_VERSION,json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, PointOfService.class);
    }

    /**
     * Gets all.
     *
     * @param sellerId     the seller id
     * @param loginAllegro the login allegro
     * @return the all
     * @throws AllerException the aller exception
     */
    public static List<PointOfService> getAll(String sellerId, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE, API_VERSION, ImmutableMap.of("seller.id", sellerId), loginAllegro);
        PosList posList = JsonToObjectConverter.convert(response, PosList.class);
        return posList.getPosList();
    }

    /**
     * Get point of service.
     *
     * @param id           the id
     * @param loginAllegro the login allegro
     * @return the point of service
     * @throws AllerException the aller exception
     */
    public static PointOfService get(String id, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE + "/" + id, API_VERSION, loginAllegro);
        return JsonToObjectConverter.convert(response, PointOfService.class);
    }

    /**
     * Update point of service.
     *
     * @param pointOfService the point of service
     * @param loginAllegro   the login allegro
     * @return the point of service
     * @throws AllerException the aller exception
     */
    public static PointOfService update(PointOfService pointOfService, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(pointOfService);
        String response = RestManager.put(RESOURCE + "/" + pointOfService.getId(), API_VERSION, json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, PointOfService.class);
    }

    /**
     * Delete.
     *
     * @param id           the id
     * @param loginAllegro the login allegro
     * @throws AllerException the aller exception
     */
    public static void delete(String id, String loginAllegro) throws AllerException {
        RestManager.delete(RESOURCE + "/" + id, API_VERSION, loginAllegro);
    }
}
