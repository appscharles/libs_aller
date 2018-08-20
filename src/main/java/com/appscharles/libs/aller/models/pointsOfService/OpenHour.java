package com.appscharles.libs.aller.models.pointsOfService;

import com.appscharles.libs.aller.models.commons.enums.DayOfWeek;

import java.util.Calendar;

/**
 * The type Open hour.
 */
public class OpenHour {

        private DayOfWeek dayOfWeek;

        private Calendar from;

        private Calendar to;

    /**
     * Instantiates a new Open hour.
     */
    public OpenHour() {
    }

    /**
     * Instantiates a new Open hour.
     *
     * @param dayOfWeek the day of week
     * @param from      the from
     * @param to        the to
     */
    public OpenHour(DayOfWeek dayOfWeek, Calendar from, Calendar to) {
        this.dayOfWeek = dayOfWeek;
        this.from = from;
        this.to = to;
    }

    /**
     * Gets day of week.
     *
     * @return the day of week
     */
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Sets day of week.
     *
     * @param dayOfWeek the day of week
     */
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * Gets from.
     *
     * @return the from
     */
    public Calendar getFrom() {
        return from;
    }

    /**
     * Sets from.
     *
     * @param from the from
     */
    public void setFrom(Calendar from) {
        this.from = from;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public Calendar getTo() {
        return to;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(Calendar to) {
        this.to = to;
    }
}
