package com.kkm.kkm_server_v2.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("꼬꼬막 API")
                .version("version 1.0")
                .description("꼬꼬막 API 문서");

        return new OpenAPI()
                .info(info);
    }

}