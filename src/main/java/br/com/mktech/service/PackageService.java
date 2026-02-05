package br.com.mktech.service;

import br.com.mktech.model.*;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

/**
 * Implementação do serviço de pacotes
 * Princípio de Responsabilidade Única (SRP)
 */
@Service
public class PackageService implements IPackageService {

    private final List<ServicePackage> packages;

    public PackageService() {
        this.packages = Arrays.asList(
            new SilverPackage(),
            new GoldPackage(),
            new PlatinumPackage()
        );
    }

    @Override
    public List<ServicePackage> getAllPackages() {
        return packages;
    }

    @Override
    public ServicePackage getPackageByLevel(String level) {
        return packages.stream()
            .filter(p -> p.getLevel().equalsIgnoreCase(level))
            .findFirst()
            .orElse(null);
    }
}

