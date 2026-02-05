# 📋 Guia de Instalação e Execução - MK Tech

## ✅ Projeto Criado com Sucesso!

Seu site MK Tech foi completamente estruturado com:
- ✅ Arquitetura Maven
- ✅ Princípios SOLID implementados
- ✅ Orientação a Objetos completa
- ✅ Integração com WhatsApp API
- ✅ Interface web moderna e responsiva

## 📦 Estrutura Criada

### Backend (Java)
```
src/main/java/br/com/mktech/
├── MKTechApplication.java          # Aplicação Spring Boot principal
├── model/                          # Modelos de domínio
│   ├── Service.java               # Classe abstrata base (OCP)
│   ├── ServicePackage.java        # Classe abstrata de pacotes (OCP)
│   ├── SmartLightService.java     # Serviço de lâmpadas
│   ├── SmartLockService.java      # Serviço de trancas
│   ├── SmartCurtainService.java   # Serviço de cortinas
│   ├── SmartTemperatureService.java # Serviço de temperatura
│   ├── SmartCameraService.java    # Serviço de câmeras
│   ├── SilverPackage.java         # Pacote Prata
│   ├── GoldPackage.java           # Pacote Ouro
│   └── PlatinumPackage.java       # Pacote Platina
├── service/                        # Camada de negócio (SRP, DIP)
│   ├── IPackageService.java       # Interface de pacotes
│   ├── PackageService.java        # Implementação de pacotes
│   ├── IWhatsAppService.java      # Interface WhatsApp
│   └── WhatsAppService.java       # Implementação WhatsApp
├── controller/                     # Camada de apresentação
│   ├── HomeController.java        # Controller da página inicial
│   └── ContactController.java     # Controller de contato/API
└── dto/                           # Data Transfer Objects
    ├── ContactRequest.java
    └── ContactResponse.java
```

### Frontend
```
src/main/resources/
├── templates/
│   └── index.html                 # Landing page completa
└── application.properties          # Configurações
```

## 🎯 Princípios SOLID Implementados

### 1. Single Responsibility Principle (SRP)
- Cada classe tem UMA responsabilidade
- `PackageService` → Gerencia pacotes
- `WhatsAppService` → Integração WhatsApp
- `ContactController` → Processa contatos

### 2. Open/Closed Principle (OCP)
- Classes abstratas `Service` e `ServicePackage`
- Fácil adicionar novos serviços SEM modificar código existente
- Exemplo: criar `SmartGarageService extends Service`

### 3. Liskov Substitution Principle (LSP)
- Todos os `Service` podem substituir a classe base
- Todos os `ServicePackage` mantêm o contrato

### 4. Interface Segregation Principle (ISP)
- Interfaces específicas: `IPackageService`, `IWhatsAppService`
- Clientes não dependem de métodos que não usam

### 5. Dependency Inversion Principle (DIP)
- Controllers dependem de INTERFACES, não implementações
- Exemplo: `IWhatsAppService`, não `WhatsAppService`

## 🚀 Como Executar

### Opção 1: IntelliJ IDEA (Recomendado)
1. Abra o projeto no IntelliJ IDEA
2. Aguarde o Maven baixar as dependências automaticamente
3. Execute `MKTechApplication.java` (botão play verde)
4. Acesse: `http://localhost:8080`

### Opção 2: Maven Command Line
```bash
# Instale o Maven primeiro se necessário
# Windows: https://maven.apache.org/download.cgi

# Baixar dependências
mvn clean install -DskipTests

# Executar aplicação
mvn spring-boot:run
```

### Opção 3: JAR Executável
```bash
mvn clean package -DskipTests
java -jar target/Site-MK-Tech-1.0-SNAPSHOT.jar
```

## 📱 Configurar WhatsApp API

### Passo 1: Obter Credenciais
1. Acesse: https://developers.facebook.com/docs/whatsapp/cloud-api/get-started
2. Crie uma conta Business no Meta for Developers
3. Configure o WhatsApp Cloud API
4. Obtenha:
   - `Token de Acesso` (Access Token)
   - `Phone Number ID`

### Passo 2: Configurar Aplicação
Edite `src/main/resources/application.properties`:

```properties
whatsapp.api.token=EAAxxxxxxxxxxxxx  # Seu token
whatsapp.phone.id=1234567890         # Seu phone ID
```

## 🎨 Características do Site

### Destaque da Dor do Cliente
✅ Seção dedicada mostrando problemas resolvidos:
- Esqueceu a luz acesa → Desperdício de energia
- Perdeu as chaves → Insegurança
- Conta alta → Sem controle de temperatura
- Sem monitoramento → Preocupação constante

### Pacotes de Serviços

**🥈 Pacote Prata** (Básico)
- Lâmpadas Inteligentes
- Trancas Inteligentes
- **Valores negociados via WhatsApp**

**🥇 Pacote Ouro** (Intermediário)
- Prata + Temperatura + Câmeras
- **Valores negociados via WhatsApp**

**💎 Pacote Platina** (Premium)
- Todos os serviços (5 serviços)
- **Valores negociados via WhatsApp**

### Integração WhatsApp
- Formulário de contato no site
- Envio automático de mensagem personalizada
- **Negociação humanizada de valores**
- Resposta rápida da equipe

## 📊 Fluxo de Funcionamento

```
Cliente visita site
    ↓
Vê as dores sendo resolvidas
    ↓
Escolhe um pacote
    ↓
Clica em "Falar no WhatsApp"
    ↓
Preenche nome e telefone
    ↓
Sistema envia mensagem via WhatsApp API
    ↓
Equipe MK Tech negocia valores personalizados
    ↓
Cliente recebe atendimento humanizado
```

## 🔧 Dependências Utilizadas

```xml
- Spring Boot Web 3.2.1     → Framework web
- Spring Boot Thymeleaf     → Templates HTML
- OkHttp 4.12.0            → Cliente HTTP (WhatsApp)
- Gson 2.10.1              → JSON processing
- Lombok 1.18.30           → Reduzir boilerplate
```

## 📝 Próximos Passos

1. ✅ **Configurar WhatsApp API** (seguir instruções acima)
2. ✅ **Executar aplicação** (IntelliJ ou Maven)
3. ✅ **Testar integração** (preencher formulário)
4. 🔄 **Personalizar valores** (se quiser adicionar no futuro)
5. 🔄 **Deploy em produção** (Heroku, AWS, etc.)

## 💡 Dicas

- Os valores NÃO aparecem no site conforme solicitado
- Negociação personalizada via WhatsApp
- Foco na dor do cliente primeiro
- Design moderno e responsivo
- Código totalmente SOLID e POO

## 🆘 Precisa de Ajuda?

Se encontrar problemas:
1. Verifique se o Java 21+ está instalado
2. Verifique se as dependências foram baixadas
3. Configure corretamente as credenciais do WhatsApp
4. Verifique os logs da aplicação

---

**🎉 Seu site está pronto para transformar casas em lares inteligentes!**

