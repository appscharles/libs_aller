package com.appscharles.libs.aller.models.pointsOfServices;

/**
 * The type Address.
 */
public class Address {

    private String street;

    private String city;

    private String zipCode;

    private String state;

    private String countryCode;

    private Coordinates coordinates;

    /**
     * Instantiates a new Address.
     */
    public Address() {
    }

    /**
     * Instantiates a new Address.
     *
     * @param street      the street
     * @param city        the city
     * @param zipCode     the zip code
     * @param state       the state
     * @param countryCode the country code
     */
    public Address(String street, String city, String zipCode, String state, String countryCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.countryCode = countryCode;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street.
     *
     * @param street the street
     */
    public void setStreet(String street) {
        this.street = street;
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
     * Gets zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
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
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
