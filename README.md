# MKTech - Automacao Residencial

Landing page institucional da MKTech, com uma versao estatica para a Vercel e
uma versao integrada ao projeto Java/Spring Boot.

## Estrutura

```text
public/
|-- index.html
`-- assets/
    |-- css/
    |   |-- reset.css
    |   |-- variables.css
    |   |-- base.css
    |   |-- layout.css
    |   |-- components.css
    |   `-- responsive.css
    |-- js/
    |   |-- main.js
    |   |-- modal.js
    |   |-- form.js
    |   `-- whatsapp.js
    `-- images/

src/main/
|-- java/br/com/mktech/       # Aplicacao Spring Boot
`-- resources/
    |-- templates/landing.html
    `-- static/assets/         # Assets usados pela versao Spring
```

### Responsabilidades dos arquivos

- `reset.css`: normalizacao basica dos elementos.
- `variables.css`: cores, gradientes, espacamentos e temas claro/escuro.
- `base.css`: tipografia, animacoes globais e estilos base.
- `layout.css`: estrutura da navegacao, hero e secoes.
- `components.css`: botoes, cards, formulario, carrosseis e demais componentes.
- `responsive.css`: ajustes para celular, tablet e desktop.
- `main.js`: tema, menu, navegacao, FAQ, animacoes e carrosseis.
- `modal.js`: comportamento reutilizavel para modais.
- `form.js`: validacao e eventos do formulario de contato.
- `whatsapp.js`: URL do WhatsApp e mascara reutilizavel de telefone.

## Deploy estatico na Vercel

O deploy estatico usa diretamente a pasta `public`.

1. Importe o repositorio na Vercel.
2. Selecione **Other** em Framework Preset.
3. Deixe o Build Command vazio.
4. Defina **Output Directory** como `public`.

O arquivo `vercel.json` mantem o fallback de rotas para `public/index.html`.

## Execucao local da landing page

Sirva a pasta `public` com qualquer servidor HTTP estatico. Exemplo:

```bash
npx serve public
```

Depois, acesse o endereco exibido no terminal.

## Execucao com Spring Boot

Pre-requisitos:

- Java 21 ou compativel com o projeto
- Maven 3.8+

```bash
mvn clean install
mvn spring-boot:run
```

A aplicacao fica disponivel em `http://localhost:8080`.

Os arquivos em `src/main/resources/static/assets` espelham os assets da landing
estatica para preservar a versao Spring Boot.

## Contato pelo WhatsApp

O formulario valida os campos no navegador e abre uma conversa no WhatsApp com
a mensagem preenchida. Nenhum framework JavaScript e necessario.
