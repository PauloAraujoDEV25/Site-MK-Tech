package br.com.mktech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Interface que define um serviço de automação residencial
 * Princípio da Segregação de Interface (ISP)
 */
@Getter
@AllArgsConstructor
public abstract class Service {
    private String name;
    private String description;
    private String icon;

    public abstract String getDetails();
}

