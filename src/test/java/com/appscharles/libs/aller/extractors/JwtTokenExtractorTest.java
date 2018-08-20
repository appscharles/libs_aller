package com.appscharles.libs.aller.extractors;

import com.appscharles.libs.aller.TestCase;
import com.appscharles.libs.aller.accesses.TokenAccess;
import com.appscharles.libs.aller.exceptions.AllerException;
import com.appscharles.libs.aller.managers.TokenManager;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 18.08.2018
 * Time: 15:33
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class JwtTokenExtractorTest extends TestCase {

    @Test
    public void shouldGetSellerId() throws MalformedURLException, AllerException {
        TokenManager.setConfiguration(getTokenManagerConfiguration());
        TokenAccess tokenAccess = TokenManager.getTokenAccess(getLoginAllegro());
        JwtToken jwtToken = new JwtTokenExtractor(tokenAccess.getToken()).extract();
        Assert.assertFalse(jwtToken.getUsername().isEmpty());
    }
}