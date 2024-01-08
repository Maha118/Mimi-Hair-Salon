package com.mimisalon.casestudy.controller;


import com.mimisalon.casestudy.database.dao.SalonServiceDAO;
import com.mimisalon.casestudy.database.entity.Employee;
import com.mimisalon.casestudy.database.entity.SalonService;
import com.mimisalon.casestudy.service.EmployeeService;
import com.mimisalon.casestudy.service.SalonServiceService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/booking/service")
public class SalonServiceController {

    @Autowired
    private SalonServiceService salonServiceService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SalonServiceDAO salonServiceDAO;

    @GetMapping
    public ModelAndView selectService(Model model) {
        ModelAndView modelAndView = new ModelAndView("booking/service");
        List<SalonService> services = salonServiceService.getAllServices();
        List<Employee> employees = employeeService.findAll();
        modelAndView.addObject("services", services);
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @PostMapping("/serviceSubmitting")
    public String prepareBooking(
            @RequestParam(value = "selectedServices", required = false) Long[] selectedServices,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        if (selectedServices != null && selectedServices.length > 0) {
            // Pass the selected service IDs to the booking creation page
            // Here, we convert the array of service IDs to a comma-separated string
            String selectedServiceIds = Arrays.stream(selectedServices)
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));

            // Set the 'selectedServices' session attribute
            session.setAttribute("selectedServices", selectedServiceIds);

            return "redirect:/booking/create";
        } else {
            // Handle the case where no services were selected
            // You can add an error message or redirect to a different page
            redirectAttributes.addFlashAttribute("error", "Please select at least one service.");
            return "redirect:/services/booking/error";
        }
    }
}
