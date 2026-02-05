package br.com.mktech.service;

/**
 * Interface para integração com WhatsApp
 * Princípio da Inversão de Dependência (DIP)
 */
public interface IWhatsAppService {
    String sendMessage(String phoneNumber, String name, String packageName);
}

