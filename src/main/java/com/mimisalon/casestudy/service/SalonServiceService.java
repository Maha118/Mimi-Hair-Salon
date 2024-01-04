package com.mimisalon.casestudy.service;


import com.mimisalon.casestudy.database.dao.SalonServiceDAO;
import com.mimisalon.casestudy.database.entity.SalonService;
import com.mimisalon.casestudy.form.CreateSalonServiceFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SalonServiceService {
    private final SalonServiceDAO salonServiceDAO;

    @Autowired
    public SalonServiceService(SalonServiceDAO salonServiceDAO) {
        this.salonServiceDAO = salonServiceDAO;
    }

    public Optional<SalonService> getServiceById(Integer id) {return salonServiceDAO.findById(id);

    }

    public SalonService createOrUpdateService(CreateSalonServiceFormBean form) {
        log.debug("id: " + form.getId());
        log.debug("name: " + form.getName());
        log.info("description: " + form.getDescription());
        log.info("price: " + form.getPrice());

        Optional<SalonService> salonServiceOptional = salonServiceDAO.findById(form.getId());
        SalonService salonService = salonServiceOptional.orElseGet(SalonService::new);

        salonService.setName(form.getName());
        salonService.setDescription(form.getDescription());
        salonService.setPrice(form.getPrice());

        return salonServiceDAO.save(salonService);
    }
}