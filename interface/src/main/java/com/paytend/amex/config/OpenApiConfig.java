package com.paytend.amex.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xixi
 */

@Configuration
public class OpenApiConfig {
    @Bean
    protected OpenAPI springDocOpenAPI() {
        return new OpenAPI().info(new Info()
                        .title("AMEX API")
                        .description("AMEX DESC")
                        .version("v0.0.1-SNAPSHOT")
                        .license(new License().name("AMEX ")
                                .url("www.paytend.com ")))
                .externalDocs(new ExternalDocumentation()
                        .description("AMEX")
                        .url("AMEX"))

                // 配置Authorizations
                .components(new Components().addSecuritySchemes("bearer-key",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")))
                ;
    }

}
