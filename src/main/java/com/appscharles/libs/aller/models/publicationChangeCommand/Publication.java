package com.appscharles.libs.aller.models.publicationChangeCommand;

import com.appscharles.libs.aller.models.publicationChangeCommand.enums.Action;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Calendar;

/**
 * The type Publication.
 */
public class Publication {

    private Action action;

    private Calendar scheduledFor;

    /**
     * Instantiates a new Publication.
     */
    public Publication() {
    }

    /**
     * Instantiates a new Publication.
     *
     * @param action the action
     */
    public Publication(Action action) {
        this.action = action;
    }

    /**
     * Gets action.
     *
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * Sets action.
     *
     * @param action the action
     */
    public void setAction(Action action) {
        this.action = action;
    }

    /**
     * Gets scheduled for.
     *
     * @return the scheduled for
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    public Calendar getScheduledFor() {
        return scheduledFor;
    }

    /**
     * Sets scheduled for.
     *
     * @param scheduledFor the scheduled for
     */
    public void setScheduledFor(Calendar scheduledFor) {
        this.scheduledFor = scheduledFor;
    }
}
