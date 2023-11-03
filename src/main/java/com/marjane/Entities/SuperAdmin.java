package com.example.marjane.Entities;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
public class SuperAdmin {

    @Id
    @Column(name = "CIN", length = 255)
    private String cin;

    @Column(name = "firstName", length = 255, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 255, nullable = false)
    private String lastName;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "password", length = 255, nullable = false)
    private String password;


    // Getter and setter methods
}