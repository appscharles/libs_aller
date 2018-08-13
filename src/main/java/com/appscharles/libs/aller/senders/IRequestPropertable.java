package com.appscharles.libs.aller.senders;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.08.2018
 * Time: 15:42
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IRequestPropertable {

    <T extends AbstractPostHttpSender>  T addRequestProperty(String key, String value);
}
