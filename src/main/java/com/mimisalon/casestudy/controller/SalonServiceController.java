package com.mimisalon.casestudy.controller;


import com.mimisalon.casestudy.database.dao.SalonServiceDAO;
import com.mimisalon.casestudy.database.entity.Employee;
import com.mimisalon.casestudy.database.entity.SalonService;
import com.mimisalon.casestudy.form.CreateEmployeeFormBean;
import com.mimisalon.casestudy.form.CreateSalonServiceFormBean;
import com.mimisalon.casestudy.service.EmployeeService;
import com.mimisalon.casestudy.service.SalonServiceService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class SalonServiceController {

    @Autowired
    private SalonServiceService salonServiceService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SalonServiceDAO salonServiceDAO;

    @GetMapping("/booking/service")
    public ModelAndView selectService(Model model) {
        ModelAndView modelAndView = new ModelAndView("bookings/service");
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

    @GetMapping("/salonservice/create")
    public ModelAndView createSalonService() {
        ModelAndView response = new ModelAndView("salonservice/create");

        log.debug("In create salonservice with no args - log.debug");
        log.info("In create salonservice with no Args");
        return response;
    }
    @GetMapping("/salonservice/createSubmit")
    public ModelAndView createSalonServiceSubmit(@Valid CreateSalonServiceFormBean form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("######################### In create salonservice submit - has errors #########################");
            ModelAndView response = new ModelAndView("salonservice/create");

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("######################### In create salonservice submit - no error found #########################");

        SalonService salonService = salonServiceService.createOrUpdateSalonService(form);


        // the view name can either be a jsp file name or a redirect to another controller method
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/salonservice/create/" + salonService.getId() + "?success=Service Saved Successfully");

        return response;
    }


}
