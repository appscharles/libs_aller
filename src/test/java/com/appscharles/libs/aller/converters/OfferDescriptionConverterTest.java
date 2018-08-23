package com.appscharles.libs.aller.converters;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.DeliveryMethod;
import com.appscharles.libs.aller.models.Offer;
import com.appscharles.libs.aller.models.ShippingRate;
import com.appscharles.libs.aller.models.offers.*;
import com.appscharles.libs.aller.models.offers.enums.Format;
import com.appscharles.libs.aller.models.offers.enums.InvoiceType;
import com.appscharles.libs.aller.models.offers.enums.ItemType;
import com.appscharles.libs.aller.models.offers.enums.Unit;
import com.appscharles.libs.aller.models.shippingRate.ItemRate;
import com.appscharles.libs.aller.models.shippingRate.Rate;
import com.appscharles.libs.aller.models.shippingRate.ShippingTime;
import com.appscharles.libs.aller.rests.DeliveryMethodRest;
import com.appscharles.libs.aller.rests.OfferRest;
import com.appscharles.libs.aller.rests.ShippingRatesRest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        List<DeliveryMethod> deliveryMethods = DeliveryMethodRest.getAll(getLoginAllegro());
        ShippingRate shippingRate = new ShippingRate("ShippingName", Arrays.asList(new Rate(deliveryMethods.get(0), 1, new ItemRate("12.12", "PLN"), new ItemRate("13.22", "PLN"), new ShippingTime("PT72H", "PT120H"))));
        shippingRate = ShippingRatesRest.add(shippingRate, getLoginAllegro());

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
}