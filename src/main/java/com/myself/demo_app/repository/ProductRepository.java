package com.myself.demo_app.repository;

import com.myself.demo_app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Predicate;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByIdAndIsActiveTrue(Long id);
}
