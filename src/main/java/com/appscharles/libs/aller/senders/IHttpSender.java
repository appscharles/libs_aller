package com.appscharles.libs.aller.senders;

import com.appscharles.libs.aller.exceptions.AllerException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.08.2018
 * Time: 15:42
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IHttpSender {

    void send() throws AllerException;
}
