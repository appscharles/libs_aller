package com.appscharles.libs.aller.models.offers;

import java.util.List;

/**
 * The type Offer description.
 */
public class OfferDescription {

    private List<DescriptionSection> sections;

    /**
     * Instantiates a new Offer description.
     */
    public OfferDescription() {
    }

    /**
     * Instantiates a new Offer description.
     *
     * @param sections the sections
     */
    public OfferDescription(List<DescriptionSection> sections) {
        this.sections = sections;
    }

    /**
     * Gets sections.
     *
     * @return the sections
     */
    public List<DescriptionSection> getSections() {
        return sections;
    }

    /**
     * Sets sections.
     *
     * @param sections the sections
     */
    public void setSections(List<DescriptionSection> sections) {
        this.sections = sections;
    }
}
