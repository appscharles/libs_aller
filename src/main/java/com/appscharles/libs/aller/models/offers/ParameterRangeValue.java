package com.appscharles.libs.aller.models.offers;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 13:45
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ParameterRangeValue {

    private String from;

    private String to;

    public ParameterRangeValue() {
    }

    public ParameterRangeValue(String from, String to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Getter for property 'from'.
     *
     * @return Value for property 'from'.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Setter for property 'from'.
     *
     * @param from Value to set for property 'from'.
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Getter for property 'to'.
     *
     * @return Value for property 'to'.
     */
    public String getTo() {
        return to;
    }

    /**
     * Setter for property 'to'.
     *
     * @param to Value to set for property 'to'.
     */
    public void setTo(String to) {
        this.to = to;
    }
}
