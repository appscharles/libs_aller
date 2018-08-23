package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.DeliveryMethod;
import com.appscharles.libs.aller.models.Offer;
import com.appscharles.libs.aller.models.ShippingRate;
import com.appscharles.libs.aller.models.offers.*;
import com.appscharles.libs.aller.models.offers.enums.*;
import com.appscharles.libs.aller.models.shippingRate.ItemRate;
import com.appscharles.libs.aller.models.shippingRate.Rate;
import com.appscharles.libs.aller.models.shippingRate.ShippingTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 13:39
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class OfferRestTest extends TestCase {

    @Test
    public void shouldAddOffer() throws AllerException {
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
        Assert.assertTrue(offer.getValidation().getErrors().size() == 0);
    }

    @Test
    public void shouldGetOffer() throws AllerException {
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
        RestManager.setConfiguration(getRestManagerConfiguration());
        offer = OfferRest.get(offer.getId(), getLoginAllegro());
      Assert.assertNotNull(offer);
    }

    @Test
    public void shouldUpdateOffer() throws AllerException {
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
        offer = OfferRest.get(offer.getId(), getLoginAllegro());
        offer.getStock().setAvailable(3);
        offer = OfferRest.update(offer, getLoginAllegro());
        Assert.assertNotNull(offer);
        Assert.assertTrue(offer.getStock().getAvailable().equals(3));
    }

}