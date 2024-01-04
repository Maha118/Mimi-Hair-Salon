package com.mimisalon.casestudy.form;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateBookingFormBean {

    private Integer id;
    private String customerName;
    private String service_id; // Updated to match the Booking entity
    private Date date;
    private String status;


}