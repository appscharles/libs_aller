package com.appscharles.libs.aller.models.pointsOfServices;

/**
 * The type Open hour.
 */
public class OpenHour {

    private DayOfWeek dayOfWeek;

    private String from;

    private String to;

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
    public OpenHour(DayOfWeek dayOfWeek, String from, String to) {
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
    public String getFrom() {
        return from;
    }

    /**
     * Sets from.
     *
     * @param from the from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(String to) {
        this.to = to;
    }
}
