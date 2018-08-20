package com.appscharles.libs.aller.validators;

import com.appscharles.libs.aller.accesses.TokenAccess;

import java.util.Calendar;

/**
 * The type Expire refresh token validator.
 */
public class ExpireRefreshTokenValidator {

    /**
     * Is valid boolean.
     *
     * @param tokenAccess the token access
     * @return the boolean
     */
    public static boolean isValid(TokenAccess tokenAccess) {
        Calendar now = Calendar.getInstance();
        Calendar refreshTokenCreatedAt = tokenAccess.getRefreshTokenCreatedAt();
        refreshTokenCreatedAt.add(Calendar.DAY_OF_YEAR, 330);
        return refreshTokenCreatedAt.compareTo(now) >= 0;
    }
}
