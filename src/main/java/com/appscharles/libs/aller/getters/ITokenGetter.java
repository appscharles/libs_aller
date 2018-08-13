package com.appscharles.libs.aller.getters;

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
public interface ITokenGetter {

    TokenAccess get() throws AllerException;
}
