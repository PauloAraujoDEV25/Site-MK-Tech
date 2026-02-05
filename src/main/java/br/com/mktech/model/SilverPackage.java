package br.com.mktech.model;

import java.util.Arrays;
import java.util.List;

/**
 * Pacote Prata - Entrada no mundo da automação
 * Serviços básicos: Lâmpadas + Trancas
 */
public class SilverPackage extends ServicePackage {

    public SilverPackage() {
        super(
            "Pacote Prata",
            "Básico",
            1499.90,
            createServices(),
            "Comece sua jornada na automação residencial"
        );
    }

    private static List<Service> createServices() {
        return Arrays.asList(
            new SmartLightService(),
            new SmartLockService()
        );
    }

    @Override
    public String getBenefits() {
        return "Ideal para quem quer começar com o essencial: " +
               "segurança e conforto na iluminação.";
    }
}

