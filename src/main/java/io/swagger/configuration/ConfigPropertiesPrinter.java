package io.swagger.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigPropertiesPrinter {

    @Value("${server.port}")
    private String serverPort;

    @Bean
    public CommandLineRunner printProperties() {
        return args -> {
            System.out.println("Server port: " + serverPort);

        };
    }
}