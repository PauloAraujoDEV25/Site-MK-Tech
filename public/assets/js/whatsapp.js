(function() {
    'use strict';

    const phoneNumber = '5534996568351';

    function createUrl(message) {
        return `https://wa.me/${phoneNumber}?text=${encodeURIComponent(message)}`;
    }

    function applyPhoneMask(input) {
        const digits = input.value.replace(/\D/g, '').slice(0, 11);
        input.value = digits
            .replace(/^(\d{2})(\d)/, '($1) $2')
            .replace(/(\d{5})(\d)/, '$1-$2');
    }

    document.querySelectorAll('[data-phone-mask]').forEach((input) => {
        input.addEventListener('input', () => applyPhoneMask(input));
    });

    window.MKTechWhatsApp = { createUrl };
})();
