package com.example.authservice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthClientConfig {
    public static final String SERVICE_NAME = "AUTH";
    public static final String URL_PROP = "auth.service.url";


}
