package br.com.mktech.service;

import br.com.mktech.model.ServicePackage;
import java.util.List;

/**
 * Interface para o serviço de pacotes
 * Princípio da Inversão de Dependência (DIP)
 */
public interface IPackageService {
    List<ServicePackage> getAllPackages();
    ServicePackage getPackageByLevel(String level);
}

