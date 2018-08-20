package com.appscharles.libs.aller.extractors;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * The type Jwt token.
 */
@JsonIgnoreProperties(value = { "exp", "jti", "client_id", "scope" })
public class JwtToken {

    private String username;

    /**
     * Instantiates a new Jwt token.
     */
    public JwtToken() {
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    @JsonGetter("user_name")
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    @JsonSetter("user_name")
    public void setUsername(String username) {
        this.username = username;
    }
}
