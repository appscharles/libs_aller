package com.appscharles.libs.aller.models.offers;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Compatibility list.
 */
public class CompatibilityList {

    private List<CompatibilityListItem> items;

    /**
     * Instantiates a new Compatibility list.
     */
    public CompatibilityList() {
    }

    /**
     * Instantiates a new Compatibility list.
     *
     * @param items the items
     */
    public CompatibilityList(List<CompatibilityListItem> items) {
        this.items = items;
        this.items = new ArrayList<>();
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public List<CompatibilityListItem> getItems() {
        return items;
    }

    /**
     * Sets items.
     *
     * @param items the items
     */
    public void setItems(List<CompatibilityListItem> items) {
        this.items = items;
    }
}
