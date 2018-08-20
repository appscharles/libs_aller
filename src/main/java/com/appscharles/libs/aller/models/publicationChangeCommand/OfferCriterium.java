package com.appscharles.libs.aller.models.publicationChangeCommand;

import com.appscharles.libs.aller.models.publicationChangeCommand.enums.CriteriaType;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 16:49
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class OfferCriterium {

    private List<OfferId> offers;

    private CriteriaType type;

    public OfferCriterium() {
    }

    public OfferCriterium(List<OfferId> offers, CriteriaType type) {
        this.offers = offers;
        this.type = type;
    }

    /**
     * Getter for property 'offers'.
     *
     * @return Value for property 'offers'.
     */
    public List<OfferId> getOffers() {
        return offers;
    }

    /**
     * Setter for property 'offers'.
     *
     * @param offers Value to set for property 'offers'.
     */
    public void setOffers(List<OfferId> offers) {
        this.offers = offers;
    }

    /**
     * Getter for property 'type'.
     *
     * @return Value for property 'type'.
     */
    public CriteriaType getType() {
        return type;
    }

    /**
     * Setter for property 'type'.
     *
     * @param type Value to set for property 'type'.
     */
    public void setType(CriteriaType type) {
        this.type = type;
    }
}
