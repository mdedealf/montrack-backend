package com.mdedealf.montrackbackend.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public class JwtConfigProperties {
    private String secret;
}
