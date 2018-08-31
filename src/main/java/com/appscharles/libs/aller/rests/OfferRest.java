package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.converters.JsonToObjectConverter;
import com.appscharles.libs.aller.converters.ObjectToJsonConverter;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.Offer;
import com.appscharles.libs.aller.models.PublicationChangeCommand;
import com.appscharles.libs.aller.models.publicationChangeCommand.OfferCriterium;
import com.appscharles.libs.aller.models.publicationChangeCommand.OfferId;
import com.appscharles.libs.aller.models.publicationChangeCommand.Publication;
import com.appscharles.libs.aller.models.publicationChangeCommand.TaskReport;
import com.appscharles.libs.aller.models.publicationChangeCommand.enums.Action;
import com.appscharles.libs.aller.models.publicationChangeCommand.enums.CriteriaType;
import com.appscharles.libs.aller.models.publicationChangeCommand.enums.Status;
import com.appscharles.libs.aller.senders.rest.ApiVersion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;

/**
 * The type Offer rest.
 */
public class OfferRest {

    private static final ApiVersion API_VERSION = ApiVersion.V1;

    private static final String RESOURCE = "sale/offers";

    private static long timeoutTaskReport = 10 * 60000;

    /**
     * Add offer.
     *
     * @param offer        the offer
     * @param loginAllegro the login allegro
     * @return the offer
     * @throws AllerException the aller exception
     */
    public static Offer add(Offer offer, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(offer);
        String response = RestManager.post(RESOURCE, API_VERSION, json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, Offer.class);
    }

