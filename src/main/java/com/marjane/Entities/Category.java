package com.marjane.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "CIN", nullable = false)
    private ProxyAdmin admin;


    @OneToMany(mappedBy = "category") // Means mapping by the corresponding column in Subcategory entity
    private List<SubCategory> subCategories = new ArrayList<>();


}