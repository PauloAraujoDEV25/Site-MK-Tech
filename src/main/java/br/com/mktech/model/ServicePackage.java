package br.com.mktech.model;

import lombok.Getter;
import java.util.List;

/**
 * Classe abstrata para pacotes de serviços
 * Princípio Open/Closed (OCP) - aberto para extensão, fechado para modificação
 */
@Getter
public abstract class ServicePackage {
    private String name;
    private String level;
    private double price;
    private List<Service> services;
    private String description;

    public ServicePackage(String name, String level, double price, List<Service> services, String description) {
        this.name = name;
        this.level = level;
        this.price = price;
        this.services = services;
        this.description = description;
    }

    public int getServiceCount() {
        return services.size();
    }

    public abstract String getBenefits();
}

