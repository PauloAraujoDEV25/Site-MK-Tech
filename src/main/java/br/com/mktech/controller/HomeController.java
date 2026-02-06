package br.com.mktech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller principal do site
 * Responsável pela exibição da página inicial
 */
@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "<!DOCTYPE html>\n" +
            "<html lang=\"pt-BR\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>MK Tech - Automação Residencial Inteligente</title>\n" +
            "    <style>\n" +
            "        * { margin: 0; padding: 0; box-sizing: border-box; }\n" +
            "        body { font-family: 'Segoe UI', sans-serif; line-height: 1.6; color: #333; }\n" +
            "        nav { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 1rem 2rem; display: flex; justify-content: space-between; align-items: center; }\n" +
            "        .logo { font-size: 1.5rem; font-weight: bold; }\n" +
            "        .nav-links { display: flex; list-style: none; gap: 2rem; }\n" +
            "        .nav-links a { color: white; text-decoration: none; }\n" +
            "        .hero { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 100px 20px; text-align: center; }\n" +
            "        .hero h1 { font-size: 3rem; margin-bottom: 1rem; }\n" +
            "        .hero p { font-size: 1.2rem; margin-bottom: 2rem; }\n" +
            "        .btn { padding: 12px 30px; margin: 10px; border: none; border-radius: 5px; cursor: pointer; font-size: 1rem; }\n" +
            "        .btn-primary { background: #FFD700; color: #333; font-weight: bold; }\n" +
            "        .btn-secondary { background: transparent; color: white; border: 2px solid white; }\n" +
            "        .packages { padding: 80px 20px; background: #f5f5f5; }\n" +
            "        .packages h2 { text-align: center; margin-bottom: 3rem; font-size: 2.5rem; }\n" +
            "        .packages-grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(300px, 1fr)); gap: 30px; max-width: 1200px; margin: 0 auto; }\n" +
            "        .package-card { background: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); text-align: center; }\n" +
            "        .package-card h3 { color: #667eea; margin-bottom: 1rem; }\n" +
            "        .package-card .price { font-size: 2rem; color: #FFD700; margin: 1rem 0; font-weight: bold; }\n" +
            "        .package-card ul { list-style: none; margin: 1rem 0; text-align: left; }\n" +
            "        .package-card li { padding: 0.5rem 0; border-bottom: 1px solid #eee; }\n" +
            "        footer { background: #333; color: white; text-align: center; padding: 2rem; }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <nav>\n" +
            "        <div class=\"logo\">🏠 MK Tech</div>\n" +
            "        <ul class=\"nav-links\">\n" +
            "            <li><a href=\"#pacotes\">Pacotes</a></li>\n" +
            "        </ul>\n" +
            "    </nav>\n" +
            "\n" +
            "    <section class=\"hero\">\n" +
            "        <h1>🏠 Sua Casa Inteligente Começa Aqui</h1>\n" +
            "        <p>Automação residencial que traz segurança, economia e conforto para sua família</p>\n" +
            "        <button class=\"btn btn-primary\">Ver Pacotes</button>\n" +
            "        <button class=\"btn btn-secondary\">Saber Mais</button>\n" +
            "    </section>\n" +
            "\n" +
            "    <section id=\"pacotes\" class=\"packages\">\n" +
            "        <h2>📦 Nossos Pacotes</h2>\n" +
            "        <div class=\"packages-grid\">\n" +
            "            <div class=\"package-card\">\n" +
            "                <h3>💎 Prata</h3>\n" +
            "                <div class=\"price\">R$ 1.499,90</div>\n" +
            "                <p><strong>Básico</strong></p>\n" +
            "                <ul>\n" +
            "                    <li>✨ Iluminação Inteligente</li>\n" +
            "                    <li>🔐 Fechadura Inteligente</li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"package-card\">\n" +
            "                <h3>🥇 Ouro</h3>\n" +
            "                <div class=\"price\">R$ 2.999,90</div>\n" +
            "                <p><strong>Intermediário</strong></p>\n" +
            "                <ul>\n" +
            "                    <li>✨ Iluminação Inteligente</li>\n" +
            "                    <li>🔐 Fechadura Inteligente</li>\n" +
            "                    <li>🌡️ Controle de Temperatura</li>\n" +
            "                    <li>🎬 Cortinas Inteligentes</li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"package-card\">\n" +
            "                <h3>👑 Platina</h3>\n" +
            "                <div class=\"price\">R$ 4.999,90</div>\n" +
            "                <p><strong>Premium</strong></p>\n" +
            "                <ul>\n" +
            "                    <li>✨ Iluminação Inteligente</li>\n" +
            "                    <li>🔐 Fechadura Inteligente</li>\n" +
            "                    <li>🌡️ Controle de Temperatura</li>\n" +
            "                    <li>🎬 Cortinas Inteligentes</li>\n" +
            "                    <li>📹 Câmeras de Segurança</li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </section>\n" +
            "\n" +
            "    <footer>\n" +
            "        <p>&copy; 2026 MK Tech - Automação Residencial Inteligente</p>\n" +
            "        <p>Transforme sua casa em um lar inteligente! 🏠✨</p>\n" +
            "    </footer>\n" +
            "</body>\n" +
            "</html>";
    }
}

