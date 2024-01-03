package com.mimisalon.casestudy.controller;


import com.mimisalon.casestudy.database.dao.CustomerServiceDAO;
import com.mimisalon.casestudy.form.CreateCustomerServiceFormBean;
import com.mimisalon.casestudy.service.CustomServiceService;
import com.mimisalon.casestudy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/service")
public class CustomerServiceController {


    private final CustomServiceService serviceService;

    @Autowired
    public CustomerServiceController(CustomServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/edit/{serviceId}")
    public ModelAndView editService(@PathVariable Integer serviceId, @RequestParam(required = false) String success) {
        ModelAndView response = new ModelAndView("service/edit");

        Optional<CustomerService> customerServiceOptional = serviceService.getServiceById(serviceId);

        if (success != null) {
            response.addObject("success", success);
        }

        CreateCustomerServiceFormBean form = new CreateCustomerServiceFormBean();

        if (customerServiceOptional.isPresent()) {
            CustomerService customerService = customerServiceOptional.get();
            form.setId(customerService.getId());
            form.setName(customerService.getName());
            form.setDescription(customerService.getDescription());
            form.setPrice(customerService.getPrice());
            response.addObject("form", form);
        } else {
            response.setViewName("redirect:/service/error");
            return response;
        }

        return response;
    }
}
