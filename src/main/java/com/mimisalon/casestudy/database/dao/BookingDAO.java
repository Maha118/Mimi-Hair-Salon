package com.mimisalon.casestudy.database.dao;

import com.mimisalon.casestudy.database.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional; // Import Optional

public interface BookingDAO extends JpaRepository<Booking, Long> {

    List<Booking> findById(Integer id); // Use Optional<Booking> here

    List<Booking> findByCustomerName(String customerName);

    // Add your custom queries here using the @Query annotation
    @Query("SELECT b FROM Booking b WHERE b.status = :status")
    List<Booking> findByStatus(String status);

    @Query("SELECT b FROM Booking b WHERE b.service.id = :serviceId")
    List<Booking> findByServiceId(Long serviceId);
}
