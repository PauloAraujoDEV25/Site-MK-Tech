/**
 * MK Tech - Landing Page
 * Arquivo principal de JavaScript
 * Controla interações com modal, formulário e validações
 */

// ====================================
// SELEÇÃO DE ELEMENTOS
// ====================================
const modal = document.getElementById('contactModal');
const span = document.getElementsByClassName('close')[0];
const contactBtns = document.querySelectorAll('.contact-btn');
const contactForm = document.getElementById('contactForm');
const alertBox = document.getElementById('alertBox');
const phoneInput = document.getElementById('phone');
const submitBtn = document.querySelector('.submit-btn');

// ====================================
// FUNÇÕES DE MODAL
// ====================================

/**
 * Abre o modal de contato
 * @param {string} packageLevel - Nível do pacote selecionado
 */
function openContactModal(packageLevel) {
    document.getElementById('packageLevel').value = packageLevel;
    modal.style.display = 'block';
    document.body.style.overflow = 'hidden';
}

/**
 * Fecha o modal de contato
 */
function closeContactModal() {
    modal.style.display = 'none';
    document.body.style.overflow = 'auto';
    contactForm.reset();
}

// ====================================
// EVENT LISTENERS - MODAL
// ====================================

// Abrir modal ao clicar em botões de contato
contactBtns.forEach(btn => {
    btn.addEventListener('click', function(e) {
        e.preventDefault();
        const packageLevel = this.getAttribute('data-package');
        openContactModal(packageLevel);
    });
});

// Fechar modal ao clicar no X
span.addEventListener('click', closeContactModal);

// Fechar modal ao clicar fora dele
window.addEventListener('click', function(event) {
    if (event.target === modal) {
        closeContactModal();
    }
});

// Fechar modal ao pressionar ESC
document.addEventListener('keydown', function(event) {
    if (event.key === 'Escape' && modal.style.display === 'block') {
        closeContactModal();
    }
});

// ====================================
// VALIDAÇÃO DE FORMULÁRIO
// ====================================

/**
 * Valida os dados do formulário
 * @returns {boolean} true se válido, false caso contrário
 */
function validateForm() {
    const name = document.getElementById('name').value.trim();
    const phone = document.getElementById('phone').value.trim();
    const packageLevel = document.getElementById('packageLevel').value;

    if (!name) {
        showAlert('Por favor, insira seu nome!', 'error');
        return false;
    }

    if (name.length < 3) {
        showAlert('Nome deve ter pelo menos 3 caracteres!', 'error');
        return false;
    }

    if (!phone) {
        showAlert('Por favor, insira seu WhatsApp!', 'error');
        return false;
    }

    // Validar telefone (deve ter pelo menos 10 dígitos)
    const phoneDigits = phone.replace(/\D/g, '');
    if (phoneDigits.length < 10) {
        showAlert('Telefone inválido! Insira um número com DDD.', 'error');
        return false;
    }

    if (!packageLevel) {
        showAlert('Por favor, selecione um pacote!', 'error');
        return false;
    }

    return true;
}

// ====================================
// SUBMISSÃO DE FORMULÁRIO
// ====================================

/**
 * Envia o formulário de contato
 */
contactForm.addEventListener('submit', async function(e) {
    e.preventDefault();

    // Validar formulário
    if (!validateForm()) {
        return;
    }

    // Desabilitar botão durante o envio
    submitBtn.disabled = true;
    submitBtn.classList.add('loading');
    submitBtn.innerHTML = '⏳ Enviando...';

    const formData = {
        name: document.getElementById('name').value.trim(),
        phone: document.getElementById('phone').value.trim(),
        packageLevel: document.getElementById('packageLevel').value
    };

    try {
        const response = await fetch('/api/contact', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        });

        const result = await response.json();

        if (response.ok && result.success) {
            showAlert('✅ ' + result.message, 'success');
            contactForm.reset();
            
            // Fechar modal após 2 segundos
            setTimeout(() => {
                closeContactModal();
                submitBtn.disabled = false;
                submitBtn.classList.remove('loading');
                submitBtn.innerHTML = '✅ Enviar e Receber Contato';
            }, 2000);
        } else {
            showAlert('❌ ' + (result.message || 'Erro ao enviar mensagem'), 'error');
            submitBtn.disabled = false;
            submitBtn.classList.remove('loading');
            submitBtn.innerHTML = '✅ Enviar e Receber Contato';
        }
    } catch (error) {
        console.error('Erro:', error);
        showAlert('❌ Erro ao enviar mensagem. Tente novamente mais tarde.', 'error');
        submitBtn.disabled = false;
        submitBtn.classList.remove('loading');
        submitBtn.innerHTML = '✅ Enviar e Receber Contato';
    }
});

