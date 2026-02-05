package br.com.mktech.model;

/**
 * Serviço de Câmeras Inteligentes
 * Monitoramento e segurança
 */
public class SmartCameraService extends Service {

    public SmartCameraService() {
        super(
            "Câmeras Inteligentes",
            "Monitoramento 24h com detecção de movimento",
            "📹"
        );
    }

    @Override
    public String getDetails() {
        return "Visualize sua casa em tempo real, " +
               "receba alertas de movimento e grave automaticamente.";
    }
}

