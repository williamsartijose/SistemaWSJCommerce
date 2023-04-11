package com.wsjsistema.wsjdscommerce.repositories;

import com.wsjsistema.wsjdscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
