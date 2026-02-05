package br.com.mktech.service;

import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementação do serviço WhatsApp Business API
 * Princípio de Responsabilidade Única (SRP)
 */
@Service
public class WhatsAppService implements IWhatsAppService {

    @Value("${whatsapp.api.url:https://graph.facebook.com/v18.0}")
    private String apiUrl;

    @Value("${whatsapp.api.token:YOUR_TOKEN_HERE}")
    private String apiToken;

    @Value("${whatsapp.phone.id:YOUR_PHONE_ID}")
    private String phoneId;

    private final OkHttpClient client;
    private final Gson gson;

    public WhatsAppService() {
        this.client = new OkHttpClient();
        this.gson = new Gson();
    }

    @Override
    public String sendMessage(String phoneNumber, String name, String packageName) {
        try {
            String message = buildMessage(name, packageName);
            return sendWhatsAppMessage(phoneNumber, message);
        } catch (IOException e) {
            return "Erro ao enviar mensagem: " + e.getMessage();
        }
    }

    private String buildMessage(String name, String packageName) {
        return String.format(
            "Olá %s! 🏠✨\n\n" +
            "Obrigado pelo interesse na MK Tech!\n\n" +
            "Você selecionou o *%s*.\n\n" +
            "Nossa equipe está pronta para transformar sua casa em um lar inteligente! " +
            "Vamos conversar sobre valores e como podemos atender suas necessidades de forma personalizada?\n\n" +
            "Estamos à disposição para negociar e tirar todas as suas dúvidas! 😊",
            name, packageName
        );
    }

    private String sendWhatsAppMessage(String phoneNumber, String message) throws IOException {
        // Remove caracteres não numéricos do telefone
        String cleanPhone = phoneNumber.replaceAll("[^0-9]", "");

        // Monta o payload
        Map<String, Object> payload = new HashMap<>();
        payload.put("messaging_product", "whatsapp");
        payload.put("to", cleanPhone);
        payload.put("type", "text");

        Map<String, String> text = new HashMap<>();
        text.put("body", message);
        payload.put("text", text);

        String jsonPayload = gson.toJson(payload);

        RequestBody body = RequestBody.create(
            jsonPayload,
            MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
            .url(apiUrl + "/" + phoneId + "/messages")
            .addHeader("Authorization", "Bearer " + apiToken)
            .addHeader("Content-Type", "application/json")
            .post(body)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return "Mensagem enviada com sucesso!";
            } else {
                return "Erro ao enviar mensagem: " + response.code();
            }
        }
    }
}

