package com.appscharles.libs.aller.converters;

import com.appscharles.libs.aller.models.Offer;
import com.appscharles.libs.aller.models.offers.DescriptionSection;
import com.appscharles.libs.aller.models.offers.DescriptionSectionItem;
import com.appscharles.libs.aller.models.offers.enums.ItemType;

/**
 * The type Offer description converter.
 */
public class OfferDescriptionConverter {

    /**
     * Get string string.
     *
     * @param offer the offer
     * @return the string
     */
    public static String getString(Offer offer){
        StringBuilder stringBuilder = new StringBuilder();
        for (DescriptionSection descriptionSection : offer.getDescription().getSections()) {
            for (DescriptionSectionItem descriptionSectionItem : descriptionSection.getItems()) {
                if (descriptionSectionItem.getType().equals(ItemType.TEXT)){
                    stringBuilder.append(descriptionSectionItem.getContent());
                } else if (descriptionSectionItem.getType().equals(ItemType.IMAGE)){
                    stringBuilder.append(descriptionSectionItem.getUrl());
                }
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }

}
