package com.appscharles.libs.aller.managers;

import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.authorizations.RefreshTokenAuthorization;
import com.appscharles.libs.aller.builders.NewTokenAccessBuilder;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.getters.AvailablePortGetter;
import com.appscharles.libs.aller.validators.RefreshTokenValidator;
import com.appscharles.libs.aller.validators.ExpireTokenValidator;
import com.appscharles.libs.ioer.services.FileReader;
import com.appscharles.libs.ioer.services.FileWriter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jasypt.util.text.StrongTextEncryptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Token manager.
 */
public class TokenManager {

    private static Map<String, TokenAccess> tokens;

    private static TokenManagerConfiguration configuration;

    /**
     * Gets token access.
     *
     * @param loginAllegro the login allegro
     * @return the token access
     * @throws AllerException the aller exception
     */
    public static TokenAccess getTokenAccess(String loginAllegro) throws AllerException {
        synchronized ( TokenManager.class ){
            initTokens();
            checkConfiguration();
            for (Map.Entry<String, TokenAccess> entry : tokens.entrySet()) {
                if (entry.getValue().getLoginAllegro().equals(loginAllegro)) {
                    TokenAccess tokenAccess = entry.getValue();
                    if (RefreshTokenValidator.isValid(tokens.get(loginAllegro)) == false){
                        return forceRefreshTokenAccess(loginAllegro);
                    } else if (ExpireTokenValidator.isValid(tokenAccess) == false) {
                        refreshTokenAccess(loginAllegro, 3);
                    }
                    return tokenAccess;
                }
            }
            return newTokenAccess(loginAllegro);
        }
    }

    public static Boolean isActiveAccessToken(String loginAllegro) throws AllerException {
        synchronized ( TokenManager.class ) {
            initTokens();
            checkConfiguration();
            if (tokens.containsKey(loginAllegro) == false){
                return false;
            }
            TokenAccess tokenAccess = tokens.get(loginAllegro);
            if (RefreshTokenValidator.isValid(tokenAccess)){
                return true;
            }
            return false;
        }
    }

    /**
     * Force refresh token access token access.
     *
     * @param loginAllegro the login allegro
     * @return the token access
     */
    public static TokenAccess forceRefreshTokenAccess(String loginAllegro) throws AllerException {
    synchronized ( TokenManager.class ) {
        initTokens();
        checkConfiguration();
        TokenAccess tokenAccess = NewTokenAccessBuilder.create(loginAllegro, configuration.getClientId(), configuration.getClientSecret(), configuration.getRedirectPorts(), configuration.getAuthorizationEndPoint()).build();
        tokens.remove(loginAllegro);
        tokens.put(loginAllegro, tokenAccess);
        saveTokens();
        return tokenAccess;
    }
}

    /**
     * New token access token access.
     *
     * @param loginAllegro the login allegro
     * @return the token access
     * @throws AllerException the aller exception
     */
    public static TokenAccess newTokenAccess(String loginAllegro) throws AllerException {
        synchronized ( TokenManager.class ) {
            initTokens();
            checkConfiguration();
            if (tokens.containsKey(loginAllegro)) {
                throw new AllerException("Token for '" + loginAllegro + "' is exist.");
            }
            TokenAccess tokenAccess = NewTokenAccessBuilder.create(loginAllegro, configuration.getClientId(), configuration.getClientSecret(), configuration.getRedirectPorts(), configuration.getAuthorizationEndPoint()).build();
            tokens.put(loginAllegro, tokenAccess);
            saveTokens();
            return tokenAccess;
        }
    }

    /**
     * Remove token access.
     *
     * @param loginAllegro the login allegro
     * @throws AllerException the aller exception
     */
    public static void removeTokenAccess(String loginAllegro) throws AllerException {
        synchronized ( TokenManager.class ) {
            initTokens();
            if (tokens.containsKey(loginAllegro) == false) {
                throw new AllerException("Token '" + loginAllegro + "' is not exist.");
            }
            tokens.remove(loginAllegro);
            saveTokens();
        }
    }

    /**
     * Refresh token access token access.
     *
     * @param loginAllegro the login allegro
     * @param attempts     the attempts
     * @return the token access
     * @throws AllerException the aller exception
     */
    public static TokenAccess refreshTokenAccess(String loginAllegro, Integer attempts) throws AllerException {
        synchronized ( TokenManager.class ) {
            initTokens();
            checkConfiguration();
            if (tokens.containsKey(loginAllegro) == false) {
                throw new AllerException("Token '" + loginAllegro + "' is not exist.");
            }
            Exception exception = null;
            TokenAccess tokenAccess = null;
            for (int i = 0; i < attempts; i++) {
                try {
                    Integer port = AvailablePortGetter.get(configuration.getRedirectPorts());
                    RefreshTokenAuthorization refreshTokenAuthorization = new RefreshTokenAuthorization(configuration.getClientId(), configuration.getClientSecret(), port, tokens.get(loginAllegro).getRefreshToken(), tokens.get(loginAllegro).getRefreshTokenCreatedAt());
                    refreshTokenAuthorization.setAuthorizationEndPoint(configuration.getAuthorizationEndPoint());
                    tokenAccess = refreshTokenAuthorization.getTokenAccess();
                    tokenAccess.setLoginAllegro(loginAllegro);
                    break;
                } catch (AllerException e) {
                    exception = e;
                }
            }
            if (tokenAccess == null) {
                throw new AllerException("Can not refresh token '" + loginAllegro + "'.", exception);
            }
            removeTokenAccess(loginAllegro);
            tokens.put(loginAllegro, tokenAccess);
            saveTokens();
            return tokenAccess;
        }
    }

    private static void initTokens() throws AllerException {
        if (tokens == null) {
            tokens = new HashMap<>();
            if (configuration.getFileConfigurationsTokens().exists()){
                ObjectMapper mapper = new ObjectMapper();
                StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
                textEncryptor.setPassword(configuration.getSaltPassword());
                try {
                    String json = textEncryptor.decrypt(FileReader.read(configuration.getFileConfigurationsTokens()));
                    tokens = mapper.readValue(json, new TypeReference<Map<String, TokenAccess>>(){});
                } catch (IOException e) {
                    throw new AllerException(e);
                }
            }
        }
    }

    private static void saveTokens() throws AllerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tokens);
            StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
            textEncryptor.setPassword(configuration.getSaltPassword());
            FileWriter.write(configuration.getFileConfigurationsTokens(), textEncryptor.encrypt(json));
        } catch (IOException e) {
           throw new AllerException(e);
        }
    }

    private static void checkConfiguration() throws AllerException {
        if (configuration == null) {
            throw new AllerException("Set token manager configuration");
        }
    }

    /**
     * Sets configuration.
     *
     * @param configuration the configuration
     */
    public static void setConfiguration(TokenManagerConfiguration configuration) {
        TokenManager.configuration = configuration;
    }

    /**
     * Gets tokens.
     *
     * @return the tokens
     * @throws AllerException the aller exception
     */
    public static Map<String, TokenAccess> getTokens() throws AllerException {
        synchronized ( TokenManager.class ) {
            initTokens();
            checkConfiguration();
            return tokens;
        }
    }
}
