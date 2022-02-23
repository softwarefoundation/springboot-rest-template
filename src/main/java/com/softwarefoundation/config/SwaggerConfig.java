package com.softwarefoundation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value(value = "${app.version}")
    private String appVersion;
    @Value(value = "${spring.application.name}")
    private String applicationName;
    @Value(value = "${spring.profiles.active}")
    private String profile;

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.softwarefoundation.restcontroller"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("applicationName")
                .description("applicationName" + " - Documentação de acesso aos endpoints").version("profile".concat(" " +"appVersion"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact())
                .build();
    }
    private Contact contact() {
        return new Contact("Softeware Foundation", "https://github.com/sofwarefoundation", "agenda.sofwarefoundation@gmail.com");
    }

}
