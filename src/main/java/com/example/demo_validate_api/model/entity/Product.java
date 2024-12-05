package com.example.demo_validate_api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer proId;
    @Column(name = "product_name",length = 100,nullable = false)
    private String proName;
    @Column(name = "producer",length = 100,nullable = false)
    private String producer;
    @Column(name = "year_making",nullable = false)
    private Integer yearMaking;
    @Column(name = "epxire_date")
    private Date expireDate;
    @Column(name = "price")
    private Double price;
    @Column(name = "status")
    private Boolean status;
}