// ====================================
// EXIBIÇÃO DE ALERTAS
// ====================================

/**
 * Mostra uma mensagem de alerta
 * @param {string} message - Mensagem a exibir
 * @param {string} type - Tipo do alerta ('success' ou 'error')
 */
function showAlert(message, type) {
    alertBox.textContent = message;
    alertBox.className = 'alert alert-' + type;
    alertBox.style.display = 'block';

    // Auto-ocultar após 5 segundos
    setTimeout(() => {
        if (alertBox.style.display === 'block') {
            alertBox.style.display = 'none';
        }
    }, 5000);
}

// ====================================
// MÁSCARA DE TELEFONE
// ====================================

/**
 * Aplica máscara de telefone no campo de entrada
 * Formato: (XX) XXXXX-XXXX
 */
if (phoneInput) {
    phoneInput.addEventListener('input', function(e) {
        let value = e.target.value.replace(/\D/g, '');
        
        // Limitar a 11 dígitos
        if (value.length > 11) {
            value = value.slice(0, 11);
        }

        // Aplicar máscara conforme o usuário digita
        if (value.length > 6) {
            value = value.replace(/^(\d{2})(\d{5})(\d{0,4}).*/, '($1) $2-$3');
        } else if (value.length > 2) {
            value = value.replace(/^(\d{2})(\d{0,5})/, '($1) $2');
        } else if (value.length > 0) {
            value = value.replace(/^(\d*)/, '($1');
        }

        e.target.value = value;
    });

    // Ao sair do campo, completar a máscara se necessário
    phoneInput.addEventListener('blur', function(e) {
        const digits = e.target.value.replace(/\D/g, '');
        if (digits.length > 0 && digits.length < 10) {
            showAlert('Por favor, insira um número de telefone válido com DDD', 'error');
        }
    });
}

// ====================================
// SCROLL SUAVE PARA SEÇÕES
// ====================================

/**
 * Adiciona comportamento de scroll suave para links âncora
 */
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        const href = this.getAttribute('href');
        if (href !== '#' && document.querySelector(href)) {
            e.preventDefault();
            const target = document.querySelector(href);
            target.scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            });
        }
    });
});

// ====================================
// TRACKING E ANALYTICS
// ====================================

/**
 * Log de ações do usuário (opcional)
 * Pode ser integrado com Google Analytics, Segment, etc.
 */
function trackEvent(eventName, eventData = {}) {
    console.log(`[Event] ${eventName}`, eventData);
    
    // Exemplo de integração com Google Analytics
    // if (typeof gtag !== 'undefined') {
    //     gtag('event', eventName, eventData);
    // }
}

// Rastrear aberturas de modal
contactBtns.forEach(btn => {
    btn.addEventListener('click', function() {
        const packageLevel = this.getAttribute('data-package');
        trackEvent('open_contact_modal', { package: packageLevel });
    });
});

// Rastrear submissão bem-sucedida
const originalShowAlert = showAlert;
window.showAlert = function(message, type) {
    if (type === 'success') {
        trackEvent('contact_form_submitted', { status: 'success' });
    } else {
        trackEvent('contact_form_error', { message: message });
    }
    originalShowAlert(message, type);
};

// ====================================
// INICIALIZAÇÃO
// ====================================

/**
 * Inicializa componentes da página
 */
function init() {
    console.log('MK Tech Landing Page - Inicializado');
    
    // Verificar se todos os elementos críticos existem
    if (!modal || !contactForm || !alertBox) {
        console.error('Elementos críticos do formulário não encontrados!');
    }
}

// Executar inicialização quando o DOM estiver pronto
if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', init);
} else {
    init();
}
