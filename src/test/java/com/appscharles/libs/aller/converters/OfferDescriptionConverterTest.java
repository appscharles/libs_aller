package com.appscharles.libs.aller.converters;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.Offer;
import com.appscharles.libs.aller.models.ShippingRate;
import com.appscharles.libs.aller.models.offers.*;
import com.appscharles.libs.aller.models.offers.enums.Format;
import com.appscharles.libs.aller.models.offers.enums.InvoiceType;
import com.appscharles.libs.aller.models.offers.enums.ItemType;
import com.appscharles.libs.aller.models.offers.enums.Unit;
import com.appscharles.libs.aller.rests.OfferRest;
import com.appscharles.libs.aller.rests.ShippingRatesRest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * The type Offer description converter test.
 */
public class OfferDescriptionConverterTest extends TestCase {

    /**
     * Should get description.
     *
     * @throws AllerException the aller exception
     */
    @Test
    public void shouldGetDescription() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        ShippingRate shippingRate = null;
        for (ShippingRate rate : ShippingRatesRest.getAll(RestManager.getSellerId(getLoginAllegro()), getLoginAllegro())) {
            shippingRate = ShippingRatesRest.get(rate.getId(), getLoginAllegro());
            break;
        }
        if (shippingRate == null || shippingRate.getRates() == null){
            throw new AllerException("Shipping rate is null, add shipping rate");
        }

        Offer offer = new Offer("My offer", new Category("14237"),
                Arrays.asList(new Parameter("11323", Arrays.asList("11323_1"))),
                new OfferDescription(Arrays.asList(new DescriptionSection(
                        Arrays.asList(new DescriptionSectionItem(ItemType.TEXT, "<p>content offer</p>"))
                ))), new SellingMode(Format.BUY_NOW, new Price("12.23", "PLN")),
                new Stock(20, Unit.UNIT),
                new Delivery("PT168H", new JustId(shippingRate.getId())),
                new Payments(InvoiceType.NO_INVOICE),
                new Location("city", "23-400", "WIELKOPOLSKIE","PL"));
        offer =  OfferRest.add(offer, getLoginAllegro());
        String content = OfferDescriptionConverter.getString(offer);
        Assert.assertEquals(content, "<p>content offer</p>");
    }

//    @Test
//    public void shouldGetDescription2() throws AllerException {
//  initRestManager();
//        Offer offer = OfferRest.get("7519942222", getLoginAllegro());
//        String content = OfferDescriptionConverter.getString(offer);
//        Assert.assertEquals(content, "<p>content offer</p>");
//    }
}