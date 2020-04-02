package com.in28Minutes.rest.webservices.restwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        // URL : http://localhost:8080/v2/api-docs - get swagger documentation
        // URL : http://localhost:8080/swagger-ui.html - visualize the swagger documentation
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