    /**
     * Add with publish offer.
     *
     * @param offer        the offer
     * @param loginAllegro the login allegro
     * @return the offer
     * @throws AllerException the aller exception
     */
    public static Offer addWithPublish(Offer offer, String loginAllegro) throws AllerException {
        if (offer.getId() != null){
            throw new AllerException("Offer has been added: " + offer.getId());
        }
        offer = add(offer, loginAllegro);
        if (offer.getValidation().getErrors().size() > 0) {
            try {
                String jsonErrors = new ObjectMapper().writeValueAsString(offer.getValidation().getErrors());
                throw new AllerException("Validation offer "+offer.getId()+": " +  jsonErrors);
            } catch (JsonProcessingException e) {
                throw new AllerException(e);
            }
        }
        UUID uuid = UUID.randomUUID();
        PublicationChangeCommand command = new PublicationChangeCommand(Arrays.asList(new OfferCriterium(Arrays.asList(new OfferId(offer.getId())), CriteriaType.CONTAINS_OFFERS)), new Publication(Action.ACTIVATE));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1);
        command.getPublication().setScheduledFor(calendar);
        OfferPublicationCommandsRest.put(command, uuid.toString(),loginAllegro);
       long timeout = System.currentTimeMillis() + timeoutTaskReport;
        while (System.currentTimeMillis() < timeout) {
            try {
                Thread.sleep(700);
                TaskReport taskReport = OfferPublicationCommandsRest.getTaskReport(uuid.toString(), loginAllegro);
                if (taskReport.getTasks().size() == 0){
                    throw new AllerException("Failed task report: " +  new ObjectMapper().writeValueAsString(taskReport));
                }
                if (taskReport.getTasks().get(0).getStatus().equals(Status.NEW)){
                    continue;
                } else if (taskReport.getTasks().get(0).getStatus().equals(Status.FAIL)){
                    throw new AllerException("Failed in task report publish offer "+offer.getId()+": " + taskReport.getTasks().get(0).getMessage());
                } else if (taskReport.getTasks().get(0).getStatus().equals(Status.SUCCESS)){
                    return offer;
                }
            } catch (InterruptedException | JsonProcessingException e) {
                throw new AllerException(e);
            }
        }
        PublicationChangeCommand commandClose = new PublicationChangeCommand(Arrays.asList(new OfferCriterium(Arrays.asList(new OfferId(offer.getId())), CriteriaType.CONTAINS_OFFERS)), new Publication(Action.END));
        OfferPublicationCommandsRest.put(commandClose, UUID.randomUUID().toString(),loginAllegro);
        throw new AllerException("Timeout wait for task report. Call command close offer "+offer.getId()+".");
    }

    /**
     * Publish offer.
     *
     * @param offer        the offer
     * @param loginAllegro the login allegro
     * @return the offer
     * @throws AllerException the aller exception
     */
    public static Offer publish(Offer offer, String loginAllegro) throws AllerException {
        if (offer.getId() == null){
            throw new AllerException("Use method addAndPublish");
        }
        UUID uuid = UUID.randomUUID();
        PublicationChangeCommand command = new PublicationChangeCommand(Arrays.asList(new OfferCriterium(Arrays.asList(new OfferId(offer.getId())), CriteriaType.CONTAINS_OFFERS)), new Publication(Action.ACTIVATE));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1);
        command.getPublication().setScheduledFor(calendar);
        OfferPublicationCommandsRest.put(command, uuid.toString(),loginAllegro);
        long timeout = System.currentTimeMillis() + timeoutTaskReport;
        while (System.currentTimeMillis() < timeout) {
            try {
                Thread.sleep(700);
                TaskReport taskReport = OfferPublicationCommandsRest.getTaskReport(uuid.toString(), loginAllegro);
                if (taskReport.getTasks().size() == 0){
                    throw new AllerException("Failed task report: " +  new ObjectMapper().writeValueAsString(taskReport));
                }
                if (taskReport.getTasks().get(0).getStatus().equals(Status.NEW)){
                    continue;
                } else if (taskReport.getTasks().get(0).getStatus().equals(Status.FAIL)){
                    throw new AllerException("Failed in task report publish offer "+offer.getId()+": " + taskReport.getTasks().get(0).getMessage());
                } else if (taskReport.getTasks().get(0).getStatus().equals(Status.SUCCESS)){
                    return offer;
                }
            } catch (InterruptedException | JsonProcessingException e) {
                throw new AllerException(e);
            }
        }
        PublicationChangeCommand commandClose = new PublicationChangeCommand(Arrays.asList(new OfferCriterium(Arrays.asList(new OfferId(offer.getId())), CriteriaType.CONTAINS_OFFERS)), new Publication(Action.END));
        OfferPublicationCommandsRest.put(commandClose, UUID.randomUUID().toString(),loginAllegro);
        throw new AllerException("Timeout wait for task report. Call command close offer "+offer.getId()+".");
    }

    /**
     * Close.
     *
     * @param offerId      the offer id
     * @param loginAllegro the login allegro
     * @throws AllerException the aller exception
     */
    public static void close(String offerId, String loginAllegro) throws AllerException {
        UUID uuid = UUID.randomUUID();
        PublicationChangeCommand command = new PublicationChangeCommand(Arrays.asList(new OfferCriterium(Arrays.asList(new OfferId(offerId)), CriteriaType.CONTAINS_OFFERS)), new Publication(Action.END));
        OfferPublicationCommandsRest.put(command, uuid.toString(),loginAllegro);
        long timeout = System.currentTimeMillis() + timeoutTaskReport;
        while (System.currentTimeMillis() < timeout) {
            try {
                Thread.sleep(700);
                TaskReport taskReport = OfferPublicationCommandsRest.getTaskReport(uuid.toString(), loginAllegro);
                if (taskReport.getTasks().get(0).getStatus().equals(Status.NEW)){
                    continue;
                } else if (taskReport.getTasks().get(0).getStatus().equals(Status.FAIL)){
                    throw new AllerException("Failed in task report publish offer "+offerId+": " + taskReport.getTasks().get(0).getMessage());
                }
            } catch (InterruptedException e) {
                throw new AllerException(e);
            }
        }
        throw new AllerException("Timeout wait for task report for close offer: " +offerId);
    }

    /**
     * Get offer.
     *
     * @param offerId      the offer id
     * @param loginAllegro the login allegro
     * @return the offer
     * @throws AllerException the aller exception
     */
    public static Offer get(String offerId, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE + "/" + offerId, API_VERSION, loginAllegro);
        return JsonToObjectConverter.convert(response, Offer.class);
    }

    /**
     * Update offer.
     *
     * @param offer        the offer
     * @param loginAllegro the login allegro
     * @return the offer
     * @throws AllerException the aller exception
     */
    public static Offer update(Offer offer, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(offer);
        String response = RestManager.put(RESOURCE + "/" + offer.getId(), API_VERSION, json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, Offer.class);
    }

    /**
     * Sets timeout task report.
     *
     * @param timeoutTaskReport the timeout task report
     */
    public static void setTimeoutTaskReport(long timeoutTaskReport) {
        OfferRest.timeoutTaskReport = timeoutTaskReport;
    }
}
