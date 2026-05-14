package com.template.ms_api_gateway.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.test.util.ReflectionTestUtils;

public class SecurityConfigFilterTest {
    
@Test
    void shouldCreateSecurityWebFilterChain() {
        SecurityConfig config = new SecurityConfig();

        // ✅ Inyectar secret
        ReflectionTestUtils.setField(
                config,
                "secret",
                "myVerySecretKeyForJwtAuthentication12345678901234567890"
        );

        // ✅ usar instancia real (NO mock)
        ServerHttpSecurity http = ServerHttpSecurity.http();

        SecurityWebFilterChain chain = config.securityWebFilterChain(http);

        assertNotNull(chain);
    }

}
