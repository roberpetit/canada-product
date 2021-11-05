package com.crud.productdemo.repository;

import com.crud.productdemo.entity.ProductX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductXRepository extends JpaRepository<ProductX, Integer> {
    Optional<ProductX> findByEmail(String email);
    Boolean existsByDiscountCode(Integer discountCode);
}
