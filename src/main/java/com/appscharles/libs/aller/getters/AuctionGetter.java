package com.appscharles.libs.aller.getters;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.models.offersListing.ListingOffer;
import com.appscharles.libs.aller.models.offersListing.ListingResponse;
import com.appscharles.libs.aller.rests.OffersListingRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Auction getter.
 */
public class AuctionGetter {

    private Integer maxNumber;

    private Integer limit;

    /**
     * Instantiates a new Auction getter.
     */
    public AuctionGetter() {
        this.maxNumber = 120000;
        this.limit = 99;
    }

    /**
     * Get list.
     *
     * @param urlParameters the url parameters
     * @param loginAllegro  the login allegro
     * @return the list
     * @throws AllerException the aller exception
     */
    public List<ListingOffer> get(Map<String, String> urlParameters, String loginAllegro) throws AllerException {
        List<ListingOffer> offers = new ArrayList<>();
        for (int i = 0; i < this.maxNumber ; i += this.limit + 1){
            urlParameters.put("offset", String.valueOf(i));
            urlParameters.put("limit", String.valueOf(this.limit + 1));
            ListingResponse response = OffersListingRest.get(urlParameters, loginAllegro);
            List<ListingOffer> promotedOffers = response.getItems().getPromoted();
            List<ListingOffer> regularOffers = response.getItems().getRegular();
            Integer sizeOffers = promotedOffers.size() + regularOffers.size();
            offers.addAll(promotedOffers);
            offers.addAll(regularOffers);
            if (sizeOffers <= this.limit){
                break;
            }
        }
        return offers;
    }

    /**
     * Sets max number.
     *
     * @param maxNumber the max number
     */
    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    /**
     * Sets limit.
     *
     * @param limit the limit
     */
    public void setLimit(Integer limit) {
        if (limit > 99){
            throw new IllegalArgumentException("Max limit is 99");
        }
        this.limit = limit;
    }

    /**
     * Gets max number.
     *
     * @return the max number
     */
    public Integer getMaxNumber() {
        return maxNumber;
    }

    /**
     * Gets limit.
     *
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }
}
