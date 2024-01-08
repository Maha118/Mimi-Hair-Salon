package com.mimisalon.casestudy.service;


import com.mimisalon.casestudy.database.dao.SalonServiceDAO;

import com.mimisalon.casestudy.database.entity.SalonService;
import com.mimisalon.casestudy.form.CreateSalonServiceFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SalonServiceService {

    private final SalonServiceDAO salonServiceDAO;

    @Autowired
    public SalonServiceService(SalonServiceDAO salonServiceDAO) {
        this.salonServiceDAO = salonServiceDAO;
    }

    public List<SalonService> getAllServiceServices() {
        return salonServiceDAO.findAll();
    }

    public Optional<SalonService> getAllServiceServicesById(Integer id) {
        return salonServiceDAO.findById(id);
    }

    public SalonService createOrUpdateSalonService(CreateSalonServiceFormBean form) {
        log.debug("SalonService ID: " + form.getId());
        log.debug("Name: " + form.getName());
        log.debug("imageUrl: " + form.getImage_url());
        log.info("Price: " + form.getPrice());

        SalonService service;

        // If the form ID is not null, it means we are editing an existing SalonService
        if (form.getId() != null) {
            Optional<SalonService> existingSalonService = getAllServiceServicesById(form.getId());
            if (existingSalonService.isPresent()) {
                service = existingSalonService.get();
            } else {
                // Handle the case where the existing SalonService was not found
                throw new IllegalArgumentException("SalonService with ID " + form.getId() + " not found.");
            }
        } else {
            service = new SalonService();
        }

        // Set the properties from the form
        service.setName(form.getName());
        service.setImageUrl(form.getImage_url());
        service.setPrice(form.getPrice());

        // Save or update the SalonService
        return salonServiceDAO.save(service);
    }


    public void deleteSalonService(Long id) {
        salonServiceDAO.deleteById(id);
    }
    public List<SalonService> findAll() {
        return salonServiceDAO.findAll();
    }
    public List<SalonService> getAllServices() {
        return salonServiceDAO.findAll();
    }

    public Optional<SalonService> findById(Integer id) {
        return salonServiceDAO.findById(id);
    }

    public Optional<SalonService> findByServiceId(Integer serviceId) {
        return salonServiceDAO.findByServiceId(serviceId);
    }
}