package br.com.mktech.model;

/**
 * Serviço de Controle de Temperatura
 * Climatização inteligente
 */
public class SmartTemperatureService extends Service {

    public SmartTemperatureService() {
        super(
            "Controle de Temperatura",
            "Climatização inteligente e econômica",
            "🌡️"
        );
    }

    @Override
    public String getDetails() {
        return "Controle ar-condicionado e aquecimento remotamente, " +
               "economize energia com programação inteligente.";
    }
}

