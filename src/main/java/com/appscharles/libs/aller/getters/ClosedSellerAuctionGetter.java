package com.appscharles.libs.aller.getters;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.RestManager;
import com.appscharles.libs.aller.models.offersListing.ListingOffer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Regular auction getter.
 */
public class ClosedSellerAuctionGetter {

   private AuctionGetter auctionGetter;

    /**
     * Instantiates a new Regular auction getter.
     */
    public ClosedSellerAuctionGetter() {
        this.auctionGetter = new AuctionGetter();
    }

    /**
     * Get list.
     *
     * @param loginAllegro the login allegro
     * @return the list
     * @throws AllerException the aller exception
     */
    public List<ListingOffer> getAll(String loginAllegro) throws AllerException {
        String sellerId = RestManager.getSellerId(loginAllegro);
        Map<String, String> urlParameters = new HashMap<>();
        urlParameters.put("seller.id", sellerId);
        urlParameters.put("searchMode", "CLOSED");
        return this.auctionGetter.get(urlParameters, loginAllegro);
    }

    public AuctionGetter getAuctionGetter() {
        return auctionGetter;
    }

    public void setAuctionGetter(AuctionGetter auctionGetter) {
        this.auctionGetter = auctionGetter;
    }
}
