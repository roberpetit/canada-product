package com.crud.productdemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ProductX {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String email;
    private Long count;
    private Integer discountCode;

    public ProductX() {
    }

    public ProductX(String email, Long count, Integer discountCode) {
        this.id = generateUniqueId();
        this.email = email;
        this.count = count;
        this.discountCode = discountCode;
    }

    private String generateUniqueId() {
        return String.valueOf(System.currentTimeMillis()).substring(3, 12);
    }
}
