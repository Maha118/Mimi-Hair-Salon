package com.mimisalon.casestudy.service;
import com.mimisalon.casestudy.database.dao.BookingDAO;
import com.mimisalon.casestudy.database.dao.EmployeeDAO;
import com.mimisalon.casestudy.database.dao.SalonServiceDAO;
import com.mimisalon.casestudy.database.dao.UserDAO;
import com.mimisalon.casestudy.database.entity.Booking;
import com.mimisalon.casestudy.database.entity.Employee;
import com.mimisalon.casestudy.database.entity.SalonService;
import com.mimisalon.casestudy.database.entity.User;
import com.mimisalon.casestudy.form.CreateBookingFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class BookingService {

    @Autowired
    private BookingDAO bookingDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private SalonServiceDAO salonServiceDAO;

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    private UserService userService; // UserService to fetch User entities

    @Autowired
    private SalonServiceService salonServiceService; // ServiceService to fetch Service entities

    @Autowired
    private EmployeeService employeeService; // EmployeeService to fetch Employee entities

    public Booking createOrUpdateBooking(CreateBookingFormBean form) {
        log.debug("user_id: " + form.getUser_id());
        log.info("service_id: " + form.getService_id());
        log.info("appointment_time: " + form.getAppointment_time());
        log.info("employee_id: " + form.getEmployee_id());

        // Fetching the actual entities
        User user = userDAO.findById(form.getUser_id()).orElse(null);
        SalonService service = salonServiceDAO.findById(form.getService_id());
        Employee employee = employeeDao.findById(form.getEmployee_id()).orElse(null);

        // Create a Booking entity and populate it with the fetched entities
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setService(service);
        booking.setAppointmentTime(form.getAppointment_time());
        booking.setEmployee(employee);

        // Save the booking using your BookingDAO
        return bookingDAO.save(booking);
    }

    public Booking getBookingById(Long id) {
        return bookingDAO.findById(id).orElse(null);
    }

    public List<Booking> findByUserId(Integer user_id) {
        // Assuming you have a method in BookingDAO to find bookings by name
        return bookingDAO.findByUserId(user_id);
    }
    public Optional<Booking> findById(Integer id) {
        // Assuming you have a method in BookingDAO to find bookings by name
        return bookingDAO.findById(id);
    }

}