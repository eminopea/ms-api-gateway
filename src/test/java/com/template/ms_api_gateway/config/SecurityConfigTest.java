package com.template.ms_api_gateway.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.test.util.ReflectionTestUtils;

public class SecurityConfigTest {

    @Test
    void shouldCreateJwtDecoder() {
        SecurityConfig config = new SecurityConfig();
 
        ReflectionTestUtils.setField(
                config,
                "secret",
                "myVerySecretKeyForJwtAuthentication12345678901234567890"
        );

        ReactiveJwtDecoder decoder = config.jwtDecoder();

        assertNotNull(decoder);
    }

}
