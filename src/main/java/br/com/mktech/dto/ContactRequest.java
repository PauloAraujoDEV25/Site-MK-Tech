package br.com.mktech.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(
            regexp = "^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$|^\\d{10,11}$",
            message = "Telefone deve estar no formato (XX) 9XXXX-XXXX ou apenas números"
    )
    private String phone;

    @NotBlank(message = "Pacote é obrigatório")
    @Pattern(
            regexp = "^(SILVER|GOLD|PLATINUM|Prata|Ouro|Platina)$",
            message = "Pacote inválido. Escolha entre: Prata, Ouro ou Platina"
    )
    private String packageLevel;
}


