package br.com.mktech.controller;

import br.com.mktech.dto.ContactRequest;
import br.com.mktech.dto.ContactResponse;
import br.com.mktech.model.ServicePackage;
import br.com.mktech.service.IPackageService;
import br.com.mktech.service.IWhatsAppService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * API Controller para contato.
 * Responsável por processar requisições de contato via WhatsApp.
 *
 * Implementa validação de entrada, logging e tratamento de erros.
 * Segue padrões RESTful e SOLID principles.
 */
@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContactController {

    private final IWhatsAppService whatsAppService;
    private final IPackageService packageService;

    @Autowired
    public ContactController(IWhatsAppService whatsAppService, IPackageService packageService) {
        this.whatsAppService = whatsAppService;
        this.packageService = packageService;
    }

    /**
     * Processa requisição de contato via WhatsApp.
     *
     * @param request Dados do contato com validação
     * @return Resposta de sucesso ou erro
     */
    @PostMapping("/contact")
    public ResponseEntity<ContactResponse> sendContact(@Valid @RequestBody ContactRequest request) {
        try {
            log.info("Nova requisição de contato - Nome: {}, Telefone: {}",
                    sanitizeName(request.getName()),
                    maskPhone(request.getPhone()));

            // Validação adicional de segurança (sanitização)
            if (!isValidPhoneNumber(request.getPhone())) {
                log.warn("Telefone inválido: {}", maskPhone(request.getPhone()));
                return ResponseEntity.badRequest()
                        .body(new ContactResponse(false, "Telefone em formato inválido. Use: (XX) 9XXXX-XXXX"));
            }

            // Busca o pacote selecionado
            ServicePackage selectedPackage = packageService.getPackageByLevel(request.getPackageLevel());

            if (selectedPackage == null) {
                log.warn("Pacote solicitado não encontrado: {}", request.getPackageLevel());
                return ResponseEntity.badRequest()
                        .body(new ContactResponse(false, "Pacote selecionado não existe"));
            }

            // Envia mensagem via WhatsApp
            String result = whatsAppService.sendMessage(
                    request.getPhone(),
                    request.getName(),
                    selectedPackage.getName()
            );

            if (result != null && result.contains("sucesso")) {
                log.info("Mensagem enviada com sucesso para: {}", maskPhone(request.getPhone()));
                return ResponseEntity.ok(
                        new ContactResponse(true, "Mensagem enviada com sucesso! Entraremos em contato em breve.")
                );
            } else {
                log.error("Falha ao enviar mensagem para: {}", maskPhone(request.getPhone()));
                return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body(new ContactResponse(false, "Erro ao enviar mensagem. Tente novamente em alguns momentos."));
            }

        } catch (IllegalArgumentException e) {
            log.warn("Erro de validação: {}", e.getMessage());
            return ResponseEntity.badRequest()
                    .body(new ContactResponse(false, e.getMessage()));

        } catch (Exception e) {
            log.error("Erro não esperado ao processar contato", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ContactResponse(false, "Erro ao processar sua solicitação. Tente novamente mais tarde."));
        }
    }

    /**
     * Valida formato do telefone brasileiro.
     * Aceita: (XX) 9XXXX-XXXX ou (XX) XXXX-XXXX ou apenas números
     */
    private boolean isValidPhoneNumber(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return false;
        }
        // Remove caracteres especiais e espaços
        String cleaned = phone.replaceAll("[^0-9]", "");
        // Valida se tem entre 10 e 11 dígitos
        return cleaned.length() >= 10 && cleaned.length() <= 11;
    }

    /**
     * Sanitiza nome removendo caracteres perigosos.
     */
    private String sanitizeName(String name) {
        if (name == null) return "";
        return name.replaceAll("[<>\"'%;()&+]", "").trim();
    }

    /**
     * Mascara telefone para logging (segurança).
     */
    private String maskPhone(String phone) {
        if (phone == null || phone.length() < 4) {
            return "***";
        }
        return phone.substring(0, phone.length() - 4) + "****";
    }
}

