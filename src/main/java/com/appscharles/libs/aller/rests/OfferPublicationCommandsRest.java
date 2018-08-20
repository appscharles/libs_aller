package com.appscharles.libs.aller.rests;

import com.appscharles.libs.aller.converters.JsonToObjectConverter;
import com.appscharles.libs.aller.converters.ObjectToJsonConverter;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.PublicationChangeCommand;
import com.appscharles.libs.aller.models.publicationChangeCommand.GeneralReport;
import com.appscharles.libs.aller.models.publicationChangeCommand.TaskReport;
import com.appscharles.libs.aller.senders.rest.ApiVersion;

/**
 * The type Offer publication commands rest.
 */
public class OfferPublicationCommandsRest {

    private static final ApiVersion API_VERSION = ApiVersion.V1;

    private static final String RESOURCE = "sale/offer-publication-commands";

    /**
     * Put general report.
     *
     * @param command      the command
     * @param guid         the guid
     * @param loginAllegro the login allegro
     * @return the general report
     * @throws AllerException the aller exception
     */
    public static GeneralReport put(PublicationChangeCommand command, String guid, String loginAllegro) throws AllerException {
        String json = ObjectToJsonConverter.convert(command);
        String response = RestManager.put(RESOURCE + "/" + guid, API_VERSION,json, loginAllegro, true);
        return JsonToObjectConverter.convert(response, GeneralReport.class);
    }

    /**
     * Get general report.
     *
     * @param guid         the guid
     * @param loginAllegro the login allegro
     * @return the general report
     * @throws AllerException the aller exception
     */
    public static GeneralReport get(String guid, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE + "/" + guid, API_VERSION, loginAllegro);
        return JsonToObjectConverter.convert(response, GeneralReport.class);
    }

    public static TaskReport getTaskReport(String guid, String loginAllegro) throws AllerException {
        String response = RestManager.get(RESOURCE + "/" + guid +"/tasks", API_VERSION, loginAllegro);
        return JsonToObjectConverter.convert(response, TaskReport.class);
    }
}
