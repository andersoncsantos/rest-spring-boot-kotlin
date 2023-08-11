package br.com.anderson.config

import br.com.anderson.serialization.converter.YamlConverter
import br.com.anderson.utils.ContentMediaType
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun extendMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(YamlConverter())
    }

    override fun configureContentNegotiation(configurer: ContentNegotiationConfigurer) {


        /*

        passando no  query parameter

        configurer.favorParameter(true)
            .parameterName("mediaType")
            .ignoreAcceptHeader(true)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_ATOM_XML)*/

        /*passando no header */
        configurer.favorParameter(false)
            .ignoreAcceptHeader(false)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(ContentMediaType.APPLICATION_JSON)
            .mediaType("json", ContentMediaType.APPLICATION_JSON)
            .mediaType("xml", ContentMediaType.APPLICATION_XML)
            .mediaType("x-yaml", ContentMediaType.APPLICATION_YML)



    }
}