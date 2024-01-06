package com.mimisalon.casestudy.form;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateBookingFormBean {

    private Integer id;
    private Integer service_id; // Updated to match the Booking entity
    private Date date;
    private String status;
    private Integer employee_id;

}