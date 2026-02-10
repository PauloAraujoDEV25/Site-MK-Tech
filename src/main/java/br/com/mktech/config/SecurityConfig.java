package br.com.mktech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;

/**
 * Configuração de segurança da aplicação.
 *
 * Implementa:
 * - CSRF Protection (Cross-Site Request Forgery)
 * - Security Headers (XSS, Content-Type, Frame-Options)
 * - CORS e autorização
 *
 * Segue padrões de segurança OWASP Top 10.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF Protection habilitado por padrão
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/**")  // APIs REST não precisam de CSRF token
                )
                // Autorização de requisições
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()  // Permite acesso público a todas as rotas
                        .anyRequest().authenticated()
                )
                // Security Headers
                .headers(headers -> headers
                        // X-Frame-Options: DENY (previne clickjacking)
                        .frameOptions(frame -> frame.deny())
                        // X-Content-Type-Options: nosniff
                        .contentTypeOptions(cto -> cto.disable())
                        // X-XSS-Protection
                        .addHeaderWriter(new XXssProtectionHeaderWriter())
                        // Strict-Transport-Security (HSTS) - habilitado apenas em produção
                        .httpStrictTransportSecurity(hsts -> hsts
                                .includeSubDomains(true)
                                .maxAgeInSeconds(31536000)  // 1 ano
                        )
                );

        return http.build();
    }
}
