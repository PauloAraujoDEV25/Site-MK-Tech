package br.com.mktech.controller;

import br.com.mktech.service.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @Autowired(required = false)
    private IPackageService packageService;
    
    @GetMapping("/test")
    public String test() {
        return "✅ Servidor está respondendo!";
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
    
    @GetMapping("/api/packages")
    public String packages() {
        try {
            if (packageService == null) {
                return "PackageService é null!";
            }
            return "Pacotes: " + packageService.getAllPackages().size();
        } catch (Exception e) {
            return "Erro: " + e.getMessage() + " - " + e.getClass().getName();
        }
    }
}
