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
public class ExpireRefreshTokenValidator {

    public static boolean isValid(TokenAccess tokenAccess) {
        Calendar now = Calendar.getInstance();
        Calendar refreshTokenCreatedAt = tokenAccess.getRefreshTokenCreatedAt();
        refreshTokenCreatedAt.add(Calendar.DAY_OF_YEAR, 330);
        return refreshTokenCreatedAt.compareTo(now) >= 0;
    }
}
