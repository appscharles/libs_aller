package com.appscharles.libs.aller.accesses;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Calendar;

/**
 * The type Token access.
 */
public class TokenAccess {

    private String loginAllegro;

    private String token;

    private String type;

    private String refreshToken;

    private long expiresIn;

    private String scope;

    private String jti;

    private Calendar createdAt;

    private Calendar refreshTokenCreatedAt;

    /**
     * Instantiates a new Token access.
     */
    public TokenAccess() {
    }

    /**
     * Instantiates a new Token access.
     *
     * @param loginAllegro the login allegro
     * @param token        the token
     * @param type         the type
     * @param refreshToken the refresh token
     * @param expiresIn    the expires in
     * @param scope        the scope
     * @param jti          the jti
     */
    public TokenAccess(String loginAllegro, String token, String type, String refreshToken, long expiresIn, String scope, String jti) {
        this.loginAllegro = loginAllegro;
        this.token = token;
        this.type = type;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
        this.scope = scope;
        this.jti = jti;
    }

    /**
     * Gets login allegro.
     *
     * @return the login allegro
     */
    @JsonGetter("login_allegro")
    public String getLoginAllegro() {
        return loginAllegro;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    @JsonGetter("access_token")
    public String getToken() {
        return token;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonGetter("token_type")
    public String getType() {
        return type;
    }

    /**
     * Gets refresh token.
     *
     * @return the refresh token
     */
    @JsonGetter("refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Gets expires in.
     *
     * @return the expires in
     */
    @JsonGetter("expires_in")
    public long getExpiresIn() {
        return expiresIn;
    }

    /**
     * Gets scope.
     *
     * @return the scope
     */
    @JsonGetter("scope")
    public String getScope() {
        return scope;
    }

    /**
     * Gets jti.
     *
     * @return the jti
     */
    @JsonGetter("jti")
    public String getJti() {
        return jti;
    }


    /**
     * Sets login allegro.
     *
     * @param loginAllegro the login allegro
     */
    @JsonSetter("login_allegro")
    public void setLoginAllegro(String loginAllegro) {
        this.loginAllegro = loginAllegro;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    @JsonSetter("access_token")
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    @JsonSetter("token_type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets refresh token.
     *
     * @param refreshToken the refresh token
     */
    @JsonSetter("refresh_token")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Sets expires in.
     *
     * @param expiresIn the expires in
     */
    @JsonSetter("expires_in")
    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * Sets scope.
     *
     * @param scope the scope
     */
    @JsonSetter("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * Sets jti.
     *
     * @param jti the jti
     */
    @JsonSetter("jti")
    public void setJti(String jti) {
        this.jti = jti;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Calendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets refresh token created at.
     *
     * @return the refresh token created at
     */
    public Calendar getRefreshTokenCreatedAt() {
        return refreshTokenCreatedAt;
    }

    /**
     * Sets refresh token created at.
     *
     * @param refreshTokenCreatedAt the refresh token created at
     */
    public void setRefreshTokenCreatedAt(Calendar refreshTokenCreatedAt) {
        this.refreshTokenCreatedAt = refreshTokenCreatedAt;
    }
}
