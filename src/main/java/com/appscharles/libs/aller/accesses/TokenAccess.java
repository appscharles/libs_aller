package com.appscharles.libs.aller.accesses;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.08.2018
 * Time: 15:13
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class TokenAccess {

    private String token;

    private String type;

    private String refreshToken;

    private long expiresIn;

    private String scope;

    private String jti;

    public TokenAccess() {
    }

    public TokenAccess(String token, String type, String refreshToken, long expiresIn, String scope, String jti) {
        this.token = token;
        this.type = type;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
        this.scope = scope;
        this.jti = jti;
    }

    /**
     * Getter for property 'token'.
     *
     * @return Value for property 'token'.
     */
    @JsonGetter("access_token")
    public String getToken() {
        return token;
    }

    /**
     * Getter for property 'type'.
     *
     * @return Value for property 'type'.
     */
    @JsonGetter("token_type")
    public String getType() {
        return type;
    }

    /**
     * Getter for property 'refreshToken'.
     *
     * @return Value for property 'refreshToken'.
     */
    @JsonGetter("refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Getter for property 'expiresIn'.
     *
     * @return Value for property 'expiresIn'.
     */
    @JsonGetter("expires_in")
    public long getExpiresIn() {
        return expiresIn;
    }

    /**
     * Getter for property 'scope'.
     *
     * @return Value for property 'scope'.
     */
    @JsonGetter("scope")
    public String getScope() {
        return scope;
    }

    /**
     * Getter for property 'jti'.
     *
     * @return Value for property 'jti'.
     */
    @JsonGetter("jti")
    public String getJti() {
        return jti;
    }

    /**
     * Setter for property 'token'.
     *
     * @param token Value to set for property 'token'.
     */
    @JsonSetter("access_token")
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Setter for property 'type'.
     *
     * @param type Value to set for property 'type'.
     */
    @JsonSetter("token_type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Setter for property 'refreshToken'.
     *
     * @param refreshToken Value to set for property 'refreshToken'.
     */
    @JsonSetter("refresh_token")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Setter for property 'expiresIn'.
     *
     * @param expiresIn Value to set for property 'expiresIn'.
     */
    @JsonSetter("expires_in")
    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * Setter for property 'scope'.
     *
     * @param scope Value to set for property 'scope'.
     */
    @JsonSetter("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * Setter for property 'jti'.
     *
     * @param jti Value to set for property 'jti'.
     */
    @JsonSetter("jti")
    public void setJti(String jti) {
        this.jti = jti;
    }
}
