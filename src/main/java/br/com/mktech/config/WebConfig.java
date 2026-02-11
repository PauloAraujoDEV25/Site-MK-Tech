package br.com.mktech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuração Web para servir arquivos estáticos.
 *
 * Garante que CSS, JS e imagens sejam servidas corretamente.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Servir arquivos CSS
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");

        // Servir arquivos JavaScript
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");

        // Servir imagens
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/");
    }
}
