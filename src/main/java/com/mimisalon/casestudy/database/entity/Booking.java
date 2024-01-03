package com.mimisalon.casestudy.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "service")
    private String service;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;
}
