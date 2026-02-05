package br.com.mktech.model;

/**
 * Serviço de Cortinas Inteligentes
 * Automação de cortinas e persianas
 */
public class SmartCurtainService extends Service {

    public SmartCurtainService() {
        super(
            "Cortinas Inteligentes",
            "Automação completa de cortinas e persianas",
            "🪟"
        );
    }

    @Override
    public String getDetails() {
        return "Abra e feche cortinas automaticamente, " +
               "programe horários e integre com sensor de luminosidade.";
    }
}

