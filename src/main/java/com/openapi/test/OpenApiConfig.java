package com.openapi.test;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* Configuración de propiedades básicas de OpenAPI.
* */
@Configuration
public class OpenApiConfig {

    // definimos un Bean donde configuramos el objeto info con la informacion que queremos mostrar
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Documentacion de API con OpenApi")
                                .version("1.0.0")
                                .description("Implementacion basica de OpenAPI")
                );
    }

    // También podemos modificar las propiedades.
    @Bean
    public OpenApiCustomizer customizer() {
        return openApi -> {
            openApi.getTags().forEach(tag -> {
                System.out.println(tag.getName());
            });
        };
    }

}
