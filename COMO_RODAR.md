# 🚀 Como Executar o Projeto MK Tech

## ⚠️ Importante!

O arquivo `index.html` é um **template Thymeleaf**, não um HTML estático. Isso significa que:

✅ **Deve ser acessado via Spring Boot**: `http://localhost:8080/`  
❌ **NÃO deve ser aberto como arquivo local**: `file:///...`

Quando você tenta abrir o arquivo `index.html` diretamente no navegador, o CSS e JavaScript não carregam porque:
- Os links usam `/css/style.css` (caminho relativo ao servidor)
- O navegador não consegue acessar esses recursos sem um servidor web

---

## ✅ Como Rodar Corretamente

### 1️⃣ **Via Maven**

Abra o terminal na pasta do projeto e execute:

```bash
cd "c:\development\java\Site-MK-Tech\Site-MK-Tech"
mvn spring-boot:run
```

Ou se preferir usar PowerShell:

```powershell
cd "c:\development\java\Site-MK-Tech\Site-MK-Tech"
.\mvnw.cmd spring-boot:run
```

### 2️⃣ **Aguarde o servidor iniciar**

Você verá mensagens como:
```
Started MKTechApplication in X seconds
Tomcat started on port(s): 8080
```

### 3️⃣ **Abra no navegador**

```
http://localhost:8080/
```

Pronto! Agora você verá a landing page com **CSS e JavaScript carregados corretamente**! ✨

---

## 🔍 Verificar se está Funcionando

### ✅ CSS carregou?
- Você vê cores, gradientes e espaçamento bonito
- A página é responsiva

### ✅ JavaScript funciona?
- Clique em "Solicitar Orçamento"
- O modal abre/fecha
- A máscara de telefone funciona
- Submeter formulário dispara a requisição

---

## 🛠️ Troubleshooting

### Erro: "Maven não encontrado"
**Solução:** 
- Instale Maven: https://maven.apache.org/download.cgi
- Ou use o Maven wrapper incluído no projeto:
```bash
mvnw spring-boot:run
```

### Porta 8080 já está em uso
**Solução:** 
Edite `application.properties`:
```properties
server.port=8081
```
E acesse: `http://localhost:8081/`

### CSS/JS ainda não carregam
**Solução:**
1. Abra o Console (F12)
2. Verifique os erros 404
3. Confirme que os arquivos existem em:
   - `src/main/resources/static/css/style.css` ✅
   - `src/main/resources/static/js/script.js` ✅

---

## 📊 Estrutura de Pastas Esperada

```
Site-MK-Tech/
├── src/main/
│   ├── java/
│   │   └── br/com/mktech/
│   │       ├── MKTechApplication.java
│   │       ├── controller/
│   │       ├── service/
│   │       ├── model/
│   │       └── dto/
│   │
│   └── resources/
│       ├── static/
│       │   ├── css/
│       │   │   └── style.css ✅
│       │   └── js/
│       │       └── script.js ✅
│       │
│       ├── templates/
│       │   └── index.html ✅
│       │
│       └── application.properties
│
├── pom.xml
└── ...

```

---

## 🎯 O que Cada Arquivo Faz

| Arquivo | Função | Localização |
|---------|--------|------------|
| `index.html` | Template HTML (Thymeleaf) | `src/main/resources/templates/` |
| `style.css` | Estilos CSS | `src/main/resources/static/css/` |
| `script.js` | Lógica JavaScript | `src/main/resources/static/js/` |
| `application.properties` | Config do Spring Boot | `src/main/resources/` |
| `pom.xml` | Dependências Maven | raiz do projeto |

---

## 💾 Arquivos Estáticos (Static)

Tudo dentro de `src/main/resources/static/` é servido automaticamente:

```
GET /css/style.css         → src/main/resources/static/css/style.css
GET /js/script.js          → src/main/resources/static/js/script.js
GET /img/logo.png          → src/main/resources/static/img/logo.png
```

---

## 🔗 URLs Disponíveis

Quando o servidor estiver rodando:

```
http://localhost:8080/              → Landing page completa
http://localhost:8080/css/style.css → Arquivo CSS
http://localhost:8080/js/script.js  → Arquivo JavaScript
http://localhost:8080/api/contact   → Endpoint da API (POST)
```

---

## 📝 Editar e Recarregar

1. **Edite qualquer arquivo** (HTML, CSS, JS)
2. **Salve o arquivo** (Ctrl + S)
3. **Recarregue o navegador** (F5 ou Ctrl + Shift + R para cache limpo)

Pronto! As mudanças aparecerão imediatamente.

---

## 🐛 Debug no Navegador

Pressione **F12** para abrir o DevTools:

### Console (Aba Console)
Veja erros de JavaScript aqui. Se vir algo como:
```
GET http://localhost:8080/css/style.css 404 (Not Found)
```
Significa que o CSS não foi encontrado.

### Network (Aba Network)
Veja todas as requisições HTTP:
- `style.css` deve retornar **200 OK** com o CSS
- `script.js` deve retornar **200 OK** com o JavaScript

### Elements (Aba Elements)
Inspect dos elementos HTML e veja quais estilos foram aplicados.

---

## ✅ Checklist Final

- [ ] Projeto Maven baixado e configurado
- [ ] `pom.xml` está na raiz do projeto
- [ ] Pasta `src/` existe com estrutura correta
- [ ] `style.css` está em `src/main/resources/static/css/`
- [ ] `script.js` está em `src/main/resources/static/js/`
- [ ] `index.html` está em `src/main/resources/templates/`
- [ ] Maven instalado ou usando `mvnw`
- [ ] Executou `mvn spring-boot:run`
- [ ] Abriu `http://localhost:8080/` no navegador
- [ ] Vê a landing page com estilos e funcionalidades

---

## 🎉 Pronto!

Se tudo deu certo, você terá uma **landing page profissional e funcional**! 

**Próximos passos:**
1. Personalize as cores, textos e imagens
2. Configure a integração com WhatsApp Business API
3. Implante em um servidor

---

**Dúvidas?** Consulte a documentação em:
- `GUIA_RAPIDO.md` - Instruções rápidas de customização
- `ESTRUTURA_ARQUIVOS.md` - Documentação detalhada
- `RESUMO_LANDING_PAGE.md` - Visão geral do projeto
