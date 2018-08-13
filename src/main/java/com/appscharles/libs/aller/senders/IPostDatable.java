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
public interface IPostDatable {

    <T extends AbstractPostHttpSender>  T addPostData(String key, String value);
}
