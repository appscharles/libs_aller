package com.appscharles.libs.aller.validators;

import com.appscharles.libs.aller.accesses.TokenAccess;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        Calendar before = Calendar.getInstance();
        System.out.println("Soon Expire: " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(before.getTime()));;

        Calendar calendar = (Calendar) before.clone();
        calendar.add( Calendar.HOUR_OF_DAY, -4);
        System.out.println("Soon Expire: " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(calendar.getTime()));;
        System.out.println("Soon Expire: " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(before.getTime()));;

        tokenAccess.setCreatedAt(calendar);
        Assert.assertTrue(ExpireTokenValidator.isValid(tokenAccess));
    }
}