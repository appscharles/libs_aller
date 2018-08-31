package com.appscharles.libs.aller.converters;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            return (T)mapper.readValue(json, aClass);
        } catch (IOException e) {
           throw new AllerException(e);
        }
    }
}
