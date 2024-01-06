package com.mimisalon.casestudy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class SlashController {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");
        return response;
    }

    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView response = new ModelAndView("about");
        return response;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView response = new ModelAndView("home");
        return response;
    }

    @GetMapping("/contactus")
    public ModelAndView contactus() {
        ModelAndView response = new ModelAndView("contactus");
        return response;
    }

}
