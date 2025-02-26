package com.vasanth.springapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Register Java 8 Date/Time Module (for LocalDate, LocalDateTime)
        objectMapper.registerModule(new JavaTimeModule());

        // Enable pretty-printing of JSON output
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Disable timestamps for LocalDate and LocalDateTime
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return objectMapper;
    }
}
