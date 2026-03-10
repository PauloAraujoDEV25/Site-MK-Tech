(function() {
        'use strict';

        // ========================
        // TEMA DARK / LIGHT
        // ========================
        const themeToggle = document.getElementById('themeToggle');
        const html = document.documentElement;

        // Carregar tema salvo ou usar dark como padrão
        const savedTheme = localStorage.getItem('mktech-theme') || 'dark';
        html.setAttribute('data-theme', savedTheme);

        themeToggle.addEventListener('click', () => {
            const current = html.getAttribute('data-theme');
            const next = current === 'dark' ? 'light' : 'dark';
            html.setAttribute('data-theme', next);
            localStorage.setItem('mktech-theme', next);
        });

        // ========================
        // MENU HAMBURGER
        // ========================
        const hamburger = document.getElementById('hamburger');
        const navLinks = document.getElementById('navLinks');
        const overlay = document.getElementById('mobileOverlay');

        function toggleMenu() {
            hamburger.classList.toggle('active');
            navLinks.classList.toggle('open');
            overlay.classList.toggle('show');
            document.body.style.overflow = navLinks.classList.contains('open') ? 'hidden' : '';
        }

        function closeMenu() {
            hamburger.classList.remove('active');
            navLinks.classList.remove('open');
            overlay.classList.remove('show');
            document.body.style.overflow = '';
        }

        hamburger.addEventListener('click', toggleMenu);
        overlay.addEventListener('click', closeMenu);

        // Fechar menu ao clicar em um link
        navLinks.querySelectorAll('a').forEach(link => {
            link.addEventListener('click', closeMenu);
        });

        // ========================
        // NAVBAR SCROLL EFFECT
        // ========================
        const navbar = document.getElementById('navbar');
        let lastScroll = window.pageYOffset || 0;

        window.addEventListener('scroll', () => {
            const currentScroll = window.pageYOffset || 0;
            const menuOpen = navLinks.classList.contains('open');

            navbar.classList.toggle('scrolled', currentScroll > 50);

            // No topo (ou com menu aberto), mantém visível
            if (currentScroll < 10 || menuOpen) {
                navbar.classList.remove('navbar-hidden');
                lastScroll = currentScroll;
                return;
            }

            const scrollingDown = currentScroll > lastScroll;
            const scrollingUp = currentScroll < lastScroll;

            // Evita flicker com um pequeno "threshold"
            if (scrollingDown && currentScroll > 90) {
                navbar.classList.add('navbar-hidden');
            } else if (scrollingUp) {
                navbar.classList.remove('navbar-hidden');
            }

            lastScroll = currentScroll;
        }, { passive: true });

        // ========================
        // SCROLL REVEAL (animações ao scroll)
        // ========================
        const revealElements = document.querySelectorAll('.reveal');

        const revealObserver = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    entry.target.classList.add('visible');
                    revealObserver.unobserve(entry.target);
                }
            });
        }, {
            threshold: 0.1,
            rootMargin: '0px 0px -50px 0px'
        });

        revealElements.forEach(el => revealObserver.observe(el));

        // ========================
        // ACTIVE NAV LINK (scroll spy)
        // ========================
        const sections = document.querySelectorAll('section[id], aside[id]');
        const navLinksList = document.querySelectorAll('.nav-links a');

        const spyObserver = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    const id = entry.target.getAttribute('id');
                    navLinksList.forEach(link => {
                        link.classList.toggle('active', link.getAttribute('href') === '#' + id);
                    });
                }
            });
        }, {
            threshold: 0.3,
            rootMargin: '-80px 0px -50% 0px'
        });

        sections.forEach(section => spyObserver.observe(section));

        // ========================
        // SMOOTH SCROLL
        // ========================
        window.scrollTo = function(selector) {
            const target = document.querySelector(selector);
            if (target) {
                const offset = 80; // altura da navbar
                const top = target.getBoundingClientRect().top + window.pageYOffset - offset;
                window.scroll({ top, behavior: 'smooth' });
            }
        };

        // Links âncora
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function(e) {
                const href = this.getAttribute('href');
                if (href !== '#' && document.querySelector(href)) {
                    e.preventDefault();
                    scrollTo(href);
                }
            });
        });

        // ========================
        // ENVIO DO FORMULÁRIO (abre WhatsApp)
        // ========================
        window.sendContact = function(event) {
            event.preventDefault();

            const name = document.getElementById('name').value.trim();
            const packageLevel = document.getElementById('packageLevel').value;

            if (!name || name.length < 2) {
                showToast('Por favor, insira um nome válido!', 'error');
                return;
            }

            if (!packageLevel) {
                showToast('Por favor, selecione um serviço!', 'error');
                return;
            }

            const message = `Olá, meu nome é ${name}.\nServiço de interesse: ${packageLevel}.`;
            const whatsappUrl = 'https://wa.me/5534996568351?text=' + encodeURIComponent(message);

            window.open(whatsappUrl, '_blank');

            // Atualiza UI como sucesso
            document.getElementById('contactForm').style.display = 'none';
            document.getElementById('formSuccess').style.display = 'block';
            showToast('Abrimos o WhatsApp com sua mensagem.', 'success');
        };

        window.goToContactWithService = function(serviceName) {
            const select = document.getElementById('packageLevel');
            if (select) {
                // tenta selecionar exatamente o serviço passado
                select.value = serviceName;
            }

            const contactSection = document.getElementById('contato');
            if (contactSection) {
                contactSection.scrollIntoView({ behavior: 'smooth', block: 'start' });
            }

            const nameInput = document.getElementById('name');
            if (nameInput) {
                nameInput.focus();
            }
        };

        // ========================
        // FAQ - acordeão
        // ========================
        const faqItems = document.querySelectorAll('.faq-item');
        faqItems.forEach((item) => {
            const questionBtn = item.querySelector('.faq-question');
            if (!questionBtn) return;

            questionBtn.addEventListener('click', () => {
                const isOpen = item.classList.contains('open');

                // fecha todos os outros
                faqItems.forEach((other) => {
                    if (other !== item) {
                        other.classList.remove('open');
                    }
                });

                // alterna o atual
                if (!isOpen) {
                    item.classList.add('open');
                } else {
                    item.classList.remove('open');
                }
            });
        });

        // ========================
        // TOAST NOTIFICATIONS
        // ========================
        function showToast(message, type = 'info') {
            // Remover toast anterior
            const existing = document.querySelector('.toast');
            if (existing) existing.remove();

            const toast = document.createElement('div');
            toast.className = 'toast';
            toast.style.cssText = `
                position: fixed;
                bottom: 2rem;
                right: 2rem;
                padding: 1rem 1.5rem;
                border-radius: 12px;
                font-size: 0.92rem;
                font-weight: 600;
                font-family: inherit;
                z-index: 10000;
                animation: fadeInUp 0.4s ease-out;
                max-width: 360px;
                box-shadow: 0 8px 30px rgba(0,0,0,0.3);
                backdrop-filter: blur(10px);
                ${type === 'success'
                    ? 'background: rgba(16,185,129,0.9); color: white;'
                    : type === 'error'
                    ? 'background: rgba(239,68,68,0.9); color: white;'
                    : 'background: rgba(147,51,234,0.9); color: white;'
                }
            `;
            toast.textContent = (type === 'success' ? '✅ ' : type === 'error' ? '❌ ' : 'ℹ️ ') + message;
            document.body.appendChild(toast);

            setTimeout(() => {
                toast.style.opacity = '0';
                toast.style.transform = 'translateY(10px)';
                toast.style.transition = 'all 0.3s ease';
                setTimeout(() => toast.remove(), 300);
            }, 4000);
        }

        // ========================
        // CARROSSEL DE DEPOIMENTOS
        // ========================
        const testimonialsTrack = document.getElementById('testimonialsTrack');
        const testimonialCards = testimonialsTrack ? Array.from(testimonialsTrack.querySelectorAll('.testimonial-card')) : [];
        const dotsContainer = document.getElementById('testimonialDots');
        const prevBtn = document.querySelector('.testimonial-nav.prev');
        const nextBtn = document.querySelector('.testimonial-nav.next');

        if (testimonialsTrack && testimonialCards.length > 0 && dotsContainer && prevBtn && nextBtn) {
            let currentIndex = 0;

            // Criar dots
            testimonialCards.forEach((_, index) => {
                const dot = document.createElement('div');
                dot.className = 'testimonial-dot' + (index === 0 ? ' active' : '');
                dot.addEventListener('click', () => goToSlide(index));
                dotsContainer.appendChild(dot);
            });

            const dots = Array.from(dotsContainer.querySelectorAll('.testimonial-dot'));

            function updateCarousel(instant = false) {
                const target = testimonialCards[currentIndex];
                if (!target) return;

                if (instant) testimonialsTrack.style.transition = 'none';
                const offset = -target.offsetLeft;
                testimonialsTrack.style.transform = `translateX(${offset}px)`;
                if (instant) {
                    requestAnimationFrame(() => {
                        testimonialsTrack.style.transition = '';
                    });
                }

                dots.forEach((dot, idx) => dot.classList.toggle('active', idx === currentIndex));
            }

            function goToSlide(index) {
                currentIndex = (index + testimonialCards.length) % testimonialCards.length;
                updateCarousel();
            }

            prevBtn.addEventListener('click', () => goToSlide(currentIndex - 1));
            nextBtn.addEventListener('click', () => goToSlide(currentIndex + 1));

            // Auto-play
            let autoPlay = setInterval(() => goToSlide(currentIndex + 1), 8000);

            // Pausar ao interagir
            [prevBtn, nextBtn, testimonialsTrack].forEach(el => {
                el.addEventListener('mouseenter', () => clearInterval(autoPlay));
                el.addEventListener('mouseleave', () => {
                    autoPlay = setInterval(() => goToSlide(currentIndex + 1), 8000);
                });
            });

            // Ajuste inicial
            updateCarousel(true);

            // Recalcular offsets ao redimensionar (gap/width mudam)
            window.addEventListener('resize', () => updateCarousel(true), { passive: true });
        }

        // ========================
        // CARROSSEL DE BENEFÍCIOS
        // ========================
        const benefitsCarousel = document.getElementById('benefitsCarousel');
        const benefitsTrack = document.getElementById('benefitsTrack');
        const benefitSlides = benefitsTrack ? Array.from(benefitsTrack.querySelectorAll('.benefits-slide')) : [];

        if (benefitsCarousel && benefitsTrack && benefitSlides.length > 0) {
            let currentIndex = 0;
            let autoPlayId = null;
            let resumeTimeoutId = null;
            let topicsOpen = false;

            function getAssetsBasePath() {
                const logo = document.querySelector('.nav-logo img');
                const src = logo ? (logo.getAttribute('src') || '') : '';
                // No estático usamos "../static/"; no Spring normalmente fica "/MKTech.png".
                return src.includes('static/') ? '../static/' : '/';
            }

            const ASSETS_BASE = getAssetsBasePath();

            function benefitImageForIndex(index) {
                const slide = benefitSlides[index];
                const title = slide ? getBenefitTitle(slide).toLowerCase() : '';

                if (title.includes('instala')) return 'beneficios/instalacao-profissional.png';
                if (title.includes('suporte')) return 'beneficios/suporte-dedicado.png';
                if (title.includes('atualiza')) return 'beneficios/atualizacoes-gratuitas.png';
                if (title.includes('formas')) return 'beneficios/formas-de-pagamento.png';
                if (title.includes('tecnologia')) return 'beneficios/tecnologia-de-ponta.png';

                return 'tranca-inteligente.png';
            }

            function getBenefitText(slideEl) {
                const p = slideEl.querySelector('.benefit-main p');
                return p ? p.textContent.trim() : '';
            }

            function getBenefitDetailText(slideEl) {
                const title = getBenefitTitle(slideEl).toLowerCase();

                if (title.includes('instala')) {
                    return 'Instalação limpa e organizada, com configuração completa, testes e orientação de uso. Tudo fica pronto para você começar a usar no mesmo dia, com acabamento de alto padrão.';
                }

                if (title.includes('suporte')) {
                    return 'Suporte rápido via WhatsApp, com diagnóstico e acompanhamento pós-instalação. Se precisar, agendamos ajustes e visitas técnicas para manter tudo funcionando perfeito.';
                }

                if (title.includes('atualiza')) {
                    return 'Seu sistema evolui com novas automações e melhorias de segurança. Fazemos ajustes finos e atualizações para você aproveitar mais recursos sem complicação.';
                }

                if (title.includes('formas')) {
                    return 'Opções flexíveis para caber no seu orçamento, com parcelamento e condições que facilitam a decisão. Você escolhe o melhor caminho sem abrir mão de qualidade.';
                }

                if (title.includes('tecnologia')) {
                    return 'Trabalhamos com dispositivos confiáveis, compatíveis com Alexa, Google e Siri, e integrações entre marcas. Mais estabilidade, performance e garantia para o seu projeto.';
                }

                return getBenefitText(slideEl);
            }

            function getBenefitIconMarkup(slideEl) {
                const iconSvg = slideEl.querySelector('.benefit-main .card-icon svg');
                return iconSvg ? iconSvg.outerHTML : '';
            }

            const benefitDetails = benefitSlides.map((slide, idx) => ({
                title: getBenefitTitle(slide),
                text: getBenefitDetailText(slide),
                image: benefitImageForIndex(idx),
                icon: getBenefitIconMarkup(slide)
            }));

            function updateBenefitsCarousel(instant = false) {
                const target = benefitSlides[currentIndex];
                if (!target) return;

                if (instant) benefitsTrack.style.transition = 'none';
                const offset = -target.offsetLeft;
                benefitsTrack.style.transform = `translateX(${offset}px)`;
                if (instant) {
                    requestAnimationFrame(() => {
                        benefitsTrack.style.transition = '';
                    });
                }
            }

            function goToBenefit(index, instant = false) {
                currentIndex = (index + benefitSlides.length) % benefitSlides.length;
                updateBenefitsCarousel(instant);
                if (topicsOpen) {
                    openTopicsForCurrent();
                }
            }

            function getBenefitTitle(slideEl) {
                const title = slideEl.querySelector('.benefit-card h3');
                return title ? title.textContent.trim() : '';
            }

            function buildTopicsLists() {
                const titles = benefitSlides.map(getBenefitTitle);
                benefitSlides.forEach((slide, slideIndex) => {
                    const list = slide.querySelector('.benefit-topic-list');
                    if (!list) return;

                    list.innerHTML = '';
                    titles.forEach((t, idx) => {
                        const btn = document.createElement('button');
                        btn.type = 'button';
                        btn.className = 'benefit-topic' + (idx === currentIndex ? ' active' : '');
                        btn.textContent = t || `Benefício ${idx + 1}`;
                        btn.dataset.index = String(idx);
                        list.appendChild(btn);
                    });
                });
            }

            function closeAllTopics() {
                benefitSlides.forEach(slide => {
                    const card = slide.querySelector('.benefit-card');
                    if (card) card.classList.remove('topics-open');

                    const panel = slide.querySelector('.benefit-panel');
                    if (panel instanceof HTMLElement) {
                        panel.hidden = true;
                        const img = panel.querySelector('.benefit-detail-media img');
                        if (img) img.removeAttribute('src');
                        const icon = panel.querySelector('.benefit-detail-icon');
                        if (icon) icon.innerHTML = '';
                    }
                });
            }

            function syncActiveTopicButtons() {
                benefitSlides.forEach(slide => {
                    slide.querySelectorAll('.benefit-topic').forEach(btn => {
                        const idx = Number(btn.dataset.index);
                        btn.classList.toggle('active', idx === currentIndex);
                    });
                });
            }

            function renderBenefitDetail(slideEl, detailIndex) {
                const panel = slideEl.querySelector('.benefit-panel');
                if (!(panel instanceof HTMLElement)) return;

                const data = benefitDetails[detailIndex];
                if (!data) return;

                const heading = panel.querySelector('.benefit-topic-heading');
                const text = panel.querySelector('.benefit-topic-text');
                const img = panel.querySelector('.benefit-detail-media img');
                const icon = panel.querySelector('.benefit-detail-icon');

                if (heading) heading.textContent = data.title;
                if (text) text.textContent = data.text;
                if (img) {
                    img.alt = data.title;
                    img.src = encodeURI(ASSETS_BASE + data.image);
                }

                if (icon) {
                    icon.innerHTML = data.icon || '';
                }

                panel.hidden = false;
            }

            function openTopicsForCurrent() {
                closeAllTopics();
                const slide = benefitSlides[currentIndex];
                if (!slide) return;
                const card = slide.querySelector('.benefit-card');
                if (!card) return;
                card.classList.add('topics-open');
                syncActiveTopicButtons();
                renderBenefitDetail(slide, currentIndex);
            }

            function stopBenefitsAutoplay() {
                if (autoPlayId) {
                    clearInterval(autoPlayId);
                    autoPlayId = null;
                }
            }

            function startBenefitsAutoplay() {
                stopBenefitsAutoplay();
                autoPlayId = setInterval(() => goToBenefit(currentIndex + 1), 3000);
            }

            function scheduleBenefitsResume() {
                if (resumeTimeoutId) clearTimeout(resumeTimeoutId);
                resumeTimeoutId = setTimeout(() => {
                    startBenefitsAutoplay();
                }, 2000);
            }

            benefitsCarousel.addEventListener('mouseenter', () => {
                stopBenefitsAutoplay();
                if (resumeTimeoutId) {
                    clearTimeout(resumeTimeoutId);
                    resumeTimeoutId = null;
                }
                topicsOpen = true;
                openTopicsForCurrent();
            });

            benefitsCarousel.addEventListener('mouseleave', () => {
                topicsOpen = false;
                closeAllTopics();
                scheduleBenefitsResume();
            });

            benefitsCarousel.addEventListener('click', (event) => {
                const target = event.target;
                if (!(target instanceof HTMLElement)) return;
                const btn = target.closest('.benefit-topic');
                if (!btn) return;
                const idx = Number(btn.dataset.index);
                if (Number.isNaN(idx)) return;
                goToBenefit(idx);
            });

            // Suporte a toque/mobile: tocar no card abre/fecha o painel de tópicos.
            benefitsCarousel.addEventListener('click', (event) => {
                const target = event.target;
                if (!(target instanceof HTMLElement)) return;

                if (target.closest('.benefit-topic')) return;

                const card = target.closest('.benefit-card');
                if (!card) return;

                topicsOpen = !topicsOpen;
                if (topicsOpen) {
                    stopBenefitsAutoplay();
                    openTopicsForCurrent();
                } else {
                    closeAllTopics();
                    scheduleBenefitsResume();
                }
            });

            window.addEventListener('resize', () => updateBenefitsCarousel(true), { passive: true });

            // Ajuste inicial
            updateBenefitsCarousel(true);
            buildTopicsLists();
            startBenefitsAutoplay();
        }

        // ========================
        // LOG INICIALIZAÇÃO
        // ========================
        console.log('%c🏠 MKTech Landing Page', 'color: #9333ea; font-size: 16px; font-weight: bold;');
        console.log('%cCarregado com sucesso!', 'color: #f59e0b; font-size: 12px;');

    })();
