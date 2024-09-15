package com.thieunm.messaging_api.config.cors;

import com.thieunm.messaging_api.config.cors.CorsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig {

    @Bean
    public CorsProperties corsProperties() {
        return new CorsProperties();
    }
}
