package com.devsuperior.curso.repositories;

import com.devsuperior.curso.entities.Category;
import com.devsuperior.curso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
