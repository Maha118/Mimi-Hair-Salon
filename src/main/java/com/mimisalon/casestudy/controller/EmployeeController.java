package com.mimisalon.casestudy.controller;


import com.mimisalon.casestudy.database.dao.EmployeeDAO;

import com.mimisalon.casestudy.database.entity.Employee;
import com.mimisalon.casestudy.database.entity.User;
import com.mimisalon.casestudy.form.CreateEmployeeFormBean;
import com.mimisalon.casestudy.Security.AuthenticatedUserService;
import com.mimisalon.casestudy.service.EmployeeService;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeService employeeeService;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;


    @GetMapping("/employee/search")
    public ModelAndView search(@RequestParam(required = false) String firstNameSearch,
                               @RequestParam(required = false) String lastNameSearch) {
        ModelAndView response = new ModelAndView("employee/search");

        log.debug("in the employee search controller method : first name = " + firstNameSearch + " last name = " + lastNameSearch);

        if (!StringUtils.isEmpty(firstNameSearch) || !StringUtils.isEmpty(lastNameSearch)) {

            response.addObject("firstNameSearch", firstNameSearch);
            response.addObject("lastNameSearch", lastNameSearch);

            if (!StringUtils.isEmpty(firstNameSearch)) {
                firstNameSearch = "%" + firstNameSearch + "%";
            }

            if (!StringUtils.isEmpty(lastNameSearch)) {
                lastNameSearch = "%" + lastNameSearch + "%";
            }

            // we only want to do this code if the user has entered either a first name or a last name
            List<Employee> employees = employeeDAO.findByFirstNameandLastName(firstNameSearch, lastNameSearch);

            response.addObject("employeeVar", employees);


            for (Employee employee : employees){
                log.debug("employee: id = " + employee.getId() + " last name = " + employee.getLastName());
            }
        }

        return response;
    }
    @GetMapping("/employee/edit/{employeeId}")
    public ModelAndView editEmployee(@PathVariable int employeeId, @RequestParam(required = false) String success) {
        log.info("######################### In /employee/edit #########################");
        ModelAndView response = new ModelAndView("employee/create");

        Optional<Employee> employeeOptional = employeeDAO.findById(employeeId);

        if (!StringUtils.isEmpty(success)) {
            response.addObject("success", success);
        }

        CreateEmployeeFormBean form = new CreateEmployeeFormBean();

        employeeOptional.ifPresent(employee -> {
            form.setId(employee.getId());
            form.setFirstName(employee.getFirstName());
            form.setLastName(employee.getLastName());
            form.setPhone(employee.getPhone());
            form.setSpeciality(employee.getSpeciality());
            form.setImageUrl(employee.getImageUrl());
        });

        if (!employeeOptional.isPresent()) {
            log.warn("Employee with id " + employeeId + " was not found");
        }

        response.addObject("form", form);

        return response;
    }

    @GetMapping("/employee/create")
    public ModelAndView createEmployee() {
        ModelAndView response = new ModelAndView("employee/create");

        log.debug("In create customer with no args - log.debug");
        log.info("In create employee with no Args");
        return response;
    }
    @GetMapping("/employee/createSubmit")
    public ModelAndView createEmployeeSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("######################### In create customer submit - has errors #########################");
            ModelAndView response = new ModelAndView("employee/create");

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("######################### In create customer submit - no error found #########################");

        Employee c = employeeeService.createEmployee(form);

        // the view name can either be a jsp file name or a redirect to another controller method
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/employee/edit/" + c.getId() + "?success=Employee Saved Successfully");

        return response;
    }

    @GetMapping("/employee/myEmployee")
    public void myEmployees() {
        log.info("######################### In my employees #########################");

        // 1) Use the authenticated user service to find the logged in user
        User user = authenticatedUserService.loadCurrentUser();

        // 2) Create a DAO method that will find by userId
        // 3) use the authenticated user id to find a list of all customers created by this user
        List<Employee> employees = employeeDAO.findByUserId(user.getId());

        // 4) loop over the employees created and log.debug the employee id and employee last name
        for (Employee employee : employees) {
            log.debug("employee: id = " + employee.getId() + " last name = " + employee.getLastName());
        }

    }

    @RequestMapping("/employee/detail")
    public ModelAndView detail(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("employee/detail");

        Optional<Employee> employeeOptional = employeeDAO.findById(id);

        if (!employeeOptional.isPresent()) {
            log.warn("Employee with id " + id + " was not found");
            // In a real application, you might redirect to a 404 here because the employee was not found
            response.setViewName("redirect:/error/404");
            return response;
        }

        Employee employee = employeeOptional.get();
        response.addObject("employee", employee);

        return response;
    }

    @GetMapping("/employee/fileupload")
    public ModelAndView fileUpload(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("employee/fileupload");

        Optional<Employee> employeeOptional = employeeDAO.findById(id);

        if (!employeeOptional.isPresent()) {
            log.warn("Employee with id " + id + " was not found");
            // In a real application, you might handle this case accordingly (e.g., redirect to an error page)
        } else {
            Employee employee = employeeOptional.get();
            response.addObject("employee", employee);
        }

        log.info(" In fileupload with no Args");
        return response;
    }


    @PostMapping("/employee/fileUploadSubmit")
    public ModelAndView fileUploadSubmit(@RequestParam("file") MultipartFile file,
                                         @RequestParam Integer id) {
        ModelAndView response = new ModelAndView("redirect:/employee/detail?id=" + id);

        log.info("Filename = " + file.getOriginalFilename());
        log.info("Size     = " + file.getSize());
        log.info("Type     = " + file.getContentType());

        // Get the file and save it somewhere
        File f = new File("./src/main/webapp/pub/images/" + file.getOriginalFilename());
        try (OutputStream outputStream = new FileOutputStream(f.getAbsolutePath())) {
            IOUtils.copy(file.getInputStream(), outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Check if employee exists
        Optional<Employee> employeeOptional = employeeDAO.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setImageUrl("/pub/images/" + file.getOriginalFilename());
            employeeDAO.save(employee);
        } else {
            log.warn("Employee with id " + id + " was not found");
            // Handle the case where the employee is not found (e.g., redirect to an error page)
        }

        return response;
    }

   /* @GetMapping("/employee/createSubmit")
    public ModelAndView createEmployeeSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("employee/create");

        log.info("firstname:" + form.getFirstName());
        log.info("lastname:" + form.getLastName());
        log.info("phone:" + form.getPhone());
        log.info("speciality:" + form.getSpeciality());

        Employee employee = new Employee();

        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setPhone(form.getPhone());
        employee.setSpeciality(form.getSpeciality());


        //  customerDAO.save(customer);
        employeeDAO.save(employee);

        log.info(" In create customer with  Args");
        return response;*/
    }

