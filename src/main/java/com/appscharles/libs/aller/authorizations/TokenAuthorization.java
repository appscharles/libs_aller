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
 * The type Token authorization.
 */
public class TokenAuthorization implements ITokenAuthorization {

    private final static String DEFAULT_AUTHORIZATION_END_POINT = "https://allegro.pl/auth/oauth/";

    private String clientId;

    private String clientSecret;

    private Integer port;

    private ICodeAuthorization authorizeCodeGetter;

    private URL authorizationEndPoint;

    /**
     * Instantiates a new Token authorization.
     *
     * @param clientId            the client id
     * @param clientSecret        the client secret
     * @param port                the port
     * @param authorizeCodeGetter the authorize code getter
     */
    public TokenAuthorization(String clientId, String clientSecret, Integer port, ICodeAuthorization authorizeCodeGetter) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.port = port;
        this.authorizeCodeGetter = authorizeCodeGetter;
    }

    @Override
    public TokenAccess getTokenAccess() throws AllerException {
        try {
            this.authorizationEndPoint = (this.authorizationEndPoint == null) ? new URL(DEFAULT_AUTHORIZATION_END_POINT) : this.authorizationEndPoint;
            String code = this.authorizeCodeGetter.getCode();
            URL allegroTokenUrl = new URL(this.authorizationEndPoint + "/token");
            String authorizationBase64 = Base64.getEncoder().encodeToString(new String(this.clientId + ":" + this.clientSecret).getBytes());
            PostHttpSender sender = new PostHttpSender(allegroTokenUrl).addRequestProperty("Authorization", "Basic " + authorizationBase64);
sender.setData(String.format("grant_type=authorization_code&code=%1$s&redirect_uri=%2$s", code, "http://localhost:" + this.port));
            ObjectMapper mapper = new ObjectMapper();
            TokenAccess tokenAccess = mapper.readValue(sender.getResponse(), TokenAccess.class);
            tokenAccess.setCreatedAt(Calendar.getInstance());
            tokenAccess.setRefreshTokenCreatedAt(Calendar.getInstance());
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
