package com.appscharles.libs.aller.models;

import com.appscharles.libs.aller.models.publicationChangeCommand.OfferCriterium;
import com.appscharles.libs.aller.models.publicationChangeCommand.Publication;

import java.util.List;

/**
 * The type Publication change command.
 */
public class PublicationChangeCommand {

    private List<OfferCriterium> offerCriteria;

    private Publication publication;

    /**
     * Instantiates a new Publication change command.
     */
    public PublicationChangeCommand() {
    }

    /**
     * Instantiates a new Publication change command.
     *
     * @param offerCriteria the offer criteria
     * @param publication   the publication
     */
    public PublicationChangeCommand(List<OfferCriterium> offerCriteria, Publication publication) {
        this.offerCriteria = offerCriteria;
        this.publication = publication;
    }

    /**
     * Gets offer criteria.
     *
     * @return the offer criteria
     */
    public List<OfferCriterium> getOfferCriteria() {
        return offerCriteria;
    }

    /**
     * Sets offer criteria.
     *
     * @param offerCriteria the offer criteria
     */
    public void setOfferCriteria(List<OfferCriterium> offerCriteria) {
        this.offerCriteria = offerCriteria;
    }

    /**
     * Gets publication.
     *
     * @return the publication
     */
    public Publication getPublication() {
        return publication;
    }

    /**
     * Sets publication.
     *
     * @param publication the publication
     */
    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
