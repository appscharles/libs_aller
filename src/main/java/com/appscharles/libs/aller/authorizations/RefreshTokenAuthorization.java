package com.appscharles.libs.aller.authorizations;

import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.senders.PostHttpSender;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.Calendar;

/**
 * The type Refresh token authorization.
 */
public class RefreshTokenAuthorization implements ITokenAuthorization {

    private final static String DEFAULT_AUTHORIZATION_END_POINT = "https://allegro.pl/auth/oauth";

    private String clientId;

    private String clientSecret;

    private Integer port;

    private String refreshToken;

    private Calendar refreshTokenCreatedAt;

    private URL authorizationEndPoint;

    /**
     * Instantiates a new Refresh token authorization.
     *
     * @param clientId              the client id
     * @param clientSecret          the client secret
     * @param port                  the port
     * @param refreshToken          the refresh token
     * @param refreshTokenCreatedAt the refresh token created at
     */
    public RefreshTokenAuthorization(String clientId, String clientSecret, Integer port, String refreshToken, Calendar refreshTokenCreatedAt) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.port = port;
        this.refreshToken = refreshToken;
        this.refreshTokenCreatedAt = refreshTokenCreatedAt;
    }

    @Override
    public TokenAccess getTokenAccess() throws AllerException {
        try {
            this.authorizationEndPoint = (this.authorizationEndPoint == null) ? new URL(DEFAULT_AUTHORIZATION_END_POINT) : this.authorizationEndPoint;

            URL allegroRefreshTokenUrl = new URL(String.format(this.authorizationEndPoint + "/token?grant_type=refresh_token&refresh_token=%1$s&redirect_uri=%2$s", this.refreshToken, "http://localhost:" + this.port));
            String authorizationBase64 = Base64.getEncoder().encodeToString(new String(this.clientId + ":" + this.clientSecret).getBytes());
            PostHttpSender sender = new PostHttpSender(allegroRefreshTokenUrl).addRequestProperty("Authorization", "Basic " + authorizationBase64);
            ObjectMapper mapper = new ObjectMapper();
            TokenAccess tokenAccess = mapper.readValue(sender.getResponse(), TokenAccess.class);
            tokenAccess.setCreatedAt(Calendar.getInstance());
            tokenAccess.setRefreshTokenCreatedAt(this.refreshTokenCreatedAt);
            return tokenAccess;
        }
        catch (IOException e) {
            throw new AllerException(e);
        }
    }

    /**
     * Sets authorization end point.
     *
     * @param authorizationEndPoint the authorization end point
     */
    public void setAuthorizationEndPoint(URL authorizationEndPoint) {
        this.authorizationEndPoint = authorizationEndPoint;
    }
}
