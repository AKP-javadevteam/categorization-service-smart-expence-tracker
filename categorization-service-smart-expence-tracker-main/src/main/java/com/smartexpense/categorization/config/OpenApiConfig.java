package com.smartexpense.categorization.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig<OpenApiCustomizer> {
    @Bean
    public OpenApiCustomizer infoCustomizer() {
        return openApi -> {
            return openApi.info(new Info().title("Categorization Service API")
                    .version("v1")
                    .description("Rules-based categorization microservice (rules-only)"));
        };
    }
}
