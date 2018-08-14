package com.appscharles.libs.aller.getters;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * The type Resource content getter.
 */
public class ResourceContentGetter {

    /**
     * Get string.
     *
     * @param resource the resource
     * @return the string
     */
    public String get(String resource) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(resource);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
