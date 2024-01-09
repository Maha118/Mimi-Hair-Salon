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
    public SalonService getsalonservicebyId(long id){
        return salonServiceDAO.findById(id).orElse(null);
    }

    public SalonService createOrUpdateSalonService(CreateSalonServiceFormBean form) {
        log.debug("SalonService ID: " + form.getId());
        log.debug("Name: " + form.getName());
        log.debug("imageUrl: " + form.getImage_url());
        log.info("Price: " + form.getPrice());

        SalonService service;

        // If the form ID is not null, it means we are editing an existing SalonService
        if (form.getId() != null) {
           List<SalonService> existingSalonService = getAllServiceServices();
            if (existingSalonService.size()>0) {
                service = existingSalonService.get(0);
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

    public SalonService findById(Integer id) {
        return salonServiceDAO.findById(id);
    }


    /*public SalonService findByServiceId(Integer serviceId) {
        return salonServiceDAO.findById(serviceId);
    }*/
}