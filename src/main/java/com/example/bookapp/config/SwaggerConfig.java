package com.example.bookapp.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//
@Configuration
@OpenAPIDefinition
@SecurityScheme(name = "JWT", scheme = "bearer",
        type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {
        return new OpenAPI().info(new Info()
                .summary("My BookApp REST project")
                .description("This is my BookApp project")
                .title("REST BookApp")
                .version("1.0.0.")
                .license(new License().name("By Shishkov"))
                .contact(new Contact()
                        .name("Shiskov Evgeny")
                        .email("ev.1103248@gmail.ru")));
    }

    @Bean
    public GroupedOpenApi getFirstControllerApi() {
        return GroupedOpenApi.builder()
                .group("First controller group")
                .displayName("BookAdmin controller group")
                .pathsToMatch("/books_admin/**")
                .build();
    }

    @Bean
    public GroupedOpenApi getSecondController(){
        return GroupedOpenApi.builder()
                .group("second controller group")
                .displayName("Authentication controller group")
                .pathsToMatch("/auth/**")
                .build();
    }
//    @Bean
//    public GroupedOpenApi getThirdController(){
//        return GroupedOpenApi.builder()
//                .group("fourth controller group")
//                .displayName("Authors controller group")
//                .pathsToMatch("/authors/**")
//                .build();
//    }
    @Bean
    public GroupedOpenApi getFifthController(){
        return GroupedOpenApi.builder()
                .group("fifth controller group")
                .displayName("BookUser controller group")
                .pathsToMatch("/books_user/**")
                .build();
    }
    @Bean
    public GroupedOpenApi getSixthController(){
        return GroupedOpenApi.builder()
                .group("sixth controller group")
                .displayName("AuthorUser controller group")
                .pathsToMatch("/authors_user/**")
                .build();
    }
    @Bean
    public GroupedOpenApi getSeventhController(){
        return GroupedOpenApi.builder()
                .group("seventh controller group")
                .displayName("AuthorAdmin controller group")
                .pathsToMatch("/authors_admin/**")
                .build();
    }
}
