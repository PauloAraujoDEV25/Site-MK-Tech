package br.com.mktech.model;

import java.util.Arrays;
import java.util.List;

/**
 * Pacote Platina - Automação Total
 * Todos os serviços disponíveis
 */
public class PlatinumPackage extends ServicePackage {

    public PlatinumPackage() {
        super(
            "Pacote Platina",
            "Premium",
            4499.90,
            createServices(),
            "Automação residencial completa - a casa do futuro"
        );
    }

    private static List<Service> createServices() {
        return Arrays.asList(
            new SmartLightService(),
            new SmartLockService(),
            new SmartCurtainService(),
            new SmartTemperatureService(),
            new SmartCameraService()
        );
    }

    @Override
    public String getBenefits() {
        return "A solução definitiva: controle total da sua casa, " +
               "máxima economia de energia e segurança incomparável.";
    }
}

