package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.PointOfService;
import com.appscharles.libs.aller.models.Seller;
import com.appscharles.libs.aller.models.pointsOfServices.Address;
import com.appscharles.libs.aller.models.pointsOfServices.DayOfWeek;
import com.appscharles.libs.aller.models.pointsOfServices.OpenHour;
import com.appscharles.libs.aller.models.pointsOfServices.enums.ConfirmationType;
import com.appscharles.libs.aller.models.pointsOfServices.enums.Status;
import com.appscharles.libs.aller.models.pointsOfServices.enums.Type;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
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
        PointOfService pointsOfService = new PointOfService("My point",
                new Seller(sellerId), Type.PICKUP_POINT, new Address("Street", "City", "45-300", "świętokrzyskie", "PL"),
                ConfirmationType.CALL_US, Status.ACTIVE);
        pointsOfService = PointOfServiceRest.add(pointsOfService, getLoginAllegro());
        Assert.assertNotNull(pointsOfService.getId());
    }

    @Test
    public void shouldGetAllPointsOfServices() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        PointOfService pointsOfService = new PointOfService("My point",
                new Seller(sellerId), Type.PICKUP_POINT, new Address("Street", "City", "45-300", "świętokrzyskie", "PL"),
                ConfirmationType.CALL_US, Status.ACTIVE);
       PointOfServiceRest.add(pointsOfService, getLoginAllegro());
        List<PointOfService> pointsOfServices = PointOfServiceRest.getAll(sellerId, getLoginAllegro());
       Assert.assertTrue(pointsOfServices.size()>0);
    }

    @Test
    public void shouldGetPointsOfService() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        PointOfService pointsOfService = new PointOfService("My point",
                new Seller(sellerId), Type.PICKUP_POINT, new Address("Street", "City", "45-300", "świętokrzyskie", "PL"),
                ConfirmationType.CALL_US, Status.ACTIVE);
        pointsOfService = PointOfServiceRest.add(pointsOfService, getLoginAllegro());
        Assert.assertNotNull(pointsOfService.getId());
        pointsOfService = PointOfServiceRest.get(pointsOfService.getId(), getLoginAllegro());
        Assert.assertNotNull(pointsOfService.getId());
    }

    @Test
    public void shouldUpdatePointsOfService() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        PointOfService pointsOfService = new PointOfService("My point",
                new Seller(sellerId), Type.PICKUP_POINT, new Address("Street", "City", "45-300", "świętokrzyskie", "PL"),
                ConfirmationType.CALL_US, Status.ACTIVE);
        Calendar to = Calendar.getInstance();
        to.add(Calendar.HOUR, 2);
        pointsOfService.getOpenHours().add(new OpenHour(DayOfWeek.MONDAY, "08:00:00.000", "09:00:00.000"));
        pointsOfService = PointOfServiceRest.add(pointsOfService, getLoginAllegro());
        pointsOfService.setName("New name");
        pointsOfService = PointOfServiceRest.update(pointsOfService, getLoginAllegro());
        PointOfService pointsOfServiceGet = PointOfServiceRest.get(pointsOfService.getId(), getLoginAllegro());
        Assert.assertNotNull(pointsOfServiceGet.getName().equals("New name"));
    }

    @Test
    public void shouldDeletePointsOfService() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        String sellerId = RestManager.getSellerId(getLoginAllegro());
        List<PointOfService> pointsOfServices = PointOfServiceRest.getAll(sellerId, getLoginAllegro());
        for (PointOfService pointsOfService : pointsOfServices) {
            PointOfServiceRest.delete(pointsOfService.getId(), getLoginAllegro());
        }
        Assert.assertTrue(PointOfServiceRest.getAll(sellerId, getLoginAllegro()).size() == 0);
    }
}