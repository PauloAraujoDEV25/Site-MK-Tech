package br.com.mktech.controller;

import br.com.mktech.dto.ContactRequest;
import br.com.mktech.dto.ContactResponse;
import br.com.mktech.model.ServicePackage;
import br.com.mktech.service.IPackageService;
import br.com.mktech.service.IWhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * API Controller para contato
 * Responsável por processar requisições de contato via WhatsApp
 */
@RestController
@RequestMapping("/api")
public class ContactController {

    private final IWhatsAppService whatsAppService;
    private final IPackageService packageService;

    @Autowired
    public ContactController(IWhatsAppService whatsAppService, IPackageService packageService) {
        this.whatsAppService = whatsAppService;
        this.packageService = packageService;
    }

    @PostMapping("/contact")
    public ResponseEntity<ContactResponse> sendContact(@RequestBody ContactRequest request) {
        try {
            // Valida os dados
            if (request.getName() == null || request.getName().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body(new ContactResponse(false, "Nome é obrigatório"));
            }

            if (request.getPhone() == null || request.getPhone().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body(new ContactResponse(false, "Telefone é obrigatório"));
            }

            // Busca o pacote selecionado
            ServicePackage selectedPackage = packageService.getPackageByLevel(request.getPackageLevel());

            if (selectedPackage == null) {
                return ResponseEntity.badRequest()
                    .body(new ContactResponse(false, "Pacote inválido"));
            }

            // Envia mensagem via WhatsApp
            String result = whatsAppService.sendMessage(
                request.getPhone(),
                request.getName(),
                selectedPackage.getName()
            );

            return ResponseEntity.ok(
                new ContactResponse(true, "Mensagem enviada com sucesso! Entraremos em contato em breve.")
            );

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body(new ContactResponse(false, "Erro ao processar solicitação: " + e.getMessage()));
        }
    }
}

