package com.appscharles.libs.aller.authorizations;

import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.exceptions.AllerException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.08.2018
 * Time: 12:29
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface ITokenAuthorization {

    TokenAccess getTokenAccess() throws AllerException;
}
