package com.appscharles.libs.aller.models.offersListing;

import java.util.List;

/**
 * The type Listing response categories.
 */
public class ListingResponseCategories {

    private List<ListingCategory> subcategories;

    private List<ListingCategory> path;

    /**
     * Instantiates a new Listing response categories.
     */
    public ListingResponseCategories() {
    }

    /**
     * Gets subcategories.
     *
     * @return the subcategories
     */
    public List<ListingCategory> getSubcategories() {
        return subcategories;
    }

    /**
     * Sets subcategories.
     *
     * @param subcategories the subcategories
     */
    public void setSubcategories(List<ListingCategory> subcategories) {
        this.subcategories = subcategories;
    }

    /**
     * Gets path.
     *
     * @return the path
     */
    public List<ListingCategory> getPath() {
        return path;
    }

    /**
     * Sets path.
     *
     * @param path the path
     */
    public void setPath(List<ListingCategory> path) {
        this.path = path;
    }
}
