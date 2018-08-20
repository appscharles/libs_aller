package com.appscharles.libs.aller.validators;

import com.appscharles.libs.aller.accesses.TokenAccess;

import java.util.Calendar;

/**
 * The type Expire token validator.
 */
public class ExpireTokenValidator {

    /**
     * Is valid boolean.
     *
     * @param tokenAccess the token access
     * @return the boolean
     */
    public static boolean isValid(TokenAccess tokenAccess) {
        Calendar now = Calendar.getInstance();
        Calendar createdAt = tokenAccess.getCreatedAt();
        createdAt.add(Calendar.HOUR_OF_DAY, 8);
        return createdAt.compareTo(now) >= 0;
    }
}
