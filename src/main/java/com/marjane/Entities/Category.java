package com.example.marjane.Entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "cin", nullable = false)
    private ProxyAdmin admin;

    // Getter and setter methods
}