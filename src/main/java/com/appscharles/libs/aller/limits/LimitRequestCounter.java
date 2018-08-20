package com.appscharles.libs.aller.limits;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Limit request counter.
 */
public class LimitRequestCounter  {

    private Timer timer;

    private long limitRequest;

    private long counter;

    /**
     * Instantiates a new Limit request counter.
     *
     * @param limitRequest the limit request
     * @param period       the period
     */
    public LimitRequestCounter(long limitRequest, long period) {
        this.limitRequest = limitRequest;
        this.counter = 0;
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                resetCounter();
            }
        }, 0, period);
    }

    /**
     * Has limit boolean.
     *
     * @return the boolean
     */
    public boolean hasLimit() {
        return this.counter >= this.limitRequest;
    }

    private void resetCounter(){
        this.counter = 0;
    }

    /**
     * Add request.
     */
    public void addRequest(){
        this.counter++;
    }
}
