package br.com.mktech.config;

import br.com.mktech.dto.ContactResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Tratamento centralizado de exceções.
 *
 * Implementa:
 * - Respostas de erro padronizadas
 * - Logging estruturado
 * - Mensagens de erro seguras (sem expor detalhes internos)
 *
 * Segue padrões de Clean Architecture.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Trata erros de validação de RequestBody.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ContactResponse> handleValidationException(
            MethodArgumentNotValidException ex) {

        String errorMessage = "Erro de validação: "
                + ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(field -> field.getField() + " - " + field.getDefaultMessage())
                .reduce("", (a, b) -> a.isEmpty() ? b : a + "; " + b);

        log.warn("Erro de validação no corpo da requisição: {}", errorMessage);

        return ResponseEntity
                .badRequest()
                .body(new ContactResponse(false, "Dados inválidos na requisição. Verifique os campos."));
    }

    /**
     * Trata exceções genéricas não capturadas.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ContactResponse> handleGenericException(Exception ex) {
        log.error("Erro não tratado na aplicação", ex);

        // Não expõe detalhes da exceção ao cliente por segurança
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ContactResponse(
                        false,
                        "Erro ao processar sua requisição. Tente novamente mais tarde."
                ));
    }
}
