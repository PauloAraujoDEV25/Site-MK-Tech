package br.com.mktech.model;

/**
 * Serviço de Lâmpadas Inteligentes
 * Controle completo de iluminação da sua casa
 */
public class SmartLightService extends Service {

    public SmartLightService() {
        super(
            "Lâmpadas Inteligentes",
            "Controle total da iluminação da sua casa pelo celular",
            "💡"
        );
    }

    @Override
    public String getDetails() {
        return "Controle a iluminação de todos os cômodos pelo celular, " +
               "programe horários, ajuste intensidade e cores.";
    }
}

