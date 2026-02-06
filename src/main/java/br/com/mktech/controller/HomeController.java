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
            "        :root {\n" +
            "            --primary: #5017e2;\n" +
            "            --primary-dark: #592093;\n" +
            "            --accent: #f3d00a;\n" +
            "            --accent-dark: #FFC700;\n" +
            "            --dark-bg: #0f172a;\n" +
            "            --light-bg: #ffffff;\n" +
            "            --text-dark: #1a1a1ae2;\n" +
            "            --text-light: #ffffff;\n" +
            "            --border-radius: 12px;\n" +
            "            --shadow: 0 10px 30px rgba(0, 0, 0, 0.1);\n" +
            "            --shadow-lg: 0 20px 40px rgba(0, 0, 0, 0.2);\n" +
            "            --transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);\n" +
            "        }\n" +
            "\n" +
            "        * {\n" +
            "            margin: 0;\n" +
            "            padding: 0;\n" +
            "            box-sizing: border-box;\n" +
            "        }\n" +
            "\n" +
            "        html {\n" +
            "            scroll-behavior: smooth;\n" +
            "        }\n" +
            "\n" +
            "        body {\n" +
            "            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, sans-serif;\n" +
            "            line-height: 1.6;\n" +
            "            color: var(--text-dark);\n" +
            "            overflow-x: hidden;\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== NAVIGATION ==================== */\n" +
            "        nav {\n" +
            "            position: sticky;\n" +
            "            top: 0;\n" +
            "            z-index: 1000;\n" +
            "            background: linear-gradient(135deg, var(--primary) 0%, var(--primary-dark) 100%);\n" +
            "            color: var(--text-light);\n" +
            "            padding: 1rem 2rem;\n" +
            "            display: flex;\n" +
            "            justify-content: space-between;\n" +
            "            align-items: center;\n" +
            "            box-shadow: var(--shadow);\n" +
            "            backdrop-filter: blur(10px);\n" +
            "            animation: slideDown 0.5s ease-out;\n" +
            "        }\n" +
            "\n" +
            "        @keyframes slideDown {\n" +
            "            from {\n" +
            "                opacity: 0;\n" +
            "                transform: translateY(-20px);\n" +
            "            }\n" +
            "            to {\n" +
            "                opacity: 1;\n" +
            "                transform: translateY(0);\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .logo {\n" +
            "            font-size: 1.8rem;\n" +
            "            font-weight: 800;\n" +
            "            letter-spacing: -1px;\n" +
            "            display: flex;\n" +
            "            align-items: center;\n" +
            "            gap: 0.5rem;\n" +
            "        }\n" +
            "\n" +
            "        .nav-links {\n" +
            "            display: flex;\n" +
            "            list-style: none;\n" +
            "            gap: 2.5rem;\n" +
            "        }\n" +
            "\n" +
            "        .nav-links a {\n" +
            "            color: var(--text-light);\n" +
            "            text-decoration: none;\n" +
            "            font-weight: 600;\n" +
            "            position: relative;\n" +
            "            transition: var(--transition);\n" +
            "            font-size: 0.95rem;\n" +
            "        }\n" +
            "\n" +
            "        .nav-links a::after {\n" +
            "            content: '';\n" +
            "            position: absolute;\n" +
            "            bottom: -5px;\n" +
            "            left: 0;\n" +
            "            width: 0;\n" +
            "            height: 2px;\n" +
            "            background: var(--accent);\n" +
            "            transition: var(--transition);\n" +
            "        }\n" +
            "\n" +
            "        .nav-links a:hover::after {\n" +
            "            width: 100%;\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== HERO SECTION ==================== */\n" +
            "        .hero {\n" +
            "            background: linear-gradient(135deg, var(--primary) 0%, var(--primary-dark) 100%);\n" +
            "            color: var(--text-light);\n" +
            "            padding: 120px 2rem;\n" +
            "            text-align: center;\n" +
            "            position: relative;\n" +
            "            overflow: hidden;\n" +
            "            min-height: 100vh;\n" +
            "            display: flex;\n" +
            "            flex-direction: column;\n" +
            "            justify-content: center;\n" +
            "            align-items: center;\n" +
            "        }\n" +
            "\n" +
            "        .hero::before {\n" +
            "            content: '';\n" +
            "            position: absolute;\n" +
            "            width: 600px;\n" +
            "            height: 600px;\n" +
            "            background: rgba(255, 215, 0, 0.1);\n" +
            "            border-radius: 50%;\n" +
            "            top: -200px;\n" +
            "            right: -200px;\n" +
            "            animation: float 6s ease-in-out infinite;\n" +
            "        }\n" +
            "\n" +
            "        .hero::after {\n" +
            "            content: '';\n" +
            "            position: absolute;\n" +
            "            width: 400px;\n" +
            "            height: 400px;\n" +
            "            background: rgba(255, 215, 0, 0.05);\n" +
            "            border-radius: 50%;\n" +
            "            bottom: -150px;\n" +
            "            left: -150px;\n" +
            "            animation: float 8s ease-in-out infinite reverse;\n" +
            "        }\n" +
            "\n" +
            "        @keyframes float {\n" +
            "            0%, 100% { transform: translateY(0px); }\n" +
            "            50% { transform: translateY(-20px); }\n" +
            "        }\n" +
            "\n" +
            "        .hero-content {\n" +
            "            position: relative;\n" +
            "            z-index: 1;\n" +
            "            max-width: 800px;\n" +
            "            animation: fadeInUp 0.8s ease-out 0.2s both;\n" +
            "        }\n" +
            "\n" +
            "        @keyframes fadeInUp {\n" +
            "            from {\n" +
            "                opacity: 0;\n" +
            "                transform: translateY(30px);\n" +
            "            }\n" +
            "            to {\n" +
            "                opacity: 1;\n" +
            "                transform: translateY(0);\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .hero h1 {\n" +
            "            font-size: clamp(2rem, 5vw, 4rem);\n" +
            "            margin-bottom: 1.5rem;\n" +
            "            font-weight: 900;\n" +
            "            line-height: 1.1;\n" +
            "            letter-spacing: -2px;\n" +
            "        }\n" +
            "\n" +
            "        .hero .subtitle {\n" +
            "            font-size: clamp(1rem, 2vw, 1.3rem);\n" +
            "            margin-bottom: 2.5rem;\n" +
            "            opacity: 0.95;\n" +
            "            line-height: 1.6;\n" +
            "            font-weight: 300;\n" +
            "        }\n" +
            "\n" +
            "        .cta-buttons {\n" +
            "            display: flex;\n" +
            "            gap: 1.5rem;\n" +
            "            justify-content: center;\n" +
            "            flex-wrap: wrap;\n" +
            "        }\n" +
            "\n" +
            "        .btn {\n" +
            "            padding: 14px 40px;\n" +
            "            border: none;\n" +
            "            border-radius: var(--border-radius);\n" +
            "            cursor: pointer;\n" +
            "            font-size: 1rem;\n" +
            "            font-weight: 700;\n" +
            "            transition: var(--transition);\n" +
            "            position: relative;\n" +
            "            overflow: hidden;\n" +
            "            text-transform: uppercase;\n" +
            "            letter-spacing: 0.5px;\n" +
            "        }\n" +
            "\n" +
            "        .btn::before {\n" +
            "            content: '';\n" +
            "            position: absolute;\n" +
            "            top: 50%;\n" +
            "            left: 50%;\n" +
            "            width: 0;\n" +
            "            height: 0;\n" +
            "            border-radius: 50%;\n" +
            "            background: rgba(255, 255, 255, 0.3);\n" +
            "            transform: translate(-50%, -50%);\n" +
            "            transition: width 0.6s, height 0.6s;\n" +
            "        }\n" +
            "\n" +
            "        .btn:hover::before {\n" +
            "            width: 300px;\n" +
            "            height: 300px;\n" +
            "        }\n" +
            "\n" +
            "        .btn-primary {\n" +
            "            background: var(--accent);\n" +
            "            color: var(--text-dark);\n" +
            "            box-shadow: 0 8px 25px rgba(255, 215, 0, 0.3);\n" +
            "        }\n" +
            "\n" +
            "        .btn-primary:hover {\n" +
            "            background: var(--accent-dark);\n" +
            "            transform: translateY(-3px);\n" +
            "            box-shadow: 0 12px 35px rgba(255, 215, 0, 0.4);\n" +
            "        }\n" +
            "\n" +
            "        .btn-secondary {\n" +
            "            background: transparent;\n" +
            "            color: var(--text-light);\n" +
            "            border: 2px solid var(--accent);\n" +
            "        }\n" +
            "\n" +
            "        .btn-secondary:hover {\n" +
            "            background: var(--accent);\n" +
            "            color: var(--text-dark);\n" +
            "            transform: translateY(-3px);\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== PACKAGES SECTION ==================== */\n" +
            "        .packages {\n" +
            "            padding: 100px 2rem;\n" +
            "            background: var(--light-bg);\n" +
            "        }\n" +
            "\n" +
            "        .packages-alt {\n" +
            "            background: var(--dark-bg);\n" +
            "            color: var(--text-light);\n" +
            "        }\n" +
            "\n" +
            "        .section-title {\n" +
            "            text-align: center;\n" +
            "            margin-bottom: 4rem;\n" +
            "            position: relative;\n" +
            "        }\n" +
            "\n" +
            "        .section-title h2 {\n" +
            "            font-size: clamp(2rem, 4vw, 3.5rem);\n" +
            "            margin-bottom: 1rem;\n" +
            "            font-weight: 900;\n" +
            "        }\n" +
            "\n" +
            "        .packages h2 {\n" +
            "            color: var(--text-dark);\n" +
            "        }\n" +
            "\n" +
            "        .packages-alt h2 {\n" +
            "            color: var(--text-light);\n" +
            "        }\n" +
            "\n" +
            "        .section-subtitle {\n" +
            "            font-size: 1.1rem;\n" +
            "            opacity: 0.7;\n" +
            "            margin-bottom: 0.5rem;\n" +
            "        }\n" +
            "\n" +
            "        .section-title::after {\n" +
            "            content: '';\n" +
            "            position: absolute;\n" +
            "            bottom: -20px;\n" +
            "            left: 50%;\n" +
            "            transform: translateX(-50%);\n" +
            "            width: 60px;\n" +
            "            height: 4px;\n" +
            "            background: linear-gradient(90deg, var(--primary) 0%, var(--primary-dark) 100%);\n" +
            "            border-radius: 2px;\n" +
            "        }\n" +
            "\n" +
            "        .packages-grid {\n" +
            "            display: grid;\n" +
            "            grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));\n" +
            "            gap: 2rem;\n" +
            "            max-width: 1400px;\n" +
            "            margin: 0 auto;\n" +
            "        }\n" +
            "\n" +
            "        .package-card {\n" +
            "            background: white;\n" +
            "            padding: 2.5rem;\n" +
            "            border-radius: var(--border-radius);\n" +
            "            box-shadow: var(--shadow);\n" +
            "            text-align: center;\n" +
            "            transition: var(--transition);\n" +
            "            position: relative;\n" +
            "            overflow: hidden;\n" +
            "            cursor: pointer;\n" +
            "        }\n" +
            "\n" +
            "        .packages-alt .package-card {\n" +
            "            background: rgba(255, 255, 255, 0.05);\n" +
            "            border: 1px solid rgba(255, 255, 255, 0.1);\n" +
            "            color: var(--text-light);\n" +
            "        }\n" +
            "\n" +
            "        .package-card::before {\n" +
            "            content: '';\n" +
            "            position: absolute;\n" +
            "            top: 0;\n" +
            "            left: 0;\n" +
            "            right: 0;\n" +
            "            height: 4px;\n" +
            "            background: linear-gradient(90deg, var(--primary) 0%, var(--primary-dark) 100%);\n" +
            "            transform: scaleX(0);\n" +
            "            transform-origin: left;\n" +
            "            transition: transform 0.6s cubic-bezier(0.4, 0, 0.2, 1);\n" +
            "        }\n" +
            "\n" +
            "        .package-card:hover::before {\n" +
            "            transform: scaleX(1);\n" +
            "        }\n" +
            "\n" +
            "        .package-card:hover {\n" +
            "            transform: translateY(-10px);\n" +
            "            box-shadow: var(--shadow-lg);\n" +
            "        }\n" +
            "\n" +
            "        .package-icon {\n" +
            "            font-size: 3rem;\n" +
            "            margin-bottom: 1rem;\n" +
            "            animation: pulse 2s ease-in-out infinite;\n" +
            "        }\n" +
            "\n" +
            "        @keyframes pulse {\n" +
            "            0%, 100% { transform: scale(1); }\n" +
            "            50% { transform: scale(1.1); }\n" +
            "        }\n" +
            "\n" +
            "        .package-card h3 {\n" +
            "            color: var(--primary);\n" +
            "            font-size: 1.8rem;\n" +
            "            margin-bottom: 0.5rem;\n" +
            "            font-weight: 800;\n" +
            "        }\n" +
            "\n" +
            "        .packages-alt .package-card h3 {\n" +
            "            color: var(--accent);\n" +
            "        }\n" +
            "\n" +
            "        .package-level {\n" +
            "            font-size: 0.9rem;\n" +
            "            opacity: 0.7;\n" +
            "            margin-bottom: 1rem;\n" +
            "            text-transform: uppercase;\n" +
            "            letter-spacing: 1px;\n" +
            "            font-weight: 600;\n" +
            "        }\n" +
            "\n" +
            "        .package-card .price {\n" +
            "            font-size: 2.5rem;\n" +
            "            color: var(--accent);\n" +
            "            margin: 1rem 0;\n" +
            "            font-weight: 900;\n" +
            "        }\n" +
            "\n" +
            "        .package-card ul {\n" +
            "            list-style: none;\n" +
            "            margin: 2rem 0;\n" +
            "            text-align: left;\n" +
            "        }\n" +
            "\n" +
            "        .package-card li {\n" +
            "            padding: 0.8rem 0;\n" +
            "            border-bottom: 1px solid rgba(0, 0, 0, 0.1);\n" +
            "            font-size: 0.95rem;\n" +
            "        }\n" +
            "\n" +
            "        .packages-alt .package-card li {\n" +
            "            border-bottom-color: rgba(255, 255, 255, 0.1);\n" +
            "        }\n" +
            "\n" +
            "        .package-card li:last-child {\n" +
            "            border-bottom: none;\n" +
            "        }\n" +
            "\n" +
            "        .btn-cta {\n" +
            "            margin-top: 1.5rem;\n" +
            "            width: 100%;\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== QUICK MENU SECTION ==================== */\n" +
            "        .quick-menu {\n" +
            "            padding: 100px 2rem;\n" +
            "            background: linear-gradient(135deg, #f5f5f5 0%, #e8e8f5 100%);\n" +
            "        }\n" +
            "\n" +
            "        .menu-cards {\n" +
            "            display: grid;\n" +
            "            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));\n" +
            "            gap: 2rem;\n" +
            "            max-width: 1200px;\n" +
            "            margin: 0 auto;\n" +
            "            margin-top: 3rem;\n" +
            "        }\n" +
            "\n" +
            "        .menu-card {\n" +
            "            background: white;\n" +
            "            padding: 2.5rem 2rem;\n" +
            "            border-radius: var(--border-radius);\n" +
            "            box-shadow: var(--shadow);\n" +
            "            text-align: center;\n" +
            "            cursor: pointer;\n" +
            "            transition: var(--transition);\n" +
            "            border: 2px solid transparent;\n" +
            "        }\n" +
            "\n" +
            "        .menu-card:hover {\n" +
            "            border-color: var(--primary);\n" +
            "            transform: translateY(-8px);\n" +
            "            box-shadow: var(--shadow-lg);\n" +
            "        }\n" +
            "\n" +
            "        .menu-icon {\n" +
            "            font-size: 3.5rem;\n" +
            "            margin-bottom: 1rem;\n" +
            "            display: inline-block;\n" +
            "            animation: pulse 2s ease-in-out infinite;\n" +
            "        }\n" +
            "\n" +
            "        .menu-card h4 {\n" +
            "            color: var(--primary);\n" +
            "            font-size: 1.4rem;\n" +
            "            margin-bottom: 0.5rem;\n" +
            "            font-weight: 800;\n" +
            "        }\n" +
            "\n" +
            "        .menu-card p {\n" +
            "            color: #666;\n" +
            "            margin-bottom: 1.5rem;\n" +
            "            font-size: 0.95rem;\n" +
            "        }\n" +
            "\n" +
            "        .menu-label {\n" +
            "            display: inline-block;\n" +
            "            background: linear-gradient(135deg, var(--primary) 0%, var(--primary-dark) 100%);\n" +
            "            color: white;\n" +
            "            padding: 0.8rem 1.5rem;\n" +
            "            border-radius: 20px;\n" +
            "            font-weight: 700;\n" +
            "            font-size: 0.9rem;\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== AUTOMATION MODES SECTION ==================== */\n" +
            "        .automation-modes {\n" +
            "            padding: 100px 2rem;\n" +
            "            background: var(--dark-bg);\n" +
            "            color: var(--text-light);\n" +
            "        }\n" +
            "\n" +
            "        .modes-grid {\n" +
            "            display: grid;\n" +
            "            grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));\n" +
            "            gap: 2.5rem;\n" +
            "            max-width: 1400px;\n" +
            "            margin: 0 auto;\n" +
            "            margin-top: 3rem;\n" +
            "        }\n" +
            "\n" +
            "        .mode-card {\n" +
            "            background: rgba(255, 255, 255, 0.05);\n" +
            "            border: 2px solid rgba(255, 215, 0, 0.2);\n" +
            "            padding: 2.5rem;\n" +
            "            border-radius: var(--border-radius);\n" +
            "            transition: var(--transition);\n" +
            "            position: relative;\n" +
            "            overflow: hidden;\n" +
            "        }\n" +
            "\n" +
            "        .mode-card::before {\n" +
            "            content: '';\n" +
            "            position: absolute;\n" +
            "            top: 0;\n" +
            "            left: -100%;\n" +
            "            width: 100%;\n" +
            "            height: 100%;\n" +
            "            background: linear-gradient(90deg, transparent, rgba(255, 215, 0, 0.1), transparent);\n" +
            "            transition: left 0.6s ease;\n" +
            "        }\n" +
            "\n" +
            "        .mode-card:hover::before {\n" +
            "            left: 100%;\n" +
            "        }\n" +
            "\n" +
            "        .mode-card:hover {\n" +
            "            border-color: var(--accent);\n" +
            "            background: rgba(255, 215, 0, 0.08);\n" +
            "            transform: translateY(-8px);\n" +
            "        }\n" +
            "\n" +
            "        .wifi-mode {\n" +
            "            border-color: rgba(102, 126, 234, 0.5);\n" +
            "            background: rgba(102, 126, 234, 0.1);\n" +
            "        }\n" +
            "\n" +
            "        .wifi-mode:hover {\n" +
            "            border-color: var(--primary);\n" +
            "            background: rgba(102, 126, 234, 0.15);\n" +
            "        }\n" +
            "\n" +
            "        .hybrid-mode {\n" +
            "            border-width: 3px;\n" +
            "            border-image: linear-gradient(135deg, var(--primary), var(--accent)) 1;\n" +
            "            background: rgba(255, 215, 0, 0.15);\n" +
            "            transform: scale(1.02);\n" +
            "        }\n" +
            "\n" +
            "        .hybrid-mode:hover {\n" +
            "            transform: scale(1.07) translateY(-8px);\n" +
            "        }\n" +
            "\n" +
            "        .mode-icon {\n" +
            "            font-size: 3rem;\n" +
            "            margin-bottom: 1rem;\n" +
            "            display: block;\n" +
            "            animation: float 3s ease-in-out infinite;\n" +
            "        }\n" +
            "\n" +
            "        .mode-card h3 {\n" +
            "            color: var(--accent);\n" +
            "            font-size: 1.7rem;\n" +
            "            margin-bottom: 0.5rem;\n" +
            "            font-weight: 800;\n" +
            "        }\n" +
            "\n" +
            "        .mode-label {\n" +
            "            display: block;\n" +
            "            font-size: 0.9rem;\n" +
            "            opacity: 0.8;\n" +
            "            margin-bottom: 1.5rem;\n" +
            "            font-weight: 600;\n" +
            "            text-transform: uppercase;\n" +
            "            letter-spacing: 0.5px;\n" +
            "        }\n" +
            "\n" +
            "        .mode-benefits {\n" +
            "            margin: 1.5rem 0;\n" +
            "        }\n" +
            "\n" +
            "        .mode-benefits ul {\n" +
            "            list-style: none;\n" +
            "            text-align: left;\n" +
            "        }\n" +
            "\n" +
            "        .mode-benefits li {\n" +
            "            padding: 0.7rem 0;\n" +
            "            font-size: 0.95rem;\n" +
            "            opacity: 0.9;\n" +
            "            border-bottom: 1px solid rgba(255, 255, 255, 0.1);\n" +
            "        }\n" +
            "\n" +
            "        .mode-benefits li:last-child {\n" +
            "            border-bottom: none;\n" +
            "        }\n" +
            "\n" +
            "        .mode-note {\n" +
            "            margin-top: 1.5rem;\n" +
            "            padding: 1rem;\n" +
            "            background: rgba(255, 215, 0, 0.1);\n" +
            "            border-left: 4px solid var(--accent);\n" +
            "            border-radius: 4px;\n" +
            "            font-size: 0.9rem;\n" +
            "            opacity: 0.95;\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== RESPONSIVE MODES ==================== */\n" +
            "        @media (max-width: 1024px) {\n" +
            "            .hybrid-mode {\n" +
            "                transform: scale(1);\n" +
            "            }\n" +
            "\n" +
            "            .hybrid-mode:hover {\n" +
            "                transform: scale(1.02) translateY(-8px);\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== FEATURES SECTION ==================== */\n" +
            "        .features {\n" +
            "            padding: 100px 2rem;\n" +
            "            background: var(--dark-bg);\n" +
            "            color: var(--text-light);\n" +
            "        }\n" +
            "\n" +
            "        .features-grid {\n" +
            "            display: grid;\n" +
            "            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));\n" +
            "            gap: 2.5rem;\n" +
            "            max-width: 1400px;\n" +
            "            margin: 0 auto;\n" +
            "            margin-top: 3rem;\n" +
            "        }\n" +
            "\n" +
            "        .feature-card {\n" +
            "            padding: 2rem;\n" +
            "            background: rgba(255, 255, 255, 0.05);\n" +
            "            border: 1px solid rgba(255, 215, 0, 0.2);\n" +
            "            border-radius: var(--border-radius);\n" +
            "            text-align: center;\n" +
            "            transition: var(--transition);\n" +
            "        }\n" +
            "\n" +
            "        .feature-card:hover {\n" +
            "            background: rgba(255, 215, 0, 0.1);\n" +
            "            border-color: var(--accent);\n" +
            "            transform: translateY(-5px);\n" +
            "        }\n" +
            "\n" +
            "        .feature-icon {\n" +
            "            font-size: 2.5rem;\n" +
            "            margin-bottom: 1rem;\n" +
            "        }\n" +
            "\n" +
            "        .feature-card h4 {\n" +
            "            color: var(--accent);\n" +
            "            margin-bottom: 0.5rem;\n" +
            "            font-size: 1.2rem;\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== FOOTER ==================== */\n" +
            "        footer {\n" +
            "            background: #000;\n" +
            "            color: var(--text-light);\n" +
            "            text-align: center;\n" +
            "            padding: 3rem 2rem;\n" +
            "            border-top: 1px solid rgba(255, 215, 0, 0.2);\n" +
            "        }\n" +
            "\n" +
            "        footer p {\n" +
            "            margin: 0.5rem 0;\n" +
            "            opacity: 0.8;\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== TESTIMONIALS SECTION ==================== */\n" +
            "        .testimonials {\n" +
            "            padding: 100px 2rem;\n" +
            "            background: var(--light-bg);\n" +
            "        }\n" +
            "\n" +
            "        .carousel-container {\n" +
            "            max-width: 800px;\n" +
            "            margin: 3rem auto;\n" +
            "            position: relative;\n" +
            "            overflow: hidden;\n" +
            "        }\n" +
            "\n" +
            "        .carousel {\n" +
            "            display: flex;\n" +
            "            transition: transform 0.6s cubic-bezier(0.4, 0, 0.2, 1);\n" +
            "        }\n" +
            "\n" +
            "        .testimonial-card {\n" +
            "            min-width: 100%;\n" +
            "            background: white;\n" +
            "            padding: 3rem;\n" +
            "            border-radius: var(--border-radius);\n" +
            "            box-shadow: var(--shadow);\n" +
            "            text-align: center;\n" +
            "        }\n" +
            "\n" +
            "        .testimonial-card .stars {\n" +
            "            color: var(--accent);\n" +
            "            font-size: 1.5rem;\n" +
            "            margin-bottom: 1rem;\n" +
            "        }\n" +
            "\n" +
            "        .testimonial-card p {\n" +
            "            font-size: 1.1rem;\n" +
            "            color: #555;\n" +
            "            margin-bottom: 1.5rem;\n" +
            "            font-style: italic;\n" +
            "            line-height: 1.8;\n" +
            "        }\n" +
            "\n" +
            "        .testimonial-author {\n" +
            "            display: flex;\n" +
            "            align-items: center;\n" +
            "            justify-content: center;\n" +
            "            gap: 1rem;\n" +
            "        }\n" +
            "\n" +
            "        .author-avatar {\n" +
            "            width: 60px;\n" +
            "            height: 60px;\n" +
            "            border-radius: 50%;\n" +
            "            background: linear-gradient(135deg, var(--primary) 0%, var(--primary-dark) 100%);\n" +
            "            display: flex;\n" +
            "            align-items: center;\n" +
            "            justify-content: center;\n" +
            "            color: white;\n" +
            "            font-size: 1.5rem;\n" +
            "            font-weight: 700;\n" +
            "        }\n" +
            "\n" +
            "        .author-info h4 {\n" +
            "            margin: 0;\n" +
            "            color: var(--primary);\n" +
            "            font-weight: 700;\n" +
            "        }\n" +
            "\n" +
            "        .author-info p {\n" +
            "            margin: 0;\n" +
            "            font-size: 0.9rem;\n" +
            "            color: #999;\n" +
            "            font-style: normal;\n" +
            "        }\n" +
            "\n" +
            "        .carousel-nav {\n" +
            "            display: flex;\n" +
            "            justify-content: center;\n" +
            "            gap: 1rem;\n" +
            "            margin-top: 2rem;\n" +
            "        }\n" +
            "\n" +
            "        .carousel-btn {\n" +
            "            width: 40px;\n" +
            "            height: 40px;\n" +
            "            border: 2px solid var(--primary);\n" +
            "            background: transparent;\n" +
            "            color: var(--primary);\n" +
            "            border-radius: 50%;\n" +
            "            cursor: pointer;\n" +
            "            font-size: 1.2rem;\n" +
            "            transition: var(--transition);\n" +
            "        }\n" +
            "\n" +
            "        .carousel-btn:hover {\n" +
            "            background: var(--primary);\n" +
            "            color: white;\n" +
            "            transform: scale(1.1);\n" +
            "        }\n" +
            "\n" +
            "        .carousel-dots {\n" +
            "            display: flex;\n" +
            "            justify-content: center;\n" +
            "            gap: 0.5rem;\n" +
            "            margin-top: 1.5rem;\n" +
            "        }\n" +
            "\n" +
            "        .dot {\n" +
            "            width: 12px;\n" +
            "            height: 12px;\n" +
            "            border-radius: 50%;\n" +
            "            background: #ddd;\n" +
            "            cursor: pointer;\n" +
            "            transition: var(--transition);\n" +
            "        }\n" +
            "\n" +
            "        .dot.active {\n" +
            "            background: var(--primary);\n" +
            "            width: 30px;\n" +
            "            border-radius: 10px;\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== CONTACT SECTION ==================== */\n" +
            "        .contact {\n" +
            "            padding: 100px 2rem;\n" +
            "            background: var(--dark-bg);\n" +
            "            color: var(--text-light);\n" +
            "        }\n" +
            "\n" +
            "        .contact-content {\n" +
            "            max-width: 1200px;\n" +
            "            margin: 0 auto;\n" +
            "            display: grid;\n" +
            "            grid-template-columns: 1fr 1fr;\n" +
            "            gap: 3rem;\n" +
            "            margin-top: 3rem;\n" +
            "        }\n" +
            "\n" +
            "        .contact-info {\n" +
            "            display: flex;\n" +
            "            flex-direction: column;\n" +
            "            gap: 2rem;\n" +
            "        }\n" +
            "\n" +
            "        .contact-item {\n" +
            "            display: flex;\n" +
            "            gap: 1.5rem;\n" +
            "            align-items: flex-start;\n" +
            "        }\n" +
            "\n" +
            "        .contact-icon {\n" +
            "            font-size: 1.8rem;\n" +
            "            width: 50px;\n" +
            "            height: 50px;\n" +
            "            border-radius: 50%;\n" +
            "            background: rgba(255, 215, 0, 0.1);\n" +
            "            display: flex;\n" +
            "            align-items: center;\n" +
            "            justify-content: center;\n" +
            "            flex-shrink: 0;\n" +
            "        }\n" +
            "\n" +
            "        .contact-item h4 {\n" +
            "            color: var(--accent);\n" +
            "            margin-bottom: 0.5rem;\n" +
            "            font-size: 1.2rem;\n" +
            "        }\n" +
            "\n" +
            "        .contact-item p {\n" +
            "            margin: 0;\n" +
            "            opacity: 0.9;\n" +
            "        }\n" +
            "\n" +
            "        .contact-form {\n" +
            "            background: rgba(255, 255, 255, 0.05);\n" +
            "            padding: 2.5rem;\n" +
            "            border-radius: var(--border-radius);\n" +
            "            border: 1px solid rgba(255, 215, 0, 0.2);\n" +
            "        }\n" +
            "\n" +
            "        .contact-form h3 {\n" +
            "            color: var(--accent);\n" +
            "            margin-bottom: 1.5rem;\n" +
            "            font-size: 1.3rem;\n" +
            "        }\n" +
            "\n" +
            "        .form-group {\n" +
            "            margin-bottom: 1.5rem;\n" +
            "        }\n" +
            "\n" +
            "        .form-group label {\n" +
            "            display: block;\n" +
            "            margin-bottom: 0.5rem;\n" +
            "            font-weight: 600;\n" +
            "            font-size: 0.95rem;\n" +
            "        }\n" +
            "\n" +
            "        .form-group input,\n" +
            "        .form-group textarea {\n" +
            "            width: 100%;\n" +
            "            padding: 0.8rem;\n" +
            "            border: 1px solid rgba(255, 215, 0, 0.3);\n" +
            "            background: rgba(255, 255, 255, 0.05);\n" +
            "            color: var(--text-light);\n" +
            "            border-radius: 8px;\n" +
            "            font-family: inherit;\n" +
            "            transition: var(--transition);\n" +
            "        }\n" +
            "\n" +
            "        .form-group input::placeholder,\n" +
            "        .form-group textarea::placeholder {\n" +
            "            color: rgba(255, 255, 255, 0.5);\n" +
            "        }\n" +
            "\n" +
            "        .form-group input:focus,\n" +
            "        .form-group textarea:focus {\n" +
            "            outline: none;\n" +
            "            border-color: var(--accent);\n" +
            "            background: rgba(255, 215, 0, 0.1);\n" +
            "            box-shadow: 0 0 0 3px rgba(255, 215, 0, 0.1);\n" +
            "        }\n" +
            "\n" +
            "        .contact-form .btn {\n" +
            "            width: 100%;\n" +
            "        }\n" +
            "\n" +
            "        .footer-content {\n" +
            "            max-width: 1400px;\n" +
            "            margin: 0 auto;\n" +
            "            display: grid;\n" +
            "            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));\n" +
            "            gap: 3rem;\n" +
            "            margin-bottom: 3rem;\n" +
            "        }\n" +
            "\n" +
            "        .footer-section h4 {\n" +
            "            color: var(--accent);\n" +
            "            margin-bottom: 1.5rem;\n" +
            "            font-size: 1.2rem;\n" +
            "        }\n" +
            "\n" +
            "        .footer-section ul {\n" +
            "            list-style: none;\n" +
            "        }\n" +
            "\n" +
            "        .footer-section li {\n" +
            "            margin-bottom: 0.8rem;\n" +
            "        }\n" +
            "\n" +
            "        .footer-section a {\n" +
            "            color: rgba(255, 255, 255, 0.8);\n" +
            "            text-decoration: none;\n" +
            "            transition: var(--transition);\n" +
            "        }\n" +
            "\n" +
            "        .footer-section a:hover {\n" +
            "            color: var(--accent);\n" +
            "            margin-left: 5px;\n" +
            "        }\n" +
            "\n" +
            "        .footer-divider {\n" +
            "            border-top: 1px solid rgba(255, 215, 0, 0.2);\n" +
            "            padding-top: 2rem;\n" +
            "        }\n" +
            "\n" +
            "        .footer-bottom {\n" +
            "            text-align: center;\n" +
            "            opacity: 0.8;\n" +
            "        }\n" +
            "\n" +
            "        .footer-bottom p {\n" +
            "            margin: 0.5rem 0;\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== SCROLLBAR ==================== */\n" +
            "        ::-webkit-scrollbar {\n" +
            "            width: 10px;\n" +
            "        }\n" +
            "\n" +
            "        ::-webkit-scrollbar-track {\n" +
            "            background: #f1f1f1;\n" +
            "        }\n" +
            "\n" +
            "        ::-webkit-scrollbar-thumb {\n" +
            "            background: var(--primary);\n" +
            "            border-radius: 10px;\n" +
            "        }\n" +
            "\n" +
            "        ::-webkit-scrollbar-thumb:hover {\n" +
            "            background: var(--primary-dark);\n" +
            "        }\n" +
            "\n" +
            "        /* ==================== RESPONSIVE ==================== */\n" +
            "        @media (max-width: 768px) {\n" +
            "            nav {\n" +
            "                flex-direction: column;\n" +
            "                gap: 1rem;\n" +
            "                padding: 1rem;\n" +
            "            }\n" +
            "\n" +
            "            .nav-links {\n" +
            "                gap: 1.5rem;\n" +
            "            }\n" +
            "\n" +
            "            .hero {\n" +
            "                padding: 60px 1rem;\n" +
            "                min-height: auto;\n" +
            "            }\n" +
            "\n" +
            "            .cta-buttons {\n" +
            "                flex-direction: column;\n" +
            "                gap: 1rem;\n" +
            "            }\n" +
            "\n" +
            "            .btn {\n" +
            "                width: 100%;\n" +
            "            }\n" +
            "\n" +
            "            .packages,\n" +
            "            .features {\n" +
            "                padding: 60px 1rem;\n" +
            "            }\n" +
            "\n" +
            "            .packages-grid,\n" +
            "            .features-grid {\n" +
            "                gap: 1.5rem;\n" +
            "            }\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <!-- Navigation -->\n" +
            "    <nav>\n" +
            "        <div class=\"logo\">🏠 MK Tech Automacao Residencial</div>\n" +
            "        <ul class=\"nav-links\">\n" +
            "            <li><a href=\"#pacotes\">Pacotes</a></li>\n" +
            "            <li><a href=\"#recursos\">Recursos</a></li>\n" +
            "            <li><a href=\"#contato\">Contato</a></li>\n" +
            "        </ul>\n" +
            "    </nav>\n" +
            "\n" +
            "    <!-- Hero Section -->\n" +
            "    <section class=\"hero\">\n" +
            "        <div class=\"hero-content\">\n" +
            "            <h1>🏠 Transforme Sua Casa de Forma Inteligente</h1>\n" +
            "            <p class=\"subtitle\">Automação residencial com tecnologia de ponta. Segurança, economia e conforto em um só lugar.</p>\n" +
            "            <div class=\"cta-buttons\">\n" +
            "                <button class=\"btn btn-primary\" onclick=\"document.getElementById('pacotes').scrollIntoView({behavior: 'smooth'});\">Ver Pacotes</button>\n" +
            "                <button class=\"btn btn-secondary\" onclick=\"showAlert();\">Agendar Demo</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </section>\n" +
            "\n" +
            "    <!-- Packages Section -->\n" +
            "    <section id=\"pacotes\" class=\"packages\">\n" +
            "        <div class=\"section-title\">\n" +
            "            <h2>📦 Nossos Pacotes</h2>\n" +
            "            <p class=\"section-subtitle\">Escolha o plano perfeito para sua casa</p>\n" +
            "        </div>\n" +
            "        <div class=\"packages-grid\">\n" +
            "            <div class=\"package-card\" onclick=\"toggleDetails(this)\">\n" +
            "                <div class=\"package-icon\">💎</div>\n" +
            "                <h3>Prata</h3>\n" +
            "                <p class=\"package-level\">Básico</p>\n" +
            "                <div class=\"price\">R$ 1.499</div>\n" +
            "                <ul>\n" +
            "                    <li>✨ Iluminação Inteligente</li>\n" +
            "                    <li>🔐 Fechadura Inteligente</li>\n" +
            "                    <li>📱 Controle via Smartphone</li>\n" +
            "                    <li>⏰ Automação por Horário</li>\n" +
            "                </ul>\n" +
            "                <button class=\"btn btn-primary btn-cta\">Contratar Agora</button>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"package-card\" onclick=\"toggleDetails(this)\" style=\"transform: scale(1.05); z-index: 10;\">\n" +
            "                <div class=\"package-icon\">🥇</div>\n" +
            "                <h3>Ouro</h3>\n" +
            "                <p class=\"package-level\">Recomendado ⭐</p>\n" +
            "                <div class=\"price\">R$ 2.999</div>\n" +
            "                <ul>\n" +
            "                    <li>✨ Iluminação Inteligente</li>\n" +
            "                    <li>🔐 Fechadura Inteligente</li>\n" +
            "                    <li>🌡️ Controle de Temperatura</li>\n" +
            "                    <li>🎬 Cortinas Inteligentes</li>\n" +
            "                    <li>📱 Controle via App</li>\n" +
            "                    <li>🔊 Assistente de Voz</li>\n" +
            "                </ul>\n" +
            "                <button class=\"btn btn-primary btn-cta\">Contratar Agora</button>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"package-card\" onclick=\"toggleDetails(this)\">\n" +
            "                <div class=\"package-icon\">👑</div>\n" +
            "                <h3>Platina</h3>\n" +
            "                <p class=\"package-level\">Premium</p>\n" +
            "                <div class=\"price\">R$ 4.999</div>\n" +
            "                <ul>\n" +
            "                    <li>✨ Iluminação Inteligente</li>\n" +
            "                    <li>🔐 Fechadura Inteligente</li>\n" +
            "                    <li>🌡️ Controle de Temperatura</li>\n" +
            "                    <li>🎬 Cortinas Inteligentes</li>\n" +
            "                    <li>📹 Câmeras de Segurança</li>\n" +
            "                    <li>🔊 Assistente de Voz AI</li>\n" +
            "                    <li>⚡ Gerenciamento de Energia</li>\n" +
            "                    <li>🌐 Integração com Smart TV</li>\n" +
            "                </ul>\n" +
            "                <button class=\"btn btn-primary btn-cta\">Contratar Agora</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </section>\n" +
            "\n" +
            "    <!-- Automation Modes Section -->\n" +
            "    <section class=\"automation-modes\">\n" +
            "        <div class=\"section-title\">\n" +
            "            <h2>⚙️ Formas de Automação</h2>\n" +
            "            <p class=\"section-subtitle\">Escolha a tecnologia que melhor se adequa à sua casa</p>\n" +
            "        </div>\n" +
            "        <div class=\"modes-grid\">\n" +
            "            <div class=\"mode-card wifi-mode\">\n" +
            "                <div class=\"mode-icon\">📡</div>\n" +
            "                <h3>WiFi - Sem Cabos</h3>\n" +
            "                <p class=\"mode-label\">Instalação Rápida & Flexível</p>\n" +
            "                <div class=\"mode-benefits\">\n" +
            "                    <ul>\n" +
            "                        <li>✅ Instalação em minutos</li>\n" +
            "                        <li>✅ Sem obras ou furos</li>\n" +
            "                        <li>✅ Fácil reposicionamento</li>\n" +
            "                        <li>✅ Custo de instalação reduzido</li>\n" +
            "                        <li>✅ Ideal para aluguel</li>\n" +
            "                        <li>✅ Controle via smartphone</li>\n" +
            "                    </ul>\n" +
            "                </div>\n" +
            "                <p class=\"mode-note\">⚡ Melhor para: Apartamentos, casas alugadas, renovação rápida</p>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"mode-card\">\n" +
            "                <div class=\"mode-icon\">🔌</div>\n" +
            "                <h3>Cabeado - Profissional</h3>\n" +
            "                <p class=\"mode-label\">Máxima Confiabilidade & Cobertura</p>\n" +
            "                <div class=\"mode-benefits\">\n" +
            "                    <ul>\n" +
            "                        <li>✅ Sinal mais estável</li>\n" +
            "                        <li>✅ Cobertura total da casa</li>\n" +
            "                        <li>✅ Sem interferências</li>\n" +
            "                        <li>✅ Backup de energia integrado</li>\n" +
            "                        <li>✅ Maior capacidade de dispositivos</li>\n" +
            "                        <li>✅ Futuro-proof</li>\n" +
            "                    </ul>\n" +
            "                </div>\n" +
            "                <p class=\"mode-note\">🏠 Melhor para: Casas novas, reformas, high-end</p>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"mode-card hybrid-mode\">\n" +
            "                <div class=\"mode-icon\">🔄</div>\n" +
            "                <h3>Híbrido - O Melhor dos Dois</h3>\n" +
            "                <p class=\"mode-label\">Flexibilidade Total</p>\n" +
            "                <div class=\"mode-benefits\">\n" +
            "                    <ul>\n" +
            "                        <li>✅ Combina WiFi + Cabeado</li>\n" +
            "                        <li>✅ Redundância de sinal</li>\n" +
            "                        <li>✅ Máxima confiabilidade</li>\n" +
            "                        <li>✅ Expande conforme necessário</li>\n" +
            "                        <li>✅ Sem compromissos</li>\n" +
            "                        <li>✅ Escalável</li>\n" +
            "                    </ul>\n" +
            "                </div>\n" +
            "                <p class=\"mode-note\">⭐ Melhor para: Máximo desempenho e flexibilidade</p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </section>\n" +
            "\n" +
            "    <!-- Quick Menu Section -->\n" +
            "    <section class=\"quick-menu\">\n" +
            "        <div class=\"section-title\">\n" +
            "            <h2>🎯 Encontre Seu Pacote Ideal</h2>\n" +
            "            <p class=\"section-subtitle\">Responda 3 perguntas e recomendaremos o melhor pacote</p>\n" +
            "        </div>\n" +
            "        <div class=\"menu-cards\">\n" +
            "            <div class=\"menu-card\" onclick=\"scrollToPackages(); showAlert('Veja nossos pacotes Silver, Gold e Platinum abaixo!');\">\n" +
            "                <div class=\"menu-icon\">🏠</div>\n" +
            "                <h4>Sou Iniciante</h4>\n" +
            "                <p>Primeira vez com automação</p>\n" +
            "                <span class=\"menu-label\">→ Pacote Prata</span>\n" +
            "            </div>\n" +
            "            <div class=\"menu-card\" onclick=\"scrollToPackages(); showAlert('Recomendamos o Pacote Gold!');\">\n" +
            "                <div class=\"menu-icon\">🎯</div>\n" +
            "                <h4>Sou Experiente</h4>\n" +
            "                <p>Quero automação completa</p>\n" +
            "                <span class=\"menu-label\">→ Pacote Ouro</span>\n" +
            "            </div>\n" +
            "            <div class=\"menu-card\" onclick=\"scrollToPackages(); showAlert('Pacote Platina: Todo o poder em suas mãos!');\">\n" +
            "                <div class=\"menu-icon\">👑</div>\n" +
            "                <h4>Sou Premium</h4>\n" +
            "                <p>Quero tudo, sem limites</p>\n" +
            "                <span class=\"menu-label\">→ Pacote Platina</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </section>\n" +
            "\n" +
            "    <!-- Features Section -->\n" +
            "    <section id=\"recursos\" class=\"features\">\n" +
            "        <div class=\"section-title\">\n" +
            "            <h2>🚀 Por Que Escolher MK Tech?</h2>\n" +
            "            <p class=\"section-subtitle\">Diferenciais que fazem toda a diferença</p>\n" +
            "        </div>\n" +
            "        <div class=\"features-grid\">\n" +
            "            <div class=\"feature-card\">\n" +
            "                <div class=\"feature-icon\">🛡️</div>\n" +
            "                <h4>Segurança 100%</h4>\n" +
            "                <p>Criptografia de ponta a ponta em todos os dados</p>\n" +
            "            </div>\n" +
            "            <div class=\"feature-card\">\n" +
            "                <div class=\"feature-icon\">⚡</div>\n" +
            "                <h4>Economize Energia</h4>\n" +
            "                <p>Reduza sua conta de energia em até 40%</p>\n" +
            "            </div>\n" +
            "            <div class=\"feature-card\">\n" +
            "                <div class=\"feature-icon\">📱</div>\n" +
            "                <h4>Controle Total</h4>\n" +
            "                <p>Controle sua casa de qualquer lugar do mundo</p>\n" +
            "            </div>\n" +
            "            <div class=\"feature-card\">\n" +
            "                <div class=\"feature-icon\">🔧</div>\n" +
            "                <h4>Fácil Instalação</h4>\n" +
            "                <p>Instalação profissional incluída em todos os pacotes</p>\n" +
            "            </div>\n" +
            "            <div class=\"feature-card\">\n" +
            "                <div class=\"feature-icon\">🎯</div>\n" +
            "                <h4>Suporte 24/7</h4>\n" +
            "                <p>Tim técnico sempre disponível para ajudá-lo</p>\n" +
            "            </div>\n" +
            "            <div class=\"feature-card\">\n" +
            "                <div class=\"feature-icon\">🌟</div>\n" +
            "                <h4>Inovação Contínua</h4>\n" +
            "                <p>Atualizações de software sempre gratuitas</p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </section>\n" +
            "\n" +
            "    <!-- Testimonials Section -->\n" +
            "    <section class=\"testimonials\">\n" +
            "        <div class=\"section-title\">\n" +
            "            <h2>⭐ O Que Nossos Clientes Dizem</h2>\n" +
            "            <p class=\"section-subtitle\">Histórias reais de transformação digital</p>\n" +
            "        </div>\n" +
            "        <div class=\"carousel-container\">\n" +
            "            <div class=\"carousel\" id=\"carousel\">\n" +
            "                <div class=\"testimonial-card\">\n" +
            "                    <div class=\"stars\">⭐⭐⭐⭐⭐</div>\n" +
            "                    <p>\"A MK Tech transformou minha casa! Agora controlo tudo pelo meu celular. Instalação rápida e suporte impecável!\"</p>\n" +
            "                    <div class=\"testimonial-author\">\n" +
            "                        <div class=\"author-avatar\">JM</div>\n" +
            "                        <div class=\"author-info\">\n" +
            "                            <h4>João Mendes</h4>\n" +
            "                            <p>São Paulo, SP</p>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"testimonial-card\">\n" +
            "                    <div class=\"stars\">⭐⭐⭐⭐⭐</div>\n" +
            "                    <p>\"Melhor investimento que fiz! Minha conta de energia caiu 35%. O pacote platinum é realmente completo!\"</p>\n" +
            "                    <div class=\"testimonial-author\">\n" +
            "                        <div class=\"author-avatar\">MS</div>\n" +
            "                        <div class=\"author-info\">\n" +
            "                            <h4>Mariana Silva</h4>\n" +
            "                            <p>Rio de Janeiro, RJ</p>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"testimonial-card\">\n" +
            "                    <div class=\"stars\">⭐⭐⭐⭐⭐</div>\n" +
            "                    <p>\"Sem palavras! A segurança é tremenda, as cortinas automáticas e câmeras funcionam perfeitamente. Recomendo demais!\"</p>\n" +
            "                    <div class=\"testimonial-author\">\n" +
            "                        <div class=\"author-avatar\">CF</div>\n" +
            "                        <div class=\"author-info\">\n" +
            "                            <h4>Carlos Ferreira</h4>\n" +
            "                            <p>Belo Horizonte, MG</p>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"testimonial-card\">\n" +
            "                    <div class=\"stars\">⭐⭐⭐⭐⭐</div>\n" +
            "                    <p>\"Atendimento excepcional! Equipe técnica muito atenciosa. Minha casa se tornou um verdadeiro lar inteligente!\"</p>\n" +
            "                    <div class=\"testimonial-author\">\n" +
            "                        <div class=\"author-avatar\">AN</div>\n" +
            "                        <div class=\"author-info\">\n" +
            "                            <h4>Aline Oliveira</h4>\n" +
            "                            <p>Curitiba, PR</p>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"carousel-nav\">\n" +
            "                <button class=\"carousel-btn\" onclick=\"prevSlide()\">❮</button>\n" +
            "                <button class=\"carousel-btn\" onclick=\"nextSlide()\">❯</button>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"carousel-dots\" id=\"dots\"></div>\n" +
            "        </div>\n" +
            "    </section>\n" +
            "\n" +
            "    <!-- Contact Section -->\n" +
            "    <section id=\"contato\" class=\"contact\">\n" +
            "        <div class=\"section-title\">\n" +
            "            <h2>💬 Fale Conosco</h2>\n" +
            "            <p class=\"section-subtitle\">Estamos prontos para transformar sua casa</p>\n" +
            "        </div>\n" +
            "        <div class=\"contact-content\">\n" +
            "            <div class=\"contact-info\">\n" +
            "                <div class=\"contact-item\">\n" +
            "                    <div class=\"contact-icon\">📍</div>\n" +
            "                    <div>\n" +
            "                        <h4>Localização</h4>\n" +
            "                        <p>Av. Paulista, 1000 - São Paulo, SP<br>CEP 01310-100</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"contact-item\">\n" +
            "                    <div class=\"contact-icon\">📱</div>\n" +
            "                    <div>\n" +
            "                        <h4>Telefone</h4>\n" +
            "                        <p>(11) 3000-1000<br>WhatsApp: (11) 99999-9999</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"contact-item\">\n" +
            "                    <div class=\"contact-icon\">📧</div>\n" +
            "                    <div>\n" +
            "                        <h4>E-mail</h4>\n" +
            "                        <p>contato@mktech.com.br<br>suporte@mktech.com.br</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"contact-item\">\n" +
            "                    <div class=\"contact-icon\">🕐</div>\n" +
            "                    <div>\n" +
            "                        <h4>Horário de Atendimento</h4>\n" +
            "                        <p>Segunda a Sexta: 8h - 18h<br>Sábado: 9h - 14h</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "\n" +
            "            <form class=\"contact-form\" onsubmit=\"sendContact(event)\">\n" +
            "                <h3>📝 Envie uma Mensagem</h3>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <label for=\"name\">Nome Completo</label>\n" +
            "                    <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Seu nome\" required>\n" +
            "                </div>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <label for=\"email\">E-mail</label>\n" +
            "                    <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"seu@email.com\" required>\n" +
            "                </div>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <label for=\"phone\">Telefone</label>\n" +
            "                    <input type=\"tel\" id=\"phone\" name=\"phone\" placeholder=\"(11) 99999-9999\" required>\n" +
            "                </div>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <label for=\"subject\">Assunto</label>\n" +
            "                    <input type=\"text\" id=\"subject\" name=\"subject\" placeholder=\"Como podemos ajudar?\" required>\n" +
            "                </div>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <label for=\"message\">Mensagem</label>\n" +
            "                    <textarea id=\"message\" name=\"message\" rows=\"5\" placeholder=\"Digite sua mensagem aqui...\" required></textarea>\n" +
            "                </div>\n" +
            "                <button type=\"submit\" class=\"btn btn-primary\">Enviar Mensagem</button>\n" +
            "            </form>\n" +
            "        </div>\n" +
            "    </section>\n" +
            "\n" +
            "    <!-- Footer -->\n" +
            "    <footer>\n" +
            "        <div class=\"footer-content\">\n" +
            "            <div class=\"footer-section\">\n" +
            "                <h4>🏠 MK Tech</h4>\n" +
            "                <p style=\"margin: 0; opacity: 0.8; font-size: 0.9rem;\">Transformando casas em lares inteligentes há 5 anos.</p>\n" +
            "            </div>\n" +
            "            <div class=\"footer-section\">\n" +
            "                <h4>📦 Serviços</h4>\n" +
            "                <ul>\n" +
            "                    <li><a href=\"#pacotes\">Pacotes</a></li>\n" +
            "                    <li><a href=\"#recursos\">Recursos</a></li>\n" +
            "                    <li><a href=\"#\">Manutenção</a></li>\n" +
            "                    <li><a href=\"#\">Consultoria</a></li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"footer-section\">\n" +
            "                <h4>🔗 Links Úteis</h4>\n" +
            "                <ul>\n" +
            "                    <li><a href=\"#\">Blog de Tecnologia</a></li>\n" +
            "                    <li><a href=\"#\">Documentação</a></li>\n" +
            "                    <li><a href=\"#\">FAQ</a></li>\n" +
            "                    <li><a href=\"#\">Termos de Uso</a></li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"footer-section\">\n" +
            "                <h4>📞 Suporte</h4>\n" +
            "                <ul>\n" +
            "                    <li><a href=\"mailto:contato@mktech.com.br\">E-mail: contato@mktech.com.br</a></li>\n" +
            "                    <li><a href=\"tel:+5511999999999\">WhatsApp: (11) 99999-9999</a></li>\n" +
            "                    <li><a href=\"#contato\">Central de Contato</a></li>\n" +
            "                    <li><a href=\"#\">Chat 24/7</a></li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"footer-divider\">\n" +
            "            <div class=\"footer-bottom\">\n" +
            "                <p>&copy; 2026 MK Tech  Automação Residencial. Todos os direitos reservados.</p>\n" +
            "                <p>Desenvolvido por phdev25</p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </footer>\n" +
            "\n" +
            "    <script>\n" +
            "        function toggleDetails(element) {\n" +
            "            element.style.opacity = element.style.opacity === '0.7' ? '1' : '0.7';\n" +
            "        }\n" +
            "\n" +
            "        function showAlert() {\n" +
            "            alert('🎉 Obrigado pelo interesse!\\n\\nNosso time entrará em contato em breve para agendar sua demonstração.');\n" +
            "        }\n" +
            "\n" +
            "        // Smooth scroll for navigation\n" +
            "        document.querySelectorAll('a[href^=\"#\"]').forEach(anchor => {\n" +
            "            anchor.addEventListener('click', function (e) {\n" +
            "                e.preventDefault();\n" +
            "                const target = document.querySelector(this.getAttribute('href'));\n" +
            "                if (target) {\n" +
            "                    target.scrollIntoView({behavior: 'smooth', block: 'start'});\n" +
            "                }\n" +
            "            });\n" +
            "        });\n" +
            "\n" +
            "        // Animate elements on scroll\n" +
            "        const observerOptions = {\n" +
            "            threshold: 0.1,\n" +
            "            rootMargin: '0px 0px -100px 0px'\n" +
            "        };\n" +
            "\n" +
            "        const observer = new IntersectionObserver(function(entries) {\n" +
            "            entries.forEach(entry => {\n" +
            "                if (entry.isIntersecting) {\n" +
            "                    entry.target.style.animation = 'fadeInUp 0.6s ease-out forwards';\n" +
            "                    observer.unobserve(entry.target);\n" +
            "                }\n" +
            "            });\n" +
            "        }, observerOptions);\n" +
            "\n" +
            "        document.querySelectorAll('.package-card, .feature-card, .mode-card, .menu-card').forEach(el => {\n" +
            "            el.style.opacity = '0';\n" +
            "            observer.observe(el);\n" +
            "        });\n" +
            "\n" +
            "        // Carousel Functionality\n" +
            "        let currentSlide = 0;\n" +
            "        const carousel = document.getElementById('carousel');\n" +
            "        const dotsContainer = document.getElementById('dots');\n" +
            "        const totalSlides = document.querySelectorAll('.testimonial-card').length;\n" +
            "\n" +
            "        function initCarousel() {\n" +
            "            for (let i = 0; i < totalSlides; i++) {\n" +
            "                const dot = document.createElement('div');\n" +
            "                dot.className = 'dot' + (i === 0 ? ' active' : '');\n" +
            "                dot.onclick = () => goToSlide(i);\n" +
            "                dotsContainer.appendChild(dot);\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        function updateCarousel() {\n" +
            "            carousel.style.transform = `translateX(-${currentSlide * 100}%)`;\n" +
            "            updateDots();\n" +
            "        }\n" +
            "\n" +
            "        function updateDots() {\n" +
            "            document.querySelectorAll('.dot').forEach((dot, index) => {\n" +
            "                dot.classList.toggle('active', index === currentSlide);\n" +
            "            });\n" +
            "        }\n" +
            "\n" +
            "        function nextSlide() {\n" +
            "            currentSlide = (currentSlide + 1) % totalSlides;\n" +
            "            updateCarousel();\n" +
            "        }\n" +
            "\n" +
            "        function prevSlide() {\n" +
            "            currentSlide = (currentSlide - 1 + totalSlides) % totalSlides;\n" +
            "            updateCarousel();\n" +
            "        }\n" +
            "\n" +
            "        function goToSlide(index) {\n" +
            "            currentSlide = index;\n" +
            "            updateCarousel();\n" +
            "        }\n" +
            "\n" +
            "        // Auto-advance carousel every 8 seconds\n" +
            "        setInterval(nextSlide, 8000);\n" +
            "\n" +
            "        // Contact Form Handler\n" +
            "        function sendContact(e) {\n" +
            "            e.preventDefault();\n" +
            "            const name = document.getElementById('name').value;\n" +
            "            const email = document.getElementById('email').value;\n" +
            "            const phone = document.getElementById('phone').value;\n" +
            "            const subject = document.getElementById('subject').value;\n" +
            "            const message = document.getElementById('message').value;\n" +
            "\n" +
            "            // Simulate form submission\n" +
            "            showAlert(`✅ Obrigado, ${name}!\\\\n\\\\nRecebemos sua mensagem sobre \\\"${subject}\\\".\\\\nNosso team responderá em breve no e-mail ${email} ou WhatsApp ${phone}.\\\\n\\\\nAguarde! 🚀`);\n" +
            "\n" +
            "            // Reset form\n" +
            "            document.querySelector('.contact-form').reset();\n" +
            "        }\n" +
            "\n" +
            "        // Initialize carousel\n" +
            "        initCarousel();\n" +
            "\n" +
            "        function scrollToPackages() {\n" +
            "            document.getElementById('pacotes').scrollIntoView({behavior: 'smooth'});\n" +
            "        }\n" +
            "    </script>\n" +
            "</body>\n" +
            "</html>";
    }
}

