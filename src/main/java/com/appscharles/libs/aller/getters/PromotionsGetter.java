package com.appscharles.libs.aller.getters;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.models.promotions.SellerRebate;
import com.appscharles.libs.aller.models.promotions.SellerRebates;
import com.appscharles.libs.aller.rests.PromotionRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Auction getter.
 */
public class PromotionsGetter {

    private Integer maxNumber;

    private Integer limit;

    /**
     * Instantiates a new Auction getter.
     */
    public PromotionsGetter() {
        this.maxNumber = 120000;
        this.limit = 49;
    }

    /**
     * Get list.
     *
     * @param urlParameters the url parameters
     * @param loginAllegro  the login allegro
     * @return the list
     * @throws AllerException the aller exception
     */
    public List<SellerRebate> get(Map<String, String> urlParameters, String loginAllegro) throws AllerException {
        List<SellerRebate> promotions = new ArrayList<>();
        for (int i = 0; i < this.maxNumber ; i += this.limit + 1){
            urlParameters.put("offset", String.valueOf(i));
            urlParameters.put("limit", String.valueOf(this.limit + 1));
            SellerRebates response = PromotionRest.get(urlParameters, loginAllegro);
            List<SellerRebate> promotionsPart = response.getPromotions();
            promotions.addAll(promotionsPart);
            if (promotionsPart.size() <= this.limit){
                break;
            }
        }
        return promotions;
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
            throw new IllegalArgumentException("Max limit is 49");
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
