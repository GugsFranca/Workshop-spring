package com.devsuperior.curso.repositories;

import com.devsuperior.curso.entities.Category;
import com.devsuperior.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
