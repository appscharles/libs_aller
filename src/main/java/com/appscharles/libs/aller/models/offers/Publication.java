package com.appscharles.libs.aller.models.offers;

import com.appscharles.libs.aller.models.offers.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Calendar;

/**
 * The type Publication.
 */
public class Publication {

    private String duration;

    private Calendar endingAt;

    private Calendar startingAt;

    private Status status;

    /**
     * Instantiates a new Publication.
     */
    public Publication() {
    }

    public Publication( Status status) {
        this.status = status;
    }

    /**
     * Getter for property 'duration'.
     *
     * @return Value for property 'duration'.
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Setter for property 'duration'.
     *
     * @param duration Value to set for property 'duration'.
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Getter for property 'endingAt'.
     *
     * @return Value for property 'endingAt'.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    public Calendar getEndingAt() {
        return endingAt;
    }

    /**
     * Setter for property 'endingAt'.
     *
     * @param endingAt Value to set for property 'endingAt'.
     */
    public void setEndingAt(Calendar endingAt) {
        this.endingAt = endingAt;
    }

    /**
     * Getter for property 'startingAt'.
     *
     * @return Value for property 'startingAt'.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    public Calendar getStartingAt() {
        return startingAt;
    }

    /**
     * Setter for property 'startingAt'.
     *
     * @param startingAt Value to set for property 'startingAt'.
     */
    public void setStartingAt(Calendar startingAt) {
        this.startingAt = startingAt;
    }

    /**
     * Getter for property 'status'.
     *
     * @return Value for property 'status'.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Setter for property 'status'.
     *
     * @param status Value to set for property 'status'.
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}
