package com.erlenelo.vesselsearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class to enable Cross-Origin Resource Sharing for a local React application
 * running on http://localhost:3000 to interact with the database on http://localhost:8080.
 */
@Configuration
public class CorsConfig {

    /**
     * Configures CORS settings for the application.
     *
     * @return an instance of WebMvcConfigurer with CORS configurations
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000") 
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}