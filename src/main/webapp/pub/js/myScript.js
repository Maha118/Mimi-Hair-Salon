   document.getElementById("serviceForm").addEventListener("submit", function (event) {
            event.preventDefault(); // Prevent the default form submission
            const selectedService = document.getElementById("service").value;
            if (selectedService) {
                // Redirect to the booking page with the selected service
                window.location.href = "/booking?service=" + selectedService;
            }
        });
