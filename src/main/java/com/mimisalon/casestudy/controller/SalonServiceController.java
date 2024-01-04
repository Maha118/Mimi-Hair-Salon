package com.mimisalon.casestudy.controller;

import com.mimisalon.casestudy.database.entity.SalonService;
import com.mimisalon.casestudy.form.CreateSalonServiceFormBean;
import com.mimisalon.casestudy.service.SalonServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/service")
public class SalonServiceController {
    private final SalonServiceService salonServiceService;

    @Autowired
    public SalonServiceController(SalonServiceService salonServiceService) {
        this.salonServiceService = salonServiceService;
    }

    @GetMapping("/edit/{serviceId}")
    public ModelAndView editService(@PathVariable Integer serviceId, @RequestParam(required = false) String success) {
        ModelAndView response = new ModelAndView("service/edit");

        Optional<SalonService> salonServiceOptional = salonServiceService.getServiceById(serviceId);

        if (success != null) {
            response.addObject("success", success);
        }


        CreateSalonServiceFormBean form = new CreateSalonServiceFormBean();

        if (salonServiceOptional.isPresent()) {
            SalonService salonService = salonServiceOptional.get();
            form.setId(salonService.getId());
            form.setName(salonService.getName());
            form.setDescription(salonService.getDescription());
            form.setPrice(salonService.getPrice());
            response.addObject("form", form);
        } else {
            response.setViewName("redirect:/service/error");
            return response;
        }

        return response;
    }
}
