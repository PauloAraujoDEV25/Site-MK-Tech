package br.com.mktech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO para resposta de contato
 */
@Data
@AllArgsConstructor
public class ContactResponse {
    private boolean success;
    private String message;
}

