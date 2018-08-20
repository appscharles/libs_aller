package com.appscharles.libs.aller.models.offers;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 13:57
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class DescriptionSection {

    List<DescriptionSectionItem> items;

    public DescriptionSection() {
    }

    public DescriptionSection(List<DescriptionSectionItem> items) {
        this.items = items;
    }

    /**
     * Getter for property 'items'.
     *
     * @return Value for property 'items'.
     */
    public List<DescriptionSectionItem> getItems() {
        return items;
    }

    /**
     * Setter for property 'items'.
     *
     * @param items Value to set for property 'items'.
     */
    public void setItems(List<DescriptionSectionItem> items) {
        this.items = items;
    }
}
