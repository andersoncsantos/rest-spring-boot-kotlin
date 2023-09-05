package br.com.anderson.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    /*http://localhost:8080/swagger-ui/index.html*/

    @Bean
    fun customOpenApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("RESTful API with Kotlin 1.6.10 and Spring Boot 3.0.0")
                    .version("v1")
                    .description("Some description about your API.")
                    .termsOfService("")
                    .license(
                        License().name("Apache 2.0")
                            .url("")
                    )

            )
    }
}