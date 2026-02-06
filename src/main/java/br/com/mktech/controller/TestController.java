package br.com.mktech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/test")
    public String test() {
        return "✅ Servidor está respondendo!";
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
