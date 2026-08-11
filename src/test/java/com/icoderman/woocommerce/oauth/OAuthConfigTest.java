package com.icoderman.woocommerce.oauth;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OAuthConfigTest {
    @Test(expected = IllegalArgumentException.class)
    public void rejectsMissingConsumerSecret() {
        new OAuthConfig("https://example.com", "consumer-key", "");
    }

    @Test
    public void retainsConfigurationValues() {
        OAuthConfig config = new OAuthConfig("https://example.com", "consumer-key", "consumer-secret");
        assertEquals("https://example.com", config.getUrl());
        assertEquals("consumer-key", config.getConsumerKey());
        assertEquals("consumer-secret", config.getConsumerSecret());
    }

    @Test
    public void removesTrailingSlashFromStoreUrl() {
        OAuthConfig config = new OAuthConfig("https://example.com/", "consumer-key", "consumer-secret");
        assertEquals("https://example.com", config.getUrl());
    }
}
