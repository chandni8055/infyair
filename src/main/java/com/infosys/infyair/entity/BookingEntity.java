package com.infosys.infyair.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp bookingTime;
    private Integer numberOfSeat;
    private String pnr;
}
