(function() {
    'use strict';

    const form = document.getElementById('contactForm');
    const serviceSelect = document.getElementById('packageLevel');
    const nameInput = document.getElementById('name');

    function showToast(message, type) {
        if (window.MKTech && typeof window.MKTech.showToast === 'function') {
            window.MKTech.showToast(message, type);
        }
    }

    function selectService(serviceName) {
        if (serviceSelect) serviceSelect.value = serviceName;

        const contactSection = document.getElementById('contato');
        if (contactSection) {
            contactSection.scrollIntoView({ behavior: 'smooth', block: 'start' });
        }

        if (nameInput) nameInput.focus();
    }

    document.querySelectorAll('[data-service]').forEach((button) => {
        button.addEventListener('click', () => selectService(button.dataset.service));
    });

    if (!form) return;

    form.addEventListener('submit', (event) => {
        event.preventDefault();

        const name = nameInput ? nameInput.value.trim() : '';
        const packageLevel = serviceSelect ? serviceSelect.value : '';

        if (name.length < 2) {
            showToast('Por favor, insira um nome válido!', 'error');
            return;
        }

        if (!packageLevel) {
            showToast('Por favor, selecione um serviço!', 'error');
            return;
        }

        const message = `Olá, meu nome é ${name}.\nServiço de interesse: ${packageLevel}.`;
        window.open(window.MKTechWhatsApp.createUrl(message), '_blank');

        form.style.display = 'none';
        const successMessage = document.getElementById('formSuccess');
        if (successMessage) successMessage.style.display = 'block';
        showToast('Abrimos o WhatsApp com sua mensagem.', 'success');
    });
})();
