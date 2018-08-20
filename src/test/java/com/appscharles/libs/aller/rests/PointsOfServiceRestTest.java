package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.PointsOfService;
import com.appscharles.libs.aller.models.commons.Seller;
import com.appscharles.libs.aller.models.pointsOfService.Address;
import com.appscharles.libs.aller.models.pointsOfService.enums.ConfirmationType;
import com.appscharles.libs.aller.models.pointsOfService.enums.Status;
import com.appscharles.libs.aller.models.pointsOfService.enums.Type;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 08:42
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PointsOfServiceRestTest extends TestCase {

    @Test
    public void shouldAddPointsOfService() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        PointsOfService pointsOfService = new PointsOfService("My point",
                new Seller(sellerId), Type.PICKUP_POINT, new Address("Street", "City", "45-300", "świętokrzyskie", "PL"),
                ConfirmationType.CALL_US, Status.ACTIVE);
        pointsOfService = PointsOfServiceRest.add(pointsOfService, getLoginAllegro());
        Assert.assertNotNull(pointsOfService.getId());
    }

    @Test
    public void shouldGetAllPointsOfServices() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        PointsOfService pointsOfService = new PointsOfService("My point",
                new Seller(sellerId), Type.PICKUP_POINT, new Address("Street", "City", "45-300", "świętokrzyskie", "PL"),
                ConfirmationType.CALL_US, Status.ACTIVE);
       PointsOfServiceRest.add(pointsOfService, getLoginAllegro());
        List<PointsOfService> pointsOfServices = PointsOfServiceRest.getAll(sellerId, getLoginAllegro());
       Assert.assertTrue(pointsOfServices.size()>0);
    }

    @Test
    public void shouldGetPointsOfService() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        PointsOfService pointsOfService = new PointsOfService("My point",
                new Seller(sellerId), Type.PICKUP_POINT, new Address("Street", "City", "45-300", "świętokrzyskie", "PL"),
                ConfirmationType.CALL_US, Status.ACTIVE);
        pointsOfService = PointsOfServiceRest.add(pointsOfService, getLoginAllegro());
        Assert.assertNotNull(pointsOfService.getId());
        pointsOfService = PointsOfServiceRest.get(pointsOfService.getId(), getLoginAllegro());
        Assert.assertNotNull(pointsOfService.getId());
    }

    @Test
    public void shouldUpdatePointsOfService() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        PointsOfService pointsOfService = new PointsOfService("My point",
                new Seller(sellerId), Type.PICKUP_POINT, new Address("Street", "City", "45-300", "świętokrzyskie", "PL"),
                ConfirmationType.CALL_US, Status.ACTIVE);
        pointsOfService = PointsOfServiceRest.add(pointsOfService, getLoginAllegro());
        pointsOfService.setName("New name");
        pointsOfService = PointsOfServiceRest.update(pointsOfService, getLoginAllegro());
        PointsOfService pointsOfServiceGet = PointsOfServiceRest.get(pointsOfService.getId(), getLoginAllegro());
        Assert.assertNotNull(pointsOfServiceGet.getName().equals("New name"));
    }

    @Test
    public void shouldDeletePointsOfService() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        List<PointsOfService> pointsOfServices = PointsOfServiceRest.getAll(sellerId, getLoginAllegro());
        for (PointsOfService pointsOfService : pointsOfServices) {
            PointsOfServiceRest.delete(pointsOfService.getId(), getLoginAllegro());
        }
        Assert.assertTrue(PointsOfServiceRest.getAll(sellerId, getLoginAllegro()).size() == 0);
    }
}