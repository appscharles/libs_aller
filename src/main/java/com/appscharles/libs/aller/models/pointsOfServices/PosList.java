package com.appscharles.libs.aller.models.pointsOfServices;

import com.appscharles.libs.aller.models.PointOfService;

import java.util.List;

/**
 * The type Pos list.
 */
public class PosList {

    private List<PointOfService> posList;

    /**
     * Instantiates a new Pos list.
     */
    public PosList() {
    }

    /**
     * Gets pos list.
     *
     * @return the pos list
     */
    public List<PointOfService> getPosList() {
        return posList;
    }

    /**
     * Sets pos list.
     *
     * @param posList the pos list
     */
    public void setPosList(List<PointOfService> posList) {
        this.posList = posList;
    }
}
