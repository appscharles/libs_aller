package com.appscharles.libs.aller.models.offersListing;

/**
 * The type Listing response search meta.
 */
public class ListingResponseSearchMeta {

    private Integer availableCount;

    private Integer totalCount;

    private Boolean fallback;

    /**
     * Instantiates a new Listing response search meta.
     */
    public ListingResponseSearchMeta() {
    }

    /**
     * Gets available count.
     *
     * @return the available count
     */
    public Integer getAvailableCount() {
        return availableCount;
    }

    /**
     * Sets available count.
     *
     * @param availableCount the available count
     */
    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    /**
     * Gets total count.
     *
     * @return the total count
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * Sets total count.
     *
     * @param totalCount the total count
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Gets fallback.
     *
     * @return the fallback
     */
    public Boolean getFallback() {
        return fallback;
    }

    /**
     * Sets fallback.
     *
     * @param fallback the fallback
     */
    public void setFallback(Boolean fallback) {
        this.fallback = fallback;
    }
}
