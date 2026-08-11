package com.icoderman.woocommerce.oauth;

import com.icoderman.woocommerce.HttpMethod;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OAuthSignatureTest {
    private final OAuthConfig config = new OAuthConfig("https://example.com", "consumer key", "consumer-secret");

    @Test
    public void returnsEmptyValuesForIncompleteInput() {
        assertTrue(OAuthSignature.getAsMap(null, "https://example.com", HttpMethod.GET).isEmpty());
        assertEquals("", OAuthSignature.getAsQueryString(config, null, HttpMethod.GET));
    }

    @Test
    public void includesRequiredOAuthParameters() {
        Map<String, String> values = OAuthSignature.getAsMap(
                config, "https://example.com/wp-json/wc/v3/products", HttpMethod.GET);
        assertEquals("consumer key", values.get("oauth_consumer_key"));
        assertEquals("HMAC-SHA256", values.get("oauth_signature_method"));
        assertTrue(values.containsKey("oauth_nonce"));
        assertTrue(values.containsKey("oauth_timestamp"));
        assertTrue(values.containsKey("oauth_signature"));
    }

    @Test
    public void percentEncodesQueryValues() {
        Map<String, String> params = new HashMap<>();
        params.put("search", "coffee & tea");
        String query = OAuthSignature.getAsQueryString(
                config, "https://example.com/wp-json/wc/v3/products", HttpMethod.GET, params);
        assertTrue(query.contains("search=coffee%20%26%20tea"));
        assertFalse(query.contains("coffee+%26+tea"));
    }

    @Test
    public void deleteAddsWooCommerceForceParameter() {
        Map<String, String> values = OAuthSignature.getAsMap(
                config, "https://example.com/wp-json/wc/v3/products/1", HttpMethod.DELETE,
                Collections.<String, String>emptyMap());
        assertEquals("true", values.get("force"));
    }

    @Test
    public void doubleEncodesIsoDateInsideSignatureBaseString() {
        Map<String, String> params = new HashMap<>();
        params.put("after", "2023-02-21T13:00:23");

        String baseString = OAuthSignature.getSignatureBaseString(
                "https://example.com/wp-json/wc/v3/orders", "GET", params);

        assertTrue(baseString.contains("after%3D2023-02-21T13%253A00%253A23"));
    }
}
