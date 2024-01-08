document.addEventListener('DOMContentLoaded', function () {
    var dropdownButton = document.getElementById('dropdownMenuButton');
    var dropdownMenu = dropdownButton.nextElementSibling;

    dropdownButton.addEventListener('click', function (event) {
        var isExpanded = dropdownButton.getAttribute('aria-expanded') === 'true';
        dropdownButton.setAttribute('aria-expanded', !isExpanded);
        dropdownMenu.classList.toggle('show');
    });

    // Close the dropdown if clicked outside
    document.addEventListener('click', function (event) {
        if (!dropdownButton.contains(event.target) && !dropdownMenu.contains(event.target)) {
            dropdownButton.setAttribute('aria-expanded', 'false');
            dropdownMenu.classList.remove('show');
        }
    });
});
