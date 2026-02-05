package br.com.mktech.model;

import java.util.Arrays;
import java.util.List;

/**
 * Pacote Ouro - Conforto Completo
 * Serviços: Prata + Temperatura + Câmera
 */
public class GoldPackage extends ServicePackage {

    public GoldPackage() {
        super(
            "Pacote Ouro",
            "Intermediário",
            2999.90,
            createServices(),
            "Conforto e segurança elevados ao próximo nível"
        );
    }

    private static List<Service> createServices() {
        return Arrays.asList(
            new SmartLightService(),
            new SmartLockService(),
            new SmartTemperatureService(),
            new SmartCameraService()
        );
    }

    @Override
    public String getBenefits() {
        return "Perfeito para famílias que buscam conforto térmico " +
               "e segurança avançada com monitoramento.";
    }
}

