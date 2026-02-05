# 🎯 Guia Rápido - Landing Page MK Tech

## ✅ O que foi criado para você:

### 📁 Estrutura de Pastas
```
src/main/resources/
├── static/
│   ├── css/
│   │   └── style.css (Estilos completos)
│   └── js/
│       └── script.js (Funcionalidades JavaScript)
└── templates/
    └── index.html (Página HTML moderna)
```

---

## 🚀 Como Usar

### 1. **Visualizar a Landing Page**
- Abra seu navegador
- Acesse: `http://localhost:8080/`
- Você verá uma landing page profissional e moderna!

### 2. **Testar o Formulário**
- Clique em qualquer botão "Solicitar Orçamento"
- Preencha Nome e WhatsApp
- Clique em "Enviar e Receber Orçamento"
- O formulário será enviado para `POST /api/contact`

---

## 🎨 Personalizar a Landing Page

### **Mudar Cores**
Abra `static/css/style.css` e procure por `:root`:
```css
:root {
    --primary-color: #667eea;      /* Azul/Roxo */
    --secondary-color: #764ba2;    /* Roxo escuro */
    --accent-color: #25D366;       /* Verde WhatsApp */
}
```

### **Adicionar/Remover Seções**
No arquivo `templates/index.html`, cada seção é um `<section>` com um `id`:
- `#problemas` - Seção de problemas
- `#funcionalidades` - Serviços oferecidos
- `#pacotes` - Planos de preço
- `#cta` - Call-to-Action

### **Editar Conteúdo**
Basta editar o texto dentro de cada seção. O HTML está bem organizado com comentários!

### **Adicionar Novo Serviço**
Na seção de funcionalidades, copie um `.feature-card` e modifique:
```html
<div class="feature-card">
    <div class="service-icon">🆕</div>
    <h3>Novo Serviço</h3>
    <p>Descrição do novo serviço...</p>
</div>
```

### **Adicionar Novo Pacote**
Na seção de pacotes, copie um `.package-card` e modifique:
```html
<div class="package-card">
    <div class="package-header">
        <div class="package-icon">👑</div>
        <h3 class="package-name">Novo Pacote</h3>
        <p class="package-description">Descrição</p>
    </div>
    <!-- ... resto do card ... -->
</div>
```

---

## 🔧 Funcionalidades JavaScript

O arquivo `static/js/script.js` inclui:

### ✅ Modal de Contato
- Abre ao clicar em "Solicitar Orçamento"
- Fecha ao clicar em X, ESC ou fora do modal
- Salva o pacote selecionado automaticamente

### ✅ Validação de Formulário
Valida:
- Nome (mínimo 3 caracteres)
- Telefone (formato brasileiro com DDD)
- Pacote selecionado

### ✅ Máscara de Telefone
Formata automaticamente: `(XX) XXXXX-XXXX`

### ✅ Envio via Fetch API
```javascript
fetch('/api/contact', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(formData)
})
```

### ✅ Alertas de Sucesso/Erro
Mostra mensagens automáticas ao usuário

### ✅ Analytics Integrado
Rastreia eventos como:
- Abrir modal
- Submeter formulário
- Erros

---

## 🔌 Integração com Backend

### API Esperada
```
POST /api/contact
Content-Type: application/json

{
    "name": "João Silva",
    "phone": "(11) 99999-9999",
    "packageLevel": "GOLD"
}
```

### Response Esperada
```json
{
    "success": true,
    "message": "Mensagem enviada com sucesso!"
}
```

ou

```json
{
    "success": false,
    "message": "Erro ao enviar mensagem"
}
```

---

## 📱 Design Responsivo

A landing page é 100% responsiva:
- ✅ Desktop (1200px+) - 3 colunas
- ✅ Tablet (768px - 1199px) - 2 colunas
- ✅ Mobile (até 768px) - 1 coluna

Teste redimensionando a janela do navegador!

---

## 🎯 SEO Básico

Já incluído no `<head>` do HTML:
- ✅ Meta description
- ✅ Meta keywords
- ✅ Open Graph tags (para redes sociais)
- ✅ Favicon
- ✅ Title otimizado

---

## 🐛 Troubleshooting

### Botões não funcionam
Verifique se o arquivo `script.js` está sendo carregado:
```html
<script src="/js/script.js"></script>
```

### Estilos não aparecem
Verifique se o arquivo `style.css` está sendo carregado:
```html
<link rel="stylesheet" href="/css/style.css">
```

### Formulário não envia
1. Abra o Console do Navegador (F12)
2. Verifique se há erros
3. Confirme que a API em `/api/contact` está respondendo

### Modal não abre
Verifique o console para erros de JavaScript

---

## 💡 Dicas de Customização

### Adicionar Logo
Substitua o emoji na navbar:
```html
<div class="logo">🏠 MK Tech</div>
```
por:
```html
<div class="logo"><img src="/img/logo.png" alt="MK Tech"></div>
```

### Adicionar Vídeo
Após o hero section, adicione:
```html
<section class="video-section">
    <iframe width="100%" height="400" src="https://www.youtube.com/embed/SEU_VIDEO_ID"></iframe>
</section>
```

### Adicionar Depoimentos
Crie uma nova seção:
```html
<section class="testimonials-section">
    <div class="testimonial-card">
        <p>"Excelente serviço!"</p>
        <p>- Cliente Satisfeito</p>
    </div>
</section>
```

---

## 📊 Analytics

Para integrar com Google Analytics, adicione ao `<head>`:
```html
<!-- Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=GA_MEASUREMENT_ID"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'GA_MEASUREMENT_ID');
</script>
```

---

## 🎨 Customizações Avançadas

### Mudar Font
No `style.css`, procure por:
```css
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
```

Mude para sua font favorita de Google Fonts.

### Adicionar Animações
Use a sintaxe de animações no CSS:
```css
@keyframes minha-animacao {
    from { opacity: 0; }
    to { opacity: 1; }
}

.elemento {
    animation: minha-animacao 1s ease-out;
}
```

### Modo Dark
Adicione ao `style.css`:
```css
@media (prefers-color-scheme: dark) {
    body {
        background: #1a1a1a;
        color: #f0f0f0;
    }
    /* ... mais estilos ... */
}
```

---

## 📚 Arquivos Importantes

| Arquivo | Função |
|---------|--------|
| `index.html` | Estrutura HTML da página |
| `style.css` | Todos os estilos (CSS) |
| `script.js` | Lógica e interatividade (JS) |
| `ESTRUTURA_ARQUIVOS.md` | Documentação completa |
| `RESUMO_LANDING_PAGE.md` | Resumo visual |

---

## 🚀 Próximas Melhorias

1. **Integrar com WhatsApp Business API**
   - Enviar mensagens automáticas
   - Rastrear conversas

2. **Adicionar Banco de Dados**
   - Salvar leads
   - Analytics avançado

3. **Email Marketing**
   - Confirmação por email
   - Campanhas automáticas

4. **Testes**
   - Testes unitários
   - Testes E2E

5. **Performance**
   - Minificar CSS/JS
   - Otimizar imagens
   - Cache

---

## 🤝 Suporte

Qualquer dúvida:
1. Consulte os comentários nos arquivos
2. Verifique a documentação em `ESTRUTURA_ARQUIVOS.md`
3. Abra o Console (F12) para ver erros

---

**Criado em:** 2026-02-04  
**Versão:** 1.0  
**Status:** ✅ Pronto para usar!
