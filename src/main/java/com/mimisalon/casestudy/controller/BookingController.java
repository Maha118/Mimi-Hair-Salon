package com.mimisalon.casestudy.controller;

import com.mimisalon.casestudy.database.dao.EmployeeDAO;
import com.mimisalon.casestudy.database.dao.SalonServiceDAO;
import com.mimisalon.casestudy.database.dao.UserDAO;
import com.mimisalon.casestudy.database.entity.Booking;
import com.mimisalon.casestudy.database.entity.Employee;
import com.mimisalon.casestudy.database.entity.SalonService;
import com.mimisalon.casestudy.database.entity.User;
import com.mimisalon.casestudy.form.CreateBookingFormBean;
import com.mimisalon.casestudy.service.BookingService;
import com.mimisalon.casestudy.service.EmployeeService;
import com.mimisalon.casestudy.service.SalonServiceService;
import com.mimisalon.casestudy.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class BookingController {

    @Autowired
    private SalonServiceDAO salonServiceDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeService employeeService;

    private final BookingService bookingService;
    private final UserService userService; // Assuming you have a service for Users
    private final SalonServiceService salonServiceService; // Assuming you have a service for Services


    @Autowired
    public BookingController(BookingService bookingService, UserService userService, SalonServiceService salonServiceService, EmployeeService employeeService) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.salonServiceService = salonServiceService;
        this.employeeService = employeeService;
    }

    @GetMapping("/booking/create")
    public ModelAndView createBookingForm(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("bookings/create");

        // Retrieve the selectedServices session attribute as a String
        String selectedServiceIds = (String) session.getAttribute("selectedServices");

        // Parse the comma-separated string into a List of Longs
        List<Long> selectedServices = new ArrayList<>();
        if (selectedServiceIds != null && !selectedServiceIds.isEmpty()) {
            String[] idsArray = selectedServiceIds.split(",");
            for (String id : idsArray) {
                selectedServices.add(Long.parseLong(id));
            }
        }

        // Add other data as needed
        List<User> users = userService.findAll();
        modelAndView.addObject("users", users);

        List<Employee> employees = employeeService.findAll(); // Use employeeService here
        modelAndView.addObject("employees", employees);

        modelAndView.addObject("selectedServices", selectedServices);
        modelAndView.addObject("form", new CreateBookingFormBean()); // Form backing object

        return modelAndView;
    }



    @GetMapping("/edit/{bookingId}")
    public ModelAndView editBookingForm(@PathVariable Long bookingId) {
        // Fetch the booking details by bookingId from your data source
        // Populate the form with the booking details
        Booking booking = bookingService.getBookingById(bookingId);

        ModelAndView modelAndView = new ModelAndView("bookings/service");
        List<SalonService> services = salonServiceService.getAllServices();
        modelAndView.addObject("services", services);
        modelAndView.addObject("form", new CreateBookingFormBean()); // Form backing object
        modelAndView.addObject("editBooking", booking); // Add the booking to be edited
        return modelAndView;
    }

    @GetMapping("/booking/search")
    public ModelAndView searchBookingById(@RequestParam(required = false) Long bookingId) {
        ModelAndView response = new ModelAndView("bookings/search");

        if (bookingId != null) {
            Booking booking = bookingService.getBookingById(bookingId);
            if (booking != null) {
                response.addObject("booking", booking);
            } else {
                response.addObject("notFound", true);
            }
        }

        return response;
    }




        @GetMapping("/detail")
        public String showBookingDetails(@RequestParam("id") Long bookingId, Model model) {
            // Fetch the booking details based on the 'id' parameter
            Booking booking = bookingService.getBookingById(bookingId);

            if (booking != null) {
                // If the booking is found, add it to the model for rendering in the JSP
                model.addAttribute("booking", booking);
                return "bookings/detail"; // Use the correct JSP page name
            } else {
                // Handle the case where the booking is not found (e.g., show an error page)
                return "error"; // You can create an error JSP page
            }
        }


    /*@GetMapping("/booking/detail")
    public ModelAndView bookingDetail(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("bookings/detail");

        Optional<Booking> bookingOptional = bookingService.findById(id);

        if (!bookingOptional.isPresent()) {
            log.warn("Booking with id " + id + " was not found");
            response.setViewName("redirect:/error/404");
            return response;
        }

        response.addObject("booking", bookingOptional.get());
        return response;
    }*/
    // Populate the form bean from the Booking entity
    private void populateFormBean(CreateBookingFormBean form, Booking booking) {
        form.setId(booking.getId());
        form.setUser_id(booking.getUser().getId());
        form.setService_id(booking.getService().getId());
        form.setAppointment_time(booking.getAppointmentTime());
        form.setEmployee_id(booking.getEmployee().getId());
        // ... other fields ...
    }

    // Add lists of users, services, and employees to the model
    private void addDropdownAttributes(ModelAndView modelAndView) {
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("services", salonServiceService.findAll());
        modelAndView.addObject("employees", employeeService.findAll());
    }
    @GetMapping("/booking/createSubmit")
    public ModelAndView createBookingSubmit(@ModelAttribute("form") CreateBookingFormBean form, BindingResult result) {
        ModelAndView response = new ModelAndView();

        if (result.hasErrors()) {
            // Handle errors
            response.setViewName("bookings/create");
            addDropdownAttributes(response); // Re-populate dropdowns
            return response;
        }

        Booking booking = convertFormToEntity(form);

        bookingService.createOrUpdateBooking(form); // Adjusted to use your existing method

        response.addObject("successMessage", "Booking created successfully!");
        response.setViewName("redirect:/booking/success"); // or any other success view

        return response;
    }

    private Booking convertFormToEntity(CreateBookingFormBean form) {
        Booking booking = new Booking();
        // Populate booking entity with form data
        booking.setUser(userService.findById(form.getUser_id()).orElse(null));
        booking.setService(salonServiceService.findById(form.getService_id()));
        booking.setEmployee(employeeService.findById(form.getEmployee_id()).orElse(null));
        booking.setAppointmentTime(form.getAppointment_time());
        // Set other fields as necessary
        return booking;
    }
    @PostMapping("/complete")
    public String completeBooking(@ModelAttribute("bookingForm") CreateBookingFormBean bookingForm,
                                  @SessionAttribute("selectedServices") List<SalonService> selectedServices,
                                  RedirectAttributes redirectAttributes) {
        // Access the selected service details from the session (selectedServices)
        // Access the appointment time and other booking information from bookingForm

        // Save the booking details in your database
        // You can use the selectedServices, appointment time, and other booking information

        // After completing the booking, you can display a success message or redirect to a confirmation page
        return "booking/confirmation";
    }

}
