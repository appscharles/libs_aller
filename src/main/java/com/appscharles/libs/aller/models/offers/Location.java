package com.appscharles.libs.aller.models.offers;

/**
 * The type Location.
 */
public class Location {

    private String city;

    private String postCode;

    private String province;

    private String countryCode;

    /**
     * Instantiates a new Location.
     */
    public Location() {
    }

    /**
     * Instantiates a new Location.
     *
     * @param city        the city
     * @param countryCode the country code
     * @param postCode    the post code
     * @param province    the province
     */
    public Location(String city, String postCode, String province, String countryCode) {
        this.city = city;
        this.countryCode = countryCode;
        this.postCode = postCode;
        this.province = province;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets country code.
     *
     * @return the country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets country code.
     *
     * @param countryCode the country code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets post code.
     *
     * @return the post code
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets post code.
     *
     * @param postCode the post code
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * Gets province.
     *
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets province.
     *
     * @param province the province
     */
    public void setProvince(String province) {
        this.province = province;
    }
}
