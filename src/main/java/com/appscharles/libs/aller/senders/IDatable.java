package com.appscharles.libs.aller.senders;

import java.util.Map;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.08.2018
 * Time: 15:42
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IDatable {

    <T>  T addData(String key, String value);

    <T>  T setData(Map<String, String> data);
}
