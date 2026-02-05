# 🚀 Guia de Deploy no Railway

Este guia explica como fazer deploy da aplicação MK Tech no Railway.

## 📋 Pré-requisitos

1. **Conta Railway**: Crie uma conta em https://railway.app
2. **GitHub**: Envie seu código para um repositório GitHub
3. **Variáveis de Ambiente**: Tenha prontos seus tokens do WhatsApp API

## 🔧 Configuração do Repositório

### 1. Preparar o Git

```bash
cd c:\development\java\Site-MK-Tech\Site-MK-Tech

# Inicializar git (se não estiver)
git init

# Adicionar arquivos
git add .

# Commit inicial
git commit -m "Initial commit: Landing page with WhatsApp integration"

# Criar repositório no GitHub e fazer push
git remote add origin https://github.com/seu-usuario/Site-MK-Tech.git
git branch -M main
git push -u origin main
```

### 2. Estrutura de Deploy (Já Criada ✅)

A estrutura necessária para Railway já foi criada:

- ✅ **Procfile** - Define como iniciar a aplicação
- ✅ **Dockerfile** - Multi-stage build para otimizar tamanho
- ✅ **application-prod.properties** - Configurações de produção
- ✅ **railway.json** - Configuração específica do Railway
- ✅ **.gitignore** - Exclui arquivos desnecessários

## 🚀 Fazer Deploy

### Opção 1: Via Dashboard Railway (Recomendado)

1. Acesse https://railway.app
2. Faça login
3. Clique em **New Project**
4. Selecione **Deploy from GitHub**
5. Selecione seu repositório `Site-MK-Tech`
6. Railway detectará automaticamente como Java/Maven

### Opção 2: Via Railway CLI

```bash
# Instalar Railway CLI (se não tiver)
npm install -g @railway/cli

# Fazer login
railway login

# Iniciar projeto
railway init

# Fazer deploy
railway up
```

## 🔐 Configurar Variáveis de Ambiente

Após criar o projeto no Railway:

1. Acesse o dashboard do projeto
2. Vá para **Variables**
3. Adicione as variáveis:

```
WHATSAPP_API_URL=https://graph.facebook.com/v18.0
WHATSAPP_API_TOKEN=seu_token_aqui
WHATSAPP_PHONE_ID=seu_phone_id_aqui
SPRING_PROFILES_ACTIVE=prod
PORT=8080
```

## 📊 Monitoramento

### Ver Logs

```bash
railway logs
```

### Acessar a Aplicação

- URL será algo como: `https://seu-projeto-production.railway.app`
- Railway gera um domínio automático

### Logs no Dashboard

1. Acesse seu projeto no Railway
2. Clique em **Deployments**
3. Selecione o deploy mais recente
4. Visualize os logs

## 🔄 Fazer Atualizações

Sempre que fazer alterações:

```bash
git add .
git commit -m "Descrição da alteração"
git push origin main
```

Railway redeploya automaticamente a cada push para `main`.

## ⚠️ Troubleshooting

### Build falha com erro de Maven

**Problema**: Processo de build muito longo ou falha de memória

**Solução**: O Dockerfile usa multi-stage, que otimiza isso. Se ainda falhar:
- Verifique se pom.xml está correto
- Tente `mvn clean install` localmente primeiro

### Aplicação não inicia

**Problema**: Container inicia mas aplicação não sobe

**Solução**: Verifique os logs:
```bash
railway logs
```

Procure por erros de:
- WhatsApp API URL/Token inválidos
- Porta em conflito
- Template Thymeleaf não encontrado

### WhatsApp API retorna erro 401

**Problema**: Variáveis de ambiente não estão sendo lidas

**Solução**: Confirme que as variáveis foram definidas em **Variables** no dashboard

## 📝 Checklist de Deploy

- [ ] Código enviado para GitHub
- [ ] Repositório conectado ao Railway
- [ ] Variáveis de ambiente configuradas
- [ ] Deploy bem-sucedido (sem erros nos logs)
- [ ] Página inicial carregando em produção
- [ ] Modal de contato funcionando
- [ ] Mensagens de WhatsApp sendo enviadas

## 💰 Custo

- Railway oferece **US$5/mês de crédito gratuito**
- Aplicação típica de Spring Boot usa ~0,5-1 USD/mês
- Muito econômico para landing page e MVP

## 🎯 Próximos Passos

1. ✅ Estrutura criada
2. ⏳ Enviar para GitHub
3. ⏳ Conectar ao Railway
4. ⏳ Configurar variáveis
5. ⏳ Testar em produção

Sucesso! 🎉
