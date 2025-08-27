package com.cleiversoares.cscommerce.repositories;

import com.cleiversoares.cscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
