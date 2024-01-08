package com.mimisalon.casestudy.service;


import com.mimisalon.casestudy.Security.AuthenticatedUserService;
import com.mimisalon.casestudy.database.dao.EmployeeDAO;
import com.mimisalon.casestudy.database.entity.Employee;
import com.mimisalon.casestudy.form.CreateEmployeeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;


    public Optional<Employee> findEmployeeById(Integer id) {
        return employeeDao.findById(id);
    }


    public Employee createEmployee(CreateEmployeeFormBean form) {
        log.debug("id: " + form.getId());
        log.debug("firstName: " + form.getFirstName());
        log.info("lastName: " + form.getLastName());
        log.info("phone: " + form.getPhone());
        log.info("speciality: " + form.getSpeciality());

        Optional<Employee> employeeOptional = employeeDao.findById(form.getId());
        Employee employee;

        if (employeeOptional.isPresent()) {
            employee = employeeOptional.get();
        } else {
            // If the employee is not found, create a new one
            employee = new Employee();
        }

        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setPhone(form.getPhone());
        employee.setSpeciality(form.getSpeciality());
        employee.setImageUrl(form.getImageUrl());

        return employeeDao.save(employee);
    }


    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
    public Optional<Employee> findById(Integer id) {
        return employeeDao.findById(id);
    }

    public Optional<Employee> findByEmployeeId(Integer employeeId) {
        return employeeDao.findByEmployeeId(employeeId);
    }
}


