package com.api.cards_api;

import lombok.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtCore {
    @Value("${cards_api.app.secret}")
    private String secret;
    @Value
    private int lifetime;

    public String generateToken(Authentication) {

    }
}


