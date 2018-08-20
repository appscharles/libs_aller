package com.appscharles.libs.aller.managers;

import com.appscharles.libs.aller.exceptions.AllerException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 11:51
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class LimitManagerTest {

    @Test
    public void shouldCountLimitRequests() throws AllerException {
        LimitManager.setConfiguration(new LimitManagerConfiguration());
        LimitManager.addRequestWithWait("localhost");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i<1200 ; i++){
            LimitManager.addRequestWithWait("localhost");
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        Assert.assertTrue(String.valueOf(time), time > 9000);
        Assert.assertTrue(String.valueOf(time), time < 10000);
    }
}