package br.com.mktech.model;

/**
 * Serviço de Trancas Inteligentes
 * Segurança e controle de acesso
 */
public class SmartLockService extends Service {

    public SmartLockService() {
        super(
            "Trancas Inteligentes",
            "Segurança total com controle de acesso inteligente",
            "🔒"
        );
    }

    @Override
    public String getDetails() {
        return "Tranque e destranque portas remotamente, " +
               "receba notificações de acesso e tenha histórico completo.";
    }
}

