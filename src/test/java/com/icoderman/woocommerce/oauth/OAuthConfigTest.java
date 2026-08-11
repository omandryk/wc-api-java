package com.icoderman.woocommerce.oauth;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OAuthConfigTest {

    @Test
    public void removesOneTrailingSlashFromStoreUrl() {
        OAuthConfig config = new OAuthConfig(
                "https://store.example.com/",
                "consumer-key",
                "consumer-secret"
        );

        assertEquals("https://store.example.com", config.getUrl());
    }

    @Test
    public void preservesStoreUrlWithoutTrailingSlash() {
        OAuthConfig config = new OAuthConfig(
                "https://store.example.com",
                "consumer-key",
                "consumer-secret"
        );

        assertEquals("https://store.example.com", config.getUrl());
    }
}
