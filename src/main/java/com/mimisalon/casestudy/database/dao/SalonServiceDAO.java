package com.mimisalon.casestudy.database.dao;

import com.mimisalon.casestudy.database.entity.SalonService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface SalonServiceDAO extends JpaRepository<SalonService, Long> {
    Optional<SalonService> findById(Integer id);

    List<SalonService> findByName(String name);
    List<SalonService> findAll();

    // Corrected query assuming the entity is named 'Service' and has a 'price' field
    @Query("SELECT s FROM Service s WHERE s.price <= :maxPrice")
    List<SalonService> findByMaxPrice(double maxPrice);

   Optional<SalonService> findByServiceId(Integer serviceId);
}
