package com.mimisalon.casestudy.service;
import com.mimisalon.casestudy.database.dao.BookingDAO;
import com.mimisalon.casestudy.database.entity.Booking;
import com.mimisalon.casestudy.form.CreateBookingFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookingService {

    private final BookingDAO bookingDAO;

    @Autowired
    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public Booking createOrUpdateBooking(CreateBookingFormBean form) {
        log.debug("customerName: " + form.getCustomerName());
        log.info("service_id: " + form.getService_id());
        log.info("date: " + form.getDate());
        log.info("status: " + form.getStatus());

        // Create a Booking entity and populate it with form data
        Booking booking = new Booking();
        booking.setCustomerName(form.getCustomerName());
        booking.setService_id(form.getService_id());
        booking.setDate(form.getDate());
        booking.setStatus(form.getStatus());
        // Add more fields as needed

        // Save the booking using your BookingDAO
        return bookingDAO.save(booking);
    }
    public Booking getBookingById(Long id) {
        return bookingDAO.findById(id).orElse(null);
    }
    public List<Booking> getBookingsByCustomerName(String customerName) {
        return bookingDAO.findByCustomerName(customerName);
    }
}