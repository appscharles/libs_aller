package com.appscharles.libs.aller.models.publicationChangeCommand;

import com.appscharles.libs.aller.models.publicationChangeCommand.enums.Status;

import java.util.Calendar;

/**
 * The type Command task.
 */
public class CommandTask {

    private String field;

    private Calendar finishedAt;

    private String message;

    private OfferId offer;

    private Calendar scheduledAt;

    private Status status;

    /**
     * Instantiates a new Command task.
     */
    public CommandTask() {
    }

    /**
     * Gets field.
     *
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * Sets field.
     *
     * @param field the field
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * Gets finished at.
     *
     * @return the finished at
     */
    public Calendar getFinishedAt() {
        return finishedAt;
    }

    /**
     * Sets finished at.
     *
     * @param finishedAt the finished at
     */
    public void setFinishedAt(Calendar finishedAt) {
        this.finishedAt = finishedAt;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets offer.
     *
     * @return the offer
     */
    public OfferId getOffer() {
        return offer;
    }

    /**
     * Sets offer.
     *
     * @param offer the offer
     */
    public void setOffer(OfferId offer) {
        this.offer = offer;
    }

    /**
     * Gets scheduled at.
     *
     * @return the scheduled at
     */
    public Calendar getScheduledAt() {
        return scheduledAt;
    }

    /**
     * Sets scheduled at.
     *
     * @param scheduledAt the scheduled at
     */
    public void setScheduledAt(Calendar scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}
