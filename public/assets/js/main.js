(function() {
    'use strict';

// TEMA DARK / LIGHT
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

  // MENU HAMBURGER
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

  // NAVBAR SCROLL EFFECT
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

  // SCROLL REVEAL (animações ao scroll)
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

  // ACTIVE NAV LINK (scroll spy)
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

  // SMOOTH SCROLL
  window.scrollTo = function (selector) {
    const target = document.querySelector(selector);
    if (target) {
      const offset = 80; // altura da navbar
      const top = target.getBoundingClientRect().top + window.pageYOffset - offset;
      window.scroll({ top, behavior: 'smooth' });
    }
  };

  // Links âncora
  document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
      const href = this.getAttribute('href');
      if (href !== '#' && document.querySelector(href)) {
        e.preventDefault();
        scrollTo(href);
      }
    });
  });

  // FAQ - acordeão
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

  // TOAST NOTIFICATIONS
  function showToast(message, type = 'info') {
    // Remover toast anterior
    const existing = document.querySelector('.toast');
    if (existing) existing.remove();

    const toast = document.createElement('div');
    toast.className = 'toast';
    toast.classList.add(`toast-${type}`);
    toast.textContent = (type === 'success' ? '✅ ' : type === 'error' ? '❌ ' : 'ℹ️ ') + message;
    document.body.appendChild(toast);

    setTimeout(() => {
      toast.classList.add('is-hiding');
      setTimeout(() => toast.remove(), 300);
    }, 4000);
  }

  window.MKTech = window.MKTech || {};
  window.MKTech.showToast = showToast;

  // CARROSSEL DE DEPOIMENTOS
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

  // CARROSSEL DE FRASES DOS BENEFÍCIOS
  const benefitsPhrase = document.getElementById('benefitsPhrase');
  const benefitsPhraseDots = Array.from(document.querySelectorAll('.benefits-phrase-dot'));

  if (benefitsPhrase && benefitsPhraseDots.length > 0) {
    const phrases = [
      'Imagine você acordando não com um alarme estridente, mas com as cortinas se abrindo suavemente e a luz do quarto simulando o nascer do sol, preparando seu corpo para o dia de forma natural.',
      'Imagine entrar na cozinha com as mãos ocupadas pelas compras e a luz se acender automaticamente, iluminando seu caminho sem que você precise procurar por um interruptor.',
      'Imagine a segurança de receber uma notificação em tempo real se houver qualquer movimento inesperado ou se uma porta for aberta enquanto você está viajando, podendo visualizar as câmeras de onde estiver.'
    ];
    const reduceMotion = window.matchMedia('(prefers-reduced-motion: reduce)').matches;
    let currentPhrase = 0;
    let wordTimer = null;
    let phraseTimer = null;
    let transitionTimer = null;

    function clearBenefitsTimers() {
      window.clearInterval(wordTimer);
      window.clearTimeout(phraseTimer);
      window.clearTimeout(transitionTimer);
    }

    function updateBenefitsDots(index) {
      benefitsPhraseDots.forEach((dot, dotIndex) => {
        const active = dotIndex === index;
        dot.classList.toggle('active', active);
        dot.setAttribute('aria-pressed', String(active));
      });
    }

    function showPhrase(index) {
      clearBenefitsTimers();
      currentPhrase = (index + phrases.length) % phrases.length;
      updateBenefitsDots(currentPhrase);

      const words = phrases[currentPhrase].split(' ');
      benefitsPhrase.replaceChildren();

      words.forEach((word) => {
        const wordElement = document.createElement('span');
        wordElement.className = 'benefits-word';
        wordElement.textContent = word;
        benefitsPhrase.appendChild(wordElement);
        benefitsPhrase.appendChild(document.createTextNode(' '));
      });

      const wordElements = Array.from(benefitsPhrase.querySelectorAll('.benefits-word'));
      if (reduceMotion) {
        wordElements.forEach((word) => word.classList.add('visible'));
        phraseTimer = window.setTimeout(() => showPhrase(currentPhrase + 1), 6500);
        return;
      }

      let wordIndex = 0;
      wordTimer = window.setInterval(() => {
        wordElements[wordIndex]?.classList.add('visible');
        wordIndex += 1;

        if (wordIndex >= wordElements.length) {
          window.clearInterval(wordTimer);
          phraseTimer = window.setTimeout(() => {
            benefitsPhrase.classList.add('is-leaving');
            transitionTimer = window.setTimeout(() => {
              benefitsPhrase.classList.remove('is-leaving');
              showPhrase(currentPhrase + 1);
            }, 450);
          }, 4000);
        }
      }, 85);
    }

    benefitsPhraseDots.forEach((dot) => {
      dot.addEventListener('click', () => showPhrase(Number(dot.dataset.phraseIndex)));
    });

    showPhrase(0);
  }


})();
