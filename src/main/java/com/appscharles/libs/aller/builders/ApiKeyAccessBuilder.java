package com.appscharles.libs.aller.builders;

import com.appscharles.libs.aller.accesses.ApiKeyAccess;
import com.appscharles.libs.aller.exceptions.AllerException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Api key access builder.
 */
public class ApiKeyAccessBuilder {

    private File propertiesFile;

    private ApiKeyAccessBuilder(){

    }

    /**
     * Create api key access builder.
     *
     * @param propertiesFile the properties file
     * @return the api key access builder
     */
    public static ApiKeyAccessBuilder create(File propertiesFile){
        ApiKeyAccessBuilder instance = new ApiKeyAccessBuilder();
        instance.propertiesFile = propertiesFile;
        return instance;
    }

    /**
     * Build api key access.
     *
     * @return the api key access
     * @throws AllerException the aller exception
     */
    public ApiKeyAccess build() throws AllerException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(this.propertiesFile));
        } catch (IOException e) {
           throw new AllerException(e);
        }
        String clientId = properties.getProperty("libs_aller.test.client_id");
        String clientSecret = properties.getProperty("libs_aller.test.client_secret");
        if (clientId == null){
            throw new AllerException("Client ID is null.");
        } else if (clientSecret == null){
            throw new AllerException("Client secret is null.");
        } else if (clientId.isEmpty()){
            throw new AllerException("Client ID is empty.");
        } else if (clientSecret.isEmpty()){
            throw new AllerException("Client secret is empty.");
        }
        return new ApiKeyAccess(clientId,clientSecret);
    }
}
