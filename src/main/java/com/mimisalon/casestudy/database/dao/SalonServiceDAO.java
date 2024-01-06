package com.mimisalon.casestudy.database.dao;

import com.mimisalon.casestudy.database.entity.SalonService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;



public interface SalonServiceDAO extends JpaRepository<SalonService, Long> {


}
