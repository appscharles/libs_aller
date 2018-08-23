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
 * Date: 22.08.2018
 * Time: 16:37
 * Project name: stocker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class RegularAuctionGetterTest extends TestCase {

    @Test
    public void shouldGetAuctions() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        RegularSellerAuctionGetter getter = new RegularSellerAuctionGetter();
        String loginAllegro = getLoginAllegro();
        List<ListingOffer> offers = getter.getAll(loginAllegro);
        for (ListingOffer offer : offers) {
            System.out.println(offer.getName());
        }
        System.out.println("offers: " + offers.size());
    }
}