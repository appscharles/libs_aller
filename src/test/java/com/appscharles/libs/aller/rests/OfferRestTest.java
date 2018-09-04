package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.Offer;
import com.appscharles.libs.aller.models.PublicationChangeCommand;
import com.appscharles.libs.aller.models.ShippingRate;
import com.appscharles.libs.aller.models.offers.*;
import com.appscharles.libs.aller.models.offers.enums.Format;
import com.appscharles.libs.aller.models.offers.enums.InvoiceType;
import com.appscharles.libs.aller.models.offers.enums.ItemType;
import com.appscharles.libs.aller.models.offers.enums.Unit;
import com.appscharles.libs.aller.models.publicationChangeCommand.OfferCriterium;
import com.appscharles.libs.aller.models.publicationChangeCommand.OfferId;
import com.appscharles.libs.aller.models.publicationChangeCommand.Publication;
import com.appscharles.libs.aller.models.publicationChangeCommand.TaskReport;
import com.appscharles.libs.aller.models.publicationChangeCommand.enums.Action;
import com.appscharles.libs.aller.models.publicationChangeCommand.enums.CriteriaType;
import com.appscharles.libs.aller.models.publicationChangeCommand.enums.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

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
        ShippingRate shippingRate = null;
        for (ShippingRate rate : ShippingRatesRest.getAll(RestManager.getSellerId(getLoginAllegro()), getLoginAllegro())) {
            shippingRate = ShippingRatesRest.get(rate.getId(), getLoginAllegro());
            break;
        }
        if (shippingRate == null || shippingRate.getRates() == null) {
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
                new Location("city", "23-400", "WIELKOPOLSKIE", "PL"));
        offer = OfferRest.add(offer, getLoginAllegro());
        Assert.assertTrue(offer.getValidation().getErrors().size() == 0);
    }

    @Test
    public void shouldGetOffer() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        ShippingRate shippingRate = null;
        for (ShippingRate rate : ShippingRatesRest.getAll(RestManager.getSellerId(getLoginAllegro()), getLoginAllegro())) {
            shippingRate = ShippingRatesRest.get(rate.getId(), getLoginAllegro());
            break;
        }
        if (shippingRate == null || shippingRate.getRates() == null) {
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
                new Location("city", "23-400", "WIELKOPOLSKIE", "PL"));
        offer = OfferRest.add(offer, getLoginAllegro());
        RestManager.setConfiguration(getRestManagerConfiguration());
        offer = OfferRest.get(offer.getId(), getLoginAllegro());
        Assert.assertNotNull(offer);
    }

    @Test
    public void shouldUpdateOffer() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        ShippingRate shippingRate = null;
        for (ShippingRate rate : ShippingRatesRest.getAll(RestManager.getSellerId(getLoginAllegro()), getLoginAllegro())) {
            shippingRate = ShippingRatesRest.get(rate.getId(), getLoginAllegro());
            break;
        }
        if (shippingRate == null || shippingRate.getRates() == null) {
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
                new Location("city", "23-400", "WIELKOPOLSKIE", "PL"));
        offer = OfferRest.add(offer, getLoginAllegro());
        offer = OfferRest.get(offer.getId(), getLoginAllegro());
        offer.getStock().setAvailable(3);
        offer = OfferRest.update(offer, getLoginAllegro());
        Assert.assertNotNull(offer);
        Assert.assertTrue(offer.getStock().getAvailable().equals(3));
    }

    @Test
    public void shouldAddWithPublishOffer() throws AllerException {
        RestManager.setConfiguration(getRestManagerConfiguration());
        ShippingRate shippingRate = null;
        for (ShippingRate rate : ShippingRatesRest.getAll(RestManager.getSellerId(getLoginAllegro()), getLoginAllegro())) {
            shippingRate = ShippingRatesRest.get(rate.getId(), getLoginAllegro());
            break;
        }
        if (shippingRate == null || shippingRate.getRates() == null) {
            throw new AllerException("Shipping rate is null, add shipping rate");
        }
        Delivery delivery = new Delivery("PT168H", new JustId(shippingRate.getId()));
        Offer offer = new Offer("My offer", new Category("14237"),
                Arrays.asList(new Parameter("11323", Arrays.asList("11323_1"))),
                new OfferDescription(Arrays.asList(new DescriptionSection(
                        Arrays.asList(new DescriptionSectionItem(ItemType.TEXT, "<p>content offer</p>"))
                ))), new SellingMode(Format.BUY_NOW, new Price("12.23", "PLN")),
                new Stock(20, Unit.UNIT),
                delivery,
                new Payments(InvoiceType.NO_INVOICE),
                new Location("city", "23-400", "WIELKOPOLSKIE", "PL"));
        offer = OfferRest.add(offer, getLoginAllegro());
        if (offer.getValidation().getErrors().size() > 0) {
            try {
                String jsonErrors = new ObjectMapper().writeValueAsString(offer.getValidation().getErrors());
                throw new AllerException("Validation offer " + offer.getId() + ": " + jsonErrors);
            } catch (JsonProcessingException e) {
                throw new AllerException(e);
            }
        }
        UUID uuid = UUID.randomUUID();
        PublicationChangeCommand command = new PublicationChangeCommand(Arrays.asList(new OfferCriterium(Arrays.asList(new OfferId(offer.getId())), CriteriaType.CONTAINS_OFFERS)), new Publication(Action.ACTIVATE));
        OfferPublicationCommandsRest.put(command, uuid.toString(), getLoginAllegro());
        TaskReport taskReport2 = OfferPublicationCommandsRest.getTaskReport(uuid.toString(), getLoginAllegro());
        long timeout = System.currentTimeMillis() + 60000;
        while (System.currentTimeMillis() < timeout) {
            try {
                Thread.sleep(700);
                TaskReport taskReport = OfferPublicationCommandsRest.getTaskReport(uuid.toString(), getLoginAllegro());
                if (taskReport.getTasks().size() == 0) {
                    throw new AllerException("Failed task report: " + new ObjectMapper().writeValueAsString(taskReport));
                }
                if (taskReport.getTasks().get(0).getStatus().equals(Status.NEW)) {
                    continue;
                } else if (taskReport.getTasks().get(0).getStatus().equals(Status.FAIL)) {
                    throw new AllerException("Failed in task report publish offer " + offer.getId() + ": " + taskReport.getTasks().get(0).getMessage());
                } else if (taskReport.getTasks().get(0).getStatus().equals(Status.SUCCESS)) {
                    return;
                }
            } catch (InterruptedException | JsonProcessingException e) {
                throw new AllerException(e);
            }
        }
        throw new AllerException("Timeout");
    }
}