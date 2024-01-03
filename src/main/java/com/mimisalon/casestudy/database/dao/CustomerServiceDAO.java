package com.mimisalon.casestudy.database.dao;

import com.mimisalon.casestudy.service.CustomerService;
import org.hibernate.service.Service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;



public interface CustomerServiceDAO extends JpaRepository<CustomerService, Long> {

    Optional<CustomerService> findById(Integer id);

    List<CustomerService> findByName(String name);

    // Add your custom queries here using the @Query annotation
    @Query("SELECT cs FROM CustomerService cs WHERE cs.price <= :maxPrice")
    List<CustomerService> findByMaxPrice(double maxPrice);

    @Query("SELECT cs FROM CustomerService cs WHERE cs.description LIKE %:keyword%")
    List<CustomerService> findByDescriptionContaining(String keyword);
}
