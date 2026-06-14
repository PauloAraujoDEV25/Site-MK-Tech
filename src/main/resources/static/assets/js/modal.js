(function() {
    'use strict';

    document.querySelectorAll('[data-modal-open]').forEach((trigger) => {
        trigger.addEventListener('click', () => {
            const modal = document.getElementById(trigger.dataset.modalOpen);
            if (modal) modal.removeAttribute('hidden');
        });
    });

    document.querySelectorAll('[data-modal-close]').forEach((trigger) => {
        trigger.addEventListener('click', () => {
            const modal = trigger.closest('[role="dialog"]');
            if (modal) modal.setAttribute('hidden', '');
        });
    });
})();
