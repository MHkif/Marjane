package com.example.marjane.Entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
public class ProxyAdmin {

    @Id
    @Column(name = "CIN", length = 255)
    private String cin;

    @ManyToOne
    @JoinColumn(name = "superAdmin_id", referencedColumnName = "CIN", nullable = false)
    private SuperAdmin superAdmin;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "firstName", length = 255, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 255, nullable = false)
    private String lastName;

    // Getter and setter methods
}