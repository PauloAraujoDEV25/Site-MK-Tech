# 🏠 MK Tech - Automação Residencial Inteligente

Site de automação residencial que resolve a dor de clientes que desejam automatizar suas casas com tecnologia inteligente.

## 🎯 Problema Resolvido

O MK Tech resolve frustrações comuns do dia a dia:
- 😰 **Esqueceu a luz acesa?** - Controle remoto de iluminação
- 🔑 **Perdeu as chaves?** - Trancas inteligentes com controle via app
- 🌡️ **Conta de luz alta?** - Automação de temperatura com economia de energia
- 👀 **Sem monitoramento?** - Câmeras inteligentes 24h

## 📦 Pacotes Disponíveis

### 🥈 Pacote Prata (Básico)
- Lâmpadas Inteligentes
- Trancas Inteligentes

### 🥇 Pacote Ouro (Intermediário)
- Tudo do Prata +
- Controle de Temperatura
- Câmeras Inteligentes

### 💎 Pacote Platina (Premium)
- Tudo do Ouro +
- Cortinas Inteligentes
- **Automação Completa!**

## 🏗️ Arquitetura

O projeto segue os princípios **SOLID**:

- **S**ingle Responsibility Principle - Cada classe tem uma única responsabilidade
- **O**pen/Closed Principle - Aberto para extensão, fechado para modificação
- **L**iskov Substitution Principle - Abstrações podem ser substituídas
- **I**nterface Segregation Principle - Interfaces específicas
- **D**ependency Inversion Principle - Dependa de abstrações, não implementações

### Estrutura do Projeto

```
br.com.mktech
├── model              # Modelos de domínio
│   ├── Service        # Classe abstrata de serviços
│   ├── ServicePackage # Classe abstrata de pacotes
│   ├── SmartLightService
│   ├── SmartLockService
│   ├── SmartCurtainService
│   ├── SmartTemperatureService
│   ├── SmartCameraService
│   ├── SilverPackage
│   ├── GoldPackage
│   └── PlatinumPackage
├── service            # Camada de negócio
│   ├── IPackageService
│   ├── PackageService
│   ├── IWhatsAppService
│   └── WhatsAppService
├── controller         # Camada de apresentação
│   ├── HomeController
│   └── ContactController
└── dto                # Data Transfer Objects
    ├── ContactRequest
    └── ContactResponse
```

## 🚀 Como Executar

### Pré-requisitos
- Java 21+
- Maven 3.8+

### Configuração do WhatsApp

1. Obtenha suas credenciais da [WhatsApp Business API](https://developers.facebook.com/docs/whatsapp)
2. Edite o arquivo `src/main/resources/application.properties`:

```properties
whatsapp.api.token=SEU_TOKEN_AQUI
whatsapp.phone.id=SEU_PHONE_ID_AQUI
```

### Executar o Projeto

```bash
# Baixar dependências
mvn clean install

# Executar a aplicação
mvn spring-boot:run
```

Acesse: `http://localhost:8080`

## ▲ Deploy na Vercel (somente Landing Page)

Se a ideia por enquanto é **apenas a landing page de captação**, este repositório já inclui uma versão estática em `public/` para deploy direto na Vercel, **sem backend Java**.

- Entrada: `public/index.html`
- Assets: `public/static/*`

### Como publicar

1. Importe o repositório na Vercel
2. Em **Framework Preset**, escolha **Other**
3. Em **Build Command**, deixe vazio
4. Em **Output Directory**, use `public`

Pronto: a Vercel vai servir o HTML/CSS/JS e o formulário continuará abrindo o WhatsApp via `wa.me` (client-side).

## 💬 Integração WhatsApp

O sistema integra com a WhatsApp Business API para:
- Envio automático de mensagens personalizadas
- Contato humanizado com os clientes
- **Negociação de valores direto no WhatsApp**

**Importante:** Os valores dos pacotes são negociados diretamente via WhatsApp para melhor atendimento personalizado!

## 🛠️ Tecnologias Utilizadas

- **Spring Boot 3.2.1** - Framework web
- **Thymeleaf** - Template engine para HTML
- **OkHttp** - Client HTTP para WhatsApp API
- **Gson** - Processamento JSON
- **Lombok** - Redução de boilerplate
- **Maven** - Gerenciamento de dependências

## 📱 Funcionalidades

- ✅ Landing page responsiva
- ✅ Destaque das dores dos clientes
- ✅ Apresentação dos pacotes de serviços
- ✅ Modal de contato interativo
- ✅ Integração com WhatsApp API
- ✅ Validação de formulários
- ✅ Máscara de telefone automática
- ✅ Alertas de sucesso/erro

## 📄 Licença

Este projeto é propriedade da MK Tech © 2026

---

**Desenvolvido com ❤️ seguindo princípios SOLID e boas práticas de POO**

