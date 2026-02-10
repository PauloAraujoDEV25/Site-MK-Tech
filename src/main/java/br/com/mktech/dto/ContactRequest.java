package br.com.mktech.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para requisição de contato.
 *
 * Implementa validação de entrada com Bean Validation (Jakarta Validation).
 * Garante dados válidos antes de processar no controller.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String name;

    @NotBlank(message = "Telefone é obrigatório")
    @Size(min = 10, max = 15, message = "Telefone deve ter entre 10 e 15 caracteres")
    private String phone;

    @NotBlank(message = "Pacote é obrigatório")
    @Size(min = 3, max = 20, message = "Pacote inválido")
    private String packageLevel;
}


