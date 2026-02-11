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
        // Servir todos os arquivos estáticos sem cache
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }
}
