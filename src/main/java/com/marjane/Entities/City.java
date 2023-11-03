package com.example.marjane.Entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "country", length = 255, columnDefinition = "DEFAULT 'Morocco'")
    private String country;

    // Getter and setter methods
}