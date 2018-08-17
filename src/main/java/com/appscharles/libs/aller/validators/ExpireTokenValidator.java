package com.appscharles.libs.aller.validators;

import com.appscharles.libs.aller.accesses.TokenAccess;

import java.util.Calendar;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 17.08.2018
 * Time: 14:01
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ExpireTokenValidator {

    public static boolean isValid(TokenAccess tokenAccess) {
        Calendar now = Calendar.getInstance();
        Calendar createdAt = tokenAccess.getCreatedAt();
        createdAt.add(Calendar.HOUR_OF_DAY, 8);
        return createdAt.compareTo(now) >= 0;
    }
}
