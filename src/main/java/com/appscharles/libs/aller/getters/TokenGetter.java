package com.appscharles.libs.aller.getters;

import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.senders.PostHttpSender;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.08.2018
 * Time: 15:15
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class TokenGetter extends AbstractTokenGetter {

    private final static String DEFAULT_AUTHORIZATION_END_POINT = "https://allegro.pl/auth/oauth/";

    private String clientId;

    private String clientSecret;

    private long authorizeTimeout;

    private Integer[] redirectPorts;

    private URL authorizationEndPoint;

    private String htmlSuccessResponse;

    private String htmlFailedResponse;

    public TokenGetter(String clientId, String clientSecret, long authorizeTimeout, Integer ... redirectPorts) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorizeTimeout = authorizeTimeout;
        this.redirectPorts = redirectPorts;
    }

    @Override
    public TokenAccess get() throws AllerException {
        try {
            this.authorizationEndPoint = (this.authorizationEndPoint == null) ? new URL(DEFAULT_AUTHORIZATION_END_POINT) : this.authorizationEndPoint;
            AuthorizeCodeGetter getter = new AuthorizeCodeGetter(this.clientId, this.authorizeTimeout, this.redirectPorts);
            if (this.htmlSuccessResponse != null) {
                getter.setHtmlSuccessResponse(this.htmlSuccessResponse);
            }
            if (this.htmlFailedResponse != null) {
                getter.setHtmlFailedResponse(this.htmlFailedResponse);
            }
            getter.setAuthorizationEndPoint(this.authorizationEndPoint);
            String code = getter.get();
            Integer port = AvailablePortGetter.get(this.redirectPorts);
            URL allegroTokenUrl = new URL(String.format(this.authorizationEndPoint + "token?grant_type=authorization_code&code=%1$s&redirect_uri=%2$s", code, "http://localhost:" + port));
            String authorizationBase64 = Base64.getEncoder().encodeToString(new String(this.clientId + ":" + this.clientSecret).getBytes());
            PostHttpSender sender = new PostHttpSender(allegroTokenUrl).addRequestProperty("Authorization", "Basic " + authorizationBase64);
            sender.send();
            ObjectMapper mapper = new ObjectMapper();
            TokenAccess tokenAccess = mapper.readValue(sender.getContent(), TokenAccess.class);
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

    /**
     * Setter for property 'htmlSuccessResponse'.
     *
     * @param htmlSuccessResponse Value to set for property 'htmlSuccessResponse'.
     */
    public void setHtmlSuccessResponse(String htmlSuccessResponse) {
        this.htmlSuccessResponse = htmlSuccessResponse;
    }

    /**
     * Setter for property 'htmlFailedResponse'.
     *
     * @param htmlFailedResponse Value to set for property 'htmlFailedResponse'.
     */
    public void setHtmlFailedResponse(String htmlFailedResponse) {
        this.htmlFailedResponse = htmlFailedResponse;
    }
}
