package com.appscharles.libs.aller.validators;

import com.appscharles.libs.aller.accesses.TokenAccess;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 17.08.2018
 * Time: 14:05
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ExpireTokenValidatorTest {

    @Test
    public void shouldValidateTokenAccess(){
        TokenAccess tokenAccess = new TokenAccess();
        Calendar calendar = Calendar.getInstance();
        calendar.add( Calendar.HOUR_OF_DAY, -9);
        tokenAccess.setCreatedAt(calendar);
        Assert.assertFalse(ExpireTokenValidator.isValid(tokenAccess));
    }


    @Test
    public void shouldValidateTokenAccess2(){
        TokenAccess tokenAccess = new TokenAccess();
        Calendar calendar = Calendar.getInstance();
        calendar.add( Calendar.HOUR_OF_DAY, -4);
        tokenAccess.setCreatedAt(calendar);
        Assert.assertTrue(ExpireTokenValidator.isValid(tokenAccess));
    }
}