package br.com.mktech.controller;

import br.com.mktech.service.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller principal do site
 * Responsável pela exibição da página inicial
 */
@Controller
public class HomeController {

    private final IPackageService packageService;

    @Autowired
    public HomeController(IPackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping("/")
    public String home(Model model) {
        try {
            model.addAttribute("packages", packageService.getAllPackages());
        } catch (Exception e) {
            System.err.println("Erro ao carregar pacotes: " + e.getMessage());
            e.printStackTrace();
        }
        return "index";
    }
}

