package com.appscharles.libs.aller.getters;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.offersListing.ListingOffer;
import org.junit.Test;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 23.08.2018
 * Time: 14:02
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class DescriptionsSellerAuctionGetterTest extends TestCase {

    @Test
    public void shouldGetAuctions() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        DescriptionsSellerAuctionGetter getter = new DescriptionsSellerAuctionGetter();
        String loginAllegro = getLoginAllegro();
        List<ListingOffer> offers = getter.getAll(loginAllegro);
        for (ListingOffer offer : offers) {
            System.out.println(offer.getName());
        }
        System.out.println("offers: " + offers.size());
    }
}