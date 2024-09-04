package com.mentes_innovadoras.gift4you.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Value("${gift4you.base-url}")
    private String baseUrl;
    @Value("${server.description}")
    private String serverDescription;

    @Bean
    public OpenAPI myOpenAPI() {
        Server server = new Server();
        server.setUrl(baseUrl);
        server.setDescription(serverDescription);

        Info info = new Info()
                .title("Gift For You")
                .version("V1.0")
                .description("Gift-4-You Documentation");

        SecurityScheme securityScheme = new SecurityScheme()
                .name("bearer-jwt")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearer-jwt");

        return new OpenAPI()
                .info(info)
                .servers(List.of(server))
                .components(new io.swagger.v3.oas.models.Components().addSecuritySchemes("bearer-jwt", securityScheme))
                .addSecurityItem(securityRequirement);
    }
}
