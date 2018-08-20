package com.appscharles.libs.aller.extractors;

import com.appscharles.libs.aller.exceptions.AllerException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Base64;

/**
 * The type Jwt token extractor.
 */
public class JwtTokenExtractor {

    private String jwtToken;

    /**
     * Instantiates a new Jwt token extractor.
     *
     * @param jwtToken the jwt token
     */
    public JwtTokenExtractor(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    /**
     * Extract jwt token.
     *
     * @return the jwt token
     * @throws AllerException the aller exception
     */
    public JwtToken extract() throws AllerException {
        String base64EncodedBody = this.jwtToken.split("\\.")[1];
        try {
            String json = new String(Base64.getUrlDecoder().decode(base64EncodedBody.getBytes("UTF-8")), "UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, JwtToken.class);
        } catch (IOException e) {
            throw new AllerException(e);
        }
    }
}
