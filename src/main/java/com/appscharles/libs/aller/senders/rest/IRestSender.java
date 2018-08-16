package com.appscharles.libs.aller.senders.rest;

import com.appscharles.libs.aller.exceptions.AllerException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 16.08.2018
 * Time: 09:06
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IRestSender {

    String getResponse() throws AllerException;
}
