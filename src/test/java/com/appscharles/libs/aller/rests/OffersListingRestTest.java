package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.offersListing.ListingResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 21.08.2018
 * Time: 09:29
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class OffersListingRestTest extends TestCase {

    @Test
    public void shouldGetOffers() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        ListingResponse response = OffersListingRest.get(RestManager.getSellerId(getLoginAllegro()), getLoginAllegro());
        Assert.assertNotNull(response);
    }
}