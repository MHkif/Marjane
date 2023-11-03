package com.example.marjane.Entities;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subCat_id", nullable = false)
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "cin", nullable = false)
    private ProxyAdmin admin;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    // Getter and setter methods
}
