package com.SamarthToge.PayCore.Configurations;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIDocConfig {

    @Value("${server.port:8080}")
    private String serverPort;

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()

                // API server information
                .servers(java.util.List.of(
                        new Server()
                                .url("http://localhost:" + serverPort)
                                .description("Local Development Server")
                ))

                // API information
                .info(new Info()
                        .title("My Application API")
                        .description(
                                "REST API documentation for my Spring Boot application. "
                                        + "This documentation describes the available endpoints, "
                                        + "request parameters, request bodies, and responses."
                        )
                        .version("1.0.0")

                        // Developer or organization information
                        .contact(new Contact()
                                .name("Development Team")
                                .email("developer@example.com")
                        )

                        // API license information
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")
                        )
                )

                // Define JWT Bearer authentication
                .components(new Components()
                        .addSecuritySchemes(
                                "Bearer Authentication",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description(
                                                "Enter your JWT access token. "
                                                        + "Swagger UI will send it using "
                                                        + "the Authorization: Bearer <token> header."
                                        )
                        )
                )

                // Apply authentication requirement to documented APIs
                .addSecurityItem(
                        new SecurityRequirement()
                                .addList("Bearer Authentication")
                );
    }
}