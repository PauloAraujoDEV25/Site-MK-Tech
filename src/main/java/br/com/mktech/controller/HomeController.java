package br.com.mktech.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller principal do site.
 * Responsável pela exibição da página inicial (landing page).
 *
 * Segue princípios de Clean Architecture e SOLID:
 * - Single Responsibility: apenas renderiza a landing page
 * - Separação de responsabilidades: HTML/CSS/JS em arquivos estáticos
 */
@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        log.debug("Acessando página inicial (landing page)");
        return "landing";
    }
}
