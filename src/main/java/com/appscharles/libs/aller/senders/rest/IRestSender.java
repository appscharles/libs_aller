package com.appscharles.libs.aller.senders.rest;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.senders.IDatable;
import com.appscharles.libs.aller.senders.IRequestPropertable;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 16.08.2018
 * Time: 09:06
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IRestSender extends IDatable, IRequestPropertable {

    String getResponse() throws AllerException;
}
