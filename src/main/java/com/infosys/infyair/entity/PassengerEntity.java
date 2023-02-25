package com.infosys.infyair.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passenger")
public class PassengerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private char gender;
    private String mobile;
}
