package com.appscharles.libs.aller.models.pointsOfService;

/**
 * The type Coordinates.
 */
public class Coordinates {

    private Double lat;

    private Double lon;

    /**
     * Instantiates a new Coordinates.
     */
    public Coordinates() {
    }

    /**
     * Instantiates a new Coordinates.
     *
     * @param lat the lat
     * @param lon the lon
     */
    public Coordinates(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * Gets lat.
     *
     * @return the lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * Sets lat.
     *
     * @param lat the lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * Gets lon.
     *
     * @return the lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * Sets lon.
     *
     * @param lon the lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }
}
