package com.poktest.swagger.swaggertutorial.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.poktest.swagger.swaggertutorial.api.controller"))
                //.paths(PathSelectors.ant("/api/**"))
                //.paths(regex("/api.*"))  // to use this method much import static springfox.documentation.builders.PathSelectors.regex;
                .paths(postPaths())
                .build()
                .apiInfo(metaInfo());

    }

    private Predicate<String> postPaths() {
        return or(regex("/api/hello.*"), regex("/api/user.*"));
    }

    //custom infomation
    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Swagger Example API",  // title
                "Spring Boot Swagger Example API for youtube",  // description
                "1.0",
                "Terms of Service",
                new Contact("PokAha","https://www.youtube.com","poktest@mail.com"),
                "Apache License Version 2.0",
                "https://www.google.com"
        );
        return apiInfo;
    }
}
