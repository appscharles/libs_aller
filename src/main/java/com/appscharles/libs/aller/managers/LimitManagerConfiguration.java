package com.appscharles.libs.aller.managers;

/**
 * The type Limit manager configuration.
 */
public class LimitManagerConfiguration {

    private long ipRequestPerSeconds;

    /**
     * Instantiates a new Limit manager configuration.
     */
    public LimitManagerConfiguration() {
        this.ipRequestPerSeconds = 110;
    }

    /**
     * Gets limit ip request per seconds.
     *
     * @return the limit ip request per seconds
     */
    public long getIpRequestPerSeconds() {
        return ipRequestPerSeconds;
    }

    /**
     * Sets limit ip request per seconds.
     *
     * @param ipRequestPerSeconds the limit ip request per seconds
     */
    public void setIpRequestPerSeconds(long ipRequestPerSeconds) {
        this.ipRequestPerSeconds = ipRequestPerSeconds;
    }
}
