package com.mimisalon.casestudy.database.dao;

import com.mimisalon.casestudy.database.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional; // Import Optional

public interface BookingDAO extends JpaRepository<Booking, Long> {


}
