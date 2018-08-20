package com.appscharles.libs.aller.models.pointsOfService;

import com.appscharles.libs.aller.models.PointsOfService;

import java.util.List;

/**
 * The type Pos list.
 */
public class PosList {

    private List<PointsOfService> posList;

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
    public List<PointsOfService> getPosList() {
        return posList;
    }

    /**
     * Sets pos list.
     *
     * @param posList the pos list
     */
    public void setPosList(List<PointsOfService> posList) {
        this.posList = posList;
    }
}
