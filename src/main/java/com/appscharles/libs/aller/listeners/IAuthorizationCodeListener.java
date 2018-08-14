package com.appscharles.libs.aller.listeners;

import com.appscharles.libs.aller.exceptions.AllerException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 14.08.2018
 * Time: 10:19
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IAuthorizationCodeListener extends IInterruptable {

    String waitAndGet() throws AllerException;
}
