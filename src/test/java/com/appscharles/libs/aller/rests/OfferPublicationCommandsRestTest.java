package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.getters.RegularSellerAuctionGetter;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.DeliveryMethod;
import com.appscharles.libs.aller.models.Offer;
import com.appscharles.libs.aller.models.PublicationChangeCommand;
import com.appscharles.libs.aller.models.ShippingRate;
import com.appscharles.libs.aller.models.offers.*;
import com.appscharles.libs.aller.models.offers.enums.Format;
import com.appscharles.libs.aller.models.offers.enums.InvoiceType;
import com.appscharles.libs.aller.models.offers.enums.ItemType;
import com.appscharles.libs.aller.models.offers.enums.Unit;
import com.appscharles.libs.aller.models.offersListing.ListingOffer;
import com.appscharles.libs.aller.models.publicationChangeCommand.*;
import com.appscharles.libs.aller.models.publicationChangeCommand.Publication;
import com.appscharles.libs.aller.models.publicationChangeCommand.enums.Action;
import com.appscharles.libs.aller.models.publicationChangeCommand.enums.CriteriaType;
import com.appscharles.libs.aller.models.shippingRate.ItemRate;
import com.appscharles.libs.aller.models.shippingRate.Rate;
import com.appscharles.libs.aller.models.shippingRate.ShippingTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 16:58
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class OfferPublicationCommandsRestTest extends TestCase {

    @Test
    public void shouldGetGeneralReport() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        List<DeliveryMethod> deliveryMethods = DeliveryMethodRest.getAll(getLoginAllegro());
        ShippingRate shippingRate = new ShippingRate("ShippingName", Arrays.asList(new Rate(deliveryMethods.get(0), 1, new ItemRate("12.12", "PLN"), new ItemRate("13.22", "PLN"), new ShippingTime("PT72H", "PT120H"))));
        shippingRate = ShippingRatesRest.add(shippingRate, getLoginAllegro());
        Offer offer = new Offer("My offer public", new Category("14237"),
                Arrays.asList(new Parameter("11323", Arrays.asList("11323_1"))),
                new OfferDescription(Arrays.asList(new DescriptionSection(
                        Arrays.asList(new DescriptionSectionItem(ItemType.TEXT, "<p>content offer</p>"))
                ))), new SellingMode(Format.BUY_NOW, new Price("12.23", "PLN")),
                new Stock(20, Unit.UNIT),
                new Delivery("PT168H", new JustId(shippingRate.getId())),
                new Payments(InvoiceType.NO_INVOICE),
                new Location("city", "23-400", "WIELKOPOLSKIE","PL"));
        offer =  OfferRest.add(offer, getLoginAllegro());
        UUID uuid = UUID.randomUUID();
        PublicationChangeCommand command = new PublicationChangeCommand(Arrays.asList(new OfferCriterium(Arrays.asList(new OfferId(offer.getId())), CriteriaType.CONTAINS_OFFERS)), new Publication(Action.ACTIVATE));
        GeneralReport generalReport = OfferPublicationCommandsRest.put(command, uuid.toString(), getLoginAllegro());
        for (ListingOffer listingOffer : new RegularSellerAuctionGetter().getAll(getLoginAllegro())) {
            System.out.println(listingOffer.getName());
        }
        generalReport.setId("f");
        generalReport = OfferPublicationCommandsRest.get(uuid.toString(), getLoginAllegro());
        TaskReport taskReport = OfferPublicationCommandsRest.getTaskReport(uuid.toString(), getLoginAllegro());
        Assert.assertNotNull(generalReport);
        Assert.assertNotNull(taskReport);
    }
}