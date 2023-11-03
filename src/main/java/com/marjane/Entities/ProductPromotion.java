package com.example.marjane.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class ProductPromotion implements Promotion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "cin", nullable = false)
    private ProxyAdmin admin;

    @Column(name = "percentage", precision = 10, scale = 2)
    private BigDecimal percentage;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "start_at")
    private Date startAt;

    @Column(name = "end_at")
    private Date endAt;

    // Getter and setter methods
}

