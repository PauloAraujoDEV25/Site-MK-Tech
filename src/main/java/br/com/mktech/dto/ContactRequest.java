package br.com.mktech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para requisição de contato
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    private String name;
    private String phone;
    private String packageLevel;
}

