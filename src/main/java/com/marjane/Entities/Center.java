package com.example.marjane.Entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private ProxyAdmin admin;

    // Getter and setter methods
}