package com.appscharles.libs.aller.managers;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.limits.LimitRequestCounter;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Limit manager.
 */
public class LimitManager {

    private static LimitManagerConfiguration configuration;

    private static Map<String, LimitRequestCounter> limits;

    /**
     * Add request with wait.
     *
     * @param host the host
     * @throws AllerException the aller exception
     */
    public synchronized static void addRequestWithWait(String host) throws AllerException {
        initLimits();
        checkConfiguration();
        if (limits.containsKey(host) == false) {
            LimitRequestCounter counter = new LimitRequestCounter(configuration.getIpRequestPerSeconds(), 1000);
            counter.addRequest();
            limits.put(host, counter);
            return;
        }

        LimitRequestCounter counter = limits.get(host);
        if (counter.hasLimit()){
            while (counter.hasLimit()) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new AllerException();
                }
            }
        }
        counter.addRequest();
    }

    private static void initLimits() {
        if (limits == null) {
            limits = new HashMap<>();
        }
    }

    private static void checkConfiguration() throws AllerException {
        if (configuration == null) {
            throw new AllerException("Set check limit manager configuration");
        }
    }

    /**
     * Sets configuration.
     *
     * @param configuration the configuration
     */
    public static void setConfiguration(LimitManagerConfiguration configuration) {
        LimitManager.configuration = configuration;
    }
}
