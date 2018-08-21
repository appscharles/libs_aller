package com.appscharles.libs.aller.models.offersListing;

import java.util.List;

/**
 * The type Listing response.
 */
public class ListingResponse {

    private ListingResponseOffers items;

    private ListingResponseCategories categories;

    private List<ListingResponseFilter> filters;

    private ListingResponseSearchMeta searchMeta;

    private List<ListingResponseSort> sort;

    /**
     * Instantiates a new Listing response.
     */
    public ListingResponse() {
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public ListingResponseOffers getItems() {
        return items;
    }

    /**
     * Sets items.
     *
     * @param items the items
     */
    public void setItems(ListingResponseOffers items) {
        this.items = items;
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
    public ListingResponseCategories getCategories() {
        return categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(ListingResponseCategories categories) {
        this.categories = categories;
    }

    /**
     * Gets filters.
     *
     * @return the filters
     */
    public List<ListingResponseFilter> getFilters() {
        return filters;
    }

    /**
     * Sets filters.
     *
     * @param filters the filters
     */
    public void setFilters(List<ListingResponseFilter> filters) {
        this.filters = filters;
    }

    /**
     * Gets search meta.
     *
     * @return the search meta
     */
    public ListingResponseSearchMeta getSearchMeta() {
        return searchMeta;
    }

    /**
     * Sets search meta.
     *
     * @param searchMeta the search meta
     */
    public void setSearchMeta(ListingResponseSearchMeta searchMeta) {
        this.searchMeta = searchMeta;
    }

    /**
     * Gets sort.
     *
     * @return the sort
     */
    public List<ListingResponseSort> getSort() {
        return sort;
    }

    /**
     * Sets sort.
     *
     * @param sort the sort
     */
    public void setSort(List<ListingResponseSort> sort) {
        this.sort = sort;
    }
}
