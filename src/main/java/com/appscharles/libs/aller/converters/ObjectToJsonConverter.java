package com.appscharles.libs.aller.converters;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

/**
 * The type Object to json converter.
 */
public class ObjectToJsonConverter {

    /**
     * Convert string.
     *
     * @param object the object
     * @return the string
     * @throws AllerException the aller exception
     */
    public static String convert(Object object) throws AllerException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
           throw new AllerException(e);
        }
    }
}
