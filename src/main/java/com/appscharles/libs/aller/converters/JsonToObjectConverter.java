package com.appscharles.libs.aller.converters;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * The type Json to object converter.
 */
public class JsonToObjectConverter {

    /**
     * Convert t.
     *
     * @param <T>    the type parameter
     * @param json   the json
     * @param aClass the a class
     * @return the t
     * @throws AllerException the aller exception
     */
    public static <T> T convert(String json, Class aClass) throws AllerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return (T)mapper.readValue(json, aClass);
        } catch (IOException e) {
           throw new AllerException(e);
        }
    }
}
