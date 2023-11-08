package com.marjane.Entities;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subCat_id", nullable = false)
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "CIN", nullable = false)
    private ProxyAdmin admin;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @OneToOne(mappedBy = "product") // Define the OneToOne relationship
    private Stock stock;
}
