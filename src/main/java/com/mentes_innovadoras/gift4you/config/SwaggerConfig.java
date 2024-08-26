package com.mentes_innovadoras.gift4you.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gift-4-You")
                        .version("1.0")
                        .description("Gift-4-You Documentation"));
    }

    private String devUrl = "http://localhost:2403";

//    @Value("")
//    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

//        Server prodServer = new Server();
//        prodServer.setUrl(prodUrl);
//        prodServer.setDescription("Server URL in Production environment");


        Info info = new Info()
                .title("Gift-4-You")
                .version("1.0")
                .description("Gift-4-You Documentation");


        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
