package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.converters.JsonToObjectConverter;
import com.appscharles.libs.aller.converters.ObjectToJsonConverter;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.PointsOfService;
import com.appscharles.libs.aller.models.pointsOfService.PosList;
import com.appscharles.libs.aller.senders.rest.ApiVersion;
import com.google.common.collect.ImmutableMap;

import java.util.List;

/**
 * The type Points of service rest.
 */
public class PointsOfServiceRest {

    private static final ApiVersion API_VERSION = ApiVersion.V1;

    private static final String RESOURCE = "points-of-service";

    /**
     * Add points of service.
     *
     * @param pointsOfService the points of service
     * @param loginAllegro    the login allegro
     * @return the points of service
     * @throws AllerException the aller exception
     */
    public static PointsOfService add(PointsOfService pointsOfService, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(pointsOfService);
        String response = RestManager.post(RESOURCE, API_VERSION,json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, PointsOfService.class);
    }

    /**
     * Gets all.
     *
     * @param sellerId     the seller id
     * @param loginAllegro the login allegro
     * @return the all
     * @throws AllerException the aller exception
     */
    public static List<PointsOfService> getAll(String sellerId, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE, API_VERSION, ImmutableMap.of("seller.id", sellerId), loginAllegro);
        PosList posList = JsonToObjectConverter.convert(response, PosList.class);
        return posList.getPosList();
    }

    /**
     * Get points of service.
     *
     * @param id           the id
     * @param loginAllegro the login allegro
     * @return the points of service
     * @throws AllerException the aller exception
     */
    public static PointsOfService get(String id, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE + "/" + id, API_VERSION, loginAllegro);
        return JsonToObjectConverter.convert(response, PointsOfService.class);
    }

    /**
     * Update points of service.
     *
     * @param pointsOfService the points of service
     * @param loginAllegro    the login allegro
     * @return the points of service
     * @throws AllerException the aller exception
     */
    public static PointsOfService update(PointsOfService pointsOfService, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(pointsOfService);
        String response = RestManager.put(RESOURCE + "/" + pointsOfService.getId(), API_VERSION, json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, PointsOfService.class);
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
