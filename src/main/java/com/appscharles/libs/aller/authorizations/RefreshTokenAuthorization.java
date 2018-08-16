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
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.08.2018
 * Time: 15:15
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class RefreshTokenAuthorization implements ITokenAuthorization {

    private final static String DEFAULT_AUTHORIZATION_END_POINT = "https://allegro.pl/auth/oauth";

    private String clientId;

    private String clientSecret;

    private Integer port;

    private String refreshToken;

    private URL authorizationEndPoint;

    public RefreshTokenAuthorization(String clientId, String clientSecret, Integer port, String refreshToken) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.port = port;
        this.refreshToken = refreshToken;
    }

    @Override
    public TokenAccess getTokenAccess() throws AllerException {
        try {
            this.authorizationEndPoint = (this.authorizationEndPoint == null) ? new URL(DEFAULT_AUTHORIZATION_END_POINT) : this.authorizationEndPoint;

            URL allegroRefreshTokenUrl = new URL(String.format(this.authorizationEndPoint + "/token?grant_type=refresh_token&refresh_token=%1$s&redirect_uri=%2$s", this.refreshToken, "http://localhost:" + this.port));
            String authorizationBase64 = Base64.getEncoder().encodeToString(new String(this.clientId + ":" + this.clientSecret).getBytes());
            PostHttpSender sender = new PostHttpSender(allegroRefreshTokenUrl).addRequestProperty("Authorization", "Basic " + authorizationBase64);
            sender.send();
            ObjectMapper mapper = new ObjectMapper();
            TokenAccess tokenAccess = mapper.readValue(sender.getContent(), TokenAccess.class);
            tokenAccess.setCreatedAt(Calendar.getInstance());
            return tokenAccess;
        }
        catch (IOException e) {
            throw new AllerException(e);
        }
    }

    /**
     * Setter for property 'authorizationEndPoint'.
     *
     * @param authorizationEndPoint Value to set for property 'authorizationEndPoint'.
     */
    public void setAuthorizationEndPoint(URL authorizationEndPoint) {
        this.authorizationEndPoint = authorizationEndPoint;
    }
}
