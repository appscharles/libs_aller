package com.appscharles.libs.aller.limits;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 11:31
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class LimitRequestCounterTest {

    @Test
    public void shouldResetLimitCounter() throws InterruptedException {
        LimitRequestCounter counter = new LimitRequestCounter(110, 1000);
       Boolean hasLimit = false;
        for (int i = 0; i < 300 ; i++){
            Thread.sleep(20);
            counter.addRequest();
            if (counter.hasLimit()){
                hasLimit = true;
            }
        }
        Assert.assertFalse(hasLimit);
    }

    @Test
    public void shouldHasLimitCounter() throws InterruptedException {
        LimitRequestCounter counter = new LimitRequestCounter(110, 1000);
        Boolean hasLimit = false;
        for (int i = 0; i < 300 ; i++){
            Thread.sleep(5);
            counter.addRequest();
            if (counter.hasLimit()){
                hasLimit = true;
            }
        }
        Assert.assertTrue(hasLimit);
    }
}